package test.java.com.example.calculator.service;

import main.java.com.example.calculator.model.ModoAngulo;
import main.java.com.example.calculator.service.OperacionesCientificasService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * tests para las operaciones cientificas
 */


class OperacionesCientificasServiceTest {

    @Test
    void senoEnGrados() {
        OperacionesCientificasService service =
                new OperacionesCientificasService(() -> ModoAngulo.GRADOS);

        assertEquals(1.0, service.seno(90), 0.0001);
    }

    @Test
    void senoEnRadianes() {
        OperacionesCientificasService service =
                new OperacionesCientificasService( () -> ModoAngulo.RADIANES);

        assertEquals(1.0, service.seno(Math.PI / 2), 0.0001);
    }

    @Test
    void log10Correcto() {
        OperacionesCientificasService service =
                new OperacionesCientificasService(() -> ModoAngulo.RADIANES);

        assertEquals(2, service.log10(100), 0.0001);

    }

}
