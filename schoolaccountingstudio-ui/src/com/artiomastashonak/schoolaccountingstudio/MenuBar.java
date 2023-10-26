package com.artiomastashonak.schoolaccountingstudio;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {

    public MenuBar() {
        String[] menuTitles = {"File", "Edit", "Print", "Tools", "Help"};
        String[][] menuOptions = {
                {"Create new invoice", "Open invoice", "Save", "Save as", "Exit"},
                {"Undo", "Redo", "Copy", "Paste", "Cut"},
                {"Print in XML"},
                {"Interest calculator"},
                {"Welcome", "About", "License", "GitHub"}
        };
        JMenu[] menus = new JMenu[menuTitles.length];

        for (int menuIndex = 0; menuIndex < menuTitles.length; menuIndex++) {
            menus[menuIndex] = new JMenu(menuTitles[menuIndex]);
            menus[menuIndex].setMnemonic(menuTitles[menuIndex].charAt(0));
            for (int menuOptionIndex = 0; menuOptionIndex < menuOptions[menuIndex].length; menuOptionIndex++) {
                menus[menuIndex].add(new JMenuItem(menuOptions[menuIndex][menuOptionIndex]));
            }
            add(menus[menuIndex]);
        }
    }

}