package org.joraazam;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PrestamoTest {

    @Test
    void testConstructorPrestamo() {
        Libro libro = new Libro("Cien años de soledad", "Gabriel García Márquez", 5, 25);
        Prestamo prestamo = new Prestamo(libro, 3);

        assertNotNull(prestamo);
        assertEquals(libro, prestamo.getLibro()); // Verifica si el libro en el préstamo es el esperado
        assertEquals(3, prestamo.getCantidad()); // Verifica si la cantidad en el préstamo es la esperada

        // Verifica si las fechas de préstamo y devolución son correctas
        LocalDate fechaActual = LocalDate.now();
        assertEquals(fechaActual, prestamo.getFechaPrestamo());
        assertEquals(fechaActual.plusDays(14), prestamo.getFechaDevolucion());
    }

    @Test
    void testAumentarCantidad() {
        Libro libro = new Libro("Cien años de soledad", "Gabriel García Márquez", 5, 25);
        Prestamo prestamo = new Prestamo(libro, 3);

        prestamo.aumentarCantidad(2); // Incrementa la cantidad prestada en 2

        assertEquals(5, prestamo.getCantidad()); // Verifica si la cantidad se ha incrementado correctamente
    }

    @Test
    void testEquals() {
        Libro libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", 5, 25);
        Libro libro2 = new Libro("Cien años de soledad", "Gabriel García Márquez", 5, 25);
        Libro otroLibro = new Libro("El nombre del viento", "Patrick Rothfuss", 3, 30);

        Prestamo prestamo1 = new Prestamo(libro1, 3);
        Prestamo prestamo2 = new Prestamo(libro2, 3);
        Prestamo otroPrestamo = new Prestamo(otroLibro, 2);

        assertTrue(prestamo1.equals(prestamo2)); // Verifica si dos préstamos con el mismo libro y cantidad son iguales
        assertFalse(prestamo1.equals(otroPrestamo)); // Verifica si dos préstamos con libros diferentes son diferentes
    }
}