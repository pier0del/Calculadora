package test.java.com.example.calculator.service;

import main.java.com.example.calculator.service.EstadisticaService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests para calculos estadisticos
 */

class EstadisticaServiceTest {

    private final EstadisticaService service = new EstadisticaService();

    @Test
    void mediaCorrecto() {
        double[] valores = {2, 4, 5};
        assertEquals(4, service.mean(valores));
    }

    @Test
    void varianzaCorrecta() {
        double[] valores = {2, 4, 6};
        assertEquals(2.666, service.variance(valores), 0.001);
    }

    @Test
    void desviacionEstandarCorrecta() {
        double[] valores = {2, 4, 6};
        assertEquals(Math.sqrt(2.6666),
                service.stdDev(valores),0.001);
    }

}