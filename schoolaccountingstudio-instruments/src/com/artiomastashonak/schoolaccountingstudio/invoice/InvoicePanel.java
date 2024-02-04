package com.artiomastashonak.schoolaccountingstudio.invoice;

import com.artiomastashonak.schoolaccountingstudio.Button;
import com.artiomastashonak.schoolaccountingstudio.DarkThemeColors;
import com.artiomastashonak.schoolaccountingstudio.Label;
import com.artiomastashonak.schoolaccountingstudio.TextField;
import com.artiomastashonak.schoolaccountingstudio.TextSizes;
import org.jetbrains.annotations.NotNull;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.util.Objects;
import java.util.ResourceBundle;

public final class InvoicePanel extends JPanel {
  private final ResourceBundle BUNDLE;
  private final InvoiceHandler HANDLER = new InvoiceHandler();

  private final Color MAIN_WINDOW_COLOR = DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color;
  private final Color TEXT_INPUT_COLOR = DarkThemeColors.MENU_BAR_BACKGROUND_COLOR.color;
  private final Color BUTTON_COLOR = DarkThemeColors.BUTTON_BACKGROUND_COLOR.color;
  private final Color TEXT_COLOR = DarkThemeColors.PRIMARY_TEXT_COLOR.color;
  private final Font ELEMENT_TITLE_FONT = new Font("sans-serif", Font.BOLD, TextSizes.ELEMENT_TITLE_TEXT_SIZE.size);
  private final Font INPUT_FONT = new Font("sans-serif", Font.PLAIN, TextSizes.BUTTON_TEXT_SIZE.size);

