package com.artiomastashonak.schoolaccountingstudio;

import org.jetbrains.annotations.NotNull;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Font;

public class Window extends JFrame {

    public Window(@NotNull ImageIcon icon) {
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(1000, 500));
        getContentPane().setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
        setTitle(StringsEN.APPLICATION_NAME.value);
        setIconImage(icon.getImage());
        setJMenuBar(new MenuBar(new Font("K2D", Font.PLAIN, TextSizes.MENU_BAR_TEXT_SIZE.size)));
    }

    public Window(int width, int height, @NotNull ImageIcon icon, String title) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(width, height);
        setResizable(false);
        getContentPane().setBackground(DarkThemeColors.POP_UP_WINDOW_BACKGROUND_COLOR.color);
        setTitle(title);
        setIconImage(icon.getImage());
    }

}