package main.java.com.example.calculator.model;

/**
 * enum que representa el modo de angulo de la calculadora
 *
 * se utiliza para indicar si las funciones trigonometricas
 * (seno, cos, y tangente) trabajan en:
 * - GRADOS
 * - RADIANES
 *
 * el valor de este enum afecta directamente a los calculos
 * realizados en el servicio de operaciones cientificas
 */
public enum ModoAngulo {
    /**
     * modo en grados (ejm: 90, 180)
     * antes de calcular, los valores se convierten en radianes
     */
    GRADOS,

    /**modo radianes ( ejm: PI/2 , PI)
     */
    RADIANES
}
