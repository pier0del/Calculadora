package main.java.com.example.calculator.model;

/**
 * clase q representa el resultado de la operacion matematica
 *
 * puede representar:
 * -un resultado correcto (valor numerico)
 * -un error (mensaje explicativo)
 *
 * esta clase permite manejar resultados y errores
 * sin lanzar excepciones hasta la ui
 * haciendo el flujo del programa mas limpio
 */

public class CalculoResultado {

    //valor numerico del resultado (solo valido si success == true)
    private final double value;

    //mensaje de resultado (puede ser OK o mensaje de error)
    private final String message;

    //indica si la operacion fue exitosa o no
    private final boolean success;

    /**
     * constructor para un resultado correcto
     *
     * @param value resultado numerico de la operacion
     */
    public CalculoResultado(double value) {
        this.value = value;
        this.message = "OK";
        this.success = true;
    }

    /**
     * constructor para resultado con error
     *
     * @param errorMessage mensaje que describe el tipo de error
     */

    public CalculoResultado(String errorMessage) {
        this.value = Double.NaN;
        this.message = errorMessage;
        this.success = false;
    }

    /**
     * devuelve el valor numerico del resultado
     *
     * @return valor calculado (Double.NaN si hubo error)
     */

    public double getValue() {
        return value;
    }

    /**
     * devuelve un mensaje asociado al resultado
     *
     * @return "OK" si fue exitoso o mensaje de error si fallo algo
     */


    public String getMessage() {
        return message;
    }
    /**
     * indice si la operacion fue exitosa
     *
     * @return true si el calculo fue correcto o false si ocurrio un error
     */
    public boolean isSuccess() {
        return success;

    }

    /**
     * representacion en texto de resultado
     * se utiliza directamente al imprimir el objeto por consola
     */

    @Override
    public String toString() {
        return success
                ? "resultado: " + value
                : "ERROR: " + message;
    }
}