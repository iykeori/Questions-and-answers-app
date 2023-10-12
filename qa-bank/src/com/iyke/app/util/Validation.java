package com.iyke.app.util;

public class Validation {
    
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

    public static boolean validateAnswerEntry(String answer){
        answer = answer.trim();
        if(answer.isEmpty() || answer == null){
            return false;
        }
        if(answer.length() < 1 || answer.length() > 1){
            return false;
        }
        if(!answer.equalsIgnoreCase("A")){
            return false;
        }else if (!answer.equalsIgnoreCase("B")){
            return false;
        }else if (!answer.equalsIgnoreCase("C")){
            return false;  
        }
        return true;
    }
}
