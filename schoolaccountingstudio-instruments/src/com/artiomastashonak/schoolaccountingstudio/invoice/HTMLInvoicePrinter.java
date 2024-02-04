package com.artiomastashonak.schoolaccountingstudio.invoice;

import com.artiomastashonak.schoolaccountingstudio.Parameters;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Random;

public class HTMLInvoicePrinter {
  private final InvoiceHandler HANDLER;
  private String document;

  public HTMLInvoicePrinter(InvoiceHandler handler) {
    this.HANDLER = handler;
    document = "<!DOCTYPE html>\n" +
      "<html lang=\"en\">\n" +
      "<head>\n" +
      "\t<meta charset=\"UTF-8\">\n" +
      "\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
      String.format(String.format("\t<title>%s</title>\n", Parameters.getBundle().getString("invoiceNTo")), HANDLER.getInvoice()[0], HANDLER.getCustomer()[0]) +
      "\t<link rel=\"stylesheet\" href=\"css/style.css\">\n" +
      "</head>\n" +
      "<body>\n" +
      "\t<div class=\"document\">\n";
  }

  public HTMLInvoicePrinter addHeader() {
    document += String.format(String.format("\t\t<h1 class=\"header\">%s</h1>\n", Parameters.getBundle().getString("invoiceNTo")), HANDLER.getInvoice()[0], HANDLER.getCustomer()[0]);
    return this;
  }

  public HTMLInvoicePrinter addSeller() {
    document += "\t\t<div class=\"seller-customer break\">\n" +
      "\t\t\t<div class=\"seller\">\n" +
      String.format("\t\t\t\t<h3>%s</h3>\n", HANDLER.getSeller()[0]) +
      String.format("\t\t\t\t<p>%s</p>\n", HANDLER.getSeller()[1]) +
      String.format("\t\t\t\t<p>%s</p>\n", HANDLER.getSeller()[2]) +
      String.format("\t\t\t\t<p>%s</p>\n", HANDLER.getSeller()[3]) +
      String.format("\t\t\t\t<p>%s</p>\n", HANDLER.getSeller()[4]) +
      String.format("\t\t\t\t<p>%s</p>\n", HANDLER.getSeller()[5]) +
      String.format("\t\t\t\t<p>%s</p>\n", HANDLER.getSeller()[6]) +
      "\t\t\t</div>\n";
    return this;
  }

  public HTMLInvoicePrinter addCustomer() {
    document += "\t\t\t<div class=\"customer\">\n" +
      String.format("\t\t\t\t<h3>%s</h3>\n", HANDLER.getCustomer()[0]) +
      String.format("\t\t\t\t<p>%s</p>\n", HANDLER.getCustomer()[1]) +
      String.format("\t\t\t\t<p>%s</p>\n", HANDLER.getCustomer()[2]) +
      String.format("\t\t\t\t<p>%s</p>\n", HANDLER.getCustomer()[3]) +
      String.format("\t\t\t\t<p>%s</p>\n", HANDLER.getCustomer()[4]) +
      String.format("\t\t\t\t<p>%s</p>\n", HANDLER.getCustomer()[5]) +
      String.format("\t\t\t\t<p>%s</p>\n", HANDLER.getCustomer()[6]) +
      "\t\t\t</div>\n" +
      "\t\t</div>\n";
    return this;
  }

  public HTMLInvoicePrinter addLegalInformation() {
    String[] codes = {"0G6TBBX", "0KDMVIB", "0ZCQR4A", "2LCMIUNI", "38P86EY", "39QMOPD", "3ZJY534", "4157ZO4", "5KQRP7D", "5P3UNVR", "M5UXCR1", "M62SGNV", "MJ10YNU"};
    Random random = new Random();
    document += "\t\t<table class=\"legal-information break\">\n" +
      "\t\t\t<thead>\n" +
      "\t\t\t\t<tr>\n" +
      String.format("\t\t\t\t\t<th>%s</th>\n", Parameters.getBundle().getString("documentType")) +
      String.format("\t\t\t\t\t<th>%s</th>\n", Parameters.getBundle().getString("recipientCode")) +
      "\t\t\t\t</tr>\n" +
      "\t\t\t</thead>\n" +
      "\t\t\t<tbody>\n" +
      "\t\t\t\t<tr>\n" +
      "\t\t\t\t\t<th>TD01</th>\n" +
      String.format("\t\t\t\t\t<th>%s</th>\n", codes[random.nextInt(codes.length)]) +
      "\t\t\t\t</tr>\n" +
      "\t\t\t</tbody>\n" +
      "\t\t</table>\n";
    return this;
  }

