package tomocomd;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import tomocomd.configuration.subsetsearch.AexopConfig;
import tomocomd.peptides.dcs.startpep.StartpepDCS;

@Data
@Builder
@AllArgsConstructor
public class PeptidesAppConfig extends AexopConfig {

  protected void initAttributeDCSList() {

    for (String clas : List.of("AC", "GV", "TS")) {
      StartpepDCS startpepDCSClass = new StartpepDCS(clas);
      startpepDCSClass.getClassicalAggParam().getParams().put(clas, true);
      startpepDCSClass.getClassicalAggParam().getParams().put("ES", true);
      startpepDCSClass.getClassicalAggParam().getParams().put("MIC", true);
      startpepDCSClass.getClassicalAggParam().getParams().put("", true);
      aAttributeDCSList.add(startpepDCSClass);
    }
  }
}
