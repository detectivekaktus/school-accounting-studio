package com.artiomastashonak.schoolaccountingstudio;

import com.artiomastashonak.schoolaccountingstudio.discount.DiscountPresentValueDialog;
import com.artiomastashonak.schoolaccountingstudio.interest.InterestTotAmountDialog;
import com.artiomastashonak.schoolaccountingstudio.invoice.InvoicePanel;
import com.artiomastashonak.schoolaccountingstudio.proportion.ProportionDialog;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class MainWindow {

  public static void main(String[] args) {
    Parameters.initialize();

    Window window = new Window(new ImageIcon("resources/img/icon_256_256.png"), Parameters.getBundle());
    MenuBar menuBar = Parameters.getMenuBar();
    window.setJMenuBar(menuBar);
    CardLayout cardLayout = new CardLayout();
    JPanel mainPanel = new JPanel();
    mainPanel.setName("MAIN");
    mainPanel.setLayout(cardLayout);
    window.add(mainPanel, BorderLayout.CENTER);

    JPanel cleanPanel = new JPanel();
    cleanPanel.setName("NONE");
    cleanPanel.setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
    Label logoLabel = new Label(Parameters.getBundle().getString("applicationName"), DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color, DarkThemeColors.VIOLET_PRIMARY_ACCENT_COLOR.color, new Font("sans-serif", Font.PLAIN, 32));
    cleanPanel.add(logoLabel);
    SpringLayout cleanPanelLayout = new SpringLayout();
    cleanPanelLayout.putConstraint(SpringLayout.NORTH, logoLabel, 10, SpringLayout.NORTH, window.getContentPane());
    cleanPanelLayout.putConstraint(SpringLayout.WEST, logoLabel, 50, SpringLayout.WEST, window.getContentPane());
    mainPanel.add(cleanPanel, "NONE");
    cardLayout.show(mainPanel, "NONE");

    menuBar.fileCreateInvoice.addActionListener((e) -> {
      for (Component component : mainPanel.getComponents()) {
        if (!Objects.equals(component.getName(), "INVOICE")) continue;
        if (JOptionPane.showConfirmDialog(null, Parameters.getBundle().getString("invoiceWarning"), Parameters.getBundle().getString("warning"), JOptionPane.YES_NO_OPTION) != 0) return;
        mainPanel.remove(component);
      }
      InvoicePanel invoicePanel = new InvoicePanel(Parameters.getBundle());
      invoicePanel.setPreferredSize(new Dimension(1200, 875));
      JScrollPane invoice = new JScrollPane(invoicePanel);
      invoice.getVerticalScrollBar().setUnitIncrement(5);
      invoice.getHorizontalScrollBar().setUnitIncrement(5);
      invoice.setName("INVOICE");
      invoice.setBorder(null);
      mainPanel.add(invoice, "INVOICE");
      cardLayout.show(mainPanel, "INVOICE");
    });
    menuBar.fileSettingsItem.addActionListener((e) -> showSettings());
    menuBar.toolsInterestCalcItem.addActionListener((e) -> new InterestTotAmountDialog(Parameters.getBundle()));
    menuBar.toolsDiscountCalcItem.addActionListener((e) -> new DiscountPresentValueDialog(Parameters.getBundle()));
    menuBar.toolsProportionCalcItem.addActionListener((e) -> new ProportionDialog(Parameters.getBundle()));

    window.setVisible(true);

    if (Parameters.getConfig().get("firstBoot").equals("true")) {
      menuBar.helpWelcomeItem.doClick();
      Parameters.getConfig().setProperty("firstBoot", "false");
      Parameters.updateConfig();
    }
  }

  private static void showSettings() {
    JDialog dialog = new JDialog();
    dialog.setModal(true);
    dialog.getContentPane().setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
    dialog.setSize(300, 300);
    dialog.setResizable(false);
    SpringLayout layout = new SpringLayout();
    dialog.setLayout(layout);

    Label settingsLabel = new Label(Parameters.getBundle().getString("settings"), DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color, DarkThemeColors.PRIMARY_TEXT_COLOR.color, new Font("sans-serif", Font.PLAIN, TextSizes.WELCOME_ACTION_BUTTONS_TEXT_SIZE.size));
    dialog.add(settingsLabel);
    layout.putConstraint(SpringLayout.NORTH, settingsLabel, 5, SpringLayout.NORTH, dialog);
    layout.putConstraint(SpringLayout.WEST, settingsLabel, 5, SpringLayout.WEST, dialog);

    Label languageLabel = new Label(Parameters.getBundle().getString("language"), DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color, DarkThemeColors.PRIMARY_TEXT_COLOR.color, new Font("sans-serif", Font.PLAIN, TextSizes.ELEMENT_TITLE_TEXT_SIZE.size));
    dialog.add(languageLabel);
    layout.putConstraint(SpringLayout.NORTH, languageLabel, 5, SpringLayout.SOUTH, settingsLabel);
    layout.putConstraint(SpringLayout.WEST, languageLabel, 5, SpringLayout.WEST, dialog);

    String[] languages = {"English", "Italiano", "Español", "Русский", "Shqip", "اَلْعَرَبِيَّة"};
    JComboBox<String> comboBox = new JComboBox<>(languages);
    comboBox.setBackground(DarkThemeColors.MENU_BAR_BACKGROUND_COLOR.color);
    comboBox.setForeground(DarkThemeColors.PRIMARY_TEXT_COLOR.color);
    comboBox.setFont(new Font("sans-serif", Font.PLAIN, TextSizes.BUTTON_TEXT_SIZE.size));
    dialog.add(comboBox);
    layout.putConstraint(SpringLayout.NORTH, comboBox, 5, SpringLayout.SOUTH, languageLabel);
    layout.putConstraint(SpringLayout.WEST, comboBox, 5, SpringLayout.WEST, dialog);

    Button submitButton = new Button(Parameters.getBundle().getString("submit"), DarkThemeColors.BUTTON_BACKGROUND_COLOR.color, DarkThemeColors.PRIMARY_TEXT_COLOR.color, new Font("sans-serif", Font.PLAIN, TextSizes.BUTTON_TEXT_SIZE.size));
    submitButton.addActionListener((e) -> {

    });
    submitButton.addActionListener((e) -> {
      switch ((String) Objects.requireNonNull(comboBox.getSelectedItem())) {
        case "English": {
          Parameters.getConfig().setProperty("language", "EN");
          Parameters.updateConfig();
          break;
        }
        case "Italiano": {
          Parameters.getConfig().setProperty("language", "IT");
          Parameters.updateConfig();
          break;
        }
        case "Español": {
          Parameters.getConfig().setProperty("language", "ES");
          Parameters.updateConfig();
          break;
        }
        case "Русский": {
          Parameters.getConfig().setProperty("language", "RU");
          Parameters.updateConfig();
          break;
        }
        case "Shqip": {
          Parameters.getConfig().setProperty("language", "SQ");
          Parameters.updateConfig();
          break;
        }
        case "اَلْعَرَبِيَّة": {
          Parameters.getConfig().setProperty("language", "AR");
          Parameters.updateConfig();
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