  public HTMLInvoicePrinter addInformation() {
    document += "\t\t<table class=\"information break\">\n" +
      "\t\t\t<thead>\n" +
      "\t\t\t\t<tr>\n" +
      String.format("\t\t\t\t\t<th>%s</th>\n", Parameters.getBundle().getString("delivery")) +
      String.format("\t\t\t\t\t<th>%s</th>\n", Parameters.getBundle().getString("transport")) +
      String.format("\t\t\t\t\t<th>%s</th>\n", Parameters.getBundle().getString("packaging")) +
      String.format("\t\t\t\t\t<th>%s</th>\n", Parameters.getBundle().getString("payment")) +
      "\t\t\t\t</tr>\n" +
      "\t\t\t</thead>\n" +
      "\t\t\t<tbody>\n" +
      "\t\t\t\t<tr>\n" +
      String.format("\t\t\t\t\t<th>%s</th>\n", HANDLER.getInvoice()[2]) +
      String.format("\t\t\t\t\t<th>%s</th>\n", HANDLER.getInvoice()[3]) +
      String.format("\t\t\t\t\t<th>%s</th>\n", HANDLER.getInvoice()[4]) +
      String.format("\t\t\t\t\t<th>%s</th>\n", HANDLER.getInvoice()[5]) +
      "\t\t\t\t</tr>\n" +
      "\t\t\t</tbody>\n" +
      "\t\t</table>\n";
    return this;
  }

  public HTMLInvoicePrinter addItems() {
    document += "<table class=\"items break\">\n" +
      "\t\t\t\t<thead>\n" +
      "\t\t\t\t\t<tr>\n" +
      String.format("\t\t\t\t\t\t<th>%s</th>\n", Parameters.getBundle().getString("code")) +
      String.format("\t\t\t\t\t\t<th>%s</th>\n", Parameters.getBundle().getString("quantity")) +
      String.format("\t\t\t\t\t\t<th>%s</th>\n", Parameters.getBundle().getString("description")) +
      String.format("\t\t\t\t\t\t<th>%s</th>\n", Parameters.getBundle().getString("VATPercent")) +
      String.format("\t\t\t\t\t\t<th>%s</th>\n", Parameters.getBundle().getString("unitPrice")) +
      String.format("\t\t\t\t\t\t<th>%s</th>\n", Parameters.getBundle().getString("discount1")) +
      String.format("\t\t\t\t\t\t<th>%s</th>\n", Parameters.getBundle().getString("discount2")) +
      "\t\t\t\t\t</tr>\n" +
      "\t\t\t\t</thead>\n" +
      "\t\t\t\t<tbody>\n";

    for (Item item : HANDLER.getItems()) {
      document += "\t\t\t\t<tr>\n" +
        String.format("\t\t\t\t\t<th>%s</th>\n", item.code()) +
        String.format("\t\t\t\t\t<th>%s %d</th>\n", item.measureUnit(), item.quantity()) +
        String.format("\t\t\t\t\t<th>%s</th>\n", item.description()) +
        String.format("\t\t\t\t\t<th>%d&percnt;</th>\n", item.vat()) +
        String.format("\t\t\t\t\t<th>%.2f&euro;</th>\n", item.price()) +
        String.format("\t\t\t\t\t<th>%.2f&percnt;</th>\n", item.discount1()) +
        String.format("\t\t\t\t\t<th>%.2f&percnt;</th>\n", item.discount2()) +
        "\t\t\t\t</tr>\n";
    }

    if (HANDLER.getNonDocumentedCost() != 0) {
      document += "\t\t\t\t<tr>\n" +
        "\t\t\t\t\t<th></th>\n" +
        "\t\t\t\t\t<th></th>\n" +
        String.format("\t\t\t\t\t<th>%s</th>\n", Parameters.getBundle().getString("nonDocumentedCost")) +
        "\t\t\t\t\t<th></th>\n" +
        String.format("\t\t\t\t\t<th>%.2f&euro;\n", HANDLER.getNonDocumentedCost()) +
        "\t\t\t\t\t<th></th>\n" +
        "\t\t\t\t\t<th></th>\n" +
        "\t\t\t\t</tr>\n";
      }

    if (HANDLER.getPackagingCost() != 0) {
      document += "\t\t\t\t<tr>\n" +
        "\t\t\t\t\t<th></th>\n" +
        "\t\t\t\t\t<th></th>\n" +
        String.format("\t\t\t\t\t<th>%s</th>\n", Parameters.getBundle().getString("packaging")) +
        "\t\t\t\t\t<th></th>\n" +
        String.format("\t\t\t\t\t<th>%.2f&euro;\n", HANDLER.getPackagingCost()) +
        "\t\t\t\t\t<th></th>\n" +
        "\t\t\t\t\t<th></th>\n" +
        "\t\t\t\t</tr>\n";
    }
    document += "\t\t\t</tbody>\n" +
      "\t\t</table>\n";
    return this;
  }

