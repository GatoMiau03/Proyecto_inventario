package org.example;

import java.util.HashMap;
import java.util.Map;

public class Inventario {
    protected static Map<String, Producto> inventario = new HashMap<>();

    public static void agregarProducto(Producto producto) {
        if (!inventario.containsKey(producto.getNombre().toLowerCase())) {
            inventario.put(producto.getNombre().toLowerCase(), producto);
            Datos.guardarProductoEnCSV(producto);
            System.out.println("Producto agregado con éxito al inventario.");
        } else {
            System.out.println("Error: Ya existe un producto con el mismo nombre en el inventario.");
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

    public static Producto obtenerProducto(String nombre) {
        return inventario.get(nombre.toLowerCase());
    }

    public static void cargarInventario() {
        Datos.cargarInventarioDesdeCSV();
    }

    public static void mostrarInventario() {
        if (inventario.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            System.out.println("Inventario completo:");
            for (Producto producto : inventario.values()) {
                System.out.println(producto);
            }
        }
    }
}
