package com.iyke.app.beans;

import java.util.Map;
import java.util.UUID;

public class Questions {

    private UUID questionId;
    private String question;
    private char answer;
    private double mark;
    private Map<Character, String> options;

    //constructor
    public Questions(String question, char answer, double mark, Map<Character, String> options) {
        this.question = question;
        this.answer = answer;
        this.mark = mark;
        this.options = options;
        this.questionId = UUID.randomUUID();
    }

    //Getter and Setter
    public UUID getQuestionId() {
        return questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
    
    public char getAnswer() {
        return answer;
    }

    public void setAnswer(char answer) {
        this.answer = answer;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public Map<Character, String> getOptions() {
        return options;
    }

    public void setOptions(Map<Character, String> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "Questions [questionId=" + questionId + ", question=" + question + ", answer=" + answer + ", mark="
                + mark + ", options=" + options + ", isShown=" + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((questionId == null) ? 0 : questionId.hashCode());
        result = prime * result + ((question == null) ? 0 : question.hashCode());
        result = prime * result + answer;
        long temp;
        temp = Double.doubleToLongBits(mark);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((options == null) ? 0 : options.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Questions other = (Questions) obj;
        if (questionId == null) {
            if (other.questionId != null)
                return false;
        } else if (!questionId.equals(other.questionId))
            return false;
        if (question == null) {
            if (other.question != null)
                return false;
        } else if (!question.equals(other.question))
            return false;
        if (answer != other.answer)
            return false;
        if (Double.doubleToLongBits(mark) != Double.doubleToLongBits(other.mark))
            return false;
        if (options == null) {
            if (other.options != null)
                return false;
        } else if (!options.equals(other.options))
            return false;
        
        return true;
    }

    

}