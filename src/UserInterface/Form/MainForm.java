package UserInterface.Form;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import UserInterface.CustomerControl.SebButton;

public class MainForm extends JPanel {
    SebButton btnOp1 = new SebButton("Iniciar Sesión"),
            btnOp2 = new SebButton("Crear Cuenta");
    private JLabel background; // Etiqueta para la imagen de fondo

    public MainForm() {

        customizeComponent();
        btnOp1.addActionListener(e -> showPatPnlPersonaSexo());

        btnOp2.addActionListener(e -> btnOp2Click());
    }

    private void showPatPnlPersonaSexo() {
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

    private void btnOp2Click() {
        JOptionPane.showMessageDialog(this, "Seleccionaste Opción 3");

    }

    private void btnOp3Click() {
        JOptionPane.showMessageDialog(this, "Seleccionaste Opción 3");
    }

    private void customizeComponent() {
        setLayout(new BorderLayout()); // Establece el diseño del MainForm como BorderLayout

        // Carga la imagen de fondo
        ImageIcon backgroundImage = new ImageIcon(
                "src\\Resource\\Img\\ilustracion-pareja-dibujos-animados-dia-san-valentin_82446-122.jpg"); // Cambia la
        // ruta por
        // la
        // ubicación
        // de tu imagen
        background = new JLabel(backgroundImage);

        // Establece el tamaño del fondo para que coincida con el tamaño del MainForm
        background.setPreferredSize(new Dimension(getWidth(), getHeight()));

        // Establece el diseño del fondo como BorderLayout para que cubra todo el
        // MainForm
        background.setLayout(new BorderLayout());

        // Agrega los botones al fondo
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setOpaque(false); // Hace que el panel de botones sea transparente
        buttonsPanel.add(btnOp1);
        buttonsPanel.add(btnOp2);

        // Agrega el panel de botones al centro del fondo
        background.add(buttonsPanel, BorderLayout.CENTER);

        // Agrega el fondo al MainForm
        add(background);
    }
}
