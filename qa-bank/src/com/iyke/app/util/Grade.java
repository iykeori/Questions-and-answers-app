package com.iyke.app.util;

public class Grade {
    
    //Grade Method
    public static String getGrade(double mark){
        String grade = " ";
        //Checking for grade range 
        if(mark >= 0 && mark <= 49.99){
            grade = "F";
        }else if(mark >= 50 && mark <= 59.99){
            grade = "C";
        }else if(mark >= 60 && mark <= 69.99){
            grade = "B-";
        }else if(mark >= 70 && mark <= 79.99){
            grade = "B+";
        }else if(mark >= 80 && mark <= 89.99){
            grade = "A-";
        }else if(mark >= 90 && mark <= 100){
            grade = "A+";
        }else{
            return "Mark out of Standard Academic range";
        }
        return grade;
    }
}
