package com.artiomastashonak.schoolaccountingstudio;

import com.artiomastashonak.schoolaccountingstudio.invoice.InvoicePanel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
            CardLayout mainPanelCardLayout = new CardLayout();
            mainPanel.setLayout(mainPanelCardLayout);
            mainPanel.setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);

            JPanel welcomePanel = new JPanel();
            welcomePanel.setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);

            Button createInvoiceButton = new Button(StringsEN.INVOICE_CREATE_BUTTON_ACTION.value,
                    new Font("K2D", Font.ITALIC, TextSizes.WELCOME_ACTION_BUTTONS_TEXT_SIZE.size),
                    DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color,
                    DarkThemeColors.VIOLET_PRIMARY_ACCENT_COLOR.color);
            createInvoiceButton.setBorder(null);
            welcomePanel.add(createInvoiceButton);

            JScrollPane welcomePanelScrollPane = new JScrollPane(welcomePanel);
            welcomePanelScrollPane.setBorder(null);

            mainPanel.add(welcomePanelScrollPane, "WELCOME_PANEL");
            mainPanel.add(new InvoicePanel(), "INVOICE_PANEL");

            window.add(fileManager, BorderLayout.WEST);
            window.add(mainPanel, BorderLayout.CENTER);

            createInvoiceButton.addActionListener((e) -> mainPanelCardLayout.show(mainPanel, "INVOICE_PANEL"));

            window.setVisible(true);
        };

        Thread mainWindowThread = new Thread(mainWindowRunnable);
        mainWindowThread.start();
    }

}