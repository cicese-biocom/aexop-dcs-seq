package tomocomd.peptides.dcs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import tomocomd.configuration.dcs.ComputerType;

@AllArgsConstructor
@Getter
public class PeptideComputerType implements ComputerType {
  public static final ComputerType STARTPEP = new PeptideComputerType("Startpep");

  private final String name;

  @Override
  public String toString() {
    return "PeptideComputerType{" + "name='" + name + '\'' + '}';
  }
}
