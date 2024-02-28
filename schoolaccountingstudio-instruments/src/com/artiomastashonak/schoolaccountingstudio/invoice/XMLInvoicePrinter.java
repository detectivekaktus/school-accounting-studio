// Copyright 2023-2024 Artiom Astashonak. Use of this code is governed by the Apache License 2.0 that can be found in the LICENSE file.
package com.artiomastashonak.schoolaccountingstudio.invoice;

import com.artiomastashonak.schoolaccountingstudio.printing.Printer;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The {@code XMLInvoicePrinter} class deines a {@link Printer} inherited
 * object to invoke printing an XML file representing an invoice requested
 * by user actions on the user interface.
 * <p>
 * To print the invoice correctly, you need to invoke the print methods in the
 * following order:
 * <ol>
 *   <li>{@code addDate();}</li>
 *   <li>{@code addSeller();}</li>
 *   <li>{@code addCustomer();}</li>
 *   <li>{@code addDelivery();}</li>
 *   <li>{@code addTransport();}</li>
 *   <li>{@code addPackaging();}</li>
 *   <li>{@code addPayment();}</li>
 *   <li>{@code addItems();}</li>
 *   <li>{@code addINonDocumentedCost();}</li>
 *   <li>{@code addPackagingCost();}</li>
 *   <li>{@code addDocumentedCost();}</li>
 *   <li>{@code addInterests();}</li>
 *   <li>{@code addDeposit();}</li>
 *   <li>{@code addTotal();}</li>
 *   <li>{@code endFile();}</li>
 * </ol>
 *
 * @see Printer
 * @see InvoiceHandler
 *
 * @author Artiom Astashonak
 */
public class XMLInvoicePrinter extends Printer {
  private final InvoiceHandler HANDLER;
  private String document = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + "<invoice>\n";

  /**
   * Constructs a new {@code XMLInvoicePrinter} object with initial handler setup.
   *
   * @param handler the {@link InvoiceHandler} object containing the invoice data
   */
  public XMLInvoicePrinter(InvoiceHandler handler) {
      this.HANDLER = handler;
  }

  /**
   * Appends number information of the current invoice to the document.
   *
   * @return the current object
   */
  public XMLInvoicePrinter addNumber() {
    document += String.format("\t<number value=\"%s\"/>\n", HANDLER.getInvoice()[0]);
    return this;
  }

  /**
   * Appends date information of the current invoice to the document.
   *
   * @return the current object
   */
  public XMLInvoicePrinter addDate() {
    document += String.format("\t<date value=\"%s\"/>\n", HANDLER.getInvoice()[1]);
    return this;
  }

  /**
   * Appends seller information of the current invoice to the document.
   *
   * @return the current object
   */
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

  /**
   * Appends customer information of the current invoice to the document.
   *
   * @return the current object
   */
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

  /**
   * Appends delivery information of the current invoice to the document.
   *
   * @return the current object
   */
  public XMLInvoicePrinter addDelivery() {
    document += String.format("\t<delivery value=\"%s\"/>\n", HANDLER.getInvoice()[2]);
    return this;
  }

  /**
   * Appends transport information of the current invoice to the document.
   *
   * @return the current object
   */
  public XMLInvoicePrinter addTransport() {
    document += String.format("\t<transport value=\"%s\"/>\n", HANDLER.getInvoice()[3]);
    return this;
  }

  /**
   * Appends packaging information of the current invoice to the document.
   *
   * @return the current object
   */
  public XMLInvoicePrinter addPackaging() {
    document += String.format("\t<packaging value=\"%s\"/>\n", HANDLER.getInvoice()[4]);
    return this;
  }

  /**
   * Appends payment information of the current invoice to the document.
   *
   * @return the current object
   */
  public XMLInvoicePrinter addPayment() {
    document += String.format("\t<payment value=\"%s\"/>\n", HANDLER.getInvoice()[5]);
    return this;
  }

  /**
   * Appends items information of the current invoice to the document.
   *
   * @return the current object
   */
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

  /**
   * Appends non-documented cost of the current invoice to the document.
   *
   * @return the current object
   */
  public XMLInvoicePrinter addNonDocumentedCost() {
    document += String.format("\t<nonDocumentedCost value=\"%.2f\"/>\n", HANDLER.getNonDocumentedCost());
    return this;
  }

  /**
   * Appends packaging cost of the current invoice to the document.
   *
   * @return the current object
   */
  public XMLInvoicePrinter addPackagingCost() {
    document += String.format("\t<packagingCost value=\"%.2f\"/>\n", HANDLER.getPackagingCost());
    return this;
  }

  /**
   * Appends documented cost of the current invoice to the document.
   *
   * @return the current object
   */
  public XMLInvoicePrinter addDocumentedCost() {
    document += String.format("\t<documentedCost value=\"%.2f\"/>\n", HANDLER.getDocumentedCost());
    return this;
  }

  /**
   * Appends interests of the current invoice to the document.
   *
   * @return the current object
   */
  public XMLInvoicePrinter addInterests() {
    document += String.format("\t<interests value=\"%.2f\"/>\n", HANDLER.getInterests());
    return this;
  }

  /**
   * Appends deposit of the current invoice to the document.
   *
   * @return the current object
   */
  public XMLInvoicePrinter addDeposit() {
    document += String.format("\t<deposit value=\"%.2f\"/>\n", HANDLER.getDeposit());
    return this;
  }

  /**
   * Appends invoice total of the current invoice to the document.
   *
   * @return the current object
   */
  public XMLInvoicePrinter addTotal() {
    document += String.format("\t<total value=\"%.2f\"/>\n", HANDLER.calculate());
    return this;
  }

  /**
   * Ends file.
   */
  public void endFile() {
    document += "</invoice>";
  }

  /**
   * Prints the document.
   * <p>
   * This process consists in the following parts:
   * <ol>
   *   <li>Creates a new file with <strong>{@code invoice_n_INVOICE_NUMBER_to_CUSTOMER_NAME}</strong>
   *   inside the <strong>generated/invoice/xml</strong> path.</li>
   *   <li>Opens the generated file.</li>
   * </ol>
   * <p>
   * If during this process a problem occurs, the generated file gets deleted and
   * returns -1.
   *
   * @return 0 if the invoice is printed successfully, -1 if the invoice wasn't printed
   */
  @Override
  public int print() {
    String outputDirectory = "generated/invoices/xml";
    File outputDir = new File(outputDirectory);
    outputDir.mkdirs();
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(outputDirectory + String.format("/invoice_n_%s_to_%s", HANDLER.getInvoice()[0], HANDLER.getCustomer()[0]) + ".xml"));
      writer.write(document);
      writer.close();
    } catch (Exception e) {
      new File(outputDirectory + String.format("/invoice_n_%s_to_%s", HANDLER.getInvoice()[0], HANDLER.getCustomer()[0]) + ".xml").delete();
      reset();
      return -1;
    }
    reset();
    try {
      Desktop.getDesktop().open(new File(outputDirectory + "/" + String.format("invoice_n_%s_to_%s", HANDLER.getInvoice()[0], HANDLER.getCustomer()[0]) + ".xml"));
    } catch (IOException ignored) { }
    return 0;
  }

  /**
   * Resets the object to its initial state.
   */
  @Override
  protected void reset() {
    this.document = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + "<invoice>\n";
  }
}