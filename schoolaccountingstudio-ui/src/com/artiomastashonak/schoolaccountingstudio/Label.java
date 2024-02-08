package com.artiomastashonak.schoolaccountingstudio;

import org.jetbrains.annotations.NotNull;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class Label extends JLabel {
  public Label(@NotNull String text, @NotNull Color backgroundColor, @NotNull Color textColor, @NotNull Font font) {
    setHorizontalAlignment(LEFT);
    setVerticalAlignment(TOP);
    setForeground(textColor);
    setFont(font);
    setBackground(backgroundColor);
    setText(text);
  }
}