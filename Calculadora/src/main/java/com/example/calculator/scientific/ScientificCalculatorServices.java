package main.java.com.example.calculator.scientific;

import main.java.com.example.calculator.common.CalculatorException;
import main.java.com.example.calculator.common.Constants;

public class ScientificCalculatorServices {
    private final SinOperation sinOp = new SinOperation();
    public double sin(double radians) {
        return sinOp.operate(radians);
    }

    public double log(double value) {
        if (value <= 0) {
            throw new CalculatorException("error: El logaritmo no tiene valor positivo");
        }
        return Math.log(value);
    }

    public double exp(double exponent) {
        return Math.exp(exponent);

    }

    public double pow(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public double pi() {
        return Constants.PI;

    }
}
