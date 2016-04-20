import java.io.FileWriter;
import java.io.IOException;

/**
 * Generate password combination from four digit to eight digit.
 *
 * @author 454A
 */
public class PasswordListGenerator {

  // All digit character
  private final String[] DIGIT;

  private FileWriter fileWriter;

  /**
   * Construct a PasswordListGenerator.
   *
   * @param filename The name of the target file
   * @throws IOException if failed to open the file
   */
  private PasswordListGenerator(String filename) throws IOException {
    DIGIT = new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    fileWriter = new FileWriter(filename, true);
  }

  /**
   * This is a helper uses to display the status.
   *
   * @param counter       The number of words wrote in one second
   * @param wordToDisplay The word of current process
   */
  private void printStatus(int counter, String wordToDisplay) {
    System.out.println(
        "Current word: --> " + wordToDisplay + " Speed: " + counter + "k/s");
  }

  public void run() throws Exception{
    String[] areaCode = new String[] {"647", "416", "905", "289", "514",
        "438", "613", "343", "780", "236", "778", "604", "403", "587", "581",
        "418", "800"};
    int counter = 0;
    long startTime = System.currentTimeMillis();
    long currTime;
    String currWord;

    for (String prefix : areaCode) {
      for (String a : DIGIT) {
        for (String b : DIGIT) {
          for (String c : DIGIT) {
            for (String d : DIGIT) {
              for (String e : DIGIT) {
                for (String f : DIGIT) {
                  for (String g : DIGIT) {
                    currTime = System.currentTimeMillis();
                    currWord = "\n" + prefix + a + b + c + d + e + f + g;
                    fileWriter.write(currWord);
                    counter++;

                    // Display the status for every 1000ms
                    if (currTime - startTime >= 1000) {
                      this.printStatus(counter, currWord);
                      startTime = System.currentTimeMillis();
                      counter = 0;
                    }   
                  }
                }
              }
            }
          }
        }
      }
    }
    System.out.println("=== 10 Digit Telephone Number has been finished ===");
  }
  
  /**
   * The entry-point of the PasswordListGenerator.
   *
   * @param args The array of filename string
   */
  public static void main(String[] args) throws Exception {
    new PasswordListGenerator(args[0]).run();
  }


}
