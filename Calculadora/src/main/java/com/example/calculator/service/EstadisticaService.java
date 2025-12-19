package main.java.com.example.calculator.service;

/**
 * servicio encargado de realizar calculos estadisticos basicos
 * sobre un conjunto de datos numericos:
 *
 * operaciones incluidas:
 * - media
 * - varianza
 * - desviacion estandar
 *
 * esta clase no valida entrada desde consola ni muestra resultados;
 * solo contiene logica matematica
 */

public class EstadisticaService {

    /**
     * calcula la media aritmetica de un conjunto de valores
     *
     * @param values array de numeros
     * @return media aritmetica o Double.NaN si el array es nulo o vacio
     */

    public double mean(double[] values) {
        //si no hay datos validos, no se puede calcular la media
        if (values == null || values.length  == 0) return Double.NaN;
        double sum = 0;
        for (double v : values) {
            sum += v;
        }
        //media = suma / numero de elementos
        return sum / values.length;
    }

    /**
     *calcula la varianza de un conjunto de valores
     *
     * formula:
     * varianza = E (xi - media)^2 / N
     *
     * @param values array de numeros
     * @return varianza o Double.NaN si el array es nulo o vacio
     */
    public double variance(double[] values) {
        //sin datos no hay varianza
        if (values == null || values.length == 0)
            return Double.NaN;

        //calculamos la media
        double m = mean(values);
        double sum = 0;

        //sumamos el cuadrado de la diferencia con la media
        for (double v : values) {
            double diff = v - m;
            sum += diff * diff;
        }

        return sum / values.length;
    }

    /**
     * calcula la desviacion estandar de un conjunto de valores
     *
     * desviacion estandar = raiz cuadrada de la varianza
     *
     * @param values array de numeros
     * @return desviacion estandar
     */
    public double stdDev(double[] values) {
        return Math.sqrt(variance(values));
    }
}
