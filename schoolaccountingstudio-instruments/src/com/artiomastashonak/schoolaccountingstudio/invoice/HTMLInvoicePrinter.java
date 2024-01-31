package com.artiomastashonak.schoolaccountingstudio.invoice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;

public class HTMLInvoicePrinter {
  private final InvoiceHandler HANDLER;
  private String document = "<!DOCTYPE html>\n" +
    "<html lang=\"en\">\n" +
    "<head>\n" +
    "\t<meta charset=\"UTF-8\">\n" +
    "\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
    "\t<title>Invoice n. 123 to Example</title>\n" +
    "\t<link rel=\"stylesheet\" href=\"css/style.css\">\n" +
    "</head>\n" +
    "<body>\n" +
    "\t<div class=\"document\">\n";

  public HTMLInvoicePrinter(InvoiceHandler handler) {
    this.HANDLER = handler;
  }

  public HTMLInvoicePrinter addHeader() {
    document += String.format("\t\t<h1 class=\"header\">Invoice n. %s from %s</h1>\n", HANDLER.getInvoice()[0], HANDLER.getInvoice()[1]);
    return this;
  }

  public HTMLInvoicePrinter addSeller() {
    document += "\t\t<div class=\"seller-customer break\">\n" +
      "\t\t\t<div class=\"seller\">\n";
    document += String.format("\t\t\t\t<h3>%s</h3>\n", HANDLER.getSeller()[0]);
    document += String.format("\t\t\t\t<p>%s</p>\n", HANDLER.getSeller()[1]);
    document += String.format("\t\t\t\t<p>%s</p>\n", HANDLER.getSeller()[2]);
    document += String.format("\t\t\t\t<p>%s</p>\n", HANDLER.getSeller()[3]);
    document += String.format("\t\t\t\t<p>%s</p>\n", HANDLER.getSeller()[4]);
    document += String.format("\t\t\t\t<p>%s</p>\n", HANDLER.getSeller()[5]);
    document += String.format("\t\t\t\t<p>%s</p>\n", HANDLER.getSeller()[6]);
    document += "\t\t\t</div>\n";
    return this;
  }

  public HTMLInvoicePrinter addCustomer() {
    document += "\t\t\t<div class=\"customer\">\n";
    document += String.format("\t\t\t\t<h3>%s</h3>\n", HANDLER.getCustomer()[0]);
    document += String.format("\t\t\t\t<p>%s</p>\n", HANDLER.getCustomer()[1]);
    document += String.format("\t\t\t\t<p>%s</p>\n", HANDLER.getCustomer()[2]);
    document += String.format("\t\t\t\t<p>%s</p>\n", HANDLER.getCustomer()[3]);
    document += String.format("\t\t\t\t<p>%s</p>\n", HANDLER.getCustomer()[4]);
    document += String.format("\t\t\t\t<p>%s</p>\n", HANDLER.getCustomer()[5]);
    document += String.format("\t\t\t\t<p>%s</p>\n", HANDLER.getCustomer()[6]);
    document += "\t\t\t</div>\n" +
      "\t\t</div>\n";
    return this;
  }

  public HTMLInvoicePrinter addInformation() {
    document += "\t\t<table class=\"information break\">\n" +
      "\t\t\t<thead>\n" +
      "\t\t\t\t<tr>\n" +
      "\t\t\t\t\t<th>Delivery</th>\n" +
      "\t\t\t\t\t<th>Transport</th>\n" +
      "\t\t\t\t\t<th>Packaging</th>\n" +
      "\t\t\t\t\t<th>Payment</th>\n" +
      "\t\t\t\t</tr>\n" +
      "\t\t\t</thead>\n" +
      "\t\t\t<tbody>\n" +
      "\t\t\t\t<tr>\n";
    document += String.format("\t\t\t\t\t<th>%s</th>\n", HANDLER.getInvoice()[2]);
    document += String.format("\t\t\t\t\t<th>%s</th>\n", HANDLER.getInvoice()[3]);
    document += String.format("\t\t\t\t\t<th>%s</th>\n", HANDLER.getInvoice()[4]);
    document += String.format("\t\t\t\t\t<th>%s</th>\n", HANDLER.getInvoice()[5]);
    document += "\t\t\t\t</tr>\n" +
      "\t\t\t</tbody>\n" +
      "\t\t</table>\n";
    return this;
  }

