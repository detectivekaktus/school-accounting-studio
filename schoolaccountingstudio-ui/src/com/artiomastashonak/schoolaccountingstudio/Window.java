package com.artiomastashonak.schoolaccountingstudio;

import org.jetbrains.annotations.NotNull;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.BorderLayout;

public class Window extends JFrame {
  public Window(@NotNull ImageIcon icon) {
    setLayout(new BorderLayout());
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setExtendedState(MAXIMIZED_BOTH);
    setMinimumSize(new Dimension(1000, 500));
    getContentPane().setBackground(UIHelper.getMainWindowColor());
    setTitle(Parameters.getBundle().getString("applicationName"));
    setIconImage(icon.getImage());
  }
}