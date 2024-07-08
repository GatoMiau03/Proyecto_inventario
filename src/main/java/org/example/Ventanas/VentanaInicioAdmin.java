package org.example.Ventanas;

import org.example.Usuarios.Usuario;

import javax.swing.*;
import java.awt.*;

public class VentanaInicioAdmin extends JFrame {
    private Usuario usuario;

    public VentanaInicioAdmin(Usuario usuario) {
        this.usuario = usuario;
        setTitle("Inicio Administrador");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel(new GridLayout(5, 1)); // Cambiar el GridLayout para 5 filas
        add(panelPrincipal);

        JLabel etiquetaBienvenida = new JLabel("Bienvenido, " + usuario.getNombre(), SwingConstants.CENTER);
        panelPrincipal.add(etiquetaBienvenida);

        JButton botonMostrarInventario = new JButton("Mostrar Inventario");
        botonMostrarInventario.addActionListener(e -> new VentanaMostrarInventario());
        panelPrincipal.add(botonMostrarInventario);

        JButton botonAgregarProducto = new JButton("Agregar Producto");
        botonAgregarProducto.addActionListener(e -> new VentanaAgregarProducto());
        panelPrincipal.add(botonAgregarProducto);

        JButton botonEliminarProducto = new JButton("Eliminar Producto");
        botonEliminarProducto.addActionListener(e -> new VentanaEliminarProducto());
        panelPrincipal.add(botonEliminarProducto);

        JButton botonQuitarCantidadProducto = new JButton("Quitar Cantidad de Producto"); // Nuevo botón para quitar cantidad de producto
        botonQuitarCantidadProducto.addActionListener(e -> new VentanaQuitarCantidadProducto());
        panelPrincipal.add(botonQuitarCantidadProducto);

        setVisible(true);
    }
}
