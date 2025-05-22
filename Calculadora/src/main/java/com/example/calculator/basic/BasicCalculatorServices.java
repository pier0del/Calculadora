package main.java.com.example.calculator.basic;

import main.java.com.example.calculator.common.CalculatorException;
import main.java.com.example.calculator.common.Constants;

public class BasicCalculatorServices {
    private final Addition addition = new Addition();

    public double add(double a, double b) {
        return addition.operate(a, b);

    }

    public double subtract(double a, double b) {
        return a - b;

    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b){
        if(b == 0) {
            throw new CalculatorException(Constants.DIVISION_BY_ZERO);

        }
        return a / b;
    }

}
