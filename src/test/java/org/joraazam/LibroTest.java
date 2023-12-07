package org.joraazam;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibroTest {

    @Test
    void testGetTitulo() {
        Libro libro = new Libro("Libro de prueba", "Autor de prueba", 10);
        assertEquals("Libro de prueba", libro.getTitulo());
    }

    @Test
    void testGetAutor() {
        Libro libro = new Libro("Libro de prueba", "Autor de prueba", 10);
        assertEquals("Autor de prueba", libro.getAutor());
    }

}