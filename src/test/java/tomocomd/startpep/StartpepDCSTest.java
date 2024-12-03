package tomocomd.startpep;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tomocomd.configuration.dcs.AHeadEntity;
import tomocomd.exceptions.AExOpDCSException;
import tomocomd.md.HeaderValidator;
import tomocomd.peptides.dcs.PDType;
import tomocomd.peptides.dcs.startpep.StartpepDCS;
import tomocomd.utils.Constants;

class StartpepDCSTest {

  StartpepDCS startpepDCS;

  @BeforeEach
  void setUp() {
    startpepDCS = new StartpepDCS();
  }

  @Test
  void getType() {
    assertEquals(PDType.STARTPEP, startpepDCS.getType());
  }

  @Test
  void randomHeading() {
    AHeadEntity aHeadEntity = startpepDCS.randomHeading();
    assertNotNull(aHeadEntity);
    HeaderValidator.validateHeader(aHeadEntity.toString());
  }

  @Test
  void getSetDim() {
    assertEquals(29920, startpepDCS.getSetDim());
  }

  @Test
  void getValues4ParamClass() {
    assertEquals(1, startpepDCS.getValues4Param(Constants.CLASAGGOPECONST).length);
  }

  @Test
  void getValues4ParamAgg() {
    assertEquals(136, startpepDCS.getValues4Param(Constants.AGGOPECONST).length);
  }

  @Test
  void getValues4ParamGroups() {
    assertEquals(11, startpepDCS.getValues4Param(Constants.GROUPSCONST).length);
  }

  @Test
  void getValues4ParamProp() {
    assertEquals(20, startpepDCS.getValues4Param(Constants.PROPCONST).length);
  }

  @Test
  void getValues4ParamException() {
    assertThrows(AExOpDCSException.class, () -> startpepDCS.getValues4Param("Constants.PROPCONST"));
  }
}
