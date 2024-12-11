package tomocomd.descriptors;

import tomocomd.configuration.dcs.ComputerType;
import tomocomd.exceptions.AExOpDCSException;
import tomocomd.peptides.dcs.PeptideComputerType;

public class PDComputerFactory implements AttributeComputerFactory {

  @Override
  public IAttributeComputer getComputer(ComputerType type) {
    if (type == PeptideComputerType.STARTPEP) return new StartpepDescriptorExecutor();
    throw AExOpDCSException.ExceptionType.DCS_EXCEPTION.get("Invalid PD type");
  }
}
