package com.artiomastashonak.schoolaccountingstudio;

import org.jetbrains.annotations.NotNull;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.util.ResourceBundle;

public class Window extends JFrame {

    private ResourceBundle bundle;
    public MenuBar menuBar;

    public Window(@NotNull ImageIcon icon, @NotNull ResourceBundle bundle) {
        this.bundle = bundle;
        this.menuBar = new MenuBar(bundle);

        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(1000, 500));
        getContentPane().setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
        setTitle(bundle.getString("applicationName"));
        setIconImage(icon.getImage());
    }

}