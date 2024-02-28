// Copyright 2023-2024 Artiom Astashonak. Use of this code is governed by the Apache License 2.0 that can be found in the LICENSE file.
package com.artiomastashonak.schoolaccountingstudio;

import org.jetbrains.annotations.NotNull;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.BorderLayout;

/**
 * The {@code Window} is a window object that gets displayed to the end
 * user and can have components placed inside it.
 *
 * @see JFrame
 *
 * @author Artiom Astashonak
 */
public class Window extends JFrame {
  /**
   * Creates a new {@code Window} instance with icon specified. The parameters
   * can't be of type {@code null}.
   * <p>
   * The default layout for this object is set to {@link BorderLayout}, as well as
   * extended state is set to {@code MAXIMIZED_BOTH}.
   * @param icon the window icon
   */
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