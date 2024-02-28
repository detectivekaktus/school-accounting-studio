// Copyright 2023-2024 Artiom Astashonak. Use of this code is governed by the Apache License 2.0 that can be found in the LICENSE file.
package com.artiomastashonak.schoolaccountingstudio;

import org.jetbrains.annotations.NotNull;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

/**
 * The {@code Label} instance serves as a text holder displayed on the canvas
 * to the end user.
 *
 * @see JLabel
 *
 * @author Artiom Astashonak
 */
public class Label extends JLabel {
  /**
   * Constructs a new instance of {@code Label} with text, background color,
   * text color, and font properties initialized. None of the properties passed
   * to this constructor must be of type {@code null}.
   *
   * @param text the text to be displayed on the label
   * @param backgroundColor the background color of the label
   * @param textColor the text color of the label
   * @param font the font to be applied to the label
   */
  public Label(@NotNull String text, @NotNull Color backgroundColor, @NotNull Color textColor, @NotNull Font font) {
    setHorizontalAlignment(LEFT);
    setVerticalAlignment(TOP);
    setForeground(textColor);
    setFont(font);
    setBackground(backgroundColor);
    setText(text);
  }
}