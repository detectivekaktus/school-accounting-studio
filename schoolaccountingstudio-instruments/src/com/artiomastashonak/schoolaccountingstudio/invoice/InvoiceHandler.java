// Copyright 2023-2024 Artiom Astashonak. Use of this code is governed by the Apache License 2.0 that can be found in the LICENSE file.
package com.artiomastashonak.schoolaccountingstudio.invoice;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The {@code InvoiceHandler} object is responsible for giving numeric results
 * of an invoice processed, based on the data the object itself is holding.
 *
 * @author Artiom Astashonak
 */
public class InvoiceHandler {
  /**
   * The seller is represented with a String {@code Array}.
   * <ul>
   *   <li>Index 0 - name</li>
   *   <li>Index 1 - address</li>
   *   <li>Index 2 - phone number</li>
   *   <li>Index 3 - email</li>
   *   <li>Index 4 - VAT payer number</li>
   *   <li>Index 5 - register</li>
   *   <li>Index 6 - shared capital</li>
   * </ul>
   */
  private String[] seller = new String[] {};
  /**
   * The customer is represented with a String {@code Array}.
   * <ul>
   *   <li>Index 0 - name</li>
   *   <li>Index 1 - address</li>
   *   <li>Index 2 - phone number</li>
   *   <li>Index 3 - email</li>
   *   <li>Index 4 - VAT payer number</li>
   *   <li>Index 5 - register</li>
   *   <li>Index 6 - shared capital</li>
   * </ul>
   */
  private String[] customer = new String[] {};
  /**
   * The invoice is represented with a String {@code Array}.
   * <ul>
   *   <li>Index 0 - number</li>
   *   <li>Index 1 - emission date</li>
   *   <li>Index 2 - delivery clause</li>
   *   <li>Index 3 - transport clause</li>
   *   <li>Index 4 - packaging clause</li>
   *   <li>Index 5 - payment clause</li>
   * </ul>
   */
  private String[] invoice = new String[] {};
  private ArrayList<Item> items = new ArrayList<>(10);
  private HashMap<Integer, Double> itemsMap = new HashMap<>(4);
  private double nonDocumentedCost = 0;
  private double packagingCost = 0;
  private double documentedCost = 0;
  private double interests = 0;
  private double deposit = 0;

  /**
   * Constructs a new {@code InvoiceHandler} object with initial values set up.
   */
  public InvoiceHandler() { }

  /**
   * Calculates and returns an invoice result based on the data provided
   * previously.
   *
   * @return invoice result or {@code 0} if no data is provided.
   */
  public double calculate() {
    composeMap();
    double semiResult = 0.0;
    for (double value : itemsMap.values()) {
      semiResult += value;
    }

    return Math.round((semiResult + documentedCost + interests + deposit) * 100.0)/100.0;
  }

  /**
   * Assembles {@code HashMap itemsMap} static variable with values based on the
   * {@code ArrayList items} of {@link Item} records stored by the original
   * object.
   */
  public void composeMap() {
    itemsMap.put(4, 0.0);
    itemsMap.put(5, 0.0);
    itemsMap.put(10, 0.0);
    itemsMap.put(22, 0.0);

    for (Item item : items) {
      itemsMap.put(item.vat(), itemsMap.get(item.vat()) + (100 - item.discount2())/100 * ((100 - item.discount1())/100 * (item.quantity() * item.price())));
    }

    double itemsSum = 0.0;
    for (double value : itemsMap.values()) {
      itemsSum += value;
    }

    double costCoefficient = nonDocumentedCost/itemsSum;
    double packagingCoefficient = packagingCost/itemsSum;

    itemsMap.forEach((key, value) -> {
      itemsMap.put(key, itemsMap.get(key) + value * costCoefficient);
      itemsMap.put(key, itemsMap.get(key) + value * packagingCoefficient);

      itemsMap.put(key, itemsMap.get(key) * (100 + key)/100);
    });
  }

  /**
   * Resets the current instance of the object to the default settings.
   */
  public void reset() {
    this.seller = new String[] {};
    this.customer = new String[] {};
    this.invoice = new String[] {};
    this.items = new ArrayList<>(10);
    this.itemsMap = new HashMap<>(4);
    this.nonDocumentedCost = 0;
    this.packagingCost = 0;
    this.documentedCost = 0;
    this.interests = 0;
    this.deposit = 0;
  }

  /**
   * Creates a directory in the path <strong>$HOME/generated/invoices/html</strong>
   * with the name <strong>{@code invoice_n_INVOICE_NUMBER_to_CUSTOMER_NAME}</strong>
   * format.
   * <p>
   * If successful, will return 0 and open the invoice in the browser set as a default
   * one.
   *
   * @return 0 if the invoice is printed successfully, -1 if the invoice wasn't printed.
   */
  public int printHTML() {
    HTMLInvoicePrinter printer = new HTMLInvoicePrinter(this);
    try {
      printer.addHeader()
        .addSeller()
        .addCustomer()
        .addLegalInformation()
        .addInformation()
        .addItems()
        .addVatInformation()
        .addCostInformation()
        .endFile();
    } catch (Exception ignored) { }
    return printer.print();
  }

  /**
   * Creates a file in the path <strong>$HOME/generated/invoices/xml</strong> with the
   * name <strong>{@code invoice_n_INVOICE_NUMBER_to_CUSTOMER_NAME}</strong> format.
   * <p>
   * If successful, will return 0 and open the invoice in the application set as a default
   * one to open .xml files.
   *
   * @return 0 if the invoice is printed successfully, -1 if the invoice wasn't printed.
   */
  public int printXML() {
    XMLInvoicePrinter printer = new XMLInvoicePrinter(this);
    try {
      printer.addNumber()
        .addDate()
        .addSeller()
        .addCustomer()
        .addDelivery()
        .addTransport()
        .addPackaging()
        .addPayment()
        .addItems()
        .addNonDocumentedCost()
        .addPackagingCost()
        .addDocumentedCost()
        .addInterests()
        .addDeposit()
        .addTotal()
        .endFile();
    } catch (Exception ignored) { }
    return printer.print();
  }

  public String[] getSeller() {
    return seller;
  }

  public void setSeller(String[] seller) {
    this.seller = seller;
  }

  public String[] getCustomer() {
    return customer;
  }

  public void setCustomer(String[] customer) {
    this.customer = customer;
  }

  public String[] getInvoice() {
    return invoice;
  }

  public void setInvoice(String[] invoice) {
    this.invoice = invoice;
  }

  public ArrayList<Item> getItems() {
    return items;
  }

  public void addItem(Item item) {
    this.items.add(item);
  }

  public HashMap<Integer, Double> getItemsMap() {
    return itemsMap;
  }

  public double getNonDocumentedCost() {
    return nonDocumentedCost;
  }

  public void setNonDocumentedCost(double nonDocumentedCost) {
    this.nonDocumentedCost = nonDocumentedCost;
  }

  public double getPackagingCost() {
    return packagingCost;
  }

  public void setPackagingCost(double packagingCost) {
    this.packagingCost = packagingCost;
  }

  public double getDocumentedCost() {
    return documentedCost;
  }

  public void setDocumentedCost(double documentedCost) {
    this.documentedCost = documentedCost;
  }

  public double getInterests() {
    return interests;
  }

  public void setInterests(double interests) {
    this.interests = interests;
  }

  public double getDeposit() {
    return deposit;
  }

  public void setDeposit(double deposit) {
    this.deposit = deposit;
  }
}