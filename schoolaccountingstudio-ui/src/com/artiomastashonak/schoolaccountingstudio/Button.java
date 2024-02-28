// Copyright 2023-2024 Artiom Astashonak. Use of this code is governed by the Apache License 2.0 that can be found in the LICENSE file.
package com.artiomastashonak.schoolaccountingstudio;

import org.jetbrains.annotations.NotNull;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;

/**
 * The {@code Button} object represents a graphical button that the user
 * can interact with.
 *
 * @see JButton
 *
 * @author Artiom Astashonak
 */
public class Button extends JButton {
  /**
   * Constructs a new {@code Button} object with text, background color, text color
   * and, font properties specified. The properties provided to this constructor
   * must not be of type {@code null}.
   *
   * @param text text to be displayed on the button
   * @param backgroundColor the background color of the button
   * @param textColor the text color of the button
   * @param font the font applied to the text of the button
   */
  public Button(@NotNull String text, @NotNull Color backgroundColor, @NotNull Color textColor, @NotNull Font font) {
    setText(text);
    setBackground(backgroundColor);
    setForeground(textColor);
    setFont(font);
    setFocusable(false);

    setOpaque(true);
  }

  /**
   * Constructs a new {@code Button} object with icon and background color
   * properties specified. The properties provided to this constructor must
   * not be of type {@code null}.
   *
   * @param icon the image to be displayed on the button
   * @param backgroundColor the background color of the button
   */
  public Button(@NotNull ImageIcon icon, @NotNull Color backgroundColor) {
    setIcon(icon);
    setBackground(backgroundColor);
    setFocusable(false);
    setMinimumSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));

    setOpaque(true);
  }

  /**
   * Constructs a new {@code Button} object with icon, text, background color,
   * text color, and font properties specified. The properties provided to this
   * constructor must not be of type {@code null}.
   *
   * @param icon image to be displayed on the button
   * @param text text to be displayed on the button
   * @param backgroundColor the background color on the button
   * @param textColor the text color of the button
   * @param font the font applied to the text of the button
   */
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