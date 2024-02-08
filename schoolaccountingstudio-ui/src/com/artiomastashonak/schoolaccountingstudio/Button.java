package com.artiomastashonak.schoolaccountingstudio;

import org.jetbrains.annotations.NotNull;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;

public class Button extends JButton {
  public Button(@NotNull String text, @NotNull Color backgroundColor, @NotNull Color textColor, @NotNull Font font) {
    setText(text);
    setBackground(backgroundColor);
    setForeground(textColor);
    setFont(font);
    setFocusable(false);

    setOpaque(true);
  }

  public Button(@NotNull ImageIcon icon, @NotNull Color backgroundColor) {
    setIcon(icon);
    setBackground(backgroundColor);
    setFocusable(false);
    setMinimumSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));

    setOpaque(true);
  }

  public Button(@NotNull ImageIcon icon, @NotNull String text, @NotNull Color backgroundColor, @NotNull Color textColor, @NotNull Font font) {
    setIcon(icon);
    setText(text);
    setBackground(backgroundColor);
    setForeground(textColor);
    setFont(font);
    setFocusable(false);
    setMinimumSize(new Dimension(icon.getIconWidth() + text.length(), icon.getIconHeight()));

    setOpaque(true);
  }
}