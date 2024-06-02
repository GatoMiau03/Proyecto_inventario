package org.example;

public class Validacion {

    public static boolean validarNombre(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }

    public static boolean validarPrecio(String precio) {
        try {
            Double.parseDouble(precio);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
