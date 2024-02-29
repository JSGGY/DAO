
/**
/*-------------------------------------------------------------\
|  Copyright (©) 2K24 EPN-FIS. All rights reserved.            |
|  sebastian.sarasti01@epn.edu.ec PROPRIETARY/CONFIDENTIAL.    |
|  Use is subject to license terms.       Sebastian Sarasti    |
\--------------------------------------------------------------\
 */
import java.awt.SplashScreen;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatArcDarkOrangeIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneLightContrastIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatSolarizedLightIJTheme;

import BusinessLogic.PersonaBL;
import BusinessLogic.UsuarioSistemaBL;
import DataAcces.DTO.UsuarioSistemaDTO;
import UserInterface.Form.MainForm;
import UserInterface.Form.SplashScreenForm;

public class App {
    public static void main(String[] args) throws Exception {
        PersonaBL personaNueva = new PersonaBL();

        // personaNueva.update(1, "Isabelx", 1, 3, "1234567");

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
        ImageIcon icon = new ImageIcon("src\\Resource\\Img\\png-transparent-heart-red-heart-thumbnail.png");
        // Cambia
        // la ruta
        // logo
        frame.setIconImage(icon.getImage());
        frame.setSize(700, 700); // Por ejemplo, tamaño de 400x300 píxeles
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // try {
        // ArrayList<UsuarioSistemaDTO> usuarios = UsuarioSistemaBL.getUsuario();
        // System.out.println("Lista de usuarios obtenida:");
        // for (UsuarioSistemaDTO usuario : usuarios) {
        // System.out.println(usuario.toString());
        // if ("1".equals(usuario.toString()))
        // System.out.println("aa");
        // ;
        // }
        // } catch (Exception e) {
        // e.printStackTrace();
        // }

    }
}
