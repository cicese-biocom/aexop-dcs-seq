package tomocomd.descriptors;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tomocomd.exceptions.AExOpDCSException;
import tomocomd.peptides.dcs.PDType;

class PDComputerFactoryTest {

  PDComputerFactory pdComputerFactory;

  @BeforeEach
  void setUp() {
    pdComputerFactory = new PDComputerFactory();
  }

  @Test
  void getComputer() {
    assertEquals(PDType.STARTPEP, pdComputerFactory.getComputer(PDType.STARTPEP).getType());
  }

  @Test
  void getComputerError() {
    try {
      pdComputerFactory.getComputer(PDType.STARTPEP);
    } catch (AExOpDCSException e) {
      assertEquals("Invalid PD type", e.getMessage());
    }
  }
}
