package com.artiomastashonak.schoolaccountingstudio.discount;

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

public class DiscountPresentValueDialog extends JDialog {
  private final ResourceBundle BUNDLE;
  private final DiscountHandler DISCOUNT_HANDLER = new DiscountHandler();
  private final PresentValueHandler PRESENT_VALUE_HANDLER = new PresentValueHandler();
  private final Color MAIN_WINDOW_COLOR = DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color;
  private final Color TEXT_INPUT_COLOR = DarkThemeColors.MENU_BAR_BACKGROUND_COLOR.color;
  private final Color BUTTON_COLOR = DarkThemeColors.BUTTON_BACKGROUND_COLOR.color;
  private final Color TEXT_COLOR = DarkThemeColors.PRIMARY_TEXT_COLOR.color;
  private final Font SECTION_TITLE_FONT = new Font("sans-serif", Font.BOLD, TextSizes.SUBSECTION_TITLE_TEXT_SIZE.size);
  private final Font ELEMENT_TITLE_FONT = new Font("sans-serif", Font.BOLD, TextSizes.ELEMENT_TITLE_TEXT_SIZE.size);
  private final Font INPUT_FONT = new Font("sans-serif", Font.PLAIN, TextSizes.BUTTON_TEXT_SIZE.size);

  private JComboBox<String> discountTimeCombo;
  private final TextField DISCOUNT_TIME = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
  private final TextField DISCOUNT_CAPITAL = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
  private final TextField DISCOUNT_QUOTE = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
  private final TextField DISCOUNT_VALUE = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
  private JCheckBox discountLeapYearCheck;

  private JComboBox<String> presValueTimeCombo;
  private final TextField PRESENT_VALUE_TIME = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
  private final TextField PRESENT_VALUE_CAPITAL = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
  private final TextField PRESENT_VALUE_QUOTE = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
  private final TextField PRESENT_VALUE = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
  private JCheckBox presValueLeapYearCheck;

  public DiscountPresentValueDialog(ResourceBundle bundle) {
    this.BUNDLE = bundle;

    setMinimumSize(new Dimension(600, 550));
    setTitle(bundle.getString("discountCalculator"));
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

    Button discountViewButton = new Button(bundle.getString("discount"), BUTTON_COLOR, TEXT_COLOR, INPUT_FONT);
    switchPanel.add(discountViewButton);

    Button presValueViewButton = new Button(bundle.getString("presentValue"), BUTTON_COLOR, TEXT_COLOR, INPUT_FONT);
    switchPanel.add(presValueViewButton);

    JPanel discountPanel = createDiscountPanel();
    mainPanel.add(discountPanel, "DISCOUNT");

    JPanel presValuePanel = createPresValuePanel();
    mainPanel.add(presValuePanel, "PRES_VALUE");

    mainLayout.show(mainPanel, "DISCOUNT");

    discountViewButton.addActionListener((e) -> mainLayout.show(mainPanel, "DISCOUNT"));
    presValueViewButton.addActionListener((e) -> mainLayout.show(mainPanel, "PRES_VALUE"));

    show();
  }