  public HTMLInvoicePrinter addItems() {
    document += "<table class=\"items break\">\n" +
      "\t\t\t\t<thead>\n" +
      "\t\t\t\t\t<tr>\n" +
      "\t\t\t\t\t\t<th>Quantity</th>\n" +
      "\t\t\t\t\t\t<th>Description</th>\n" +
      "\t\t\t\t\t\t<th>VAT %</th>\n" +
      "\t\t\t\t\t\t<th>Unit price</th>\n" +
      "\t\t\t\t\t\t<th>Discount 1</th>\n" +
      "\t\t\t\t\t\t<th>Discount 2</th>\n" +
      "\t\t\t\t\t</tr>\n" +
      "\t\t\t\t</thead>\n" +
      "\t\t\t\t<tbody>\n";

    for (Item item : HANDLER.getItems()) {
      document += "\t\t\t\t<tr>\n";
      document += String.format("\t\t\t\t\t<th>%s %d</th>\n", item.measureUnit(), item.quantity());
      document += String.format("\t\t\t\t\t<th>%s</th>\n", item.description());
      document += String.format("\t\t\t\t\t<th>%d</th>\n", item.vat());
      document += String.format("\t\t\t\t\t<th>%.2f&euro;</th>\n", item.price());
      document += String.format("\t\t\t\t\t<th>%.2f</th>\n", item.discount1());
      document += String.format("\t\t\t\t\t<th>%.2f</th>\n", item.discount2());
      document += "\t\t\t\t</tr>\n";
    }

    if (HANDLER.getNonDocumentedCost() != 0) {
      document += "\t\t\t\t<tr>\n" +
        "\t\t\t\t\t<th></th>\n" +
        "\t\t\t\t\t<th>Non documented cost</th>\n" +
        "\t\t\t\t\t<th></th>\n";
      document += String.format("\t\t\t\t\t<th>%.2f&euro;\n", HANDLER.getNonDocumentedCost());
      document += "\t\t\t\t\t<th></th>\n" +
        "\t\t\t\t\t<th></th>\n" +
        "\t\t\t\t</tr>\n";
      }

    if (HANDLER.getPackagingCost() != 0) {
      document += "\t\t\t\t<tr>\n" +
        "\t\t\t\t\t<th></th>\n" +
        "\t\t\t\t\t<th>Packaging cost</th>\n" +
        "\t\t\t\t\t<th></th>\n";
      document += String.format("\t\t\t\t\t<th>%.2f&euro;\n", HANDLER.getPackagingCost());
      document += "\t\t\t\t\t<th></th>\n" +
        "\t\t\t\t\t<th></th>\n" +
        "\t\t\t\t</tr>\n";
    }
    document += "\t\t\t</tbody>\n" +
      "\t\t</table>\n";
    return this;
  }

  public HTMLInvoicePrinter addCostInformation() {
    document += "\t\t<table class=\"cost-information\">\n" +
      "\t\t\t<thead>\n" +
      "\t\t\t\t<tr>\n" +
      "\t\t\t\t\t<th>Documented cost</th>\n" +
      "\t\t\t\t\t<th>Interests</th>\n" +
      "\t\t\t\t\t<th>Deposit</th>\n" +
      "\t\t\t\t\t<th>Total</th>\n" +
      "\t\t\t\t</tr>\n" +
      "\t\t\t</thead>\n" +
      "\t\t\t<tbody>\n" +
      "\t\t\t\t<tr>\n";
    document += String.format("\t\t\t\t\t<th>%.2f&euro;</th>\n", HANDLER.getDocumentedCost());
    document += String.format("\t\t\t\t\t<th>%.2f&euro;</th>\n", HANDLER.getInterests());
    document += String.format("\t\t\t\t\t<th>%.2f&euro;</th>\n", HANDLER.getDeposit());
    document += String.format("\t\t\t\t\t<th>%.2f&euro;</th>\n", HANDLER.calculate());
    document += "\t\t\t\t</tr>\n" +
      "\t\t\t</tbody>\n" +
      "\t\t</table>\n" +
      "\t</div>\n" +
      "\t<script src=\"js/main.js\"></script>\n" +
      "</body>\n" +
      "</html>";
    return this;
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
    return 0;
  }

  private void reset() {
    this.document = "<!DOCTYPE html>\n" +
      "<html lang=\"en\">\n" +
      "<head>\n" +
      "\t<meta charset=\"UTF-8\">\n" +
      "\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
      "\t<title>Invoice n. 123 to Example</title>\n" +
      "\t<link rel=\"stylesheet\" href=\"css/style.css\">\n" +
      "</head>\n" +
      "<body>\n" +
      "\t<div class=\"document\">\n";
  }
}