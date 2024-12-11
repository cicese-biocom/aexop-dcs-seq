package tomocomd.peptides.dcs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import tomocomd.configuration.dcs.AttributeType;
import tomocomd.configuration.dcs.ComputerType;

@Getter
@AllArgsConstructor
public class PDType implements AttributeType {
  public static final AttributeType STARTPEP = new PDType(PeptideComputerType.STARTPEP, "Startpep");

  private final ComputerType computerType;
  private final String code;

  @Override
  public String toString() {
    return "PDType{" + "computerType=" + computerType + ", code='" + code + '\'' + '}';
  }
}
