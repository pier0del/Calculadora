package test.java.com.example.calculator.service;

import main.java.com.example.calculator.service.OperacionesBasicasService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests para operaciones basicas de la calculadora
 */

 class OperacionesBasicasServiceTest {

     private final OperacionesBasicasService service = new OperacionesBasicasService();

     @Test
     void sumaDebeFuncionar() {
         assertEquals(5, service.suma(2,3));

     }

     @Test
     void divisionEntreCeroDebeLanzarExcepcion() {
         assertThrows(ArithmeticException.class,
                 () -> service.division(10,0));
     }

     @Test
     void potenciaCorrecta() {
         assertEquals(8, service.potencia(2,3));
     }

     @Test
     void raizNegativaDebeFallar() {
         assertThrows(ArithmeticException.class, () -> service.raizCuadrada(-4));
     }
}
