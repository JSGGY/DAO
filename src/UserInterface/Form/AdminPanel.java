package UserInterface.Form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import BusinessLogic.PersonaBL;
import BusinessLogic.PersonaBL;
import BusinessLogic.RelacionBL;
import BusinessLogic.RelacionBL;
import DataAcces.DAO.RegaloEnvioDao;
import DataAcces.DTO.PersonaDTO;
import DataAcces.DTO.PersonaDTO;
import DataAcces.DTO.RelacionDTO;
import DataAcces.DTO.RelacionDTO;
import UserInterface.CustomerControl.SebButton;

public class AdminPanel extends JPanel {

    private Image backgroundImage;
    private SebButton btnRegresar;
    private SebButton btnCrear;
    private SebButton btnEliminar;
    private SebButton btnEditar;
    private JPanel pnlTabla = new JPanel();
    private JTextField txtNombre;
    private JTextField txtCedula;
    private JComboBox<String> cmbSexo;
    private JComboBox<String> cmbRol;

    public AdminPanel() {
        initializeComponents();
        setupLayout();
        setupActions();
        loadImage();
        showPersonasTabla();
    }

    private void initializeComponents() {
        btnRegresar = new SebButton("Regresar");
        btnCrear = new SebButton("Crear");
        btnEditar = new SebButton("Editar");
        btnEliminar = new SebButton("Eliminar");

    }

