package org.example.Modelo;

import org.example.Datos.Datos;

import java.util.HashMap;
import java.util.Map;

public class Inventario {
    public static Map<String, Producto> inventario = new HashMap<>();

    public static void agregarProducto(Producto producto) {
        agregarProducto(producto, true);
    }

    public static void agregarProducto(Producto producto, boolean mostrarMensaje) {
        if (!inventario.containsKey(producto.getNombre().toLowerCase())) {
            inventario.put(producto.getNombre().toLowerCase(), producto);
            Datos.guardarProductoEnCSV(producto);
            if (mostrarMensaje) {
                System.out.println("Producto agregado con éxito al inventario.");
            }
        } else {
            Producto existente = inventario.get(producto.getNombre().toLowerCase());
            existente.setCantidad(existente.getCantidad() + producto.getCantidad());
            Datos.actualizarCSV();
            if (mostrarMensaje) {
                System.out.println("La cantidad del producto ha sido actualizada.");
            }
        }
    }

    public static void eliminarProducto(String nombre) {
        if (inventario.containsKey(nombre.toLowerCase())) {
            inventario.remove(nombre.toLowerCase());
            Datos.actualizarCSV();
            System.out.println("Producto eliminado con éxito del inventario.");
        } else {
            System.out.println("Error: No existe un producto con ese nombre en el inventario.");
        }
    }

    public static void cargarInventario() {
        Datos.cargarInventarioDesdeCSV();
    }

    public static void quitarCantidadProducto(String nombre, int cantidad) {
        try {
            if (cantidad <= 0) {
                throw new IllegalArgumentException("La cantidad debe ser un entero positivo mayor a 0.");
            }
            if (!inventario.containsKey(nombre.toLowerCase())) {
                throw new Exception("Error: No existe un producto con ese nombre en el inventario.");
            }

            Producto producto = inventario.get(nombre.toLowerCase());
            if (producto.getCantidad() < cantidad) {
                throw new Exception("Error: No hay suficiente cantidad del producto en el inventario.");
            }

            producto.setCantidad(producto.getCantidad() - cantidad);
            if (producto.getCantidad() == 0) {
                inventario.remove(nombre.toLowerCase());
            }
            Datos.actualizarCSV();
            System.out.println("Cantidad del producto actualizada con éxito.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void aumentarCantidadProducto(String nombre, int cantidad) {
        try {
            if (cantidad <= 0) {
                throw new IllegalArgumentException("La cantidad debe ser un entero positivo mayor a 0.");
            }
            if (!inventario.containsKey(nombre.toLowerCase())) {
                throw new Exception("Error: No existe un producto con ese nombre en el inventario.");
            }

            Producto producto = inventario.get(nombre.toLowerCase());
            producto.setCantidad(producto.getCantidad() + cantidad);
            Datos.actualizarCSV();
            System.out.println("Cantidad del producto aumentada con éxito.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}