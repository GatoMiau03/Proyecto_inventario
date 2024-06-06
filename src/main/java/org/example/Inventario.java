package org.example;

import java.util.HashMap;
import java.util.Map;

public class Inventario {
    protected static Map<String, Producto> inventario = new HashMap<>();

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
            System.out.printf("%-20s %-10s %-20s %-15s %-10s%n", "Nombre", "Precio", "Información Adicional", "Fecha de Ingreso", "Cantidad");
            System.out.println("--------------------------------------------------------------------------------------------");
            for (Producto producto : inventario.values()) {
                System.out.printf("%-20s %-10d %-20s %-15s %-10d%n",
                        producto.getNombre(),
                        (int) producto.getPrecio(),
                        producto.getInformacionAdicional(),
                        producto.getFechaIngreso(),
                        producto.getCantidad());
            }
        }
    }

    public static void quitarCantidadProducto(String nombre, int cantidad) {
        try {
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
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
