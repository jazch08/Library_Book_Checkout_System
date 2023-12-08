package org.joraazam;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {
    @Test
    void testConstructorUsuario() {
        Usuario usuario = new Usuario("Usuario1");

        assertNotNull(usuario);
        assertEquals("Usuario1", usuario.getUsername()); // Verifica si el nombre de usuario es el esperado
        assertNotNull(usuario.getPrestamoList()); // Verifica si la lista de préstamos no es nula
        assertEquals(0, usuario.getCargoPorAtraso()); // Verifica si el cargo por atraso es inicializado correctamente
    }

    @Test
    void testSetUsername() {
        Usuario usuario = new Usuario("Usuario1");
        usuario.setUsername("NuevoUsuario");

        assertEquals("NuevoUsuario", usuario.getUsername()); // Verifica si el cambio de nombre de usuario es correcto
    }

    @Test
    void testSetPrestamoList() {
        Usuario usuario = new Usuario("Usuario1");
        Prestamo prestamo = new Prestamo(new Libro("Cien años de soledad", "Gabriel García Márquez", 5, 25), 3);
        usuario.getPrestamoList().add(prestamo); // Agrega un préstamo a la lista

        assertFalse(usuario.getPrestamoList().isEmpty()); // Verifica si la lista de préstamos no está vacía
        assertEquals(1, usuario.getPrestamoList().size()); // Verifica si el tamaño de la lista es el esperado
        assertTrue(usuario.getPrestamoList().contains(prestamo)); // Verifica si el préstamo está en la lista
    }

    @Test
    void testCargoPorAtraso() {
        Usuario usuario = new Usuario("Usuario1");

        assertEquals(0, usuario.getCargoPorAtraso()); // Verifica si el cargo por atraso se inicializa correctamente

        usuario.setCargoPorAtraso(10);
        assertEquals(10, usuario.getCargoPorAtraso()); // Verifica si el cargo por atraso se actualiza correctamente
    }

    @Test
    void testAgregarPrestamo() {
        Usuario usuario = new Usuario("Usuario1");
        Prestamo prestamo = new Prestamo(new Libro("Cien años de soledad", "Gabriel García Márquez", 5, 25), 3);

        usuario.getPrestamoList().add(prestamo); // Agrega un préstamo a la lista

        assertFalse(usuario.getPrestamoList().isEmpty()); // Verifica si la lista de préstamos no está vacía
        assertEquals(1, usuario.getPrestamoList().size()); // Verifica si el tamaño de la lista es el esperado
        assertTrue(usuario.getPrestamoList().contains(prestamo)); // Verifica si el préstamo está en la lista
    }


}