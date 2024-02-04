package com.artiomastashonak.schoolaccountingstudio.invoice;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class XMLInvoicePrinter {
  private final InvoiceHandler HANDLER;
  private String document = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + "<invoice>\n";

  public XMLInvoicePrinter(InvoiceHandler handler) {
      this.HANDLER = handler;
  }

  public XMLInvoicePrinter addNumber() {
    document += String.format("\t<number value=\"%s\"/>\n", HANDLER.getInvoice()[0]);
    return this;
  }

  public XMLInvoicePrinter addDate() {
    document += String.format("\t<date value=\"%s\"/>\n", HANDLER.getInvoice()[1]);
    return this;
  }

  public XMLInvoicePrinter addSeller() {
    document += "\t<seller>\n";
    document += String.format("\t\t<name value=\"%s\"/>\n", HANDLER.getSeller()[0]);
    document += String.format("\t\t<address value=\"%s\"/>\n", HANDLER.getSeller()[1]);
    document += String.format("\t\t<phone value=\"%s\"/>\n", HANDLER.getSeller()[2]);
    document += String.format("\t\t<email value=\"%s\"/>\n", HANDLER.getSeller()[3]);
    document += String.format("\t\t<vatNumber value=\"%s\"/>\n", HANDLER.getSeller()[4]);
    document += String.format("\t\t<register value=\"%s\"/>\n", HANDLER.getSeller()[5]);
    document += String.format("\t\t<capital value=\"%s\"/>\n", HANDLER.getSeller()[6]);
    document += "\t</seller>\n";
    return this;
  }

  public XMLInvoicePrinter addCustomer() {
    document += "\t<customer>\n";
    document += String.format("\t\t<name value=\"%s\"/>\n", HANDLER.getCustomer()[0]);
    document += String.format("\t\t<address value=\"%s\"/>\n", HANDLER.getCustomer()[1]);
    document += String.format("\t\t<phone value=\"%s\"/>\n", HANDLER.getCustomer()[2]);
    document += String.format("\t\t<email value=\"%s\"/>\n", HANDLER.getCustomer()[3]);
    document += String.format("\t\t<vatNumber value=\"%s\"/>\n", HANDLER.getSeller()[4]);
    document += String.format("\t\t<register value=\"%s\"/>\n", HANDLER.getCustomer()[5]);
    document += String.format("\t\t<capital value=\"%s\"/>\n", HANDLER.getCustomer()[6]);
    document += "\t</customer>\n";
    return this;
  }

  public XMLInvoicePrinter addDelivery() {
    document += String.format("\t<delivery value=\"%s\"/>\n", HANDLER.getInvoice()[2]);
    return this;
  }

  public XMLInvoicePrinter addTransport() {
    document += String.format("\t<transport value=\"%s\"/>\n", HANDLER.getInvoice()[3]);
    return this;
  }

  public XMLInvoicePrinter addPackaging() {
    document += String.format("\t<packaging value=\"%s\"/>\n", HANDLER.getInvoice()[4]);
    return this;
  }

  public XMLInvoicePrinter addPayment() {
    document += String.format("\t<payment value=\"%s\"/>\n", HANDLER.getInvoice()[5]);
    return this;
  }

  public XMLInvoicePrinter addItems() {
    document += "\t<items>\n";
    for (Item item : HANDLER.getItems()) {
      document += "\t\t<item>\n";
      document += String.format("\t\t\t<measureUnit value=\"%s\"/>\n", item.measureUnit());
      document += String.format("\t\t\t<quantity value=\"%d\"/>\n", item.quantity());
      document += String.format("\t\t\t<code value=\"%s\"/>\n", item.code());
      document += String.format("\t\t\t<description value=\"%s\"/>\n", item.description());
      document += String.format("\t\t\t<vat value=\"%d\"/>\n", item.vat());
      document += String.format("\t\t\t<unitPrice value=\"%.2f\"/>\n", item.price());
      document += String.format("\t\t\t<discount1 value=\"%.2f\"/>\n", item.discount1());
      document += String.format("\t\t\t<discount2 value=\"%.2f\"/>\n", item.discount2());
      document += "\t\t</item>\n";
    }
    document += "\t</items>\n";
    return this;
  }

  public XMLInvoicePrinter addNonDocumentedCost() {
    document += String.format("\t<nonDocumentedCost value=\"%.2f\"/>\n", HANDLER.getNonDocumentedCost());
    return this;
  }

  public XMLInvoicePrinter addPackagingCost() {
    document += String.format("\t<packagingCost value=\"%.2f\"/>\n", HANDLER.getPackagingCost());
    return this;
  }

  public XMLInvoicePrinter addDocumentedCost() {
    document += String.format("\t<documentedCost value=\"%.2f\"/>\n", HANDLER.getDocumentedCost());
    return this;
  }

  public XMLInvoicePrinter addInterests() {
    document += String.format("\t<interests value=\"%.2f\"/>\n", HANDLER.getInterests());
    return this;
  }

  public XMLInvoicePrinter addDeposit() {
    document += String.format("\t<deposit value=\"%.2f\"/>\n", HANDLER.getDeposit());
    return this;
  }

  public XMLInvoicePrinter addTotal() {
    document += String.format("\t<total value=\"%.2f\"/>\n", HANDLER.calculate());
    return this;
  }

  public int print() {
    document += "</invoice>";
    String outputDirectory = "generated/invoices/xml";
    File outputDir = new File(outputDirectory);
    outputDir.mkdirs();
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(outputDirectory + String.format("/invoice_n_%s_to_%s", HANDLER.getInvoice()[0], HANDLER.getCustomer()[0]) + ".xml"));
      writer.write(document);
      writer.close();
    } catch (Exception e) {
      reset();
      return -1;
    }
    reset();
    try {
      Desktop.getDesktop().open(new File(outputDirectory + "/" + String.format("invoice_n_%s_to_%s", HANDLER.getInvoice()[0], HANDLER.getCustomer()[0]) + ".xml"));
    } catch (IOException ignored) { }
    return 0;
  }

  private void reset() {
    this.document = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + "<invoice>\n";
  }
}