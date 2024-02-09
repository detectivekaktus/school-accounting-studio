package com.artiomastashonak.schoolaccountingstudio;

import org.jetbrains.annotations.NotNull;
import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class MenuBar extends JMenuBar {
  public JMenuItem fileCreateInvoice;
  public JMenuItem fileSettingsItem;
  public JMenuItem fileExitItem;

  public JMenuItem toolsProportionCalcItem;
  public JMenuItem toolsInterestCalcItem;
  public JMenuItem toolsDiscountCalcItem;

  public JMenuItem helpWelcomeItem;
  public JMenuItem helpLicenseItem;
  public JMenuItem helpGitHubItem;

  public MenuBar() {
    setFont(UIHelper.getMenuBarFont());
    setBackground(UIHelper.getMenuBarColor());
    setForeground(UIHelper.getPrimaryTextColor());
    setBorder(null);
    setBorderPainted(false);

    JMenu fileMenu = new JMenu(Parameters.getBundle().getString("file"));
    fileMenu.setMnemonic(KeyEvent.VK_F);
    setupMenu(fileMenu);

    JMenu fileCreateMenu = new JMenu(Parameters.getBundle().getString("create"));
    fileCreateMenu.setMnemonic(KeyEvent.VK_C);
    setupMenu(fileCreateMenu);
    fileCreateInvoice = new JMenuItem(Parameters.getBundle().getString("invoice"));
    fileCreateInvoice.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
    setupMenuItem(fileCreateInvoice);
    fileCreateMenu.add(fileCreateInvoice);

    fileSettingsItem = new JMenuItem(Parameters.getBundle().getString("settings"));
    fileSettingsItem.setMnemonic(KeyEvent.VK_S);
    fileSettingsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK | InputEvent.ALT_DOWN_MASK));
    setupMenuItem(fileSettingsItem);

    fileExitItem = new JMenuItem(Parameters.getBundle().getString("exit"));
    fileExitItem.setMnemonic(KeyEvent.VK_X);
    setupMenuItem(fileExitItem);
    fileExitItem.addActionListener((e) -> System.exit(0));

    fileMenu.add(fileCreateMenu);
    fileMenu.add(fileSettingsItem);
    fileMenu.add(fileExitItem);
    add(fileMenu);

    JMenu toolsMenu = new JMenu(Parameters.getBundle().getString("tools"));
    toolsMenu.setMnemonic(KeyEvent.VK_T);
    setupMenu(toolsMenu);

    JMenu mathematicalMenu = new JMenu(Parameters.getBundle().getString("mathematicalInstruments"));
    mathematicalMenu.setMnemonic(KeyEvent.VK_M);
    setupMenu(mathematicalMenu);

    toolsProportionCalcItem = new JMenuItem(Parameters.getBundle().getString("proportionCalculator"));
    toolsProportionCalcItem.setMnemonic(KeyEvent.VK_P);
    toolsProportionCalcItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK));
    setupMenuItem(toolsProportionCalcItem);

    mathematicalMenu.add(toolsProportionCalcItem);

    toolsInterestCalcItem = new JMenuItem(Parameters.getBundle().getString("interestCalculator"));
    toolsInterestCalcItem.setMnemonic(KeyEvent.VK_I);
    toolsInterestCalcItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK));
    setupMenuItem(toolsInterestCalcItem);

    toolsDiscountCalcItem = new JMenuItem(Parameters.getBundle().getString("discountCalculator"));
    toolsDiscountCalcItem.setMnemonic(KeyEvent.VK_D);
    toolsDiscountCalcItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
    setupMenuItem(toolsDiscountCalcItem);

    toolsMenu.add(mathematicalMenu);
    toolsMenu.add(toolsInterestCalcItem);
    toolsMenu.add(toolsDiscountCalcItem);
    add(toolsMenu);

    JMenu helpMenu = new JMenu(Parameters.getBundle().getString("help"));
    helpMenu.setMnemonic(KeyEvent.VK_H);
    setupMenu(helpMenu);

    helpWelcomeItem = new JMenuItem(Parameters.getBundle().getString("welcome"));
    setupMenuItem(helpWelcomeItem);
    helpWelcomeItem.addActionListener((e) -> JOptionPane.showMessageDialog(null, "Welcome to School Accounting Studio!\nIt's a free and open-source project developed by an Italian\nstudent to facilitate the accounting routines for everyone!", "Welcome to School Accounting Studio", JOptionPane.INFORMATION_MESSAGE));

    helpLicenseItem = new JMenuItem(Parameters.getBundle().getString("license"));
    helpLicenseItem.setMnemonic(KeyEvent.VK_L);
    setupMenuItem(helpLicenseItem);
    helpLicenseItem.addActionListener((e) -> {
      try {
        Desktop.getDesktop().browse(new URI("https://github.com/Artiom-Astashonak/school-accounting-studio/blob/master/LICENSE"));
      } catch (IOException | URISyntaxException ignored) { }
    });

    helpGitHubItem = new JMenuItem(Parameters.getBundle().getString("github"));
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
    menu.setFont(UIHelper.getMenuBarFont());
    menu.setBackground(UIHelper.getMenuBarColor());
    menu.setForeground(UIHelper.getPrimaryTextColor());
    menu.getPopupMenu().setBorder(null);
    menu.setBorder(null);
    menu.setOpaque(true);
  }

  private void setupMenuItem(@NotNull JMenuItem menuItem) {
    menuItem.setFont(UIHelper.getMenuBarFont());
    menuItem.setBackground(UIHelper.getMenuBarColor());
    menuItem.setForeground(UIHelper.getPrimaryTextColor());
    menuItem.setBorderPainted(false);
    menuItem.setBorder(null);
    menuItem.setOpaque(true);
  }
}