package org.joraazam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaBiblioteca {
    private List<Libro> catalogo;
    private List<Prestamo> prestamos;

    public SistemaBiblioteca() {
        catalogo = new ArrayList<>();
        prestamos = new ArrayList<>();
        inicializarCatalogo();
    }

    private void inicializarCatalogo() {
        catalogo.add(new Libro("Cien años de soledad", "Gabriel García Márquez", 5));
        catalogo.add(new Libro("El nombre del viento", "Patrick Rothfuss", 3));
        // Agregar más libros al catálogo
    }

    public void mostrarCatalogo() {
        System.out.println("Catálogo de libros disponibles:");
        for (Libro libro : catalogo) {
            System.out.println("Título: " + libro.titulo + ", Autor: " + libro.autor + ", Disponibles: " + libro.cantidadDisponible);
        }
    }

    public void realizarPrestamo() {
        Scanner scanner = new Scanner(System.in);
        int cantidadTotalPrestada = 0;

        System.out.println("Catálogo de libros disponibles:");
        for (Libro libro : catalogo) {
            System.out.println("Título: " + libro.titulo + ", Autor: " + libro.autor + ", Disponibles: " + libro.cantidadDisponible);
        }

        while (cantidadTotalPrestada < 10) {
            System.out.println("Ingrese el título del libro que desea llevar en préstamo (o 'fin' para finalizar):");
            String titulo = scanner.nextLine();

            if (titulo.equalsIgnoreCase("fin")) {
                break;
            }

            Libro libroSeleccionado = null;
            for (Libro libro : catalogo) {
                if (libro.titulo.equalsIgnoreCase(titulo)) {
                    libroSeleccionado = libro;
                    break;
                }
            }

            if (libroSeleccionado != null && libroSeleccionado.cantidadDisponible > 0) {
                System.out.println("Ingrese la cantidad de ejemplares que desea llevar en préstamo:");
                int cantidad = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                if (cantidad > 0 && cantidad <= libroSeleccionado.cantidadDisponible && cantidadTotalPrestada + cantidad <= 10) {
                    libroSeleccionado.cantidadDisponible -= cantidad;
                    cantidadTotalPrestada += cantidad;
                    System.out.println("¡Préstamo de '" + libroSeleccionado.titulo + "' realizado con éxito!");
                } else {
                    System.out.println("La cantidad ingresada es inválida o excede el límite de disponibilidad o de libros a prestar.");
                }
            } else {
                System.out.println("El libro ingresado no está disponible en el catálogo o no quedan ejemplares.");
            }
        }

        System.out.println("Ha alcanzado el límite máximo de libros prestados o ha finalizado el proceso de préstamo.");
    }

}
