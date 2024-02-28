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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import BusinessLogic.PersonaBL;
import BusinessLogic.RelacionBL;
import DataAcces.DTO.PersonaDTO;
import DataAcces.DTO.RelacionDTO;
import UserInterface.CustomerControl.SebButton;
import UserInterface.CustomerControl.SebLabel;

public class UserPanel extends JPanel {

    private Image backgroundImage;
    private SebButton btnRegresar;
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
        btnEditar.addActionListener(e -> VentanaEditar());
        btnEliminar.addActionListener(e -> VentanaEliminar());
    }

    public void VentanaEditar() {
        // Utiliza JOptionPane para crear una ventana emergente con los componentes
        // necesarios
        JPanel panelIdRelacion = new JPanel();
        JTextField txtIdRelacion = new JTextField(10);
        panelIdRelacion.add(new SebLabel("ID de la Relación a Editar:"));
        panelIdRelacion.add(txtIdRelacion);

        // Mostrar un diálogo para que el usuario ingrese el ID de la relación a editar
        int opcionId = JOptionPane.showConfirmDialog(null, panelIdRelacion, "Ingrese el ID de la Relación a Editar",
                JOptionPane.OK_CANCEL_OPTION);

        // Verificar si se ha presionado "OK" y si se ha ingresado un ID válido
        if (opcionId == JOptionPane.OK_OPTION && !txtIdRelacion.getText().isEmpty()) {
            try {
                Integer idRelacion = Integer.parseInt(txtIdRelacion.getText()); // Convertir el texto del campo ID a un
                // entero

                // Obtener la información de la relación a editar usando el ID
                // Aquí debes obtener los datos de la relación correspondiente a idRelacion
                // desde tu base de datos

                // Verificar si la relación existe
                // Si no existe, muestra un mensaje de error y termina el método

                RelacionDTO relacionDTO = RelacionBL.getBy(idRelacion);
                int idRelacionTipo = relacionDTO.getIdRelacioTipo();
                int idPersona1 = relacionDTO.getIdPersona1();
                int idPersona2 = relacionDTO.getIdPersona2();

                // Utiliza JOptionPane para crear una ventana emergente con los componentes
                // necesarios
                JPanel panelEditar = new JPanel(new GridLayout(5, 2, 5, 5));

                SebLabel lblIdRelacionTipo = new SebLabel("Tipo de Relación:");
                // Crear JComboBox para elegir el tipo de relación
                JComboBox<String> cmbTipoRelacion = new JComboBox<>(
                        new String[] { "Familiar", "Amistad", "Sentimental" });
                cmbTipoRelacion.setSelectedIndex(idRelacionTipo - 1); // Seleccionar el índice correspondiente al tipo
                                                                      // de relación

                SebLabel lblIdPersona1 = new SebLabel("ID Persona 1:");
                JTextField txtIdPersona1Edit = new JTextField(String.valueOf(idPersona1), 10); // Campo autollenado con
                                                                                               // el ID de la persona 1

                SebLabel lblIdPersona2 = new SebLabel("ID Persona 2:");
                JTextField txtIdPersona2Edit = new JTextField(String.valueOf(idPersona2), 10); // Campo autollenado con
                                                                                               // el ID de la persona 2

                panelEditar.add(lblIdRelacionTipo);
                panelEditar.add(cmbTipoRelacion);
                panelEditar.add(lblIdPersona1);
                panelEditar.add(txtIdPersona1Edit);
                panelEditar.add(lblIdPersona2);
                panelEditar.add(txtIdPersona2Edit);

                // Mostrar la ventana emergente de edición con los campos autollenados
                int opcion = JOptionPane.showConfirmDialog(null, panelEditar, "Editar Relación",
                        JOptionPane.OK_CANCEL_OPTION);

                // Verificar si se ha presionado "OK"
                if (opcion == JOptionPane.OK_OPTION) {
                    if (txtIdPersona1Edit.getText().isEmpty() || txtIdPersona2Edit.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Los campos Nombre y Cédula no pueden estar vacíos",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return; // Salir del método sin procesar los datos
                    }
                    Integer idPersona1Nuevo = Integer.parseInt(txtIdPersona1Edit.getText());
                    Integer idPersona2Nuevo = Integer.parseInt(txtIdPersona2Edit.getText());
                    Integer intIdRelacionTipo;
                    String stringIdRelacion = cmbTipoRelacion.getSelectedItem().toString();

                    if (stringIdRelacion.equals("Familiar")) {
                        intIdRelacionTipo = 1;
                    } else if (stringIdRelacion.equals("Amistad")) {
                        intIdRelacionTipo = 2;
                    } else {
                        intIdRelacionTipo = 3;
                    } // Crear un nuevo objeto RelacionBL con los valores actualizados
                    RelacionBL relacionEditada = new RelacionBL();

                    relacionEditada.update(idRelacion, intIdRelacionTipo, idPersona1Nuevo, idPersona2Nuevo);
                    // Cerrar la ventana AdminPanel actual
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
                    frame.dispose();

                    // Crear una nueva instancia de AdminPanel y mostrarla
                    JFrame newFrame = new JFrame("User Panel");
                    newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    newFrame.add(new UserPanel());
                    newFrame.pack();
                    newFrame.setSize(700, 700);
                    newFrame.setVisible(true);

                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El ID ingresado no es válido", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al editar relación", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void VentanaEliminar() {
        // Utiliza JOptionPane para crear una ventana emergente con los componentes
        // necesarios
        JPanel panelIdRelacion = new JPanel();
        JTextField txtIdRelacion = new JTextField(10);
        panelIdRelacion.add(new SebLabel("ID de la Relación a Eliminar:"));
        panelIdRelacion.add(txtIdRelacion);

        // Mostrar un diálogo para que el usuario ingrese el ID de la relación a editar
        int opcionId = JOptionPane.showConfirmDialog(null, panelIdRelacion, "Ingrese el ID de la Relación a Editar",
                JOptionPane.OK_CANCEL_OPTION);

        // Verificar si se ha presionado "OK" y si se ha ingresado un ID válido
        if (opcionId == JOptionPane.OK_OPTION && !txtIdRelacion.getText().isEmpty()) {
            try {
                Integer idRelacion = Integer.parseInt(txtIdRelacion.getText());

                RelacionDTO relacionDTO = RelacionBL.getBy(idRelacion);
                if (relacionDTO == null) {
                    System.out.println("no hay");
                    JOptionPane.showMessageDialog(null, "La relacion con el ID especificado no existe", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return; // Salir del método si la persona no existe
                }

                RelacionBL relacionElimiar = new RelacionBL();

                relacionElimiar.delete(idRelacion);
                // Cerrar la ventana AdminPanel actual
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
                frame.dispose();

                // Crear una nueva instancia de AdminPanel y mostrarla
                JFrame newFrame = new JFrame("User Panel");
                newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                newFrame.add(new UserPanel());
                newFrame.pack();
                newFrame.setSize(700, 700);
                newFrame.setVisible(true);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El ID ingresado no es válido", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al editar relación", "Error", JOptionPane.ERROR_MESSAGE);
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
