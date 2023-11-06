package com.artiomastashonak.schoolaccountingstudio.invoice;

import com.artiomastashonak.schoolaccountingstudio.*;
import org.jetbrains.annotations.NotNull;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Insets;

public class InvoicePanel extends JTabbedPane {

    private final Font sectionTitleFont = new  Font("K2D", Font.BOLD, TextSizes.SECTION_TITLE_TEXT_SIZE.size);
    private final Font subsectionTitleFont = new Font("K2D", Font.BOLD, TextSizes.SUBSECTION_TITLE_TEXT_SIZE.size);
    private final Font elementTitleFont = new Font("K2D", Font.PLAIN, TextSizes.ELEMENT_TITLE_TEXT_SIZE.size);
    private final Font elementInputFont = new Font("K2D", Font.PLAIN, TextSizes.BUTTON_TEXT_SIZE.size);

    public InvoicePanel() {
        setOpaque(true);
        Insets insets = UIManager.getInsets("TabbedPane.contentBorderInsets");
        insets.top = -1;
        insets.bottom = -1;
        insets.left = -1;
        insets.right = -1;
        UIManager.put("TabbedPane.contentBorderInsets", insets);

        setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
        setForeground(DarkThemeColors.PRIMARY_TEXT_COLOR.color);
        addTab(StringsEN.INVOICE_INFORMATION_TITLE.value, initInvoiceInformationTab());
        addTab(StringsEN.INVOICE_ITEMS_TITLE.value, initInvoiceItemsTab());
        addTab(StringsEN.INVOICE_COSTS_TITLE.value, initInvoiceCostsTab());
    }

