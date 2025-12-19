package main.java.com.example.calculator.service;

/**
 * clase que contiene las operaciones matematicas basicas
 * de una calculadora
 *
 * incluye las validaciones para evitar errores matematicos
 * como divisiones entre cero o raices invalidas
 *
 */
public class OperacionesBasicasService {

    /**
     * suma dos numeros
     *
     * @param a primer numero
     * @param b segundo numero
     * @return resultado de a + b
     */

    public double suma(double a, double b) {
        return a + b;
    }
    /**
     * resta dos numeros
     *
     * @param a numero del que se resta
     * @param b  numero que se resta
     * @return resultado de a-b
     */
    public double resta(double a, double b) {
        return a - b;
    }

    /**
     * multiplica dos numeros
     *
     * @param a primer numero
     * @param b segundo numero
     * @return resultado de la multiplicaciones a*b
     */

    public double multiplicacion(double a, double b) {
        return a * b;
    }

    /**
     * divide dos numeros
     *
     * @param a dividendo
     * @param b divisor
     * @return resultado de a/b
     * @throws java.lang.ArithmeticException si el divisor es 0
     */
    public double division( double a, double b) {

        //no se puede divir entre cero
        if (b == 0) {
            throw new ArithmeticException("no se puede dividir entre cero");
        }
        return a / b;
    }

    /**
     * calcula la potencia de un numero
     *
     * @param base base de la potencia
     * @param exp exponente
     * @return resultado de base elevado a exp
     * @throws ArithmeticException si la operacion es invalida
     */

    public double potencia(double base, double exp) {

        //0^0 no esta definido en las matematicas
        if (base == 0 && exp == 0) {
            throw new ArithmeticException("0^0 es una indeterminacion matematicaa");

        }

        //0 elevado a un exponente negativo no es valido
        if (base == 0 && exp < 0) {
            throw new ArithmeticException("no se puede calcular 0 elevado a un exponente negativo");
        }

        //un numero negativo elevado a un exponente fraccionario da un numero complejo
        if (base < 0 && exp % 1 != 0) {
            throw new ArithmeticException("No se puede elevar un numero negativo a un exponente fraccionario");

        }

        return Math.pow(base, exp);

    }

    /**
     * calcula la raiz cuadrada de un numero
     *
     * @param x numero del que se quiere obtener la raiz
     *
     * @return raiz cuadrada de x
     * @throws ArithmeticException si x es negativo
     */

    public double raizCuadrada(double x) {
        //la raiz cuadrada de un numero negativo no es real
        if ( x < 0) {
            throw new ArithmeticException("no se puede calcular la raiz cuadrada de un numero negativo");
        }
       return Math.sqrt(x);
    }

    /**
     * devuelve el valor absoluto de un numero
     *
     * @param x numero de entrada
     * @return valor absoluto de x
     */
    public double valorAbsoluto(double x) {
        return Math.abs(x);
    }
}