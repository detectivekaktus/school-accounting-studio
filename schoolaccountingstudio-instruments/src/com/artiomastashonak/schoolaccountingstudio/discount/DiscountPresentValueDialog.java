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
    private final ResourceBundle bundle;
    private final DiscountHandler discountHandler = new DiscountHandler();
    private final PresentValueHandler presentValueHandler = new PresentValueHandler();
    private final Color mainWindowColor = DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color;
    private final Color textInputColor = DarkThemeColors.MENU_BAR_BACKGROUND_COLOR.color;
    private final Color buttonColor = DarkThemeColors.BUTTON_BACKGROUND_COLOR.color;
    private final Color textColor = DarkThemeColors.PRIMARY_TEXT_COLOR.color;
    private final Font sectionTitleFont = new Font("sans-serif", Font.BOLD, TextSizes.SUBSECTION_TITLE_TEXT_SIZE.size);
    private final Font elementTitleFont = new Font("sans-serif", Font.BOLD, TextSizes.ELEMENT_TITLE_TEXT_SIZE.size);
    private final Font inputFont = new Font("sans-serif", Font.PLAIN, TextSizes.BUTTON_TEXT_SIZE.size);

    private JComboBox<String> discountTimeCombo;
    private final TextField discountTime = new TextField(textInputColor, textColor, inputFont);
    private final TextField discountCapital = new TextField(textInputColor, textColor, inputFont);
    private final TextField discountQuote = new TextField(textInputColor, textColor, inputFont);
    private final TextField discountValue = new TextField(textInputColor, textColor, inputFont);
    private JCheckBox discountLeapYearCheck;

    private JComboBox<String> presValueTimeCombo;
    private final TextField presValueTime = new TextField(textInputColor, textColor, inputFont);
    private final TextField presValueCapital = new TextField(textInputColor, textColor, inputFont);
    private final TextField presValueQuote = new TextField(textInputColor, textColor, inputFont);
    private final TextField presValue = new TextField(textInputColor, textColor, inputFont);
    private JCheckBox presValueLeapYearCheck;
    
    public DiscountPresentValueDialog(ResourceBundle bundle) {
        this.bundle = bundle;

        setMinimumSize(new Dimension(600, 550));
        setTitle(bundle.getString("discountCalculator"));
        getContentPane().setBackground(mainWindowColor);
        setModal(false);
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(mainWindowColor);
        CardLayout mainLayout = new CardLayout();
        mainPanel.setLayout(mainLayout);
        add(mainPanel, BorderLayout.CENTER);

        JPanel switchPanel = new JPanel();
        switchPanel.setBackground(textInputColor);
        switchPanel.setLayout(new BoxLayout(switchPanel, BoxLayout.Y_AXIS));
        add(switchPanel, BorderLayout.WEST);

        Button discountViewButton = new Button(bundle.getString("discount"),
                buttonColor,
                textColor,
                inputFont);
        switchPanel.add(discountViewButton);

        Button presValueViewButton = new Button(bundle.getString("presentValue"),
                buttonColor,
                textColor,
                inputFont);
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
        discountPanel.setBackground(mainWindowColor);
        SpringLayout layout = new SpringLayout();
        discountPanel.setLayout(layout);

        Label discountCalculatorLabel = new Label(bundle.getString("discountCalculator"),
                mainWindowColor,
                textColor,
                sectionTitleFont);
        discountPanel.add(discountCalculatorLabel);
        layout.putConstraint(SpringLayout.NORTH, discountCalculatorLabel, 5, SpringLayout.NORTH, discountPanel);
        layout.putConstraint(SpringLayout.WEST, discountCalculatorLabel, 5, SpringLayout.WEST, discountPanel);

        Label discountTimeLabel = new Label(bundle.getString("time"),
                mainWindowColor,
                textColor,
                elementTitleFont);
        discountPanel.add(discountTimeLabel);
        layout.putConstraint(SpringLayout.NORTH, discountTimeLabel, 5, SpringLayout.SOUTH, discountCalculatorLabel);
        layout.putConstraint(SpringLayout.WEST, discountTimeLabel, 5, SpringLayout.WEST, discountPanel);

        discountTimeCombo = new JComboBox<>(new String[]{bundle.getString("days"), bundle.getString("moths"), bundle.getString("years")});
        discountTimeCombo.setBackground(textInputColor);
        discountTimeCombo.setForeground(textColor);
        discountTimeCombo.setBorder(null);
        discountPanel.add(discountTimeCombo);
        layout.putConstraint(SpringLayout.NORTH, discountTimeCombo, 5, SpringLayout.SOUTH, discountTimeLabel);
        layout.putConstraint(SpringLayout.WEST, discountTimeCombo, 5, SpringLayout.WEST, discountPanel);

        discountTime.setColumns(20);
        discountPanel.add(discountTime);
        layout.putConstraint(SpringLayout.NORTH, discountTime, 5, SpringLayout.SOUTH, discountTimeCombo);
        layout.putConstraint(SpringLayout.WEST, discountTime, 5, SpringLayout.WEST, discountPanel);

        Label discountCapitalLabel = new Label(bundle.getString("capital"),
                mainWindowColor,
                textColor,
                elementTitleFont);
        discountPanel.add(discountCapitalLabel);
        layout.putConstraint(SpringLayout.NORTH, discountCapitalLabel, 5, SpringLayout.SOUTH, discountTime);
        layout.putConstraint(SpringLayout.WEST, discountCapitalLabel, 5, SpringLayout.WEST, discountPanel);

        discountCapital.setColumns(20);
        discountPanel.add(discountCapital);
        layout.putConstraint(SpringLayout.NORTH, discountCapital, 5, SpringLayout.SOUTH, discountCapitalLabel);
        layout.putConstraint(SpringLayout.WEST, discountCapital, 5, SpringLayout.WEST, discountPanel);

        Label discountQuoteLabel = new Label(bundle.getString("quote"),
                mainWindowColor,
                textColor,
                elementTitleFont);
        discountPanel.add(discountQuoteLabel);
        layout.putConstraint(SpringLayout.NORTH, discountQuoteLabel, 5, SpringLayout.SOUTH, discountCapital);
        layout.putConstraint(SpringLayout.WEST, discountQuoteLabel, 5, SpringLayout.WEST, discountPanel);

        discountQuote.setColumns(20);
        discountPanel.add(discountQuote);
        layout.putConstraint(SpringLayout.NORTH, discountQuote, 5, SpringLayout.SOUTH, discountQuoteLabel);
        layout.putConstraint(SpringLayout.WEST, discountQuote, 5, SpringLayout.WEST, discountPanel);

        Label discountdiscountLabel = new Label(bundle.getString("discount"),
                mainWindowColor,
                textColor,
                elementTitleFont);
        discountPanel.add(discountdiscountLabel);
        layout.putConstraint(SpringLayout.NORTH, discountdiscountLabel, 5, SpringLayout.SOUTH, discountQuote);
        layout.putConstraint(SpringLayout.WEST, discountdiscountLabel, 5, SpringLayout.WEST, discountPanel);

        discountValue.setColumns(20);
        discountPanel.add(discountValue);
        layout.putConstraint(SpringLayout.NORTH, discountValue, 5, SpringLayout.SOUTH, discountdiscountLabel);
        layout.putConstraint(SpringLayout.WEST, discountValue, 5, SpringLayout.WEST, discountPanel);

        Button discountCalcButton = new Button(bundle.getString("calculate"), buttonColor, textColor, inputFont);
        discountCalcButton.addActionListener((e) -> {
            insertDiscountData();
            double result = discountHandler.calculate(discountTimeCombo.getSelectedIndex());
            if (result != -1) {
                JOptionPane.showInternalMessageDialog(null, String.format(bundle.getString("solutionIs"), result));
            } else {
                JOptionPane.showInternalMessageDialog(null, bundle.getString("calculationError"));
            }
        });
        discountPanel.add(discountCalcButton);
        layout.putConstraint(SpringLayout.SOUTH, discountCalcButton, -25, SpringLayout.SOUTH, discountPanel);
        layout.putConstraint(SpringLayout.EAST, discountCalcButton, -50, SpringLayout.EAST, discountPanel);

      Button discountResetButton = new Button(bundle.getString("reset"), buttonColor, textColor, inputFont);
        discountResetButton.addActionListener((e) -> resetDiscount());
        discountPanel.add(discountResetButton);
        layout.putConstraint(SpringLayout.NORTH, discountResetButton, 0, SpringLayout.NORTH, discountCalcButton);
        layout.putConstraint(SpringLayout.EAST, discountResetButton, -10, SpringLayout.WEST, discountCalcButton);

        discountLeapYearCheck = new JCheckBox(bundle.getString("leapYear"));
        discountLeapYearCheck.setBackground(mainWindowColor);
        discountLeapYearCheck.setForeground(textColor);
        discountPanel.add(discountLeapYearCheck);
        layout.putConstraint(SpringLayout.NORTH, discountLeapYearCheck, 0, SpringLayout.NORTH, discountResetButton);
        layout.putConstraint(SpringLayout.EAST, discountLeapYearCheck, -10, SpringLayout.WEST, discountResetButton);

        return discountPanel;
    }

    private void insertDiscountData() {
        ArrayList<TextField> solutionTerm = new ArrayList<>(1);
        for (TextField textField : new TextField[]{discountCapital, discountTime, discountQuote, discountValue}) {
            if (Objects.equals(textField.getText(), "")) {
                solutionTerm.add(textField);
            }
        }
        if (solutionTerm.size() != 1) {
            JOptionPane.showInternalMessageDialog(null, bundle.getString("wrongInput"));
            return;
        }
        try {
            if (!discountCapital.equals(solutionTerm.get(0))) {
                discountHandler.setCapital(Double.parseDouble(discountCapital.getText()));
            }
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, bundle.getString("capitalError"));
            discountHandler.reset();
            return;
        }

        try {
            if (!discountTime.equals(solutionTerm.get(0))) {
                discountHandler.setTime(validateTime(discountTime, discountTimeCombo.getSelectedIndex()));
            }
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, bundle.getString("timeError"));
            discountHandler.reset();
            return;
        }

        try {
            if (!discountQuote.equals(solutionTerm.get(0))) {
                discountHandler.setQuote(Double.parseDouble(discountQuote.getText()));
            }
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, bundle.getString("quoteError"));
            discountHandler.reset();
            return;
        }

        try {
            if (!discountValue.equals(solutionTerm.get(0))) {
                discountHandler.setDiscount(Double.parseDouble(discountValue.getText()));
            }
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, bundle.getString("financialDiscountError"));
            discountHandler.reset();
            return;
        }

        discountHandler.setLeapYear(discountLeapYearCheck.isSelected());
    }

    private void resetDiscount() {
        for (TextField textField : new TextField[]{discountTime, discountCapital, discountQuote, discountValue}) {
            textField.setText("");
        }
        discountHandler.reset();
    }

    private JPanel createPresValuePanel() {
        JPanel presValuePanel = new JPanel();
        presValuePanel.setBackground(mainWindowColor);
        SpringLayout layout = new SpringLayout();
        presValuePanel.setLayout(layout);

        Label presValueCalculatorLabel = new Label(bundle.getString("presentValueCalculator"),
                mainWindowColor,
                textColor,
                sectionTitleFont);
        presValuePanel.add(presValueCalculatorLabel);
        layout.putConstraint(SpringLayout.NORTH, presValueCalculatorLabel, 5, SpringLayout.NORTH, presValuePanel);
        layout.putConstraint(SpringLayout.WEST, presValueCalculatorLabel, 5, SpringLayout.WEST, presValuePanel);

        Label presValueTimeLabel = new Label(bundle.getString("time"),
                mainWindowColor,
                textColor,
                elementTitleFont);
        presValuePanel.add(presValueTimeLabel);
        layout.putConstraint(SpringLayout.NORTH, presValueTimeLabel, 5, SpringLayout.SOUTH, presValueCalculatorLabel);
        layout.putConstraint(SpringLayout.WEST, presValueTimeLabel, 5, SpringLayout.WEST, presValuePanel);

        presValueTimeCombo = new JComboBox<>(new String[]{bundle.getString("days"), bundle.getString("moths"), bundle.getString("years")});
        presValueTimeCombo.setBackground(textInputColor);
        presValueTimeCombo.setForeground(textColor);
        presValueTimeCombo.setBorder(null);
        presValuePanel.add(presValueTimeCombo);
        layout.putConstraint(SpringLayout.NORTH, presValueTimeCombo, 5, SpringLayout.SOUTH, presValueTimeLabel);
        layout.putConstraint(SpringLayout.WEST, presValueTimeCombo, 5, SpringLayout.WEST, presValuePanel);

        presValueTime.setColumns(20);
        presValuePanel.add(presValueTime);
        layout.putConstraint(SpringLayout.NORTH, presValueTime, 5, SpringLayout.SOUTH, presValueTimeCombo);
        layout.putConstraint(SpringLayout.WEST, presValueTime, 5, SpringLayout.WEST, presValuePanel);

        Label presValueCapitalLabel = new Label(bundle.getString("capital"),
                mainWindowColor,
                textColor,
                elementTitleFont);
        presValuePanel.add(presValueCapitalLabel);
        layout.putConstraint(SpringLayout.NORTH, presValueCapitalLabel, 5, SpringLayout.SOUTH, presValueTime);
        layout.putConstraint(SpringLayout.WEST, presValueCapitalLabel, 5, SpringLayout.WEST, presValuePanel);

        presValueCapital.setColumns(20);
        presValuePanel.add(presValueCapital);
        layout.putConstraint(SpringLayout.NORTH, presValueCapital, 5, SpringLayout.SOUTH, presValueCapitalLabel);
        layout.putConstraint(SpringLayout.WEST, presValueCapital, 5, SpringLayout.WEST, presValuePanel);

        Label presValueQuoteLabel = new Label(bundle.getString("quote"),
                mainWindowColor,
                textColor,
                elementTitleFont);
        presValuePanel.add(presValueQuoteLabel);
        layout.putConstraint(SpringLayout.NORTH, presValueQuoteLabel, 5, SpringLayout.SOUTH, presValueCapital);
        layout.putConstraint(SpringLayout.WEST, presValueQuoteLabel, 5, SpringLayout.WEST, presValuePanel);

        presValueQuote.setColumns(20);
        presValuePanel.add(presValueQuote);
        layout.putConstraint(SpringLayout.NORTH, presValueQuote, 5, SpringLayout.SOUTH, presValueQuoteLabel);
        layout.putConstraint(SpringLayout.WEST, presValueQuote, 5, SpringLayout.WEST, presValuePanel);

        Label presValueValueLabel = new Label(bundle.getString("presentValue"),
                mainWindowColor,
                textColor,
                elementTitleFont);
        presValuePanel.add(presValueValueLabel);
        layout.putConstraint(SpringLayout.NORTH, presValueValueLabel, 5, SpringLayout.SOUTH, presValueQuote);
        layout.putConstraint(SpringLayout.WEST, presValueValueLabel, 5, SpringLayout.WEST, presValuePanel);

        presValue.setColumns(20);
        presValuePanel.add(presValue);
        layout.putConstraint(SpringLayout.NORTH, presValue, 5, SpringLayout.SOUTH, presValueValueLabel);
        layout.putConstraint(SpringLayout.WEST, presValue, 5, SpringLayout.WEST, presValuePanel);

      Button presValueCalcButton = new Button(bundle.getString("calculate"), buttonColor, textColor, inputFont);
        presValueCalcButton.addActionListener((e) -> {
            insertPresentValueData();
            double result = presentValueHandler.calculate(presValueTimeCombo.getSelectedIndex());
            if (result != -1) {
                JOptionPane.showInternalMessageDialog(null, String.format(bundle.getString("solutionIs"), result));
            } else {
                JOptionPane.showInternalMessageDialog(null, bundle.getString("calculationError"));
            }
        });
        presValuePanel.add(presValueCalcButton);
        layout.putConstraint(SpringLayout.SOUTH, presValueCalcButton, -25, SpringLayout.SOUTH, presValuePanel);
        layout.putConstraint(SpringLayout.EAST, presValueCalcButton, -50, SpringLayout.EAST, presValuePanel);

      Button presValueResetButton = new Button(bundle.getString("reset"), buttonColor, textColor, inputFont);
        presValueResetButton.addActionListener((e) -> resetPresValue());
        presValuePanel.add(presValueResetButton);
        layout.putConstraint(SpringLayout.NORTH, presValueResetButton, 0, SpringLayout.NORTH, presValueCalcButton);
        layout.putConstraint(SpringLayout.EAST, presValueResetButton, -10, SpringLayout.WEST, presValueCalcButton);

        presValueLeapYearCheck = new JCheckBox(bundle.getString("leapYear"));
        presValueLeapYearCheck.setBackground(mainWindowColor);
        presValueLeapYearCheck.setForeground(textColor);
        presValuePanel.add(presValueLeapYearCheck);
        layout.putConstraint(SpringLayout.NORTH, presValueLeapYearCheck, 0,SpringLayout.NORTH, presValueResetButton);
        layout.putConstraint(SpringLayout.EAST, presValueLeapYearCheck, -10, SpringLayout.WEST, presValueResetButton);

        return presValuePanel;
    }

    private void insertPresentValueData() {
        ArrayList<TextField> solutionTerm = new ArrayList<>(1);
        for (TextField textField : new TextField[]{presValueCapital, presValueTime, presValueQuote, presValue}) {
            if (Objects.equals(textField.getText(), "")) {
                solutionTerm.add(textField);
            }
        }
        if (solutionTerm.size() != 1) {
            JOptionPane.showInternalMessageDialog(null, bundle.getString("wrongInput"));
            return;
        }

        try {
            if (!presValueCapital.equals(solutionTerm.get(0))) {
                presentValueHandler.setCapital(Double.parseDouble(presValueCapital.getText()));
            }
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, bundle.getString("capitalError"));
            presentValueHandler.reset();
            return;
        }

        try {
            if (!presValueTime.equals(solutionTerm.get(0))) {
                presentValueHandler.setTime(validateTime(presValueTime, presValueTimeCombo.getSelectedIndex()));
            }
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, bundle.getString("timeError"));
            presentValueHandler.reset();
            return;
        }

        try {
            if (!presValueQuote.equals(solutionTerm.get(0))) {
                presentValueHandler.setQuote(Double.parseDouble(presValueQuote.getText()));
            }
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, bundle.getString("quoteError"));
            presentValueHandler.reset();
            return;
        }

        try {
            if (!presValue.equals(solutionTerm.get(0))) {
                presentValueHandler.setPresentValue(Double.parseDouble(presValue.getText()));
            }
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, bundle.getString("presentValueError"));
            presentValueHandler.reset();
            return;
        }

        presentValueHandler.setLeapYear(presValueLeapYearCheck.isSelected());
    }

    private void resetPresValue() {
        for (TextField textField : new TextField[]{presValueTime, presValueCapital, presValueQuote, presValue}) {
            textField.setText("");
        }
        presentValueHandler.reset();
    }

    private long validateTime(TextField textField, int comboIndex) {
        String timeRegex = "^((0[1-9]|[1-2]\\d|3[0-1])/(0[1-9]|1[0-2])/(\\d{4}))\\s-\\s((0[1-9]|[1-2]\\d|3[0-1])/(0[1-9]|1[0-2])/(\\d{4}))$";
        Pattern pattern = Pattern.compile(timeRegex);
        Matcher matcher = pattern.matcher(textField.getText());
        if (matcher.matches() && comboIndex == 0) {
            LocalDate initDate = LocalDate.of(Integer.parseInt(textField.getText().substring(6, 10)),
                    Integer.parseInt(textField.getText().substring(3, 5)),
                    Integer.parseInt(textField.getText().substring(0, 2)));
            LocalDate endDate = LocalDate.of(Integer.parseInt(textField.getText().substring(19, 23)),
                    Integer.parseInt(textField.getText().substring(16, 18)),
                    Integer.parseInt(textField.getText().substring(13, 15)));
            return ChronoUnit.DAYS.between(initDate, endDate);
        }
        return Long.parseLong(textField.getText());
    }
}