    private @NotNull JScrollPane initInvoiceInformationTab() {
        JPanel invoiceInfoPanel = new JPanel();
        invoiceInfoPanel.setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
        invoiceInfoPanel.setLayout(new GridLayout(13, 1));

        JPanel sellerCustomer = new JPanel();
        sellerCustomer.setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
        sellerCustomer.setLayout(new GridLayout(1, 2, 50, 0));

        JPanel sellerPanel = new JPanel();
        sellerPanel.setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
        sellerPanel.setLayout(new GridLayout(2, 1));

        JPanel sellerTitlePanel = new JPanel();
        sellerTitlePanel.setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
        sellerTitlePanel.setLayout(new GridLayout(1, 3, 100, 0));

        Button importSellerButton = new Button(StringsEN.BUTTON_IMPORT_ACTION.value,
                elementInputFont,
                DarkThemeColors.BUTTON_BACKGROUND_COLOR.color,
                DarkThemeColors.PRIMARY_TEXT_COLOR.color);
        Button addSellerButton = new Button(StringsEN.BUTTON_ADD_ACTION.value,
                elementInputFont,
                DarkThemeColors.BUTTON_BACKGROUND_COLOR.color,
                DarkThemeColors.PRIMARY_TEXT_COLOR.color);

        sellerTitlePanel.add(new Label(StringsEN.INVOICE_SELLER_TITLE.value,
                new Font("K2D", Font.BOLD, TextSizes.WELCOME_ACTION_BUTTONS_TEXT_SIZE.size),
                DarkThemeColors.TERTIARY_TEXT_COLOR.color,
                DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color));
        sellerTitlePanel.add(importSellerButton);
        sellerTitlePanel.add(addSellerButton);

        Table sellerTable = new Table(DarkThemeColors.MENU_BAR_BACKGROUND_COLOR.color,
                DarkThemeColors.SECONDARY_TEXT_COLOR.color,
                elementInputFont);

        sellerPanel.add(sellerTitlePanel);
        sellerPanel.add(sellerTable);

        JPanel customerPanel = new JPanel();
        customerPanel.setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
        customerPanel.setLayout(new GridLayout(2, 1));

        JPanel customerTitlePanel = new JPanel();
        customerTitlePanel.setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
        customerTitlePanel.setLayout(new GridLayout(1, 3, 100, 0));

        Button importCustomerButton = new Button(StringsEN.BUTTON_IMPORT_ACTION.value,
                elementInputFont,
                DarkThemeColors.BUTTON_BACKGROUND_COLOR.color,
                DarkThemeColors.PRIMARY_TEXT_COLOR.color);
        Button addCustomerButton = new Button(StringsEN.BUTTON_ADD_ACTION.value,
                elementInputFont,
                DarkThemeColors.BUTTON_BACKGROUND_COLOR.color,
                DarkThemeColors.PRIMARY_TEXT_COLOR.color);

        customerTitlePanel.add(new Label(StringsEN.INVOICE_CUSTOMER_TITLE.value,
                new Font("K2D", Font.BOLD,  TextSizes.WELCOME_ACTION_BUTTONS_TEXT_SIZE.size),
                DarkThemeColors.TERTIARY_TEXT_COLOR.color,
                DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color));
        customerTitlePanel.add(importCustomerButton);
        customerTitlePanel.add(addCustomerButton);

        Table customerTable = new Table(DarkThemeColors.MENU_BAR_BACKGROUND_COLOR.color,
                DarkThemeColors.SECONDARY_TEXT_COLOR.color,
                elementInputFont);

        customerPanel.add(customerTitlePanel);
        customerPanel.add(customerTable);

        sellerCustomer.add(sellerPanel);
        sellerCustomer.add(customerPanel);

        JPanel invoiceInfo = new JPanel();
        invoiceInfo.setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
        invoiceInfo.setLayout(new GridLayout(1, 4, 75, 0));

        JPanel invoiceNumberPanel = new JPanel();
        invoiceNumberPanel.setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
        invoiceNumberPanel.setLayout(new BorderLayout());

        TextField invoiceNumberTextField = new TextField(DarkThemeColors.MENU_BAR_BACKGROUND_COLOR.color,
                DarkThemeColors.PRIMARY_TEXT_COLOR.color,
                elementInputFont);

        invoiceNumberPanel.add(new Label(StringsEN.INVOICE_NUMBER_TITLE.value,
                elementTitleFont,
                DarkThemeColors.PRIMARY_TEXT_COLOR.color,
                DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color),
                BorderLayout.NORTH);
        invoiceNumberPanel.add(invoiceNumberTextField, BorderLayout.SOUTH);

        JPanel invoiceEmissionDatePanel = new JPanel();
        invoiceEmissionDatePanel.setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
        invoiceEmissionDatePanel.setLayout(new BorderLayout());

        TextField emissionDateTextField = new TextField(DarkThemeColors.MENU_BAR_BACKGROUND_COLOR.color,
                DarkThemeColors.PRIMARY_TEXT_COLOR.color,
                elementInputFont);

        invoiceEmissionDatePanel.add(new Label(StringsEN.INVOICE_EMISSION_DATE_TITLE.value,
                elementTitleFont,
                DarkThemeColors.PRIMARY_TEXT_COLOR.color,
                DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color),
                BorderLayout.NORTH);
        invoiceEmissionDatePanel.add(emissionDateTextField, BorderLayout.SOUTH);

        JPanel invoiceExpireDatePanel = new JPanel();
        invoiceExpireDatePanel.setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
        invoiceExpireDatePanel.setLayout(new BorderLayout());

        TextField expireDateTextField = new TextField(DarkThemeColors.MENU_BAR_BACKGROUND_COLOR.color,
                DarkThemeColors.PRIMARY_TEXT_COLOR.color,
                elementInputFont);

        invoiceExpireDatePanel.add(new Label(StringsEN.INVOICE_EXPIRE_DATE_TITLE.value,
                elementTitleFont,
                DarkThemeColors.PRIMARY_TEXT_COLOR.color,
                DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color),
                BorderLayout.NORTH);
        invoiceExpireDatePanel.add(expireDateTextField, BorderLayout.SOUTH);

        JPanel invoiceTypePanel = new JPanel();
        invoiceTypePanel.setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
        invoiceTypePanel.setLayout(new BorderLayout());

        String[] invoiceTypeComboItems = {"Immediate", "Deferred"};
        JComboBox<String> invoiceTypeComboBox = new JComboBox<>(invoiceTypeComboItems);
        invoiceTypeComboBox.setBackground(DarkThemeColors.MENU_BAR_BACKGROUND_COLOR.color);
        invoiceTypeComboBox.setForeground(DarkThemeColors.PRIMARY_TEXT_COLOR.color);
        invoiceTypeComboBox.setFont(elementInputFont);

        invoiceTypePanel.add(new Label(StringsEN.INVOICE_TYPE_TITLE.value,
                elementTitleFont,
                DarkThemeColors.PRIMARY_TEXT_COLOR.color,
                DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color),
                BorderLayout.NORTH);
        invoiceTypePanel.add(invoiceTypeComboBox, BorderLayout.SOUTH);

        invoiceInfo.add(invoiceNumberPanel);
        invoiceInfo.add(invoiceEmissionDatePanel);
        invoiceInfo.add(invoiceExpireDatePanel);
        invoiceInfo.add(invoiceTypePanel);

        JPanel invoiceDelivery = new JPanel();
        invoiceDelivery.setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
        invoiceDelivery.setLayout(new GridLayout(1, 2, 75, 0));

        JPanel deliveryTypePanel = new JPanel();
        deliveryTypePanel.setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
        deliveryTypePanel.setLayout(new BorderLayout());

        String[] deliveryTypesComboItems = {"Ex works", "Delivered duty paid"};
        JComboBox<String> deliveryTypeComboBox = new JComboBox<>(deliveryTypesComboItems);
        deliveryTypeComboBox.setBackground(DarkThemeColors.MENU_BAR_BACKGROUND_COLOR.color);
        deliveryTypeComboBox.setForeground(DarkThemeColors.PRIMARY_TEXT_COLOR.color);
        deliveryTypeComboBox.setFont(elementInputFont);

        deliveryTypePanel.add(new Label(StringsEN.INVOICE_DELIVERY_TYPE_TITLE.value,
                elementTitleFont,
                DarkThemeColors.PRIMARY_TEXT_COLOR.color,
                DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color),
                BorderLayout.NORTH);
        deliveryTypePanel.add(deliveryTypeComboBox, BorderLayout.SOUTH);

        JPanel deliveryDatePanel = new JPanel();
        deliveryDatePanel.setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
        deliveryDatePanel.setLayout(new BorderLayout());

        TextField deliveryDateTextField = new TextField(DarkThemeColors.MENU_BAR_BACKGROUND_COLOR.color,
                DarkThemeColors.PRIMARY_TEXT_COLOR.color,
                elementInputFont);

        deliveryDatePanel.add(new Label(StringsEN.INVOICE_DELIVERY_DATE_TITLE.value,
                elementTitleFont,
                DarkThemeColors.PRIMARY_TEXT_COLOR.color,
                DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color),
                BorderLayout.NORTH);
        deliveryDatePanel.add(deliveryDateTextField, BorderLayout.SOUTH);

        invoiceDelivery.add(deliveryTypePanel);
        invoiceDelivery.add(deliveryDatePanel);

        JPanel invoiceTransport = new JPanel();
        invoiceTransport.setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
        invoiceTransport.setLayout(new GridLayout(1, 3, 75, 0));

        JPanel transportTypePanel = new JPanel();
        transportTypePanel.setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
        transportTypePanel.setLayout(new BorderLayout());

        String[] transportTypeComboItems = {"Our mean", "Your mean", "Carrier"};
        JComboBox<String> transportTypeComboBox = new JComboBox<>(transportTypeComboItems);
        transportTypeComboBox.setBackground(DarkThemeColors.MENU_BAR_BACKGROUND_COLOR.color);
        transportTypeComboBox.setForeground(DarkThemeColors.PRIMARY_TEXT_COLOR.color);
        transportTypeComboBox.setFont(elementInputFont);

        transportTypePanel.add(new Label(StringsEN.INVOICE_TRANSPORT_TYPE_TITLE.value,
                elementTitleFont,
                DarkThemeColors.PRIMARY_TEXT_COLOR.color,
                DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color),
                BorderLayout.NORTH);
        transportTypePanel.add(transportTypeComboBox, BorderLayout.SOUTH);

        JPanel transportAdditionalInfoPanel = new JPanel();
        transportAdditionalInfoPanel.setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
        transportAdditionalInfoPanel.setLayout(new BorderLayout());

        TextField transportAdditionalInfoPanelTextField = new TextField(DarkThemeColors.MENU_BAR_BACKGROUND_COLOR.color,
                DarkThemeColors.PRIMARY_TEXT_COLOR.color,
                elementInputFont);

        transportAdditionalInfoPanel.add(new Label(StringsEN.INVOICE_TRANSPORT_ADDITIONAL_INFO_TITLE.value,
                elementTitleFont,
                DarkThemeColors.PRIMARY_TEXT_COLOR.color,
                DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color),
                BorderLayout.NORTH);
        transportAdditionalInfoPanel.add(transportAdditionalInfoPanelTextField, BorderLayout.SOUTH);

        invoiceTransport.add(transportTypePanel);
        invoiceTransport.add(transportAdditionalInfoPanel);

        JPanel invoicePackaging = new JPanel();
        invoicePackaging.setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
        invoicePackaging.setLayout(new BorderLayout());

        JPanel packagingTypePanel = new JPanel();
        packagingTypePanel.setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
        packagingTypePanel.setLayout(new BorderLayout());

        String[] packagingTypeComboItems = {"Free", "Billed", "Returnable"};
        JComboBox<String> packagingTypeComboBox = new JComboBox<>(packagingTypeComboItems);
        packagingTypeComboBox.setBackground(DarkThemeColors.MENU_BAR_BACKGROUND_COLOR.color);
        packagingTypeComboBox.setForeground(DarkThemeColors.PRIMARY_TEXT_COLOR.color);
        packagingTypeComboBox.setFont(elementInputFont);

        packagingTypePanel.add(new Label(StringsEN.INVOICE_PACKAGING_TYPE_TITLE.value,
                elementTitleFont,
                DarkThemeColors.PRIMARY_TEXT_COLOR.color,
                DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color),
                BorderLayout.NORTH);
        packagingTypePanel.add(packagingTypeComboBox, BorderLayout.SOUTH);

        invoicePackaging.add(packagingTypePanel);

        JPanel invoicePayment = new JPanel();
        invoicePayment.setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
        invoicePayment.setLayout(new GridLayout(1, 4, 75, 0));

        JPanel paymentTypePanel = new JPanel();
        paymentTypePanel.setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
        paymentTypePanel.setLayout(new BorderLayout());

        String[] paymentTypeComboItems = {"In advance", "On delivery", "Prompt", "Deferred"};
        JComboBox<String> paymentTypeComboBox = new JComboBox<>(paymentTypeComboItems);
        paymentTypeComboBox.setBackground(DarkThemeColors.MENU_BAR_BACKGROUND_COLOR.color);
        paymentTypeComboBox.setForeground(DarkThemeColors.PRIMARY_TEXT_COLOR.color);
        paymentTypeComboBox.setFont(elementInputFont);

        paymentTypePanel.add(new Label(StringsEN.INVOICE_PAYMENT_TYPE_TITLE.value,
                elementTitleFont,
                DarkThemeColors.PRIMARY_TEXT_COLOR.color,
                DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color),
                BorderLayout.NORTH);
        paymentTypePanel.add(paymentTypeComboBox, BorderLayout.SOUTH);

        JPanel paymentMethodPanel = new JPanel();
        paymentMethodPanel.setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
        paymentMethodPanel.setLayout(new BorderLayout());

        String[] paymentMethodComboItems = {"Non specified", "Bank receipt", "Promissory note", "On delivery"};
        JComboBox<String> paymentMethodComboBox = new JComboBox<>(paymentMethodComboItems);
        paymentMethodComboBox.setBackground(DarkThemeColors.MENU_BAR_BACKGROUND_COLOR.color);
        paymentMethodComboBox.setForeground(DarkThemeColors.PRIMARY_TEXT_COLOR.color);
        paymentMethodComboBox.setFont(elementInputFont);

        paymentMethodPanel.add(new Label(StringsEN.INVOICE_PAYMENT_METHOD_TITLE.value,
                elementTitleFont,
                DarkThemeColors.PRIMARY_TEXT_COLOR.color,
                DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color),
                BorderLayout.NORTH);
        paymentMethodPanel.add(paymentMethodComboBox, BorderLayout.SOUTH);

        invoicePayment.add(paymentTypePanel);
        invoicePayment.add(paymentMethodPanel);

        invoiceInfoPanel.add(new Label(StringsEN.INVOICE_INFORMATION_TITLE.value,
                sectionTitleFont,
                DarkThemeColors.PRIMARY_TEXT_COLOR.color,
                DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color));
        invoiceInfoPanel.add(new Label(StringsEN.INVOICE_SELLER_AND_CUSTOMER_TITLE.value,
                subsectionTitleFont,
                DarkThemeColors.BUTTON_BACKGROUND_COLOR.color,
                DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color));
        invoiceInfoPanel.add(sellerCustomer);
        invoiceInfoPanel.add(new Label(StringsEN.INVOICE_INVOICE_TITLE.value,
                subsectionTitleFont,
                DarkThemeColors.BUTTON_BACKGROUND_COLOR.color,
                DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color));
        invoiceInfoPanel.add(invoiceInfo);
        invoiceInfoPanel.add(new Label(StringsEN.INVOICE_DELIVERY_TITLE.value,
                subsectionTitleFont,
                DarkThemeColors.BUTTON_BACKGROUND_COLOR.color,
                DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color));
        invoiceInfoPanel.add(invoiceDelivery);
        invoiceInfoPanel.add(new Label(StringsEN.INVOICE_TRANSPORT_TITLE.value,
                subsectionTitleFont,
                DarkThemeColors.BUTTON_BACKGROUND_COLOR.color,
                DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color));
        invoiceInfoPanel.add(invoiceTransport);
        invoiceInfoPanel.add(new Label(StringsEN.INVOICE_PACKAGING_TITLE.value,
                subsectionTitleFont,
                DarkThemeColors.BUTTON_BACKGROUND_COLOR.color,
                DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color));
        invoiceInfoPanel.add(invoicePackaging);
        invoiceInfoPanel.add(new Label(StringsEN.INVOICE_PAYMENT_TITLE.value,
                subsectionTitleFont,
                DarkThemeColors.BUTTON_BACKGROUND_COLOR.color,
                DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color));
        invoiceInfoPanel.add(invoicePayment);

        JScrollPane scrollInvoiceInfoPane = new JScrollPane(invoiceInfoPanel);
        scrollInvoiceInfoPane.getVerticalScrollBar().setUnitIncrement(10);

        return scrollInvoiceInfoPane;
    }

