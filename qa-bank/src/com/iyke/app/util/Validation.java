package com.iyke.app.util;

public class Validation {

  // Validating first entry "1" the user for input to start app
  public static boolean validateFirstEntry(int input) {
    return input == 1;
  }

  // Validating the answer entry and making sure is either A, B, C
  public static boolean validateAnswerEntry(String answer) {

    answer = answer.trim().toUpperCase();
    if (answer.isEmpty() || answer == null) {
      return false;
    }

    if (answer.length() != 1) { // ✅
      return false;
    }

    if (answer.equals("A") || answer.equals("B") || answer.equals("C")) {
      return true;
    }

    return false;
  }

  public boolean isSomethingTrue() {
    //if anything is true, then return true before the final return
    return false;
  }
}
