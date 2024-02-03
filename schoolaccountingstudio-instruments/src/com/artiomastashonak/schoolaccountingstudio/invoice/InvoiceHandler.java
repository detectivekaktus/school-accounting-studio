package com.artiomastashonak.schoolaccountingstudio.invoice;

import java.util.ArrayList;
import java.util.HashMap;

public class InvoiceHandler {
  private String[] seller = new String[] {};
  private String[] customer = new String[] {};
  private String[] invoice = new String[] {};
  private ArrayList<Item> items = new ArrayList<>(10);
  private HashMap<Short, Double> itemsMap = new HashMap<>(4);
  private double nonDocumentedCost = 0;
  private double packagingCost = 0;
  private double documentedCost = 0;
  private double interests = 0;
  private double deposit = 0;

  public InvoiceHandler() { }

  public double calculate() {
    composeMap();
    double semiResult = 0.0;
    for (double value : itemsMap.values()) {
      semiResult += value;
    }

    return Math.round((semiResult + documentedCost + interests + deposit) * 100.0)/100.0;
  }

  public void composeMap() {
    itemsMap.put((short) 4, 0.0);
    itemsMap.put((short) 5, 0.0);
    itemsMap.put((short) 10, 0.0);
    itemsMap.put((short) 22, 0.0);

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
        .addTotal();

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

  public HashMap<Short, Double> getItemsMap() {
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