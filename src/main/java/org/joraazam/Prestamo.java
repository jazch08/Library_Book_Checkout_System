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
        this.fechaDevolucion = fechaPrestamo.plusDays(14);
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void aumentarCantidad(int cantidad) {
        this.cantidad = cantidad + this.cantidad;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prestamo prestamo)) return false;

        return getLibro() != null ? getLibro().equals(prestamo.getLibro()) : prestamo.getLibro() == null;
    }

    @Override
    public int hashCode() {
        return getLibro() != null ? getLibro().hashCode() : 0;
    }
}
