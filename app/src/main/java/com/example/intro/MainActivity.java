package com.example.intro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

/**
 * A calculator in 2 orientation; A simple calculator in portrait.
 * A scientific calculator in landscape.
 */
public class MainActivity extends AppCompatActivity {

    private TextView mainTextView;
    private long number = 0;
    private long secondNumber = 0;
    private String operator = "";
    //(data structure) Key values pair for the symbols and the operations examples like phoneBook (name is key and value is the number)
    //the new key word creates the object and initialise the values in the double curly brackets.
    private Map<String, Integer> arithmeticMap = new HashMap<String, Integer>(){{
        put("+", 0);
        put("-", 1);
        put("*", 2);
        put("/", 3);
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainTextView = findViewById(R.id.solution_textview);
        mainTextView.setText(number + "");
    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.addition_button:
                initCalculation("+");
                break;
            case R.id.subtraction_button:
                initCalculation("-");
                break;
            case R.id.multiplication_button:
                initCalculation("*");
                break;
            case R.id.division_button:
                initCalculation("/");
                break;
            case R.id.one_button:
                //{
                //if(number > 0) {
                // number = Integer.parseInt( mainTextView.getText().toString() + 1);
                // }
                //else {
                // number = 1;
                // mainTextView.setText(number + "");
                // }
                // }
                concatNumber(1);
                break;

            case R.id.two_button:
                concatNumber(2);
                break;
            case R.id.three_button:
                concatNumber(3);
                break;

            case R.id.four_button:
                concatNumber(4);
                break;
            case R.id.five_button:
                concatNumber(5);
                break;
            case R.id.six_button:
                concatNumber(6);
                break;
            case R.id.seven_button:
                concatNumber(7);
                break;
            case R.id.eight_button:
                concatNumber(8);
                break;
            case R.id.nine_button:
                concatNumber(9);
                break;
            case R.id.zero_button:
                concatNumber(0);
                break;
            case R.id.equals_button:
                calculateValue();
                break;
            case R.id.cancel_button:
                number = 0;
                //secondNumber = 0;
                mainTextView.setText(R.string.clear_text);
                break;
        }
    }

    private void initCalculation(String s) {
        operator = s;
        if(!operator.isEmpty()) {
            calculateValue();
        }
        else {
            mainTextView.setText(R.string.clear_text);
            secondNumber = number;
            number = 0;
        }
        operator = s;

    }

    private void calculateValue() {
        long solution = 0;
        switch (arithmeticMap.get(operator)) {
            case 0: //addition
                solution = number + secondNumber;
                break;
            case 1: //subtraction
                solution = secondNumber - number;
                break;
            case 2: //multiplication
                solution = (secondNumber * number);
                break;
            case 3: //division
                solution = (secondNumber/number);
                break;
        }
        secondNumber = 0;
        number = 0;
        mainTextView.setText(String.valueOf(solution));

    }

    private void concatNumber(int add) {
        //string concatination
        StringBuilder sBuilder = new StringBuilder();
        //Get the current value (number which is an int variable) and append (creates one string objects and keeps on adding to the same string)
        //add the other value (add).
        //String value = sBuilder.append(number).append(add);
        String value = sBuilder.append(number).append(add).toString();
        //convert it back to long and set text.
        //number = Long.parseLong(sBuilder.toString());
        if(value.length() < 19)  {
            number = Long.parseLong(value);
        }
        else //show a message using a toast
        //static method called makeText which takes an argument context - activity is tied to the life cycle of activity
        //AppCompactctivity is a subclass of the context
        //if I want to use the application context then use this.application context
        //never forget to show()
        {
            Toast.makeText(this, "Number is too large - the maximum digits you can enter is 19 digits!", Toast.LENGTH_SHORT).show();
            mainTextView.setText(String.valueOf(number));
            //number = String.valueOf(add) + add;
        }

    }
}