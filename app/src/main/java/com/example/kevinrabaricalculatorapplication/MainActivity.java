package com.example.kevinrabaricalculatorapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean startNewNumber=true;
    boolean acceptingDigits= true;
    CalculatorModel calculatorModel=new CalculatorModel();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void buttonClick(android.view.View view)
    { //Which button is pressed
        Log.i("button","Button Clicked:");
        Button button =(Button) view;
        String buttonText =button.getText().toString();
        Log.i("button","button is Pressed: "+ buttonText);
        //what  was number displayed at time of button press

        TextView textview=(TextView) findViewById(R.id.numberDisplay);
        String currentNumber =textview.getText().toString();

        switch(buttonText)
        {
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "0":
            case ".":
                //Digit or .
                if(startNewNumber) {
                    if(buttonText.equals("."))
                    {
                        currentNumber="0.";
                    }else {
                        currentNumber=buttonText;
                    }
                    //currentNumber=buttonText;
                    startNewNumber=false;
                }else{
                    //Do nothing Already Contains .
                    if(buttonText.equals(".") && currentNumber.contains(".")) {
                    }else
                    {currentNumber = currentNumber + buttonText;
                    }
                }
                break;

            case "+":
            case"-":
            case "/":
            case"*":
                if (calculatorModel.firstNumberset && calculatorModel.operatorSet && !startNewNumber)
                    {
                        double secondNumber = Double.parseDouble(currentNumber);
                        calculatorModel.setSecondNumber(secondNumber);
                        String result=resultToString(calculatorModel.getResult());
                        currentNumber = result;

                    }
                double firstNumber = Double.parseDouble(currentNumber);
                calculatorModel.setFirstNumber(firstNumber);

                calculatorModel.setOperator(buttonText);
                startNewNumber =true;
                break;
            case "=":
                if(calculatorModel.firstNumberset) {

                    double secondNumber = Double.parseDouble(currentNumber);
                    calculatorModel.setSecondNumber(secondNumber);
                    String result = resultToString(calculatorModel.getResult());
                    currentNumber = result;

                    startNewNumber = true;
                }
                break;
            case"C":
                calculatorModel.clear();
                currentNumber="0.";
                startNewNumber=true;
                break;


        }

        textview.setText(currentNumber);

    }
    public String resultToString(double num)
    {
        int numInt=(int) num;
        if(numInt==num)
        {
            return Integer.toString(numInt);
        }
        else
        {
            return Double.toString(num);
        }
    }
}