package tomocomd.peptides.dcs;

import tomocomd.configuration.dcs.AAttributeDCS;
import tomocomd.configuration.dcs.AttributeType;
import tomocomd.configuration.dcs.DCSFactory;
import tomocomd.peptides.dcs.startpep.StartpepDCS;

public class PeptidesDCSFactory implements DCSFactory {

  @Override
  public AAttributeDCS getDcs(AttributeType type) {
    if (type == null) throw new IllegalArgumentException("Null DCS not allowed");
    if (type == PDType.STARTPEP) {
      return new StartpepDCS();
    }
    throw new IllegalArgumentException("DCS type not supported: " + type);
  }
}
