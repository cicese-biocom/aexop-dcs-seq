package tomocomd.peptides.dcs;

import lombok.AllArgsConstructor;
import tomocomd.configuration.dcs.AttributeType;

@AllArgsConstructor
public enum PDType implements AttributeType {
  STARTPEP {
    @Override
    public String getName() {
      return "StartPEP";
    }

    @Override
    public String getCode() {
      return "StartPEP";
    }
  }
}
