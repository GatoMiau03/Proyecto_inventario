package org.example.Ventana;

import org.example.Modelo.Inventario;
import org.example.Modelo.Producto;
import org.example.Datos.Datos;
import org.example.Usuarios.Usuario;
import org.example.Usuarios.Login;
import org.example.Usuarios.Rol;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaMostrarInventario extends JFrame {
    private JTable tablaInventario;
    private DefaultTableModel modeloTabla;
    private Usuario usuario;

    public VentanaMostrarInventario(Usuario usuario) {
        this.usuario = usuario;
        setTitle("Inventario de Productos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
        Datos.cargarInventarioDesdeCSV();
        cargarDatosInventario();
    }

    private void initComponents() {
        String[] columnas = {"Nombre", "Precio", "Información Adicional", "Fecha de Ingreso", "Cantidad"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaInventario = new JTable(modeloTabla);

        JScrollPane scrollPane = new JScrollPane(tablaInventario);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        JButton botonAgregar = new JButton("Agregar Producto");
        JButton botonEliminar = new JButton("Eliminar Producto");
        JButton botonQuitarCantidad = new JButton("Quitar Cantidad");
        JButton botonAumentarCantidad = new JButton("Aumentar Cantidad");

        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarProducto();
            }
        });

        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarProducto();
            }
        });

        botonQuitarCantidad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quitarCantidadProducto();
            }
        });

        botonAumentarCantidad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aumentarCantidadProducto();
            }
        });

        panelBotones.add(botonAgregar);
        panelBotones.add(botonEliminar);
        panelBotones.add(botonQuitarCantidad);
        panelBotones.add(botonAumentarCantidad);

        if (usuario.getRol() == Rol.ADMINISTRADOR) {
            JButton botonAgregarVendedor = new JButton("Agregar Vendedor");
            JButton botonEliminarVendedor = new JButton("Eliminar Vendedor");

            botonAgregarVendedor.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    agregarVendedor();
                }
            });

            botonEliminarVendedor.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    eliminarVendedor();
                }
            });

            panelBotones.add(botonAgregarVendedor);
            panelBotones.add(botonEliminarVendedor);
        }

        add(panelBotones, BorderLayout.SOUTH);
    }

    private void cargarDatosInventario() {
        modeloTabla.setRowCount(0); // Limpiar la tabla

        for (Producto producto : Inventario.inventario.values()) {
            Object[] fila = {
                    producto.getNombre(),
                    producto.getPrecio(),
                    producto.getInformacionAdicional(),
                    producto.getFechaIngreso(),
                    producto.getCantidad()
            };
            modeloTabla.addRow(fila);
        }
    }

    private void agregarProducto() {
        // Aquí puedes mostrar un diálogo para ingresar los datos del nuevo producto
        // y luego agregarlo al inventario usando Inventario.agregarProducto(producto);
        // Finalmente, recargar los datos en la tabla con cargarDatosInventario();
    }

    private void eliminarProducto() {
        // Aquí puedes mostrar un diálogo para ingresar el nombre del producto a eliminar
        // y luego eliminarlo del inventario usando Inventario.eliminarProducto(nombre);
        // Finalmente, recargar los datos en la tabla con cargarDatosInventario();
    }

    private void quitarCantidadProducto() {
        // Aquí puedes mostrar un diálogo para ingresar el nombre y la cantidad del producto a quitar
        // y luego actualizar el inventario usando Inventario.quitarCantidadProducto(nombre, cantidad);
        // Finalmente, recargar los datos en la tabla con cargarDatosInventario();
    }

    private void aumentarCantidadProducto() {
        // Aquí puedes mostrar un diálogo para ingresar el nombre y la cantidad del producto a aumentar
        // y luego actualizar el inventario usando Inventario.aumentarCantidadProducto(nombre, cantidad);
        // Finalmente, recargar los datos en la tabla con cargarDatosInventario();
    }

    private void agregarVendedor() {
        // Aquí puedes mostrar un diálogo para ingresar los datos del nuevo vendedor
        // y luego agregarlo usando Login.agregarUsuario(usuario);
    }

    private void eliminarVendedor() {
        // Aquí puedes mostrar un diálogo para ingresar el nombre del vendedor a eliminar
        // y luego eliminarlo usando Login.eliminarUsuario(nombre);
    }

    public static void main(String[] args) {
        Usuario usuario = Login.autenticarUsuario();
        if (usuario != null) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new VentanaMostrarInventario(usuario).setVisible(true);
                }
            });
        } else {
            System.out.println("No se pudo autenticar el usuario.");
        }
    }
}
