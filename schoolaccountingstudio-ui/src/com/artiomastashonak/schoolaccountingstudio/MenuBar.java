// Copyright 2023-2024 Artiom Astashonak. Use of this code is governed by the Apache License 2.0 that can be found in the LICENSE file.
package com.artiomastashonak.schoolaccountingstudio;

import org.jetbrains.annotations.NotNull;
import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * The {@code MenuBar} object describes a menu bar attached to the top of the
 * {@link Window} object in memory.
 * <p>
 * It provides control and access to its child elements to be modified (yet
 * not reassigned) objects of the application.
 *
 * @see JMenuBar
 * @see JMenu
 * @see JMenuItem
 * @see Window
 *
 * @author Artiom Astashonak
 */
public class MenuBar extends JMenuBar {
  public final JMenuItem fileCreateInvoice;
  public final JMenuItem fileSettingsItem;
  public final JMenuItem fileExitItem;

  public final JMenuItem toolsProportionCalcItem;
  public final JMenuItem toolsInterestCalcItem;
  public final JMenuItem toolsDiscountCalcItem;
  public final JMenuItem toolsDateCalcItem;

  public final JMenuItem helpWelcomeItem;
  public final JMenuItem helpLicenseItem;
  public final JMenuItem helpGitHubItem;

  /**
   * Constructs a new {@code MenuBar} instance in memory with {@code fileExitItem},
   * {@code helpWelcomeItem}, {@code helpLicenseItem}, and {@code helpGitHubItem}
   * menu elements setup by default.
   */
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

    toolsDateCalcItem = new JMenuItem(Parameters.getBundle().getString("dateCalculator"));
    toolsDateCalcItem.setMnemonic(KeyEvent.VK_T);
    toolsDateCalcItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_DOWN_MASK));
    setupMenuItem(toolsDateCalcItem);

    toolsMenu.add(mathematicalMenu);
    toolsMenu.add(toolsInterestCalcItem);
    toolsMenu.add(toolsDiscountCalcItem);
    toolsMenu.add(toolsDateCalcItem);
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

  /**
   * Applies standard styling properties to the menu.
   *
   * @param menu the {@link JMenu} instance to be modified
   */
  private void setupMenu(@NotNull JMenu menu) {
    menu.setFont(UIHelper.getMenuBarFont());
    menu.setBackground(UIHelper.getMenuBarColor());
    menu.setForeground(UIHelper.getPrimaryTextColor());
    menu.getPopupMenu().setBorder(null);
    menu.setBorder(null);
    menu.setOpaque(true);
  }

  /**
   * Applies standard styling properties to the menu item.
   *
   * @param menuItem the {@link JMenuItem} instance to be modified
   */
  private void setupMenuItem(@NotNull JMenuItem menuItem) {
    menuItem.setFont(UIHelper.getMenuBarFont());
    menuItem.setBackground(UIHelper.getMenuBarColor());
    menuItem.setForeground(UIHelper.getPrimaryTextColor());
    menuItem.setBorderPainted(false);
    menuItem.setBorder(null);
    menuItem.setOpaque(true);
  }
}