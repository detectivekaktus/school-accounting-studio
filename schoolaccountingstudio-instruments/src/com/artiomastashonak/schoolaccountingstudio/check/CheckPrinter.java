// Copyright 2023-2024 Artiom Astashonak. Use of this code is governed by the Apache License 2.0 that can be found in the LICENSE file.
package com.artiomastashonak.schoolaccountingstudio.check;

/**
 * The {@code CheckPrinter} object is a facade object used to redirect API calls
 * to the {@link CheckXMLPrinter} and {@link CheckHTMLPrinter} printers for the
 * bank checks.
 * 
 * @see CheckXMLPrinter
 * @see CheckHTMLPrinter
 * 
 * @author Artiom Astashonak
 */
public final class CheckPrinter {
  private CheckPrinter() { }

  /**
   * Prints a bank check in the {@code generated/checks/} directory with all its
   * dependencies.
   * <p>
   * In the case of XML printing, generates an XML file containing all necessary information.
   * <p>
   * In the case of HTML printing generates a directory with HTML file being the check, CSS
   * being the style parameters, and JS file for the document scripting.
   * 
   * @param mode print mode. 0 for XML, 1 for HTML.
   * @return 0 if successful, -1 otherwise
   */
  public static int print(int mode) {
    return 0;
  }
}