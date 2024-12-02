package tomocomd.descriptors;

import tomocomd.configuration.dcs.AttributeType;
import tomocomd.exceptions.AExOpDCSException;
import tomocomd.peptides.dcs.PDType;

public class PDComputerFactory implements AttributeComputerFactory {

  @Override
  public IAttributeComputer getComputer(AttributeType type) {
    if (type == PDType.STARTPEP) return new StartpepDescriptorExecutor();
    throw AExOpDCSException.ExceptionType.DCS_EXCEPTION.get("Invalid PD type");
  }
}
