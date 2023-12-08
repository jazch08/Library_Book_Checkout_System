package org.joraazam;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibroTest {

    @Test
    void testGetTitulo() {
        Libro libro = new Libro("Libro de prueba", "Autor de prueba", 10, 13);
        assertEquals("Libro de prueba", libro.getTitulo());
    }

    @Test
    void testGetAutor() {
        Libro libro = new Libro("Libro de prueba", "Autor de prueba", 10, 10);
        assertEquals("Autor de prueba", libro.getAutor());
    }

    @Test
    void testEqualsLibrosIguales() {
        Libro libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", 5, 25);
        Libro libro2 = new Libro("Cien años de soledad", "Gabriel García Márquez", 5, 25);

        assertTrue(libro1.equals(libro2));
    }

    @Test
    void testEqualsLibrosDiferentes() {
        Libro libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", 5, 25);
        Libro libro2 = new Libro("El nombre del viento", "Patrick Rothfuss", 3, 30);

        assertFalse(libro1.equals(libro2));
    }

}