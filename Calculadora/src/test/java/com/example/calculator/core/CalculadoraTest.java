package test.java.com.example.calculator.core;

import main.java.com.example.calculator.core.Calculadora;
import main.java.com.example.calculator.model.ModoAngulo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * test de integracion ligera para la clase Calculadora
 *
 */
public class CalculadoraTest {

    private final Calculadora calc = new Calculadora();

    @Test
    void sumaDesdeCalculadora() {
        assertEquals(10, calc.suma(5, 5));
    }

    @Test
    void sumaModoAngulo() {
        calc.setModoAngulo(ModoAngulo.RADIANES);
        assertEquals(ModoAngulo.RADIANES, calc.getModoAngulo());


    }

    @Test
    void senoDesdeCalculadora() {
        calc.setModoAngulo(ModoAngulo.GRADOS);
        assertEquals(1.0, calc.seno(90), 0.0001);
    }

}
