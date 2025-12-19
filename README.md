# Calculadora Cientifica y basica en java (CLI)

esta es una **calculadora basica y cientifica avanzada escrita en java**. ejecutada desde la consola, diseñanda con arquitectura limpia y modular.
permite realizar **operaciones basicas, cientificas y estadisticas** ademas de cambiar el **modo de angulo**

---

# Funcionalidades

### Operaciones basicas
- suma
- resta
- multiplicacion
- division (con control de division entre cero)
- potencias (base y exponente)
- raiz cuadrada (con validacion)
- |x| valor absoluto

---

### Operaciones cientificas
- seno (sin)
- coseno (cos)
- tangente (tan)
- logaritmo natural (ln)
- logaritmo en base 10 (log0)
- exponencial (e^x)
- potencia de 10 (1o^x)

  las funciones trigonometricas funcionan tanto como en **GRADOS** como en **RADIANES**

  ---

  ### Estadistica
  - media
  - varianza
  - desviacion estandar
 
  permite introducir multiples valores separados por
  - espacios
  - comas
  - punto y coma
 
  ejm:
  1, 2 3; 4.5

  ---

  ### Modo de angulo
  - cambio dinamico entre:
    - **GRADOS**
    - **RADIANES**

  el modo afecta directamente a sin, cos y tan

  ---

  ## Diseño del proyecto

  - arquitectura por capas:
    - ui -> interfaz de consola
    - core -> fachada principal (Calculadora)
    - service -> logica matematica
    - model -> modelos y enums
  - separacion clara de responsabilidades
  - manejo de errores sin romper la ejecucion
  - codigo documentado con  **Javadoc**

FIN
  
