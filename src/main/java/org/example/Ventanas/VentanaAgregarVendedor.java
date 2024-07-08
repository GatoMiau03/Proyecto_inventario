package org.example.Ventanas;

import org.example.Usuarios.Login;
import org.example.Usuarios.Usuario;
import org.example.Usuarios.Rol;
import org.example.Modelo.Inventario;

import javax.swing.*;
import java.awt.*;

public class VentanaAgregarVendedor extends JFrame {
    public VentanaAgregarVendedor() {
        setTitle("Agregar Vendedor");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        add(panel);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        JLabel etiquetaUsuario = new JLabel("Usuario:");
        panel.add(etiquetaUsuario, gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField campoUsuario = new JTextField(15);
        panel.add(campoUsuario, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        JLabel etiquetaContrasena = new JLabel("Contraseña:");
        panel.add(etiquetaContrasena, gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JPasswordField campoContrasena = new JPasswordField(15);
        panel.add(campoContrasena, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel etiquetaConfirmarContrasena = new JLabel("Confirmar Contraseña:");
        panel.add(etiquetaConfirmarContrasena, gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JPasswordField campoConfirmarContrasena = new JPasswordField(15);
        panel.add(campoConfirmarContrasena, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        JButton botonAgregar = new JButton("Agregar");
        panel.add(botonAgregar, gbc);

        gbc.gridy = 4;
        JLabel etiquetaResultado = new JLabel("", SwingConstants.CENTER);
        panel.add(etiquetaResultado, gbc);

        botonAgregar.addActionListener(e -> {
            String usuario = campoUsuario.getText().trim();
            String contrasena = new String(campoContrasena.getPassword()).trim();
            String confirmarContrasena = new String(campoConfirmarContrasena.getPassword()).trim();

            if (!usuario.isEmpty() && !contrasena.isEmpty() && !confirmarContrasena.isEmpty()) {
                if (contrasena.equals(confirmarContrasena)) {
                    Usuario nuevoVendedor = new Usuario(usuario, contrasena, Rol.GESTOR_DE_VENTAS);
                    // Aquí deberías añadir la lógica para guardar la contraseña del vendedor si es necesario
                    try {
                        Login.agregarUsuario(nuevoVendedor); // Asumiendo que Inventario tiene un método agregarUsuario
                        etiquetaResultado.setText("Vendedor agregado exitosamente.");
                    } catch (Exception ex) {
                        etiquetaResultado.setText("Error al agregar el vendedor.");
                    }
                } else {
                    etiquetaResultado.setText("Las contraseñas no coinciden.");
                }
            } else {
                etiquetaResultado.setText("Por favor, complete todos los campos.");
            }
        });

        setVisible(true);
    }
}
