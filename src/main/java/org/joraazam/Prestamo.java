package org.joraazam;
import java.time.LocalDate;

class Prestamo {
    Libro libro;
    int cantidad;
    LocalDate fechaPrestamo;
    LocalDate fechaDevolucion;

    public Prestamo(Libro libro, int cantidad) {
        this.libro = libro;
        this.cantidad = cantidad;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = fechaPrestamo.plusDays(14); // 14 días de préstamo
    }
}