  private JPanel createDiscountPanel() {
    JPanel discountPanel = new JPanel();
    discountPanel.setBackground(MAIN_WINDOW_COLOR);
    SpringLayout layout = new SpringLayout();
    discountPanel.setLayout(layout);

    Label discountCalculatorLabel = new Label(BUNDLE.getString("discountCalculator"), MAIN_WINDOW_COLOR, TEXT_COLOR, SECTION_TITLE_FONT);
    discountPanel.add(discountCalculatorLabel);
    layout.putConstraint(SpringLayout.NORTH, discountCalculatorLabel, 5, SpringLayout.NORTH, discountPanel);
    layout.putConstraint(SpringLayout.WEST, discountCalculatorLabel, 5, SpringLayout.WEST, discountPanel);

    Label discountTimeLabel = new Label(BUNDLE.getString("time"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    discountPanel.add(discountTimeLabel);
    layout.putConstraint(SpringLayout.NORTH, discountTimeLabel, 5, SpringLayout.SOUTH, discountCalculatorLabel);
    layout.putConstraint(SpringLayout.WEST, discountTimeLabel, 5, SpringLayout.WEST, discountPanel);

    discountTimeCombo = new JComboBox<>(new String[]{BUNDLE.getString("days"), BUNDLE.getString("months"), BUNDLE.getString("years")});
    discountTimeCombo.setBackground(TEXT_INPUT_COLOR);
    discountTimeCombo.setForeground(TEXT_COLOR);
    discountTimeCombo.setBorder(null);
    discountPanel.add(discountTimeCombo);
    layout.putConstraint(SpringLayout.NORTH, discountTimeCombo, 5, SpringLayout.SOUTH, discountTimeLabel);
    layout.putConstraint(SpringLayout.WEST, discountTimeCombo, 5, SpringLayout.WEST, discountPanel);

    DISCOUNT_TIME.setColumns(20);
    discountPanel.add(DISCOUNT_TIME);
    layout.putConstraint(SpringLayout.NORTH, DISCOUNT_TIME, 5, SpringLayout.SOUTH, discountTimeCombo);
    layout.putConstraint(SpringLayout.WEST, DISCOUNT_TIME, 5, SpringLayout.WEST, discountPanel);

    Label discountCapitalLabel = new Label(BUNDLE.getString("capital"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    discountPanel.add(discountCapitalLabel);
    layout.putConstraint(SpringLayout.NORTH, discountCapitalLabel, 5, SpringLayout.SOUTH, DISCOUNT_TIME);
    layout.putConstraint(SpringLayout.WEST, discountCapitalLabel, 5, SpringLayout.WEST, discountPanel);

    DISCOUNT_CAPITAL.setColumns(20);
    discountPanel.add(DISCOUNT_CAPITAL);
    layout.putConstraint(SpringLayout.NORTH, DISCOUNT_CAPITAL, 5, SpringLayout.SOUTH, discountCapitalLabel);
    layout.putConstraint(SpringLayout.WEST, DISCOUNT_CAPITAL, 5, SpringLayout.WEST, discountPanel);

    Label discountQuoteLabel = new Label(BUNDLE.getString("quote"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    discountPanel.add(discountQuoteLabel);
    layout.putConstraint(SpringLayout.NORTH, discountQuoteLabel, 5, SpringLayout.SOUTH, DISCOUNT_CAPITAL);
    layout.putConstraint(SpringLayout.WEST, discountQuoteLabel, 5, SpringLayout.WEST, discountPanel);

    DISCOUNT_QUOTE.setColumns(20);
    discountPanel.add(DISCOUNT_QUOTE);
    layout.putConstraint(SpringLayout.NORTH, DISCOUNT_QUOTE, 5, SpringLayout.SOUTH, discountQuoteLabel);
    layout.putConstraint(SpringLayout.WEST, DISCOUNT_QUOTE, 5, SpringLayout.WEST, discountPanel);

    Label discountdiscountLabel = new Label(BUNDLE.getString("discount"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    discountPanel.add(discountdiscountLabel);
    layout.putConstraint(SpringLayout.NORTH, discountdiscountLabel, 5, SpringLayout.SOUTH, DISCOUNT_QUOTE);
    layout.putConstraint(SpringLayout.WEST, discountdiscountLabel, 5, SpringLayout.WEST, discountPanel);

    DISCOUNT_VALUE.setColumns(20);
    discountPanel.add(DISCOUNT_VALUE);
    layout.putConstraint(SpringLayout.NORTH, DISCOUNT_VALUE, 5, SpringLayout.SOUTH, discountdiscountLabel);
    layout.putConstraint(SpringLayout.WEST, DISCOUNT_VALUE, 5, SpringLayout.WEST, discountPanel);

    Button discountCalcButton = new Button(BUNDLE.getString("calculate"), BUTTON_COLOR, TEXT_COLOR, INPUT_FONT);
    discountCalcButton.addActionListener((e) -> {
      insertDiscountData();
      double result = DISCOUNT_HANDLER.calculate(discountTimeCombo.getSelectedIndex());
      if (result != -1) {
        JOptionPane.showInternalMessageDialog(null, String.format(BUNDLE.getString("solutionIs"), result));
      } else {
        JOptionPane.showInternalMessageDialog(null, BUNDLE.getString("calculationError"));
      }
    });
    discountPanel.add(discountCalcButton);
    layout.putConstraint(SpringLayout.SOUTH, discountCalcButton, -25, SpringLayout.SOUTH, discountPanel);
    layout.putConstraint(SpringLayout.EAST, discountCalcButton, -50, SpringLayout.EAST, discountPanel);

    Button discountResetButton = new Button(BUNDLE.getString("reset"), BUTTON_COLOR, TEXT_COLOR, INPUT_FONT);
    discountResetButton.addActionListener((e) -> resetDiscount());
    discountPanel.add(discountResetButton);
    layout.putConstraint(SpringLayout.NORTH, discountResetButton, 0, SpringLayout.NORTH, discountCalcButton);
    layout.putConstraint(SpringLayout.EAST, discountResetButton, -10, SpringLayout.WEST, discountCalcButton);

    discountLeapYearCheck = new JCheckBox(BUNDLE.getString("leapYear"));
    discountLeapYearCheck.setBackground(MAIN_WINDOW_COLOR);
    discountLeapYearCheck.setForeground(TEXT_COLOR);
    discountPanel.add(discountLeapYearCheck);
    layout.putConstraint(SpringLayout.NORTH, discountLeapYearCheck, 0, SpringLayout.NORTH, discountResetButton);
    layout.putConstraint(SpringLayout.EAST, discountLeapYearCheck, -10, SpringLayout.WEST, discountResetButton);

    return discountPanel;
  }

  private void insertDiscountData() {
    ArrayList<TextField> solutionTerm = new ArrayList<>(1);
    for (TextField textField : new TextField[]{DISCOUNT_CAPITAL, DISCOUNT_TIME, DISCOUNT_QUOTE, DISCOUNT_VALUE}) {
      if (Objects.equals(textField.getText(), "")) {
        solutionTerm.add(textField);
      }
    }
    if (solutionTerm.size() != 1) {
      JOptionPane.showInternalMessageDialog(null, BUNDLE.getString("wrongInput"));
      return;
    }
    try {
      if (!DISCOUNT_CAPITAL.equals(solutionTerm.get(0))) {
        DISCOUNT_HANDLER.setCapital(Double.parseDouble(DISCOUNT_CAPITAL.getText()));
      }
    } catch (Exception e) {
      JOptionPane.showInternalMessageDialog(null, BUNDLE.getString("capitalError"));
      DISCOUNT_HANDLER.reset();
      return;
    }

    try {
      if (!DISCOUNT_TIME.equals(solutionTerm.get(0))) {
        DISCOUNT_HANDLER.setTime(validateTime(DISCOUNT_TIME, discountTimeCombo.getSelectedIndex()));
      }
    } catch (Exception e) {
      JOptionPane.showInternalMessageDialog(null, BUNDLE.getString("timeError"));
      DISCOUNT_HANDLER.reset();
      return;
    }

    try {
      if (!DISCOUNT_QUOTE.equals(solutionTerm.get(0))) {
        DISCOUNT_HANDLER.setQuote(Double.parseDouble(DISCOUNT_QUOTE.getText()));
      }
    } catch (Exception e) {
      JOptionPane.showInternalMessageDialog(null, BUNDLE.getString("quoteError"));
      DISCOUNT_HANDLER.reset();
      return;
    }

    try {
      if (!DISCOUNT_VALUE.equals(solutionTerm.get(0))) {
        DISCOUNT_HANDLER.setDiscount(Double.parseDouble(DISCOUNT_VALUE.getText()));
      }
    } catch (Exception e) {
      JOptionPane.showInternalMessageDialog(null, BUNDLE.getString("financialDiscountError"));
      DISCOUNT_HANDLER.reset();
      return;
    }

    DISCOUNT_HANDLER.setLeapYear(discountLeapYearCheck.isSelected());
  }

  private void resetDiscount() {
    for (TextField textField : new TextField[]{DISCOUNT_TIME, DISCOUNT_CAPITAL, DISCOUNT_QUOTE, DISCOUNT_VALUE}) {
      textField.setText("");
    }
    DISCOUNT_HANDLER.reset();
  }

  private JPanel createPresValuePanel() {
    JPanel presValuePanel = new JPanel();
    presValuePanel.setBackground(MAIN_WINDOW_COLOR);
    SpringLayout layout = new SpringLayout();
    presValuePanel.setLayout(layout);

    Label presValueCalculatorLabel = new Label(BUNDLE.getString("presentValueCalculator"), MAIN_WINDOW_COLOR, TEXT_COLOR, SECTION_TITLE_FONT);
    presValuePanel.add(presValueCalculatorLabel);
    layout.putConstraint(SpringLayout.NORTH, presValueCalculatorLabel, 5, SpringLayout.NORTH, presValuePanel);
    layout.putConstraint(SpringLayout.WEST, presValueCalculatorLabel, 5, SpringLayout.WEST, presValuePanel);

    Label presValueTimeLabel = new Label(BUNDLE.getString("time"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    presValuePanel.add(presValueTimeLabel);
    layout.putConstraint(SpringLayout.NORTH, presValueTimeLabel, 5, SpringLayout.SOUTH, presValueCalculatorLabel);
    layout.putConstraint(SpringLayout.WEST, presValueTimeLabel, 5, SpringLayout.WEST, presValuePanel);

    presValueTimeCombo = new JComboBox<>(new String[]{BUNDLE.getString("days"), BUNDLE.getString("months"), BUNDLE.getString("years")});
    presValueTimeCombo.setBackground(TEXT_INPUT_COLOR);
    presValueTimeCombo.setForeground(TEXT_COLOR);
    presValueTimeCombo.setBorder(null);
    presValuePanel.add(presValueTimeCombo);
    layout.putConstraint(SpringLayout.NORTH, presValueTimeCombo, 5, SpringLayout.SOUTH, presValueTimeLabel);
    layout.putConstraint(SpringLayout.WEST, presValueTimeCombo, 5, SpringLayout.WEST, presValuePanel);

    PRESENT_VALUE_TIME.setColumns(20);
    presValuePanel.add(PRESENT_VALUE_TIME);
    layout.putConstraint(SpringLayout.NORTH, PRESENT_VALUE_TIME, 5, SpringLayout.SOUTH, presValueTimeCombo);
    layout.putConstraint(SpringLayout.WEST, PRESENT_VALUE_TIME, 5, SpringLayout.WEST, presValuePanel);

    Label presValueCapitalLabel = new Label(BUNDLE.getString("capital"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    presValuePanel.add(presValueCapitalLabel);
    layout.putConstraint(SpringLayout.NORTH, presValueCapitalLabel, 5, SpringLayout.SOUTH, PRESENT_VALUE_TIME);
    layout.putConstraint(SpringLayout.WEST, presValueCapitalLabel, 5, SpringLayout.WEST, presValuePanel);

    PRESENT_VALUE_CAPITAL.setColumns(20);
    presValuePanel.add(PRESENT_VALUE_CAPITAL);
    layout.putConstraint(SpringLayout.NORTH, PRESENT_VALUE_CAPITAL, 5, SpringLayout.SOUTH, presValueCapitalLabel);
    layout.putConstraint(SpringLayout.WEST, PRESENT_VALUE_CAPITAL, 5, SpringLayout.WEST, presValuePanel);

    Label presValueQuoteLabel = new Label(BUNDLE.getString("quote"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    presValuePanel.add(presValueQuoteLabel);
    layout.putConstraint(SpringLayout.NORTH, presValueQuoteLabel, 5, SpringLayout.SOUTH, PRESENT_VALUE_CAPITAL);
    layout.putConstraint(SpringLayout.WEST, presValueQuoteLabel, 5, SpringLayout.WEST, presValuePanel);

    PRESENT_VALUE_QUOTE.setColumns(20);
    presValuePanel.add(PRESENT_VALUE_QUOTE);
    layout.putConstraint(SpringLayout.NORTH, PRESENT_VALUE_QUOTE, 5, SpringLayout.SOUTH, presValueQuoteLabel);
    layout.putConstraint(SpringLayout.WEST, PRESENT_VALUE_QUOTE, 5, SpringLayout.WEST, presValuePanel);

    Label presValueValueLabel = new Label(BUNDLE.getString("presentValue"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    presValuePanel.add(presValueValueLabel);
    layout.putConstraint(SpringLayout.NORTH, presValueValueLabel, 5, SpringLayout.SOUTH, PRESENT_VALUE_QUOTE);
    layout.putConstraint(SpringLayout.WEST, presValueValueLabel, 5, SpringLayout.WEST, presValuePanel);

    PRESENT_VALUE.setColumns(20);
    presValuePanel.add(PRESENT_VALUE);
    layout.putConstraint(SpringLayout.NORTH, PRESENT_VALUE, 5, SpringLayout.SOUTH, presValueValueLabel);
    layout.putConstraint(SpringLayout.WEST, PRESENT_VALUE, 5, SpringLayout.WEST, presValuePanel);

    Button presValueCalcButton = new Button(BUNDLE.getString("calculate"), BUTTON_COLOR, TEXT_COLOR, INPUT_FONT);
    presValueCalcButton.addActionListener((e) -> {
      insertPresentValueData();
      double result = PRESENT_VALUE_HANDLER.calculate(presValueTimeCombo.getSelectedIndex());
      if (result != -1) {
        JOptionPane.showInternalMessageDialog(null, String.format(BUNDLE.getString("solutionIs"), result));
      } else {
        JOptionPane.showInternalMessageDialog(null, BUNDLE.getString("calculationError"));
      }
    });
    presValuePanel.add(presValueCalcButton);
    layout.putConstraint(SpringLayout.SOUTH, presValueCalcButton, -25, SpringLayout.SOUTH, presValuePanel);
    layout.putConstraint(SpringLayout.EAST, presValueCalcButton, -50, SpringLayout.EAST, presValuePanel);

    Button presValueResetButton = new Button(BUNDLE.getString("reset"), BUTTON_COLOR, TEXT_COLOR, INPUT_FONT);
    presValueResetButton.addActionListener((e) -> resetPresValue());
    presValuePanel.add(presValueResetButton);
    layout.putConstraint(SpringLayout.NORTH, presValueResetButton, 0, SpringLayout.NORTH, presValueCalcButton);
    layout.putConstraint(SpringLayout.EAST, presValueResetButton, -10, SpringLayout.WEST, presValueCalcButton);

    presValueLeapYearCheck = new JCheckBox(BUNDLE.getString("leapYear"));
    presValueLeapYearCheck.setBackground(MAIN_WINDOW_COLOR);
    presValueLeapYearCheck.setForeground(TEXT_COLOR);
    presValuePanel.add(presValueLeapYearCheck);
    layout.putConstraint(SpringLayout.NORTH, presValueLeapYearCheck, 0,SpringLayout.NORTH, presValueResetButton);
    layout.putConstraint(SpringLayout.EAST, presValueLeapYearCheck, -10, SpringLayout.WEST, presValueResetButton);

    return presValuePanel;
  }

  private void insertPresentValueData() {
    ArrayList<TextField> solutionTerm = new ArrayList<>(1);
    for (TextField textField : new TextField[]{PRESENT_VALUE_CAPITAL, PRESENT_VALUE_TIME, PRESENT_VALUE_QUOTE, PRESENT_VALUE}) {
      if (Objects.equals(textField.getText(), "")) {
        solutionTerm.add(textField);
      }
    }
    if (solutionTerm.size() != 1) {
      JOptionPane.showInternalMessageDialog(null, BUNDLE.getString("wrongInput"));
      return;
    }

    try {
      if (!PRESENT_VALUE_CAPITAL.equals(solutionTerm.get(0))) {
        PRESENT_VALUE_HANDLER.setCapital(Double.parseDouble(PRESENT_VALUE_CAPITAL.getText()));
      }
    } catch (Exception e) {
      JOptionPane.showInternalMessageDialog(null, BUNDLE.getString("capitalError"));
      PRESENT_VALUE_HANDLER.reset();
      return;
    }

    try {
      if (!PRESENT_VALUE_TIME.equals(solutionTerm.get(0))) {
        PRESENT_VALUE_HANDLER.setTime(validateTime(PRESENT_VALUE_TIME, presValueTimeCombo.getSelectedIndex()));
      }
    } catch (Exception e) {
      JOptionPane.showInternalMessageDialog(null, BUNDLE.getString("timeError"));
      PRESENT_VALUE_HANDLER.reset();
      return;
    }

    try {
      if (!PRESENT_VALUE_QUOTE.equals(solutionTerm.get(0))) {
        PRESENT_VALUE_HANDLER.setQuote(Double.parseDouble(PRESENT_VALUE_QUOTE.getText()));
      }
    } catch (Exception e) {
      JOptionPane.showInternalMessageDialog(null, BUNDLE.getString("quoteError"));
      PRESENT_VALUE_HANDLER.reset();
      return;
    }

    try {
      if (!PRESENT_VALUE.equals(solutionTerm.get(0))) {
        PRESENT_VALUE_HANDLER.setPresentValue(Double.parseDouble(PRESENT_VALUE.getText()));
      }
    } catch (Exception e) {
      JOptionPane.showInternalMessageDialog(null, BUNDLE.getString("presentValueError"));
      PRESENT_VALUE_HANDLER.reset();
      return;
    }

    PRESENT_VALUE_HANDLER.setLeapYear(presValueLeapYearCheck.isSelected());
  }

  private void resetPresValue() {
    for (TextField textField : new TextField[]{PRESENT_VALUE_TIME, PRESENT_VALUE_CAPITAL, PRESENT_VALUE_QUOTE, PRESENT_VALUE}) {
      textField.setText("");
    }
    PRESENT_VALUE_HANDLER.reset();
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