package org.example;

public class Launcher {
    public static void main(String[] args) {
        Usuario usuario = Login.autenticarUsuario();

        if (usuario != null) {
            Menu.mostrarMenu(usuario);
        } else {
            System.out.println("No se pudo autenticar el usuario.");
        }
    }
}