  public HTMLInvoicePrinter addVatInformation() {
    HANDLER.composeMap();
    document += "\t\t<table class=\"vat\">\n" +
      "\t\t\t<thead>\n" +
      "\t\t\t\t<tr>\n" +
      String.format("\t\t\t\t\t<th>%s</th>\n", Parameters.getBundle().getString("VATPercent")) +
      String.format("\t\t\t\t\t<th>%s</th>\n", Parameters.getBundle().getString("calculatedOn")) +
      String.format("\t\t\t\t\t<th>%s</th>\n", Parameters.getBundle().getString("vat")) +
      "\t\t\t\t</tr>\n" +
      "\t\t\t</thead>\n" +
      "\t\t\t<tbody>\n";
    HANDLER.getItemsMap().forEach((key, value) -> {
      document += "\t\t\t\t<tr>\n" +
        String.format("\t\t\t\t\t<th>%d&percnt;</th>\n", key) +
        String.format("\t\t\t\t\t<th>%.2f&euro;</th>\n", Math.round((value / ((100 + key) / 100.0)) * 100.0) / 100.0) +
        String.format("\t\t\t\t\t<th>%.2f&euro;</th>\n", Math.round((value - (value / ((100 + key) / 100.0))) * 100.0) / 100.0) +
        "\t\t\t\t</tr>\n";
    });
    document += "\t\t\t</tbody>\n" +
      "\t\t</table>\n";
    return this;
  }

  public HTMLInvoicePrinter addCostInformation() {
    document += "\t\t<table class=\"cost-information\">\n" +
      "\t\t\t<thead>\n" +
      "\t\t\t\t<tr>\n" +
      String.format("\t\t\t\t\t<th>%s</th>\n", Parameters.getBundle().getString("documentedCost")) +
      String.format("\t\t\t\t\t<th>%s</th>\n", Parameters.getBundle().getString("interest")) +
      String.format("\t\t\t\t\t<th>%s</th>\n", Parameters.getBundle().getString("deposit")) +
      String.format("\t\t\t\t\t<th>%s</th>\n", Parameters.getBundle().getString("total")) +
      "\t\t\t\t</tr>\n" +
      "\t\t\t</thead>\n" +
      "\t\t\t<tbody>\n" +
      "\t\t\t\t<tr>\n" +
      String.format("\t\t\t\t\t<th>%.2f&euro;</th>\n", HANDLER.getDocumentedCost()) +
      String.format("\t\t\t\t\t<th>%.2f&euro;</th>\n", HANDLER.getInterests()) +
      String.format("\t\t\t\t\t<th>%.2f&euro;</th>\n", HANDLER.getDeposit()) +
      String.format("\t\t\t\t\t<th>%.2f&euro;</th>\n", HANDLER.calculate()) +
      "\t\t\t\t</tr>\n" +
      "\t\t\t</tbody>\n" +
      "\t\t</table>\n";
    return this;
  }

  public void endFile() {
    document += "\t</div>\n" +
      "\t<script src=\"js/main.js\"></script>\n" +
      "</body>\n" +
      "</html>";
  }

  public int print() {
    String documentName = String.format("invoice_n_%s_to_%s", HANDLER.getInvoice()[0], HANDLER.getCustomer()[0]);
    String outputDirectory = "generated/invoices/html";
    String cssDirectory = "resources/printing/invoice/css/style.css";
    String jsDirectory = "resources/printing/invoice/js/main.js";
    try {
      File documentOutput = new File(outputDirectory + "/" + documentName);
      documentOutput.mkdirs();

      BufferedWriter writer = new BufferedWriter(new FileWriter(outputDirectory + "/" + documentName + "/" + documentName + ".html"));
      writer.write(document);
      writer.close();

      File invoiceCssDir = new File(outputDirectory + "/" + documentName + "/css");
      invoiceCssDir.mkdirs();

      File invoiceJsDir = new File(outputDirectory + "/" + documentName + "/js");
      invoiceJsDir.mkdirs();

      File cssSource = new File(cssDirectory);
      File jsSource = new File(jsDirectory);
      File cssOutput = new File(outputDirectory + "/" + documentName + "/css/style.css");
      File jsOutput = new File(outputDirectory + "/" + documentName + "/js/main.js");

      Files.copy(cssSource.toPath(), cssOutput.toPath());
      Files.copy(jsSource.toPath(), jsOutput.toPath());
    } catch (Exception e) {
      reset();
      return -1;
    }
    reset();
    try {
      Desktop.getDesktop().open(new File(outputDirectory + "/" + documentName + "/" + documentName + ".html"));
    } catch (IOException ignored) { }
    return 0;
  }

  private void reset() {
    document = "<!DOCTYPE html>\n" +
      "<html lang=\"en\">\n" +
      "<head>\n" +
      "\t<meta charset=\"UTF-8\">\n" +
      "\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
      String.format("\t<title>Invoice n. %s to %s</title>\n", HANDLER.getInvoice()[0], HANDLER.getCustomer()[0]) +
      "\t<link rel=\"stylesheet\" href=\"css/style.css\">\n" +
      "</head>\n" +
      "<body>\n" +
      "\t<div class=\"document\">\n";
  }
}