    private void showPersonasTabla() {
        try {
            String[] encabezado = { "IdPersona", "Nombre", "IdPersonaRol", "IdPersonaSexo", "Cedula",
                    "FechaCrea", "FechaModifica" };

            // Obtener los datos de la base de datos
            ArrayList<PersonaDTO> personas = PersonaBL.getAll();

            // Crear un array bidimensional para almacenar los datos
            Object[][] data = new Object[personas.size()][encabezado.length];

            // Llenar el array con los datos obtenidos de la base de datos
            for (int i = 0; i < personas.size(); i++) {
                PersonaDTO persona = personas.get(i);
                data[i][0] = persona.getIdPersona();
                data[i][1] = persona.getNombre();
                data[i][2] = persona.getIdPersonaRol();
                data[i][3] = persona.getIdPersonaSexo();
                data[i][4] = persona.getCedula();
                data[i][5] = persona.getFechaCrea();
                data[i][6] = persona.getFechaModifica();
            }

            // Crear una nueva tabla con los datos obtenidos
            JTable table = new JTable(data, encabezado);
            table.setShowHorizontalLines(true);
            table.setGridColor(Color.pink);
            table.setRowSelectionAllowed(true);
            table.setColumnSelectionAllowed(false);

            // Configurar la vista de la tabla
            table.setPreferredScrollableViewportSize(new Dimension(600, 300));
            table.setFillsViewportHeight(true);

            // Agregar la tabla a un JScrollPane y mostrarlo en tu panel
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setPreferredSize(new Dimension(600, 300)); // Establecer tamaño preferido
            pnlTabla.removeAll();
            pnlTabla.add(scrollPane);
            // Asegúrate de agregar el panel que contiene la tabla al panel principal
            add(pnlTabla, BorderLayout.CENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setupLayout() {
        setLayout(new BorderLayout());

        // Crear panel para la tabla y centrarla en la ventana
        JPanel panelTablaCentral = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelTablaCentral.setOpaque(false);

        // Agregar la tabla al panel central y al panel principal
        panelTablaCentral.add(pnlTabla);
        add(panelTablaCentral, BorderLayout.CENTER);
        // Panel para los botones de manipulacion
        JPanel panelBotonera = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBotonera.setOpaque(false);
        panelBotonera.add(btnCrear);
        panelBotonera.add(btnEditar);
        panelBotonera.add(btnEliminar);
        add(panelBotonera, BorderLayout.NORTH);

        // Panel para el botón "Regresar"
        JPanel panelRegresar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelRegresar.setOpaque(false);
        panelRegresar.add(btnRegresar);

        add(panelRegresar, BorderLayout.SOUTH);
    }

    private void setupActions() {
        btnRegresar.addActionListener(e -> MainForm());
        btnCrear.addActionListener(e -> VentanaCrear());
        btnEditar.addActionListener(e -> {
            VentanaEditar();
        });
        // btnEliminar.addActionListener(e -> );
    }

    public void VentanaCrear() {
        // Utiliza JOptionPane para crear una ventana emergente con los componentes
        // necesarios

        JPanel panerCrear = new JPanel(new GridLayout(5, 2, 5, 5));

        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField(20);

        JLabel lblCedula = new JLabel("Cédula:");
        JTextField txtCedula = new JTextField(10);

        JLabel lblSexo = new JLabel("Sexo:");
        String[] opcionesSexo = { "Masculino", "Femenino", "Otros" };
        JComboBox<String> cmbSexo = new JComboBox<>(opcionesSexo);

        JLabel lblRol = new JLabel("Rol:");
        String[] opcionesRol = { "Administrador", "Repartidor", "Usuario" };
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

            // Luego puedes realizar las operaciones necesarias con estos datos, como
            // almacenarlos en la base de datos, etc.
            // Por ejemplo, imprimirlos en la consola:
            System.out.println("Nombre: " + nombre);
            System.out.println("Cédula: " + cedula);
            System.out.println("Sexo: " + sexo);
            System.out.println("Rol: " + rol);
        }
    }

    public void VentanaEditar() {
        // Crear un panel para solicitar el ID de la persona a editar
        JPanel panelId = new JPanel();
        JTextField txtId = new JTextField(10);
        panelId.add(new JLabel("ID de la Persona:"));
        panelId.add(txtId);

        // Mostrar un diálogo para que el usuario ingrese el ID de la persona a editar
        int opcionId = JOptionPane.showConfirmDialog(null, panelId, "Ingrese el ID de la Persona a Editar",
                JOptionPane.OK_CANCEL_OPTION);

        // Verificar si se ha presionado "OK" y si se ha ingresado un ID válido
        if (opcionId == JOptionPane.OK_OPTION && !txtId.getText().isEmpty()) {
            try {
                int idPersona = Integer.parseInt(txtId.getText()); // Convertir el texto del campo ID a un entero

                // Obtener la información de la persona a editar usando el ID
                PersonaDTO persona = PersonaBL.getById(idPersona);

                // Verificar si la persona existe
                if (persona == null) {
                    JOptionPane.showMessageDialog(null, "La persona con el ID especificado no existe", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return; // Salir del método si la persona no existe
                }

                // Utiliza JOptionPane para crear una ventana emergente con los componentes
                // necesarios
                JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));

                JLabel lblNombre = new JLabel("Nombre:");
                JTextField txtNombre = new JTextField(persona.getNombre(), 20); // Establecer el nombre de la persona en
                                                                                // el campo de texto

                JLabel lblCedula = new JLabel("Cédula:");
                JTextField txtCedula = new JTextField(); // Establecer la cédula de la persona en
                                                         // el campo de texto

                JLabel lblSexo = new JLabel("Sexo:");
                String[] opcionesSexo = { "Masculino", "Femenino", "Otros" };
                JComboBox<String> cmbSexo = new JComboBox<>(opcionesSexo);
                cmbSexo.setSelectedItem(persona.getIdPersonaSexo()); // Establecer el sexo de la persona en el ComboBox

                JLabel lblRol = new JLabel("Rol:");
                String[] opcionesRol = { "Administrador", "Repartidor", "Usuario" };
                JComboBox<String> cmbRol = new JComboBox<>(opcionesRol);
                cmbRol.setSelectedItem(persona.getIdPersonaRol()); // Establecer el rol de la persona en el ComboBox

                panel.add(lblNombre);
                panel.add(txtNombre);
                panel.add(lblCedula);
                panel.add(txtCedula);
                panel.add(lblSexo);
                panel.add(cmbSexo);
                panel.add(lblRol);
                panel.add(cmbRol);

                // Mostrar la ventana emergente de entrada con los componentes
                int opcion = JOptionPane.showConfirmDialog(null, panel, "Editar Usuario", JOptionPane.OK_CANCEL_OPTION);

                // Verificar si se ha presionado "OK"
                if (opcion == JOptionPane.OK_OPTION) {
                    // Verificar que los campos no estén vacíos
                    if (txtNombre.getText().isEmpty() || txtCedula.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Los campos Nombre y Cédula no pueden estar vacíos",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return; // Salir del método sin procesar los datos
                    }

                    // Obtener los nuevos valores ingresados por el usuario
                    String nombre = txtNombre.getText();
                    Integer idPersonaNueva = Integer.parseInt(txtId.getText());
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

                    // Crear un nuevo objeto PersonaBL con los valores actualizados
                    PersonaBL personaNueva = new PersonaBL();

                    personaNueva.update(idPersonaNueva, nombre, numeroRol, numeroSexo, cedula);
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
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El ID ingresado no es válido", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al editar persona", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
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

}
