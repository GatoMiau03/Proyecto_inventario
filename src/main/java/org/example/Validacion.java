package org.example;

public class Validacion {

    public static boolean validarNombre(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }

    public static boolean validarPrecio(double precio) {
        return precio > 0;
    }
}
