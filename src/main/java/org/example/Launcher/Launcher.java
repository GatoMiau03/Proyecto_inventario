package org.example.Launcher;

import org.example.Datos.Datos;
import org.example.Usuarios.Login;
import org.example.Menu.Menu;
import org.example.Usuarios.Usuario;

public class Launcher {
    public static void main(String[] args) {
        Datos.asegurarArchivosCSV();
        Usuario usuario = Login.autenticarUsuario();

        if (usuario != null) {
            Menu.mostrarMenu(usuario);
        } else {
            System.out.println("No se pudo autenticar el usuario.");
        }
    }
}