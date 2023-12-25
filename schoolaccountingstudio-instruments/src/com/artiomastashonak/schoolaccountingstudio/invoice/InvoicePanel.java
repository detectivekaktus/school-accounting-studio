package com.artiomastashonak.schoolaccountingstudio.invoice;

import com.artiomastashonak.schoolaccountingstudio.DarkThemeColors;
import com.artiomastashonak.schoolaccountingstudio.Label;
import com.artiomastashonak.schoolaccountingstudio.TextSizes;
import org.jetbrains.annotations.NotNull;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ResourceBundle;

public final class InvoicePanel extends JPanel {

    private final ResourceBundle bundle;

    private final Color mainWindowColor = DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color;
    private final Color textInputColor = DarkThemeColors.TEXT_ENTRY_BACKGROUND_COLOR.color;
    private final Color buttonColor = DarkThemeColors.BUTTON_BACKGROUND_COLOR.color;
    private final Color textColor = DarkThemeColors.PRIMARY_TEXT_COLOR.color;
    private final Font sectionTitleFont = new Font("K2D", Font.BOLD, TextSizes.SUBSECTION_TITLE_TEXT_SIZE.size);
    private final Font elementTitleFont = new Font("K2D", Font.BOLD, TextSizes.ELEMENT_TITLE_TEXT_SIZE.size);
    private final Font inputFont = new Font("K2D", Font.PLAIN, TextSizes.BUTTON_TEXT_SIZE.size);

    public InvoicePanel(@NotNull ResourceBundle bundle) {
        this.bundle = bundle;

        setBackground(mainWindowColor);
        setLayout(new GridLayout(13, 1));

        Label welcomeLabel = new Label(bundle.getString("invoiceGenerator"),
                mainWindowColor,
                textColor,
                sectionTitleFont);



        add(welcomeLabel);
    }
}