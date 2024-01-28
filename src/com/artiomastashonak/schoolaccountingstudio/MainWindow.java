package com.artiomastashonak.schoolaccountingstudio;

import com.artiomastashonak.schoolaccountingstudio.discount.DiscountPresentValueDialog;
import com.artiomastashonak.schoolaccountingstudio.interest.InterestTotAmountDialog;
import com.artiomastashonak.schoolaccountingstudio.invoice.InvoicePanel;
import com.artiomastashonak.schoolaccountingstudio.proportion.ProportionDialog;
import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Objects;
import java.util.Properties;
import java.util.ResourceBundle;

public class MainWindow {

    public static Properties CONFIG = new Properties();
    public static ResourceBundle BUNDLE;

    public static void main(String[] args) {
        setConfig();
        BUNDLE = ResourceBundle.getBundle("strings/strings", Locale.of(CONFIG.get("language").toString()));

        Window window = new Window(new ImageIcon(), BUNDLE);
        MenuBar menuBar = new MenuBar(BUNDLE);
        window.setJMenuBar(menuBar);
        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel();
        mainPanel.setName("MAIN");
        mainPanel.setLayout(cardLayout);
        window.add(mainPanel, BorderLayout.CENTER);

        JPanel cleanPanel = new JPanel();
        cleanPanel.setName("NONE");
        cleanPanel.setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
        Label logoLabel = new Label("School Accounting Studio",
                DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color,
                DarkThemeColors.VIOLET_PRIMARY_ACCENT_COLOR.color,
                new Font("K2D", Font.PLAIN, 32));
        cleanPanel.add(logoLabel);
        SpringLayout cleanPanelLayout = new SpringLayout();
        cleanPanelLayout.putConstraint(SpringLayout.NORTH, logoLabel, 10, SpringLayout.NORTH, window.getContentPane());
        cleanPanelLayout.putConstraint(SpringLayout.WEST, logoLabel, 50, SpringLayout.WEST, window.getContentPane());
        mainPanel.add(cleanPanel, "NONE");
        cardLayout.show(mainPanel, "NONE");

        menuBar.fileCreateInvoice.addActionListener((e) -> {
            for (Component component : mainPanel.getComponents()) {
                if (!Objects.equals(component.getName(), "INVOICE")) continue;
                if (JOptionPane.showConfirmDialog(null, "Are you sure you want to start a new invoice?", "Warning", JOptionPane.YES_NO_OPTION) != 0) return;
                mainPanel.remove(component);
            }
            InvoicePanel invoicePanel = new InvoicePanel(BUNDLE);
            JScrollPane invoice = new JScrollPane(invoicePanel);
            invoice.setName("INVOICE");
            invoice.setBorder(null);
            mainPanel.add(invoice, "INVOICE");
            cardLayout.show(mainPanel, "INVOICE");
        });
        menuBar.fileSettingsItem.addActionListener((e) -> showSettings());
        menuBar.toolsInterestCalcItem.addActionListener((e) -> new InterestTotAmountDialog(BUNDLE));
        menuBar.toolsDiscountCalcItem.addActionListener((e) -> new DiscountPresentValueDialog(BUNDLE));
        menuBar.toolsProportionCalcItem.addActionListener((e) -> new ProportionDialog(BUNDLE));

        window.setVisible(true);

        if (CONFIG.get("firstBoot").equals("true")) {
            menuBar.helpWelcomeItem.doClick();
            CONFIG.setProperty("firstBoot", "false");
            updateConfig();
        }
    }

    private static void setConfig() {
        try {
            CONFIG.load(new FileInputStream("config.properties"));
        } catch (IOException e) { }
    }

    private static void updateConfig() {
        try {
            CONFIG.store(new FileOutputStream("config.properties"), "Configuration update caused by user action.");
        } catch (IOException e) { }
    }

    private static void showSettings() {
        JDialog dialog = new JDialog();
        dialog.setModal(true);
        dialog.getContentPane().setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
        dialog.setSize(300, 300);
        dialog.setResizable(false);
        SpringLayout layout = new SpringLayout();
        dialog.setLayout(layout);

        Label settingsLabel = new Label("Settings",
                DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color,
                DarkThemeColors.PRIMARY_TEXT_COLOR.color,
                new Font("K2D", Font.PLAIN, TextSizes.WELCOME_ACTION_BUTTONS_TEXT_SIZE.size));
        dialog.add(settingsLabel);
        layout.putConstraint(SpringLayout.NORTH, settingsLabel, 5, SpringLayout.NORTH, dialog);
        layout.putConstraint(SpringLayout.WEST, settingsLabel, 5, SpringLayout.WEST, dialog);

        Label languageLabel = new Label("Language",
                DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color,
                DarkThemeColors.PRIMARY_TEXT_COLOR.color,
                new Font("K2D", Font.PLAIN, TextSizes.ELEMENT_TITLE_TEXT_SIZE.size));
        dialog.add(languageLabel);
        layout.putConstraint(SpringLayout.NORTH, languageLabel, 5, SpringLayout.SOUTH, settingsLabel);
        layout.putConstraint(SpringLayout.WEST, languageLabel, 5, SpringLayout.WEST, dialog);

        String[] languages = {"English", "Italiano", "Español", "Русский", "Shqip", "اَلْعَرَبِيَّة"};
        JComboBox<String> comboBox = new JComboBox<>(languages);
        comboBox.setBackground(DarkThemeColors.MENU_BAR_BACKGROUND_COLOR.color);
        comboBox.setForeground(DarkThemeColors.PRIMARY_TEXT_COLOR.color);
        comboBox.setFont(new Font("K2D", Font.PLAIN, TextSizes.BUTTON_TEXT_SIZE.size));
        dialog.add(comboBox);
        layout.putConstraint(SpringLayout.NORTH, comboBox, 5, SpringLayout.SOUTH, languageLabel);
        layout.putConstraint(SpringLayout.WEST, comboBox, 5, SpringLayout.WEST, dialog);

        Button submitButton = new Button("Submit",
                DarkThemeColors.BUTTON_BACKGROUND_COLOR.color,
                DarkThemeColors.PRIMARY_TEXT_COLOR.color,
                new Font("K2D", Font.PLAIN, TextSizes.BUTTON_TEXT_SIZE.size));
        submitButton.addActionListener((e) -> {
            switch ((String) comboBox.getSelectedItem()) {
                case "English": {
                    CONFIG.setProperty("language", "EN");
                    updateConfig();
                    break;
                }
                case "Italiano": {
                    CONFIG.setProperty("language", "IT");
                    updateConfig();
                    break;
                }
                case "Español": {
                    CONFIG.setProperty("language", "ES");
                    updateConfig();
                    break;
                }
                case "Русский": {
                    CONFIG.setProperty("language", "RU");
                    updateConfig();
                    break;
                }
                case "Shqip": {
                    CONFIG.setProperty("language", "SQ");
                    updateConfig();
                    break;
                }
                case "اَلْعَرَبِيَّة": {
                    CONFIG.setProperty("language", "AR");
                    updateConfig();
                    break;
                }
                default: break;
            }
        });
        dialog.add(submitButton);
        layout.putConstraint(SpringLayout.SOUTH, submitButton, -5, SpringLayout.SOUTH, dialog.getContentPane());
        layout.putConstraint(SpringLayout.EAST, submitButton, -5, SpringLayout.EAST, dialog.getContentPane());

        dialog.show();
    }
}