package com.artiomastashonak.schoolaccountingstudio;

import com.artiomastashonak.schoolaccountingstudio.discount.DiscountPresentValueDialog;
import com.artiomastashonak.schoolaccountingstudio.interests.InterestTotAmountDialog;
import com.artiomastashonak.schoolaccountingstudio.invoice.InvoicePanel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainWindow {

    public static Locale LOCALE = Locale.ENGLISH;
    public static ResourceBundle BUNDLE = ResourceBundle.getBundle("strings/strings", LOCALE);

    public static void main(String[] args) {
        Window window = new Window(new ImageIcon(), BUNDLE);
        MenuBar menuBar = new MenuBar(BUNDLE);
        window.setJMenuBar(menuBar);

        menuBar.toolsInterestCalcItem.addActionListener((e) -> new InterestTotAmountDialog(BUNDLE));
        menuBar.toolsDiscountCalcItem.addActionListener((e) -> new DiscountPresentValueDialog(BUNDLE));

        CardLayout cardLayout = new CardLayout();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(cardLayout);

        InvoicePanel invoicePanel = new InvoicePanel(BUNDLE);
        JScrollPane invoice = new JScrollPane(invoicePanel);
        invoice.setBorder(null);

        mainPanel.add(invoice, "INVOICE");

        cardLayout.show(mainPanel, "INVOICE");

        window.add(mainPanel, BorderLayout.CENTER);

        window.setVisible(true);
    }

}