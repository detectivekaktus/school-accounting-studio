// Copyright 2023-2024 Artiom Astashonak. Use of this code is governed by the Apache License 2.0 that can be found in the LICENSE file.
package com.artiomastashonak.schoolaccountingstudio.invoice;

import com.artiomastashonak.schoolaccountingstudio.Parameters;
import com.artiomastashonak.schoolaccountingstudio.printing.Printer;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * The {@code HTMLInvoicePrinter} class defines a {@link Printer} inherited
 * object to invoke printing a web page representing an invoice requested
 * by the user actions on the user interface.
 * <p>
 * To print the invoice correctly, you need to invoke the print methods in the
 * following order:
 * <ol>
 *   <li>{@code addHeader();}</li>
 *   <li>{@code addSeller();}</li>
 *   <li>{@code addCustomer();}</li>
 *   <li>{@code addLegalInformation();}</li>
 *   <li>{@code addInformation();}</li>
 *   <li>{@code addItems();}</li>
 *   <li>{@code addVatInformation();}</li>
 *   <li>{@code addCostInformation();}</li>
 *   <li>{@code endFile();}</li>
 * </ol>
 *
 * @see Printer
 * @see InvoiceHandler
 *
 * @author Artiom Astashonak
 */
public class HTMLInvoicePrinter extends Printer {
  private final InvoiceHandler HANDLER;
  private String document;

  /**
   * Constructs a new {@code HTMLInvoicePrinter} object with initial document
   * parameters setup.
   *
   * @param handler the {@link InvoiceHandler} object containing the invoice data
   */
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

  /**
   * Appends a header containing the invoice number and the customer name
   * to the document.
   *
   * @return the current object
   */
  public HTMLInvoicePrinter addHeader() {
    document += String.format(String.format("\t\t<h1 class=\"header\">%s</h1>\n", Parameters.getBundle().getString("invoiceNTo")), HANDLER.getInvoice()[0], HANDLER.getCustomer()[0]);
    return this;
  }

  /**
   * Appends seller information to the document.
   *
   * @return the current object
   */
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

  /**
   * Appends customer information to the document.
   *
   * @return the current object
   */
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

  /**
   * Appends a document code and a recipient code to the document.
   *
   * @return the current object
   */
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

  /**
   * Appends delivery, transport, packaging, and payment information to the document.
   *
   * @return the current object
   */
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

