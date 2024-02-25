package UserInterface.Form; // Define el paquete donde se encuentra la clase LoginPanel

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import UserInterface.CustomerControl.SebButton;

public class RolPanel extends JPanel {

    private SebButton btnUsuario;
    private SebButton btnAdministrador;
    private SebButton btnRepartidor;
    private Image backgroundImage;
    private SebButton btnRegresar;

    public RolPanel() {
        initializeComponents();
        setupLayout();
        setupActions();
        loadImage();
    }

    private void initializeComponents() {
        btnUsuario = new SebButton("Usuario");
        btnAdministrador = new SebButton("Administrador");
        btnRepartidor = new SebButton("Repartidor");
        btnUsuario.setPreferredSize(new Dimension(200, 50));
        btnAdministrador.setPreferredSize(new Dimension(200, 50));
        btnRepartidor.setPreferredSize(new Dimension(200, 50));
        btnRegresar = new SebButton("Regresar");
    }

    private void setupLayout() {
        setLayout(new BorderLayout());

        JPanel panerIncicioSesion = new JPanel(new FlowLayout(FlowLayout.CENTER, 300, 270));
        panerIncicioSesion.setOpaque(false);
        JPanel btnPanel = new JPanel();
        btnPanel.setOpaque(false); // Hace que el panel de botones sea transparente
        btnPanel.add(btnUsuario);
        btnPanel.add(btnAdministrador);
        btnPanel.add(btnRepartidor);
        panerIncicioSesion.add(btnPanel);
        add(panerIncicioSesion, BorderLayout.CENTER);
        JPanel panelRegresar = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Nuevo panel para el botón "Regresar"
        panelRegresar.setOpaque(false); // Hacer transparente el panel

        panelRegresar.add(btnRegresar); // Agregar el botón "Regresar" al panel

        add(panelRegresar, BorderLayout.SOUTH); // Agregar el panel de "Regresar" en la parte inferior
    }

    private void setupActions() {
        btnUsuario.addActionListener(e -> LoginPanel());

        btnAdministrador.addActionListener(e -> LoginAdminPanel());
        btnRepartidor.addActionListener(e -> LoginRepartidorPanel());
        btnRegresar.addActionListener(e -> MainForm());
    }

    private void MainForm() {
        try {
            removeAll();
            add(new MainForm());
            revalidate();
            repaint();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar PatPnlPersonaSexo",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void LoginRepartidorPanel() {
        try {
            removeAll();
            add(new LoginRepartidorPanel());
            revalidate();
            repaint();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar PatPnlPersonaSexo",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void LoginAdminPanel() {
        try {
            removeAll();
            add(new LoginAdminPanel());
            revalidate();
            repaint();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar PatPnlPersonaSexo",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void LoginPanel() {
        try {
            removeAll();
            add(new LoginPanel());
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
                "src\\Resource\\Img\\RolFondo.png");
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
