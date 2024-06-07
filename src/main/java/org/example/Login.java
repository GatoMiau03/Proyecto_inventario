package org.example;

import java.util.Map;

public class Login {

	private static Map<String, Usuario> usuarios;

	static {
		Datos.asegurarArchivosCSV();
		usuarios = Datos.cargarUsuariosDesdeCSV();
	}

	public static Usuario autenticarUsuario() {
		return Validacion.autenticarUsuario(usuarios);
	}

	public static void agregarUsuario(Usuario usuario) {
		if (!usuarios.containsKey(usuario.getNombre())) {
			usuarios.put(usuario.getNombre(), usuario);
			Datos.guardarUsuarioEnCSV(usuario);
		} else {
			System.out.println("Error: Ya existe un usuario con el mismo nombre.");
		}
	}

	public static void eliminarUsuario(String nombre) {
		if (usuarios.containsKey(nombre)) {
			usuarios.remove(nombre);
			Datos.actualizarUsuariosCSV(usuarios);
		} else {
			System.out.println("Error: No existe un usuario con ese nombre.");
		}
	}
}
