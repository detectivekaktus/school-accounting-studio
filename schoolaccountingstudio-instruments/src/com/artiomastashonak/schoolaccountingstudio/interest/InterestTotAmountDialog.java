package com.artiomastashonak.schoolaccountingstudio.interest;

import com.artiomastashonak.schoolaccountingstudio.Button;
import com.artiomastashonak.schoolaccountingstudio.DarkThemeColors;
import com.artiomastashonak.schoolaccountingstudio.Label;
import com.artiomastashonak.schoolaccountingstudio.TextField;
import com.artiomastashonak.schoolaccountingstudio.TextSizes;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InterestTotAmountDialog extends JDialog {
  private final ResourceBundle BUNDLE;
  private final InterestHandler INTEREST_HANDLER = new InterestHandler();
  private final TotalAmountHandler TOTAL_AMOUNT_HANDLER = new TotalAmountHandler();
  private final Color MAIN_WINDOW_COLOR = DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color;
  private final Color TEXT_INPUT_COLOR = DarkThemeColors.MENU_BAR_BACKGROUND_COLOR.color;
  private final Color BUTTON_COLOR = DarkThemeColors.BUTTON_BACKGROUND_COLOR.color;
  private final Color TEXT_COLOR = DarkThemeColors.PRIMARY_TEXT_COLOR.color;
  private final Font SECTION_TITLE_FONT = new Font("sans-serif", Font.BOLD, TextSizes.SUBSECTION_TITLE_TEXT_SIZE.size);
  private final Font ELEMENT_TITLE_FONT = new Font("sans-serif", Font.BOLD, TextSizes.ELEMENT_TITLE_TEXT_SIZE.size);
  private final Font INPUT_FONT = new Font("sans-serif", Font.PLAIN, TextSizes.BUTTON_TEXT_SIZE.size);

  private JComboBox<String> interestTimeCombo;
  private final TextField INTEREST_TIME = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
  private final TextField INTEREST_CAPITAL = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
  private final TextField INTEREST_QUOTE = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
  private final TextField INTEREST_VALUE = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
  private JCheckBox interestLeapYearCheck;

  private JComboBox<String> totAmountTimeCombo;
  private final TextField TOTAL_AMOUNT_TIME = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
  private final TextField TOTAL_AMOUNT_CAPITAL = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
  private final TextField TOTAL_AMOUNT_QUOTE = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
  private final TextField TOTAL_AMOUNT_VALUE = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
  private JCheckBox totAmountLeapYearCheck;

  public InterestTotAmountDialog(ResourceBundle bundle) {
    this.BUNDLE = bundle;

    setMinimumSize(new Dimension(600, 550));
    setTitle(BUNDLE.getString("interestCalculator"));
    getContentPane().setBackground(MAIN_WINDOW_COLOR);
    setModal(false);
    setLayout(new BorderLayout());

    JPanel mainPanel = new JPanel();
    mainPanel.setBackground(MAIN_WINDOW_COLOR);
    CardLayout mainLayout = new CardLayout();
    mainPanel.setLayout(mainLayout);
    add(mainPanel, BorderLayout.CENTER);

    JPanel switchPanel = new JPanel();
    switchPanel.setBackground(TEXT_INPUT_COLOR);
    switchPanel.setLayout(new BoxLayout(switchPanel, BoxLayout.Y_AXIS));
    add(switchPanel, BorderLayout.WEST);

    Button interestViewButton = new Button(BUNDLE.getString("interest"), BUTTON_COLOR, TEXT_COLOR, INPUT_FONT);
    switchPanel.add(interestViewButton);

    Button totAmountViewButton = new Button(BUNDLE.getString("totalAmount"), BUTTON_COLOR, TEXT_COLOR, INPUT_FONT);
    switchPanel.add(totAmountViewButton);

    JPanel interestPanel = createInterestPanel();
    mainPanel.add(interestPanel, "INTEREST");

    JPanel totAmountPanel = createTotAmountPanel();
    mainPanel.add(totAmountPanel, "TOT_AMOUNT");

    mainLayout.show(mainPanel, "INTEREST");

    interestViewButton.addActionListener((e) -> mainLayout.show(mainPanel, "INTEREST"));
    totAmountViewButton.addActionListener((e) -> mainLayout.show(mainPanel, "TOT_AMOUNT"));

    show();
  }

  private JPanel createInterestPanel() {
    JPanel interestPanel = new JPanel();
    interestPanel.setBackground(MAIN_WINDOW_COLOR);
    SpringLayout layout = new SpringLayout();
    interestPanel.setLayout(layout);

    Label interestCalculatorLabel = new Label(BUNDLE.getString("interestCalculator"), MAIN_WINDOW_COLOR, TEXT_COLOR, SECTION_TITLE_FONT);
    interestPanel.add(interestCalculatorLabel);
    layout.putConstraint(SpringLayout.NORTH, interestCalculatorLabel, 5, SpringLayout.NORTH, interestPanel);
    layout.putConstraint(SpringLayout.WEST, interestCalculatorLabel, 5, SpringLayout.WEST, interestPanel);

    Label interestTimeLabel = new Label(BUNDLE.getString("time"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    interestPanel.add(interestTimeLabel);
    layout.putConstraint(SpringLayout.NORTH, interestTimeLabel, 5, SpringLayout.SOUTH, interestCalculatorLabel);
    layout.putConstraint(SpringLayout.WEST, interestTimeLabel, 5, SpringLayout.WEST, interestPanel);

    interestTimeCombo = new JComboBox<>(new String[]{BUNDLE.getString("days"), BUNDLE.getString("months"), BUNDLE.getString("years")});
    interestTimeCombo.setBackground(TEXT_INPUT_COLOR);
    interestTimeCombo.setForeground(TEXT_COLOR);
    interestTimeCombo.setBorder(null);
    interestPanel.add(interestTimeCombo);
    layout.putConstraint(SpringLayout.NORTH, interestTimeCombo, 5, SpringLayout.SOUTH, interestTimeLabel);
    layout.putConstraint(SpringLayout.WEST, interestTimeCombo, 5, SpringLayout.WEST, interestPanel);

    INTEREST_TIME.setColumns(20);
    interestPanel.add(INTEREST_TIME);
    layout.putConstraint(SpringLayout.NORTH, INTEREST_TIME, 5, SpringLayout.SOUTH, interestTimeCombo);
    layout.putConstraint(SpringLayout.WEST, INTEREST_TIME, 5, SpringLayout.WEST, interestPanel);

    Label interestCapitalLabel = new Label(BUNDLE.getString("capital"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    interestPanel.add(interestCapitalLabel);
    layout.putConstraint(SpringLayout.NORTH, interestCapitalLabel, 5, SpringLayout.SOUTH, INTEREST_TIME);
    layout.putConstraint(SpringLayout.WEST, interestCapitalLabel, 5, SpringLayout.WEST, interestPanel);

    INTEREST_CAPITAL.setColumns(20);
    interestPanel.add(INTEREST_CAPITAL);
    layout.putConstraint(SpringLayout.NORTH, INTEREST_CAPITAL, 5, SpringLayout.SOUTH, interestCapitalLabel);
    layout.putConstraint(SpringLayout.WEST, INTEREST_CAPITAL, 5, SpringLayout.WEST, interestPanel);

    Label interestQuoteLabel = new Label(BUNDLE.getString("quote"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    interestPanel.add(interestQuoteLabel);
    layout.putConstraint(SpringLayout.NORTH, interestQuoteLabel, 5, SpringLayout.SOUTH, INTEREST_CAPITAL);
    layout.putConstraint(SpringLayout.WEST, interestQuoteLabel, 5, SpringLayout.WEST, interestPanel);

    INTEREST_QUOTE.setColumns(20);
    interestPanel.add(INTEREST_QUOTE);
    layout.putConstraint(SpringLayout.NORTH, INTEREST_QUOTE, 5, SpringLayout.SOUTH, interestQuoteLabel);
    layout.putConstraint(SpringLayout.WEST, INTEREST_QUOTE, 5, SpringLayout.WEST, interestPanel);

    Label interestInterestLabel = new Label(BUNDLE.getString("interest"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    interestPanel.add(interestInterestLabel);
    layout.putConstraint(SpringLayout.NORTH, interestInterestLabel, 5, SpringLayout.SOUTH, INTEREST_QUOTE);
    layout.putConstraint(SpringLayout.WEST, interestInterestLabel, 5, SpringLayout.WEST, interestPanel);

    INTEREST_VALUE.setColumns(20);
    interestPanel.add(INTEREST_VALUE);
    layout.putConstraint(SpringLayout.NORTH, INTEREST_VALUE, 5, SpringLayout.SOUTH, interestInterestLabel);
    layout.putConstraint(SpringLayout.WEST, INTEREST_VALUE, 5, SpringLayout.WEST, interestPanel);

    Button interestCalcButton = new Button(BUNDLE.getString("calculate"), BUTTON_COLOR, TEXT_COLOR, INPUT_FONT);
    interestCalcButton.addActionListener((e) -> {
      insertInterestData();
      double result = INTEREST_HANDLER.calculate(interestTimeCombo.getSelectedIndex());
      if (result != -1) {
        JOptionPane.showInternalMessageDialog(null, String.format(BUNDLE.getString("solutionIs"), result));
      } else {
        JOptionPane.showInternalMessageDialog(null, BUNDLE.getString("calculationError"));
      }
    });
    interestPanel.add(interestCalcButton);
    layout.putConstraint(SpringLayout.SOUTH, interestCalcButton, -25, SpringLayout.SOUTH, interestPanel);
    layout.putConstraint(SpringLayout.EAST, interestCalcButton, -50, SpringLayout.EAST, interestPanel);

    Button interestResetButton = new Button(BUNDLE.getString("reset"), BUTTON_COLOR, TEXT_COLOR, INPUT_FONT);
    interestResetButton.addActionListener((e) -> resetInterest());
    interestPanel.add(interestResetButton);
    layout.putConstraint(SpringLayout.NORTH, interestResetButton, 0, SpringLayout.NORTH, interestCalcButton);
    layout.putConstraint(SpringLayout.EAST, interestResetButton, -10, SpringLayout.WEST, interestCalcButton);

    interestLeapYearCheck = new JCheckBox(BUNDLE.getString("leapYear"));
    interestLeapYearCheck.setBackground(MAIN_WINDOW_COLOR);
    interestLeapYearCheck.setForeground(TEXT_COLOR);
    interestPanel.add(interestLeapYearCheck);
    layout.putConstraint(SpringLayout.NORTH, interestLeapYearCheck, 0, SpringLayout.NORTH, interestResetButton);
    layout.putConstraint(SpringLayout.EAST, interestLeapYearCheck, -10, SpringLayout.WEST, interestResetButton);

    return interestPanel;
  }

  private void insertInterestData() {
    ArrayList<TextField> solutionTerm = new ArrayList<>(1);
    for (TextField textField : new TextField[]{INTEREST_CAPITAL, INTEREST_TIME, INTEREST_QUOTE, INTEREST_VALUE}) {
      if (Objects.equals(textField.getText(), "")) {
        solutionTerm.add(textField);
      }
    }
    if (solutionTerm.size() != 1) {
      JOptionPane.showInternalMessageDialog(null, BUNDLE.getString("wrongInput"));
      return;
    }
    try {
      if (!INTEREST_CAPITAL.equals(solutionTerm.get(0))) {
        INTEREST_HANDLER.setCapital(Double.parseDouble(INTEREST_CAPITAL.getText()));
      }
    } catch (Exception e) {
      JOptionPane.showInternalMessageDialog(null, BUNDLE.getString("capitalError"));
      INTEREST_HANDLER.reset();
      return;
    }

    try {
      if (!INTEREST_TIME.equals(solutionTerm.get(0))) {
        INTEREST_HANDLER.setTime(validateTime(INTEREST_TIME, interestTimeCombo.getSelectedIndex()));
      }
    } catch (Exception e) {
      JOptionPane.showInternalMessageDialog(null, BUNDLE.getString("timeError"));
      INTEREST_HANDLER.reset();
      return;
    }

    try {
      if (!INTEREST_QUOTE.equals(solutionTerm.get(0))) {
        INTEREST_HANDLER.setQuote(Double.parseDouble(INTEREST_QUOTE.getText()));
      }
    } catch (Exception e) {
      JOptionPane.showInternalMessageDialog(null, BUNDLE.getString("quoteError"));
      INTEREST_HANDLER.reset();
      return;
    }

    try {
      if (!INTEREST_VALUE.equals(solutionTerm.get(0))) {
          INTEREST_HANDLER.setInterest(Double.parseDouble(INTEREST_VALUE.getText()));
      }
    } catch (Exception e) {
      JOptionPane.showInternalMessageDialog(null, BUNDLE.getString("interestError"));
      INTEREST_HANDLER.reset();
      return;
    }

    INTEREST_HANDLER.setLeapYear(interestLeapYearCheck.isSelected());
  }

  private void resetInterest() {
    for (TextField textField : new TextField[]{INTEREST_TIME, INTEREST_CAPITAL, INTEREST_QUOTE, INTEREST_VALUE}) {
      textField.setText("");
    }
    INTEREST_HANDLER.reset();
  }

  private JPanel createTotAmountPanel() {
    JPanel totAmountPanel = new JPanel();
    totAmountPanel.setBackground(MAIN_WINDOW_COLOR);
    SpringLayout layout = new SpringLayout();
    totAmountPanel.setLayout(layout);

    Label totAmountCalculatorLabel = new Label(BUNDLE.getString("totalAmountCalculator"), MAIN_WINDOW_COLOR, TEXT_COLOR, SECTION_TITLE_FONT);
    totAmountPanel.add(totAmountCalculatorLabel);
    layout.putConstraint(SpringLayout.NORTH, totAmountCalculatorLabel, 5, SpringLayout.NORTH, totAmountPanel);
    layout.putConstraint(SpringLayout.WEST, totAmountCalculatorLabel, 5, SpringLayout.WEST, totAmountPanel);

    Label totAmountTimeLabel = new Label(BUNDLE.getString("time"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    totAmountPanel.add(totAmountTimeLabel);
    layout.putConstraint(SpringLayout.NORTH, totAmountTimeLabel, 5, SpringLayout.SOUTH, totAmountCalculatorLabel);
    layout.putConstraint(SpringLayout.WEST, totAmountTimeLabel, 5, SpringLayout.WEST, totAmountPanel);

    totAmountTimeCombo = new JComboBox<>(new String[]{BUNDLE.getString("days"), BUNDLE.getString("months"), BUNDLE.getString("years")});
    totAmountTimeCombo.setBackground(TEXT_INPUT_COLOR);
    totAmountTimeCombo.setForeground(TEXT_COLOR);
    totAmountTimeCombo.setBorder(null);
    totAmountPanel.add(totAmountTimeCombo);
    layout.putConstraint(SpringLayout.NORTH, totAmountTimeCombo, 5, SpringLayout.SOUTH, totAmountTimeLabel);
    layout.putConstraint(SpringLayout.WEST, totAmountTimeCombo, 5, SpringLayout.WEST, totAmountPanel);

    TOTAL_AMOUNT_TIME.setColumns(20);
    totAmountPanel.add(TOTAL_AMOUNT_TIME);
    layout.putConstraint(SpringLayout.NORTH, TOTAL_AMOUNT_TIME, 5, SpringLayout.SOUTH, totAmountTimeCombo);
    layout.putConstraint(SpringLayout.WEST, TOTAL_AMOUNT_TIME, 5, SpringLayout.WEST, totAmountPanel);

    Label totAmountCapitalLabel = new Label(BUNDLE.getString("capital"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    totAmountPanel.add(totAmountCapitalLabel);
    layout.putConstraint(SpringLayout.NORTH, totAmountCapitalLabel, 5, SpringLayout.SOUTH, TOTAL_AMOUNT_TIME);
    layout.putConstraint(SpringLayout.WEST, totAmountCapitalLabel, 5, SpringLayout.WEST, totAmountPanel);

    TOTAL_AMOUNT_CAPITAL.setColumns(20);
    totAmountPanel.add(TOTAL_AMOUNT_CAPITAL);
    layout.putConstraint(SpringLayout.NORTH, TOTAL_AMOUNT_CAPITAL, 5, SpringLayout.SOUTH, totAmountCapitalLabel);
    layout.putConstraint(SpringLayout.WEST, TOTAL_AMOUNT_CAPITAL, 5, SpringLayout.WEST, totAmountPanel);

    Label totAmountQuoteLabel = new Label(BUNDLE.getString("quote"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    totAmountPanel.add(totAmountQuoteLabel);
    layout.putConstraint(SpringLayout.NORTH, totAmountQuoteLabel, 5, SpringLayout.SOUTH, TOTAL_AMOUNT_CAPITAL);
    layout.putConstraint(SpringLayout.WEST, totAmountQuoteLabel, 5, SpringLayout.WEST, totAmountPanel);

    TOTAL_AMOUNT_QUOTE.setColumns(20);
    totAmountPanel.add(TOTAL_AMOUNT_QUOTE);
    layout.putConstraint(SpringLayout.NORTH, TOTAL_AMOUNT_QUOTE, 5, SpringLayout.SOUTH, totAmountQuoteLabel);
    layout.putConstraint(SpringLayout.WEST, TOTAL_AMOUNT_QUOTE, 5, SpringLayout.WEST, totAmountPanel);

    Label totAmountValueLabel = new Label(BUNDLE.getString("totalAmount"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    totAmountPanel.add(totAmountValueLabel);
    layout.putConstraint(SpringLayout.NORTH, totAmountValueLabel, 5, SpringLayout.SOUTH, TOTAL_AMOUNT_QUOTE);
    layout.putConstraint(SpringLayout.WEST, totAmountValueLabel, 5, SpringLayout.WEST, totAmountPanel);

    TOTAL_AMOUNT_VALUE.setColumns(20);
    totAmountPanel.add(TOTAL_AMOUNT_VALUE);
    layout.putConstraint(SpringLayout.NORTH, TOTAL_AMOUNT_VALUE, 5, SpringLayout.SOUTH, totAmountValueLabel);
    layout.putConstraint(SpringLayout.WEST, TOTAL_AMOUNT_VALUE, 5, SpringLayout.WEST, totAmountPanel);

    Button totAmountCalcButton = new Button(BUNDLE.getString("calculate"), BUTTON_COLOR, TEXT_COLOR, INPUT_FONT);
    totAmountCalcButton.addActionListener((e) -> {
      insertTotalAmountData();
      double result = TOTAL_AMOUNT_HANDLER.calculate(totAmountTimeCombo.getSelectedIndex());
      if (result != -1) {
        JOptionPane.showInternalMessageDialog(null, String.format(BUNDLE.getString("solutionIs"), result));
      } else {
        JOptionPane.showInternalMessageDialog(null, BUNDLE.getString("calculationError"));
      }
    });
    totAmountPanel.add(totAmountCalcButton);
    layout.putConstraint(SpringLayout.SOUTH, totAmountCalcButton, -25, SpringLayout.SOUTH, totAmountPanel);
    layout.putConstraint(SpringLayout.EAST, totAmountCalcButton, -50, SpringLayout.EAST, totAmountPanel);

    Button totAmountResetButton = new Button(BUNDLE.getString("reset"), BUTTON_COLOR, TEXT_COLOR, INPUT_FONT);
    totAmountResetButton.addActionListener((e) -> resetTotAmount());
    totAmountPanel.add(totAmountResetButton);
    layout.putConstraint(SpringLayout.NORTH, totAmountResetButton, 0, SpringLayout.NORTH, totAmountCalcButton);
    layout.putConstraint(SpringLayout.EAST, totAmountResetButton, -10, SpringLayout.WEST, totAmountCalcButton);

    totAmountLeapYearCheck = new JCheckBox(BUNDLE.getString("leapYear"));
    totAmountLeapYearCheck.setBackground(MAIN_WINDOW_COLOR);
    totAmountLeapYearCheck.setForeground(TEXT_COLOR);
    totAmountPanel.add(totAmountLeapYearCheck);
    layout.putConstraint(SpringLayout.NORTH, totAmountLeapYearCheck, 0,SpringLayout.NORTH, totAmountResetButton);
    layout.putConstraint(SpringLayout.EAST, totAmountLeapYearCheck, -10, SpringLayout.WEST, totAmountResetButton);

    return totAmountPanel;
  }

  private void insertTotalAmountData() {
    ArrayList<TextField> solutionTerm = new ArrayList<>(1);
    for (TextField textField : new TextField[]{TOTAL_AMOUNT_CAPITAL, TOTAL_AMOUNT_TIME, TOTAL_AMOUNT_QUOTE, TOTAL_AMOUNT_VALUE}) {
      if (Objects.equals(textField.getText(), "")) {
        solutionTerm.add(textField);
      }
    }
    if (solutionTerm.size() != 1) {
      JOptionPane.showInternalMessageDialog(null, BUNDLE.getString("wrongInput"));
      return;
    }

    try {
      if (!TOTAL_AMOUNT_CAPITAL.equals(solutionTerm.get(0))) {
        TOTAL_AMOUNT_HANDLER.setCapital(Double.parseDouble(TOTAL_AMOUNT_CAPITAL.getText()));
      }
    } catch (Exception e) {
      JOptionPane.showInternalMessageDialog(null, BUNDLE.getString("capitalError"));
      INTEREST_HANDLER.reset();
      return;
    }

    try {
      if (!TOTAL_AMOUNT_TIME.equals(solutionTerm.get(0))) {
        TOTAL_AMOUNT_HANDLER.setTime(validateTime(TOTAL_AMOUNT_TIME, totAmountTimeCombo.getSelectedIndex()));
      }
    } catch (Exception e) {
      JOptionPane.showInternalMessageDialog(null, BUNDLE.getString("timeError"));
      INTEREST_HANDLER.reset();
      return;
    }

    try {
      if (!TOTAL_AMOUNT_QUOTE.equals(solutionTerm.get(0))) {
        TOTAL_AMOUNT_HANDLER.setQuote(Double.parseDouble(TOTAL_AMOUNT_QUOTE.getText()));
      }
    } catch (Exception e) {
      JOptionPane.showInternalMessageDialog(null, BUNDLE.getString("quoteError"));
      TOTAL_AMOUNT_HANDLER.reset();
      return;
    }

    try {
      if (!TOTAL_AMOUNT_VALUE.equals(solutionTerm.get(0))) {
        TOTAL_AMOUNT_HANDLER.setTotalAmount(Double.parseDouble(TOTAL_AMOUNT_VALUE.getText()));
      }
    } catch (Exception e) {
      JOptionPane.showInternalMessageDialog(null, BUNDLE.getString("totalAmountError"));
      TOTAL_AMOUNT_HANDLER.reset();
      return;
    }

    TOTAL_AMOUNT_HANDLER.setLeapYear(totAmountLeapYearCheck.isSelected());
  }

  private void resetTotAmount() {
    for (TextField textField : new TextField[]{TOTAL_AMOUNT_TIME, TOTAL_AMOUNT_CAPITAL, TOTAL_AMOUNT_QUOTE, TOTAL_AMOUNT_VALUE}) {
      textField.setText("");
    }
    TOTAL_AMOUNT_HANDLER.reset();
  }

  private long validateTime(TextField textField, int comboIndex) {
    String timeRegex = "^((0[1-9]|[1-2]\\d|3[0-1])/(0[1-9]|1[0-2])/(\\d{4}))\\s-\\s((0[1-9]|[1-2]\\d|3[0-1])/(0[1-9]|1[0-2])/(\\d{4}))$";
    Pattern pattern = Pattern.compile(timeRegex);
    Matcher matcher = pattern.matcher(textField.getText());
    if (matcher.matches() && comboIndex == 0) {
      LocalDate initDate = LocalDate.of(Integer.parseInt(textField.getText().substring(6, 10)), Integer.parseInt(textField.getText().substring(3, 5)), Integer.parseInt(textField.getText().substring(0, 2)));
      LocalDate endDate = LocalDate.of(Integer.parseInt(textField.getText().substring(19, 23)), Integer.parseInt(textField.getText().substring(16, 18)), Integer.parseInt(textField.getText().substring(13, 15)));
      return ChronoUnit.DAYS.between(initDate, endDate);
    }
    return Long.parseLong(textField.getText());
  }
}