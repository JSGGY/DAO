package UserInterface.Form;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import UserInterface.CustomerControl.SebButton;

public class MainForm extends JPanel {
    SebButton bton1 = new SebButton("Iniciar Sesión"),
            bton2 = new SebButton("Crear Cuenta");
    private JLabel background; // Etiqueta para la imagen de fondo

    public MainForm() {

        customizeComponent();
        bton1.addActionListener(e -> rolPanelIniciar());

        bton2.addActionListener(e -> bton2Click());
    }

    private void rolPanelIniciar() {
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

    private void bton2Click() {
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
        buttonsPanel.add(bton1);
        buttonsPanel.add(bton2);

        // Agrega el panel de botones al centro del fondo
        background.add(buttonsPanel, BorderLayout.CENTER);

        // Agrega el fondo al MainForm
        add(background);
    }
}