  /**
   * Appends all the invoice items, non-documented cost and packaging cost to
   * the document.
   *
   * @return the current object
   */
  public HTMLInvoicePrinter addItems() {
    document += "\t\t<table class=\"items break\">\n" +
      "\t\t\t<thead>\n" +
      "\t\t\t\t<tr>\n" +
      String.format("\t\t\t\t\t<th>%s</th>\n", Parameters.getBundle().getString("code")) +
      String.format("\t\t\t\t\t<th>%s</th>\n", Parameters.getBundle().getString("quantity")) +
      String.format("\t\t\t\t\t<th>%s</th>\n", Parameters.getBundle().getString("description")) +
      String.format("\t\t\t\t\t<th>%s</th>\n", Parameters.getBundle().getString("VATPercent")) +
      String.format("\t\t\t\t\t<th>%s</th>\n", Parameters.getBundle().getString("unitPrice")) +
      String.format("\t\t\t\t\t<th>%s</th>\n", Parameters.getBundle().getString("discount1")) +
      String.format("\t\t\t\t\t<th>%s</th>\n", Parameters.getBundle().getString("discount2")) +
      "\t\t\t\t</tr>\n" +
      "\t\t\t</thead>\n" +
      "\t\t\t<tbody>\n";

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

  /**
   * Appends VAT values and calculations to the document.
   *
   * @return the current object
   */
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

  /**
   * Appends documented cost, interest, deposit, and invoice total values to
   * the document.
   *
   * @return the current object
   */
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

  /**
   * Ends the file.
   */
  public void endFile() {
    document += "\t</div>\n" +
      "\t<script src=\"js/main.js\"></script>\n" +
      "</body>\n" +
      "</html>";
  }

  /**
   * Prints the document.
   * <p>
   * This process consists in the following parts:
   * <ol>
   *   <li>Creates a directory with <strong>{@code invoice_n_INVOICE_NUMBER_to_CUSTOMER_NAME}</strong>
   *   inside the <strong>generated/invoice/html</strong> path.</li>
   *   <li>Inside the document root directory creates <strong>css</strong> and <strong>js</strong>
   *   directories.</li>
   *   <li>Creates an HTML file with name
   *   <strong>{@code invoice_n_INVOICE_NUMBER_to_CUSTOMER_NAME}</strong> and writes to it
   *   inside the document root directory.</li>
   *   <li>Creates a <strong>{@code style.css}</strong> file within the <strong>css</strong>
   *   subdirectory of the document root directory.</li>
   *   <li>Creates a <strong>{@code main.js}</strong> file within the <strong>js</strong>
   *   subdirectory of the document root directory.</li>
   *   <li>Opens the HTML file previously generated with user's default browser.</li>
   * </ol>
   * <p>
   * If during this process a problem occurs, all the generated files with the document
   * root directory get deleted and returns -1.
   *
   * @return 0 if the invoice is printed successfully, -1 if the invoice wasn't printed
   */
  @Override
  public int print() {
    String documentName = String.format("invoice_n_%s_to_%s", HANDLER.getInvoice()[0], HANDLER.getCustomer()[0]);
    String outputDirectory = "generated/invoices/html";
    try {
      new File(outputDirectory + "/" + documentName).mkdirs();
      new File(outputDirectory + "/" + documentName + "/css").mkdirs();
      new File(outputDirectory + "/" + documentName + "/js").mkdirs();

      var htmlWriter = new BufferedWriter(new FileWriter(outputDirectory + "/" + documentName + "/" + documentName + ".html"));
      htmlWriter.write(document);
      htmlWriter.close();

      var cssWriter = new BufferedWriter(new FileWriter(outputDirectory + "/" + documentName + "/css/style.css"));
      cssWriter.write("""
        @import url('https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap');
                
        :root {
            --primary-color: #34ebcf;
            --accent-color: #11806f;
            --text-color: #000000;
            --bright-text-color: #ffffff;
            --white-accent-color: #e7e7e7;
            --disabled-color: #bdbdbd;
        }
                
        * {
            margin: 0;
            padding: 0;
            border: none;
            font-family: 'Roboto', sans-serif;
        }
                
        .break {
            margin-bottom: 1em;
        }
                
        table {
            border-collapse: collapse;
            width: 100%;
            border-radius: 5px 5px 0 0;
            overflow: hidden;
        }
                
        table thead {
            font-size: 1.5em;
            font-weight: 600;
            background-color: var(--accent-color);
            color: var(--bright-text-color);
        }
                
        table tr,
        table th,
        table td {
            padding: .5em .5em;
            border-bottom: 1px solid var(--disabled-color);
        }
                
        .document {
            margin: 0 auto;
            width: 66%;
            padding: .5em;
            box-shadow: 0 0 20px rgba(0, 0, 0, .25);
            border-bottom: 1px solid var(--disabled-color);
            overflow: hidden;
        }
                
        .header {
            display: flex;
            font-size: 2rem;
            font-weight: 800;
            color: var(--text-color);
            justify-content: flex-end;
        }
                
        .seller-customer {
            display: flex;
            justify-content: space-between;
            font-size: 1.5em;
        }
                
        .seller-customer h3 {
            font-weight: 800;
            color: var(--accent-color);
        }
                
        .seller {
            text-align: left;
        }
                
        .customer {
            text-align: right;
        }
                
        .items tbody tr:nth-of-type(even) {
            background-color: var(--white-accent-color);
        }
                
        @media print {
            .document {
                padding: 0;
                width: 100%;
            }
                
            .seller-customer {
                font-size: 1em;
            }
                
            .seller-customer h3 {
                font-weight: 800;
                font-size: 1.15em;
                color: var(--accent-color);
            }
                
            table thead {
                font-size: 1.2em;
            }
        }
        """);
      cssWriter.close();

      var jsWriter = new BufferedWriter(new FileWriter(outputDirectory + "/" + documentName + "/js/main.js"));
      jsWriter.write(String.format("""
        let toBePrinted = confirm("%s");
        if (toBePrinted) {
         print();
        }
        """, Parameters.getBundle().getString("printToPDF")));
      jsWriter.close();
    } catch (Exception e) {
      new File(outputDirectory + "/" + documentName + "/" + documentName + ".html").delete();
      new File(outputDirectory + "/" + documentName + "/css/style.css").delete();
      new File(outputDirectory + "/" + documentName + "/js/main.js").delete();
      new File(outputDirectory + "/" + documentName).delete();
      reset();
      return -1;
    }
    reset();
    try {
      Desktop.getDesktop().open(new File(outputDirectory + "/" + documentName + "/" + documentName + ".html"));
    } catch (IOException ignored) { }
    return 0;
  }

  /**
   * Resets the object to its initial state.
   */
  @Override
  protected void reset() {
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