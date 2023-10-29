package com.artiomastashonak.schoolaccountingstudio;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.io.File;

public class MainWindow {

    public static void main(String[] args) {

        Runnable mainWindowRunnable = () -> {
            Window window = new Window(new ImageIcon());

            File[] directories = {new File("generated/invoices/")};
            FileManager fileManager = new FileManager(directories);

            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new CardLayout());

            JPanel welcomePanel = new JPanel();
            welcomePanel.setLayout(new BorderLayout());

            JPanel welcomeNavigationPanel = new JPanel();
            welcomeNavigationPanel.setLayout(new BoxLayout(welcomeNavigationPanel, BoxLayout.Y_AXIS));
            welcomeNavigationPanel.setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
            welcomeNavigationPanel.setForeground(DarkThemeColors.PRIMARY_TEXT_COLOR.color);

            Label welcomeLabel = new Label(StringsEN.WELCOME_MESSAGE.value, new Font("K2D", Font.PLAIN, TextSizes.WELCOME_TITLE_TEXT_SIZE.size), DarkThemeColors.PRIMARY_TEXT_COLOR.color, DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
            welcomeNavigationPanel.add(welcomeLabel);

            Button invoiceCreateButton = new Button(StringsEN.INVOICE_CREATE_BUTTON_ACTION.value, new Font("K2D", Font.ITALIC, TextSizes.WELCOME_ACTION_BUTTONS_TEXT_SIZE.size), DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color, DarkThemeColors.VIOLET_PRIMARY_ACCENT_COLOR.color);
            invoiceCreateButton.setBorder(null);
            welcomeNavigationPanel.add(invoiceCreateButton);

            welcomePanel.add(welcomeNavigationPanel, BorderLayout.CENTER);
            mainPanel.add(welcomePanel, "WELCOME_PANEL");

            window.add(fileManager, BorderLayout.WEST);
            window.add(mainPanel, BorderLayout.CENTER);

            window.setVisible(true);
        };

        Thread mainWindowThread = new Thread(mainWindowRunnable);
        mainWindowThread.start();
    }

}