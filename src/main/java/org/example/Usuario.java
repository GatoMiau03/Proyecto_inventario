package org.example;

public class Usuario {
	private String nombre;
	private String contrasena;
	private Rol rol;

	public Usuario(String nombre, String contrasena, Rol rol) {
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.rol = rol;
	}

	public String getNombre() {
		return nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public Rol getRol() {
		return rol;
	}

	@Override
	public String toString() {
		return "Usuario{" +
				"nombre='" + nombre + '\'' +
				", rol=" + rol +
				'}';
	}
}
