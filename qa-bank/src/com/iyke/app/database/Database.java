package com.iyke.app.database;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.iyke.app.beans.Questions;

public class Database {
    
    private Map<UUID, Questions> questionsBank = new HashMap<>();


    public Database(){
        createQuestionsAndpopulateBank();
    }

    public void createQuestionsAndpopulateBank(){
        Map<Character, String> optionsQ1 = new HashMap<>();
        optionsQ1.put('A', "Peter Obi");
        optionsQ1.put('B', "Bola Tinubu");
        optionsQ1.put('C', "Atiku Waziri");
        Questions q1 = new Questions("Who is the Peoples President of Nigeria?", 'A', 0, optionsQ1, 0);

        Map<Character, String> optionsQ2 = new HashMap<>();
        optionsQ2.put('A', "Apc");
        optionsQ2.put('B', "Labour");
        optionsQ2.put('C', "Pdp");
        Questions q2 = new Questions("Which Political Party does the Peoples President of Nigeria belong to?", 'B', 0, optionsQ2, 0);

        Map<Character, String> optionsQ3 = new HashMap<>();
        optionsQ3.put('A', "South East");
        optionsQ3.put('B', "South West");
        optionsQ3.put('C', "North East");
        Questions q3 = new Questions("Who Geo-political zone is the Peoples President of Nigeria from", 'A', 0, optionsQ3, 0);

        Map<Character, String> optionsQ4 = new HashMap<>();
        optionsQ4.put('A', "Peter Mbah");
        optionsQ4.put('B', "Nyesom Wike");
        optionsQ4.put('C', "Alex Oti");
        Questions q4 = new Questions("Who is the Governor of Abia State?", 'C', 0, optionsQ4, 0);

        Map<Character, String> optionsQ5 = new HashMap<>();
        optionsQ5.put('A', "Arise");
        optionsQ5.put('B', "Channel");
        optionsQ5.put('C', "Nta");
        Questions q5 = new Questions("What is the best News Channel in Nigeria?", 'A', 0, optionsQ5, 0);

        //Adding to questionsBank DB
        questionsBank.put(q1.getQuestionId(), q1);
        questionsBank.put(q2.getQuestionId(), q2);
        questionsBank.put(q3.getQuestionId(), q3);
        questionsBank.put(q4.getQuestionId(), q4);
        questionsBank.put(q5.getQuestionId(), q5);
    }

    //Getter and Setters
    public Map<UUID, Questions> getQuestionsBank() {
        return questionsBank;
    }

    public void setQuestionsBank(Map<UUID, Questions> questionsBank) {
        this.questionsBank = questionsBank;
    }

    

}
