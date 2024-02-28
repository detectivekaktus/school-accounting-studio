// Copyright 2023-2024 Artiom Astashonak. Use of this code is governed by the Apache License 2.0 that can be found in the LICENSE file.
package com.artiomastashonak.schoolaccountingstudio;

import com.artiomastashonak.schoolaccountingstudio.discount.DiscountPresentValueDialog;
import com.artiomastashonak.schoolaccountingstudio.interest.InterestTotAmountDialog;
import com.artiomastashonak.schoolaccountingstudio.invoice.InvoicePanel;
import com.artiomastashonak.schoolaccountingstudio.proportion.ProportionDialog;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * The {@code MainWindow} object represents a window instance for the application
 * running on the user side. On initialization, the object sets up configuration
 * for the {@link Parameters} object to start running the main thread of the
 * program.
 * <p>
 * After initializing all dependencies and configurations, the object creares a
 * new {@link Window} instance visible to the end user and puts all necessary
 * components on the canvas, as well as places {@code ActionListener} for the
 * {@link MenuBar} object attached to the current instance.
 * <p>
 * If the application is run for the first time, the user will be welcomed with
 * a message, after which the message won't appear on subsequent launches.
 *
 * @see Parameters
 * @see InvoicePanel
 *
 * @author Artiom Astashonak
 */
public class MainWindow {
  public static void main(String[] args) {
    Parameters.initialize();

    Window window = new Window(new ImageIcon("resources/img/icon_256_256.png"));
    MenuBar menuBar = Parameters.getMenuBar();
    window.setJMenuBar(menuBar);
    CardLayout cardLayout = new CardLayout();
    JPanel mainPanel = new JPanel();
    mainPanel.setName("MAIN");
    mainPanel.setLayout(cardLayout);
    window.add(mainPanel, BorderLayout.CENTER);

    JPanel cleanPanel = new JPanel();
    cleanPanel.setName("NONE");
    cleanPanel.setBackground(UIHelper.getMainWindowColor());
    Label logoLabel = new Label(Parameters.getBundle().getString("applicationName"), UIHelper.getMainWindowColor(), UIHelper.getVioletPrimaryColor(), new Font("sans-serif", Font.PLAIN, 32));
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
      InvoicePanel invoicePanel = new InvoicePanel();
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
    menuBar.toolsInterestCalcItem.addActionListener((e) -> new InterestTotAmountDialog());
    menuBar.toolsDiscountCalcItem.addActionListener((e) -> new DiscountPresentValueDialog());
    menuBar.toolsProportionCalcItem.addActionListener((e) -> new ProportionDialog());

    window.setVisible(true);

    if (Parameters.getConfig().get("firstBoot").equals("true")) {
      menuBar.helpWelcomeItem.doClick();
      Parameters.getConfig().setProperty("firstBoot", "false");
      Parameters.updateConfig();
    }
  }

  /**
   * Creates a new {@link JDialog} object displayed to the user with a list of
   * currently available settings for the application.
   * <p>
   * When clicked on the {@code submitButton}, the changes are applied on the
   * {@link Parameters} object and the dialog window gets disposed.
   */
  private static void showSettings() {
    JDialog dialog = new JDialog();
    dialog.setModal(true);
    dialog.getContentPane().setBackground(UIHelper.getMainWindowColor());
    dialog.setSize(300, 300);
    dialog.setResizable(false);
    SpringLayout layout = new SpringLayout();
    dialog.setLayout(layout);

    Label settingsLabel = new Label(Parameters.getBundle().getString("settings"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getSectionTitleFont());
    dialog.add(settingsLabel);
    layout.putConstraint(SpringLayout.NORTH, settingsLabel, 5, SpringLayout.NORTH, dialog);
    layout.putConstraint(SpringLayout.WEST, settingsLabel, 5, SpringLayout.WEST, dialog);

    Label languageLabel = new Label(Parameters.getBundle().getString("language"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    dialog.add(languageLabel);
    layout.putConstraint(SpringLayout.NORTH, languageLabel, 5, SpringLayout.SOUTH, settingsLabel);
    layout.putConstraint(SpringLayout.WEST, languageLabel, 5, SpringLayout.WEST, dialog);

    String[] languages = {"English", "Italiano", "Español", "Русский", "Shqip", "اَلْعَرَبِيَّة"};
    JComboBox<String> comboBox = new JComboBox<>(languages);
    comboBox.setBackground(UIHelper.getMenuBarColor());
    comboBox.setForeground(UIHelper.getPrimaryTextColor());
    comboBox.setFont(UIHelper.getInputFont());
    dialog.add(comboBox);
    layout.putConstraint(SpringLayout.NORTH, comboBox, 5, SpringLayout.SOUTH, languageLabel);
    layout.putConstraint(SpringLayout.WEST, comboBox, 5, SpringLayout.WEST, dialog);

    Button submitButton = new Button(Parameters.getBundle().getString("submit"), UIHelper.getBrightButtonColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
    submitButton.addActionListener((e) -> {

    });
    submitButton.addActionListener((e) -> {
      switch ((String) Objects.requireNonNull(comboBox.getSelectedItem())) {
        case "English": {
          Parameters.getConfig().setProperty("language", "EN");
          Parameters.updateConfig();
          dialog.dispose();
          break;
        }
        case "Italiano": {
          Parameters.getConfig().setProperty("language", "IT");
          Parameters.updateConfig();
          dialog.dispose();
          break;
        }
        case "Español": {
          Parameters.getConfig().setProperty("language", "ES");
          Parameters.updateConfig();
          dialog.dispose();
          break;
        }
        case "Русский": {
          Parameters.getConfig().setProperty("language", "RU");
          Parameters.updateConfig();
          dialog.dispose();
          break;
        }
        case "Shqip": {
          Parameters.getConfig().setProperty("language", "SQ");
          Parameters.updateConfig();
          dialog.dispose();
          break;
        }
        case "اَلْعَرَبِيَّة": {
          Parameters.getConfig().setProperty("language", "AR");
          Parameters.updateConfig();
          dialog.dispose();
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