// Copyright 2023-2024 Artiom Astashonak. Use of this code is governed by the Apache License 2.0 that can be found in the LICENSE file.
package com.artiomastashonak.schoolaccountingstudio.interest;

import com.artiomastashonak.schoolaccountingstudio.Button;
import com.artiomastashonak.schoolaccountingstudio.Label;
import com.artiomastashonak.schoolaccountingstudio.Parameters;
import com.artiomastashonak.schoolaccountingstudio.TextField;
import com.artiomastashonak.schoolaccountingstudio.UIHelper;
import com.artiomastashonak.schoolaccountingstudio.time.TimeValidator;
import org.jetbrains.annotations.NotNull;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * The {@code InterestTotAmountDialog} is a {@link JDialog} inherited object
 * that displays the user the input prompts to compute the interest and the
 * total amount values.
 * <p>
 * It communicates with {@link InterestHandler} and with
 * {@link TotalAmountHandler} objects to provide defined solutions.
 *
 * @see JDialog
 * @see InterestHandler
 * @see TotalAmountHandler
 *
 * @author Artiom Astashonak
 */
public class InterestTotAmountDialog extends JDialog {
  private final InterestHandler INTEREST_HANDLER = new InterestHandler();
  private final TotalAmountHandler TOTAL_AMOUNT_HANDLER = new TotalAmountHandler();

  private JComboBox<String> interestTimeCombo;
  private final TextField INTEREST_TIME = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
  private final TextField INTEREST_CAPITAL = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
  private final TextField INTEREST_QUOTE = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
  private final TextField INTEREST_VALUE = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
  private JCheckBox interestLeapYearCheck;

  private JComboBox<String> totalAmountTimeCombo;
  private final TextField TOTAL_AMOUNT_TIME = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
  private final TextField TOTAL_AMOUNT_CAPITAL = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
  private final TextField TOTAL_AMOUNT_QUOTE = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
  private final TextField TOTAL_AMOUNT_VALUE = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
  private JCheckBox totalAmountLeapYearCheck;

  private final int DAYS_CALCULATION = 0;
  private final int MONTHS_CALCULATION = 1;
  private final int YEARS_CALCULATION = 2;

