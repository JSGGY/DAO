import javax.swing.ImageIcon;
import javax.swing.JFrame;

import UserInterface.Form.MainForm;

public class App {
    public static void main(String[] args) {
        MainForm mainForm = new MainForm();
        JFrame frame = new JFrame("LovingFans");
        frame.add(mainForm);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        ImageIcon icon = new ImageIcon("src\\Resource\\Img\\png-transparent-heart-red-heart-thumbnail.png"); // Cambia
                                                                                                             // la ruta
        // logo
        frame.setIconImage(icon.getImage());
        frame.setSize(700, 700); // Por ejemplo, tamaño de 400x300 píxeles
        frame.setVisible(true);
    }
}
