package org.example.Menu;

import org.example.Datos.Datos;
import org.example.Usuarios.Login;
import org.example.Modelo.Inventario;
import org.example.Modelo.Producto;
import org.example.Usuarios.Rol;
import org.example.Usuarios.Usuario;
import org.example.Validaciones.Validacion;
import org.example.Ventanas.VentanaMostrarInventario;
import org.example.Ventanas.VentanaAgregarProducto;
import org.example.Ventanas.VentanaEliminarProducto;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Menu {
    public static void mostrarMenu(Usuario usuario) {
        Datos.asegurarArchivosCSV();
        Inventario.cargarInventario();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n1. Agregar Producto");
            System.out.println("2. Eliminar Producto");
            System.out.println("3. Mostrar Inventario");
            System.out.println("4. Quitar Cantidad de Producto");
            System.out.println("5. Aumentar Cantidad de Producto");
            if (usuario.getRol() == Rol.ADMINISTRADOR) {
                System.out.println("6. Agregar Vendedor");
                System.out.println("7. Eliminar Vendedor");
                System.out.println("8. Salir");
            } else {
                System.out.println("6. Salir");
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
                    new VentanaAgregarProducto();
                    break;
                case 2:
                    new VentanaEliminarProducto();
                    break;
                case 3:
                    new VentanaMostrarInventario();
                    break;
                case 4:
                    quitarCantidadProducto(scanner);
                    break;
                case 5:
                    aumentarCantidadProducto(scanner);
                    break;
                case 6:
                    if (usuario.getRol() == Rol.ADMINISTRADOR) {
                        agregarVendedor(scanner);
                    } else {
                        salir = true;
                    }
                    break;
                case 7:
                    if (usuario.getRol() == Rol.ADMINISTRADOR) {
                        eliminarVendedor(scanner);
                    }
                    break;
                case 8:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void agregarProducto(Scanner scanner) {
        String nombre;
        do {
            System.out.print("Nombre del producto: ");
            nombre = scanner.nextLine();
            if (!Validacion.validarNombre(nombre)) {
                System.out.println("Error: El nombre no puede estar vacío.");
            }
        } while (!Validacion.validarNombre(nombre));

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
            if (Validacion.validarEnteroPositivo(cantidadStr)) {
                cantidad = Integer.parseInt(cantidadStr);
                cantidadValida = true;
            } else {
                System.out.println("Error: Por favor, ingrese un número válido y positivo para la cantidad.");
            }
        }

        Producto nuevoProducto = new Producto(nombre, precio, infoAdicional, fechaIngreso, cantidad);
        Inventario.agregarProducto(nuevoProducto);
    }

    private static void eliminarProducto(Scanner scanner) {
        System.out.print("Nombre del producto a eliminar: ");
        String nombre = scanner.nextLine();
        Inventario.eliminarProducto(nombre);
    }

    private static void quitarCantidadProducto(Scanner scanner) {
        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Cantidad a quitar: ");
        String cantidadStr = scanner.nextLine();
        if (Validacion.validarEnteroPositivo(cantidadStr)) {
            int cantidad = Integer.parseInt(cantidadStr);
            Inventario.quitarCantidadProducto(nombre, cantidad);
        } else {
            System.out.println("Error: Por favor, ingrese un número válido y positivo para la cantidad.");
        }
    }

    private static void aumentarCantidadProducto(Scanner scanner) {
        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Cantidad a aumentar: ");
        String cantidadStr = scanner.nextLine();
        if (Validacion.validarEnteroPositivo(cantidadStr)) {
            int cantidad = Integer.parseInt(cantidadStr);
            Inventario.aumentarCantidadProducto(nombre, cantidad);
        } else {
            System.out.println("Error: Por favor, ingrese un número válido y positivo para la cantidad.");
        }
    }

    private static void agregarVendedor(Scanner scanner) {
        System.out.print("Nombre del nuevo vendedor: ");
        String nombre = scanner.nextLine();
        System.out.print("Contraseña del nuevo vendedor: ");
        String contrasena = scanner.nextLine();
        Usuario nuevoUsuario = new Usuario(nombre, contrasena, Rol.GESTOR_DE_VENTAS);
        Login.agregarUsuario(nuevoUsuario);
    }

    private static void eliminarVendedor(Scanner scanner) {
        System.out.print("Nombre del vendedor a eliminar: ");
        String nombre = scanner.nextLine();
        Login.eliminarUsuario(nombre);
    }
}
