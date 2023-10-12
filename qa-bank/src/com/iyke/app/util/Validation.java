package com.iyke.app.util;

public class Validation {

    //Validating first entry "1" the user for input to start app
    public static boolean validateFirstEntry(String no){
        no = no.trim();
        if(no.isEmpty() || no == null){
            return false;
        }

        if(no.length() < 1 || no.length() > 1){
            return false;
        }

        if(!no.equalsIgnoreCase("1")){
            return false;
        }

        return true;
    }

    //Validating the answer entry and making sure is either A, B, C
    public static boolean validateAnswerEntry(String answer){
        
        answer = answer.trim().toUpperCase();
        if(answer.isEmpty() || answer == null){
            return false;
        }
        
        if(answer.length() != 1){
            return false;
        }
       
        if(answer.equals("A")){
            return true;
        }else if (answer.equals("B")){
            return true;
        }else if (answer.equals("C")){
            return true;  
        }else{
            System.out.println("\n Invalid Answer!");
        }

        return true;
    }
}
