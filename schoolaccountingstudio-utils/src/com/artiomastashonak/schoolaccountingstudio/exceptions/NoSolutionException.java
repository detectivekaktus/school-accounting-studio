// Copyright 2023-2024 Artiom Astashonak. Use of this code is governed by the Apache License 2.0 that can be found in the LICENSE file.
package com.artiomastashonak.schoolaccountingstudio.exceptions;

/**
 * The {@code NoSolutionException} is thrown when a calculation operation
 * cannot be finished and return a numeric result.
 * The {@code NoSolutionException} objects can be thrown only by components of
 * {@code com.artiomastashonak.schoolaccountingstudio} package and its subpackages.
 *
 * @see Exception
 *
 * @author Artiom Astashonak
 */
public class NoSolutionException extends Exception {
  /**
   * Constructs a new {@code NoSolutionException} with no details message
   * specified.
   */
  public NoSolutionException() { }

  /**
   * Constructs a new {@code NoSolutionException} with a details message
   * passed as a parameter.
   * @param message the details message
   */
  public NoSolutionException(String message) {
    super(message);
  }
}