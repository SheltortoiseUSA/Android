package com.sheltortoiseusa.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private boolean isCurrentNumber = true;
    private char currentOperator = ' ';
    private Integer answer;

    private Values values;
    private TextView displayNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table);

        values = new Values();

        displayNumber = (TextView) findViewById(R.id.TextView1);
    }
    public void addZero(View view) {
        if(isCurrentNumber) {
            values.addToCurrentNumber('0');
            displayNumber.setText(values.getCurrentNumber());
        }
        else {
            values.addToNewNumber('0');
            displayNumber.setText(values.getNewNumber());
        }
    }
    public void addOne(View view) {
        if(isCurrentNumber) {
            values.addToCurrentNumber('1');
            displayNumber.setText(values.getCurrentNumber());
        }
        else {
            values.addToNewNumber('1');
            displayNumber.setText(values.getNewNumber());
        }
    }
    public void addTwo(View view) {
        if(isCurrentNumber) {
            values.addToCurrentNumber('2');
            displayNumber.setText(values.getCurrentNumber());
        }
        else {
            values.addToNewNumber('2');
            displayNumber.setText(values.getNewNumber());
        }
    }
    public void addThree(View view) {
        if(isCurrentNumber) {
            values.addToCurrentNumber('3');
            displayNumber.setText(values.getCurrentNumber());
        }
        else {
            values.addToNewNumber('3');
            displayNumber.setText(values.getNewNumber());
        }
    }
    public void addFour(View view) {
        if(isCurrentNumber) {
            values.addToCurrentNumber('4');
            displayNumber.setText(values.getCurrentNumber());
        }
        else {
            values.addToNewNumber('4');
            displayNumber.setText(values.getNewNumber());
        }
    }
    public void addFive(View view) {
        if(isCurrentNumber) {
            values.addToCurrentNumber('5');
            displayNumber.setText(values.getCurrentNumber());
        }
        else {
            values.addToNewNumber('5');
            displayNumber.setText(values.getNewNumber());
        }
    }
    public void addSix(View view) {
        if(isCurrentNumber) {
            values.addToCurrentNumber('6');
            displayNumber.setText(values.getCurrentNumber());
        }
        else {
            values.addToNewNumber('6');
            displayNumber.setText(values.getNewNumber());
        }
    }
    public void addSeven(View view) {
        if(isCurrentNumber) {
            values.addToCurrentNumber('7');
            displayNumber.setText(values.getCurrentNumber());
        }
        else {
            values.addToNewNumber('7');
            displayNumber.setText(values.getNewNumber());
        }
    }
    public void addEight(View view) {
        if(isCurrentNumber) {
            values.addToCurrentNumber('8');
            displayNumber.setText(values.getCurrentNumber());
        }
        else {
            values.addToNewNumber('8');
            displayNumber.setText(values.getNewNumber());
        }
    }
    public void addNine(View view) {
        if(isCurrentNumber) {
            values.addToCurrentNumber('9');
            displayNumber.setText(values.getCurrentNumber());
        }
        else {
            values.addToNewNumber('9');
            displayNumber.setText(values.getNewNumber());
        }
    }
    public void addition(View view) {
        if(currentOperator == ' ') {
            currentOperator = '+';
            isCurrentNumber = false;
        }
        else {
            doMath(view);
            currentOperator = '+';
        }
    }
    public void subtraction(View view) {
        if(currentOperator == ' ') {
            currentOperator = '-';
            isCurrentNumber = false;
        }
        else {
            doMath(view);
            currentOperator = '-';
        }
    }
    public void multiplication(View view) {
        if(currentOperator == ' ') {
            currentOperator = '*';
            isCurrentNumber = false;
        }
        else {
            doMath(view);
            currentOperator = '*';
        }
    }
    public void division(View view) {
        if(currentOperator == ' ') {
            currentOperator = '/';
            isCurrentNumber = false;
        }
        else {
            doMath(view);
            currentOperator = '/';
        }
    }
    public void module(View view) {
        if(currentOperator == ' ') {
            currentOperator = '%';
            isCurrentNumber = false;
        }
        else {
            doMath(view);
            currentOperator = '%';
        }
    }
    public void doMath(View view) {
        if(values.getNewNumber() == "") {
            // Do Nothing
        }
        else if(currentOperator == '+') {
            Integer currentNumber = Integer.parseInt(values.getCurrentNumber());
            Integer newNumber = Integer.parseInt(values.getNewNumber());

            answer = currentNumber += newNumber;

            displayNumber.setText(answer.toString());

            values.setCurrentNumber(answer.toString());
            values.setNewNumber("");

            currentOperator = ' ';
            isCurrentNumber = false;
        }
        else if(currentOperator == '-') {
            Integer currentNumber = Integer.parseInt(values.getCurrentNumber());
            Integer newNumber = Integer.parseInt(values.getNewNumber());

            answer = currentNumber -= newNumber;

            displayNumber.setText(answer.toString());

            values.setCurrentNumber(answer.toString());
            values.setNewNumber("");

            currentOperator = ' ';
            isCurrentNumber = false;
        }
        else if(currentOperator == '*') {
            Integer currentNumber = Integer.parseInt(values.getCurrentNumber());
            Integer newNumber = Integer.parseInt(values.getNewNumber());

            answer = currentNumber *= newNumber;

            displayNumber.setText(answer.toString());

            values.setCurrentNumber(answer.toString());
            values.setNewNumber("");

            currentOperator = ' ';
            isCurrentNumber = false;
        }
        else if(currentOperator == '/' && Integer.parseInt(values.getNewNumber()) != 0) {
            Integer currentNumber = Integer.parseInt(values.getCurrentNumber());
            Integer newNumber = Integer.parseInt(values.getNewNumber());

            answer = currentNumber /= newNumber;

            displayNumber.setText(answer.toString());

            values.setCurrentNumber(answer.toString());
            values.setNewNumber("");

            currentOperator = ' ';
            isCurrentNumber = false;
        }
        else if(currentOperator == '%' && Integer.parseInt(values.getNewNumber()) != 0) {
            Integer currentNumber = Integer.parseInt(values.getCurrentNumber());
            Integer newNumber = Integer.parseInt(values.getNewNumber());

            answer = currentNumber %= newNumber;

            displayNumber.setText(answer.toString());

            values.setCurrentNumber(answer.toString());
            values.setNewNumber("");

            currentOperator = ' ';
            isCurrentNumber = false;
        }
        else {
            displayNumber.setText("Undefined");
        }
    }
    public void resetAll(View view) {
        values.setCurrentNumber("");
        values.setNewNumber("");

        isCurrentNumber = true;
        currentOperator = ' ';
        answer = 0;

        displayNumber.setText("0");
    }
}
