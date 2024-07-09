package org.example.Ventanas;

import org.example.Usuarios.Usuario;

import javax.swing.*;
import java.awt.*;

public class VentanaInicioGestor extends JFrame {
    private Usuario usuario;

    public VentanaInicioGestor(Usuario usuario) {
        this.usuario = usuario;
        setTitle("Inicio Gestor de Ventas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel(new GridLayout(4, 1));
        add(panelPrincipal);

        JLabel etiquetaBienvenida = new JLabel("Bienvenido, " + usuario.getNombre(), SwingConstants.CENTER);
        panelPrincipal.add(etiquetaBienvenida);

        JButton botonMostrarInventario = new JButton("Mostrar Inventario");
        botonMostrarInventario.addActionListener(e -> new VentanaMostrarInventario());
        panelPrincipal.add(botonMostrarInventario);

        JButton botonAgregarProducto = new JButton("Agregar Producto");
        botonAgregarProducto.addActionListener(e -> new VentanaAgregarProducto());
        panelPrincipal.add(botonAgregarProducto);

        JButton botonQuitarCantidadProducto = new JButton("Quitar Cantidad de Producto");
        botonQuitarCantidadProducto.addActionListener(e -> new VentanaQuitarCantidadProducto());
        panelPrincipal.add(botonQuitarCantidadProducto);

        JButton botonEliminarProducto = new JButton("Eliminar Producto");
        botonEliminarProducto.addActionListener(e -> new VentanaEliminarProducto());
        panelPrincipal.add(botonEliminarProducto);

        setVisible(true);
    }
}
