package com.iyke.app.util.services;

import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

import com.iyke.app.beans.Questions;
import com.iyke.app.util.Grade;
import com.iyke.app.util.Validation;

public class DisplayService {

  // Method and Implementation of displaying Questions and options,
  // prompting the user for answer, comparing answer and asigning marks and grade
  public boolean display(Map<UUID, Questions> questionsBank) {
    int count = 0;
    Scanner scan = new Scanner(System.in);
    String ans;
    double mark = 0.0;
    while (count != questionsBank.size()) { // ✅
      try {
        // Outer for-loop to loop through the Question Map to display the Question
        for (Map.Entry<UUID, Questions> q : questionsBank.entrySet()) { // ✅

          System.out.println("\n# Question: " + ++count + " - " + q.getValue().getQuestion());
          System.out.println("\nOptions\n");

          // Inner for-loop to get options that belong to the question
          for (Map.Entry<Character, String> options : q.getValue().getOptions().entrySet()) {
            System.out.println(options.getKey() + " - " + options.getValue());
          }

          // Prompt to input answer
          System.out.println("\n Enter your Answer: ");
          
          while(scan.hasNext()) {
            ans = scan.nextLine();// accept user input
            // Validating user's input
            boolean isValid = Validation.validateAnswerEntry(ans);
  
            if (isValid) {
              // converting stored answer in DB from Char to String
              String answer = String.valueOf(q.getValue().getAnswer());
              // Checking if answer is correct
              if (answer.trim().equalsIgnoreCase(ans.trim())) {
                System.out.println("Right Answer");
                // setting the mark is answer is correct
                mark += q.getValue().getMark();
  
              } else {
                System.out.println("Wrong Answer");
              }
              break;
            } else {
              System.out.println("Invalid Entry. ***Please enter A, B OR C to proceed.***");
              continue;
            }
          }

        }
        // output mark
        System.out.println("\nYour Total Score is : " + mark);
        // output calculated grade
        System.out.println("\nGrade: " + Grade.getGrade(mark));
      } catch (Exception e) {
        System.out.println("Sorry! Something went wrong on out side.");
        break;
      }
    }

    return count == questionsBank.size();
  }
}
