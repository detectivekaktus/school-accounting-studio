package com.artiomastashonak.schoolaccountingstudio;

import com.artiomastashonak.schoolaccountingstudio.invoice.InvoicePanel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainWindow {

    public static Locale LOCALE = Locale.ENGLISH;
    public static ResourceBundle BUNDLE = ResourceBundle.getBundle("strings/strings", LOCALE);

    public static void main(String[] args) {
        Window window = new Window(new ImageIcon(), BUNDLE);

        CardLayout cardLayout = new CardLayout();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(cardLayout);

        mainPanel.add(new InvoicePanel(BUNDLE), "INVOICE");

        cardLayout.show(mainPanel, "INVOICE");

        window.add(mainPanel, BorderLayout.CENTER);

        window.setVisible(true);
    }

}