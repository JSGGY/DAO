package UserInterface.Form; // Define el paquete donde se encuentra la clase LoginPanel

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout; // Importa la clase GridLayout para manejar el diseño del panel
import java.awt.event.ActionEvent; // Importa las clases necesarias para manejar eventos de acción
import java.awt.event.ActionListener;

import javax.swing.JButton; // Importa las clases JButton, JLabel, JPanel, JPasswordField y JTextField para crear componentes de la interfaz de usuario
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel { // Define la clase LoginPanel que extiende JPanel

    private JTextField usernameField; // Declara un campo de texto para el nombre de usuario
    private JPasswordField passwordField; // Declara un campo de contraseña para la contraseña
    private JButton loginButton; // Declara un botón para iniciar sesión

    public LoginPanel() { // Constructor de la clase
        initializeComponents(); // Inicializa los componentes del panel
        setupLayout(); // Configura el diseño del panel
        setupActions(); // Configura las acciones del panel
    }

    private void initializeComponents() { // Método para inicializar los componentes del panel
        usernameField = new JTextField(); // Inicializa el campo de texto para el nombre de usuario
        passwordField = new JPasswordField(); // Inicializa el campo de contraseña
        loginButton = new JButton("Login"); // Inicializa el botón de inicio de sesión con el texto "Login"
    }

    private void setupLayout() { // Método para configurar el diseño del panel
        setLayout(new FlowLayout(FlowLayout.CENTER, 40, 200)); // Establece un layout de flujo con alineación centrada y
                                                               // espaciado de 10 píxeles entre componentes

        add(new JLabel("Username:")); // Agrega una etiqueta para el nombre de usuario
        add(usernameField).setPreferredSize(new Dimension(200, 30)); // Establece el tamaño preferido del campo de texto
        // para el nombre de usuario // Agrega el campo de
        // texto para el nombre de usuario

        add(new JLabel("Password:")); // Agrega una etiqueta para la contraseña
        add(passwordField).setPreferredSize(new Dimension(200, 30)); // Establece el tamaño preferido del campo de texto

        add(loginButton); // Agrega el botón de inicio de sesión
    }

    private void setupActions() { // Método para configurar las acciones del panel
        loginButton.addActionListener(new ActionListener() { // Agrega un ActionListener al botón de inicio de sesión
            @Override
            public void actionPerformed(ActionEvent e) { // Define la acción a realizar cuando se presione el botón de
                                                         // inicio de sesión
                // Lógica de autenticación
                String username = usernameField.getText(); // Obtiene el texto del campo de nombre de usuario
                char[] password = passwordField.getPassword(); // Obtiene la contraseña como un arreglo de caracteres

                // Aquí puedes realizar la lógica de autenticación

                // Ejemplo básico: mostrar un mensaje con los datos ingresados
                JOptionPane.showMessageDialog(LoginPanel.this, // Muestra un mensaje dentro del panel de inicio de
                                                               // sesión
                        "Usuario: " + username + "\nContraseña: " + new String(password), "Login Exitoso", // Título del
                                                                                                           // mensaje y
                                                                                                           // tipo de
                                                                                                           // mensaje
                        JOptionPane.INFORMATION_MESSAGE);

                // Limpia los campos después del login
                usernameField.setText(""); // Borra el texto del campo de nombre de usuario
                passwordField.setText(""); // Borra el texto del campo de contraseña
            }
        });
    }
}
