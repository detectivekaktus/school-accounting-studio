// Copyright 2023-2024 Artiom Astashonak. Use of this code is governed by the Apache License 2.0 that can be found in the LICENSE file.
package com.artiomastashonak.schoolaccountingstudio.printing;

/**
 * An abstract class for writing string literals into the files.
 * The must-to-implement methods for objects extending the {@code Printer}
 * class are {@code public int print()} and {@code protected void reset()}.
 *
 * @author Artiom Astashonak
 */
public abstract class Printer {
  /**
   * Writes a string literal into the file and closes the file.
   *
   * @return 0 if success; -1 if failure
   */
  public abstract int print();

  /**
   * Resets a string literal to its initial state.
   */
  protected abstract void reset();
}