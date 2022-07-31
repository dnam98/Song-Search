
public class SongSearchTests {

  public static void main(String[] args) throws Exception {
    // Run All Tests
  }

  // Data Wrangler Code Tests

  // Back End Developer Tests

  // Front End Developer Tests

  public void frontEndDeveloperTest1() {
    // Check if insert and title search is correct
    TextUITester tester = new TextUITester("i\nkeyword\nartist\n1423\ny\nt\nkeyword\nq");
    SearchBackEndInterface engine = new SearchBackEnd();
    SearchFrontEndInterface ui = new SearchFrontEnd();
    ui.run(engine);

    String output = tester.checkOutput();
    if (output.startsWith("Starting Song Search Program") && output.contains("keyword")) {
      System.out.print("Test passed");
    } else {
      System.out.println("Test failed");
    }
  }

  public void frontEndDeveloperTest2() {
    // Check if artist search is correct
    TextUITester tester = new TextUITester("i\nkeyword\nartist\n1899\ny\na\nartist\nq");
    SearchBackEndInterface engine = new SearchBackEnd();
    SearchFrontEndInterface ui = new SearchFrontEnd();
    ui.run(engine);

    String output = tester.checkOutput();
    if (output.startsWith("Starting Song Search Program") && output.contains("artist")) {
      System.out.print("Test passed");
    } else {
      System.out.println("Test failed");
    }
  }

  public void frontEndDeveloperTest3() {
    // Check if histogram works correct
    TextUITester tester =
        new TextUITester("i\nkeyword\nartist\n1998\ny\ni\nkeyword\nartist\n1998\ny\nh\nkeyword\nq");
    SearchBackEndInterface engine = new SearchBackEnd();
    SearchFrontEndInterface ui = new SearchFrontEnd();
    ui.run(engine);

    String output = tester.checkOutput();
    if (output.startsWith("Starting Song Search Program") && output.contains("**")) {
      System.out.print("Test passed");
    } else {
      System.out.println("Test failed");
    }
  }
  // Integration Manager Tests


}
