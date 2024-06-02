package org.example;

import java.util.HashMap;
import java.util.Map;

public class Login {
	private static Map<String, Usuario> usuarios = new HashMap<>();

	static {
		usuarios.put("admin", new Usuario("admin", "admin123", Rol.ADMINISTRADOR));
		usuarios.put("gestor", new Usuario("gestor", "gestor123", Rol.GESTOR_DE_VENTAS));
	}

	public static Usuario autenticar(String nombre, String contrasena) {
		Usuario usuario = usuarios.get(nombre);
		if (usuario != null && usuario.getContrasena().equals(contrasena)) {
			return usuario;
		} else {
			System.out.println("Usuario o contraseña incorrectos.");
			return null;
		}
	}

	public static void agregarUsuario(Usuario usuario) {
		if (usuarios.containsKey(usuario.getNombre())) {
			System.out.println("Error: El usuario ya existe.");
		} else {
			usuarios.put(usuario.getNombre(), usuario);
			System.out.println("Usuario agregado con éxito.");
		}
	}

	public static void eliminarUsuario(String nombre) {
		if (usuarios.containsKey(nombre)) {
			usuarios.remove(nombre);
			System.out.println("Usuario eliminado con éxito.");
		} else {
			System.out.println("Error: No existe un usuario con ese nombre.");
		}
	}
}
