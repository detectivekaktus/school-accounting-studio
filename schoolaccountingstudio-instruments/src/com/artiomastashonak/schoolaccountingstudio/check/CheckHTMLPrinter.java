// Copyright 2023-2024 Artiom Astashonak. Use of this code is governed by the Apache License 2.0 that can be found in the LICENSE file.
package com.artiomastashonak.schoolaccountingstudio.check;

import com.artiomastashonak.schoolaccountingstudio.printing.Printer;

/**
 * The {@code CheckHTMLPrinter} inherited from {@link Printer} object represents
 * a printing API to print bank checks in HTML format.
 * <p>
 * Providing sufficient amount of data, it can print the check requested by the user.
 */
public class CheckHTMLPrinter extends Printer {
  /**
   * Writes a string literal into the file and closes the file.
   *
   * @return 0 if success; -1 if failure
   */
  @Override
  public int print() {
    return 0;
  }

  /**
   * Resets a string literal to its initial state.
   */
  @Override
  protected void reset() {

  }
}
