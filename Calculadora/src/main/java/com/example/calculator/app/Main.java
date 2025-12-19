package main.java.com.example.calculator.app;
import main.java.com.example.calculator.ui.ConsoleUI;

/**
 * clase principal de la aplicacion
 *
 * su unica mision es iniciar la interfaz de usuario de consola
 */

public class Main {

    /**
     * metodo principal que arranca la aplicacion
     *
     */
    public static void main(String[] args) {
        //se crea interfaz de usuario de consola
        ConsoleUI ui = new ConsoleUI();

        //se inicia la ejecucion de la aplicacion
        ui.start();
    }
}
