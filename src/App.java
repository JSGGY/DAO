import java.awt.SplashScreen;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatArcDarkOrangeIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneLightContrastIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatSolarizedLightIJTheme;

import UserInterface.Form.MainForm;
import UserInterface.Form.SplashScreenForm;

public class App {
    public static void main(String[] args) {
        iniciarSistema();
    }

    public static void iniciarSistema() {
        FlatLightLaf.setup();
        FlatLightLaf.supportsNativeWindowDecorations();
        try {
            UIManager.setLookAndFeel(new FlatSolarizedLightIJTheme());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        SplashScreenForm.show();
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
