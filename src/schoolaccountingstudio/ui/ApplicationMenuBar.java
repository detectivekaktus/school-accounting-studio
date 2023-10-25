package schoolaccountingstudio.ui;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class ApplicationMenuBar extends JMenuBar {

    public ApplicationMenuBar() {
        String[] menuTitles = {"File", "Edit", "View", "Print", "Tools", "Help"};
        String[][] menuItems = {
                {"New Invoice", "Open Invoice", "Save", "Save as", "Close file", "Exit"},
                {"Undo", "Redo", "Cut", "Copy", "Paste"},
                {"Theme"},
                {"Print to XML"},
                {"Interest calculator"},
                {"Welcome", "Documentation", "GitHub", "About", "View license"}
        };

        JMenu[] menus = new JMenu[menuTitles.length];

        for (int menuIndex = 0; menuIndex < menuTitles.length; menuIndex++) {
            menus[menuIndex] = new JMenu(menuTitles[menuIndex]);
            for (int operationIndex = 0; operationIndex < menuItems[menuIndex].length; operationIndex++) {
                JMenuItem menuItem = new JMenuItem(menuItems[menuIndex][operationIndex]);
                menus[menuIndex].add(menuItem);
            }
            add(menus[menuIndex]);
        }

    }

}