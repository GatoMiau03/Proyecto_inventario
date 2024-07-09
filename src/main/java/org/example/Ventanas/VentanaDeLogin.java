package org.example.Ventanas;

import org.example.Usuarios.Login;
import org.example.Usuarios.Rol;
import org.example.Usuarios.Usuario;

import javax.swing.*;
import java.awt.*;

public class VentanaDeLogin extends JFrame {
    public VentanaDeLogin() {
        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2));
        add(panel);

        JLabel usuarioLabel = new JLabel("Usuario:");
        JTextField usuarioField = new JTextField();
        JLabel contrasenaLabel = new JLabel("Contraseña:");
        JPasswordField contrasenaField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> {
            String nombreUsuario = usuarioField.getText();
            String contraseña = new String(contrasenaField.getPassword());
            Usuario usuarioAutenticado = Login.autenticarUsuario(nombreUsuario, contraseña);

            if (usuarioAutenticado != null) {
                if (usuarioAutenticado.getRol() == Rol.ADMINISTRADOR) {
                    new VentanaInicioAdmin(usuarioAutenticado);
                } else if (usuarioAutenticado.getRol() == Rol.GESTOR_DE_VENTAS) {
                    new VentanaInicioGestor(usuarioAutenticado);
                } else {
                    JOptionPane.showMessageDialog(this, "Rol desconocido: " + usuarioAutenticado.getRol());
                }
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Autenticación fallida.");
            }
        });

        panel.add(usuarioLabel);
        panel.add(usuarioField);
        panel.add(contrasenaLabel);
        panel.add(contrasenaField);
        panel.add(new JLabel());
        panel.add(loginButton);

        setVisible(true);
    }
}
