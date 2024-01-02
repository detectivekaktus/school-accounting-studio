package com.artiomastashonak.schoolaccountingstudio;

import org.jetbrains.annotations.NotNull;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.Color;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ResourceBundle;

public class MenuBar extends JMenuBar {

    private final ResourceBundle bundle;

    private final Font font = new Font("K2D", Font.PLAIN, TextSizes.MENU_BAR_TEXT_SIZE.size);
    private final Color foregroundColor = DarkThemeColors.PRIMARY_TEXT_COLOR.color;
    private final Color backgroundColor = DarkThemeColors.MENU_BAR_BACKGROUND_COLOR.color;

    public JMenuItem fileCreateInvoice;
    public JMenuItem fileOpenInvoice;
    public JMenuItem fileSaveAsItem;
    public JMenuItem fileSaveItem;
    public JMenuItem fileSettingsItem;
    public JMenuItem fileExitItem;

    public JMenuItem toolsPercentageCalcItem;
    public JMenuItem toolsInterestCalcItem;
    public JMenuItem toolsDiscountCalcItem;

    public JMenuItem helpWelcomeItem;
    public JMenuItem helpLicenseItem;
    public JMenuItem helpGitHubItem;

    public MenuBar(@NotNull ResourceBundle bundle) {
        this.bundle = bundle;

        setFont(font);
        setBackground(backgroundColor);
        setForeground(foregroundColor);
        setBorder(null);
        setBorderPainted(false);

        JMenu fileMenu = new JMenu(bundle.getString("menuBarFileMenu"));
        setupMenu(fileMenu);

        JMenu fileCreateMenu = new JMenu(bundle.getString("fileMenuCreate"));
        fileCreateMenu.setOpaque(true);
        setupMenu(fileCreateMenu);
        fileCreateInvoice = new JMenuItem(bundle.getString("fileMenuInvoice"));
        setupMenuItem(fileCreateInvoice);
        fileCreateMenu.add(fileCreateInvoice);

        JMenu fileOpenMenu = new JMenu(bundle.getString("fileMenuOpen"));
        fileOpenMenu.setOpaque(true);
        setupMenu(fileOpenMenu);
        fileOpenInvoice = new JMenuItem(bundle.getString("fileMenuInvoice"));
        setupMenuItem(fileOpenInvoice);
        fileOpenMenu.add(fileOpenInvoice);

        fileSaveAsItem = new JMenuItem(bundle.getString("fileMenuSaveAs"));
        setupMenuItem(fileSaveAsItem);

        fileSaveItem = new JMenuItem(bundle.getString("fileMenuSave"));
        setupMenuItem(fileSaveItem);

        fileSettingsItem = new JMenuItem(bundle.getString("fileMenuSettings"));
        setupMenuItem(fileSettingsItem);

        fileExitItem = new JMenuItem(bundle.getString("fileMenuExit"));
        setupMenuItem(fileExitItem);
        fileExitItem.addActionListener((e) -> System.exit(0));

        fileMenu.add(fileCreateMenu);
        fileMenu.add(fileOpenMenu);
        fileMenu.addSeparator();
        fileMenu.add(fileSaveAsItem);
        fileMenu.add(fileSaveItem);
        fileMenu.addSeparator();
        fileMenu.add(fileSettingsItem);
        fileMenu.addSeparator();
        fileMenu.add(fileExitItem);

        add(fileMenu);

        JMenu toolsMenu = new JMenu(bundle.getString("menuBarToolsMenu"));
        setupMenu(toolsMenu);

        toolsPercentageCalcItem = new JMenuItem(bundle.getString("toolsMenuPercentageCalculator"));
        setupMenuItem(toolsPercentageCalcItem);

        toolsInterestCalcItem = new JMenuItem(bundle.getString("toolsMenuInterestCalculator"));
        setupMenuItem(toolsInterestCalcItem);

        toolsDiscountCalcItem = new JMenuItem(bundle.getString("toolsMenuCommercialDiscountCalculator"));
        setupMenuItem(toolsDiscountCalcItem);

        toolsMenu.add(toolsPercentageCalcItem);
        toolsMenu.addSeparator();
        toolsMenu.add(toolsInterestCalcItem);
        toolsMenu.addSeparator();
        toolsMenu.add(toolsDiscountCalcItem);

        add(toolsMenu);

        JMenu helpMenu = new JMenu(bundle.getString("menuBarHelpMenu"));
        setupMenu(helpMenu);

        helpWelcomeItem = new JMenuItem(bundle.getString("helpWelcome"));
        setupMenuItem(helpWelcomeItem);

        helpLicenseItem = new JMenuItem(bundle.getString("helpLicense"));
        setupMenuItem(helpLicenseItem);
        helpLicenseItem.addActionListener((e) -> {
            try {
                Desktop.getDesktop().browse(new URI("https://github.com/Artiom-Astashonak/school-accounting-studio/blob/master/LICENSE"));
            } catch (IOException | URISyntaxException ignored) { }
        });

        helpGitHubItem = new JMenuItem(bundle.getString("helpGithub"));
        setupMenuItem(helpGitHubItem);
        helpGitHubItem.addActionListener((e) -> {
            try {
                Desktop.getDesktop().browse(new URI("https://github.com/Artiom-Astashonak/school-accounting-studio"));
            } catch (IOException | URISyntaxException ignored) { }
        });

        helpMenu.add(helpWelcomeItem);
        helpMenu.add(helpLicenseItem);
        helpMenu.addSeparator();
        helpMenu.add(helpGitHubItem);

        add(helpMenu);
    }

    private void setupMenu(@NotNull JMenu menu) {
        menu.setFont(font);
        menu.setBackground(backgroundColor);
        menu.setForeground(foregroundColor);
        menu.getPopupMenu().setBorder(null);
        menu.setBorder(null);
    }

    private void setupMenuItem(@NotNull JMenuItem menuItem) {
        menuItem.setFont(font);
        menuItem.setBackground(backgroundColor);
        menuItem.setForeground(foregroundColor);
        menuItem.setBorderPainted(false);
        menuItem.setBorder(null);
    }

}