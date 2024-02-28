package UserInterface.Form;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import BusinessLogic.PersonaBL;
import UserInterface.CustomerControl.SebButton;
import UserInterface.CustomerControl.SebLabel;

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
        // Utiliza JOptionPane para crear una ventana emergente con los componentes
        // necesarios

        JPanel panerCrear = new JPanel(new GridLayout(5, 2, 5, 5));

        SebLabel lblNombre = new SebLabel("Nombre:");
        JTextField txtNombre = new JTextField(20);

        SebLabel lblCedula = new SebLabel("Cédula:");
        JTextField txtCedula = new JTextField(10);

        SebLabel lblSexo = new SebLabel("Sexo:");
        String[] opcionesSexo = { "Masculino", "Femenino", "Otros" };
        JComboBox<String> cmbSexo = new JComboBox<>(opcionesSexo);

        SebLabel lblRol = new SebLabel("Rol:");
        String[] opcionesRol = { "Usuario" };
        JComboBox<String> cmbRol = new JComboBox<>(opcionesRol);

        panerCrear.add(lblNombre);
        panerCrear.add(txtNombre);
        panerCrear.add(lblCedula);
        panerCrear.add(txtCedula);
        panerCrear.add(lblSexo);
        panerCrear.add(cmbSexo);
        panerCrear.add(lblRol);
        panerCrear.add(cmbRol);

        // Mostrar la ventana emergente de entrada con los componentes
        int opcion = JOptionPane.showConfirmDialog(null, panerCrear, "Crear Usuario", JOptionPane.OK_CANCEL_OPTION);

        // Verificar si se ha presionado "OK"
        if (opcion == JOptionPane.OK_OPTION) {
            // Verificar que los campos no estén vacíos
            if (txtNombre.getText().isEmpty() || txtCedula.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Los campos Nombre y Cédula no pueden estar vacíos", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return; // Salir del método sin procesar los datos
            }

            // Aquí puedes procesar los datos ingresados por el usuario
            String nombre = txtNombre.getText();
            String cedula = txtCedula.getText();
            String sexo = cmbSexo.getSelectedItem().toString();
            String rol = cmbRol.getSelectedItem().toString();
            Integer numeroRol;
            if (rol.equals("Administrador")) {
                numeroRol = 1;
            } else if (rol.equals("Repartidor")) {
                numeroRol = 2;
            } else {
                numeroRol = 3;
            }
            Integer numeroSexo;
            if (sexo.equals("Masculino")) {
                numeroSexo = 1;
            } else if (sexo.equals("Femenino")) {
                numeroSexo = 2;
            } else {
                numeroSexo = 3;
            }
            PersonaBL personaNueva = new PersonaBL();

            try {
                personaNueva.add(nombre, numeroRol, numeroSexo, cedula);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // Cerrar la ventana AdminPanel actual
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            frame.dispose();

            // Crear una nueva instancia de AdminPanel y mostrarla
            JFrame newFrame = new JFrame("Admin Panel");
            newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            newFrame.add(new AdminPanel());
            newFrame.pack();
            newFrame.setSize(700, 700);
            newFrame.setVisible(true);

        }

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
