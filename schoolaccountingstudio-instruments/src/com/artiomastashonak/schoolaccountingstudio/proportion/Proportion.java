package com.artiomastashonak.schoolaccountingstudio.proportion;

import com.artiomastashonak.schoolaccountingstudio.exceptions.NoSolutionException;

public class Proportion {
  private double a = 0;
  private double b = 0;
  private double c = 0;
  private double d = 0;

  public Proportion() { }

  public Proportion(double a, double b, double c, double d) {
    this.a = a;
    this.b = b;
    this.c = c;
    this.d = d;
  }

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

  private double findA() {
    return (b * c) / d;
  }

  private double findB() {
    return (a * d) / c;
  }

  private double findC() {
    return (a * d) / b;
  }

  private double findD() {
    return (b * c) / a;
  }

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