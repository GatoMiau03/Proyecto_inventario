package org.example.Ventanas;

import org.example.Usuarios.Usuario;
import org.example.Usuarios.Rol;

import javax.swing.*;
import java.awt.*;

public class VentanaInicioAdmin extends JFrame {
    private Usuario usuario;

    public VentanaInicioAdmin(Usuario usuario) {
        this.usuario = usuario;
        setTitle("Inicio Administrador");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(panelPrincipal);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.weightx = 0;
        gbc.insets = new Insets(10, 0, 10, 0);

        JLabel etiquetaBienvenida = new JLabel("Bienvenido, " + usuario.getNombre(), SwingConstants.CENTER);
        gbc.gridy = 0;
        panelPrincipal.add(etiquetaBienvenida, gbc);

        Dimension buttonSize = new Dimension(200, 50);

        JButton botonMostrarInventario = new JButton("Mostrar Inventario");
        botonMostrarInventario.setPreferredSize(buttonSize);
        botonMostrarInventario.addActionListener(e -> new VentanaMostrarInventario());
        gbc.gridy = 1;
        panelPrincipal.add(botonMostrarInventario, gbc);

        JButton botonAgregarProducto = new JButton("Agregar Producto");
        botonAgregarProducto.setPreferredSize(buttonSize);
        botonAgregarProducto.addActionListener(e -> new VentanaAgregarProducto());
        gbc.gridy = 2;
        panelPrincipal.add(botonAgregarProducto, gbc);

        JButton botonQuitarCantidadProducto = new JButton("Quitar Cantidad de Producto");
        botonQuitarCantidadProducto.setPreferredSize(buttonSize);
        botonQuitarCantidadProducto.addActionListener(e -> new VentanaQuitarCantidadProducto());
        gbc.gridy = 3;
        panelPrincipal.add(botonQuitarCantidadProducto, gbc);

        JButton botonEliminarProducto = new JButton("Eliminar Producto");
        botonEliminarProducto.setPreferredSize(buttonSize);
        botonEliminarProducto.addActionListener(e -> new VentanaEliminarProducto());
        gbc.gridy = 4;
        panelPrincipal.add(botonEliminarProducto, gbc);

        if (usuario.getRol() == Rol.ADMINISTRADOR) {
            JButton botonAgregarVendedor = new JButton("Agregar Vendedor");
            botonAgregarVendedor.setPreferredSize(buttonSize);
            botonAgregarVendedor.addActionListener(e -> new VentanaAgregarVendedor());
            gbc.gridy = 5;
            panelPrincipal.add(botonAgregarVendedor, gbc);

            JButton botonEliminarVendedor = new JButton("Eliminar Vendedor");
            botonEliminarVendedor.setPreferredSize(buttonSize);
            botonEliminarVendedor.addActionListener(e -> new VentanaEliminarVendedor());
            gbc.gridy = 6;
            panelPrincipal.add(botonEliminarVendedor, gbc);
        }

        setVisible(true);
    }
}
