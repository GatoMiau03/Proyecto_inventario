package org.example.Ventanas;

import org.example.Usuarios.Login;
import org.example.Usuarios.Usuario;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class VentanaEliminarVendedor extends JFrame {

    public VentanaEliminarVendedor() {
        setTitle("Eliminar Vendedor");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel(new GridLayout(3, 1));
        add(panelPrincipal);

        JLabel etiquetaTitulo = new JLabel("Eliminar Vendedor", SwingConstants.CENTER);
        panelPrincipal.add(etiquetaTitulo);

        // Obtener la lista de usuarios
        Map<String, Usuario> usuarios = Login.obtenerUsuarios();

        // Crear un JComboBox con los nombres de usuarios
        JComboBox<String> comboBoxUsuarios = new JComboBox<>(usuarios.keySet().toArray(new String[0]));
        panelPrincipal.add(comboBoxUsuarios);

        JButton botonEliminar = new JButton("Eliminar Vendedor");
        botonEliminar.addActionListener(e -> {
            String nombreUsuario = (String) comboBoxUsuarios.getSelectedItem();
            Login.eliminarUsuario(nombreUsuario);
            JOptionPane.showMessageDialog(this, "Usuario eliminado exitosamente");
            dispose(); // Cerrar la ventana después de eliminar
        });
        panelPrincipal.add(botonEliminar);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaEliminarVendedor());
    }
}
