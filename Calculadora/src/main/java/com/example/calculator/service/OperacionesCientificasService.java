package main.java.com.example.calculator.service;
import main.java.com.example.calculator.model.ModoAngulo;

/**
 * servicio que contiene las operaciones cientificas de la calculadora:
 * seno, coseno, tangete, logaritmos, exponenciales, etc.
 *
 * importante:
 * este servicio depende de un proveedor de modo angulo (GRADOS o RADIONES)
 * para convertir automaticamente los valores cuando sea necesario
 *
 * el modo de angulo se inyecta mediante la interfaz ModoAnguloPrivder
 * lo cual permite desacoplar la logica de la UI o de otras capas
 */

public class OperacionesCientificasService {

    /**
     * interfaz funcional que permite obtener el modo de angulo actual
     * esto permite que otras partes del programa controlen si se trabaja en
     * GRADOS o RADIONES sin acoplar esta clase a la interfaz de usuario
     */

    public interface ModoAnguloProvider {
        ModoAngulo getModoAngulo();
    }

    // dependencia que indica si trabajamos en GRADOS o RADIONES
    private final ModoAnguloProvider modoAnguloProvider;

    /**
     * constructor: recibe un proveedor del modo de angulo
     *
     *
     * @param modoAnguloProvider objeto que indica si la calculadora trabaja en GRADOS o RADIONES
     *
     */

    public OperacionesCientificasService(ModoAnguloProvider modoAnguloProvider) {
        this.modoAnguloProvider = modoAnguloProvider;


        /**
         * convierte el valor x a radianes si el modo actual es GRADOS
         * si el modo ya es RADIONES, devuelve x tal cual
         *
         * @param x valor en grados o radianes
         * @return x convertido a radianes si es necesario
         */

    }
    private double aRadianesSiEsNecesario(double x) {
        if(modoAnguloProvider.getModoAngulo() == ModoAngulo.GRADOS) {
            return Math.toRadians(x);
        }
        return x;

        /**
         * calcula el seno del valor x segun el modo de angulo actual
         */
    }
    public double seno(double x) {
        return Math.sin(aRadianesSiEsNecesario(x));
    }

    /**
     *calcula el coseno del valor x segun el modo angulo actual
     */

    public double cos(double x) {
        return Math.cos(aRadianesSiEsNecesario(x));

    }

    /**
     *calcula la tangente del valor x segun el modo de angulo actual
     */

    public double tan(double x){
        return Math.tan(aRadianesSiEsNecesario(x));

    }

    /**
     *Calcula el logaritmo natural (base e) de x
     *
     * @param x numero positivo
     * @return ln(x)
     */

    public double ln(double x) {
        return Math.log(x);

    }

    /**
     * calcula el logaritmo decimal (base 10) de x
     *
     * @param x numero positivo
     * @return log10(x)
     */

    public double log10(double x) {
        return Math.log10(x);

    }

    /**
     *calcula la funcion exponencial  e^x
     *
     */

    public double exp(double x){
        return Math.exp(x);

    }

    /**
     *calcula 10^x (diez elevado a x)
     *
     */

    public double diezALa(double x) {
        return Math.pow(10,x);

    }
}
