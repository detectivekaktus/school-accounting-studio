// Copyright 2023-2024 Artiom Astashonak. Use of this code is governed by the Apache License 2.0 that can be found in the LICENSE file.
package com.artiomastashonak.schoolaccountingstudio.date;

import com.artiomastashonak.schoolaccountingstudio.Label;
import com.artiomastashonak.schoolaccountingstudio.Button;
import com.artiomastashonak.schoolaccountingstudio.TextField;
import com.artiomastashonak.schoolaccountingstudio.Parameters;
import com.artiomastashonak.schoolaccountingstudio.UIHelper;
import com.artiomastashonak.schoolaccountingstudio.time.TimeValidator;
import javax.swing.*;
import java.awt.*;

/**
 * The {@code DateDialog} object rappresents a graphical user interface
 * inherited from {@link JDialog} class to communicate with {@link TimeValidator}
 * object API.
 *
 * @see JDialog
 *
 * @author Artiom Astashonak
 */
public class DateDialog extends JDialog {
  private final JComboBox<String> COMBO = new JComboBox<>(new String[]{Parameters.getBundle().getString("days"), Parameters.getBundle().getString("months"), Parameters.getBundle().getString("years")});
  private final TextField TIME = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());

  /**
   * Creates a new {@code DateDialog} object with initial UI components set up.
   */
  public DateDialog() {
    setMinimumSize(new Dimension(500, 250));
    setTitle(Parameters.getBundle().getString("dateCalculator"));
    getContentPane().setBackground(UIHelper.getMainWindowColor());
    setModal(false);
    SpringLayout layout = new SpringLayout();
    setLayout(layout);

    Label title = new Label(Parameters.getBundle().getString("dateCalculator"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getSectionTitleFont());
    add(title);
    layout.putConstraint(SpringLayout.NORTH, title, 5, SpringLayout.NORTH, this.getContentPane());
    layout.putConstraint(SpringLayout.WEST, title, 5, SpringLayout.WEST, this.getContentPane());

    add(COMBO);
    layout.putConstraint(SpringLayout.NORTH, COMBO, 5, SpringLayout.SOUTH, title);
    layout.putConstraint(SpringLayout.WEST, COMBO, 5, SpringLayout.WEST, this.getContentPane());

    TIME.setColumns(12);
    add(TIME);
    layout.putConstraint(SpringLayout.NORTH, TIME, 5, SpringLayout.SOUTH, COMBO);
    layout.putConstraint(SpringLayout.WEST, TIME, 5, SpringLayout.WEST, this.getContentPane());

    Button calculate = new Button(Parameters.getBundle().getString("calculate"), UIHelper.getBrightButtonColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
    add(calculate);
    layout.putConstraint(SpringLayout.SOUTH, calculate, -5, SpringLayout.SOUTH, this.getContentPane());
    layout.putConstraint(SpringLayout.EAST, calculate, -5, SpringLayout.EAST, this.getContentPane());

    show();
  }
}
