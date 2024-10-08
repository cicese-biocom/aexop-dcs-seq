package tomocomd;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/** Unit test for simple App. */
public class AppSeqRunTest extends TestCase {
  /**
   * Create the test case
   *
   * @param testName name of the test case
   */
  public AppSeqRunTest(String testName) {
    super(testName);
  }

  /**
   * @return the suite of tests being tested
   */
  public static Test suite() {
    return new TestSuite(AppSeqRunTest.class);
  }

  /** Rigourous Test :-) */
  public void testApp() {
    assertTrue(true);
  }
}
