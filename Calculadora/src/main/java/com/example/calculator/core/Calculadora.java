package main.java.com.example.calculator.core;

import main.java.com.example.calculator.model.ModoAngulo;
import main.java.com.example.calculator.service.*;

/**
 * clase principal de la logica de negocio de la calculadora
 n
 * actua como una facha:
 * - expone metodos simples para la UI (suma, seno, media, etc..)
 * - internamente delega el trabajo a distintos servicios especializados
 *
 * servicios utilizados:
 * -OperacionesBasicasService
 * -OperacionesCientificasService
 * -EstadisticaService
 *
 * la UI nunca accede directamente a los servicios,
 * solo interactua con esta clasee
 *
 */

public class Calculadora {

    //servicios internos especializados
    private final OperacionesCientificasService cientificasService;
    private final OperacionesBasicasService basicasService;
    private final EstadisticaService  estadisticaService;

    //modo de angulo actual (GRADOS O RADIANES)
    private ModoAngulo modoAngulo = ModoAngulo.GRADOS;


    /**
     * constructor de la calculadora
     *
     * inicializa todos los servicios y les inyecta las dependencias necesarias
     * en particular, el servico cientifico recibe un proveedor del modo de angulo
     * para saber si debe trabajar en GRADOS o RADIANES
     */
    public Calculadora() {
        this.cientificasService = new OperacionesCientificasService(() -> modoAngulo);
        this.basicasService = new OperacionesBasicasService();
        this.estadisticaService = new EstadisticaService();

    }

    /**
     * devuelve el modo de angulo actual
     */

    public ModoAngulo getModoAngulo() {
        return modoAngulo;
    }

    /**
     * cambia el modo de angulo (GRADOS o RADIANES)
     * sfecta a las funciones trigonometricas
     *
     */
    public void setModoAngulo(ModoAngulo modoAngulo) {
        this.modoAngulo = modoAngulo;
    }



    //----operaciones basicas------

    public double suma(double a, double b) {
        return basicasService.suma(a,b);
    }



    public double resta(double a, double b) {
        return basicasService.resta(a, b);
    }

    public double multiplicacion(double a, double b) {
        return basicasService.multiplicacion(a,b);


    }

    public double division(double a, double b) {
        return basicasService.division(a,b);
    }

    public double potencia(double base, double exp) {
        return basicasService.potencia(base,exp);

    }

    public double raizCuadrada(double x) {
        return basicasService.raizCuadrada(x);

    }

    public double valorAbsoluto(double x) {
        return basicasService.valorAbsoluto(x);
    }


//-----operaciones cientificas--------

    /**
     * calcula el seno del valor x segun el modo de angulo actual
     */


    public double seno(double x) {
        return cientificasService.seno(x);
    }

    /** calcula el coseno del valor x segun el modo de angulo actual
     */
    public double cos(double x) {
        return cientificasService.cos(x);

    }

    /**
     * calcila la tangente del valor x segun el modo de angulo actual
     */

    public double tan(double x) {
        return cientificasService.tan(x);

    }

    /**
     * calcula el logaritmo natural (ln)
     */

    public double ln(double x) {
        return cientificasService.ln(x);

    }

    /**
     * calcula la funcion exponencial e^x
     */

    public double exp(double x) {
        return cientificasService.exp(x);
    }

    /**
     * calcula 10 elevado a x
     */

    public double diezALa(double x) {
        return cientificasService.diezALa(x);
    }

    /**
     * calcula logaritmo en base 10
     */

    public double log10(double x) {
        return cientificasService.log10(x);
    }

    // ------estadistica ------

    /**
     * calcula la media aritmetica de un conjunto de valores
     */

        public double mean(double[] values) {
        return estadisticaService.mean(values);

    }

    /**
     * calcula la varianza de un conjunto de valores
     */
    public double variance(double[] values) {
        return estadisticaService.variance(values);


    }

    /**
     * calcula la desviacion estandar de un conjunto de valores
     */
    public double stdDev(double[] values) {
        return estadisticaService.stdDev(values);
    }
}
