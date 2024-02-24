package UserInterface.Form;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import UserInterface.CustomerControl.SebButton;

public class MainForm extends JFrame {
    JPanel menuPanel, imagePanel;

    public MainForm(String tilteApp) {
        setTitle(tilteApp);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuPanel = createMenuPanel();
        imagePanel = new LoginPanel();
        createImagePanel();

        // Crear un contenedor para los dos paneles usando BorderLayout
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        // Agregar los paneles al contenedor
        container.add(menuPanel, BorderLayout.WEST);
        container.add(imagePanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private JPanel createMenuPanel() {
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

        SebButton button1 = new SebButton("Opción 1");
        SebButton button2 = new SebButton("Opción 2");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para la opción 1
                JOptionPane.showMessageDialog(MainForm.this, "Seleccionaste Opción 1");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para la opción 2
                JOptionPane.showMessageDialog(MainForm.this, "Seleccionaste Opción 2");
            }
        });

        menuPanel.add(button1);
        menuPanel.add(button2);

        return menuPanel;
    }

    private JPanel createImagePanel() {
        JPanel imagePanel = new JPanel();

        // Asegúrate de tener una imagen llamada "sample_image.jpg" en la misma carpeta
        // que tu código
        String imagePath = "/UserInterface/Resource/Img/Splah.png";

        try {
            URL imageURL = SplashScreenForm.class.getResource("/UserInterface/Resource/Img/IABot.png");
            ImageIcon imageIcon = new ImageIcon(imageURL); // new ImageIcon(new File(imagePath).getCanonicalPath());
            JLabel label = new JLabel(imageIcon);
            imagePanel.add(label, BorderLayout.CENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return imagePanel;
    }

}
