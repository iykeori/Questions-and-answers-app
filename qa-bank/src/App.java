import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

import com.iyke.app.beans.Questions;
import com.iyke.app.database.Database;
import com.iyke.app.util.Validation;
import com.iyke.app.util.services.DisplayService;

public class App {
  private Database db;
  private DisplayService dService;

  // Constructor
  public App() {
    db = new Database();
    dService = new DisplayService();
  }

  // Welcome method
  public void welcome() {
    Scanner scan = new Scanner(System.in);
    int next;
    while (true) {
      try {
        // welcome the user
        System.out.println("\nWelcome to Nig Political Question Bank: ");
        // user taps a key to commence the exam
        System.out.println("\n Press 1 to continue"); // expects an integer

        if (scan.hasNextInt()) { // ⚠️ should chekc for in int input
          next = scan.nextInt();
          // Run Validation
          boolean isValid = Validation.validateFirstEntry(next); // ⚠️ should validate the int input
          if (isValid) { // checking if entry is valid
            // get questions from DB
            Map<UUID, Questions> questionsBank = db.getQuestionsBank();
            if (questionsBank != null) {
              // displays questions and options prompting users for answers
              boolean isDone = dService.display(questionsBank);
              if (isDone) {
                System.out.println("Make the last statement here and break");
                break;
              }
            } else {
              System.out.println(" The question Bank is Empty");
            }
          } else {
            System.out.println("Invalid input! you must press 1 to continue");
            continue;
          }

        } else {
          System.out.println("Invalid input. Please enter a number");
          scan.nextLine();// consume the input
          continue;
        }

      } catch (Exception e) {
        System.out.println("Exception: " + e.getMessage());
        continue;
      }
    }
  }

  public static void main(String[] args) {
    App app = new App();
    app.welcome();
  }
}
