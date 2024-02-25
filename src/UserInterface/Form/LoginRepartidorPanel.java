package UserInterface.Form; // Define el paquete donde se encuentra la clase LoginPanel

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import UserInterface.CustomerControl.SebButton;
import UserInterface.CustomerControl.SebLabel;

public class LoginRepartidorPanel extends JPanel {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private SebButton loginButton;
    private Image backgroundImage;
    private SebButton btnRegresar;

    public LoginRepartidorPanel() {
        initializeComponents();
        setupLayout();
        setupActions();
        loadImage();
    }

    private void initializeComponents() {
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new SebButton("Login");
        loginButton.setPreferredSize(new Dimension(200, 50));
        btnRegresar = new SebButton("Regresar");

    }

    private void setupLayout() {
        setLayout(new BorderLayout());

        JPanel panerIncicioSesion = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 100));
        panerIncicioSesion.setOpaque(false);
        panerIncicioSesion.add(new SebLabel("Usuario:"));
        panerIncicioSesion.add(usernameField);
        panerIncicioSesion.add(new SebLabel("Contraseña:"));
        panerIncicioSesion.add(passwordField);
        panerIncicioSesion.add(loginButton);

        add(panerIncicioSesion, BorderLayout.CENTER);
        JPanel panelRegresar = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Nuevo panel para el botón "Regresar"
        panelRegresar.setOpaque(false); // Hacer transparente el panel

        panelRegresar.add(btnRegresar); // Agregar el botón "Regresar" al panel

        add(panelRegresar, BorderLayout.SOUTH);
    }

    private void setupActions() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();

                JOptionPane.showMessageDialog(LoginRepartidorPanel.this,
                        "Usuario: " + username + "\nContraseña: " + new String(password),
                        "Login Exitoso", JOptionPane.INFORMATION_MESSAGE);

                usernameField.setText("");
                passwordField.setText("");
            }
        });
        btnRegresar.addActionListener(e -> RolPanel());

    }

    private void RolPanel() {
        try {
            removeAll();
            add(new RolPanel());
            revalidate();
            repaint();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar PatPnlPersonaSexo",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadImage() {
        ImageIcon imagenFondo = new ImageIcon(
                "src\\Resource\\Img\\RepartidorFoto.png");
        backgroundImage = imagenFondo.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

    // @Override
    // public Dimension getPreferredSize() {
    // return new Dimension(600, 400); // Establece el tamaño preferido del panel
    // }
}
