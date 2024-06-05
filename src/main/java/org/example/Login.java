package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Login {
	private static Map<String, Usuario> usuarios = new HashMap<>();

	static {
		// Usuarios por defecto
		usuarios.put("gestor", new Usuario("gestor", "gestor123", Rol.GESTOR_DE_VENTAS));
		usuarios.put("admin", new Usuario("admin", "admin123", Rol.ADMINISTRADOR));
	}

	public static Usuario autenticarUsuario() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Nombre de usuario: ");
		String nombre = scanner.nextLine();

		System.out.print("Contraseña: ");
		String contrasena = scanner.nextLine();

		Usuario usuario = autenticar(nombre, contrasena);

		return usuario;
	}

	private static Usuario autenticar(String nombre, String contrasena) {
		Usuario usuario = usuarios.get(nombre);
		if (usuario != null && usuario.getContrasena().equals(contrasena)) {
			return usuario;
		}
		return null;
	}

	public static void agregarUsuario(Usuario usuario) {
		if (!usuarios.containsKey(usuario.getNombre())) {
			usuarios.put(usuario.getNombre(), usuario);
		} else {
			System.out.println("Error: Ya existe un usuario con el mismo nombre.");
		}
	}

	public static void eliminarUsuario(String nombre) {
		if (usuarios.containsKey(nombre)) {
			usuarios.remove(nombre);
		} else {
			System.out.println("Error: No existe un usuario con ese nombre.");
		}
	}
}
