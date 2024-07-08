package org.example.Usuarios;

import org.example.Datos.Datos;
import org.example.Validaciones.Validacion;

import java.util.Map;

public class Login {

	private static Map<String, Usuario> usuarios;

	static {
		Datos.asegurarArchivosCSV();
		usuarios = Datos.cargarUsuariosDesdeCSV();
	}

	// Método original para autenticar usuario
	public static Usuario autenticarUsuario() {
		return Validacion.autenticarUsuario(usuarios);
	}

	// Nuevo método para autenticar usuario con nombre y contraseña
	public static Usuario autenticarUsuario(String nombreUsuario, String contraseña) {
		Usuario usuario = usuarios.get(nombreUsuario);
		if (usuario != null && usuario.getContrasena().equals(contraseña)) {
			return usuario;
		}
		return null;
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

	// Método para obtener la lista de usuarios
	public static Map<String, Usuario> obtenerUsuarios() {
		return usuarios;
	}
}
