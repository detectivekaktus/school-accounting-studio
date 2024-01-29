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
    private final ResourceBundle bundle;
    private final InterestHandler interestHandler = new InterestHandler();
    private final TotalAmountHandler totalAmountHandler = new TotalAmountHandler();
    private final Color mainWindowColor = DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color;
    private final Color textInputColor = DarkThemeColors.MENU_BAR_BACKGROUND_COLOR.color;
    private final Color buttonColor = DarkThemeColors.BUTTON_BACKGROUND_COLOR.color;
    private final Color textColor = DarkThemeColors.PRIMARY_TEXT_COLOR.color;
    private final Font sectionTitleFont = new Font("sans-serif", Font.BOLD, TextSizes.SUBSECTION_TITLE_TEXT_SIZE.size);
    private final Font elementTitleFont = new Font("sans-serif", Font.BOLD, TextSizes.ELEMENT_TITLE_TEXT_SIZE.size);
    private final Font inputFont = new Font("sans-serif", Font.PLAIN, TextSizes.BUTTON_TEXT_SIZE.size);

    private JComboBox<String> interestTimeCombo;
    private final TextField interestTime = new TextField(textInputColor, textColor, inputFont);
    private final TextField interestCapital = new TextField(textInputColor, textColor, inputFont);
    private final TextField interestQuote = new TextField(textInputColor, textColor, inputFont);
    private final TextField interestValue = new TextField(textInputColor, textColor, inputFont);
    private JCheckBox interestLeapYearCheck;

    private JComboBox<String> totAmountTimeCombo;
    private final TextField totAmountTime = new TextField(textInputColor, textColor, inputFont);
    private final TextField totAmountCapital = new TextField(textInputColor, textColor, inputFont);
    private final TextField totAmountQuote = new TextField(textInputColor, textColor, inputFont);
    private final TextField totAmountValue = new TextField(textInputColor, textColor, inputFont);
    private JCheckBox totAmountLeapYearCheck;

    public InterestTotAmountDialog(ResourceBundle bundle) {
        this.bundle = bundle;

        setMinimumSize(new Dimension(600, 550));
        setTitle("Interests Calculator");
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

        Button interestViewButton = new Button("Interest",
                buttonColor,
                textColor,
                inputFont);
        switchPanel.add(interestViewButton);

        Button totAmountViewButton = new Button("Total amount",
                buttonColor,
                textColor,
                inputFont);
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
        interestPanel.setBackground(mainWindowColor);
        SpringLayout layout = new SpringLayout();
        interestPanel.setLayout(layout);

        Label interestCalculatorLabel = new Label(bundle.getString("interestCalculator"),
                mainWindowColor,
                textColor,
                sectionTitleFont);
        interestPanel.add(interestCalculatorLabel);
        layout.putConstraint(SpringLayout.NORTH, interestCalculatorLabel, 5, SpringLayout.NORTH, interestPanel);
        layout.putConstraint(SpringLayout.WEST, interestCalculatorLabel, 5, SpringLayout.WEST, interestPanel);

        Label interestTimeLabel = new Label(bundle.getString("time"),
                mainWindowColor,
                textColor,
                elementTitleFont);
        interestPanel.add(interestTimeLabel);
        layout.putConstraint(SpringLayout.NORTH, interestTimeLabel, 5, SpringLayout.SOUTH, interestCalculatorLabel);
        layout.putConstraint(SpringLayout.WEST, interestTimeLabel, 5, SpringLayout.WEST, interestPanel);

        interestTimeCombo = new JComboBox<>(new String[]{bundle.getString("days"), bundle.getString("months"), bundle.getString("years")});
        interestTimeCombo.setBackground(textInputColor);
        interestTimeCombo.setForeground(textColor);
        interestTimeCombo.setBorder(null);
        interestPanel.add(interestTimeCombo);
        layout.putConstraint(SpringLayout.NORTH, interestTimeCombo, 5, SpringLayout.SOUTH, interestTimeLabel);
        layout.putConstraint(SpringLayout.WEST, interestTimeCombo, 5, SpringLayout.WEST, interestPanel);

        interestTime.setColumns(20);
        interestPanel.add(interestTime);
        layout.putConstraint(SpringLayout.NORTH, interestTime, 5, SpringLayout.SOUTH, interestTimeCombo);
        layout.putConstraint(SpringLayout.WEST, interestTime, 5, SpringLayout.WEST, interestPanel);

        Label interestCapitalLabel = new Label(bundle.getString("capital"),
                mainWindowColor,
                textColor,
                elementTitleFont);
        interestPanel.add(interestCapitalLabel);
        layout.putConstraint(SpringLayout.NORTH, interestCapitalLabel, 5, SpringLayout.SOUTH, interestTime);
        layout.putConstraint(SpringLayout.WEST, interestCapitalLabel, 5, SpringLayout.WEST, interestPanel);

        interestCapital.setColumns(20);
        interestPanel.add(interestCapital);
        layout.putConstraint(SpringLayout.NORTH, interestCapital, 5, SpringLayout.SOUTH, interestCapitalLabel);
        layout.putConstraint(SpringLayout.WEST, interestCapital, 5, SpringLayout.WEST, interestPanel);

        Label interestQuoteLabel = new Label(bundle.getString("quote"),
                mainWindowColor,
                textColor,
                elementTitleFont);
        interestPanel.add(interestQuoteLabel);
        layout.putConstraint(SpringLayout.NORTH, interestQuoteLabel, 5, SpringLayout.SOUTH, interestCapital);
        layout.putConstraint(SpringLayout.WEST, interestQuoteLabel, 5, SpringLayout.WEST, interestPanel);

        interestQuote.setColumns(20);
        interestPanel.add(interestQuote);
        layout.putConstraint(SpringLayout.NORTH, interestQuote, 5, SpringLayout.SOUTH, interestQuoteLabel);
        layout.putConstraint(SpringLayout.WEST, interestQuote, 5, SpringLayout.WEST, interestPanel);

        Label interestInterestLabel = new Label(bundle.getString("interest"),
                mainWindowColor,
                textColor,
                elementTitleFont);
        interestPanel.add(interestInterestLabel);
        layout.putConstraint(SpringLayout.NORTH, interestInterestLabel, 5, SpringLayout.SOUTH, interestQuote);
        layout.putConstraint(SpringLayout.WEST, interestInterestLabel, 5, SpringLayout.WEST, interestPanel);

        interestValue.setColumns(20);
        interestPanel.add(interestValue);
        layout.putConstraint(SpringLayout.NORTH, interestValue, 5, SpringLayout.SOUTH, interestInterestLabel);
        layout.putConstraint(SpringLayout.WEST, interestValue, 5, SpringLayout.WEST, interestPanel);

        Button interestCalcButton = new Button(bundle.getString("calculate"), buttonColor, textColor, inputFont);
        interestCalcButton.addActionListener((e) -> {
            insertInterestData();
            double result = interestHandler.calculate(interestTimeCombo.getSelectedIndex());
            if (result != -1) {
                JOptionPane.showInternalMessageDialog(null, String.format(bundle.getString("solutionIs"), result));
            } else {
                JOptionPane.showInternalMessageDialog(null, bundle.getString("calculationError"));
            }
        });
        interestPanel.add(interestCalcButton);
        layout.putConstraint(SpringLayout.SOUTH, interestCalcButton, -25, SpringLayout.SOUTH, interestPanel);
        layout.putConstraint(SpringLayout.EAST, interestCalcButton, -50, SpringLayout.EAST, interestPanel);

        Button interestResetButton = new Button(bundle.getString("reset"), buttonColor, textColor, inputFont);
        interestResetButton.addActionListener((e) -> resetInterest());
        interestPanel.add(interestResetButton);
        layout.putConstraint(SpringLayout.NORTH, interestResetButton, 0, SpringLayout.NORTH, interestCalcButton);
        layout.putConstraint(SpringLayout.EAST, interestResetButton, -10, SpringLayout.WEST, interestCalcButton);

        interestLeapYearCheck = new JCheckBox(bundle.getString("leapYear"));
        interestLeapYearCheck.setBackground(mainWindowColor);
        interestLeapYearCheck.setForeground(textColor);
        interestPanel.add(interestLeapYearCheck);
        layout.putConstraint(SpringLayout.NORTH, interestLeapYearCheck, 0, SpringLayout.NORTH, interestResetButton);
        layout.putConstraint(SpringLayout.EAST, interestLeapYearCheck, -10, SpringLayout.WEST, interestResetButton);

        return interestPanel;
    }

    private void insertInterestData() {
        ArrayList<TextField> solutionTerm = new ArrayList<>(1);
        for (TextField textField : new TextField[]{interestCapital, interestTime, interestQuote, interestValue}) {
            if (Objects.equals(textField.getText(), "")) {
                solutionTerm.add(textField);
            }
        }
        if (solutionTerm.size() != 1) {
            JOptionPane.showInternalMessageDialog(null, bundle.getString("wrongInput"));
            return;
        }
        try {
            if (!interestCapital.equals(solutionTerm.get(0))) {
                interestHandler.setCapital(Double.parseDouble(interestCapital.getText()));
            }
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, bundle.getString("capitalError"));
            interestHandler.reset();
            return;
        }

        try {
            if (!interestTime.equals(solutionTerm.get(0))) {
                interestHandler.setTime(validateTime(interestTime, interestTimeCombo.getSelectedIndex()));
            }
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, bundle.getString("timeError"));
            interestHandler.reset();
            return;
        }

        try {
            if (!interestQuote.equals(solutionTerm.get(0))) {
                interestHandler.setQuote(Double.parseDouble(interestQuote.getText()));
            }
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, bundle.getString("quoteError"));
            interestHandler.reset();
            return;
        }

        try {
            if (!interestValue.equals(solutionTerm.get(0))) {
                interestHandler.setInterest(Double.parseDouble(interestValue.getText()));
            }
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, bundle.getString("interestError"));
            interestHandler.reset();
            return;
        }

        interestHandler.setLeapYear(interestLeapYearCheck.isSelected());
    }

    private void resetInterest() {
        for (TextField textField : new TextField[]{interestTime, interestCapital, interestQuote, interestValue}) {
            textField.setText("");
        }
        interestHandler.reset();
    }

    private JPanel createTotAmountPanel() {
        JPanel totAmountPanel = new JPanel();
        totAmountPanel.setBackground(mainWindowColor);
        SpringLayout layout = new SpringLayout();
        totAmountPanel.setLayout(layout);

        Label totAmountCalculatorLabel = new Label(bundle.getString("totalAmountCalculator"),
                mainWindowColor,
                textColor,
                sectionTitleFont);
        totAmountPanel.add(totAmountCalculatorLabel);
        layout.putConstraint(SpringLayout.NORTH, totAmountCalculatorLabel, 5, SpringLayout.NORTH, totAmountPanel);
        layout.putConstraint(SpringLayout.WEST, totAmountCalculatorLabel, 5, SpringLayout.WEST, totAmountPanel);

        Label totAmountTimeLabel = new Label(bundle.getString("time"),
                mainWindowColor,
                textColor,
                elementTitleFont);
        totAmountPanel.add(totAmountTimeLabel);
        layout.putConstraint(SpringLayout.NORTH, totAmountTimeLabel, 5, SpringLayout.SOUTH, totAmountCalculatorLabel);
        layout.putConstraint(SpringLayout.WEST, totAmountTimeLabel, 5, SpringLayout.WEST, totAmountPanel);

        totAmountTimeCombo = new JComboBox<>(new String[]{bundle.getString("days"), bundle.getString("months"), bundle.getString("years")});
        totAmountTimeCombo.setBackground(textInputColor);
        totAmountTimeCombo.setForeground(textColor);
        totAmountTimeCombo.setBorder(null);
        totAmountPanel.add(totAmountTimeCombo);
        layout.putConstraint(SpringLayout.NORTH, totAmountTimeCombo, 5, SpringLayout.SOUTH, totAmountTimeLabel);
        layout.putConstraint(SpringLayout.WEST, totAmountTimeCombo, 5, SpringLayout.WEST, totAmountPanel);

        totAmountTime.setColumns(20);
        totAmountPanel.add(totAmountTime);
        layout.putConstraint(SpringLayout.NORTH, totAmountTime, 5, SpringLayout.SOUTH, totAmountTimeCombo);
        layout.putConstraint(SpringLayout.WEST, totAmountTime, 5, SpringLayout.WEST, totAmountPanel);

        Label totAmountCapitalLabel = new Label(bundle.getString("capital"),
                mainWindowColor,
                textColor,
                elementTitleFont);
        totAmountPanel.add(totAmountCapitalLabel);
        layout.putConstraint(SpringLayout.NORTH, totAmountCapitalLabel, 5, SpringLayout.SOUTH, totAmountTime);
        layout.putConstraint(SpringLayout.WEST, totAmountCapitalLabel, 5, SpringLayout.WEST, totAmountPanel);

        totAmountCapital.setColumns(20);
        totAmountPanel.add(totAmountCapital);
        layout.putConstraint(SpringLayout.NORTH, totAmountCapital, 5, SpringLayout.SOUTH, totAmountCapitalLabel);
        layout.putConstraint(SpringLayout.WEST, totAmountCapital, 5, SpringLayout.WEST, totAmountPanel);

        Label totAmountQuoteLabel = new Label(bundle.getString("quote"),
                mainWindowColor,
                textColor,
                elementTitleFont);
        totAmountPanel.add(totAmountQuoteLabel);
        layout.putConstraint(SpringLayout.NORTH, totAmountQuoteLabel, 5, SpringLayout.SOUTH, totAmountCapital);
        layout.putConstraint(SpringLayout.WEST, totAmountQuoteLabel, 5, SpringLayout.WEST, totAmountPanel);

        totAmountQuote.setColumns(20);
        totAmountPanel.add(totAmountQuote);
        layout.putConstraint(SpringLayout.NORTH, totAmountQuote, 5, SpringLayout.SOUTH, totAmountQuoteLabel);
        layout.putConstraint(SpringLayout.WEST, totAmountQuote, 5, SpringLayout.WEST, totAmountPanel);

        Label totAmountValueLabel = new Label(bundle.getString("totalAmount"),
                mainWindowColor,
                textColor,
                elementTitleFont);
        totAmountPanel.add(totAmountValueLabel);
        layout.putConstraint(SpringLayout.NORTH, totAmountValueLabel, 5, SpringLayout.SOUTH, totAmountQuote);
        layout.putConstraint(SpringLayout.WEST, totAmountValueLabel, 5, SpringLayout.WEST, totAmountPanel);

        totAmountValue.setColumns(20);
        totAmountPanel.add(totAmountValue);
        layout.putConstraint(SpringLayout.NORTH, totAmountValue, 5, SpringLayout.SOUTH, totAmountValueLabel);
        layout.putConstraint(SpringLayout.WEST, totAmountValue, 5, SpringLayout.WEST, totAmountPanel);

        Button totAmountCalcButton = new Button(bundle.getString("calculate"), buttonColor, textColor, inputFont);
        totAmountCalcButton.addActionListener((e) -> {
            insertTotalAmountData();
            double result = totalAmountHandler.calculate(totAmountTimeCombo.getSelectedIndex());
            if (result != -1) {
                JOptionPane.showInternalMessageDialog(null, String.format(bundle.getString("solutionIs"), result));
            } else {
                JOptionPane.showInternalMessageDialog(null, bundle.getString("calculationError"));
            }
        });
        totAmountPanel.add(totAmountCalcButton);
        layout.putConstraint(SpringLayout.SOUTH, totAmountCalcButton, -25, SpringLayout.SOUTH, totAmountPanel);
        layout.putConstraint(SpringLayout.EAST, totAmountCalcButton, -50, SpringLayout.EAST, totAmountPanel);

        Button totAmountResetButton = new Button(bundle.getString("reset"), buttonColor, textColor, inputFont);
        totAmountResetButton.addActionListener((e) -> resetTotAmount());
        totAmountPanel.add(totAmountResetButton);
        layout.putConstraint(SpringLayout.NORTH, totAmountResetButton, 0, SpringLayout.NORTH, totAmountCalcButton);
        layout.putConstraint(SpringLayout.EAST, totAmountResetButton, -10, SpringLayout.WEST, totAmountCalcButton);

        totAmountLeapYearCheck = new JCheckBox(bundle.getString("leapYear"));
        totAmountLeapYearCheck.setBackground(mainWindowColor);
        totAmountLeapYearCheck.setForeground(textColor);
        totAmountPanel.add(totAmountLeapYearCheck);
        layout.putConstraint(SpringLayout.NORTH, totAmountLeapYearCheck, 0,SpringLayout.NORTH, totAmountResetButton);
        layout.putConstraint(SpringLayout.EAST, totAmountLeapYearCheck, -10, SpringLayout.WEST, totAmountResetButton);

        return totAmountPanel;
    }

    private void insertTotalAmountData() {
        ArrayList<TextField> solutionTerm = new ArrayList<>(1);
        for (TextField textField : new TextField[]{totAmountCapital, totAmountTime, totAmountQuote, totAmountValue}) {
            if (Objects.equals(textField.getText(), "")) {
                solutionTerm.add(textField);
            }
        }
        if (solutionTerm.size() != 1) {
            JOptionPane.showInternalMessageDialog(null, bundle.getString("wrongInput"));
            return;
        }

        try {
            if (!totAmountCapital.equals(solutionTerm.get(0))) {
                totalAmountHandler.setCapital(Double.parseDouble(totAmountCapital.getText()));
            }
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, bundle.getString("capitalError"));
            interestHandler.reset();
            return;
        }

        try {
            if (!totAmountTime.equals(solutionTerm.get(0))) {
                totalAmountHandler.setTime(validateTime(totAmountTime, totAmountTimeCombo.getSelectedIndex()));
            }
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, bundle.getString("timeError"));
            interestHandler.reset();
            return;
        }

        try {
            if (!totAmountQuote.equals(solutionTerm.get(0))) {
                totalAmountHandler.setQuote(Double.parseDouble(totAmountQuote.getText()));
            }
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, bundle.getString("quoteError"));
            totalAmountHandler.reset();
            return;
        }

        try {
            if (!totAmountValue.equals(solutionTerm.get(0))) {
                totalAmountHandler.setTotalAmount(Double.parseDouble(totAmountValue.getText()));
            }
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, bundle.getString("totalAmountError"));
            totalAmountHandler.reset();
            return;
        }

        totalAmountHandler.setLeapYear(totAmountLeapYearCheck.isSelected());
    }

    private void resetTotAmount() {
        for (TextField textField : new TextField[]{totAmountTime, totAmountCapital, totAmountQuote, totAmountValue}) {
            textField.setText("");
        }
        totalAmountHandler.reset();
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