package org.example.Ventanas;

import org.example.Modelo.Inventario;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
package org.example.Ventanas;

import org.example.Modelo.Inventario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEliminarProducto extends JFrame {

    public VentanaEliminarProducto() {
        setTitle("Eliminar Producto");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel label = new JLabel("Nombre del producto:");
        label.setBounds(10, 20, 150, 25);
        add(label);

        JTextField nombreField = new JTextField();
        nombreField.setBounds(160, 20, 120, 25);
        add(nombreField);

        JButton eliminarButton = new JButton("Eliminar");
        eliminarButton.setBounds(90, 60, 100, 30);
        add(eliminarButton);

        JLabel resultadoLabel = new JLabel("");
        resultadoLabel.setBounds(10, 100, 280, 25);
        add(resultadoLabel);

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText().trim();
                if (!nombre.isEmpty()) {
                    if (Inventario.inventario.containsKey(nombre.toLowerCase())) {
                        Inventario.eliminarProducto(nombre);
                        resultadoLabel.setText("Producto eliminado con éxito.");
                    } else {
                        resultadoLabel.setText("Error: Producto no encontrado.");
                    }
                } else {
                    resultadoLabel.setText("Error: El nombre no puede estar vacío.");
                }
            }
        });

        setVisible(true);
    }
}
