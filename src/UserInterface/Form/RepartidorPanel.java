package UserInterface.Form; // Define el paquete donde se encuentra la clase LoginPanel

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import BusinessLogic.RegaloEnvioBL;
import DataAcces.DAO.RegaloEnvioDao;
import DataAcces.DTO.RegaloEnvioDTO;
import UserInterface.CustomerControl.SebButton;

public class RepartidorPanel extends JPanel {

    private Image backgroundImage;
    private SebButton btnRegresar;
    private SebButton btnCrear;
    private SebButton btnEliminar;
    private SebButton btnEditar;
    private JPanel pnlTabla = new JPanel();

    public RepartidorPanel() {
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
            String[] encabezado = { "IdRegaloEnvio ",
                    "IdRegalo       ",
                    "Estado         ",
                    "IdPersonaEnvia ",
                    "IdPersonaRecibe",
                    "IdPersonaRepart",
                    "Nombre         ",
                    "FechaCrea      ",
                    "FechaModifica  ",
                    "FechaEnvio     " };

            // Obtener los datos de la base de datos
            ArrayList<RegaloEnvioDTO> envios = RegaloEnvioBL.getAll();

            // Crear un array bidimensional para almacenar los datos
            Object[][] data = new Object[envios.size()][encabezado.length];

            // Llenar el array con los datos obtenidos de la base de datos
            for (int i = 0; i < envios.size(); i++) {
                RegaloEnvioDTO envio = envios.get(i);
                data[i][0] = envio.getIdRegaloEnvio();
                data[i][1] = envio.getIdRegalo();
                data[i][2] = envio.getEstado();
                data[i][3] = envio.getIdPersonaEnvia();
                data[i][4] = envio.getIdPersonaRecibe();
                data[i][5] = envio.getIdPersonaEnvia();
                data[i][6] = envio.getNombre();
                data[i][7] = envio.getFechaCrea();
                data[i][8] = envio.getFechaModifica();
                data[i][9] = envio.getFechaEnvio();
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

    // @Override
    // public Dimension getPreferredSize() {
    // return new Dimension(600, 400); // Establece el tamaño preferido del panel
    // }
}
