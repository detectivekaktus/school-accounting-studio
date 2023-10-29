package com.artiomastashonak.schoolaccountingstudio;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;

public class MenuBar extends JMenuBar {

    public MenuBar(Font font) {
        setFont(font);
        setBackground(DarkThemeColors.MENU_BAR_BACKGROUND_COLOR.color);
        setForeground(DarkThemeColors.PRIMARY_TEXT_COLOR.color);
        setBorder(null);
        setBorderPainted(false);

        String[] menuTitles = {"File", "Edit", "View", "Print", "Tools", "Help"};
        String[][] menuOptions = {
                {"Create new invoice", "Open invoice", "Save", "Save as", "Exit"},
                {"Undo", "Redo", "Copy", "Paste", "Cut"},
                {"File manager"},
                {"Print in XML"},
                {"Interest calculator"},
                {"Welcome", "GitHub", "License", "About"}
        };
        JMenu[] menus = new JMenu[menuTitles.length];

        for (int menuIndex = 0; menuIndex < menuTitles.length; menuIndex++) {
            menus[menuIndex] = new JMenu(menuTitles[menuIndex]);
            menus[menuIndex].setFont(font);
            menus[menuIndex].setBackground(DarkThemeColors.MENU_BAR_BACKGROUND_COLOR.color);
            menus[menuIndex].setForeground(DarkThemeColors.PRIMARY_TEXT_COLOR.color);
            menus[menuIndex].getPopupMenu().setBorder(null);
            menus[menuIndex].setMnemonic(menuTitles[menuIndex].charAt(0));

            for (int menuOptionIndex = 0; menuOptionIndex < menuOptions[menuIndex].length; menuOptionIndex++) {
                JMenuItem menuItem = new JMenuItem(menuOptions[menuIndex][menuOptionIndex]);
                menuItem.setFont(font);
                menuItem.setBackground(DarkThemeColors.MENU_BAR_BACKGROUND_COLOR.color);
                menuItem.setForeground(DarkThemeColors.PRIMARY_TEXT_COLOR.color);
                menuItem.setBorderPainted(false);
                menus[menuIndex].add(menuItem);
            }
            add(menus[menuIndex]);
        }

    }

}