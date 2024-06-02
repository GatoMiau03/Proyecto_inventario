package org.example;

import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nombre de usuario: ");
        String nombre = scanner.nextLine();

        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();

        Usuario usuario = Login.autenticar(nombre, contrasena);

        if (usuario != null) {
            Menu.mostrarMenu(usuario);
        } else {
            System.out.println("No se pudo autenticar el usuario.");
        }

        scanner.close();
    }
}
