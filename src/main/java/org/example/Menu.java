package org.example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Menu {
    public static void mostrarMenu(Usuario usuario) {
        Datos.asegurarArchivoCSV();
        Inventario.cargarInventario();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n1. Agregar Producto");
            System.out.println("2. Eliminar Producto");
            System.out.println("3. Mostrar Inventario");
            System.out.println("4. Quitar Cantidad de Producto");
            if (usuario.getRol() == Rol.ADMINISTRADOR) {
                System.out.println("5. Agregar Vendedor");
                System.out.println("6. Eliminar Vendedor");
                System.out.println("7. Salir");
            } else {
                System.out.println("5. Salir");
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
                        if (Validacion.validarNumero(precioStr)) {
                            precio = Double.parseDouble(precioStr);
                            precioValido = true;
                        } else {
                            System.out.println("Error: Por favor, ingrese un número válido para el precio.");
                        }
                    }

                    System.out.print("Información adicional del producto: ");
                    String infoAdicional = scanner.nextLine();

                    String fechaIngreso = new SimpleDateFormat("dd/MM/yyyy").format(new Date());

                    String cantidadStr;
                    int cantidad = 0;
                    boolean cantidadValida = false;
                    while (!cantidadValida) {
                        System.out.print("Cantidad del producto: ");
                        cantidadStr = scanner.nextLine();
                        if (Validacion.validarEntero(cantidadStr)) {
                            cantidad = Integer.parseInt(cantidadStr);
                            cantidadValida = true;
                        } else {
                            System.out.println("Error: Por favor, ingrese un número válido para la cantidad.");
                        }
                    }

                    Producto nuevoProducto = new Producto(nombre, precio, infoAdicional, fechaIngreso, cantidad);
                    Inventario.agregarProducto(nuevoProducto);
                    break;
                case 2:
                    System.out.print("Nombre del producto a eliminar: ");
                    nombre = scanner.nextLine();
                    Inventario.eliminarProducto(nombre);
                    break;
                case 3:
                    Inventario.mostrarInventario();
                    break;
                case 4:
                    System.out.print("Nombre del producto: ");
                    nombre = scanner.nextLine();
                    cantidadStr = "";
                    cantidad = 0;
                    cantidadValida = false;
                    while (!cantidadValida) {
                        System.out.print("Cantidad a quitar: ");
                        cantidadStr = scanner.nextLine();
                        if (Validacion.validarEntero(cantidadStr)) {
                            cantidad = Integer.parseInt(cantidadStr);
                            cantidadValida = true;
                        } else {
                            System.out.println("Error: Por favor, ingrese un número válido para la cantidad a quitar.");
                        }
                    }
                    Inventario.quitarCantidadProducto(nombre, cantidad);
                    break;
                case 5:
                    if (usuario.getRol() == Rol.ADMINISTRADOR) {
                        // Lógica para agregar vendedor
                    } else {
                        salir = true;
                    }
                    break;
                case 6:
                    if (usuario.getRol() == Rol.ADMINISTRADOR) {
                        // Lógica para eliminar vendedor
                    }
                    break;
                case 7:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
