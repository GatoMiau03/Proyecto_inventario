package org.example.Ventanas;

import org.example.Modelo.Inventario;
import org.example.Modelo.Producto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Map;

public class VentanaMostrarInventario extends JFrame {
    public VentanaMostrarInventario() {
        setTitle("Inventario");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear el panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        add(panelPrincipal);

        // Crear el modelo de tabla con los datos del inventario
        String[] columnas = {"Nombre", "Precio", "Información Adicional", "Fecha de Ingreso", "Cantidad"};
        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);

        // Llenar el modelo de tabla con los datos del inventario
        for (Map.Entry<String, Producto> entry : Inventario.inventario.entrySet()) {
            Producto producto = entry.getValue();
            Object[] fila = {producto.getNombre(), producto.getPrecio(), producto.getInformacionAdicional(), producto.getFechaIngreso(), producto.getCantidad()};
            modeloTabla.addRow(fila);
        }

        // Crear la tabla con el modelo
        JTable tablaInventario = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaInventario);
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);

        // Crear el panel de botones
        JPanel panelBotones = new JPanel();
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        // Crear y agregar botones
        JButton botonAgregarProducto = new JButton("Agregar Producto");
        JButton botonEliminarProducto = new JButton("Eliminar Producto");
        JButton botonQuitarCantidad = new JButton("Quitar Cantidad");
        JButton botonAumentarCantidad = new JButton("Aumentar Cantidad");
        JButton botonAgregarVendedor = new JButton("Agregar Vendedor");
        JButton botonEliminarVendedor = new JButton("Eliminar Vendedor");

        panelBotones.add(botonAgregarProducto);
        panelBotones.add(botonEliminarProducto);
        panelBotones.add(botonQuitarCantidad);
        panelBotones.add(botonAumentarCantidad);
        panelBotones.add(botonAgregarVendedor);
        panelBotones.add(botonEliminarVendedor);

        // Asignar ActionListeners a los botones
        botonAgregarProducto.addActionListener(e -> {
            // Lógica para agregar producto
        });

        botonEliminarProducto.addActionListener(e -> {
            // Lógica para eliminar producto
        });

        botonQuitarCantidad.addActionListener(e -> {
            // Lógica para quitar cantidad de producto
        });

        botonAumentarCantidad.addActionListener(e -> {
            // Lógica para aumentar cantidad de producto
        });

        botonAgregarVendedor.addActionListener(e -> {
            // Lógica para agregar vendedor
        });

        botonEliminarVendedor.addActionListener(e -> {
            // Lógica para eliminar vendedor
        });

        // Hacer visible la ventana
        setVisible(true);
    }
}
