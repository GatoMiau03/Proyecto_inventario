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
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columnNames = {"Nombre", "Precio", "Información Adicional", "Fecha de Ingreso", "Cantidad"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);

        for (Map.Entry<String, Producto> entry : Inventario.inventario.entrySet()) {
            Producto producto = entry.getValue();
            Object[] rowData = {
                    producto.getNombre(),
                    producto.getPrecio(),
                    producto.getInformacionAdicional(),
                    producto.getFechaIngreso(),
                    producto.getCantidad()
            };
            tableModel.addRow(rowData);
        }

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}
