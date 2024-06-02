package org.example;

import java.util.Scanner;

public class Menu {
    public static void mostrarMenu(Usuario usuario) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n1. Agregar Producto");
            System.out.println("2. Eliminar Producto");
            if (usuario.getRol() == Rol.ADMINISTRADOR) {
                System.out.println("3. Agregar Vendedor");
                System.out.println("4. Eliminar Vendedor");
            }
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del producto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Precio del producto: ");
                    double precio = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Información adicional del producto: ");
                    String info = scanner.nextLine();
                    Producto.agregarProducto(nombre, precio, info);
                    break;
                case 2:
                    System.out.print("Nombre del producto a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    Producto.eliminarProducto(nombreEliminar);
                    break;
                case 3:
                    if (usuario.getRol() == Rol.ADMINISTRADOR) {
                        System.out.print("Nombre del nuevo vendedor: ");
                        String nombreVendedor = scanner.nextLine();
                        System.out.print("Contraseña del nuevo vendedor: ");
                        String contrasenaVendedor = scanner.nextLine();
                        Login.agregarUsuario(new Usuario(nombreVendedor, contrasenaVendedor, Rol.GESTOR_DE_VENTAS));
                        System.out.println("Vendedor agregado con éxito.");
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    break;
                case 4:
                    if (usuario.getRol() == Rol.ADMINISTRADOR) {
                        System.out.print("Nombre del vendedor a eliminar: ");
                        String nombreVendedorEliminar = scanner.nextLine();
                        Login.eliminarUsuario(nombreVendedorEliminar);
                        System.out.println("Vendedor eliminado con éxito.");
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}
