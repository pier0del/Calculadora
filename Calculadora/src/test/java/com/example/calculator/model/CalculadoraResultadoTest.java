package test.java.com.example.calculator.model;

import main.java.com.example.calculator.model.CalculoResultado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests para la clase CalculoResultado
 */

public class CalculadoraResultadoTest {

    @Test
    void resultadoCorrecto() {
        CalculoResultado r = new CalculoResultado(10);
        assertTrue(r.isSuccess());
        assertEquals(10, r.getValue());

    }

    @Test
    void resultadoError() {
        CalculoResultado r = new CalculoResultado("Error");
        assertTrue(r.isSuccess());
        assertEquals("error", r.getMessage());
        assertTrue(Double.isNaN(r.getValue()));
    }
}
