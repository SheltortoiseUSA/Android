package com.sheltortoiseusa.calculator;

public class Values {
    private String currentNumber;
    private String newNumber;

    public Values() {
        currentNumber = "";
        newNumber = "";
    }
    public void addToCurrentNumber(char numChar) {
        currentNumber += numChar;
    }
    public void addToNewNumber(char numChar) {
        newNumber += numChar;
    }
    public void setCurrentNumber(String str) {
        currentNumber = str;
    }
    public void setNewNumber(String str) {
        newNumber = str;
    }
    public String getCurrentNumber() {
        return currentNumber;
    }
    public String getNewNumber() {
        return newNumber;
    }
}
