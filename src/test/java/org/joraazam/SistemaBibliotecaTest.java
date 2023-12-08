package org.joraazam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class SistemaBibliotecaTest {
    SistemaBiblioteca sistemaBiblioteca = null;
    @BeforeEach
    void setUp() {
        sistemaBiblioteca = new SistemaBiblioteca();
    }

    @Test
    void testMostrarCatalogo() {
        // Prueba para verificar si el catálogo se muestra correctamente
        // Estableciendo un nuevo InputStream para simular la entrada del usuario
        String input = "fin\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Ejecutamos el método y comprobamos si no hay excepciones
        assertDoesNotThrow(() -> sistemaBiblioteca.mostrarCatalogo());
    }

    @Test
    void testRealizarPrestamo() {
        // Prueba para verificar el proceso de préstamo
        // Estableciendo un nuevo InputStream para simular la entrada del usuario
        String input = "Cien años de soledad\n2\nEl nombre del viento\n3\nfin\nSi\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Ejecutamos el método y comprobamos si no hay excepciones
        assertDoesNotThrow(() -> sistemaBiblioteca.realizarPrestamo());
    }

    @Test
    void testRealizarPrestamoLimiteExcedido() {
        // Prueba para verificar si el límite de préstamos se alcanza
        // Estableciendo un nuevo InputStream para simular la entrada del usuario
        String input = "Cien años de soledad\n6\nEl nombre del viento\n6\nfin\nSi\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Ejecutamos el método y comprobamos si no hay excepciones
        assertDoesNotThrow(() -> sistemaBiblioteca.realizarPrestamo());
    }

}