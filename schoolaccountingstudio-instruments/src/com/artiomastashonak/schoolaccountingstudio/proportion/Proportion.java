// Copyright 2023-2024 Artiom Astashonak. Use of this code is governed by the Apache License 2.0 that can be found in the LICENSE file.
package com.artiomastashonak.schoolaccountingstudio.proportion;

import com.artiomastashonak.schoolaccountingstudio.exceptions.NoSolutionException;

/**
 * The {@code Proportion} class defines an arithmetic proportion with parameters
 * and methods to be solved if soluble.
 *
 * @author Artiom Astashonak
 */
public class Proportion {
  private double a = 0;
  private double b = 0;
  private double c = 0;
  private double d = 0;

  /**
   * Assembles a new {@code Proportion} object with no class variables set up.
   */
  public Proportion() { }

  /**
   * Constructs a new {@code Proportion} object with proportion's terms set up.
   * If a term is undefined, it must be set to 0.
   *
   * @param a a-term
   * @param b b-term
   * @param c c-term
   * @param d d-term
   */
  public Proportion(double a, double b, double c, double d) {
    this.a = a;
    this.b = b;
    this.c = c;
    this.d = d;
  }

  /**
   * Solves the current {@code Proportion} object.
   *
   * @return value of unknown term
   * @throws NoSolutionException if the proportion is either defined or can't be solved
   */
  public double solve() throws NoSolutionException {
    int termsToBeFound = 0;
    for (double value : new double[]{a, b, c, d}) {
      if (value == 0) termsToBeFound++;
    }
    if (termsToBeFound != 1) throw new NoSolutionException("The terms of the proportion are either defined or unsolvable.");
    if (a == 0) return findA();
    if (b == 0) return findB();
    if (c == 0) return findC();
    if (d == 0) return findD();
    return Double.NaN;
  }

  /**
   * @return a-term value
   */
  private double findA() {
    return (b * c) / d;
  }

  /**
   * @return b-term value
   */
  private double findB() {
    return (a * d) / c;
  }

  /**
   * @return c-term value
   */
  private double findC() {
    return (a * d) / b;
  }

  /**
   * @return d-term value
   */
  private double findD() {
    return (b * c) / a;
  }

  /**
   * Resets the current object to its initial state.
   */
  public void reset() {
    this.a = 0;
    this.b = 0;
    this.c = 0;
    this.d = 0;
  }

  public double getA() {
    return a;
  }

  public void setA(double a) {
    this.a = a;
  }

  public double getB() {
    return b;
  }

  public void setB(double b) {
    this.b = b;
  }

  public double getC() {
    return c;
  }

  public void setC(double c) {
    this.c = c;
  }

  public double getD() {
    return d;
  }

  public void setD(double d) {
    this.d = d;
  }
}