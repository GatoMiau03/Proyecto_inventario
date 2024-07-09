package org.example.Ventanas;

import org.example.Modelo.Inventario;

import javax.swing.*;
import java.awt.*;

public class VentanaEliminarProducto extends JFrame {
    public VentanaEliminarProducto() {
        setTitle("Eliminar Producto");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2));
        add(panel);

        JLabel etiquetaNombreProducto = new JLabel("Nombre del producto:");
        JTextField campoNombreProducto = new JTextField();
        panel.add(etiquetaNombreProducto);
        panel.add(campoNombreProducto);

        JButton botonEliminar = new JButton("Eliminar");
        panel.add(new JLabel());
        panel.add(botonEliminar);

        JLabel etiquetaResultado = new JLabel("", SwingConstants.CENTER);
        panel.add(new JLabel());
        panel.add(etiquetaResultado);

        botonEliminar.addActionListener(e -> {
            String nombreProducto = campoNombreProducto.getText().trim();
            if (!nombreProducto.isEmpty()) {
                Inventario.eliminarProducto(nombreProducto);
                etiquetaResultado.setText("Producto eliminado exitosamente.");
            } else {
                etiquetaResultado.setText("Por favor, ingrese un nombre de producto.");
            }
        });

        setVisible(true);
    }
}
