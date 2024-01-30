package com.artiomastashonak.schoolaccountingstudio;

import org.jetbrains.annotations.NotNull;
import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ResourceBundle;

public class MenuBar extends JMenuBar {
  private final Font font = new Font("sans-serif", Font.PLAIN, TextSizes.MENU_BAR_TEXT_SIZE.size);
  private final Color foregroundColor = DarkThemeColors.PRIMARY_TEXT_COLOR.color;
  private final Color backgroundColor = DarkThemeColors.MENU_BAR_BACKGROUND_COLOR.color;

  public JMenuItem fileCreateInvoice;
  public JMenuItem fileSettingsItem;
  public JMenuItem fileExitItem;

  public JMenuItem toolsProportionCalcItem;
  public JMenuItem toolsInterestCalcItem;
  public JMenuItem toolsDiscountCalcItem;

  public JMenuItem helpWelcomeItem;
  public JMenuItem helpLicenseItem;
  public JMenuItem helpGitHubItem;

  public MenuBar(@NotNull ResourceBundle bundle) {
    setFont(font);
    setBackground(backgroundColor);
    setForeground(foregroundColor);
    setBorder(null);
    setBorderPainted(false);

    JMenu fileMenu = new JMenu(bundle.getString("file"));
    fileMenu.setMnemonic(KeyEvent.VK_F);
    setupMenu(fileMenu);

    JMenu fileCreateMenu = new JMenu(bundle.getString("create"));
    fileCreateMenu.setMnemonic(KeyEvent.VK_C);
    setupMenu(fileCreateMenu);
    fileCreateInvoice = new JMenuItem(bundle.getString("invoice"));
    fileCreateInvoice.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
    setupMenuItem(fileCreateInvoice);
    fileCreateMenu.add(fileCreateInvoice);

    fileSettingsItem = new JMenuItem(bundle.getString("settings"));
    fileSettingsItem.setMnemonic(KeyEvent.VK_S);
    fileSettingsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK | InputEvent.ALT_DOWN_MASK));
    setupMenuItem(fileSettingsItem);

    fileExitItem = new JMenuItem(bundle.getString("exit"));
    fileExitItem.setMnemonic(KeyEvent.VK_X);
    setupMenuItem(fileExitItem);
    fileExitItem.addActionListener((e) -> System.exit(0));

    fileMenu.add(fileCreateMenu);
    fileMenu.add(fileSettingsItem);
    fileMenu.add(fileExitItem);
    add(fileMenu);

    JMenu toolsMenu = new JMenu(bundle.getString("tools"));
    toolsMenu.setMnemonic(KeyEvent.VK_T);
    setupMenu(toolsMenu);

    JMenu mathematicalMenu = new JMenu(bundle.getString("mathematicalInstruments"));
    mathematicalMenu.setMnemonic(KeyEvent.VK_M);
    setupMenu(mathematicalMenu);

    toolsProportionCalcItem = new JMenuItem(bundle.getString("proportionCalculator"));
    toolsProportionCalcItem.setMnemonic(KeyEvent.VK_P);
    toolsProportionCalcItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK));
    setupMenuItem(toolsProportionCalcItem);

    mathematicalMenu.add(toolsProportionCalcItem);

    toolsInterestCalcItem = new JMenuItem(bundle.getString("interestCalculator"));
    toolsInterestCalcItem.setMnemonic(KeyEvent.VK_I);
    toolsInterestCalcItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK));
    setupMenuItem(toolsInterestCalcItem);

    toolsDiscountCalcItem = new JMenuItem(bundle.getString("discountCalculator"));
    toolsDiscountCalcItem.setMnemonic(KeyEvent.VK_D);
    toolsDiscountCalcItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
    setupMenuItem(toolsDiscountCalcItem);

    toolsMenu.add(mathematicalMenu);
    toolsMenu.add(toolsInterestCalcItem);
    toolsMenu.add(toolsDiscountCalcItem);
    add(toolsMenu);

    JMenu helpMenu = new JMenu(bundle.getString("help"));
    helpMenu.setMnemonic(KeyEvent.VK_H);
    setupMenu(helpMenu);

    helpWelcomeItem = new JMenuItem(bundle.getString("welcome"));
    setupMenuItem(helpWelcomeItem);
    helpWelcomeItem.addActionListener((e) -> JOptionPane.showMessageDialog(null, "Welcome to School Accounting Studio!\nIt's a free and open-source project developed by an Italian\nstudent to facilitate the accounting routines for everyone!", "Welcome to School Accounting Studio", JOptionPane.INFORMATION_MESSAGE));

    helpLicenseItem = new JMenuItem(bundle.getString("license"));
    helpLicenseItem.setMnemonic(KeyEvent.VK_L);
    setupMenuItem(helpLicenseItem);
    helpLicenseItem.addActionListener((e) -> {
      try {
        Desktop.getDesktop().browse(new URI("https://github.com/Artiom-Astashonak/school-accounting-studio/blob/master/LICENSE"));
      } catch (IOException | URISyntaxException ignored) { }
    });

    helpGitHubItem = new JMenuItem(bundle.getString("github"));
    setupMenuItem(helpGitHubItem);
    helpGitHubItem.addActionListener((e) -> {
      try {
        Desktop.getDesktop().browse(new URI("https://github.com/Artiom-Astashonak/school-accounting-studio"));
      } catch (IOException | URISyntaxException ignored) { }
    });

    helpMenu.add(helpWelcomeItem);
    helpMenu.add(helpLicenseItem);
    helpMenu.add(helpGitHubItem);
    add(helpMenu);
  }

  private void setupMenu(@NotNull JMenu menu) {
    menu.setFont(font);
    menu.setBackground(backgroundColor);
    menu.setForeground(foregroundColor);
    menu.getPopupMenu().setBorder(null);
    menu.setBorder(null);
    menu.setOpaque(true);
  }

  private void setupMenuItem(@NotNull JMenuItem menuItem) {
    menuItem.setFont(font);
    menuItem.setBackground(backgroundColor);
    menuItem.setForeground(foregroundColor);
    menuItem.setBorderPainted(false);
    menuItem.setBorder(null);
    menuItem.setOpaque(true);
  }
}