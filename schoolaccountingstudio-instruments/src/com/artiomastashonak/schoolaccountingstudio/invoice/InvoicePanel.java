package com.artiomastashonak.schoolaccountingstudio.invoice;

import com.artiomastashonak.schoolaccountingstudio.Button;
import com.artiomastashonak.schoolaccountingstudio.Label;
import com.artiomastashonak.schoolaccountingstudio.Parameters;
import com.artiomastashonak.schoolaccountingstudio.TextField;
import com.artiomastashonak.schoolaccountingstudio.UIHelper;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public final class InvoicePanel extends JPanel {
  private final InvoiceHandler HANDLER = new InvoiceHandler();

  private final TextField SELLER_NAME = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
  private final TextField SELLER_ADDRESS = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
  private final TextField SELLER_PHONE = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
  private final TextField SELLER_EMAIL = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
  private final TextField SELLER_VAT_NUMBER = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
  private final TextField SELLER_REGISTER = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
  private final TextField SELLER_SHARED_CAPITAL = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());

  private final TextField CUSTOMER_NAME = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
  private final TextField CUSTOMER_ADDRESS = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
  private final TextField CUSTOMER_PHONE = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
  private final TextField CUSTOMER_EMAIL = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
  private final TextField CUSTOMER_VAT_NUMBER = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
  private final TextField CUSTOMER_REGISTER = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
  private final TextField CUSTOMER_SHARED_CAPITAL = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());

  private final TextField INVOICE_NUMBER = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
  private final TextField INVOICE_DATE = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
  private final TextField INVOICE_DELIVERY = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
  private final TextField INVOICE_TRANSPORT = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
  private final TextField INVOICE_PACKAGING = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
  private final TextField INVOICE_PAYMENT = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
  private final TextField INVOICE_NON_DOCUMENTED_COST = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
  private final TextField INVOICE_PACKAGING_COST = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
  private final TextField INVOICE_DOCUMENTED_COST = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
  private final TextField INVOICE_INTEREST = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
  private final TextField INVOICE_DEPOSIT = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());

  private final TextField MEASURE_UNIT;
  private final TextField QUANTITY;
  private final TextField CODE;
  private final TextField DESCRIPTION;
  private final TextField VAT;
  private final TextField UNIT_PRICE;
  private final TextField DISCOUNT_1;
  private final TextField DISCOUNT_2;

  private final DefaultTableModel TABLE_MODEL;

  public InvoicePanel() {
    setBackground(UIHelper.getMainWindowColor());
    SpringLayout layout = new SpringLayout();
    setLayout(layout);

    Label welcomeLabel = new Label(Parameters.getBundle().getString("invoiceGenerator"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getSectionTitleFont());
    add(welcomeLabel);
    layout.putConstraint(SpringLayout.WEST, welcomeLabel, 450, SpringLayout.WEST, this);

    Label sellerLabel = new Label(Parameters.getBundle().getString("seller"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    add(sellerLabel);
    layout.putConstraint(SpringLayout.NORTH, sellerLabel, 50, SpringLayout.SOUTH, welcomeLabel);
    layout.putConstraint(SpringLayout.WEST, sellerLabel, 200, SpringLayout.WEST, this);

    Button openSellerButton = new Button(Parameters.getBundle().getString("addSeller"), UIHelper.getBrightButtonColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
    add(openSellerButton);
    layout.putConstraint(SpringLayout.NORTH, openSellerButton, 10, SpringLayout.SOUTH, sellerLabel);
    layout.putConstraint(SpringLayout.WEST, openSellerButton, 0, SpringLayout.WEST, sellerLabel);
    openSellerButton.addActionListener(e -> showSellerDialog());

    Label customerLabel = new Label(Parameters.getBundle().getString("customer"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    add(customerLabel);
    layout.putConstraint(SpringLayout.NORTH, customerLabel, 50, SpringLayout.SOUTH, welcomeLabel);
    layout.putConstraint(SpringLayout.WEST, customerLabel, 250, SpringLayout.EAST, sellerLabel);

    Button openCustomerButton = new Button(Parameters.getBundle().getString("addCustomer"), UIHelper.getBrightButtonColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
    add(openCustomerButton);
    layout.putConstraint(SpringLayout.NORTH, openCustomerButton, 10, SpringLayout.SOUTH, customerLabel);
    layout.putConstraint(SpringLayout.EAST, openCustomerButton, 0, SpringLayout.EAST, customerLabel);
    openCustomerButton.addActionListener(e -> showCustomerDialog());

    Label invoiceInfoLabel = new Label(Parameters.getBundle().getString("invoiceInfo"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    add(invoiceInfoLabel);
    layout.putConstraint(SpringLayout.NORTH, invoiceInfoLabel, 15, SpringLayout.SOUTH, openSellerButton);
    layout.putConstraint(SpringLayout.WEST, invoiceInfoLabel, 0, SpringLayout.WEST, sellerLabel);

    Button openInvoiceInfoButton = new Button(Parameters.getBundle().getString("open"), UIHelper.getBrightButtonColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
    add(openInvoiceInfoButton);
    layout.putConstraint(SpringLayout.NORTH, openInvoiceInfoButton, 10, SpringLayout.SOUTH, invoiceInfoLabel);
    layout.putConstraint(SpringLayout.WEST, openInvoiceInfoButton, 0, SpringLayout.WEST, invoiceInfoLabel);
    openInvoiceInfoButton.addActionListener(e -> showInvoiceInfoDialog());

    MEASURE_UNIT = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
    MEASURE_UNIT.setColumns(6);
    add(MEASURE_UNIT);
    layout.putConstraint(SpringLayout.NORTH, MEASURE_UNIT, 25, SpringLayout.SOUTH, openInvoiceInfoButton);
    layout.putConstraint(SpringLayout.WEST, MEASURE_UNIT, 200, SpringLayout.WEST, this);

    QUANTITY = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
    QUANTITY.setColumns(6);
    add(QUANTITY);
    layout.putConstraint(SpringLayout.NORTH, QUANTITY, 25, SpringLayout.SOUTH, openInvoiceInfoButton);
    layout.putConstraint(SpringLayout.WEST, QUANTITY, 25, SpringLayout.EAST, MEASURE_UNIT);

    CODE = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
    CODE.setColumns(6);
    add(CODE);
    layout.putConstraint(SpringLayout.NORTH, CODE, 25, SpringLayout.SOUTH, openInvoiceInfoButton);
    layout.putConstraint(SpringLayout.WEST, CODE, 25, SpringLayout.EAST, QUANTITY);

    DESCRIPTION = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
    DESCRIPTION.setColumns(6);
    add(DESCRIPTION);
    layout.putConstraint(SpringLayout.NORTH, DESCRIPTION, 25, SpringLayout.SOUTH, openInvoiceInfoButton);
    layout.putConstraint(SpringLayout.WEST, DESCRIPTION, 25, SpringLayout.EAST, CODE);

    VAT = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
    VAT.setColumns(6);
    add(VAT);
    layout.putConstraint(SpringLayout.NORTH, VAT, 25, SpringLayout.SOUTH, openInvoiceInfoButton);
    layout.putConstraint(SpringLayout.WEST, VAT, 25, SpringLayout.EAST, DESCRIPTION);

    UNIT_PRICE = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
    UNIT_PRICE.setColumns(6);
    add(UNIT_PRICE);
    layout.putConstraint(SpringLayout.NORTH, UNIT_PRICE, 25, SpringLayout.SOUTH, openInvoiceInfoButton);
    layout.putConstraint(SpringLayout.WEST, UNIT_PRICE, 25, SpringLayout.EAST, VAT);

    DISCOUNT_1 = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
    DISCOUNT_1.setColumns(6);
    add(DISCOUNT_1);
    layout.putConstraint(SpringLayout.NORTH, DISCOUNT_1, 25, SpringLayout.SOUTH, openInvoiceInfoButton);
    layout.putConstraint(SpringLayout.WEST, DISCOUNT_1, 25, SpringLayout.EAST, UNIT_PRICE);

    DISCOUNT_2 = new TextField(UIHelper.getMenuBarColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
    DISCOUNT_2.setColumns(6);
    add(DISCOUNT_2);
    layout.putConstraint(SpringLayout.NORTH, DISCOUNT_2, 25, SpringLayout.SOUTH, openInvoiceInfoButton);
    layout.putConstraint(SpringLayout.WEST, DISCOUNT_2, 25, SpringLayout.EAST, DISCOUNT_1);

    Button addItemButton = new Button(Parameters.getBundle().getString("add"), UIHelper.getBrightButtonColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
    add(addItemButton);
    layout.putConstraint(SpringLayout.NORTH, addItemButton, 25, SpringLayout.SOUTH, DISCOUNT_2);
    layout.putConstraint(SpringLayout.EAST, addItemButton, 0, SpringLayout.EAST, DISCOUNT_2);
    addItemButton.addActionListener(e -> addItemAndClearInput());

    TABLE_MODEL = new DefaultTableModel();

    String[] columns = {Parameters.getBundle().getString("measureUnitShort"),
      Parameters.getBundle().getString("quantityShort"),
      Parameters.getBundle().getString("code"),
      Parameters.getBundle().getString("description"),
      Parameters.getBundle().getString("vat"),
      Parameters.getBundle().getString("unitPrice"),
      Parameters.getBundle().getString("discount1"),
      Parameters.getBundle().getString("discount2")};
    TABLE_MODEL.setColumnIdentifiers(columns);

    JTable INVOICE_TABLE = new JTable(TABLE_MODEL);
    JScrollPane tableScrollPane = new JScrollPane(INVOICE_TABLE);
    tableScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    tableScrollPane.setBorder(null);

    add(tableScrollPane);
    layout.putConstraint(SpringLayout.NORTH, tableScrollPane, 10, SpringLayout.SOUTH, addItemButton);
    layout.putConstraint(SpringLayout.WEST, tableScrollPane, 200, SpringLayout.WEST, this);
    layout.putConstraint(SpringLayout.EAST, tableScrollPane, 0, SpringLayout.EAST, addItemButton);

    Button printHTMLButton = new Button(Parameters.getBundle().getString("printHTML"), UIHelper.getBrightButtonColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
    add(printHTMLButton);
    layout.putConstraint(SpringLayout.NORTH, printHTMLButton, 10, SpringLayout.SOUTH, tableScrollPane);
    layout.putConstraint(SpringLayout.EAST, printHTMLButton, 0, SpringLayout.EAST, tableScrollPane);
    printHTMLButton.addActionListener(e -> {
      int result = HANDLER.printHTML();
      if (result == 0) {
        JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("invoicePrintedSuccessfully"));
      } else {
        JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("invoicePrintingError"));
      }
    });

    Button printXMLButton = new Button(Parameters.getBundle().getString("printXML"), UIHelper.getBrightButtonColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
    add(printXMLButton);
    layout.putConstraint(SpringLayout.NORTH, printXMLButton, 10, SpringLayout.SOUTH, tableScrollPane);
    layout.putConstraint(SpringLayout.EAST, printXMLButton, -10, SpringLayout.WEST, printHTMLButton);
    printXMLButton.addActionListener(e -> {
      int result = HANDLER.printXML();
      if (result == 0) {
        JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("invoicePrintedSuccessfully"));
      } else {
        JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("invoicePrintingError"));
      }
    });

    Button resetButton = new Button(Parameters.getBundle().getString("reset"), UIHelper.getBrightButtonColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
    add(resetButton);
    layout.putConstraint(SpringLayout.NORTH, resetButton, 10, SpringLayout.SOUTH, tableScrollPane);
    layout.putConstraint(SpringLayout.EAST, resetButton, -10, SpringLayout.WEST, printXMLButton);
    resetButton.addActionListener(e -> reset());
  }

  private void addItemAndClearInput() {
    for (TextField textField : new TextField[]{MEASURE_UNIT, QUANTITY, DESCRIPTION, VAT, UNIT_PRICE, DISCOUNT_1, DISCOUNT_2}) {
      if (textField.getText().isEmpty()) {
        JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("failedNewItem"));
        return;
      }
    }

    try {
      Integer.parseInt(QUANTITY.getText());
    } catch (Exception exception) {
      JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("quantityError"));
      return;
    }

    try {
      Integer.parseInt(VAT.getText());
    } catch (Exception exception) {
      JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("vatError"));
      return;
    }

    try {
      Double.parseDouble(UNIT_PRICE.getText());
    } catch (Exception exception) {
      JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("priceError"));
      return;
    }

    try {
      Double.parseDouble(DISCOUNT_1.getText());
    } catch (Exception exception) {
      JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("discountError"));
      return;
    }

    try {
      Double.parseDouble(DISCOUNT_2.getText());
    } catch (Exception exception) {
      JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("discountError"));
      return;
    }

    TABLE_MODEL.addRow(new Object[]{MEASURE_UNIT.getText(),
      QUANTITY.getText(),
      CODE.getText(),
      DESCRIPTION.getText(),
      VAT.getText(),
      UNIT_PRICE.getText(),
      DISCOUNT_1.getText(),
      DISCOUNT_2.getText()});

    HANDLER.addItem(new Item(MEASURE_UNIT.getText(),
      Integer.parseInt(QUANTITY.getText()),
      CODE.getText(),
      DESCRIPTION.getText(),
      Short.parseShort(VAT.getText()),
      Double.parseDouble(UNIT_PRICE.getText()),
      Float.parseFloat(DISCOUNT_1.getText()),
      Float.parseFloat(DISCOUNT_2.getText())));

    for (TextField textField : new TextField[]{MEASURE_UNIT, QUANTITY, CODE, DESCRIPTION, VAT, UNIT_PRICE, DISCOUNT_1, DISCOUNT_2}) {
      textField.setText("");
    }
  }

  private void reset() {
    for (TextField textField : new TextField[]{SELLER_NAME,
      SELLER_ADDRESS,
      SELLER_PHONE,
      SELLER_EMAIL,
      SELLER_VAT_NUMBER,
      SELLER_REGISTER,
      SELLER_SHARED_CAPITAL,
      CUSTOMER_NAME,
      CUSTOMER_ADDRESS,
      CUSTOMER_PHONE,
      CUSTOMER_EMAIL,
      CUSTOMER_VAT_NUMBER,
      CUSTOMER_REGISTER,
      CUSTOMER_SHARED_CAPITAL,
      INVOICE_NUMBER,
      INVOICE_DATE,
      INVOICE_DELIVERY,
      INVOICE_TRANSPORT,
      INVOICE_PACKAGING,
      INVOICE_PAYMENT,
      INVOICE_NON_DOCUMENTED_COST,
      INVOICE_PACKAGING_COST,
      INVOICE_DOCUMENTED_COST,
      INVOICE_INTEREST,
      INVOICE_DEPOSIT,
      MEASURE_UNIT,
      QUANTITY,
      CODE,
      DESCRIPTION,
      VAT,
      UNIT_PRICE,
      DISCOUNT_1,
      DISCOUNT_2}) {
      textField.setText("");
    }

    for (int row = 0; row < TABLE_MODEL.getRowCount(); row++) {
      TABLE_MODEL.removeRow(row);
    }

    HANDLER.reset();
  }

  private void showSellerDialog() {
    JDialog dialog = new JDialog();
    dialog.setTitle(Parameters.getBundle().getString("seller"));
    dialog.setModal(true);
    dialog.setSize(450, 400);
    dialog.setResizable(true);
    dialog.getContentPane().setBackground(UIHelper.getMainWindowColor());
    SpringLayout layout = new SpringLayout();
    dialog.setLayout(layout);

    Label sellerNameLabel = new Label(Parameters.getBundle().getString("name"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    dialog.add(sellerNameLabel);
    layout.putConstraint(SpringLayout.NORTH, sellerNameLabel, 5, SpringLayout.NORTH, dialog.getContentPane());
    layout.putConstraint(SpringLayout.WEST, sellerNameLabel, 5, SpringLayout.WEST, dialog.getContentPane());

    SELLER_NAME.setColumns(12);
    dialog.add(SELLER_NAME);
    layout.putConstraint(SpringLayout.SOUTH, SELLER_NAME, 0, SpringLayout.SOUTH, sellerNameLabel);
    layout.putConstraint(SpringLayout.EAST, SELLER_NAME, -10, SpringLayout.EAST, dialog.getContentPane());

    Label sellerAddressLabel = new Label(Parameters.getBundle().getString("address"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    dialog.add(sellerAddressLabel);
    layout.putConstraint(SpringLayout.NORTH, sellerAddressLabel, 5, SpringLayout.SOUTH, sellerNameLabel);
    layout.putConstraint(SpringLayout.WEST, sellerAddressLabel, 5, SpringLayout.WEST, dialog.getContentPane());

    SELLER_ADDRESS.setColumns(12);
    dialog.add(SELLER_ADDRESS);
    layout.putConstraint(SpringLayout.SOUTH, SELLER_ADDRESS, 0, SpringLayout.SOUTH, sellerAddressLabel);
    layout.putConstraint(SpringLayout.EAST, SELLER_ADDRESS, -10, SpringLayout.EAST, dialog.getContentPane());

    Label sellerPhoneLabel = new Label(Parameters.getBundle().getString("phone"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    dialog.add(sellerPhoneLabel);
    layout.putConstraint(SpringLayout.NORTH, sellerPhoneLabel, 5, SpringLayout.SOUTH, sellerAddressLabel);
    layout.putConstraint(SpringLayout.WEST, sellerPhoneLabel, 5, SpringLayout.WEST, dialog.getContentPane());

    SELLER_PHONE.setColumns(12);
    dialog.add(SELLER_PHONE);
    layout.putConstraint(SpringLayout.SOUTH, SELLER_PHONE, 0, SpringLayout.SOUTH, sellerPhoneLabel);
    layout.putConstraint(SpringLayout.EAST, SELLER_PHONE, -10, SpringLayout.EAST, dialog.getContentPane());

    Label sellerEmailLabel = new Label(Parameters.getBundle().getString("email"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    dialog.add(sellerEmailLabel);
    layout.putConstraint(SpringLayout.NORTH, sellerEmailLabel, 5, SpringLayout.SOUTH, sellerPhoneLabel);
    layout.putConstraint(SpringLayout.WEST, sellerEmailLabel, 5, SpringLayout.WEST, dialog.getContentPane());

    SELLER_EMAIL.setColumns(12);
    dialog.add(SELLER_EMAIL);
    layout.putConstraint(SpringLayout.SOUTH, SELLER_EMAIL, 0, SpringLayout.SOUTH, sellerEmailLabel);
    layout.putConstraint(SpringLayout.EAST, SELLER_EMAIL, -10, SpringLayout.EAST, dialog.getContentPane());

    Label sellerVatNumberLabel = new Label(Parameters.getBundle().getString("vat"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    dialog.add(sellerVatNumberLabel);
    layout.putConstraint(SpringLayout.NORTH, sellerVatNumberLabel, 5, SpringLayout.SOUTH, sellerEmailLabel);
    layout.putConstraint(SpringLayout.WEST, sellerVatNumberLabel, 5, SpringLayout.WEST, dialog.getContentPane());

    SELLER_VAT_NUMBER.setColumns(12);
    dialog.add(SELLER_VAT_NUMBER);
    layout.putConstraint(SpringLayout.SOUTH, SELLER_VAT_NUMBER, 0, SpringLayout.SOUTH, sellerVatNumberLabel);
    layout.putConstraint(SpringLayout.EAST, SELLER_VAT_NUMBER, -10, SpringLayout.EAST, dialog.getContentPane());

    Label sellerRegisterLabel = new Label(Parameters.getBundle().getString("register"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    dialog.add(sellerRegisterLabel);
    layout.putConstraint(SpringLayout.NORTH, sellerRegisterLabel, 5, SpringLayout.SOUTH, sellerVatNumberLabel);
    layout.putConstraint(SpringLayout.WEST, sellerRegisterLabel, 5, SpringLayout.WEST, dialog.getContentPane());

    SELLER_REGISTER.setColumns(12);
    dialog.add(SELLER_REGISTER);
    layout.putConstraint(SpringLayout.SOUTH, SELLER_REGISTER, 0, SpringLayout.SOUTH, sellerRegisterLabel);
    layout.putConstraint(SpringLayout.EAST, SELLER_REGISTER, -10, SpringLayout.EAST, dialog.getContentPane());

    Label sellerCapitalLabel = new Label(Parameters.getBundle().getString("capital"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    dialog.add(sellerCapitalLabel);
    layout.putConstraint(SpringLayout.NORTH, sellerCapitalLabel, 5, SpringLayout.SOUTH, sellerRegisterLabel);
    layout.putConstraint(SpringLayout.WEST, sellerCapitalLabel, 5, SpringLayout.WEST, dialog.getContentPane());

    SELLER_SHARED_CAPITAL.setColumns(12);
    dialog.add(SELLER_SHARED_CAPITAL);
    layout.putConstraint(SpringLayout.SOUTH, SELLER_SHARED_CAPITAL, 0, SpringLayout.SOUTH, sellerCapitalLabel);
    layout.putConstraint(SpringLayout.EAST, SELLER_SHARED_CAPITAL, -10, SpringLayout.EAST, dialog.getContentPane());

    Button submitSellerButton = new Button(Parameters.getBundle().getString("submit"), UIHelper.getBrightButtonColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
    dialog.add(submitSellerButton);
    layout.putConstraint(SpringLayout.NORTH, submitSellerButton, 5, SpringLayout.SOUTH, SELLER_SHARED_CAPITAL);
    layout.putConstraint(SpringLayout.EAST, submitSellerButton, -10, SpringLayout.EAST, dialog.getContentPane());
    submitSellerButton.addActionListener(e -> {
      submitSeller();
      dialog.dispose();
    });

    dialog.show();
  }

  private void submitSeller() {
    for (TextField textField : new TextField[]{SELLER_NAME,
      SELLER_ADDRESS,
      SELLER_PHONE,
      SELLER_EMAIL,
      SELLER_VAT_NUMBER,
      SELLER_REGISTER,
      SELLER_SHARED_CAPITAL}) {
      if (textField.getText().isEmpty()) {
        JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("sellerError"));
        return;
      }
    }

    HANDLER.setSeller(new String[]{SELLER_NAME.getText(),
      SELLER_ADDRESS.getText(),
      SELLER_PHONE.getText(),
      SELLER_EMAIL.getText(),
      SELLER_VAT_NUMBER.getText(),
      SELLER_REGISTER.getText(),
      SELLER_SHARED_CAPITAL.getText()});
  }

  private void showCustomerDialog() {
    JDialog dialog = new JDialog();
    dialog.setTitle(Parameters.getBundle().getString("customer"));
    dialog.setModal(true);
    dialog.setSize(450, 400);
    dialog.setResizable(true);
    dialog.getContentPane().setBackground(UIHelper.getMainWindowColor());
    SpringLayout layout = new SpringLayout();
    dialog.setLayout(layout);

    Label customerNameLabel = new Label(Parameters.getBundle().getString("name"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    dialog.add(customerNameLabel);
    layout.putConstraint(SpringLayout.NORTH, customerNameLabel, 5, SpringLayout.NORTH, dialog.getContentPane());
    layout.putConstraint(SpringLayout.WEST, customerNameLabel, 5, SpringLayout.WEST, dialog.getContentPane());

    CUSTOMER_NAME.setColumns(12);
    dialog.add(CUSTOMER_NAME);
    layout.putConstraint(SpringLayout.SOUTH, CUSTOMER_NAME, 0, SpringLayout.SOUTH, customerNameLabel);
    layout.putConstraint(SpringLayout.EAST, CUSTOMER_NAME, -10, SpringLayout.EAST, dialog.getContentPane());

    Label customerAddressLabel = new Label(Parameters.getBundle().getString("address"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    dialog.add(customerAddressLabel);
    layout.putConstraint(SpringLayout.NORTH, customerAddressLabel, 5, SpringLayout.SOUTH, customerNameLabel);
    layout.putConstraint(SpringLayout.WEST, customerAddressLabel, 5, SpringLayout.WEST, dialog.getContentPane());

    CUSTOMER_ADDRESS.setColumns(12);
    dialog.add(CUSTOMER_ADDRESS);
    layout.putConstraint(SpringLayout.SOUTH, CUSTOMER_ADDRESS, 0, SpringLayout.SOUTH, customerAddressLabel);
    layout.putConstraint(SpringLayout.EAST, CUSTOMER_ADDRESS, -10, SpringLayout.EAST, dialog.getContentPane());

    Label customerPhoneLabel = new Label(Parameters.getBundle().getString("phone"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    dialog.add(customerPhoneLabel);
    layout.putConstraint(SpringLayout.NORTH, customerPhoneLabel, 5, SpringLayout.SOUTH, customerAddressLabel);
    layout.putConstraint(SpringLayout.WEST, customerPhoneLabel, 5, SpringLayout.WEST, dialog.getContentPane());

    CUSTOMER_PHONE.setColumns(12);
    dialog.add(CUSTOMER_PHONE);
    layout.putConstraint(SpringLayout.SOUTH, CUSTOMER_PHONE, 0, SpringLayout.SOUTH, customerPhoneLabel);
    layout.putConstraint(SpringLayout.EAST, CUSTOMER_PHONE, -10, SpringLayout.EAST, dialog.getContentPane());

    Label customerEmailLabel = new Label(Parameters.getBundle().getString("email"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    dialog.add(customerEmailLabel);
    layout.putConstraint(SpringLayout.NORTH, customerEmailLabel, 5, SpringLayout.SOUTH, customerPhoneLabel);
    layout.putConstraint(SpringLayout.WEST, customerEmailLabel, 5, SpringLayout.WEST, dialog.getContentPane());

    CUSTOMER_EMAIL.setColumns(12);
    dialog.add(CUSTOMER_EMAIL);
    layout.putConstraint(SpringLayout.SOUTH, CUSTOMER_EMAIL, 0, SpringLayout.SOUTH, customerEmailLabel);
    layout.putConstraint(SpringLayout.EAST, CUSTOMER_EMAIL, -10, SpringLayout.EAST, dialog.getContentPane());

    Label customerVatNumberLabel = new Label(Parameters.getBundle().getString("vat"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    dialog.add(customerVatNumberLabel);
    layout.putConstraint(SpringLayout.NORTH, customerVatNumberLabel, 5, SpringLayout.SOUTH, customerEmailLabel);
    layout.putConstraint(SpringLayout.WEST, customerVatNumberLabel, 5, SpringLayout.WEST, dialog.getContentPane());

    CUSTOMER_VAT_NUMBER.setColumns(12);
    dialog.add(CUSTOMER_VAT_NUMBER);
    layout.putConstraint(SpringLayout.SOUTH, CUSTOMER_VAT_NUMBER, 0, SpringLayout.SOUTH, customerVatNumberLabel);
    layout.putConstraint(SpringLayout.EAST, CUSTOMER_VAT_NUMBER, -10, SpringLayout.EAST, dialog.getContentPane());

    Label customerRegisterLabel = new Label(Parameters.getBundle().getString("register"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    dialog.add(customerRegisterLabel);
    layout.putConstraint(SpringLayout.NORTH, customerRegisterLabel, 5, SpringLayout.SOUTH, customerVatNumberLabel);
    layout.putConstraint(SpringLayout.WEST, customerRegisterLabel, 5, SpringLayout.WEST, dialog.getContentPane());

    CUSTOMER_REGISTER.setColumns(12);
    dialog.add(CUSTOMER_REGISTER);
    layout.putConstraint(SpringLayout.SOUTH, CUSTOMER_REGISTER, 0, SpringLayout.SOUTH, customerRegisterLabel);
    layout.putConstraint(SpringLayout.EAST, CUSTOMER_REGISTER, -10, SpringLayout.EAST, dialog.getContentPane());

    Label customerCapitalLabel = new Label(Parameters.getBundle().getString("capital"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    dialog.add(customerCapitalLabel);
    layout.putConstraint(SpringLayout.NORTH, customerCapitalLabel, 5, SpringLayout.SOUTH, customerRegisterLabel);
    layout.putConstraint(SpringLayout.WEST, customerCapitalLabel, 5, SpringLayout.WEST, dialog.getContentPane());

    CUSTOMER_SHARED_CAPITAL.setColumns(12);
    dialog.add(CUSTOMER_SHARED_CAPITAL);
    layout.putConstraint(SpringLayout.SOUTH, CUSTOMER_SHARED_CAPITAL, 0, SpringLayout.SOUTH, customerCapitalLabel);
    layout.putConstraint(SpringLayout.EAST, CUSTOMER_SHARED_CAPITAL, -10, SpringLayout.EAST, dialog.getContentPane());

    Button submitCustomerButton = new Button(Parameters.getBundle().getString("submit"), UIHelper.getBrightButtonColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
    dialog.add(submitCustomerButton);
    layout.putConstraint(SpringLayout.NORTH, submitCustomerButton, 5, SpringLayout.SOUTH, CUSTOMER_SHARED_CAPITAL);
    layout.putConstraint(SpringLayout.EAST, submitCustomerButton, -10, SpringLayout.EAST, dialog.getContentPane());
    submitCustomerButton.addActionListener(e -> {
      submitCustomer();
      dialog.dispose();
    });

    dialog.show();
  }

  private void submitCustomer() {
    for (TextField textField : new TextField[]{CUSTOMER_NAME,
      CUSTOMER_ADDRESS,
      CUSTOMER_PHONE,
      CUSTOMER_EMAIL,
      CUSTOMER_VAT_NUMBER,
      CUSTOMER_REGISTER,
      CUSTOMER_SHARED_CAPITAL}) {
      if (textField.getText().isEmpty()) {
        JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("customerError"));
        return;
      }
    }

    HANDLER.setCustomer(new String[]{CUSTOMER_NAME.getText(),
      CUSTOMER_ADDRESS.getText(),
      CUSTOMER_PHONE.getText(),
      CUSTOMER_EMAIL.getText(),
      CUSTOMER_VAT_NUMBER.getText(),
      CUSTOMER_REGISTER.getText(),
      CUSTOMER_SHARED_CAPITAL.getText()});
  }

  private void showInvoiceInfoDialog() {
    JDialog dialog = new JDialog();
    dialog.setTitle(Parameters.getBundle().getString("invoice"));
    dialog.setModal(true);
    dialog.setSize(725, 300);
    dialog.setResizable(false);
    dialog.getContentPane().setBackground(UIHelper.getMainWindowColor());
    SpringLayout layout = new SpringLayout();
    dialog.setLayout(layout);

    Label invoiceNumberLabel = new Label(Parameters.getBundle().getString("documentNumber"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    dialog.add(invoiceNumberLabel);
    layout.putConstraint(SpringLayout.NORTH, invoiceNumberLabel, 5, SpringLayout.NORTH, dialog.getContentPane());
    layout.putConstraint(SpringLayout.WEST, invoiceNumberLabel, 5, SpringLayout.WEST, dialog.getContentPane());

    INVOICE_NUMBER.setColumns(12);
    dialog.add(INVOICE_NUMBER);
    layout.putConstraint(SpringLayout.NORTH, INVOICE_NUMBER, 5, SpringLayout.SOUTH, invoiceNumberLabel);
    layout.putConstraint(SpringLayout.WEST, INVOICE_NUMBER, 5, SpringLayout.WEST, dialog.getContentPane());

    Label invoiceDateLabel = new Label(Parameters.getBundle().getString("documentDate"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    dialog.add(invoiceDateLabel);
    layout.putConstraint(SpringLayout.NORTH, invoiceDateLabel, 5, SpringLayout.NORTH, dialog.getContentPane());
    layout.putConstraint(SpringLayout.WEST, invoiceDateLabel, 5, SpringLayout.EAST, INVOICE_NUMBER);

    INVOICE_DATE.setColumns(12);
    dialog.add(INVOICE_DATE);
    layout.putConstraint(SpringLayout.NORTH, INVOICE_DATE, 5, SpringLayout.SOUTH, invoiceDateLabel);
    layout.putConstraint(SpringLayout.WEST, INVOICE_DATE, 5, SpringLayout.EAST, INVOICE_NUMBER);

    Label invoiceDeliveryLabel = new Label(Parameters.getBundle().getString("delivery"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    dialog.add(invoiceDeliveryLabel);
    layout.putConstraint(SpringLayout.NORTH, invoiceDeliveryLabel, 5, SpringLayout.NORTH, dialog.getContentPane());
    layout.putConstraint(SpringLayout.WEST, invoiceDeliveryLabel, 5, SpringLayout.EAST, INVOICE_DATE);

    INVOICE_DELIVERY.setColumns(12);
    dialog.add(INVOICE_DELIVERY);
    layout.putConstraint(SpringLayout.NORTH, INVOICE_DELIVERY, 5, SpringLayout.SOUTH, invoiceDeliveryLabel);
    layout.putConstraint(SpringLayout.WEST, INVOICE_DELIVERY, 5, SpringLayout.EAST, INVOICE_DATE);

    Label invoiceTransportLabel = new Label(Parameters.getBundle().getString("transport"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    dialog.add(invoiceTransportLabel);
    layout.putConstraint(SpringLayout.NORTH, invoiceTransportLabel, 5, SpringLayout.NORTH, dialog.getContentPane());
    layout.putConstraint(SpringLayout.WEST, invoiceTransportLabel, 5, SpringLayout.EAST, INVOICE_DELIVERY);

    INVOICE_TRANSPORT.setColumns(12);
    dialog.add(INVOICE_TRANSPORT);
    layout.putConstraint(SpringLayout.NORTH, INVOICE_TRANSPORT, 5, SpringLayout.SOUTH, invoiceTransportLabel);
    layout.putConstraint(SpringLayout.WEST, INVOICE_TRANSPORT, 5, SpringLayout.EAST, INVOICE_DELIVERY);

    Label invoicePackagingLabel = new Label(Parameters.getBundle().getString("packaging"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    dialog.add(invoicePackagingLabel);
    layout.putConstraint(SpringLayout.NORTH, invoicePackagingLabel, 5, SpringLayout.SOUTH, INVOICE_NUMBER);
    layout.putConstraint(SpringLayout.WEST, invoicePackagingLabel, 5, SpringLayout.WEST, dialog.getContentPane());

    INVOICE_PACKAGING.setColumns(12);
    dialog.add(INVOICE_PACKAGING);
    layout.putConstraint(SpringLayout.NORTH, INVOICE_PACKAGING, 5, SpringLayout.SOUTH, invoicePackagingLabel);
    layout.putConstraint(SpringLayout.WEST, INVOICE_PACKAGING, 5, SpringLayout.WEST, dialog.getContentPane());

    Label invoicePaymentLabel = new Label(Parameters.getBundle().getString("payment"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    dialog.add(invoicePaymentLabel);
    layout.putConstraint(SpringLayout.NORTH, invoicePaymentLabel, 5, SpringLayout.SOUTH, INVOICE_DATE);
    layout.putConstraint(SpringLayout.WEST, invoicePaymentLabel, 5, SpringLayout.EAST, INVOICE_PACKAGING);

    INVOICE_PAYMENT.setColumns(12);
    dialog.add(INVOICE_PAYMENT);
    layout.putConstraint(SpringLayout.NORTH, INVOICE_PAYMENT, 5, SpringLayout.SOUTH, invoicePaymentLabel);
    layout.putConstraint(SpringLayout.WEST, INVOICE_PAYMENT, 5, SpringLayout.EAST, INVOICE_PACKAGING);

    Label invoiceNonDocumentedCostLabel = new Label(Parameters.getBundle().getString("nonDocumentedCost"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    dialog.add(invoiceNonDocumentedCostLabel);
    layout.putConstraint(SpringLayout.NORTH, invoiceNonDocumentedCostLabel, 5, SpringLayout.SOUTH, INVOICE_TRANSPORT);
    layout.putConstraint(SpringLayout.WEST, invoiceNonDocumentedCostLabel, 5, SpringLayout.EAST, INVOICE_PAYMENT);

    INVOICE_NON_DOCUMENTED_COST.setColumns(12);
    dialog.add(INVOICE_NON_DOCUMENTED_COST);
    layout.putConstraint(SpringLayout.NORTH, INVOICE_NON_DOCUMENTED_COST, 5, SpringLayout.SOUTH, invoiceNonDocumentedCostLabel);
    layout.putConstraint(SpringLayout.WEST, INVOICE_NON_DOCUMENTED_COST, 5, SpringLayout.EAST, INVOICE_PAYMENT);

    Label invoicePackagingCostLabel = new Label(Parameters.getBundle().getString("packaging"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    dialog.add(invoicePackagingCostLabel);
    layout.putConstraint(SpringLayout.NORTH, invoicePackagingCostLabel, 5, SpringLayout.SOUTH, INVOICE_TRANSPORT);
    layout.putConstraint(SpringLayout.WEST, invoicePackagingCostLabel,5, SpringLayout.EAST, INVOICE_NON_DOCUMENTED_COST);

    INVOICE_PACKAGING_COST.setColumns(12);
    dialog.add(INVOICE_PACKAGING_COST);
    layout.putConstraint(SpringLayout.NORTH, INVOICE_PACKAGING_COST, 5, SpringLayout.SOUTH, invoicePackagingCostLabel);
    layout.putConstraint(SpringLayout.WEST, INVOICE_PACKAGING_COST, 5, SpringLayout.EAST, INVOICE_NON_DOCUMENTED_COST);

    Label invoiceDocumentedCostLabel = new Label(Parameters.getBundle().getString("documentedCost"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    dialog.add(invoiceDocumentedCostLabel);
    layout.putConstraint(SpringLayout.NORTH, invoiceDocumentedCostLabel, 5, SpringLayout.SOUTH, INVOICE_PACKAGING);
    layout.putConstraint(SpringLayout.WEST, invoiceDocumentedCostLabel, 5, SpringLayout.WEST, dialog.getContentPane());

    INVOICE_DOCUMENTED_COST.setColumns(12);
    dialog.add(INVOICE_DOCUMENTED_COST);
    layout.putConstraint(SpringLayout.NORTH, INVOICE_DOCUMENTED_COST, 5, SpringLayout.SOUTH, invoiceDocumentedCostLabel);
    layout.putConstraint(SpringLayout.WEST, INVOICE_DOCUMENTED_COST, 5, SpringLayout.WEST, dialog.getContentPane());

    Label invoiceInterestLabel = new Label(Parameters.getBundle().getString("interest"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    dialog.add(invoiceInterestLabel);
    layout.putConstraint(SpringLayout.NORTH, invoiceInterestLabel, 5, SpringLayout.SOUTH, INVOICE_PAYMENT);
    layout.putConstraint(SpringLayout.WEST, invoiceInterestLabel, 5, SpringLayout.EAST, INVOICE_DOCUMENTED_COST);

    INVOICE_INTEREST.setColumns(12);
    dialog.add(INVOICE_INTEREST);
    layout.putConstraint(SpringLayout.NORTH, INVOICE_INTEREST, 5, SpringLayout.SOUTH, invoiceInterestLabel);
    layout.putConstraint(SpringLayout.WEST, INVOICE_INTEREST, 5, SpringLayout.EAST, INVOICE_DOCUMENTED_COST);

    Label invoiceDepositLabel = new Label(Parameters.getBundle().getString("deposit"), UIHelper.getMainWindowColor(), UIHelper.getPrimaryTextColor(), UIHelper.getElementTitleFont());
    dialog.add(invoiceDepositLabel);
    layout.putConstraint(SpringLayout.NORTH, invoiceDepositLabel, 5, SpringLayout.SOUTH, INVOICE_NON_DOCUMENTED_COST);
    layout.putConstraint(SpringLayout.WEST, invoiceDepositLabel, 5, SpringLayout.EAST, INVOICE_INTEREST);

    INVOICE_DEPOSIT.setColumns(12);
    dialog.add(INVOICE_DEPOSIT);
    layout.putConstraint(SpringLayout.NORTH, INVOICE_DEPOSIT, 5, SpringLayout.SOUTH, invoiceDepositLabel);
    layout.putConstraint(SpringLayout.WEST, INVOICE_DEPOSIT, 5, SpringLayout.EAST, INVOICE_INTEREST);

    Button submitInvoiceInfo = new Button(Parameters.getBundle().getString("submit"), UIHelper.getBrightButtonColor(), UIHelper.getPrimaryTextColor(), UIHelper.getInputFont());
    dialog.add(submitInvoiceInfo);
    layout.putConstraint(SpringLayout.SOUTH, submitInvoiceInfo, 5, SpringLayout.SOUTH, INVOICE_DEPOSIT);
    layout.putConstraint(SpringLayout.EAST, submitInvoiceInfo, 5, SpringLayout.EAST, INVOICE_PACKAGING_COST);
    submitInvoiceInfo.addActionListener(e -> {
      submitInvoice();
      dialog.dispose();
    });

    dialog.show();
  }

  private void submitInvoice() {
    for (TextField textField : new TextField[]{INVOICE_NUMBER,
      INVOICE_DATE,
      INVOICE_DELIVERY,
      INVOICE_TRANSPORT,
      INVOICE_PACKAGING,
      INVOICE_PAYMENT,
      INVOICE_NON_DOCUMENTED_COST,
      INVOICE_PACKAGING_COST,
      INVOICE_DOCUMENTED_COST,
      INVOICE_INTEREST,
      INVOICE_DEPOSIT}) {
      if (textField.getText().isEmpty()) {
        JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("invoiceError"));
        return;
      }
    }

    try {
      HANDLER.setNonDocumentedCost(Double.parseDouble(INVOICE_NON_DOCUMENTED_COST.getText()));
    } catch (Exception exception) {
      JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("nonDocumentedCostError"));
      return;
    }

    try {
      HANDLER.setPackagingCost(Double.parseDouble(INVOICE_PACKAGING_COST.getText()));
    } catch (Exception exception) {
      JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("packagingError"));
      return;
    }

    try {
      HANDLER.setDocumentedCost(Double.parseDouble(INVOICE_DOCUMENTED_COST.getText()));
    } catch (Exception exception) {
      JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("documentedCostError"));
      return;
    }

    try {
      HANDLER.setInterests(Double.parseDouble(INVOICE_INTEREST.getText()));
    } catch (Exception exception) {
      JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("interestError"));
      return;
    }

    try {
      HANDLER.setDeposit(Double.parseDouble(INVOICE_DEPOSIT.getText()));
    } catch (Exception exception) {
      JOptionPane.showInternalMessageDialog(null, Parameters.getBundle().getString("depositError"));
      return;
    }

    HANDLER.setInvoice(new String[]{INVOICE_NUMBER.getText(),
      INVOICE_DATE.getText(),
      INVOICE_DELIVERY.getText(),
      INVOICE_TRANSPORT.getText(),
      INVOICE_PACKAGING.getText(),
      INVOICE_PAYMENT.getText()});
  }
}