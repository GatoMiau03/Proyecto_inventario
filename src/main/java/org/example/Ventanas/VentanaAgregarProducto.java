package org.example.Ventanas;

import org.example.Modelo.Inventario;
import org.example.Modelo.Producto;

import javax.swing.*;
import java.awt.*;

public class VentanaAgregarProducto extends JFrame {
    private JTextField campoNombre;
    private JTextField campoPrecio;
    private JTextField campoInformacionAdicional;
    private JTextField campoFechaIngreso;
    private JTextField campoCantidad;

    public VentanaAgregarProducto() {
        setTitle("Agregar Producto");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel(new GridLayout(6, 2));
        add(panelPrincipal);

        panelPrincipal.add(new JLabel("Nombre:"));
        campoNombre = new JTextField();
        panelPrincipal.add(campoNombre);

        panelPrincipal.add(new JLabel("Precio:"));
        campoPrecio = new JTextField();
        panelPrincipal.add(campoPrecio);

        panelPrincipal.add(new JLabel("Información Adicional:"));
        campoInformacionAdicional = new JTextField();
        panelPrincipal.add(campoInformacionAdicional);

        panelPrincipal.add(new JLabel("Fecha de Ingreso (dd/MM/yyyy):"));
        campoFechaIngreso = new JTextField();
        panelPrincipal.add(campoFechaIngreso);

        panelPrincipal.add(new JLabel("Cantidad:"));
        campoCantidad = new JTextField();
        panelPrincipal.add(campoCantidad);

        JButton botonAgregar = new JButton("Agregar");
        panelPrincipal.add(botonAgregar);

        panelPrincipal.add(new JLabel());

        botonAgregar.addActionListener(e -> {
            String nombre = campoNombre.getText();
            double precio = Double.parseDouble(campoPrecio.getText());
            String informacionAdicional = campoInformacionAdicional.getText();
            String fechaIngreso = campoFechaIngreso.getText();
            int cantidad = Integer.parseInt(campoCantidad.getText());

            Producto nuevoProducto = new Producto(nombre, precio, informacionAdicional, fechaIngreso, cantidad);
            Inventario.agregarProducto(nuevoProducto);

            JOptionPane.showMessageDialog(this, "Producto agregado exitosamente.");
            dispose();
        });

        setVisible(true);
    }
}
