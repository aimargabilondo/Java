import java.util.ArrayList;
import java.util.Scanner;

public class SistemaGestionBiblioteca {

    static class Libro {
        String titulo;
        String autor;
        boolean prestado;

        Libro(String titulo, String autor) {
            this.titulo = titulo;
            this.autor = autor;
            this.prestado = false;
        }

        @Override
        public String toString() {
            return "[" + (prestado ? "Prestado" : "Disponible") + "] Título: " + titulo + ", Autor: " + autor;
        }
    }

    private static ArrayList<Libro> libros = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSistema de Gestión de Biblioteca:");
            System.out.println("1. Agregar libro");
            System.out.println("2. Mostrar libros");
            System.out.println("3. Prestar libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el título del libro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingresa el autor del libro: ");
                    String autor = scanner.nextLine();
                    libros.add(new Libro(titulo, autor));
                    System.out.println("Libro agregado con éxito.");
                    break;
                case 2:
                    System.out.println("\nLista de libros:");
                    for (int i = 0; i < libros.size(); i++) {
                        System.out.println((i + 1) + ". " + libros.get(i));
                    }
                    break;
                case 3:
                    System.out.print("Ingresa el número del libro que deseas prestar: ");
                    int indicePrestar = scanner.nextInt() - 1;
                    if (indicePrestar >= 0 && indicePrestar < libros.size()) {
                        Libro libro = libros.get(indicePrestar);
                        if (!libro.prestado) {
                            libro.prestado = true;
                            System.out.println("Libro prestado con éxito.");
                        } else {
                            System.out.println("El libro ya está prestado.");
                        }
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;
                case 4:
                    System.out.print("Ingresa el número del libro que deseas devolver: ");
                    int indiceDevolver = scanner.nextInt() - 1;
                    if (indiceDevolver >= 0 && indiceDevolver < libros.size()) {
                        Libro libro = libros.get(indiceDevolver);
                        if (libro.prestado) {
                            libro.prestado = false;
                            System.out.println("Libro devuelto con éxito.");
                        } else {
                            System.out.println("El libro no está prestado.");
                        }
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del sistema de gestión de biblioteca. \u00a1Adios!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intenta nuevamente.");
            }
        }
    }
}
