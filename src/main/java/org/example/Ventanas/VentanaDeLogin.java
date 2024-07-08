package org.example.Ventanas;

import org.example.Usuarios.Login;
import org.example.Usuarios.Rol;
import org.example.Usuarios.Usuario;

import javax.swing.*;
import java.awt.*;

public class VentanaDeLogin extends JFrame {
    private JTextField campoUsuario;
    private JPasswordField campoContraseña;

    public VentanaDeLogin() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel(new GridLayout(3, 2));
        add(panelPrincipal);

        panelPrincipal.add(new JLabel("Usuario:"));
        campoUsuario = new JTextField();
        panelPrincipal.add(campoUsuario);

        panelPrincipal.add(new JLabel("Contraseña:"));
        campoContraseña = new JPasswordField();
        panelPrincipal.add(campoContraseña);

        JButton botonLogin = new JButton("Login");
        panelPrincipal.add(botonLogin);

        botonLogin.addActionListener(e -> {
            String nombreUsuario = campoUsuario.getText();
            String contraseña = new String(campoContraseña.getPassword());

            Usuario usuario = Login.autenticarUsuario(nombreUsuario, contraseña);
            if (usuario != null) {
                JOptionPane.showMessageDialog(this, "Login exitoso");
                dispose();
                if (usuario.getRol() == Rol.ADMINISTRADOR) {
                    new VentanaInicioAdmin(usuario);
                }
                // Aquí puedes agregar otras ventanas para diferentes roles si es necesario
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
            }
        });

        setVisible(true);
    }
}
