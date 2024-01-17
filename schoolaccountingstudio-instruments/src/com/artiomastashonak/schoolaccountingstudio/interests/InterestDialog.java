package com.artiomastashonak.schoolaccountingstudio.interests;

import com.artiomastashonak.schoolaccountingstudio.Button;
import com.artiomastashonak.schoolaccountingstudio.DarkThemeColors;
import com.artiomastashonak.schoolaccountingstudio.Label;
import com.artiomastashonak.schoolaccountingstudio.TextField;
import com.artiomastashonak.schoolaccountingstudio.TextSizes;
import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

public class InterestDialog extends JDialog {

    private ResourceBundle bundle;
    private InterestHandler handler = new InterestHandler();
    private final Color mainWindowColor = DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color;
    private final Color textInputColor = DarkThemeColors.MENU_BAR_BACKGROUND_COLOR.color;
    private final Color buttonColor = DarkThemeColors.BUTTON_BACKGROUND_COLOR.color;
    private final Color textColor = DarkThemeColors.PRIMARY_TEXT_COLOR.color;
    private final Font sectionTitleFont = new Font("K2D", Font.BOLD, TextSizes.SUBSECTION_TITLE_TEXT_SIZE.size);
    private final Font elementTitleFont = new Font("K2D", Font.BOLD, TextSizes.ELEMENT_TITLE_TEXT_SIZE.size);
    private final Font inputFont = new Font("K2D", Font.PLAIN, TextSizes.BUTTON_TEXT_SIZE.size);

    private final TextField interestDays = new TextField(textInputColor, textColor, inputFont);
    private final TextField interestCapital = new TextField(textInputColor, textColor, inputFont);
    private final TextField interestQuote = new TextField(textInputColor, textColor, inputFont);
    private final TextField interestValue = new TextField(textInputColor, textColor, inputFont);
    private final Button interestCalcButton = new Button("Calculate", buttonColor, textColor, inputFont);

    private final TextField totAmountDays = new TextField(textInputColor, textColor, inputFont);
    private final TextField totAmountCapital = new TextField(textInputColor, textColor, inputFont);
    private final TextField totAmountQuote = new TextField(textInputColor, textColor, inputFont);
    private final TextField totAmountInterest = new TextField(textInputColor, textColor, inputFont);
    private final TextField totAmountValue = new TextField(textInputColor, textColor, inputFont);
    private final Button totAmountCalcButton = new Button("Calculate", buttonColor, textColor, inputFont);

