package tomocomd;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;
import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tomocomd.descriptors.PDComputerFactory;
import tomocomd.peptides.dcs.PeptidesDCSFactory;
import tomocomd.peptides.dcs.PeptidesHeadFactory;
import tomocomd.subsetsearch.AexopDcs;

public class CliApp {

  private static final Logger LOGGER = LogManager.getLogger(CliApp.class);

  private final String[] cmdLine;

  public CliApp(String[] cmdLine) {
    this.cmdLine = Arrays.copyOf(cmdLine, cmdLine.length);
  }

  public void execLunchCli() {

    CommandLine cmd = getCommands();

    if (!(cmd.hasOption("p"))) {
      LOGGER.error("Project file do not defined");
      System.exit(-1);
    }

    String path = cmd.getOptionValue("p");
    PeptidesAppConfig conf = null;
    try {
      ObjectMapper mapper = new ObjectMapper();
      conf = mapper.readValue(Paths.get(path).toFile(), PeptidesAppConfig.class);
    } catch (Exception ex) {
      LOGGER.error("Problems loading project file: {}", path, ex);
      System.exit(-1);
    }

    if (cmd.hasOption("i")) {
      String confLine = conf.toString();
      LOGGER.info(confLine);
      System.exit(0);
    }

    String fastFile = "";
    if (cmd.hasOption("f")) {
      fastFile = cmd.getOptionValue("f");
    }

    File fastaTest = new File(fastFile);
    if (!fastaTest.exists()) {
      LOGGER.error("Problems loading fasta file: {}", fastFile);
      System.exit(-1);
    }

    String out = "";
    if (cmd.hasOption("c")) {
      out = cmd.getOptionValue("c");
    }

    if (out.isEmpty()) {
      LOGGER.error("Output file do not defined");
      System.exit(-1);
    }

    File outFile = new File(out);
    if (Objects.isNull(outFile.getParentFile())) {
      LOGGER.error("Wrong output file path {}", outFile.getAbsolutePath());
      System.exit(-1);
    }
    if (!outFile.getParentFile().exists()) {
      LOGGER.error("Wrong output file path {}", outFile.getAbsolutePath());
      System.exit(-1);
    }

    String target = "";
    if (cmd.hasOption("e")) {
      target = cmd.getOptionValue("e");
    }

    File targetFile = new File(target);
    if (!targetFile.exists()) {
      LOGGER.error("Target do not defined {}", targetFile.getAbsolutePath());
      System.exit(-1);
    }

    cli(conf, out, target, fastFile);
  }

  private CommandLine getCommands() {
    Options options = getOptions();

    CommandLineParser parser = new DefaultParser();
    CommandLine cmd = null;
    HelpFormatter help = new HelpFormatter();
    try {
      cmd = parser.parse(options, cmdLine);
    } catch (ParseException ex) {
      help.printHelp("cmd", options, true);
      LOGGER.error("Problems parsing command line");
      System.exit(-1);
    }

    if (cmd.hasOption("h")) {
      help.printHelp("cmd", options, true);
      System.exit(0);
    }

    if (cmd.hasOption("v")) {
      LOGGER.info("AExOp-DCS 1.0");
      System.exit(0);
    }

    return cmd;
  }

  private static Options getOptions() {
    Options options = new Options();

    options.addOption("p", "project", true, "path to project file in json format (.json)");
    options.addOption("i", "info", false, "print project configuration");
    options.addOption("f", "fastafile", true, "input, path to sdf file");
    options.addOption("c", "csvfile", true, "output, path to csv file");
    options.addOption(
        "e", "endpoint", true, "csv file with a column with the target property for sequence");
    options.addOption("d", "debug", false, "create logs folder for save application logs");

    options.addOption("h", "help", false, "Show this help and exit");
    options.addOption("v", "version", false, "show the version and exit");
    return options;
  }

  public void cli(PeptidesAppConfig conf, String outFile, String target, String sdfFile) {
    try {
      AexopDcs aexopDcs =
          new AexopDcs(
              conf,
              new File(outFile).getAbsolutePath(),
              new File(sdfFile).getAbsolutePath(),
              new File(target).getAbsolutePath(),
              new PDComputerFactory(),
              new PeptidesHeadFactory(),
              new PeptidesDCSFactory());
      aexopDcs.compute();
    } catch (Exception e) {
      LOGGER.error(e.getMessage(), e);
      System.exit(-1);
    }
  }
}
