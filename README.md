

# Calculadora Científica y Básica en Java (CLI)

Una **calculadora de consola** escrita en **Java**, diseñada con una arquitectura limpia y modular.
Permite realizar **operaciones matemáticas básicas, científicas y estadísticas**, con soporte para **modo grados y radianes**.

El proyecto está pensado para ser **extensible**, **legible** y fácil de mantener.

---

##  Características

### Operaciones básicas

* Suma
* Resta
* Multiplicación
* División (con control de división por cero)
* Potencias (base y exponente)
* Raíz cuadrada (con validación)
* Valor absoluto

---

### Operaciones científicas

* Seno (`sin`)
* Coseno (`cos`)
* Tangente (`tan`)
* Logaritmo natural (`ln`)
* Logaritmo en base 10 (`log10`)
* Exponencial (`e^x`)
* Potencia de 10 (`10^x`)

Las funciones trigonométricas funcionan tanto en **GRADOS** como en **RADIANES**.

---

### Estadística

* Media
* Varianza
* Desviación estándar

Se pueden introducir múltiples valores separados por:

* espacios
* comas
* punto y coma

**Ejemplo válido:**

```
1, 2 3; 4.5
```

---

### Modo de ángulo

* Cambio dinámico entre:

  * **GRADOS**
  * **RADIANES**

El modo seleccionado afecta directamente a `sin`, `cos` y `tan`.

---

## Arquitectura del proyecto

El proyecto sigue una **arquitectura por capas**, separando responsabilidades:

```
src/
└── main/
    └── java/
        └── com/example/calculator/
            ├── app/        → Punto de entrada (Main)
            ├── ui/         → Interfaz de consola
            ├── core/       → Lógica principal
            ├── service/    → Operaciones matemáticas
            └── model/      → Modelos y enums
```

### Ventajas:

* Código limpio y mantenible
* Fácil de extender
* Ideal para testing
* Separación clara de responsabilidades

---

## Cómo ejecutar el proyecto

### Opción 1 — Usando el `.jar` (recomendado)

1. Descarga el archivo desde **Releases**
2. Ejecuta:

```bash
java -jar calculator-1.0.0.jar
```

---

### Opción 2 — Desde el código fuente (Maven)

1. Clona el repositorio:

```bash
git clone https://github.com/pier0del/Calculadora.git
```

2. Entra en el proyecto:

```bash
cd Calculadora
```

3. Compila el proyecto:

```bash
mvn clean package
```

4. Ejecuta:

```bash
java -jar target/calculator-1.0.0.jar
```

---

## Testing

El proyecto incluye **tests unitarios** utilizando JUnit.
Se ejecutan automáticamente durante el build:

```bash
mvn test
```

---

## Tecnologías usadas

* Java 25 (compatible con java 17)
* Maven
* JUnit 5
* Arquitectura modular (Clean-ish)

---

## Release

Los binarios se publican en la sección **Releases** del repositorio.

 Descarga directa del `.jar` sin necesidad de compilar.

---

## Autor

Desarrollado por **Piero**
Proyecto educativo enfocado en buenas prácticas, estructura y claridad.

---


