package com.example.kevinrabaricalculatorapplication;

public class CalculatorModel {
    double firstNumber =0.0;
    double secondNumber =0.0;
    double result=0.0;

    boolean firstNumberset= false;
    boolean secondNumberset=false;
    boolean operatorSet=false;

    String operator= "";

    public void  setFirstNumber(double num){
        firstNumber=num;
        firstNumberset=true;

    }
    public void  setSecondNumber(double num){
        secondNumber=num;
        secondNumberset=true;

    }
    public double getResult()
    {
        computeResult();
        return result;
    }
    public void computeResult() {
        if (firstNumberset && secondNumberset && operatorSet) {

            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "/":
                    result = firstNumber / secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;

            }
        }else {
            //do nothing
        }
    }
    {

    }
    public void setOperator(String op)
    {
        operator =op;
        operatorSet =true;
    }
    public void clear()
    {
        firstNumberset=false;
        firstNumber=0.0;
        secondNumberset=false;
        secondNumber=0.0;
        operatorSet=false;
        operator="";
        result=0.0;

    }

}
