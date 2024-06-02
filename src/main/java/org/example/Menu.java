package org.example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Menu {
    public static void mostrarMenu(Usuario usuario) {
        Inventario.cargarInventario();  // Cargar inventario al inicio
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n1. Agregar Producto");
            System.out.println("2. Eliminar Producto");
            System.out.println("3. Mostrar Inventario");
            if (usuario.getRol() == Rol.ADMINISTRADOR) {
                System.out.println("4. Agregar Vendedor");
                System.out.println("5. Eliminar Vendedor");
                System.out.println("6. Salir");
            } else {
                System.out.println("4. Salir");
            }
            System.out.print("Seleccione una opción: ");

            int opcion;
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del producto: ");
                    String nombre = scanner.nextLine();
                    String precioStr;
                    double precio = 0;
                    boolean precioValido = false;
                    while (!precioValido) {
                        System.out.print("Precio del producto: ");
                        precioStr = scanner.nextLine();
                        if (Validacion.validarPrecio(precioStr)) {
                            precio = Double.parseDouble(precioStr);
                            precioValido = true;
                        } else {
                            System.out.println("Error: Por favor, ingrese un número válido para el precio.");
                        }
                    }
                    System.out.print("Información adicional del producto: ");
                    String info = scanner.nextLine();
                    String fechaIngreso = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                    Producto producto = new Producto(nombre, precio, info, fechaIngreso);
                    Inventario.agregarProducto(producto);
                    break;
                case 2:
                    System.out.print("Nombre del producto a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    Inventario.eliminarProducto(nombreEliminar);
                    break;
                case 3:
                    Inventario.mostrarInventario();
                    break;
                case 4:
                    if (usuario.getRol() == Rol.ADMINISTRADOR) {
                        System.out.print("Nombre del nuevo vendedor: ");
                        String nombreVendedor = scanner.nextLine();
                        System.out.print("Contraseña del nuevo vendedor: ");
                        String contrasenaVendedor = scanner.nextLine();
                        Login.agregarUsuario(new Usuario(nombreVendedor, contrasenaVendedor, Rol.GESTOR_DE_VENTAS));
                        System.out.println("Vendedor agregado con éxito.");
                    } else {
                        salir = true;
                    }
                    break;
                case 5:
                    if (usuario.getRol() == Rol.ADMINISTRADOR) {
                        System.out.print("Nombre del vendedor a eliminar: ");
                        String nombreVendedorEliminar = scanner.nextLine();
                        Login.eliminarUsuario(nombreVendedorEliminar);
                        System.out.println("Vendedor eliminado con éxito.");
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    break;
                case 6:
                    if (usuario.getRol() == Rol.ADMINISTRADOR) {
                        salir = true;
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }

        scanner.close();
    }
}
