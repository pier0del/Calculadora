package main.java.com.example.calculator.ui;

import main.java.com.example.calculator.basic.BasicCalculatorServices;
import main.java.com.example.calculator.common.CalculatorException;
import main.java.com.example.calculator.scientific.ScientificCalculatorServices;
import java.util.Scanner;

public class CalculatorCLI {
    private final BasicCalculatorServices basicService = new BasicCalculatorServices();
    private final ScientificCalculatorServices sciService = new ScientificCalculatorServices();
    private final Scanner scanner = new Scanner(System.in);
    public void start() {
        System.out.println("CALCULADORA BASICA Y CIENTIFICA");
        while (true) {
            try {
                showMenu();
                int option = Integer.parseInt(scanner.nextLine());
                if (option == 0) {
                    System.out.println("saliendo del programa...");
                    break;
                }
                executeOption(option);

            } catch (CalculatorException ex) {
                System.err.println(ex.getMessage());
            } catch (NumberFormatException ex) {
                System.err.println("entrada invalida pon un numero");
            }
        }
    }
private void showMenu() {
    System.out.println("""
            \nSeleccione una opcion: 
            1. Suma
            2. Resta
            3. Multiplicar
            4. Dividir
            5. Seno (rad)
            6. Logaritmo natural
            7. Exponencial
            8. Potencia
            9. PI
            0. SALIR DEL PROGRAMA
            Opcion: """);
    }

    private void executeOption(int option) {
        switch (option) {
            case 1:
                performBasic((a,b) -> basicService.add(a,b));
                break;
            case 2:
                performBasic((a,b) -> basicService.subtract(a,b));
                break;
            case 3:
                performBasic((a,b) -> basicService.multiply(a,b));
                break;
            case 4:
                performBasic((a,b) -> basicService.divide(a,b));
                break;
            case 5:
                System.out.print("ingresa el angulo en radianes: ");
                double r  = Double.parseDouble(scanner.nextLine());
                System.out.println("Resultado: "+ sciService.sin(r));
                break;
            case 6:
                System.out.print("Ingresa valor (>0): ");
                double v = Double.parseDouble(scanner.nextLine());
                System.out.println("resultado: "+ sciService.log(v));
                case 7:
                System.out.print("Ingrese exponente: ");
                double exp =Double.parseDouble(scanner.nextLine());
                System.out.println("resultado: " + sciService.exp(exp));
                break;
            case 8:
                System.out.print("Base: ");
                double base = Double.parseDouble(scanner.nextLine());
                System.out.print("exponente: ");
                double expo = Double.parseDouble(scanner.nextLine());
                System.out.println("Resultado: "+ sciService.pow(base, expo));
                break;
            case 9:
                System.out.print("resultado: "+ sciService.pi());
                break;
            default:
                System.err.println("opcion no valida.");
        }
    }

    private void performBasic(BasicOperation op) {
        System.out.print("ingresa el primer operando: ");
        double a = Double.parseDouble(scanner.nextLine());
        System.out.print("ingresa el segundo operando: ");
        double b = Double.parseDouble(scanner.nextLine());
        System.out.println("resultado: "+ op.apply(a,b));



        }

        @FunctionalInterface
    private interface BasicOperation {
        double apply(double a, double b);
        }
}