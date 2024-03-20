// Copyright 2023-2024 Artiom Astashonak. Use of this code is governed by the Apache License 2.0 that can be found in the LICENSE file.
package com.artiomastashonak.schoolaccountingstudio.check;

import com.artiomastashonak.schoolaccountingstudio.UIHelper;
import javax.swing.*;

/**
 * The {@code CheckPanel} object inherited from {@link JPanel} is defined by the {@code CheckPanel}
 * class represents a graphical user interface for the user to comunicate with {@link CheckXMLPrinter}
 * API to print a bank check.
 * <p>
 * To comunicate with low-level API ({@link CheckXMLPrinter} and {@link CheckHTMLPrinter})
 * it's used a facade-object {@link CheckPrinter}.
 * 
 * @see JPanel
 * @see CheckPrinter
 * @see CheckXMLPrinter
 * @see CheckHTMLPrinter
 * 
 * @author Artiom Astashonak
 */
public class CheckPanel extends JPanel {
  /**
   * Creates a new {@code CheckPanel} object with initial UI elements and API links set up.
   */
  public CheckPanel() {
    getRootPane().setBackground(UIHelper.getMainWindowColor());
    SpringLayout layout = new SpringLayout();
    setLayout(layout);
  }
}