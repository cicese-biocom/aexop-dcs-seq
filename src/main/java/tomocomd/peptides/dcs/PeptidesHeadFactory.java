package tomocomd.peptides.dcs;

import tomocomd.configuration.dcs.AHeadEntity;
import tomocomd.configuration.dcs.AttributeType;
import tomocomd.configuration.dcs.HeadFactory;
import tomocomd.peptides.dcs.startpep.StartpepHeadEntity;

public class PeptidesHeadFactory implements HeadFactory {

  @Override
  public AHeadEntity getHead(AttributeType type) {

    if (type == null) throw new IllegalArgumentException("Head type not supported: " + type);

    if (type == PDType.STARTPEP) {
      return new StartpepHeadEntity((PDType) type);
    }
    throw new IllegalArgumentException("Head type not supported: " + type);
  }
}
