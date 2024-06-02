package org.example;

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

	@Override
	public String toString() {
		return "Producto{" +
				"nombre='" + nombre + '\'' +
				", precio=" + precio +
				", informacionAdicional='" + informacionAdicional + '\'' +
				", fechaIngreso='" + fechaIngreso + '\'' +
				'}';
	}
}
