package UserInterface.Form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import BusinessLogic.RelacionBL;
import DataAcces.DTO.RelacionDTO;
import UserInterface.CustomerControl.SebButton;
import UserInterface.CustomerControl.SebLabel;

public class UserPanel extends JPanel {

    private Image backgroundImage;
    private SebButton btnRegresar;
    private SebButton btnCrear;
    private SebButton btnEliminar;
    private SebButton btnEditar;
    private JPanel pnlTabla = new JPanel();

    public UserPanel() {
        initializeComponents();
        setupLayout();
        setupActions();
        loadImage();
        showEnviosTabla();
    }

    private void initializeComponents() {
        btnRegresar = new SebButton("Regresar");
        btnCrear = new SebButton("Crear");
        btnEditar = new SebButton("Editar");
        btnEliminar = new SebButton("Eliminar");
    }

    private void showEnviosTabla() {
        try {
            String[] encabezado = {
                    "IdRelacion",
                    "IdRelacionTipo",
                    "Estado",
                    "IdPersona1",
                    "IdPersona2",
                    "FechaCrea",
                    "FechaModifica"
            };

            // Obtener los datos de la base de datos
            ArrayList<RelacionDTO> envios = RelacionBL.getAll();

            // Crear un array bidimensional para almacenar los datos
            Object[][] data = new Object[envios.size()][encabezado.length];

            // Llenar el array con los datos obtenidos de la base de datos
            for (int i = 0; i < envios.size(); i++) {
                RelacionDTO envio = envios.get(i);
                data[i][0] = envio.getIdRelacion();
                data[i][1] = envio.getIdRelacioTipo();
                data[i][2] = envio.getEstado();
                data[i][3] = envio.getIdPersona1();
                data[i][4] = envio.getIdPersona2();
                data[i][5] = envio.getFechaCrea();
                data[i][6] = envio.getFechaModifica();
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
        btnEditar.addActionListener(e -> VentanaEditar());
    }

    public void VentanaCrear() {
        // Utiliza JOptionPane para crear una ventana emergente con los componentes
        // necesarios
        JPanel panelCrear = new JPanel(new GridLayout(6, 2, 5, 5));

        SebLabel lblIdCita = new SebLabel("ID Cita:");
        JTextField txtIdCita = new JTextField(10);

        SebLabel lblIdPersona1 = new SebLabel("ID Persona 1:");
        JTextField txtIdPersona1 = new JTextField(10);

        SebLabel lblIdPersona2 = new SebLabel("ID Persona 2:");
        JTextField txtIdPersona2 = new JTextField(10);

        SebLabel lblNombreCita = new SebLabel("Nombre Cita:");
        JTextField txtNombreCita = new JTextField(20);

        panelCrear.add(lblIdCita);
        panelCrear.add(txtIdCita);
        panelCrear.add(lblIdPersona1);
        panelCrear.add(txtIdPersona1);
        panelCrear.add(lblIdPersona2);
        panelCrear.add(txtIdPersona2);
        panelCrear.add(lblNombreCita);
        panelCrear.add(txtNombreCita);

        // Mostrar la ventana emergente de entrada con los componentes
        int opcion = JOptionPane.showConfirmDialog(null, panelCrear, "Crear Cita", JOptionPane.OK_CANCEL_OPTION);

        // Verificar si se ha presionado "OK"
        if (opcion == JOptionPane.OK_OPTION) {
            // Verificar que los campos no estén vacíos
            if (txtIdCita.getText().isEmpty() || txtIdPersona1.getText().isEmpty() ||
                    txtIdPersona2.getText().isEmpty() || txtNombreCita.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return; // Salir del método sin procesar los datos
            }

            // Aquí puedes procesar los datos ingresados por el usuario
            int idCita = Integer.parseInt(txtIdCita.getText());
            int idPersona1 = Integer.parseInt(txtIdPersona1.getText());
            int idPersona2 = Integer.parseInt(txtIdPersona2.getText());
            String nombreCita = txtNombreCita.getText();

            // Luego puedes realizar las operaciones necesarias con estos datos, como
            // almacenarlos en la base de datos, etc.
            // Por ejemplo, imprimirlos en la consola:
            System.out.println("ID Cita: " + idCita);
            System.out.println("ID Persona 1: " + idPersona1);
            System.out.println("ID Persona 2: " + idPersona2);
            System.out.println("Nombre Cita: " + nombreCita);
        }
    }

    public void VentanaEditar() {
        // Utiliza JOptionPane para crear una ventana emergente con los componentes
        // necesarios
        JPanel panelEditar = new JPanel(new GridLayout(6, 2, 5, 5));

        SebLabel lblIdCita = new SebLabel("ID Cita:");
        JTextField txtIdCita = new JTextField(10);

        SebLabel lblIdPersona1 = new SebLabel("ID Persona 1:");
        JTextField txtIdPersona1 = new JTextField(10);

        SebLabel lblIdPersona2 = new SebLabel("ID Persona 2:");
        JTextField txtIdPersona2 = new JTextField(10);

        SebLabel lblNombreCita = new SebLabel("Nombre Cita:");
        JTextField txtNombreCita = new JTextField(20);

        panelEditar.add(lblIdCita);
        panelEditar.add(txtIdCita);
        panelEditar.add(lblIdPersona1);
        panelEditar.add(txtIdPersona1);
        panelEditar.add(lblIdPersona2);
        panelEditar.add(txtIdPersona2);
        panelEditar.add(lblNombreCita);
        panelEditar.add(txtNombreCita);

        // Mostrar la ventana emergente de entrada con los componentes
        int opcion = JOptionPane.showConfirmDialog(null, panelEditar, "Editar Cita", JOptionPane.OK_CANCEL_OPTION);

        // Verificar si se ha presionado "OK"
        if (opcion == JOptionPane.OK_OPTION) {
            // Verificar que los campos no estén vacíos
            if (txtIdCita.getText().isEmpty() || txtIdPersona1.getText().isEmpty() ||
                    txtIdPersona2.getText().isEmpty() || txtNombreCita.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return; // Salir del método sin procesar los datos
            }

            // Aquí puedes procesar los datos ingresados por el usuario
            int idCita = Integer.parseInt(txtIdCita.getText());
            int idPersona1 = Integer.parseInt(txtIdPersona1.getText());
            int idPersona2 = Integer.parseInt(txtIdPersona2.getText());
            String nombreCita = txtNombreCita.getText();

            // Luego puedes realizar las operaciones necesarias con estos datos, como
            // actualizarlos en la base de datos, etc.
            // Por ejemplo, imprimirlos en la consola:
            System.out.println("ID Cita: " + idCita);
            System.out.println("ID Persona 1: " + idPersona1);
            System.out.println("ID Persona 2: " + idPersona2);
            System.out.println("Nombre Cita: " + nombreCita);
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
