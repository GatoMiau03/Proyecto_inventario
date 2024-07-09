package org.example;

import org.example.Datos.Datos;
import org.example.Modelo.Inventario;
import org.example.Usuarios.Usuario;
import org.example.Ventanas.VentanaDeLogin;

import javax.swing.*;

public class Launcher {

    public static void main(String[] args) {
        Datos.asegurarArchivosCSV();

        Datos.cargarInventarioDesdeCSV();
        Datos.cargarUsuariosDesdeCSV();

        SwingUtilities.invokeLater(() -> {
            new VentanaDeLogin();
        });
    }
}
