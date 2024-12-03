package tomocomd;

import java.io.IOException;

/** Hello world! */
public class AppSeqRun {
  public static void main(String[] args) throws IOException {
    CliApp cliApp = new CliApp(args);
    cliApp.execLunchCli();
    //    PeptidesAppConfig peptidesAppConfig = new PeptidesAppConfig();
    //    ObjectMapper objectMapper = new ObjectMapper();
    //    objectMapper.writeValue(new File("project_seq.json"), peptidesAppConfig);
    //    ObjectMapper mapper = new ObjectMapper();
    //    PeptidesAppConfig conf = mapper.readValue(Paths.get("project_seq.json").toFile(),
    // PeptidesAppConfig.class);
    //    System.out.println(conf);
  }
}