    public InterestDialog(ResourceBundle bundle) {
        this.bundle = bundle;

        setSize(600, 500);
        setTitle("Interests Calculator");
        getContentPane().setBackground(mainWindowColor);
        setModal(false);
        setResizable(false);
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

        Label interestCalculatorLabel = new Label("Interest calculator",
                mainWindowColor,
                textColor,
                sectionTitleFont);
        interestPanel.add(interestCalculatorLabel);
        layout.putConstraint(SpringLayout.NORTH, interestCalculatorLabel, 5, SpringLayout.NORTH, interestPanel);
        layout.putConstraint(SpringLayout.WEST, interestCalculatorLabel, 5, SpringLayout.WEST, interestPanel);

        Label interestDaysLabel = new Label("Days",
                mainWindowColor,
                textColor,
                elementTitleFont);
        interestPanel.add(interestDaysLabel);
        layout.putConstraint(SpringLayout.NORTH, interestDaysLabel, 5, SpringLayout.SOUTH, interestCalculatorLabel);
        layout.putConstraint(SpringLayout.WEST, interestDaysLabel, 5, SpringLayout.WEST, interestPanel);

        interestDays.setColumns(20);
        interestPanel.add(interestDays);
        layout.putConstraint(SpringLayout.NORTH, interestDays, 5, SpringLayout.SOUTH, interestDaysLabel);
        layout.putConstraint(SpringLayout.WEST, interestDays, 5, SpringLayout.WEST, interestPanel);

        Label interestCapitalLabel = new Label("Capital",
                mainWindowColor,
                textColor,
                elementTitleFont);
        interestPanel.add(interestCapitalLabel);
        layout.putConstraint(SpringLayout.NORTH, interestCapitalLabel, 5, SpringLayout.SOUTH, interestDays);
        layout.putConstraint(SpringLayout.WEST, interestCapitalLabel, 5, SpringLayout.WEST, interestPanel);

        interestCapital.setColumns(20);
        interestPanel.add(interestCapital);
        layout.putConstraint(SpringLayout.NORTH, interestCapital, 5, SpringLayout.SOUTH, interestCapitalLabel);
        layout.putConstraint(SpringLayout.WEST, interestCapital, 5, SpringLayout.WEST, interestPanel);

        Label interestQuoteLabel = new Label("Quote",
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

        Label interestInterestLabel = new Label("Interest",
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

        interestPanel.add(interestCalcButton);
        layout.putConstraint(SpringLayout.SOUTH, interestCalcButton, -25, SpringLayout.SOUTH, interestPanel);
        layout.putConstraint(SpringLayout.EAST, interestCalcButton, -50, SpringLayout.EAST, interestPanel);

        return interestPanel;
    }

    private JPanel createTotAmountPanel() {
        JPanel totAmountPanel = new JPanel();
        totAmountPanel.setBackground(mainWindowColor);
        SpringLayout layout = new SpringLayout();
        totAmountPanel.setLayout(layout);

        Label totAmountCalculatorLabel = new Label("Total amount calculator",
                mainWindowColor,
                textColor,
                sectionTitleFont);
        totAmountPanel.add(totAmountCalculatorLabel);
        layout.putConstraint(SpringLayout.NORTH, totAmountCalculatorLabel, 5, SpringLayout.NORTH, totAmountPanel);
        layout.putConstraint(SpringLayout.WEST, totAmountCalculatorLabel, 5, SpringLayout.WEST, totAmountPanel);

        Label totAmountDaysLabel = new Label("Days",
                mainWindowColor,
                textColor,
                elementTitleFont);
        totAmountPanel.add(totAmountDaysLabel);
        layout.putConstraint(SpringLayout.NORTH, totAmountDaysLabel, 5, SpringLayout.SOUTH, totAmountCalculatorLabel);
        layout.putConstraint(SpringLayout.WEST, totAmountDaysLabel, 5, SpringLayout.WEST, totAmountPanel);

        totAmountDays.setColumns(20);
        totAmountPanel.add(totAmountDays);
        layout.putConstraint(SpringLayout.NORTH, totAmountDays, 5, SpringLayout.SOUTH, totAmountDaysLabel);
        layout.putConstraint(SpringLayout.WEST, totAmountDays, 5, SpringLayout.WEST, totAmountPanel);

        Label totAmountCapitalLabel = new Label("Capital",
                mainWindowColor,
                textColor,
                elementTitleFont);
        totAmountPanel.add(totAmountCapitalLabel);
        layout.putConstraint(SpringLayout.NORTH, totAmountCapitalLabel, 5, SpringLayout.SOUTH, totAmountDays);
        layout.putConstraint(SpringLayout.WEST, totAmountCapitalLabel, 5, SpringLayout.WEST, totAmountPanel);

        totAmountCapital.setColumns(20);
        totAmountPanel.add(totAmountCapital);
        layout.putConstraint(SpringLayout.NORTH, totAmountCapital, 5, SpringLayout.SOUTH, totAmountCapitalLabel);
        layout.putConstraint(SpringLayout.WEST, totAmountCapital, 5, SpringLayout.WEST, totAmountPanel);

        Label totAmountQuoteLabel = new Label("Quote",
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

        Label totAmountInterestLabel = new Label("Interest",
                mainWindowColor,
                textColor,
                elementTitleFont);
        totAmountPanel.add(totAmountInterestLabel);
        layout.putConstraint(SpringLayout.NORTH, totAmountInterestLabel, 5, SpringLayout.SOUTH, totAmountQuote);
        layout.putConstraint(SpringLayout.WEST, totAmountInterestLabel, 5, SpringLayout.WEST, totAmountPanel);

        totAmountInterest.setColumns(20);
        totAmountPanel.add(totAmountInterest);
        layout.putConstraint(SpringLayout.NORTH, totAmountInterest, 5, SpringLayout.SOUTH, totAmountInterestLabel);
        layout.putConstraint(SpringLayout.WEST, totAmountInterest, 5, SpringLayout.WEST, totAmountPanel);

        Label totAmountValueLabel = new Label("Total amount",
                mainWindowColor,
                textColor,
                elementTitleFont);
        totAmountPanel.add(totAmountValueLabel);
        layout.putConstraint(SpringLayout.NORTH, totAmountValueLabel, 5, SpringLayout.SOUTH, totAmountInterest);
        layout.putConstraint(SpringLayout.WEST, totAmountValueLabel, 5, SpringLayout.WEST, totAmountPanel);

        totAmountValue.setColumns(20);
        totAmountPanel.add(totAmountValue);
        layout.putConstraint(SpringLayout.NORTH, totAmountValue, 5, SpringLayout.SOUTH, totAmountValueLabel);
        layout.putConstraint(SpringLayout.WEST, totAmountValueLabel, 5, SpringLayout.WEST, totAmountPanel);

        totAmountPanel.add(totAmountCalcButton);
        layout.putConstraint(SpringLayout.SOUTH, totAmountCalcButton, -25, SpringLayout.SOUTH, totAmountPanel);
        layout.putConstraint(SpringLayout.EAST, totAmountCalcButton, -50, SpringLayout.EAST, totAmountPanel);

        return totAmountPanel;
    }
}