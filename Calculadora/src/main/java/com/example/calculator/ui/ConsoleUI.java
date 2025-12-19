package main.java.com.example.calculator.ui;


import main.java.com.example.calculator.core.Calculadora;
import main.java.com.example.calculator.model.CalculoResultado;
import main.java.com.example.calculator.model.ModoAngulo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * interfaz de consola CLI para calculadora cientifica
 *
 * responsabilidades:
 * - mostrar menu
 * - pedir datos al usuario
 * - llamar a la logica de negocio (Calculadora)
 * - mostrar resultados o errores de forma amigable
 *
 * importante:
 * esta clase NO hace caculos matematicos por si misma
 * solo recoge input y delega la operacion a la clase calculadora
 *
 */
public class ConsoleUI {

    // el cerebro de la aplicacion: aqui vive la logica (servicios)
    private final Calculadora calculadora;

    //scanner para leer lo que escribe el usuario por consola
    private final Scanner scanner;

    /**
     * constructor: crea una calculadora y un scanner
     */
    public ConsoleUI() {

        this.calculadora = new Calculadora();
        this.scanner = new Scanner(System.in);
    }

    /**
     * punto de entrada de la interfaz
     * mantiene el programa en un bucle hasta qye el usuario eige "salir"
     */
    public void start() {
        boolean running = true;

        while (running) {
            mostrarMenuPrincipal();
            String opcion = scanner.nextLine().trim();

            //menu principal: redirige a submenus segun lo que eliga el usuario
            switch (opcion) {
                case "1" -> handleOperacionBasica();
                case "2" -> handleOperacionCientifica();
                case "3" -> handleEstadistica();
                case "4" -> handleCambioModoAngulo();
                case "0" -> running = false;
                default -> System.out.println("Opcion no valida.");
            }
        }
        System.out.println("saliendo del programa..-..");


    }
    /**
     * muestra el menu principal al usuario
     *
     */
    private void mostrarMenuPrincipal() {
        System.out.println("\n==== CALCULADORA CIENTIFICA AVANZADA==== ");
        System.out.println("1) operaciones basicas");
        System.out.println("2) operaciones cientificas");
        System.out.println("3) estadistica");
        System.out.println("4) cambiar modo de angulo -> (actual: " + calculadora.getModoAngulo() + ")");
        System.out.println("0) SALIR");
        System.out.println("-> elige una opcion: ");
    }
//==== OPERACIONES BASICAS=====

    /**
     * submenu de operaciones basicas
     * pide la operacion y los numeros, llama a la calculadora y muestra el resultado por pantalla
     */

    private void handleOperacionBasica() {
        System.out.println("\n --- OPERACIONES BASICAS ---");
        System.out.println("a) suma");
        System.out.println("b) resta");
        System.out.println("c) multiplicacion");
        System.out.println("d) division");
        System.out.println("e) potencia");
        System.out.println("f) raiz cuadrada");
        System.out.println("g) valor absoluto");
        System.out.print("elige subopcion (a-g): ");

        String op = scanner.nextLine().trim().toLowerCase();
        CalculoResultado resultado;
        try {
            // en cada caso pedimos los datos necesarios y ejecutamos la operacion
            switch (op) {
                case "a" -> {
                    double a = leerDouble("primer numero: ");
                    double b = leerDouble("segundo numero: ");
                    resultado = new CalculoResultado(calculadora.suma(a, b));
                }

                case "b" -> {
                    double a = leerDouble("primer numero: ");
                    double b = leerDouble("segundo numero: ");
                    resultado = new CalculoResultado(calculadora.resta(a, b));

                }

                case "c" -> {
                    double a = leerDouble("primer numero: ");
                    double b = leerDouble("segundo numero: ");
                    resultado = new CalculoResultado(calculadora.multiplicacion(a, b));

                }
                case "d" -> {
                    double a = leerDouble("numerador: ");
                    double b = leerDouble("denominador: ");
                    resultado = new CalculoResultado(calculadora.division(a, b));
                }
                case "e" -> {
                    double base = leerDouble("numero: ");
                    double exp = leerDouble("exponente: ");
                    resultado = new CalculoResultado(calculadora.potencia(base, exp));
                }

                case "f" -> {
                    double x = leerDouble("numero: ");
                    resultado = new CalculoResultado(calculadora.raizCuadrada(x));

                }
                case "g" -> {
                    double x = leerDouble("numero: ");
                    resultado = new CalculoResultado(calculadora.valorAbsoluto(x));

                }
                default -> {
                    System.out.println("subopcion invalida");
                    return;
                }
            }
        } catch (ArithmeticException ex) {
            // si la calculadora lanza error matematico lo mostramos
            resultado = new CalculoResultado(ex.getMessage());
        }
        System.out.println(resultado);
    }

    //===OPERACIONES CIENTIFICAS===

    /**
     * submenu de operaciones cientificas
     * nota -> seno/coseno/tangente usan el modo de angulo seleccionado
     * GRADOS o RADIANES
     */

