// Copyright 2023-2024 Artiom Astashonak. Use of this code is governed by the Apache License 2.0 that can be found in the LICENSE file.
package com.artiomastashonak.schoolaccountingstudio.discount;

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
 * The {@code DiscountPresentValueDialog} is a {@link JDialog} inherited object
 * that displays the user the input prompts to compute the discount and the
 * present values.
 * <p>
 * It communicates with {@link DiscountHandler} and with
 * {@link PresentValueHandler} objects to provide defined solutions.
 *
 * @see JDialog
 * @see DiscountHandler
 * @see PresentValueHandler
 *
 * @author Artiom Astashonak
 */
public class DiscountPresentValueDialog extends JDialog {
  private final DiscountHandler DISCOUNT_HANDLER = new DiscountHandler();
  private final PresentValueHandler PRESENT_VALUE_HANDLER = new PresentValueHandler();

  private JComboBox<String> discountTimeCombo;
  private final TextField DISCOUNT_TIME = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
  private final TextField DISCOUNT_CAPITAL = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
  private final TextField DISCOUNT_QUOTE = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
  private final TextField DISCOUNT_VALUE = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
  private JCheckBox discountLeapYearCheck;

  private JComboBox<String> presentValueTimeCombo;
  private final TextField PRESENT_VALUE_TIME = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
  private final TextField PRESENT_VALUE_CAPITAL = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
  private final TextField PRESENT_VALUE_QUOTE = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
  private final TextField PRESENT_VALUE = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
  private JCheckBox presentValueLeapYearCheck;

  private final int DAYS_CALCULATION = 0;
  private final int MONTHS_CALCULATION = 1;
  private final int YEARS_CALCULATION = 2;

