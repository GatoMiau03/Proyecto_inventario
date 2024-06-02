package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Datos {

	public static void guardarProductoEnCSV(Producto producto) {
		try (FileWriter writer = new FileWriter("productos.csv", true)) {
			writer.append(producto.getNombre())
					.append(",")
					.append(String.valueOf(producto.getPrecio()))
					.append(",")
					.append(producto.getInformacionAdicional())
					.append(",")
					.append(producto.getFechaIngreso())
					.append("\n");
		} catch (IOException e) {
			System.out.println("Error al guardar el producto en el archivo CSV.");
			e.printStackTrace();
		}
	}

	public static void cargarInventarioDesdeCSV() {
		String archivoCSV = "productos.csv";
		String linea;

		try (BufferedReader reader = new BufferedReader(new FileReader(archivoCSV))) {
			while ((linea = reader.readLine()) != null) {
				String[] campos = linea.split(",");
				if (campos.length == 4) {
					String nombre = campos[0];
					double precio = Double.parseDouble(campos[1]);
					String informacionAdicional = campos[2];
					String fechaIngreso = campos[3];
					Producto producto = new Producto(nombre, precio, informacionAdicional, fechaIngreso);
					Producto.agregarAlInventario(producto);
				}
			}
			System.out.println("Inventario cargado desde el archivo CSV.");
		} catch (IOException e) {
			System.out.println("Error al cargar el inventario desde el archivo CSV.");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("Error en el formato del precio en el archivo CSV.");
			e.printStackTrace();
		}
	}
}
