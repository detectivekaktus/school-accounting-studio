package com.artiomastashonak.schoolaccountingstudio.proportion;

import com.artiomastashonak.schoolaccountingstudio.Button;
import com.artiomastashonak.schoolaccountingstudio.DarkThemeColors;
import com.artiomastashonak.schoolaccountingstudio.Label;
import com.artiomastashonak.schoolaccountingstudio.TextField;
import com.artiomastashonak.schoolaccountingstudio.TextSizes;
import com.artiomastashonak.schoolaccountingstudio.exceptions.NoSolutionException;
import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

public class ProportionDialog extends JDialog {

    private final ResourceBundle bundle;
    private final Proportion proportion = new Proportion();
    private final Color TEXT_INPUT_COLOR = DarkThemeColors.MENU_BAR_BACKGROUND_COLOR.color;
    private final Color TEXT_COLOR = DarkThemeColors.PRIMARY_TEXT_COLOR.color;
    private final Font INPUT_FONT = new Font("sans-serif", Font.PLAIN, TextSizes.BUTTON_TEXT_SIZE.size);

    private final TextField firstTermTextField = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
    private final TextField secondTermTextField = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
    private final TextField thirdTermTextField = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
    private final TextField fourthTermTextField = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);

    public ProportionDialog(ResourceBundle bundle) {
        this.bundle = bundle;
        Color MAIN_WINDOW_COLOR = DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color;

        setMinimumSize(new Dimension(450, 250));
        setTitle(bundle.getString("proportionCalculator"));
        getContentPane().setBackground(MAIN_WINDOW_COLOR);
        setModal(false);
        SpringLayout layout = new SpringLayout();
        setLayout(layout);

        Label proportionCalculatorLabel = new Label(bundle.getString("proportionCalculator"),
                MAIN_WINDOW_COLOR,
                TEXT_COLOR,
                new Font("sans-serif", Font.BOLD, TextSizes.SUBSECTION_TITLE_TEXT_SIZE.size));
        add(proportionCalculatorLabel);
        layout.putConstraint(SpringLayout.NORTH, proportionCalculatorLabel, 5, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, proportionCalculatorLabel, 5, SpringLayout.WEST, this);

        firstTermTextField.setColumns(5);
        add(firstTermTextField);
        layout.putConstraint(SpringLayout.NORTH, firstTermTextField, 25, SpringLayout.SOUTH, proportionCalculatorLabel);
        layout.putConstraint(SpringLayout.WEST, firstTermTextField, 5, SpringLayout.WEST, this);

        Label firstIsToLabel = new Label(":",
                MAIN_WINDOW_COLOR,
                TEXT_COLOR,
                INPUT_FONT);
        add(firstIsToLabel);
        layout.putConstraint(SpringLayout.NORTH, firstIsToLabel, 0, SpringLayout.NORTH, firstTermTextField);
        layout.putConstraint(SpringLayout.WEST, firstIsToLabel, 5, SpringLayout.EAST, firstTermTextField);

        secondTermTextField.setColumns(5);
        add(secondTermTextField);
        layout.putConstraint(SpringLayout.NORTH, secondTermTextField, 25, SpringLayout.SOUTH, proportionCalculatorLabel);
        layout.putConstraint(SpringLayout.WEST, secondTermTextField, 5, SpringLayout.EAST, firstIsToLabel);

        Label asLabel = new Label("=",
                MAIN_WINDOW_COLOR,
                TEXT_COLOR,
                INPUT_FONT);
        add(asLabel);
        layout.putConstraint(SpringLayout.NORTH, asLabel, 0, SpringLayout.NORTH, secondTermTextField);
        layout.putConstraint(SpringLayout.WEST, asLabel, 5, SpringLayout.EAST, secondTermTextField);

        thirdTermTextField.setColumns(5);
        add(thirdTermTextField);
        layout.putConstraint(SpringLayout.NORTH, thirdTermTextField, 25, SpringLayout.SOUTH, proportionCalculatorLabel);
        layout.putConstraint(SpringLayout.WEST, thirdTermTextField, 5, SpringLayout.EAST, asLabel);

        Label secondIsToLabel = new Label(":",
                MAIN_WINDOW_COLOR,
                TEXT_COLOR,
                INPUT_FONT);
        add(secondIsToLabel);
        layout.putConstraint(SpringLayout.NORTH, secondIsToLabel, 0, SpringLayout.NORTH, thirdTermTextField);
        layout.putConstraint(SpringLayout.WEST, secondIsToLabel, 5, SpringLayout.EAST, thirdTermTextField);

        fourthTermTextField.setColumns(5);
        add(fourthTermTextField);
        layout.putConstraint(SpringLayout.NORTH, fourthTermTextField, 25, SpringLayout.SOUTH, proportionCalculatorLabel);
        layout.putConstraint(SpringLayout.WEST, fourthTermTextField, 5, SpringLayout.EAST, secondIsToLabel);

        Color BUTTON_COLOR = DarkThemeColors.BUTTON_BACKGROUND_COLOR.color;
        Button solveButton = new Button(bundle.getString("solve"),
        BUTTON_COLOR,
                TEXT_COLOR,
                INPUT_FONT);
        solveButton.addActionListener((e) -> {
            try {
                if (composeProportion() == -1) return;
                double result = proportion.solve();
                if (Double.isNaN(result)) {
                    JOptionPane.showInternalMessageDialog(null, bundle.getString("noSolutionFoundInvalid"));
                    return;
                }
                JOptionPane.showInternalMessageDialog(null, String.format(bundle.getString("solutionIs"), result));
            } catch (NoSolutionException nse) {
                JOptionPane.showInternalMessageDialog(null, bundle.getString("noSolutionFoundInvalid"));
            }
        });
        add(solveButton);
        layout.putConstraint(SpringLayout.SOUTH, solveButton, -25, SpringLayout.SOUTH, getContentPane());
        layout.putConstraint(SpringLayout.EAST, solveButton, -10, SpringLayout.EAST, getContentPane());

        Button resetButton = new Button(bundle.getString("reset"),
                BUTTON_COLOR,
                TEXT_COLOR,
                INPUT_FONT);
        resetButton.addActionListener((e) -> {
            resetInput();
            proportion.reset();
        });
        add(resetButton);
        layout.putConstraint(SpringLayout.NORTH, resetButton, 0, SpringLayout.NORTH, solveButton);
        layout.putConstraint(SpringLayout.EAST, resetButton, -10, SpringLayout.WEST, solveButton);

        show();
    }

    private int composeProportion() {
        int termsToFind = 0;
        for (TextField textField : new TextField[]{firstTermTextField, secondTermTextField, thirdTermTextField, fourthTermTextField}) {
            try {
                Double.parseDouble(textField.getText());
            } catch (Exception exception) {
                termsToFind++;
            }
        }
        if (termsToFind != 1) {
            JOptionPane.showInternalMessageDialog(null, bundle.getString("noSolutionFoundUnsolvableComposed"));
            return -1;
        }
        try {
            proportion.setA(Double.parseDouble(firstTermTextField.getText()));
            proportion.setB(Double.parseDouble(secondTermTextField.getText()));
            proportion.setC(Double.parseDouble(thirdTermTextField.getText()));
            proportion.setD(Double.parseDouble(fourthTermTextField.getText()));
        } catch (Exception e) { }

        return 0;
    }

    private void resetInput() {
        for (TextField textField : new TextField[]{firstTermTextField, secondTermTextField, thirdTermTextField, fourthTermTextField}) {
            textField.setText("");
        }
        proportion.reset();
    }
}