  private final TextField SELLER_NAME = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
  private final TextField SELLER_ADDRESS = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
  private final TextField SELLER_PHONE = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
  private final TextField SELLER_EMAIL = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
  private final TextField SELLER_VAT_NUMBER = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
  private final TextField SELLER_REGISTER = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
  private final TextField SELLER_SHARED_CAPITAL = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);

  private final TextField CUSTOMER_NAME = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
  private final TextField CUSTOMER_ADDRESS = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
  private final TextField CUSTOMER_PHONE = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
  private final TextField CUSTOMER_EMAIL = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
  private final TextField CUSTOMER_VAT_NUMBER = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
  private final TextField CUSTOMER_REGISTER = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
  private final TextField CUSTOMER_SHARED_CAPITAL = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);

  private final TextField INVOICE_NUMBER = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
  private final TextField INVOICE_DATE = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
  private final TextField INVOICE_DELIVERY = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
  private final TextField INVOICE_TRANSPORT = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
  private final TextField INVOICE_PACKAGING = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
  private final TextField INVOICE_PAYMENT = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
  private final TextField INVOICE_NON_DOCUMENTED_COST = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
  private final TextField INVOICE_PACKAGING_COST = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
  private final TextField INVOICE_DOCUMENTED_COST = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
  private final TextField INVOICE_INTEREST = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
  private final TextField INVOICE_DEPOSIT = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);

  private final TextField MEASURE_UNIT;
  private final TextField QUANTITY;
  private final TextField CODE;
  private final TextField DESCRIPTION;
  private final TextField VAT;
  private final TextField UNIT_PRICE;
  private final TextField DISCOUNT_1;
  private final TextField DISCOUNT_2;

  private final DefaultTableModel TABLE_MODEL;

  public InvoicePanel(@NotNull ResourceBundle bundle) {
    this.BUNDLE = bundle;

    setBackground(MAIN_WINDOW_COLOR);
    SpringLayout layout = new SpringLayout();
    setLayout(layout);

    Label welcomeLabel = new Label(bundle.getString("invoiceGenerator"), MAIN_WINDOW_COLOR, TEXT_COLOR, new Font("sans-serif", Font.BOLD, TextSizes.SUBSECTION_TITLE_TEXT_SIZE.size));
    add(welcomeLabel);
    layout.putConstraint(SpringLayout.WEST, welcomeLabel, 450, SpringLayout.WEST, this);

    Label sellerLabel = new Label(bundle.getString("seller"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    add(sellerLabel);
    layout.putConstraint(SpringLayout.NORTH, sellerLabel, 50, SpringLayout.SOUTH, welcomeLabel);
    layout.putConstraint(SpringLayout.WEST, sellerLabel, 200, SpringLayout.WEST, this);

    Button openSellerButton = new Button(bundle.getString("addSeller"), BUTTON_COLOR, TEXT_COLOR, INPUT_FONT);
    add(openSellerButton);
    layout.putConstraint(SpringLayout.NORTH, openSellerButton, 10, SpringLayout.SOUTH, sellerLabel);
    layout.putConstraint(SpringLayout.WEST, openSellerButton, 0, SpringLayout.WEST, sellerLabel);
    openSellerButton.addActionListener((e) -> showSellerDialog());

    Label customerLabel = new Label(bundle.getString("customer"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    add(customerLabel);
    layout.putConstraint(SpringLayout.NORTH, customerLabel, 50, SpringLayout.SOUTH, welcomeLabel);
    layout.putConstraint(SpringLayout.WEST, customerLabel, 250, SpringLayout.EAST, sellerLabel);

    Button openCustomerButton = new Button(bundle.getString("addCustomer"), BUTTON_COLOR, TEXT_COLOR, INPUT_FONT);
    add(openCustomerButton);
    layout.putConstraint(SpringLayout.NORTH, openCustomerButton, 10, SpringLayout.SOUTH, customerLabel);
    layout.putConstraint(SpringLayout.EAST, openCustomerButton, 0, SpringLayout.EAST, customerLabel);
    openCustomerButton.addActionListener((e) -> showCustomerDialog());

    Label invoiceInfoLabel = new Label(bundle.getString("invoiceInfo"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    add(invoiceInfoLabel);
    layout.putConstraint(SpringLayout.NORTH, invoiceInfoLabel, 15, SpringLayout.SOUTH, openSellerButton);
    layout.putConstraint(SpringLayout.WEST, invoiceInfoLabel, 0, SpringLayout.WEST, sellerLabel);

    Button openInvoiceInfoButton = new Button(bundle.getString("open"), BUTTON_COLOR, TEXT_COLOR, INPUT_FONT);
    add(openInvoiceInfoButton);
    layout.putConstraint(SpringLayout.NORTH, openInvoiceInfoButton, 10, SpringLayout.SOUTH, invoiceInfoLabel);
    layout.putConstraint(SpringLayout.WEST, openInvoiceInfoButton, 0, SpringLayout.WEST, invoiceInfoLabel);
    openInvoiceInfoButton.addActionListener((e) -> showInvoiceInfoDialog());

    MEASURE_UNIT = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
    MEASURE_UNIT.setColumns(6);
    add(MEASURE_UNIT);
    layout.putConstraint(SpringLayout.NORTH, MEASURE_UNIT, 25, SpringLayout.SOUTH, openInvoiceInfoButton);
    layout.putConstraint(SpringLayout.WEST, MEASURE_UNIT, 200, SpringLayout.WEST, this);

    QUANTITY = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
    QUANTITY.setColumns(6);
    add(QUANTITY);
    layout.putConstraint(SpringLayout.NORTH, QUANTITY, 25, SpringLayout.SOUTH, openInvoiceInfoButton);
    layout.putConstraint(SpringLayout.WEST, QUANTITY, 25, SpringLayout.EAST, MEASURE_UNIT);

    CODE = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
    CODE.setColumns(6);
    add(CODE);
    layout.putConstraint(SpringLayout.NORTH, CODE, 25, SpringLayout.SOUTH, openInvoiceInfoButton);
    layout.putConstraint(SpringLayout.WEST, CODE, 25, SpringLayout.EAST, QUANTITY);

    DESCRIPTION = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
    DESCRIPTION.setColumns(6);
    add(DESCRIPTION);
    layout.putConstraint(SpringLayout.NORTH, DESCRIPTION, 25, SpringLayout.SOUTH, openInvoiceInfoButton);
    layout.putConstraint(SpringLayout.WEST, DESCRIPTION, 25, SpringLayout.EAST, CODE);

    VAT = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
    VAT.setColumns(6);
    add(VAT);
    layout.putConstraint(SpringLayout.NORTH, VAT, 25, SpringLayout.SOUTH, openInvoiceInfoButton);
    layout.putConstraint(SpringLayout.WEST, VAT, 25, SpringLayout.EAST, DESCRIPTION);

    UNIT_PRICE = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
    UNIT_PRICE.setColumns(6);
    add(UNIT_PRICE);
    layout.putConstraint(SpringLayout.NORTH, UNIT_PRICE, 25, SpringLayout.SOUTH, openInvoiceInfoButton);
    layout.putConstraint(SpringLayout.WEST, UNIT_PRICE, 25, SpringLayout.EAST, VAT);

    DISCOUNT_1 = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
    DISCOUNT_1.setColumns(6);
    add(DISCOUNT_1);
    layout.putConstraint(SpringLayout.NORTH, DISCOUNT_1, 25, SpringLayout.SOUTH, openInvoiceInfoButton);
    layout.putConstraint(SpringLayout.WEST, DISCOUNT_1, 25, SpringLayout.EAST, UNIT_PRICE);

    DISCOUNT_2 = new TextField(TEXT_INPUT_COLOR, TEXT_COLOR, INPUT_FONT);
    DISCOUNT_2.setColumns(6);
    add(DISCOUNT_2);
    layout.putConstraint(SpringLayout.NORTH, DISCOUNT_2, 25, SpringLayout.SOUTH, openInvoiceInfoButton);
    layout.putConstraint(SpringLayout.WEST, DISCOUNT_2, 25, SpringLayout.EAST, DISCOUNT_1);

    Button addItemButton = new Button(bundle.getString("add"), BUTTON_COLOR, TEXT_COLOR, INPUT_FONT);
    add(addItemButton);
    layout.putConstraint(SpringLayout.NORTH, addItemButton, 25, SpringLayout.SOUTH, DISCOUNT_2);
    layout.putConstraint(SpringLayout.EAST, addItemButton, 0, SpringLayout.EAST, DISCOUNT_2);
    addItemButton.addActionListener((e) -> addItemAndClearInput());

    TABLE_MODEL = new DefaultTableModel();

    String[] columns = {bundle.getString("measureUnitShort"),
      bundle.getString("quantityShort"),
      bundle.getString("code"),
      bundle.getString("description"),
      bundle.getString("vat"),
      bundle.getString("unitPrice"),
      bundle.getString("discount1"),
      bundle.getString("discount2")};
    TABLE_MODEL.setColumnIdentifiers(columns);

    JTable INVOICE_TABLE = new JTable(TABLE_MODEL);
    JScrollPane tableScrollPane = new JScrollPane(INVOICE_TABLE);
    tableScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    tableScrollPane.setBorder(null);

    add(tableScrollPane);
    layout.putConstraint(SpringLayout.NORTH, tableScrollPane, 10, SpringLayout.SOUTH, addItemButton);
    layout.putConstraint(SpringLayout.WEST, tableScrollPane, 200, SpringLayout.WEST, this);
    layout.putConstraint(SpringLayout.EAST, tableScrollPane, 0, SpringLayout.EAST, addItemButton);

    Button printHTMLButton = new Button(bundle.getString("printHTML"), BUTTON_COLOR, TEXT_COLOR, INPUT_FONT);
    add(printHTMLButton);
    layout.putConstraint(SpringLayout.NORTH, printHTMLButton, 10, SpringLayout.SOUTH, tableScrollPane);
    layout.putConstraint(SpringLayout.EAST, printHTMLButton, 0, SpringLayout.EAST, tableScrollPane);
    printHTMLButton.addActionListener((e) -> {
      int result = HANDLER.printHTML();
      if (result == 0) {
        JOptionPane.showInternalMessageDialog(null, bundle.getString("invoicePrintedSuccessfully"));
      } else {
        JOptionPane.showInternalMessageDialog(null, bundle.getString("invoicePrintingError"));
      }
    });

    Button printXMLButton = new Button(bundle.getString("printXML"), BUTTON_COLOR, TEXT_COLOR, INPUT_FONT);
    add(printXMLButton);
    layout.putConstraint(SpringLayout.NORTH, printXMLButton, 10, SpringLayout.SOUTH, tableScrollPane);
    layout.putConstraint(SpringLayout.EAST, printXMLButton, -10, SpringLayout.WEST, printHTMLButton);
    printXMLButton.addActionListener((e) -> {
      int result = HANDLER.printXML();
      if (result == 0) {
        JOptionPane.showInternalMessageDialog(null, bundle.getString("invoicePrintedSuccessfully"));
      } else {
        JOptionPane.showInternalMessageDialog(null, bundle.getString("invoicePrintingError"));
      }
    });

    Button resetButton = new Button(bundle.getString("reset"), BUTTON_COLOR, TEXT_COLOR, INPUT_FONT);
    add(resetButton);
    layout.putConstraint(SpringLayout.NORTH, resetButton, 10, SpringLayout.SOUTH, tableScrollPane);
    layout.putConstraint(SpringLayout.EAST, resetButton, -10, SpringLayout.WEST, printXMLButton);
    resetButton.addActionListener((e) -> reset());
  }

  private void addItemAndClearInput() {
    for (TextField textField : new TextField[]{MEASURE_UNIT, QUANTITY, DESCRIPTION, VAT, UNIT_PRICE, DISCOUNT_1, DISCOUNT_2}) {
      if (Objects.equals(textField.getText(), "")) {
        JOptionPane.showInternalMessageDialog(null, BUNDLE.getString("failedNewItem"));
        return;
      }
    }

    try {
      Integer.parseInt(QUANTITY.getText());
    } catch (Exception exception) {
      JOptionPane.showInternalMessageDialog(null, BUNDLE.getString("quantityError"));
      return;
    }

    try {
      Short.parseShort(VAT.getText());
    } catch (Exception exception) {
      JOptionPane.showInternalMessageDialog(null, BUNDLE.getString("vatError"));
      return;
    }

    try {
      Double.parseDouble(UNIT_PRICE.getText());
    } catch (Exception exception) {
      JOptionPane.showInternalMessageDialog(null, BUNDLE.getString("priceError"));
      return;
    }

    try {
      Float.parseFloat(DISCOUNT_1.getText());
    } catch (Exception exception) {
      JOptionPane.showInternalMessageDialog(null, BUNDLE.getString("discountError"));
      return;
    }

    try {
      Float.parseFloat(DISCOUNT_2.getText());
    } catch (Exception exception) {
      JOptionPane.showInternalMessageDialog(null, BUNDLE.getString("discountError"));
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
      SELLER_REGISTER,
      SELLER_SHARED_CAPITAL,
      CUSTOMER_NAME,
      CUSTOMER_ADDRESS,
      CUSTOMER_PHONE,
      CUSTOMER_EMAIL,
      CUSTOMER_REGISTER,
      CUSTOMER_SHARED_CAPITAL,
      INVOICE_NUMBER,
      INVOICE_DATE,
      INVOICE_DELIVERY,
      INVOICE_TRANSPORT,
      INVOICE_PACKAGING,
      INVOICE_PAYMENT,
      INVOICE_NON_DOCUMENTED_COST,
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
    JDialog sellerDialog = new JDialog();
    sellerDialog.setTitle(BUNDLE.getString("seller"));
    sellerDialog.setModal(true);
    sellerDialog.setSize(375, 400);
    sellerDialog.setResizable(false);
    sellerDialog.getContentPane().setBackground(MAIN_WINDOW_COLOR);
    SpringLayout layout = new SpringLayout();
    sellerDialog.setLayout(layout);

    Label sellerNameLabel = new Label(BUNDLE.getString("name"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    sellerDialog.add(sellerNameLabel);
    layout.putConstraint(SpringLayout.NORTH, sellerNameLabel, 5, SpringLayout.NORTH, sellerDialog);
    layout.putConstraint(SpringLayout.WEST, sellerNameLabel, 5, SpringLayout.WEST, sellerDialog);

    SELLER_NAME.setColumns(12);
    sellerDialog.add(SELLER_NAME);
    layout.putConstraint(SpringLayout.SOUTH, SELLER_NAME, 0, SpringLayout.SOUTH, sellerNameLabel);
    layout.putConstraint(SpringLayout.WEST, SELLER_NAME, 5, SpringLayout.EAST, sellerNameLabel);

    Label sellerAddressLabel = new Label(BUNDLE.getString("address"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    sellerDialog.add(sellerAddressLabel);
    layout.putConstraint(SpringLayout.NORTH, sellerAddressLabel, 5, SpringLayout.SOUTH, sellerNameLabel);
    layout.putConstraint(SpringLayout.WEST, sellerAddressLabel, 5, SpringLayout.WEST, sellerDialog);

    SELLER_ADDRESS.setColumns(12);
    sellerDialog.add(SELLER_ADDRESS);
    layout.putConstraint(SpringLayout.SOUTH, SELLER_ADDRESS, 0, SpringLayout.SOUTH, sellerAddressLabel);
    layout.putConstraint(SpringLayout.WEST, SELLER_ADDRESS, 5, SpringLayout.EAST, sellerAddressLabel);

    Label sellerPhoneLabel = new Label(BUNDLE.getString("phone"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    sellerDialog.add(sellerPhoneLabel);
    layout.putConstraint(SpringLayout.NORTH, sellerPhoneLabel, 5, SpringLayout.SOUTH, sellerAddressLabel);
    layout.putConstraint(SpringLayout.WEST, sellerPhoneLabel, 5, SpringLayout.WEST, sellerDialog);

    SELLER_PHONE.setColumns(12);
    sellerDialog.add(SELLER_PHONE);
    layout.putConstraint(SpringLayout.SOUTH, SELLER_PHONE, 0, SpringLayout.SOUTH, sellerPhoneLabel);
    layout.putConstraint(SpringLayout.WEST, SELLER_PHONE, 5, SpringLayout.EAST, sellerPhoneLabel);

    Label sellerEmailLabel = new Label(BUNDLE.getString("email"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    sellerDialog.add(sellerEmailLabel);
    layout.putConstraint(SpringLayout.NORTH, sellerEmailLabel, 5, SpringLayout.SOUTH, sellerPhoneLabel);
    layout.putConstraint(SpringLayout.WEST, sellerEmailLabel, 5, SpringLayout.WEST, sellerDialog);

    SELLER_EMAIL.setColumns(12);
    sellerDialog.add(SELLER_EMAIL);
    layout.putConstraint(SpringLayout.SOUTH, SELLER_EMAIL, 0, SpringLayout.SOUTH, sellerEmailLabel);
    layout.putConstraint(SpringLayout.WEST, SELLER_EMAIL, 5, SpringLayout.EAST, sellerEmailLabel);

    Label sellerVatNumberLabel = new Label(BUNDLE.getString("vat"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    sellerDialog.add(sellerVatNumberLabel);
    layout.putConstraint(SpringLayout.NORTH, sellerVatNumberLabel, 5, SpringLayout.SOUTH, sellerEmailLabel);
    layout.putConstraint(SpringLayout.WEST, sellerVatNumberLabel, 5, SpringLayout.WEST, sellerDialog);

    SELLER_VAT_NUMBER.setColumns(12);
    sellerDialog.add(SELLER_VAT_NUMBER);
    layout.putConstraint(SpringLayout.SOUTH, SELLER_VAT_NUMBER, 0, SpringLayout.SOUTH, sellerVatNumberLabel);
    layout.putConstraint(SpringLayout.WEST, SELLER_VAT_NUMBER, 5, SpringLayout.EAST, sellerVatNumberLabel);

    Label sellerRegisterLabel = new Label(BUNDLE.getString("register"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    sellerDialog.add(sellerRegisterLabel);
    layout.putConstraint(SpringLayout.NORTH, sellerRegisterLabel, 5, SpringLayout.SOUTH, sellerVatNumberLabel);
    layout.putConstraint(SpringLayout.WEST, sellerRegisterLabel, 5, SpringLayout.WEST, sellerDialog);

    SELLER_REGISTER.setColumns(12);
    sellerDialog.add(SELLER_REGISTER);
    layout.putConstraint(SpringLayout.SOUTH, SELLER_REGISTER, 0, SpringLayout.SOUTH, sellerRegisterLabel);
    layout.putConstraint(SpringLayout.WEST, SELLER_REGISTER, 5, SpringLayout.EAST, sellerRegisterLabel);

    Label sellerCapitalLabel = new Label(BUNDLE.getString("capital"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    sellerDialog.add(sellerCapitalLabel);
    layout.putConstraint(SpringLayout.NORTH, sellerCapitalLabel, 5, SpringLayout.SOUTH, sellerRegisterLabel);
    layout.putConstraint(SpringLayout.WEST, sellerCapitalLabel, 5, SpringLayout.WEST, sellerDialog);

    SELLER_SHARED_CAPITAL.setColumns(12);
    sellerDialog.add(SELLER_SHARED_CAPITAL);
    layout.putConstraint(SpringLayout.SOUTH, SELLER_SHARED_CAPITAL, 0, SpringLayout.SOUTH, sellerCapitalLabel);
    layout.putConstraint(SpringLayout.WEST, SELLER_SHARED_CAPITAL, 5, SpringLayout.EAST, sellerCapitalLabel);

    Button submitSellerButton = new Button(BUNDLE.getString("submit"), BUTTON_COLOR, TEXT_COLOR, INPUT_FONT);
    sellerDialog.add(submitSellerButton);
    layout.putConstraint(SpringLayout.NORTH, submitSellerButton, 5, SpringLayout.SOUTH, SELLER_SHARED_CAPITAL);
    layout.putConstraint(SpringLayout.EAST, submitSellerButton, 0, SpringLayout.EAST, SELLER_PHONE);
    submitSellerButton.addActionListener((e) -> submitSeller());

    sellerDialog.show();
  }

  private void submitSeller() {
    for (TextField textField : new TextField[]{SELLER_NAME,
      SELLER_ADDRESS,
      SELLER_PHONE,
      SELLER_EMAIL,
      SELLER_VAT_NUMBER,
      SELLER_REGISTER,
      SELLER_SHARED_CAPITAL}) {
      if (Objects.equals(textField.getText(), "")) {
        JOptionPane.showInternalMessageDialog(null, BUNDLE.getString("sellerError"));
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
    JDialog customerDialog = new JDialog();
    customerDialog.setTitle(BUNDLE.getString("customer"));
    customerDialog.setModal(true);
    customerDialog.setSize(375, 400);
    customerDialog.setResizable(false);
    customerDialog.getContentPane().setBackground(MAIN_WINDOW_COLOR);
    SpringLayout layout = new SpringLayout();
    customerDialog.setLayout(layout);

    Label customerNameLabel = new Label(BUNDLE.getString("name"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    customerDialog.add(customerNameLabel);
    layout.putConstraint(SpringLayout.NORTH, customerNameLabel, 5, SpringLayout.NORTH, customerDialog);
    layout.putConstraint(SpringLayout.WEST, customerNameLabel, 5, SpringLayout.WEST, customerDialog);

    CUSTOMER_NAME.setColumns(12);
    customerDialog.add(CUSTOMER_NAME);
    layout.putConstraint(SpringLayout.SOUTH, CUSTOMER_NAME, 0, SpringLayout.SOUTH, customerNameLabel);
    layout.putConstraint(SpringLayout.WEST, CUSTOMER_NAME, 5, SpringLayout.EAST, customerNameLabel);

    Label customerAddressLabel = new Label(BUNDLE.getString("address"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    customerDialog.add(customerAddressLabel);
    layout.putConstraint(SpringLayout.NORTH, customerAddressLabel, 5, SpringLayout.SOUTH, customerNameLabel);
    layout.putConstraint(SpringLayout.WEST, customerAddressLabel, 5, SpringLayout.WEST, customerDialog);

    CUSTOMER_ADDRESS.setColumns(12);
    customerDialog.add(CUSTOMER_ADDRESS);
    layout.putConstraint(SpringLayout.SOUTH, CUSTOMER_ADDRESS, 0, SpringLayout.SOUTH, customerAddressLabel);
    layout.putConstraint(SpringLayout.WEST, CUSTOMER_ADDRESS, 5, SpringLayout.EAST, customerAddressLabel);

    Label customerPhoneLabel = new Label(BUNDLE.getString("phone"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    customerDialog.add(customerPhoneLabel);
    layout.putConstraint(SpringLayout.NORTH, customerPhoneLabel, 5, SpringLayout.SOUTH, customerAddressLabel);
    layout.putConstraint(SpringLayout.WEST, customerPhoneLabel, 5, SpringLayout.WEST, customerDialog);

    CUSTOMER_PHONE.setColumns(12);
    customerDialog.add(CUSTOMER_PHONE);
    layout.putConstraint(SpringLayout.SOUTH, CUSTOMER_PHONE, 0, SpringLayout.SOUTH, customerPhoneLabel);
    layout.putConstraint(SpringLayout.WEST, CUSTOMER_PHONE, 5, SpringLayout.EAST, customerPhoneLabel);

    Label customerEmailLabel = new Label(BUNDLE.getString("email"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    customerDialog.add(customerEmailLabel);
    layout.putConstraint(SpringLayout.NORTH, customerEmailLabel, 5, SpringLayout.SOUTH, customerPhoneLabel);
    layout.putConstraint(SpringLayout.WEST, customerEmailLabel, 5, SpringLayout.WEST, customerDialog);

    CUSTOMER_EMAIL.setColumns(12);
    customerDialog.add(CUSTOMER_EMAIL);
    layout.putConstraint(SpringLayout.SOUTH, CUSTOMER_EMAIL, 0, SpringLayout.SOUTH, customerEmailLabel);
    layout.putConstraint(SpringLayout.WEST, CUSTOMER_EMAIL, 5, SpringLayout.EAST, customerEmailLabel);

    Label customerVatNumberLabel = new Label(BUNDLE.getString("vat"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    customerDialog.add(customerVatNumberLabel);
    layout.putConstraint(SpringLayout.NORTH, customerVatNumberLabel, 5, SpringLayout.SOUTH, customerEmailLabel);
    layout.putConstraint(SpringLayout.WEST, customerVatNumberLabel, 5, SpringLayout.WEST, customerDialog);

    CUSTOMER_VAT_NUMBER.setColumns(12);
    customerDialog.add(CUSTOMER_VAT_NUMBER);
    layout.putConstraint(SpringLayout.SOUTH, CUSTOMER_VAT_NUMBER, 0, SpringLayout.SOUTH, customerVatNumberLabel);
    layout.putConstraint(SpringLayout.WEST, CUSTOMER_VAT_NUMBER, 5, SpringLayout.EAST, customerVatNumberLabel);

    Label customerRegisterLabel = new Label(BUNDLE.getString("register"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    customerDialog.add(customerRegisterLabel);
    layout.putConstraint(SpringLayout.NORTH, customerRegisterLabel, 5, SpringLayout.SOUTH, customerVatNumberLabel);
    layout.putConstraint(SpringLayout.WEST, customerRegisterLabel, 5, SpringLayout.WEST, customerDialog);

    CUSTOMER_REGISTER.setColumns(12);
    customerDialog.add(CUSTOMER_REGISTER);
    layout.putConstraint(SpringLayout.SOUTH, CUSTOMER_REGISTER, 0, SpringLayout.SOUTH, customerRegisterLabel);
    layout.putConstraint(SpringLayout.WEST, CUSTOMER_REGISTER, 5, SpringLayout.EAST, customerRegisterLabel);

    Label customerCapitalLabel = new Label(BUNDLE.getString("capital"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    customerDialog.add(customerCapitalLabel);
    layout.putConstraint(SpringLayout.NORTH, customerCapitalLabel, 5, SpringLayout.SOUTH, customerRegisterLabel);
    layout.putConstraint(SpringLayout.WEST, customerCapitalLabel, 5, SpringLayout.WEST, customerDialog);

    CUSTOMER_SHARED_CAPITAL.setColumns(12);
    customerDialog.add(CUSTOMER_SHARED_CAPITAL);
    layout.putConstraint(SpringLayout.SOUTH, CUSTOMER_SHARED_CAPITAL, 0, SpringLayout.SOUTH, customerCapitalLabel);
    layout.putConstraint(SpringLayout.WEST, CUSTOMER_SHARED_CAPITAL, 5, SpringLayout.EAST, customerCapitalLabel);

    Button submitCustomerButton = new Button(BUNDLE.getString("submit"), BUTTON_COLOR, TEXT_COLOR, INPUT_FONT);
    customerDialog.add(submitCustomerButton);
    layout.putConstraint(SpringLayout.NORTH, submitCustomerButton, 5, SpringLayout.SOUTH, CUSTOMER_SHARED_CAPITAL);
    layout.putConstraint(SpringLayout.EAST, submitCustomerButton, 0, SpringLayout.EAST, CUSTOMER_PHONE);
    submitCustomerButton.addActionListener((e) -> submitCustomer());

    customerDialog.show();
  }

  private void submitCustomer() {
    for (TextField textField : new TextField[]{CUSTOMER_NAME,
      CUSTOMER_ADDRESS,
      CUSTOMER_PHONE,
      CUSTOMER_EMAIL,
      CUSTOMER_VAT_NUMBER,
      CUSTOMER_REGISTER,
      CUSTOMER_SHARED_CAPITAL}) {
      if (Objects.equals(textField.getText(), "")) {
        JOptionPane.showInternalMessageDialog(null, BUNDLE.getString("customerError"));
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
    JDialog invoiceDialog = new JDialog();
    invoiceDialog.setTitle(BUNDLE.getString("invoice"));
    invoiceDialog.setModal(true);
    invoiceDialog.setSize(725, 300);
    invoiceDialog.setResizable(false);
    invoiceDialog.getContentPane().setBackground(MAIN_WINDOW_COLOR);
    SpringLayout layout = new SpringLayout();
    invoiceDialog.setLayout(layout);

    Label invoiceNumberLabel = new Label(BUNDLE.getString("documentNumber"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    invoiceDialog.add(invoiceNumberLabel);
    layout.putConstraint(SpringLayout.NORTH, invoiceNumberLabel, 5, SpringLayout.NORTH, invoiceDialog);
    layout.putConstraint(SpringLayout.WEST, invoiceNumberLabel, 5, SpringLayout.WEST, invoiceDialog);

    INVOICE_NUMBER.setColumns(12);
    invoiceDialog.add(INVOICE_NUMBER);
    layout.putConstraint(SpringLayout.NORTH, INVOICE_NUMBER, 5, SpringLayout.SOUTH, invoiceNumberLabel);
    layout.putConstraint(SpringLayout.WEST, INVOICE_NUMBER, 5, SpringLayout.WEST, invoiceDialog);

    Label invoiceDateLabel = new Label(BUNDLE.getString("documentDate"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    invoiceDialog.add(invoiceDateLabel);
    layout.putConstraint(SpringLayout.NORTH, invoiceDateLabel, 5, SpringLayout.NORTH, invoiceDialog);
    layout.putConstraint(SpringLayout.WEST, invoiceDateLabel, 5, SpringLayout.EAST, INVOICE_NUMBER);

    INVOICE_DATE.setColumns(12);
    invoiceDialog.add(INVOICE_DATE);
    layout.putConstraint(SpringLayout.NORTH, INVOICE_DATE, 5, SpringLayout.SOUTH, invoiceDateLabel);
    layout.putConstraint(SpringLayout.WEST, INVOICE_DATE, 5, SpringLayout.EAST, INVOICE_NUMBER);

    Label invoiceDeliveryLabel = new Label(BUNDLE.getString("delivery"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    invoiceDialog.add(invoiceDeliveryLabel);
    layout.putConstraint(SpringLayout.NORTH, invoiceDeliveryLabel, 5, SpringLayout.NORTH, invoiceDialog);
    layout.putConstraint(SpringLayout.WEST, invoiceDeliveryLabel, 5, SpringLayout.EAST, INVOICE_DATE);

    INVOICE_DELIVERY.setColumns(12);
    invoiceDialog.add(INVOICE_DELIVERY);
    layout.putConstraint(SpringLayout.NORTH, INVOICE_DELIVERY, 5, SpringLayout.SOUTH, invoiceDeliveryLabel);
    layout.putConstraint(SpringLayout.WEST, INVOICE_DELIVERY, 5, SpringLayout.EAST, INVOICE_DATE);

    Label invoiceTransportLabel = new Label(BUNDLE.getString("transport"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    invoiceDialog.add(invoiceTransportLabel);
    layout.putConstraint(SpringLayout.NORTH, invoiceTransportLabel, 5, SpringLayout.NORTH, invoiceDialog);
    layout.putConstraint(SpringLayout.WEST, invoiceTransportLabel, 5, SpringLayout.EAST, INVOICE_DELIVERY);

    INVOICE_TRANSPORT.setColumns(12);
    invoiceDialog.add(INVOICE_TRANSPORT);
    layout.putConstraint(SpringLayout.NORTH, INVOICE_TRANSPORT, 5, SpringLayout.SOUTH, invoiceTransportLabel);
    layout.putConstraint(SpringLayout.WEST, INVOICE_TRANSPORT, 5, SpringLayout.EAST, INVOICE_DELIVERY);

    Label invoicePackagingLabel = new Label(BUNDLE.getString("packaging"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    invoiceDialog.add(invoicePackagingLabel);
    layout.putConstraint(SpringLayout.NORTH, invoicePackagingLabel, 5, SpringLayout.SOUTH, INVOICE_NUMBER);
    layout.putConstraint(SpringLayout.WEST, invoicePackagingLabel, 5, SpringLayout.WEST, invoiceDialog);

    INVOICE_PACKAGING.setColumns(12);
    invoiceDialog.add(INVOICE_PACKAGING);
    layout.putConstraint(SpringLayout.NORTH, INVOICE_PACKAGING, 5, SpringLayout.SOUTH, invoicePackagingLabel);
    layout.putConstraint(SpringLayout.WEST, INVOICE_PACKAGING, 5, SpringLayout.WEST, invoiceDialog);

    Label invoicePaymentLabel = new Label(BUNDLE.getString("payment"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    invoiceDialog.add(invoicePaymentLabel);
    layout.putConstraint(SpringLayout.NORTH, invoicePaymentLabel, 5, SpringLayout.SOUTH, INVOICE_DATE);
    layout.putConstraint(SpringLayout.WEST, invoicePaymentLabel, 5, SpringLayout.EAST, INVOICE_PACKAGING);

    INVOICE_PAYMENT.setColumns(12);
    invoiceDialog.add(INVOICE_PAYMENT);
    layout.putConstraint(SpringLayout.NORTH, INVOICE_PAYMENT, 5, SpringLayout.SOUTH, invoicePaymentLabel);
    layout.putConstraint(SpringLayout.WEST, INVOICE_PAYMENT, 5, SpringLayout.EAST, INVOICE_PACKAGING);

    Label invoiceNonDocumentedCostLabel = new Label(BUNDLE.getString("nonDocumentedCost"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    invoiceDialog.add(invoiceNonDocumentedCostLabel);
    layout.putConstraint(SpringLayout.NORTH, invoiceNonDocumentedCostLabel, 5, SpringLayout.SOUTH, INVOICE_TRANSPORT);
    layout.putConstraint(SpringLayout.WEST, invoiceNonDocumentedCostLabel, 5, SpringLayout.EAST, INVOICE_PAYMENT);

    INVOICE_NON_DOCUMENTED_COST.setColumns(12);
    invoiceDialog.add(INVOICE_NON_DOCUMENTED_COST);
    layout.putConstraint(SpringLayout.NORTH, INVOICE_NON_DOCUMENTED_COST, 5, SpringLayout.SOUTH, invoiceNonDocumentedCostLabel);
    layout.putConstraint(SpringLayout.WEST, INVOICE_NON_DOCUMENTED_COST, 5, SpringLayout.EAST, INVOICE_PAYMENT);

    Label invoicePackagingCostLabel = new Label(BUNDLE.getString("packaging"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    invoiceDialog.add(invoicePackagingCostLabel);
    layout.putConstraint(SpringLayout.NORTH, invoicePackagingCostLabel, 5, SpringLayout.SOUTH, INVOICE_TRANSPORT);
    layout.putConstraint(SpringLayout.WEST, invoicePackagingCostLabel,5, SpringLayout.EAST, INVOICE_NON_DOCUMENTED_COST);

    INVOICE_PACKAGING_COST.setColumns(12);
    invoiceDialog.add(INVOICE_PACKAGING_COST);
    layout.putConstraint(SpringLayout.NORTH, INVOICE_PACKAGING_COST, 5, SpringLayout.SOUTH, invoicePackagingCostLabel);
    layout.putConstraint(SpringLayout.WEST, INVOICE_PACKAGING_COST, 5, SpringLayout.EAST, INVOICE_NON_DOCUMENTED_COST);

    Label invoiceDocumentedCostLabel = new Label(BUNDLE.getString("documentedCost"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    invoiceDialog.add(invoiceDocumentedCostLabel);
    layout.putConstraint(SpringLayout.NORTH, invoiceDocumentedCostLabel, 5, SpringLayout.SOUTH, INVOICE_PACKAGING);
    layout.putConstraint(SpringLayout.WEST, invoiceDocumentedCostLabel, 5, SpringLayout.WEST, invoiceDialog);

    INVOICE_DOCUMENTED_COST.setColumns(12);
    invoiceDialog.add(INVOICE_DOCUMENTED_COST);
    layout.putConstraint(SpringLayout.NORTH, INVOICE_DOCUMENTED_COST, 5, SpringLayout.SOUTH, invoiceDocumentedCostLabel);
    layout.putConstraint(SpringLayout.WEST, INVOICE_DOCUMENTED_COST, 5, SpringLayout.WEST, invoiceDialog);

    Label invoiceInterestLabel = new Label(BUNDLE.getString("interest"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    invoiceDialog.add(invoiceInterestLabel);
    layout.putConstraint(SpringLayout.NORTH, invoiceInterestLabel, 5, SpringLayout.SOUTH, INVOICE_PAYMENT);
    layout.putConstraint(SpringLayout.WEST, invoiceInterestLabel, 5, SpringLayout.EAST, INVOICE_DOCUMENTED_COST);

    INVOICE_INTEREST.setColumns(12);
    invoiceDialog.add(INVOICE_INTEREST);
    layout.putConstraint(SpringLayout.NORTH, INVOICE_INTEREST, 5, SpringLayout.SOUTH, invoiceInterestLabel);
    layout.putConstraint(SpringLayout.WEST, INVOICE_INTEREST, 5, SpringLayout.EAST, INVOICE_DOCUMENTED_COST);

    Label invoiceDepositLabel = new Label(BUNDLE.getString("deposit"), MAIN_WINDOW_COLOR, TEXT_COLOR, ELEMENT_TITLE_FONT);
    invoiceDialog.add(invoiceDepositLabel);
    layout.putConstraint(SpringLayout.NORTH, invoiceDepositLabel, 5, SpringLayout.SOUTH, INVOICE_NON_DOCUMENTED_COST);
    layout.putConstraint(SpringLayout.WEST, invoiceDepositLabel, 5, SpringLayout.EAST, INVOICE_INTEREST);

    INVOICE_DEPOSIT.setColumns(12);
    invoiceDialog.add(INVOICE_DEPOSIT);
    layout.putConstraint(SpringLayout.NORTH, INVOICE_DEPOSIT, 5, SpringLayout.SOUTH, invoiceDepositLabel);
    layout.putConstraint(SpringLayout.WEST, INVOICE_DEPOSIT, 5, SpringLayout.EAST, INVOICE_INTEREST);

    Button submitInvoiceInfo = new Button(BUNDLE.getString("submit"), BUTTON_COLOR, TEXT_COLOR, INPUT_FONT);
    invoiceDialog.add(submitInvoiceInfo);
    layout.putConstraint(SpringLayout.SOUTH, submitInvoiceInfo, 5, SpringLayout.SOUTH, INVOICE_DEPOSIT);
    layout.putConstraint(SpringLayout.EAST, submitInvoiceInfo, 5, SpringLayout.EAST, INVOICE_PACKAGING_COST);
    submitInvoiceInfo.addActionListener((e) -> submitInvoice());

    invoiceDialog.show();
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
      if (Objects.equals(textField.getText(), "")) {
        JOptionPane.showInternalMessageDialog(null, BUNDLE.getString("invoiceError"));
        return;
      }
    }

    try {
      Double.parseDouble(INVOICE_NON_DOCUMENTED_COST.getText());
    } catch (Exception exception) {
      JOptionPane.showInternalMessageDialog(null, BUNDLE.getString("nonDocumentedCostError"));
      return;
    }

    try {
      Double.parseDouble(INVOICE_PACKAGING_COST.getText());
    } catch (Exception exception) {
      JOptionPane.showInternalMessageDialog(null, BUNDLE.getString("packagingError"));
      return;
    }

    try {
      Double.parseDouble(INVOICE_DOCUMENTED_COST.getText());
    } catch (Exception exception) {
      JOptionPane.showInternalMessageDialog(null, BUNDLE.getString("documentedCostError"));
      return;
    }

    try {
      Double.parseDouble(INVOICE_INTEREST.getText());
    } catch (Exception exception) {
      JOptionPane.showInternalMessageDialog(null, BUNDLE.getString("interestError"));
      return;
    }

    try {
      Double.parseDouble(INVOICE_DEPOSIT.getText());
    } catch (Exception exception) {
      JOptionPane.showInternalMessageDialog(null, BUNDLE.getString("depositError"));
      return;
    }

    HANDLER.setNonDocumentedCost(Double.parseDouble(INVOICE_NON_DOCUMENTED_COST.getText()));
    HANDLER.setPackagingCost(Double.parseDouble(INVOICE_PACKAGING_COST.getText()));
    HANDLER.setDocumentedCost(Double.parseDouble(INVOICE_DOCUMENTED_COST.getText()));
    HANDLER.setInterests(Double.parseDouble(INVOICE_INTEREST.getText()));
    HANDLER.setDeposit(Double.parseDouble(INVOICE_DEPOSIT.getText()));

    HANDLER.setInvoice(new String[]{INVOICE_NUMBER.getText(),
      INVOICE_DATE.getText(),
      INVOICE_DELIVERY.getText(),
      INVOICE_TRANSPORT.getText(),
      INVOICE_PACKAGING.getText(),
      INVOICE_PAYMENT.getText()});
  }
}