  /**
   * Assembles a new {@code DiscountPresentValueDialog} object with initial values set up.
   */
  public DiscountPresentValueDialog() {
    setMinimumSize(new Dimension(600, 550));
    setTitle(Parameters.getBundle().getString("discountCalculator"));
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

    Button discountViewButton = new Button(Parameters.getBundle().getString("discount"), UIHelper.getBrightButtonColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
    switchPanel.add(discountViewButton);

    Button presValueViewButton = new Button(Parameters.getBundle().getString("presentValue"), UIHelper.getBrightButtonColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
    switchPanel.add(presValueViewButton);

    JPanel discountPanel = createDiscountPanel();
    mainPanel.add(discountPanel, "DISCOUNT");

    JPanel presentValuePanel = createPresentValuePanel();
    mainPanel.add(presentValuePanel, "PRES_VALUE");

    mainLayout.show(mainPanel, "DISCOUNT");

    discountViewButton.addActionListener(e -> mainLayout.show(mainPanel, "DISCOUNT"));
    presValueViewButton.addActionListener(e -> mainLayout.show(mainPanel, "PRES_VALUE"));

    show();
  }

  /**
   * Creates and sets the layout for the discount {@link JPanel} object.
   *
   * @return discount {@link JPanel} object
   */
  private @NotNull JPanel createDiscountPanel() {
    JPanel panel = new JPanel();
    panel.setBackground(UIHelper.getMainWindowColor());
    SpringLayout layout = new SpringLayout();
    panel.setLayout(layout);

    Label discountCalculatorLabel = new Label(Parameters.getBundle().getString("discountCalculator"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getSubsectionTitleFont());
    panel.add(discountCalculatorLabel);
    layout.putConstraint(SpringLayout.NORTH, discountCalculatorLabel, 5, SpringLayout.NORTH, panel);
    layout.putConstraint(SpringLayout.WEST, discountCalculatorLabel, 5, SpringLayout.WEST, panel);

    Label discountTimeLabel = new Label(Parameters.getBundle().getString("time"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    panel.add(discountTimeLabel);
    layout.putConstraint(SpringLayout.NORTH, discountTimeLabel, 5, SpringLayout.SOUTH, discountCalculatorLabel);
    layout.putConstraint(SpringLayout.WEST, discountTimeLabel, 5, SpringLayout.WEST, panel);

    discountTimeCombo = new JComboBox<>(new String[]{Parameters.getBundle().getString("days"), Parameters.getBundle().getString("months"), Parameters.getBundle().getString("years")});
    discountTimeCombo.setBackground(UIHelper.getMenuBarColor());
    discountTimeCombo.setForeground(UIHelper.getPrimaryTextColor());
    discountTimeCombo.setBorder(null);
    panel.add(discountTimeCombo);
    layout.putConstraint(SpringLayout.NORTH, discountTimeCombo, 5, SpringLayout.SOUTH, discountTimeLabel);
    layout.putConstraint(SpringLayout.WEST, discountTimeCombo, 5, SpringLayout.WEST, panel);

    DISCOUNT_TIME.setColumns(20);
    panel.add(DISCOUNT_TIME);
    layout.putConstraint(SpringLayout.NORTH, DISCOUNT_TIME, 5, SpringLayout.SOUTH, discountTimeCombo);
    layout.putConstraint(SpringLayout.WEST, DISCOUNT_TIME, 5, SpringLayout.WEST, panel);

    Label discountCapitalLabel = new Label(Parameters.getBundle().getString("capital"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    panel.add(discountCapitalLabel);
    layout.putConstraint(SpringLayout.NORTH, discountCapitalLabel, 5, SpringLayout.SOUTH, DISCOUNT_TIME);
    layout.putConstraint(SpringLayout.WEST, discountCapitalLabel, 5, SpringLayout.WEST, panel);

    DISCOUNT_CAPITAL.setColumns(20);
    panel.add(DISCOUNT_CAPITAL);
    layout.putConstraint(SpringLayout.NORTH, DISCOUNT_CAPITAL, 5, SpringLayout.SOUTH, discountCapitalLabel);
    layout.putConstraint(SpringLayout.WEST, DISCOUNT_CAPITAL, 5, SpringLayout.WEST, panel);

    Label discountQuoteLabel = new Label(Parameters.getBundle().getString("quote"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    panel.add(discountQuoteLabel);
    layout.putConstraint(SpringLayout.NORTH, discountQuoteLabel, 5, SpringLayout.SOUTH, DISCOUNT_CAPITAL);
    layout.putConstraint(SpringLayout.WEST, discountQuoteLabel, 5, SpringLayout.WEST, panel);

    DISCOUNT_QUOTE.setColumns(20);
    panel.add(DISCOUNT_QUOTE);
    layout.putConstraint(SpringLayout.NORTH, DISCOUNT_QUOTE, 5, SpringLayout.SOUTH, discountQuoteLabel);
    layout.putConstraint(SpringLayout.WEST, DISCOUNT_QUOTE, 5, SpringLayout.WEST, panel);

    Label discountdiscountLabel = new Label(Parameters.getBundle().getString("discount"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    panel.add(discountdiscountLabel);
    layout.putConstraint(SpringLayout.NORTH, discountdiscountLabel, 5, SpringLayout.SOUTH, DISCOUNT_QUOTE);
    layout.putConstraint(SpringLayout.WEST, discountdiscountLabel, 5, SpringLayout.WEST, panel);

    DISCOUNT_VALUE.setColumns(20);
    panel.add(DISCOUNT_VALUE);
    layout.putConstraint(SpringLayout.NORTH, DISCOUNT_VALUE, 5, SpringLayout.SOUTH, discountdiscountLabel);
    layout.putConstraint(SpringLayout.WEST, DISCOUNT_VALUE, 5, SpringLayout.WEST, panel);

    Button discountCalcButton = new Button(Parameters.getBundle().getString("calculate"), UIHelper.getBrightButtonColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
    discountCalcButton.addActionListener(e -> {
      try {
        insertDiscountData();
        double result = DISCOUNT_HANDLER.calculate(discountTimeCombo.getSelectedIndex());
        if (!Double.isNaN(result)) {
          JOptionPane.showInternalMessageDialog(null, String.format(Parameters.getBundle().getString("solutionIs"), result));
        } else {
          JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("calculationError"));
        }
      } catch (InputMismatchException exception) {
        DISCOUNT_HANDLER.reset();
        return;
      }
      DISCOUNT_HANDLER.reset();
    });
    panel.add(discountCalcButton);
    layout.putConstraint(SpringLayout.SOUTH, discountCalcButton, -25, SpringLayout.SOUTH, panel);
    layout.putConstraint(SpringLayout.EAST, discountCalcButton, -50, SpringLayout.EAST, panel);

    Button discountResetButton = new Button(Parameters.getBundle().getString("reset"), UIHelper.getBrightButtonColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
    discountResetButton.addActionListener(e -> resetDiscount());
    panel.add(discountResetButton);
    layout.putConstraint(SpringLayout.NORTH, discountResetButton, 0, SpringLayout.NORTH, discountCalcButton);
    layout.putConstraint(SpringLayout.EAST, discountResetButton, -10, SpringLayout.WEST, discountCalcButton);

    discountLeapYearCheck = new JCheckBox(Parameters.getBundle().getString("leapYear"));
    discountLeapYearCheck.setBackground(UIHelper.getMainWindowColor());
    discountLeapYearCheck.setForeground(UIHelper.getPrimaryTextColor());
    panel.add(discountLeapYearCheck);
    layout.putConstraint(SpringLayout.NORTH, discountLeapYearCheck, 0, SpringLayout.NORTH, discountResetButton);
    layout.putConstraint(SpringLayout.EAST, discountLeapYearCheck, -10, SpringLayout.WEST, discountResetButton);

    return panel;
  }

  /**
   * Writes discount data given by the user into the {@link DiscountHandler} object
   * associated with the current instance of the {@code DiscountPresentValueDialog} object.
   *
   * @throws InputMismatchException if provided wrong type value for any of the
   * text fields
   */
  private void insertDiscountData() throws InputMismatchException {
    ArrayList<TextField> solutionTerm = new ArrayList<>(1);
    for (TextField textField : new TextField[]{DISCOUNT_CAPITAL, DISCOUNT_TIME, DISCOUNT_QUOTE, DISCOUNT_VALUE}) {
      if (textField.getText().isEmpty()) solutionTerm.add(textField);
    }
    if (solutionTerm.size() != 1) {
      JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("wrongInput"));
      throw new InputMismatchException("Expected 1 unknown value, got: " + solutionTerm.size());
    }
    try {
      if (!DISCOUNT_CAPITAL.equals(solutionTerm.get(0))) DISCOUNT_HANDLER.setCapital(Double.parseDouble(DISCOUNT_CAPITAL.getText()));
    } catch (Exception e) {
      JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("capitalError"));
      DISCOUNT_HANDLER.reset();
      throw new InputMismatchException("Expected double value for discount capital.");
    }

    try {
      if (!DISCOUNT_TIME.equals(solutionTerm.get(0))) {
        if (discountTimeCombo.getSelectedIndex() == DAYS_CALCULATION) DISCOUNT_HANDLER.setTime(TimeValidator.DAYS.valueOrBetween(DISCOUNT_TIME.getText()));
        if (discountTimeCombo.getSelectedIndex() == MONTHS_CALCULATION) DISCOUNT_HANDLER.setTime(TimeValidator.MONTHS.valueOrBetween(DISCOUNT_TIME.getText()));
        if (discountTimeCombo.getSelectedIndex() == YEARS_CALCULATION) DISCOUNT_HANDLER.setTime(TimeValidator.YEARS.valueOrBetween(DISCOUNT_TIME.getText()));
      }
    } catch (Exception e) {
      JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("timeError"));
      DISCOUNT_HANDLER.reset();
      throw new InputMismatchException("Expected valid time expression for discount time.");
    }

    try {
      if (!DISCOUNT_QUOTE.equals(solutionTerm.get(0))) DISCOUNT_HANDLER.setQuote(Double.parseDouble(DISCOUNT_QUOTE.getText()));
    } catch (Exception e) {
      JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("quoteError"));
      DISCOUNT_HANDLER.reset();
      throw new InputMismatchException("Expected double value for discount quote.");
    }

    try {
      if (!DISCOUNT_VALUE.equals(solutionTerm.get(0))) DISCOUNT_HANDLER.setDiscount(Double.parseDouble(DISCOUNT_VALUE.getText()));
    } catch (Exception e) {
      JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("financialDiscountError"));
      DISCOUNT_HANDLER.reset();
      throw new InputMismatchException("Expected double value for discount.");
    }

    DISCOUNT_HANDLER.setLeapYear(discountLeapYearCheck.isSelected());
  }

  /**
   * Resets the text fields of the discount on the screen and resets the
   * {@link DiscountHandler} object to its initial state.
   */
  private void resetDiscount() {
    for (TextField textField : new TextField[]{DISCOUNT_TIME, DISCOUNT_CAPITAL, DISCOUNT_QUOTE, DISCOUNT_VALUE}) {
      textField.setText("");
    }
    discountTimeCombo.setSelectedIndex(0);
    discountLeapYearCheck.setSelected(false);
    DISCOUNT_HANDLER.reset();
  }

  /**
   * Creates and sets the layout for the present value {@link JPanel} object.
   *
   * @return present value {@link JPanel} object
   */
  private @NotNull JPanel createPresentValuePanel() {
    JPanel panel = new JPanel();
    panel.setBackground(UIHelper.getMainWindowColor());
    SpringLayout layout = new SpringLayout();
    panel.setLayout(layout);

    Label presentValueCalculatorLabel = new Label(Parameters.getBundle().getString("presentValueCalculator"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getSubsectionTitleFont());
    panel.add(presentValueCalculatorLabel);
    layout.putConstraint(SpringLayout.NORTH, presentValueCalculatorLabel, 5, SpringLayout.NORTH, panel);
    layout.putConstraint(SpringLayout.WEST, presentValueCalculatorLabel, 5, SpringLayout.WEST, panel);

    Label presentValueTimeLabel = new Label(Parameters.getBundle().getString("time"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    panel.add(presentValueTimeLabel);
    layout.putConstraint(SpringLayout.NORTH, presentValueTimeLabel, 5, SpringLayout.SOUTH, presentValueCalculatorLabel);
    layout.putConstraint(SpringLayout.WEST, presentValueTimeLabel, 5, SpringLayout.WEST, panel);

    presentValueTimeCombo = new JComboBox<>(new String[]{Parameters.getBundle().getString("days"), Parameters.getBundle().getString("months"), Parameters.getBundle().getString("years")});
    presentValueTimeCombo.setBackground(UIHelper.getMenuBarColor());
    presentValueTimeCombo.setForeground(UIHelper.getPrimaryTextColor());
    presentValueTimeCombo.setBorder(null);
    panel.add(presentValueTimeCombo);
    layout.putConstraint(SpringLayout.NORTH, presentValueTimeCombo, 5, SpringLayout.SOUTH, presentValueTimeLabel);
    layout.putConstraint(SpringLayout.WEST, presentValueTimeCombo, 5, SpringLayout.WEST, panel);

    PRESENT_VALUE_TIME.setColumns(20);
    panel.add(PRESENT_VALUE_TIME);
    layout.putConstraint(SpringLayout.NORTH, PRESENT_VALUE_TIME, 5, SpringLayout.SOUTH, presentValueTimeCombo);
    layout.putConstraint(SpringLayout.WEST, PRESENT_VALUE_TIME, 5, SpringLayout.WEST, panel);

    Label presentValueCapitalLabel = new Label(Parameters.getBundle().getString("capital"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    panel.add(presentValueCapitalLabel);
    layout.putConstraint(SpringLayout.NORTH, presentValueCapitalLabel, 5, SpringLayout.SOUTH, PRESENT_VALUE_TIME);
    layout.putConstraint(SpringLayout.WEST, presentValueCapitalLabel, 5, SpringLayout.WEST, panel);

    PRESENT_VALUE_CAPITAL.setColumns(20);
    panel.add(PRESENT_VALUE_CAPITAL);
    layout.putConstraint(SpringLayout.NORTH, PRESENT_VALUE_CAPITAL, 5, SpringLayout.SOUTH, presentValueCapitalLabel);
    layout.putConstraint(SpringLayout.WEST, PRESENT_VALUE_CAPITAL, 5, SpringLayout.WEST, panel);

    Label presentValueQuoteLabel = new Label(Parameters.getBundle().getString("quote"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    panel.add(presentValueQuoteLabel);
    layout.putConstraint(SpringLayout.NORTH, presentValueQuoteLabel, 5, SpringLayout.SOUTH, PRESENT_VALUE_CAPITAL);
    layout.putConstraint(SpringLayout.WEST, presentValueQuoteLabel, 5, SpringLayout.WEST, panel);

    PRESENT_VALUE_QUOTE.setColumns(20);
    panel.add(PRESENT_VALUE_QUOTE);
    layout.putConstraint(SpringLayout.NORTH, PRESENT_VALUE_QUOTE, 5, SpringLayout.SOUTH, presentValueQuoteLabel);
    layout.putConstraint(SpringLayout.WEST, PRESENT_VALUE_QUOTE, 5, SpringLayout.WEST, panel);

    Label presentValueLabel = new Label(Parameters.getBundle().getString("presentValue"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    panel.add(presentValueLabel);
    layout.putConstraint(SpringLayout.NORTH, presentValueLabel, 5, SpringLayout.SOUTH, PRESENT_VALUE_QUOTE);
    layout.putConstraint(SpringLayout.WEST, presentValueLabel, 5, SpringLayout.WEST, panel);

    PRESENT_VALUE.setColumns(20);
    panel.add(PRESENT_VALUE);
    layout.putConstraint(SpringLayout.NORTH, PRESENT_VALUE, 5, SpringLayout.SOUTH, presentValueLabel);
    layout.putConstraint(SpringLayout.WEST, PRESENT_VALUE, 5, SpringLayout.WEST, panel);

    Button presentValueCalcButton = new Button(Parameters.getBundle().getString("calculate"), UIHelper.getBrightButtonColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
    presentValueCalcButton.addActionListener(e -> {
      try {
        insertPresentValueData();
        double result = PRESENT_VALUE_HANDLER.calculate(presentValueTimeCombo.getSelectedIndex());
        if (!Double.isNaN(result)) {
          JOptionPane.showInternalMessageDialog(null, String.format(Parameters.getBundle().getString("solutionIs"), result));
        } else {
          JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("calculationError"));
        }
      } catch (InputMismatchException exception) {
        PRESENT_VALUE_HANDLER.reset();
        return;
      }
      PRESENT_VALUE_HANDLER.reset();
    });
    panel.add(presentValueCalcButton);
    layout.putConstraint(SpringLayout.SOUTH, presentValueCalcButton, -25, SpringLayout.SOUTH, panel);
    layout.putConstraint(SpringLayout.EAST, presentValueCalcButton, -50, SpringLayout.EAST, panel);

    Button presentValueResetButton = new Button(Parameters.getBundle().getString("reset"), UIHelper.getBrightButtonColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
    presentValueResetButton.addActionListener(e -> resetPresentValue());
    panel.add(presentValueResetButton);
    layout.putConstraint(SpringLayout.NORTH, presentValueResetButton, 0, SpringLayout.NORTH, presentValueCalcButton);
    layout.putConstraint(SpringLayout.EAST, presentValueResetButton, -10, SpringLayout.WEST, presentValueCalcButton);

    presentValueLeapYearCheck = new JCheckBox(Parameters.getBundle().getString("leapYear"));
    presentValueLeapYearCheck.setBackground(UIHelper.getMainWindowColor());
    presentValueLeapYearCheck.setForeground(UIHelper.getPrimaryTextColor());
    panel.add(presentValueLeapYearCheck);
    layout.putConstraint(SpringLayout.NORTH, presentValueLeapYearCheck, 0,SpringLayout.NORTH, presentValueResetButton);
    layout.putConstraint(SpringLayout.EAST, presentValueLeapYearCheck, -10, SpringLayout.WEST, presentValueResetButton);

    return panel;
  }

  /**
   * Writes present value data given by the user into the {@link PresentValueHandler}
   * object associated with the current instance of the {@code DiscountPresentValueDialog}
   * object.
   *
   * @throws InputMismatchException if provided wrong type value for any of the
   * text fields
   */
  private void insertPresentValueData() throws InputMismatchException {
    ArrayList<TextField> solutionTerm = new ArrayList<>(1);
    for (TextField textField : new TextField[]{PRESENT_VALUE_CAPITAL, PRESENT_VALUE_TIME, PRESENT_VALUE_QUOTE, PRESENT_VALUE}) {
      if (textField.getText().isEmpty()) solutionTerm.add(textField);
    }
    if (solutionTerm.size() != 1) {
      JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("wrongInput"));
      throw new InputMismatchException("Expected 1 unknown value, got: " + solutionTerm.size());
    }

    try {
      if (!PRESENT_VALUE_CAPITAL.equals(solutionTerm.get(0))) PRESENT_VALUE_HANDLER.setCapital(Double.parseDouble(PRESENT_VALUE_CAPITAL.getText()));
    } catch (Exception e) {
      JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("capitalError"));
      PRESENT_VALUE_HANDLER.reset();
      throw new InputMismatchException("Expected double value for present value capital.");
    }

    try {
      if (!PRESENT_VALUE_TIME.equals(solutionTerm.get(0))) {
        if (presentValueTimeCombo.getSelectedIndex() == DAYS_CALCULATION) PRESENT_VALUE_HANDLER.setTime(TimeValidator.DAYS.valueOrBetween(PRESENT_VALUE_TIME.getText()));
        if (presentValueTimeCombo.getSelectedIndex() == MONTHS_CALCULATION) PRESENT_VALUE_HANDLER.setTime(TimeValidator.MONTHS.valueOrBetween(PRESENT_VALUE_TIME.getText()));
        if (presentValueTimeCombo.getSelectedIndex() == YEARS_CALCULATION) PRESENT_VALUE_HANDLER.setTime(TimeValidator.YEARS.valueOrBetween(PRESENT_VALUE_TIME.getText()));
      }
    } catch (Exception e) {
      JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("timeError"));
      PRESENT_VALUE_HANDLER.reset();
      throw new InputMismatchException("Expected valid time expression for present value time.");
    }

    try {
      if (!PRESENT_VALUE_QUOTE.equals(solutionTerm.get(0))) PRESENT_VALUE_HANDLER.setQuote(Double.parseDouble(PRESENT_VALUE_QUOTE.getText()));
    } catch (Exception e) {
      JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("quoteError"));
      PRESENT_VALUE_HANDLER.reset();
      throw new InputMismatchException("Expected double value for present value quote.");
    }

    try {
      if (!PRESENT_VALUE.equals(solutionTerm.get(0))) PRESENT_VALUE_HANDLER.setPresentValue(Double.parseDouble(PRESENT_VALUE.getText()));
    } catch (Exception e) {
      JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("presentValueError"));
      PRESENT_VALUE_HANDLER.reset();
      throw new InputMismatchException("Expected double value for present value.");
    }

    PRESENT_VALUE_HANDLER.setLeapYear(presentValueLeapYearCheck.isSelected());
  }

  /**
   * Resets the text fields of the present value on the screen and resets the
   * {@link PresentValueHandler} object to its initial state.
   */
  private void resetPresentValue() {
    for (TextField textField : new TextField[]{PRESENT_VALUE_TIME, PRESENT_VALUE_CAPITAL, PRESENT_VALUE_QUOTE, PRESENT_VALUE}) {
      textField.setText("");
    }
    presentValueTimeCombo.setSelectedIndex(0);
    presentValueLeapYearCheck.setSelected(false);
    PRESENT_VALUE_HANDLER.reset();
  }
}