    private @NotNull JScrollPane initInvoiceItemsTab() {
        JPanel invoiceItemsPanel = new JPanel();
        invoiceItemsPanel.setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
        invoiceItemsPanel.setLayout(new BorderLayout());

        JPanel tableAndNavigation = new JPanel();
        tableAndNavigation.setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
        tableAndNavigation.setLayout(new BorderLayout());

        Table itemsTable = new Table(DarkThemeColors.MENU_BAR_BACKGROUND_COLOR.color,
                DarkThemeColors.TERTIARY_TEXT_COLOR.color,
                elementInputFont);

        JPanel tableControlButtons = new JPanel();
        tableControlButtons.setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
        tableControlButtons.setLayout(new GridLayout(3, 1, 0, 100));

        Button addItemButton = new Button(StringsEN.BUTTON_ADD_ACTION.value,
                elementInputFont,
                DarkThemeColors.BUTTON_BACKGROUND_COLOR.color,
                DarkThemeColors.PRIMARY_TEXT_COLOR.color);
        Button editItemButton = new Button(StringsEN.BUTTON_EDIT_ACTION.value,
                elementInputFont,
                DarkThemeColors.BUTTON_BACKGROUND_COLOR.color,
                DarkThemeColors.PRIMARY_TEXT_COLOR.color);
        Button deleteItemButton = new Button(StringsEN.BUTTON_DELETE_ACTION.value,
                elementInputFont,
                DarkThemeColors.DANGER_COLOR.color,
                DarkThemeColors.PRIMARY_TEXT_COLOR.color);

        tableControlButtons.add(addItemButton);
        tableControlButtons.add(editItemButton);
        tableControlButtons.add(deleteItemButton);

        tableAndNavigation.add(itemsTable, BorderLayout.CENTER);
        tableAndNavigation.add(tableControlButtons, BorderLayout.EAST);

        invoiceItemsPanel.add(new Label(StringsEN.INVOICE_ITEMS_TITLE.value,
                sectionTitleFont,
                DarkThemeColors.PRIMARY_TEXT_COLOR.color,
                DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color),
                BorderLayout.NORTH);
        invoiceItemsPanel.add(tableAndNavigation, BorderLayout.CENTER);

        JScrollPane scrollInvoiceItemsPane = new JScrollPane(invoiceItemsPanel);
        scrollInvoiceItemsPane.getVerticalScrollBar().setUnitIncrement(10);

        return scrollInvoiceItemsPane;
    }

