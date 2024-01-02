package com.artiomastashonak.schoolaccountingstudio.invoice;

import java.util.ArrayList;

public class InvoiceHandler {

    private String[] seller = new String[] {};
    private String[] customer = new String[] {};
    private String[] invoice = new String[] {};
    private ArrayList<Item> items = new ArrayList<>(10);
    private double nonDocumentedCost = 0;
    private double documentedCost = 0;
    private double interests = 0;
    private double deposit = 0;

    public InvoiceHandler() { }

    public long calculate() {
        return 1L;
    }

    public void printHTML() {

    }

    public void printXML() {

    }

    public void reset() {
        this.seller = new String[] {};
        this.customer = new String[] {};
        this.invoice = new String[] {};
        this.items = new ArrayList<>(10);
        this.nonDocumentedCost = 0;
        this.documentedCost = 0;
        this.interests = 0;
        this.deposit = 0;
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

    public double getNonDocumentedCost() {
        return nonDocumentedCost;
    }

    public void setNonDocumentedCost(double nonDocumentedCost) {
        this.nonDocumentedCost = nonDocumentedCost;
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