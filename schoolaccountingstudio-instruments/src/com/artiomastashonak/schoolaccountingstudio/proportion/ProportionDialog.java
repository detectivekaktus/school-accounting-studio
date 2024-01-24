package com.artiomastashonak.schoolaccountingstudio.proportion;

import com.artiomastashonak.schoolaccountingstudio.Button;
import com.artiomastashonak.schoolaccountingstudio.DarkThemeColors;
import com.artiomastashonak.schoolaccountingstudio.Label;
import com.artiomastashonak.schoolaccountingstudio.TextField;
import com.artiomastashonak.schoolaccountingstudio.TextSizes;
import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

public class ProportionDialog extends JDialog {

    private ResourceBundle bundle;
    private final Color MAIN_WINDOW_COLOR = DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color;
    private final Color TEXT_INPUT_COLOR = DarkThemeColors.MENU_BAR_BACKGROUND_COLOR.color;
    private final Color BUTTON_COLOR = DarkThemeColors.BUTTON_BACKGROUND_COLOR.color;
    private final Color TEXT_COLOR = DarkThemeColors.PRIMARY_TEXT_COLOR.color;
    private final Font SECTION_TITLE_FONT = new Font("K2D", Font.BOLD, TextSizes.SUBSECTION_TITLE_TEXT_SIZE.size);
    private final Font INPUT_FONT = new Font("K2D", Font.PLAIN, TextSizes.BUTTON_TEXT_SIZE.size);

    private final TextField firstTermTextField = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
    private final TextField secondtTermTextField = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
    private final TextField thirdTermTextField = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
    private final TextField fourthTermTextField = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);

    public ProportionDialog(ResourceBundle bundle) {
        this.bundle = bundle;

        setMinimumSize(new Dimension(450, 250));
        setTitle("Proportion Calculator");
        getContentPane().setBackground(MAIN_WINDOW_COLOR);
        setModal(false);
        SpringLayout layout = new SpringLayout();
        setLayout(layout);

        Label proportionCalculatorLabel = new Label("Proportion calculator",
                MAIN_WINDOW_COLOR,
                TEXT_COLOR,
                SECTION_TITLE_FONT);
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

        secondtTermTextField.setColumns(5);
        add(secondtTermTextField);
        layout.putConstraint(SpringLayout.NORTH, secondtTermTextField, 25, SpringLayout.SOUTH, proportionCalculatorLabel);
        layout.putConstraint(SpringLayout.WEST, secondtTermTextField, 5, SpringLayout.EAST, firstIsToLabel);

        Label asLabel = new Label("=",
                MAIN_WINDOW_COLOR,
                TEXT_COLOR,
                INPUT_FONT);
        add(asLabel);
        layout.putConstraint(SpringLayout.NORTH, asLabel, 0, SpringLayout.NORTH, secondtTermTextField);
        layout.putConstraint(SpringLayout.WEST, asLabel, 5, SpringLayout.EAST, secondtTermTextField);

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

        Button solveButton = new Button("Solve",
                BUTTON_COLOR,
                TEXT_COLOR,
                INPUT_FONT);
        add(solveButton);
        layout.putConstraint(SpringLayout.SOUTH, solveButton, -25, SpringLayout.SOUTH, getContentPane());
        layout.putConstraint(SpringLayout.EAST, solveButton, -10, SpringLayout.EAST, getContentPane());

        Button resetButton = new Button("Reset",
                BUTTON_COLOR,
                TEXT_COLOR,
                INPUT_FONT);
        add(resetButton);
        layout.putConstraint(SpringLayout.NORTH, resetButton, 0, SpringLayout.NORTH, solveButton);
        layout.putConstraint(SpringLayout.EAST, resetButton, -10, SpringLayout.WEST, solveButton);

        show();
    }
}