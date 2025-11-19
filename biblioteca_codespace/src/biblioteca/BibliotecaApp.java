package biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {

        Biblioteca b = new Biblioteca();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Agregar libro");
            System.out.println("2. Registrar usuario");
            System.out.println("3. Realizar préstamo");
            System.out.println("4. Salir");
            System.out.print("Opción: ");

            int op = sc.nextInt();
            sc.nextLine();

            try {

                switch (op) {

                    case 1:
                        System.out.print("ISBN: ");
                        String isbn = sc.nextLine();

                        System.out.print("Título: ");
                        String titulo = sc.nextLine();

                        System.out.print("Autor: ");
                        String autor = sc.nextLine();

                        System.out.print("Año: ");
                        int anio = sc.nextInt();

                        System.out.print("Ejemplares: ");
                        int ej = sc.nextInt();
                        sc.nextLine();

                        b.agregarLibro(new Libro(isbn, titulo, autor, anio, ej));
                        System.out.println("Libro agregado.");
                        break;

                    case 2:
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("Email: ");
                        String email = sc.nextLine();

                        Usuario u = new Usuario(nombre, email);
                        b.registrarUsuario(u);

                        System.out.println("Registrado con ID: " + u.getId());
                        break;

                    case 3:
                        System.out.print("ISBN: ");
                        String is = sc.nextLine();

                        System.out.print("ID usuario: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        b.realizarPrestamo(is, id);

                        System.out.println("Préstamo exitoso.");
                        break;

                    case 4:
                        System.out.println("Saliendo...");
                        return;

                    default:
                        System.out.println("Opción inválida");
                        break;
                }

            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }

    }
}
