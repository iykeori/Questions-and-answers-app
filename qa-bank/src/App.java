import java.util.Map;
import java.util.Scanner;
import java.util.UUID;
import java.util.Map.Entry;

import com.iyke.app.beans.Questions;
import com.iyke.app.database.Database;
import com.iyke.app.util.Validation;

public class App {
    private Database db;

    //Constructor
    public App(){
        db = new Database();
    }

    public void welcome(){
        Scanner scan = new Scanner(System.in);
        String next;
        while(true) {
            try{
                //welcome the user
                System.out.println("\nWelcome to Nig Political Question Bank: ");
                System.out.println("\n Press 1 to continue");

                if (scan.hasNext()){
                    next = scan.nextLine();
                    //Run Validation
                    boolean isValid = Validation.validateFirstEntry(next);
                    if (isValid){
                        Map<UUID, Questions> questionsBank = db.getQuestionsBank();
                        if ( questionsBank != null){
                            display(questionsBank);
                        }else{
                            System.out.println(" The question Bank is Empty");
                        }
                    }

                }else {
                    System.out.println("Invalid input. Please enter a number");
                    scan.nextLine();// consume the input
                    continue;
                }

            } catch (Exception e) {
                System.out.println("Exception: " + e.getMessage());
                continue;
            }
            
            
            //user taps a key to commence the exam
            //the question displays
            //the user types in an alphabet representating an answer
            //the answer is validated
            //if right, congratulate user and got to the next question
            //else tell the user they got it wrong and move on the next question still

            //at the end of the exam, calculate the score and display it to the user.
            //Optionally, you can grade the user's score
          }

    }
    public void display(Map<UUID, Questions> questionsBank){
        int count = 0;
        Scanner scan = new Scanner(System.in);
        String ans;
        double mark = 0.0;
        while (count != questionsBank.size()){
            try{
                for (Map.Entry<UUID, Questions> q : questionsBank.entrySet()){
            
                    System.out.println("\n# Question: "+ ++count +" - "+ q.getValue().getQuestion());
                    System.out.println("\nOptions\n");
                    for (Map.Entry<Character, String> options : q.getValue().getOptions().entrySet()){
                        //options.getKey();
                        System.out.println(options.getKey() + " - " + options.getValue());
                    }

                    System.out.println("\n Enter your Answer: ");
                    if (scan.hasNext()){
                        ans = scan.nextLine();
                        boolean isValid = Validation.validateAnswerEntry(ans);
                        if(isValid){
                            String answer = String.valueOf(q.getValue().getAnswer());
                            if (answer.equalsIgnoreCase(ans)){
                                System.out.println("Right Answer");
                               q.getValue().setMark(5);
                               
                            }else{
                                System.out.println("Wrong Answer");
                                q.getValue().setMark(0);
                            }
                            mark = q.getValue().getMark();
                            mark += mark;
                        }else {
                                System.out.println("Invalid Entry. ***Entry A, B OR C ***");
                                continue;
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a number");
                        scan.nextLine();// consume the input
                        continue;
                    }

                }
                System.out.println("\nYour Total Score is : " + mark);
            }catch (Exception e) {
                System.out.println("Exception: " + e.getMessage());
                continue;
            }
        }
         
        
    }
    public static void main(String[] args) throws Exception {
        App app = new App();
        app.welcome();
    }
}
