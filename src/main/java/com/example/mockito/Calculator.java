package com.example.mockito;

public class Calculator {

    public int add(int number1, int number2){
        return number1 + number2;
    }

    public double divide(double number1, double number2){
        if(number2==0){
            throw new ArithmeticException("number can not be divide by zero");
        }
        return number1/number2;
    }
}
