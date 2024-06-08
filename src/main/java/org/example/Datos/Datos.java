package org.example.Datos;

import org.example.Modelo.Inventario;
import org.example.Modelo.Producto;
import org.example.Usuarios.Rol;
import org.example.Usuarios.Usuario;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Datos {

	public static void asegurarArchivosCSV() {
		asegurarArchivoCSV("productos.csv");
		asegurarArchivoCSV("usuarios.csv");
	}

	private static void asegurarArchivoCSV(String nombreArchivo) {
		File archivoCSV = new File(nombreArchivo);
		if (!archivoCSV.exists()) {
			try {
				archivoCSV.createNewFile();
				System.out.println("Archivo " + nombreArchivo + " creado.");
			} catch (IOException e) {
				System.out.println("Error al crear el archivo " + nombreArchivo + ".");
				e.printStackTrace();
			}
		}
	}

	public static void guardarProductoEnCSV(Producto producto) {
		try (FileWriter writer = new FileWriter("productos.csv", true)) {
			writer.append(producto.getNombre())
					.append(",")
					.append(String.valueOf(producto.getPrecio()))
					.append(",")
					.append(producto.getInformacionAdicional())
					.append(",")
					.append(producto.getFechaIngreso())
					.append(",")
					.append(String.valueOf(producto.getCantidad()))
					.append("\n");
		} catch (IOException e) {
			System.out.println("Error al guardar el producto en el archivo CSV.");
			e.printStackTrace();
		}
	}

	public static void cargarInventarioDesdeCSV() {
		String archivoCSV = "productos.csv";
		String linea;

		Map<String, Producto> productosTemp = new HashMap<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(archivoCSV))) {
			while ((linea = reader.readLine()) != null) {
				String[] campos = linea.split(",");
				if (campos.length == 5) {
					String nombre = campos[0];
					double precio = Double.parseDouble(campos[1]);
					String informacionAdicional = campos[2];
					String fechaIngreso = campos[3];
					int cantidad = Integer.parseInt(campos[4]);

					if (productosTemp.containsKey(nombre.toLowerCase())) {
						Producto productoExistente = productosTemp.get(nombre.toLowerCase());
						productoExistente.setCantidad(productoExistente.getCantidad() + cantidad);
					} else {
						Producto producto = new Producto(nombre, precio, informacionAdicional, fechaIngreso, cantidad);
						productosTemp.put(nombre.toLowerCase(), producto);
					}
				}
			}
			Inventario.inventario.clear();
			Inventario.inventario.putAll(productosTemp);
			System.out.println("Inventario cargado desde el archivo CSV.");
		} catch (IOException e) {
			System.out.println("Error al cargar el inventario desde el archivo CSV.");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("Error en el formato del archivo CSV.");
			e.printStackTrace();
		}
	}

	public static void actualizarCSV() {
		try (FileWriter writer = new FileWriter("productos.csv", false)) {
			for (Producto producto : Inventario.inventario.values()) {
				writer.append(producto.getNombre())
						.append(",")
						.append(String.valueOf(producto.getPrecio()))
						.append(",")
						.append(producto.getInformacionAdicional())
						.append(",")
						.append(producto.getFechaIngreso())
						.append(",")
						.append(String.valueOf(producto.getCantidad()))
						.append("\n");
			}
		} catch (IOException e) {
			System.out.println("Error al actualizar el archivo CSV.");
			e.printStackTrace();
		}
	}

	public static void guardarUsuarioEnCSV(Usuario usuario) {
		try (FileWriter writer = new FileWriter("usuarios.csv", true)) {
			writer.append(usuario.getNombre())
					.append(",")
					.append(usuario.getContrasena())
					.append(",")
					.append(usuario.getRol().name())
					.append("\n");
		} catch (IOException e) {
			System.out.println("Error al guardar el usuario en el archivo CSV.");
			e.printStackTrace();
		}
	}

	public static Map<String, Usuario> cargarUsuariosDesdeCSV() {
		String archivoCSV = "usuarios.csv";
		String linea;
		Map<String, Usuario> usuariosTemp = new HashMap<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(archivoCSV))) {
			while ((linea = reader.readLine()) != null) {
				String[] campos = linea.split(",");
				if (campos.length == 3) {
					String nombre = campos[0];
					String contrasena = campos[1];
					Rol rol = null;
					try {
						rol = Rol.valueOf(campos[2].toUpperCase());
					} catch (IllegalArgumentException e) {
						System.out.println("Error: Rol no válido en el archivo CSV para el usuario " + nombre);
					}

					if (rol != null) {
						Usuario usuario = new Usuario(nombre, contrasena, rol);
						usuariosTemp.put(nombre, usuario);
					}
				}
			}
		} catch (IOException e) {
			System.out.println("Error al cargar los usuarios desde el archivo CSV.");
			e.printStackTrace();
		}

		return usuariosTemp;
	}

	public static void actualizarUsuariosCSV(Map<String, Usuario> usuarios) {
		try (FileWriter writer = new FileWriter("usuarios.csv", false)) {
			for (Usuario usuario : usuarios.values()) {
				writer.append(usuario.getNombre())
						.append(",")
						.append(usuario.getContrasena())
						.append(",")
						.append(usuario.getRol().name())
						.append("\n");
			}
		} catch (IOException e) {
			System.out.println("Error al actualizar el archivo CSV de usuarios.");
			e.printStackTrace();
		}
	}
}
