// Copyright 2023-2024 Artiom Astashonak. Use of this code is governed by the Apache License 2.0 that can be found in the LICENSE file.
package com.artiomastashonak.schoolaccountingstudio.proportion;

import com.artiomastashonak.schoolaccountingstudio.Button;
import com.artiomastashonak.schoolaccountingstudio.Label;
import com.artiomastashonak.schoolaccountingstudio.Parameters;
import com.artiomastashonak.schoolaccountingstudio.TextField;
import com.artiomastashonak.schoolaccountingstudio.UIHelper;
import com.artiomastashonak.schoolaccountingstudio.exceptions.NoSolutionException;
import javax.swing.*;
import java.awt.*;

/**
 * The {@code ProportionDialog} class defines a proportion calculator dialog
 * interface for the end user and provides a communication with {@link Proportion}
 * object.
 *
 * @see JDialog
 * @see Proportion
 *
 * @author Artiom Astashonak
 */
public class ProportionDialog extends JDialog {
  private final Proportion PROPORTION = new Proportion();
  private final TextField FIRST_TERM = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
  private final TextField SECOND_TERM = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
  private final TextField THIRD_TERM = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
  private final TextField FOURTH_TERM = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());

  /**
   * Constructs a new {@code ProportionDialog} object with default parameters set up.
   */
  public ProportionDialog() {
    setMinimumSize(new Dimension(450, 250));
    setTitle(Parameters.getBundle().getString("proportionCalculator"));
    getContentPane().setBackground(UIHelper.getMainWindowColor());
    setModal(false);
    SpringLayout layout = new SpringLayout();
    setLayout(layout);

    Label proportionCalculatorLabel = new Label(Parameters.getBundle().getString("proportionCalculator"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getSubsectionTitleFont());
    add(proportionCalculatorLabel);
    layout.putConstraint(SpringLayout.NORTH, proportionCalculatorLabel, 5, SpringLayout.NORTH, this);
    layout.putConstraint(SpringLayout.WEST, proportionCalculatorLabel, 5, SpringLayout.WEST, this);

    FIRST_TERM.setColumns(5);
    add(FIRST_TERM);
    layout.putConstraint(SpringLayout.NORTH, FIRST_TERM, 25, SpringLayout.SOUTH, proportionCalculatorLabel);
    layout.putConstraint(SpringLayout.WEST, FIRST_TERM, 5, SpringLayout.WEST, this);

    Label firstIsToLabel = new Label(":", UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
    add(firstIsToLabel);
    layout.putConstraint(SpringLayout.NORTH, firstIsToLabel, 0, SpringLayout.NORTH, FIRST_TERM);
    layout.putConstraint(SpringLayout.WEST, firstIsToLabel, 5, SpringLayout.EAST, FIRST_TERM);

    SECOND_TERM.setColumns(5);
    add(SECOND_TERM);
    layout.putConstraint(SpringLayout.NORTH, SECOND_TERM, 25, SpringLayout.SOUTH, proportionCalculatorLabel);
    layout.putConstraint(SpringLayout.WEST, SECOND_TERM, 5, SpringLayout.EAST, firstIsToLabel);

    Label asLabel = new Label("=", UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
    add(asLabel);
    layout.putConstraint(SpringLayout.NORTH, asLabel, 0, SpringLayout.NORTH, SECOND_TERM);
    layout.putConstraint(SpringLayout.WEST, asLabel, 5, SpringLayout.EAST, SECOND_TERM);

    THIRD_TERM.setColumns(5);
    add(THIRD_TERM);
    layout.putConstraint(SpringLayout.NORTH, THIRD_TERM, 25, SpringLayout.SOUTH, proportionCalculatorLabel);
    layout.putConstraint(SpringLayout.WEST, THIRD_TERM, 5, SpringLayout.EAST, asLabel);

    Label secondIsToLabel = new Label(":", UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
    add(secondIsToLabel);
    layout.putConstraint(SpringLayout.NORTH, secondIsToLabel, 0, SpringLayout.NORTH, THIRD_TERM);
    layout.putConstraint(SpringLayout.WEST, secondIsToLabel, 5, SpringLayout.EAST, THIRD_TERM);

    FOURTH_TERM.setColumns(5);
    add(FOURTH_TERM);
    layout.putConstraint(SpringLayout.NORTH, FOURTH_TERM, 25, SpringLayout.SOUTH, proportionCalculatorLabel);
    layout.putConstraint(SpringLayout.WEST, FOURTH_TERM, 5, SpringLayout.EAST, secondIsToLabel);

    Button solveButton = new Button(Parameters.getBundle().getString("solve"), UIHelper.getBrightButtonColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
    solveButton.addActionListener((e) -> {
      try {
        if (composeProportion() == -1) return;
        double result = PROPORTION.solve();
        if (Double.isNaN(result)) {
          JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("noSolutionFoundInvalid"));
          return;
        }
        JOptionPane.showInternalMessageDialog(null, String.format(Parameters.getBundle().getString("solutionIs"), result));
        PROPORTION.reset();
      } catch (NoSolutionException nse) {
        JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("noSolutionFoundInvalid"));
      }
    });
    add(solveButton);
    layout.putConstraint(SpringLayout.SOUTH, solveButton, -25, SpringLayout.SOUTH, getContentPane());
    layout.putConstraint(SpringLayout.EAST, solveButton, -10, SpringLayout.EAST, getContentPane());

    Button resetButton = new Button(Parameters.getBundle().getString("reset"),
      UIHelper.getBrightButtonColor(),
      UIHelper.getPrimaryTextColor(),
      UIHelper.getInputFont());
    resetButton.addActionListener((e) -> {
      resetInput();
      PROPORTION.reset();
    });
    add(resetButton);
    layout.putConstraint(SpringLayout.NORTH, resetButton, 0, SpringLayout.NORTH, solveButton);
    layout.putConstraint(SpringLayout.EAST, resetButton, -10, SpringLayout.WEST, solveButton);

    show();
  }

  /**
   * Sets each term of the {@link Proportion} object saved as a class variable of
   * the current object.
   *
   * @return 0 if successful, -1 if there are no solutions
   */
  private int composeProportion() {
    int termsToFind = 0;
    for (TextField textField : new TextField[]{FIRST_TERM, SECOND_TERM, THIRD_TERM, FOURTH_TERM}) {
      try {
        Double.parseDouble(textField.getText());
      } catch (Exception exception) {
        termsToFind++;
      }
    }
    if (termsToFind != 1) {
      JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("noSolutionFoundUnsolvableComposed"));
      return -1;
    }
    try {
      PROPORTION.setA(Double.parseDouble(FIRST_TERM.getText()));
    } catch (Exception ignored) { }
    try {
      PROPORTION.setB(Double.parseDouble(SECOND_TERM.getText()));
    } catch (Exception ignored) { }
    try {
      PROPORTION.setC(Double.parseDouble(THIRD_TERM.getText()));
    } catch (Exception ignored) { }
    try {
      PROPORTION.setD(Double.parseDouble(FOURTH_TERM.getText()));
    } catch (Exception ignored) { }

    return 0;
  }

  /**
   * Resets all input fields. Resets {@link Proportion} object associated with
   * the current object to its initial state.
   */
  private void resetInput() {
    for (TextField textField : new TextField[]{FIRST_TERM, SECOND_TERM, THIRD_TERM, FOURTH_TERM}) {
      textField.setText("");
    }
    PROPORTION.reset();
  }
}