    private void handleOperacionCientifica() {
        System.out.println("\n --- OPERACIONES CIENTIFICAS ---");
        System.out.println("a) seno");
        System.out.println("b) coseno");
        System.out.println("c) tangente");
        System.out.println("d) log10(x");
        System.out.println("e) ln(x)");
        System.out.println("f) e^x");
        System.out.println("g) 10-x");
        System.out.println("elige subopcion (a-g): ");

        String op = scanner.nextLine().trim().toLowerCase();
        CalculoResultado resultado;

        // la mayoria de funciones cientificas usan un solo valor x
        double x = leerDouble("ingresa el valor: ");
        try {
            switch (op) {
                case "a" -> resultado = new CalculoResultado(calculadora.seno(x));
                case "b" -> resultado = new CalculoResultado(calculadora.cos(x));
                case "c" -> resultado = new CalculoResultado(calculadora.tan(x));

                //log10 y ln solo estan definidos para x > 0 en numeros reales
                case "d" -> {
                    if (x <= 0) {
                        resultado = new CalculoResultado("log10 indefinido para ≤ 0");
                    } else {
                        resultado = new CalculoResultado(calculadora.log10(x));
                    }
                }
                case "e" -> {
                    if (x <= 0) {
                        resultado = new CalculoResultado("ln indefinido para <= 0");
                    } else {
                        resultado = new CalculoResultado(calculadora.ln(x));
                    }
                }
                case "f" -> resultado = new CalculoResultado(calculadora.exp(x));
                case "g" -> resultado = new CalculoResultado(calculadora.diezALa(x));
                default -> {
                    System.out.println("subopcion no valida");
                    return;
                }
            }
        } catch (ArithmeticException ex) {
            resultado = new CalculoResultado(ex.getMessage());
        }
        System.out.println(resultado);

    }

//--- estadistica---

    /**
     * permite introducir una lista de numeros y calcula:
     * - media
     * - varianza
     * - desviacion estandar
     *
     * el usuario puede separar numeros por : espacios, comas o punto y coma.
     */

    private void handleEstadistica() {
        System.out.println("\n--- ESTADISTICA ---");
        System.out.println("ingrese los numeros separados por espacios, comas o punto y coma: ");
        String linea = scanner.nextLine();

        double[] valores = parsearArrayNumeros(linea);
        if (valores.length == 0) {
            System.out.println("no se ingresaron numeros validos");
            return;

        }

        System.out.println("datos ingresados: " + Arrays.toString(valores));
        System.out.println("media       : " + calculadora.mean(valores));
        System.out.println("varianza   : " + calculadora.variance(valores));
        System.out.println("Desviacion estandar: " + calculadora.stdDev(valores));
    }

    //----modo angulo ----

    /**
     * permite cambiar el modo de angulo entre GRADOS y RADIANES
     * esto afecta a sin/cos/tan
     */
    private void handleCambioModoAngulo() {
        System.out.println("Modo actual: " + calculadora.getModoAngulo());
        System.out.println("1) GRADOS");
        System.out.println("2) RADIANES");
        System.out.println("elige nuevo modo: ");
        String op = scanner.nextLine().trim();

        if ("1".equals(op)) {
            calculadora.setModoAngulo(ModoAngulo.GRADOS);
            System.out.println("-> Modo cambiado a GRADOS");
        } else if ("2".equals(op)) {
            calculadora.setModoAngulo(ModoAngulo.RADIANES);
            System.out.println("->Modo cambiado a RADIANES");
        } else {
            System.out.println("Opcion no valida. Intentalo de nuevo");
        }
    }

    //---helpers----- (utilidades) ----

    /**
     * lee un numero double desde consola, repitiendo hasta que el usuario escriba un numero valido
     *
     * @param mensaje texto que se muestra al usuario
     * @return double valido introducido por el usuario
     */

    private double leerDouble(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String linea = scanner.nextLine().trim();
            try {
                return Double.parseDouble(linea);
            } catch (NumberFormatException e) {
                System.out.println("entrada no valida. Intentalo de nuevo");

            }
        }
    }

    /**
     * convierte un texto con numeros separados por delimitadores en un array de double
     * delimitadores aceptados: espacios, comas o punto y coma
     *
     * ejemplo valido:
     * "1 2 3" , "1,2,3" , "1 ; 2 ; 3" , "1, 2; 3 4"
     *
     * @param input texto introducido por el usuario
     * @return array con los numeros parseados (si no hay validos, devuelve un array vacio)
     *
     */

    private double[] parsearArrayNumeros(String input) {

        //separamos por espacio, coma o punto y coma
        String[] partes = input.split("[,:\\s]+");

        double[] numeros = new double[partes.length];
        int contador = 0;

        for (String p : partes) {
            p = p.trim();
            if (p.isEmpty()) continue;
            try {
                numeros[contador++] = Double.parseDouble(p);
            } catch (NumberFormatException ignored) {
                //ignorar valores no numericos
            }

        }
        //devolvemos solo los numeros validos
        return Arrays.copyOf(numeros, contador);
    }
}