  /**
   * Assembles a new {@code InterestTotAmountDialog} object with initial values set up.
   */
  public InterestTotAmountDialog() {
    setMinimumSize(new Dimension(600, 550));
    setTitle(Parameters.getBundle().getString("interestCalculator"));
    getContentPane().setBackground(UIHelper.getMainWindowColor());
    setModal(false);
    setLayout(new BorderLayout());

    JPanel mainPanel = new JPanel();
    mainPanel.setBackground(UIHelper.getMainWindowColor());
    CardLayout mainLayout = new CardLayout();
    mainPanel.setLayout(mainLayout);
    add(mainPanel, BorderLayout.CENTER);

    JPanel switchPanel = new JPanel();
    switchPanel.setBackground(UIHelper.getMenuBarColor());
    switchPanel.setLayout(new BoxLayout(switchPanel, BoxLayout.Y_AXIS));
    add(switchPanel, BorderLayout.WEST);

    Button interestViewButton = new Button(Parameters.getBundle().getString("interest"), UIHelper.getBrightButtonColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
    switchPanel.add(interestViewButton);

    Button totAmountViewButton = new Button(Parameters.getBundle().getString("totalAmount"), UIHelper.getBrightButtonColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
    switchPanel.add(totAmountViewButton);

    JPanel interestPanel = createInterestPanel();
    mainPanel.add(interestPanel, "INTEREST");

    JPanel totAmountPanel = createTotalAmountPanel();
    mainPanel.add(totAmountPanel, "TOT_AMOUNT");

    mainLayout.show(mainPanel, "INTEREST");

    interestViewButton.addActionListener(e -> mainLayout.show(mainPanel, "INTEREST"));
    totAmountViewButton.addActionListener(e -> mainLayout.show(mainPanel, "TOT_AMOUNT"));

    show();
  }

  /**
   * Creates and sets the layout for the interest {@link JPanel} object.
   *
   * @return interest {@link JPanel} object
   */
  private @NotNull JPanel createInterestPanel() {
    JPanel panel = new JPanel();
    panel.setBackground(UIHelper.getMainWindowColor());
    SpringLayout layout = new SpringLayout();
    panel.setLayout(layout);

    Label interestCalculatorLabel = new Label(Parameters.getBundle().getString("interestCalculator"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getSectionTitleFont());
    panel.add(interestCalculatorLabel);
    layout.putConstraint(SpringLayout.NORTH, interestCalculatorLabel, 5, SpringLayout.NORTH, panel);
    layout.putConstraint(SpringLayout.WEST, interestCalculatorLabel, 5, SpringLayout.WEST, panel);

    Label interestTimeLabel = new Label(Parameters.getBundle().getString("time"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    panel.add(interestTimeLabel);
    layout.putConstraint(SpringLayout.NORTH, interestTimeLabel, 5, SpringLayout.SOUTH, interestCalculatorLabel);
    layout.putConstraint(SpringLayout.WEST, interestTimeLabel, 5, SpringLayout.WEST, panel);

    interestTimeCombo = new JComboBox<>(new String[]{Parameters.getBundle().getString("days"), Parameters.getBundle().getString("months"), Parameters.getBundle().getString("years")});
    interestTimeCombo.setBackground(UIHelper.getMenuBarColor());
    interestTimeCombo.setForeground(UIHelper.getPrimaryTextColor());
    interestTimeCombo.setBorder(null);
    panel.add(interestTimeCombo);
    layout.putConstraint(SpringLayout.NORTH, interestTimeCombo, 5, SpringLayout.SOUTH, interestTimeLabel);
    layout.putConstraint(SpringLayout.WEST, interestTimeCombo, 5, SpringLayout.WEST, panel);

    INTEREST_TIME.setColumns(20);
    panel.add(INTEREST_TIME);
    layout.putConstraint(SpringLayout.NORTH, INTEREST_TIME, 5, SpringLayout.SOUTH, interestTimeCombo);
    layout.putConstraint(SpringLayout.WEST, INTEREST_TIME, 5, SpringLayout.WEST, panel);

    Label interestCapitalLabel = new Label(Parameters.getBundle().getString("capital"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    panel.add(interestCapitalLabel);
    layout.putConstraint(SpringLayout.NORTH, interestCapitalLabel, 5, SpringLayout.SOUTH, INTEREST_TIME);
    layout.putConstraint(SpringLayout.WEST, interestCapitalLabel, 5, SpringLayout.WEST, panel);

    INTEREST_CAPITAL.setColumns(20);
    panel.add(INTEREST_CAPITAL);
    layout.putConstraint(SpringLayout.NORTH, INTEREST_CAPITAL, 5, SpringLayout.SOUTH, interestCapitalLabel);
    layout.putConstraint(SpringLayout.WEST, INTEREST_CAPITAL, 5, SpringLayout.WEST, panel);

    Label interestQuoteLabel = new Label(Parameters.getBundle().getString("quote"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    panel.add(interestQuoteLabel);
    layout.putConstraint(SpringLayout.NORTH, interestQuoteLabel, 5, SpringLayout.SOUTH, INTEREST_CAPITAL);
    layout.putConstraint(SpringLayout.WEST, interestQuoteLabel, 5, SpringLayout.WEST, panel);

    INTEREST_QUOTE.setColumns(20);
    panel.add(INTEREST_QUOTE);
    layout.putConstraint(SpringLayout.NORTH, INTEREST_QUOTE, 5, SpringLayout.SOUTH, interestQuoteLabel);
    layout.putConstraint(SpringLayout.WEST, INTEREST_QUOTE, 5, SpringLayout.WEST, panel);

    Label interestInterestLabel = new Label(Parameters.getBundle().getString("interest"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    panel.add(interestInterestLabel);
    layout.putConstraint(SpringLayout.NORTH, interestInterestLabel, 5, SpringLayout.SOUTH, INTEREST_QUOTE);
    layout.putConstraint(SpringLayout.WEST, interestInterestLabel, 5, SpringLayout.WEST, panel);

    INTEREST_VALUE.setColumns(20);
    panel.add(INTEREST_VALUE);
    layout.putConstraint(SpringLayout.NORTH, INTEREST_VALUE, 5, SpringLayout.SOUTH, interestInterestLabel);
    layout.putConstraint(SpringLayout.WEST, INTEREST_VALUE, 5, SpringLayout.WEST, panel);

    Button interestCalcButton = new Button(Parameters.getBundle().getString("calculate"), UIHelper.getBrightButtonColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
    interestCalcButton.addActionListener(e -> {
      try {
        insertInterestData();
        double result = INTEREST_HANDLER.calculate(interestTimeCombo.getSelectedIndex());
        if (!Double.isNaN(result)) {
          JOptionPane.showInternalMessageDialog(null, String.format(Parameters.getBundle().getString("solutionIs"), result));
        } else {
          JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("calculationError"));
        }
      } catch (InputMismatchException exception) {
        INTEREST_HANDLER.reset();
        return;
      }
      INTEREST_HANDLER.reset();
    });
    panel.add(interestCalcButton);
    layout.putConstraint(SpringLayout.SOUTH, interestCalcButton, -25, SpringLayout.SOUTH, panel);
    layout.putConstraint(SpringLayout.EAST, interestCalcButton, -50, SpringLayout.EAST, panel);

    Button interestResetButton = new Button(Parameters.getBundle().getString("reset"), UIHelper.getBrightButtonColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
    interestResetButton.addActionListener(e -> resetInterest());
    panel.add(interestResetButton);
    layout.putConstraint(SpringLayout.NORTH, interestResetButton, 0, SpringLayout.NORTH, interestCalcButton);
    layout.putConstraint(SpringLayout.EAST, interestResetButton, -10, SpringLayout.WEST, interestCalcButton);

    interestLeapYearCheck = new JCheckBox(Parameters.getBundle().getString("leapYear"));
    interestLeapYearCheck.setBackground(UIHelper.getMainWindowColor());
    interestLeapYearCheck.setForeground(UIHelper.getPrimaryTextColor());
    panel.add(interestLeapYearCheck);
    layout.putConstraint(SpringLayout.NORTH, interestLeapYearCheck, 0, SpringLayout.NORTH, interestResetButton);
    layout.putConstraint(SpringLayout.EAST, interestLeapYearCheck, -10, SpringLayout.WEST, interestResetButton);

    return panel;
  }

  /**
   * Writes interest data given by the user into the {@link InterestHandler} object
   * associated with the current instance of the {@code InterestTotAmountDialog} object.
   *
   * @throws InputMismatchException if provided wrong type value for any of the
   * text fields
   */
  private void insertInterestData() throws InputMismatchException {
    ArrayList<TextField> solutionTerm = new ArrayList<>(1);
    for (TextField textField : new TextField[]{INTEREST_CAPITAL, INTEREST_TIME, INTEREST_QUOTE, INTEREST_VALUE}) {
      if (textField.getText().isEmpty()) solutionTerm.add(textField);
    }
    if (solutionTerm.size() != 1) {
      JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("wrongInput"));
      throw new InputMismatchException("Expected 1 unknown value, got: " + solutionTerm.size());
    }
    try {
      if (!INTEREST_CAPITAL.equals(solutionTerm.get(0))) INTEREST_HANDLER.setCapital(Double.parseDouble(INTEREST_CAPITAL.getText()));
    } catch (Exception e) {
      JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("capitalError"));
      INTEREST_HANDLER.reset();
      throw new InputMismatchException("Expected double value for interest capital.");
    }

    try {
      if (!INTEREST_TIME.equals(solutionTerm.get(0))) {
        if (interestTimeCombo.getSelectedIndex() == DAYS_CALCULATION) INTEREST_HANDLER.setTime(TimeValidator.DAYS.valueOrBetween(INTEREST_TIME.getText()));
        if (interestTimeCombo.getSelectedIndex() == MONTHS_CALCULATION) INTEREST_HANDLER.setTime(TimeValidator.MONTHS.valueOrBetween(INTEREST_TIME.getText()));
        if (interestTimeCombo.getSelectedIndex() == YEARS_CALCULATION) INTEREST_HANDLER.setTime(TimeValidator.YEARS.valueOrBetween(INTEREST_TIME.getText()));
      }
    } catch (Exception e) {
      JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("timeError"));
      INTEREST_HANDLER.reset();
      throw new InputMismatchException("Expected valid time expression for interest time.");
    }

    try {
      if (!INTEREST_QUOTE.equals(solutionTerm.get(0))) INTEREST_HANDLER.setQuote(Double.parseDouble(INTEREST_QUOTE.getText()));
    } catch (Exception e) {
      JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("quoteError"));
      INTEREST_HANDLER.reset();
      throw new InputMismatchException("Expected double value for interest quote.");
    }

    try {
      if (!INTEREST_VALUE.equals(solutionTerm.get(0))) INTEREST_HANDLER.setInterest(Double.parseDouble(INTEREST_VALUE.getText()));
    } catch (Exception e) {
      JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("interestError"));
      INTEREST_HANDLER.reset();
      throw new InputMismatchException("Expected double value for interest.");
    }

    INTEREST_HANDLER.setLeapYear(interestLeapYearCheck.isSelected());
  }

  /**
   * Resets the text fields of the interest on the screen and resets the
   * {@link InterestHandler} object to its initial state.
   */
  private void resetInterest() {
    for (TextField textField : new TextField[]{INTEREST_TIME, INTEREST_CAPITAL, INTEREST_QUOTE, INTEREST_VALUE}) {
      textField.setText("");
    }
    interestTimeCombo.setSelectedIndex(0);
    interestLeapYearCheck.setSelected(false);
    INTEREST_HANDLER.reset();
  }

  /**
   * Creates and sets the layout for the total amount {@link JPanel} object.
   *
   * @return total amount {@link JPanel} object
   */
  private @NotNull JPanel createTotalAmountPanel() {
    JPanel panel = new JPanel();
    panel.setBackground(UIHelper.getMainWindowColor());
    SpringLayout layout = new SpringLayout();
    panel.setLayout(layout);

    Label totalAmountCalculatorLabel = new Label(Parameters.getBundle().getString("totalAmountCalculator"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getSectionTitleFont());
    panel.add(totalAmountCalculatorLabel);
    layout.putConstraint(SpringLayout.NORTH, totalAmountCalculatorLabel, 5, SpringLayout.NORTH, panel);
    layout.putConstraint(SpringLayout.WEST, totalAmountCalculatorLabel, 5, SpringLayout.WEST, panel);

    Label totalAmountTimeLabel = new Label(Parameters.getBundle().getString("time"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    panel.add(totalAmountTimeLabel);
    layout.putConstraint(SpringLayout.NORTH, totalAmountTimeLabel, 5, SpringLayout.SOUTH, totalAmountCalculatorLabel);
    layout.putConstraint(SpringLayout.WEST, totalAmountTimeLabel, 5, SpringLayout.WEST, panel);

    totalAmountTimeCombo = new JComboBox<>(new String[]{Parameters.getBundle().getString("days"), Parameters.getBundle().getString("months"), Parameters.getBundle().getString("years")});
    totalAmountTimeCombo.setBackground(UIHelper.getMenuBarColor());
    totalAmountTimeCombo.setForeground(UIHelper.getPrimaryTextColor());
    totalAmountTimeCombo.setBorder(null);
    panel.add(totalAmountTimeCombo);
    layout.putConstraint(SpringLayout.NORTH, totalAmountTimeCombo, 5, SpringLayout.SOUTH, totalAmountTimeLabel);
    layout.putConstraint(SpringLayout.WEST, totalAmountTimeCombo, 5, SpringLayout.WEST, panel);

    TOTAL_AMOUNT_TIME.setColumns(20);
    panel.add(TOTAL_AMOUNT_TIME);
    layout.putConstraint(SpringLayout.NORTH, TOTAL_AMOUNT_TIME, 5, SpringLayout.SOUTH, totalAmountTimeCombo);
    layout.putConstraint(SpringLayout.WEST, TOTAL_AMOUNT_TIME, 5, SpringLayout.WEST, panel);

    Label totalAmountCapitalLabel = new Label(Parameters.getBundle().getString("capital"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    panel.add(totalAmountCapitalLabel);
    layout.putConstraint(SpringLayout.NORTH, totalAmountCapitalLabel, 5, SpringLayout.SOUTH, TOTAL_AMOUNT_TIME);
    layout.putConstraint(SpringLayout.WEST, totalAmountCapitalLabel, 5, SpringLayout.WEST, panel);

    TOTAL_AMOUNT_CAPITAL.setColumns(20);
    panel.add(TOTAL_AMOUNT_CAPITAL);
    layout.putConstraint(SpringLayout.NORTH, TOTAL_AMOUNT_CAPITAL, 5, SpringLayout.SOUTH, totalAmountCapitalLabel);
    layout.putConstraint(SpringLayout.WEST, TOTAL_AMOUNT_CAPITAL, 5, SpringLayout.WEST, panel);

    Label totalAmountQuoteLabel = new Label(Parameters.getBundle().getString("quote"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    panel.add(totalAmountQuoteLabel);
    layout.putConstraint(SpringLayout.NORTH, totalAmountQuoteLabel, 5, SpringLayout.SOUTH, TOTAL_AMOUNT_CAPITAL);
    layout.putConstraint(SpringLayout.WEST, totalAmountQuoteLabel, 5, SpringLayout.WEST, panel);

    TOTAL_AMOUNT_QUOTE.setColumns(20);
    panel.add(TOTAL_AMOUNT_QUOTE);
    layout.putConstraint(SpringLayout.NORTH, TOTAL_AMOUNT_QUOTE, 5, SpringLayout.SOUTH, totalAmountQuoteLabel);
    layout.putConstraint(SpringLayout.WEST, TOTAL_AMOUNT_QUOTE, 5, SpringLayout.WEST, panel);

    Label totalAmountValueLabel = new Label(Parameters.getBundle().getString("totalAmount"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    panel.add(totalAmountValueLabel);
    layout.putConstraint(SpringLayout.NORTH, totalAmountValueLabel, 5, SpringLayout.SOUTH, TOTAL_AMOUNT_QUOTE);
    layout.putConstraint(SpringLayout.WEST, totalAmountValueLabel, 5, SpringLayout.WEST, panel);

    TOTAL_AMOUNT_VALUE.setColumns(20);
    panel.add(TOTAL_AMOUNT_VALUE);
    layout.putConstraint(SpringLayout.NORTH, TOTAL_AMOUNT_VALUE, 5, SpringLayout.SOUTH, totalAmountValueLabel);
    layout.putConstraint(SpringLayout.WEST, TOTAL_AMOUNT_VALUE, 5, SpringLayout.WEST, panel);

    Button totalAmountCalcButton = new Button(Parameters.getBundle().getString("calculate"), UIHelper.getBrightButtonColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
    totalAmountCalcButton.addActionListener(e -> {
      try {
        insertTotalAmountData();
        double result = TOTAL_AMOUNT_HANDLER.calculate(totalAmountTimeCombo.getSelectedIndex());
        if (!Double.isNaN(result)) {
          JOptionPane.showInternalMessageDialog(null, String.format(Parameters.getBundle().getString("solutionIs"), result));
        } else {
          JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("calculationError"));
        }
      } catch (InputMismatchException exception) {
        TOTAL_AMOUNT_HANDLER.reset();
        return;
      }
      TOTAL_AMOUNT_HANDLER.reset();
    });
    panel.add(totalAmountCalcButton);
    layout.putConstraint(SpringLayout.SOUTH, totalAmountCalcButton, -25, SpringLayout.SOUTH, panel);
    layout.putConstraint(SpringLayout.EAST, totalAmountCalcButton, -50, SpringLayout.EAST, panel);

    Button totalAmountResetButton = new Button(Parameters.getBundle().getString("reset"), UIHelper.getBrightButtonColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
    totalAmountResetButton.addActionListener(e -> resetTotalAmount());
    panel.add(totalAmountResetButton);
    layout.putConstraint(SpringLayout.NORTH, totalAmountResetButton, 0, SpringLayout.NORTH, totalAmountCalcButton);
    layout.putConstraint(SpringLayout.EAST, totalAmountResetButton, -10, SpringLayout.WEST, totalAmountCalcButton);

    totalAmountLeapYearCheck = new JCheckBox(Parameters.getBundle().getString("leapYear"));
    totalAmountLeapYearCheck.setBackground(UIHelper.getMainWindowColor());
    totalAmountLeapYearCheck.setForeground(UIHelper.getPrimaryTextColor());
    panel.add(totalAmountLeapYearCheck);
    layout.putConstraint(SpringLayout.NORTH, totalAmountLeapYearCheck, 0,SpringLayout.NORTH, totalAmountResetButton);
    layout.putConstraint(SpringLayout.EAST, totalAmountLeapYearCheck, -10, SpringLayout.WEST, totalAmountResetButton);

    return panel;
  }

  /**
   * Writes total amount data given by the user into the {@link TotalAmountHandler}
   * object associated with the current instance of the {@code InterestTotAmountDialog}
   * object.
   *
   * @throws InputMismatchException if provided wrong type value for any of the
   * text fields
   */
  private void insertTotalAmountData() throws InputMismatchException {
    ArrayList<TextField> solutionTerm = new ArrayList<>(1);
    for (TextField textField : new TextField[]{TOTAL_AMOUNT_CAPITAL, TOTAL_AMOUNT_TIME, TOTAL_AMOUNT_QUOTE, TOTAL_AMOUNT_VALUE}) {
      if (textField.getText().isEmpty()) solutionTerm.add(textField);
    }
    if (solutionTerm.size() != 1) {
      JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("wrongInput"));
      throw new InputMismatchException("Expected 1 unknown value, got: " + solutionTerm.size());
    }

    try {
      if (!TOTAL_AMOUNT_CAPITAL.equals(solutionTerm.get(0))) TOTAL_AMOUNT_HANDLER.setCapital(Double.parseDouble(TOTAL_AMOUNT_CAPITAL.getText()));
    } catch (Exception e) {
      JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("capitalError"));
      INTEREST_HANDLER.reset();
      throw new InputMismatchException("Expected double value for total amount capital.");
    }

    try {
      if (!TOTAL_AMOUNT_TIME.equals(solutionTerm.get(0))) {
        if (totalAmountTimeCombo.getSelectedIndex() == DAYS_CALCULATION) TOTAL_AMOUNT_HANDLER.setTime(TimeValidator.DAYS.valueOrBetween(TOTAL_AMOUNT_TIME.getText()));
        if (totalAmountTimeCombo.getSelectedIndex() == MONTHS_CALCULATION) TOTAL_AMOUNT_HANDLER.setTime(TimeValidator.MONTHS.valueOrBetween(TOTAL_AMOUNT_TIME.getText()));
        if (totalAmountTimeCombo.getSelectedIndex() == YEARS_CALCULATION) TOTAL_AMOUNT_HANDLER.setTime(TimeValidator.YEARS.valueOrBetween(TOTAL_AMOUNT_TIME.getText()));
      }
    } catch (Exception e) {
      JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("timeError"));
      INTEREST_HANDLER.reset();
      throw new InputMismatchException("Expected valid time expression for total amount time.");
    }

    try {
      if (!TOTAL_AMOUNT_QUOTE.equals(solutionTerm.get(0))) TOTAL_AMOUNT_HANDLER.setQuote(Double.parseDouble(TOTAL_AMOUNT_QUOTE.getText()));
    } catch (Exception e) {
      JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("quoteError"));
      TOTAL_AMOUNT_HANDLER.reset();
      throw new InputMismatchException("Expected double value for total amount quote.");
    }

    try {
      if (!TOTAL_AMOUNT_VALUE.equals(solutionTerm.get(0))) TOTAL_AMOUNT_HANDLER.setTotalAmount(Double.parseDouble(TOTAL_AMOUNT_VALUE.getText()));
    } catch (Exception e) {
      JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("totalAmountError"));
      TOTAL_AMOUNT_HANDLER.reset();
      throw new InputMismatchException("Expected double value for total amount.");
    }

    TOTAL_AMOUNT_HANDLER.setLeapYear(totalAmountLeapYearCheck.isSelected());
  }

  /**
   * Resets the text fields of the total amount on the screen and resets the
   * {@link TotalAmountHandler} object to its initial state.
   */
  private void resetTotalAmount() {
    for (TextField textField : new TextField[]{TOTAL_AMOUNT_TIME, TOTAL_AMOUNT_CAPITAL, TOTAL_AMOUNT_QUOTE, TOTAL_AMOUNT_VALUE}) {
      textField.setText("");
    }
    totalAmountTimeCombo.setSelectedIndex(0);
    totalAmountLeapYearCheck.setSelected(false);
    TOTAL_AMOUNT_HANDLER.reset();
  }
}