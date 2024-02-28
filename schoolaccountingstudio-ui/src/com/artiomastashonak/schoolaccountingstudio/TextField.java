// Copyright 2023-2024 Artiom Astashonak. Use of this code is governed by the Apache License 2.0 that can be found in the LICENSE file.
package com.artiomastashonak.schoolaccountingstudio;

import org.jetbrains.annotations.NotNull;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

/**
 * The {@code TextField} object serves as a user input prompt displayed
 * on the screen.
 *
 * @see JTextField
 *
 * @author Artiom Astashonak
 */
public class TextField extends JTextField {
  /**
   * Constructs a new {@code TextField} instance with background color, text
   * color, and font properties initialized. The properties of the constructor
   * must not be of type of {@code null}.
   *
   * @param backgroundColor the background color of the text field
   * @param textColor the text color of the text field
   * @param font the font to the applied on the text of the text field
   */
  public TextField(@NotNull Color backgroundColor, @NotNull Color textColor, @NotNull Font font) {
    setBackground(backgroundColor);
    setForeground(textColor);
    setFont(font);
    setBorder(null);
  }
}