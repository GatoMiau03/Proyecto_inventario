package org.example.Validaciones;

import org.example.Usuarios.Usuario;

import java.io.Console;
import java.util.Map;
import java.util.Scanner;

public class Validacion {

    public static boolean validarNombre(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }

    public static boolean validarNumero(String numero) {
        try {
            Double.parseDouble(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean validarEntero(String numero) {
        try {
            Integer.parseInt(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean validarEnteroPositivo(String numero) {
        if (validarEntero(numero)) {
            int valor = Integer.parseInt(numero);
            return valor > 0;
        }
        return false;
    }
    public static Usuario autenticarUsuario(Map<String, Usuario> usuarios) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nombre de usuario: ");
        String nombre = scanner.nextLine();

        String contrasena = "";
        Console console = System.console();
        if (console == null) {
            System.out.print("Contraseña: ");
            contrasena = scanner.nextLine();
        } else {
            char[] contrasenaArray = console.readPassword("Contraseña: ");
            contrasena = new String(contrasenaArray);
        }

        return autenticar(nombre, contrasena, usuarios);
    }

    private static Usuario autenticar(String nombre, String contrasena, Map<String, Usuario> usuarios) {
        Usuario usuario = usuarios.get(nombre);
        if (usuario != null && usuario.getContrasena().equals(contrasena)) {
            return usuario;
        }
        return null;
    }
}