package org.example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Producto {
	private String nombre;
	private double precio;
	private String informacionAdicional;
	private String fechaIngreso;

	public Producto(String nombre, double precio, String informacionAdicional, String fechaIngreso) {
		this.nombre = nombre.toLowerCase();
		this.precio = precio;
		this.informacionAdicional = informacionAdicional;
		this.fechaIngreso = fechaIngreso;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public String getInformacionAdicional() {
		return informacionAdicional;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public static void agregarProducto(String nombre, double precio, String informacionAdicional) {
		if (!existeProducto(nombre.toLowerCase())) {
			Producto producto = new Producto(nombre, precio, informacionAdicional, obtenerFechaActual());
			inventario.put(nombre.toLowerCase(), producto);
			Datos.guardarProductoEnCSV(producto);
			System.out.println("Producto agregado con éxito al inventario.");
		} else {
			System.out.println("Error: Ya existe un producto con el mismo nombre en el inventario.");
		}
	}

	public static void eliminarProducto(String nombre) {
		if (existeProducto(nombre.toLowerCase())) {
			inventario.remove(nombre.toLowerCase());
			System.out.println("Producto eliminado con éxito del inventario.");
		} else {
			System.out.println("Error: No existe un producto con ese nombre en el inventario.");
		}
	}

	public static boolean existeProducto(String nombre) {
		return inventario.containsKey(nombre.toLowerCase());
	}

	private static String obtenerFechaActual() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return formatter.format(date);
	}

	public static void agregarAlInventario(Producto producto) {
		inventario.put(producto.getNombre().toLowerCase(), producto);
	}

	private static Map<String, Producto> inventario = new HashMap<>();
}
