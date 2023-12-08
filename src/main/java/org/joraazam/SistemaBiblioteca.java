package org.joraazam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaBiblioteca {
    private ArrayList<Libro> catalogo;
    private ArrayList<Prestamo> prestamos;
    Usuario usuario_login = new Usuario("Sjoraazam");
    private double cargoMoraPorDia = 1.0;


    public SistemaBiblioteca() {
        catalogo = new ArrayList<>();
        prestamos = new ArrayList<>();
        inicializarCatalogo();
    }

    private void inicializarCatalogo() {
        catalogo.add(new Libro("Cien años de soledad", "Gabriel García Márquez", 5, 13));
        catalogo.add(new Libro("El nombre del viento", "Patrick Rothfuss", 3, 10));
    }


    public void mostrarCatalogo() {
        System.out.println("Catálogo de libros disponibles:");
        for (Libro libro : catalogo) {
            System.out.println( libro.codigo + ". " + "Título: " + libro.titulo + ", Autor: " + libro.autor + ", Disponibles: " + libro.cantidadDisponible);
        }
    }

    public void mostrarLibrosAPrestar() {
        int contador = 1;
        int total = 0;
        for (Prestamo prestamo : prestamos){
            System.out.println(contador + ". " + prestamo.getLibro().titulo);
            System.out.println("\t Cantidad: " + prestamo.getCantidad());
            System.out.println("\t Fecha limite de entrega: " + prestamo.getFechaDevolucion());
            int subtotal = prestamo.getCantidad() * prestamo.getLibro().getPrecio();
            System.out.println("\t Subtotal: $" + subtotal);
            total = total + subtotal;
            contador++;
        }
        System.out.println("Sus cargos por entregas atrasadas son: " + usuario_login.getCargoPorAtraso());
        total = total + usuario_login.getCargoPorAtraso();
        System.out.println("Total a pagar: $" + total);

    }

    public void realizarPrestamo() {
        Scanner scanner = new Scanner(System.in);
        int cantidadTotalPrestada = 0;

        mostrarCatalogo();

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

            if (libroSeleccionado != null) {
                int cantidad = 0;

                boolean inputValido = false;

                while (!inputValido) {
                    try {
                        System.out.println("Ingrese la cantidad de ejemplares que desea llevar en préstamo:");
                        cantidad = Integer.parseInt(scanner.nextLine());

                        if (cantidad > 0) {
                            inputValido = true;
                        } else{
                            System.out.println("Error: Ingrese un numero mayor a cero");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Ingrese un número válido.");
                    }
                }

                if (cantidad > 0 && cantidad <= libroSeleccionado.cantidadDisponible && cantidadTotalPrestada + cantidad <= 10) {
                    libroSeleccionado.cantidadDisponible -= cantidad;
                    cantidadTotalPrestada += cantidad;
                    Prestamo prestamo = new Prestamo(libroSeleccionado, cantidad);
                    if(prestamos.contains(prestamo)) {
                        int indiceLibroAPrestar = prestamos.indexOf(prestamo);
                        prestamos.get(indiceLibroAPrestar).aumentarCantidad(cantidad);
                    }else {
                        prestamos.add(prestamo);
                    }
                    System.out.println("¡Selección de '" + libroSeleccionado.titulo + "' realizado con éxito!");
                } else if (cantidad > libroSeleccionado.cantidadDisponible) {
                    System.out.println("Del libro seleccionado quedan unicamente: " + libroSeleccionado.cantidadDisponible + " disponibles.");
                } else if (cantidadTotalPrestada + cantidad > 10){
                    System.out.println("Ha alcanzado el límite máximo de libros prestados. Puede presta hasta 10 libros.");
                    break;
                }
            } else {
                System.out.println("El libro ingresado no está disponible en el catálogo");
            }
        }

        mostrarLibrosAPrestar();

        String seguro = "";

        do{
            System.out.println("Esta seguro que quiere prestar estos libros? Si o no");
            seguro = scanner.nextLine();
            if(seguro.equals("No")){
                System.out.println("Gracias por su visita");
                System.exit(-1);
            }
            if(!seguro.equals("Si")){
                System.out.println("Ingrese una respuesta valida");
            }
        }while(!seguro.equals("Si"));

        usuario_login.setPrestamoList(prestamos);

        System.out.println("Gracias por su pago");

    }

}
