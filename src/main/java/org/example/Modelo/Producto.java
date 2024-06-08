package org.example.Modelo;

public class Producto {
	private String nombre;
	private double precio;
	private String informacionAdicional;
	private String fechaIngreso;
	private int cantidad;

	public Producto(String nombre, double precio, String informacionAdicional, String fechaIngreso, int cantidad) {
		this.nombre = nombre.toLowerCase();
		this.precio = precio;
		this.informacionAdicional = informacionAdicional;
		this.fechaIngreso = fechaIngreso;
		this.cantidad = cantidad;
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

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Producto{" +
				"nombre='" + nombre + '\'' +
				", precio=" + precio +
				", informacionAdicional='" + informacionAdicional + '\'' +
				", fechaIngreso='" + fechaIngreso + '\'' +
				", cantidad=" + cantidad +
				'}';
	}
}