    private @NotNull JScrollPane initInvoiceCostsTab() {
        JPanel invoiceCostsPanel = new JPanel();
        invoiceCostsPanel.setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
        invoiceCostsPanel.setLayout(new GridLayout(8, 1));

        JPanel packagingCost = new JPanel();
        packagingCost.setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
        packagingCost.setLayout(new GridLayout(1, 2, 100, 0));

        JPanel billedPackagingCostPanel = new JPanel();
        billedPackagingCostPanel.setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
        billedPackagingCostPanel.setLayout(new BorderLayout());

        TextField billedPackagingTextField = new TextField(DarkThemeColors.MENU_BAR_BACKGROUND_COLOR.color,
                DarkThemeColors.PRIMARY_TEXT_COLOR.color,
                elementInputFont);

        billedPackagingCostPanel.add(new Label(StringsEN.INVOICE_BILLED_PACKAGING_COST_TITLE.value,
                elementTitleFont,
                DarkThemeColors.PRIMARY_TEXT_COLOR.color,
                DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color),
                BorderLayout.NORTH);
        billedPackagingCostPanel.add(billedPackagingTextField, BorderLayout.SOUTH);

        JPanel bailedPackagingCostPanel = new JPanel();
        bailedPackagingCostPanel.setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
        bailedPackagingCostPanel.setLayout(new BorderLayout());

        TextField bailedPackagingCostTextField = new TextField(DarkThemeColors.MENU_BAR_BACKGROUND_COLOR.color,
                DarkThemeColors.PRIMARY_TEXT_COLOR.color,
                elementInputFont);

        bailedPackagingCostPanel.add(new Label(StringsEN.INVOICE_BAILED_PACKAGING_COST_TITLE.value,
                elementTitleFont,
                DarkThemeColors.PRIMARY_TEXT_COLOR.color,
                DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color),
                BorderLayout.NORTH);
        bailedPackagingCostPanel.add(bailedPackagingCostTextField, BorderLayout.SOUTH);

        packagingCost.add(billedPackagingCostPanel);
        packagingCost.add(bailedPackagingCostPanel);

        JPanel documentedCosts = new JPanel();
        documentedCosts.setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
        documentedCosts.setLayout(new GridLayout(1, 2, 100, 0));

        JPanel nonDocumentedCostPanel = new JPanel();
        nonDocumentedCostPanel.setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
        nonDocumentedCostPanel.setLayout(new BorderLayout());

        TextField nonDocumentedCostTextField = new TextField(DarkThemeColors.MENU_BAR_BACKGROUND_COLOR.color,
                DarkThemeColors.PRIMARY_TEXT_COLOR.color,
                elementInputFont);

        nonDocumentedCostPanel.add(new Label(StringsEN.INVOICE_NON_DOCUMENTED_COST_TITLE.value,
                elementTitleFont,
                DarkThemeColors.PRIMARY_TEXT_COLOR.color,
                DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color),
                BorderLayout.NORTH);
        nonDocumentedCostPanel.add(nonDocumentedCostTextField, BorderLayout.SOUTH);

        JPanel documentedCostPanel = new JPanel();
        documentedCostPanel.setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
        documentedCostPanel.setLayout(new BorderLayout());

        TextField documentedCostTextField = new TextField(DarkThemeColors.MENU_BAR_BACKGROUND_COLOR.color,
                DarkThemeColors.PRIMARY_TEXT_COLOR.color,
                elementInputFont);

        documentedCostPanel.add(new Label(StringsEN.INVOICE_DOCUMENTED_COSTS_TITLE.value,
                elementTitleFont,
                DarkThemeColors.PRIMARY_TEXT_COLOR.color,
                DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color),
                BorderLayout.NORTH);
        documentedCostPanel.add(documentedCostTextField, BorderLayout.SOUTH);

        documentedCosts.add(nonDocumentedCostPanel);
        documentedCosts.add(documentedCostPanel);

        JPanel interests = new JPanel();
        interests.setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
        interests.setLayout(new GridLayout(1, 1, 100, 0));

        JPanel interestValuePanel = new JPanel();
        interestValuePanel.setBackground(DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
        interestValuePanel.setLayout(new BorderLayout());

        TextField interestsTextField = new TextField(DarkThemeColors.MENU_BAR_BACKGROUND_COLOR.color,
                DarkThemeColors.PRIMARY_TEXT_COLOR.color,
                elementInputFont);

        interestValuePanel.add(new Label(StringsEN.INVOICE_INTEREST_TITLE.value,
                elementTitleFont,
                DarkThemeColors.PRIMARY_TEXT_COLOR.color,
                DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color),
                BorderLayout.NORTH);
        interestValuePanel.add(interestsTextField, BorderLayout.SOUTH);

        interests.add(interestValuePanel);

        invoiceCostsPanel.add(new Label(StringsEN.INVOICE_COSTS_TITLE.value,
                sectionTitleFont,
                DarkThemeColors.PRIMARY_TEXT_COLOR.color,
                DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color));
        invoiceCostsPanel.add(new Label(StringsEN.INVOICE_BILLED_PACKAGING_COST_TITLE.value,
                subsectionTitleFont,
                DarkThemeColors.BUTTON_BACKGROUND_COLOR.color,
                DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color));
        invoiceCostsPanel.add(packagingCost);
        invoiceCostsPanel.add(new Label(StringsEN.INVOICE_DOCUMENTED_COSTS_TITLE.value,
                subsectionTitleFont,
                DarkThemeColors.BUTTON_BACKGROUND_COLOR.color,
                DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color));
        invoiceCostsPanel.add(documentedCosts);
        invoiceCostsPanel.add(new Label(StringsEN.INVOICE_INTEREST_TITLE.value,
                subsectionTitleFont,
                DarkThemeColors.BUTTON_BACKGROUND_COLOR.color,
                DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color));
        invoiceCostsPanel.add(interests);

        JScrollPane scrollInvoiceCostsPane = new JScrollPane(invoiceCostsPanel);
        scrollInvoiceCostsPane.getVerticalScrollBar().setUnitIncrement(10);

        return scrollInvoiceCostsPane;
    }

}