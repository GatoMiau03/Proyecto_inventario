package org.example.Ventanas;

import org.example.Modelo.Inventario;

import javax.swing.*;
import java.awt.*;

public class VentanaQuitarCantidadProducto extends JFrame {
    public VentanaQuitarCantidadProducto() {
        setTitle("Quitar Cantidad de Producto");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2));
        add(panel);

        JLabel etiquetaNombreProducto = new JLabel("Nombre del producto:");
        JTextField campoNombreProducto = new JTextField();
        panel.add(etiquetaNombreProducto);
        panel.add(campoNombreProducto);

        JLabel etiquetaCantidad = new JLabel("Cantidad a quitar:");
        JTextField campoCantidad = new JTextField();
        panel.add(etiquetaCantidad);
        panel.add(campoCantidad);

        JButton botonQuitar = new JButton("Quitar");
        panel.add(new JLabel());  // Añadir un componente vacío para centrar el botón
        panel.add(botonQuitar);

        JLabel etiquetaResultado = new JLabel("", SwingConstants.CENTER);
        panel.add(new JLabel());  // Añadir un componente vacío
        panel.add(etiquetaResultado);

        botonQuitar.addActionListener(e -> {
            String nombreProducto = campoNombreProducto.getText().trim();
            String cantidadTexto = campoCantidad.getText().trim();
            if (!nombreProducto.isEmpty() && !cantidadTexto.isEmpty()) {
                try {
                    int cantidad = Integer.parseInt(cantidadTexto);
                    try {
                        Inventario.quitarCantidadProducto(nombreProducto, cantidad);
                        etiquetaResultado.setText("Cantidad quitada exitosamente.");
                    } catch (Exception ex) {
                        etiquetaResultado.setText("No se pudo quitar la cantidad. Verifique el nombre del producto y la cantidad.");
                    }
                } catch (NumberFormatException ex) {
                    etiquetaResultado.setText("Por favor, ingrese un número válido.");
                }
            } else {
                etiquetaResultado.setText("Por favor, complete todos los campos.");
            }
        });

        setVisible(true);
    }
}
