package tomocomd.startpep.aggregtions;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tomocomd.peptides.dcs.startpep.aggregtions.InformationAggParam;

class InformationAggParamTest {

  InformationAggParam informationAggParam;

  @BeforeEach
  void setUp() {
    informationAggParam = new InformationAggParam();
  }

  @Test
  void setDefault() {
    assertArrayEquals(getDefaults(), informationAggParam.getValues());
  }

  @Test
  void getParamName() {
    assertEquals("Information aggregators", informationAggParam.getParamName());
  }

  @Test
  void testValidate() {
    InformationAggParam info = new InformationAggParam(informationAggParam);
    info.getParams().keySet().forEach(key -> info.setValue(key, false));
    String[] values = info.getValues();
    assertTrue(Objects.nonNull(values) && values.length == 0);
  }

  String[] getDefaults() {
    return new String[] {"TIC", "SIC"};
  }
}
