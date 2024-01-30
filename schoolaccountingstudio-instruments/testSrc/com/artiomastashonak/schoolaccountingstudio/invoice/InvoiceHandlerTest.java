package com.artiomastashonak.schoolaccountingstudio.invoice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InvoiceHandlerTest {
  @DisplayName("Expected result: 554.40")
  @Test
  void firstOnlyCalculationTest() {
    InvoiceHandler handler = new InvoiceHandler();
    handler.addItem(new Item("", 80, "", "", (short) 5, 2.25, 4.0, 0));
    handler.addItem(new Item("", 40, "", "", (short) 5, 2.30, 4.0, 0));
    handler.addItem(new Item("", 40, "", "", (short) 5, 3.20, 4.0, 0));
    handler.addItem(new Item("", 60, "", "", (short) 5, 2.50, 4.0, 0));
    Assertions.assertEquals(554.40, handler.calculate());
  }

  @DisplayName("Expected result: 2086.20")
  @Test
  void secondOnlyCalculationTest() {
    InvoiceHandler handler = new InvoiceHandler();
    handler.addItem(new Item("", 50, "", "", (short) 22, 6.20, 10, 5));
    handler.addItem(new Item("", 30, "", "", (short) 22, 26.60, 10, 5));
    handler.addItem(new Item("", 40, "", "", (short) 22, 22.30, 10, 5));
    Assertions.assertEquals(2086.20, handler.calculate());
  }

  @DisplayName("Expected result: 7942.00")
  @Test
  void thirdOnlyCalculationTest() {
    InvoiceHandler handler = new InvoiceHandler();
    handler.addItem(new Item("", 1250, "", "", (short) 10, 2.08, 5, 5));
    handler.addItem(new Item("", 625, "", "", (short) 10, 5.60, 5, 5));
    handler.addItem(new Item("", 400, "", "", (short) 10, 4.75, 5, 5));
    Assertions.assertEquals(7942.00, handler.calculate());
  }

  @DisplayName("Expected result: 5749.90")
  @Test
  void fourthOnlyCalculationTest() {
    InvoiceHandler handler = new InvoiceHandler();
    handler.addItem(new Item("", 20, "", "", (short) 4, 77, 20, 0));
    handler.addItem(new Item("", 40, "", "", (short) 4, 11.50, 20, 0));
    handler.addItem(new Item("", 80, "", "", (short) 22, 26.25, 20, 0));
    handler.addItem(new Item("", 50, "", "", (short) 22, 38, 20, 0));
    handler.setDocumentedCost(42.70);
    handler.setNonDocumentedCost(120);
    Assertions.assertEquals(5749.90, handler.calculate());
  }

  @DisplayName("Expected result: 3433.84")
  @Test
  void fifthOnlyCalculationTest() {
    InvoiceHandler handler = new InvoiceHandler();
    handler.addItem(new Item("", 150, "", "", (short) 10, 3.20, 10, 0));
    handler.addItem(new Item("", 200, "", "", (short) 10, 2.60, 10, 0));
    handler.addItem(new Item("", 32, "", "", (short) 22, 26.25, 10, 0));
    handler.addItem(new Item("", 80, "", "", (short) 22, 14.50, 10, 0));
    handler.setNonDocumentedCost(108);
    handler.setDocumentedCost(85.40);
    handler.setDeposit(35);
    Assertions.assertEquals(3433.84, handler.calculate());
  }

  @DisplayName("Expected result: 22205.39")
  @Test
  void sixthOnlyCalculationTest() {
    InvoiceHandler handler = new InvoiceHandler();
    handler.addItem(new Item("", 800, "", "", (short) 4, 3.75, 5, 0));
    handler.addItem(new Item("", 200, "", "", (short) 10, 50, 5, 0));
    handler.addItem(new Item("", 800, "", "", (short) 22, 8.75, 5, 0));
    handler.setNonDocumentedCost(380);
    handler.setDocumentedCost(103.70);
    handler.setInterests(144.15);
    Assertions.assertEquals(22205.39, handler.calculate());
  }

  @DisplayName("Expected result: 5471.70")
  @Test
  void firstDocumentedCostTest() {
    InvoiceHandler handler = new InvoiceHandler();
    handler.addItem(new Item("", 10, "", "", (short) 22, 260, 20, 10));
    handler.addItem(new Item("", 6, "", "", (short) 22, 300, 20, 10));
    handler.addItem(new Item("", 20, "", "", (short) 22, 80, 20, 10));
    handler.setDocumentedCost(201.30);
    Assertions.assertEquals(5471.70, handler.calculate());
  }

  @DisplayName("Expected result: 7521.46")
  @Test
  void secondDocumentedCostTest() {
    InvoiceHandler handler = new InvoiceHandler();
    handler.addItem(new Item("", 160, "", "", (short) 10, 15, 5, 0));
    handler.addItem(new Item("", 100, "", "", (short) 22, 40, 2, 0));
    handler.setNonDocumentedCost(155);
    handler.setDocumentedCost(48.80);
    Assertions.assertEquals(7521.46, handler.calculate());
  }

  @DisplayName("Expected result: 1664.08")
  @Test
  void firstNonDocumentedCostTest() {
    InvoiceHandler handler = new InvoiceHandler();
    handler.addItem(new Item("", 25, "", "", (short) 22, 23.20, 10, 0));
    handler.addItem(new Item("", 15, "", "", (short) 22, 33.50, 0, 0));
    handler.addItem(new Item("", 10, "", "", (short) 22, 29.95, 0, 0));
    handler.setNonDocumentedCost(40);
    Assertions.assertEquals(1664.08, handler.calculate());
  }

  @DisplayName("Expected result: 3745.40")
  @Test
  void secondNonDocumentedCostTest() {
    InvoiceHandler handler = new InvoiceHandler();
    handler.addItem(new Item("", 5, "", "", (short) 22, 178, 25, 0));
    handler.addItem(new Item("", 10, "", "", (short) 22, 205, 25, 0));
    handler.addItem(new Item("", 8, "", "", (short) 22, 135, 25, 0));
    handler.setNonDocumentedCost(55);
    Assertions.assertEquals(3745.40, handler.calculate());
  }

  @DisplayName("Expected result: 28017.30")
  @Test
  void firstBothCostsTest() {
    InvoiceHandler handler = new InvoiceHandler();
    handler.addItem(new Item("", 30, "", "", (short) 22, 260, 25, 0));
    handler.addItem(new Item("", 50, "", "", (short) 22, 310, 25, 4));
    handler.addItem(new Item("", 100, "", "", (short) 22, 75, 25, 0));
    handler.setNonDocumentedCost(120);
    handler.setDocumentedCost(256.20);
    Assertions.assertEquals(28017.30, handler.calculate());
  }

  @DisplayName("Expected result: 2370.46")
  @Test
  void firstPackagingCostTest() {
    InvoiceHandler handler = new InvoiceHandler();
    handler.addItem(new Item("", 40, "", "", (short) 22, 41, 5, 2));
    handler.addItem(new Item("", 5, "", "", (short) 22, 72, 5, 2));
    handler.setPackagingCost(81);
    Assertions.assertEquals(2370.46, handler.calculate());
  }

  @DisplayName("Expected result: 962.00")
  @Test
  void secondPackagingCostTest() {
    InvoiceHandler handler = new InvoiceHandler();
    handler.addItem(new Item("", 35, "", "", (short) 4, 6, 5, 0));
    handler.addItem(new Item("", 40, "", "", (short) 4, 3.75, 5, 0));
    handler.addItem(new Item("", 40, "", "", (short) 4, 7.20, 5, 0));
    handler.addItem(new Item("", 40, "", "", (short) 4, 6.30, 5, 0));
    handler.setPackagingCost(30);
    handler.setNonDocumentedCost(40);
    Assertions.assertEquals(962.00, handler.calculate());
  }

  @DisplayName("Expected result: 4309.46")
  @Test
  void firstInterestTest() {
    InvoiceHandler handler = new InvoiceHandler();
    handler.addItem(new Item("", 2, "", "", (short) 22, 580, 20, 5));
    handler.addItem(new Item("", 2, "", "", (short) 22, 1040, 20, 5));
    handler.addItem(new Item("", 4, "", "", (short) 22, 330, 20, 5));
    handler.setPackagingCost(38.40);
    handler.setInterests(34.58);
    Assertions.assertEquals(4309.46, handler.calculate());
  }

  @DisplayName("Expected result: 15501.22")
  @Test
  void secondInterestTest() {
    InvoiceHandler handler = new InvoiceHandler();
    handler.addItem(new Item("", 800, "", "", (short) 10, 1.15, 20, 0));
    handler.addItem(new Item("", 800, "", "", (short) 10, 1.35, 20, 0));
    handler.addItem(new Item("", 800, "", "", (short) 22, 6.25, 20, 0));
    handler.addItem(new Item("", 1200, "", "", (short) 22, 7.50, 20, 5));
    handler.setPackagingCost(311);
    handler.setDocumentedCost(79.30);
    handler.setInterests(62.50);
    Assertions.assertEquals(15501.22, handler.calculate());
  }

  @DisplayName("Expected result: 6473.60")
  @Test
  void firstDepositTest() {
    InvoiceHandler handler = new InvoiceHandler();
    handler.addItem(new Item("", 4, "", "", (short) 22, 449, 12, 0));
    handler.addItem(new Item("", 18, "", "", (short) 22, 75, 16, 0));
    handler.addItem(new Item("", 20, "", "", (short) 22, 142.70, 12, 0));
    handler.setNonDocumentedCost(54);
    handler.setDocumentedCost(32);
    Assertions.assertEquals(6473.60, handler.calculate());
  }

  @DisplayName("Expected result: 7363.83")
  @Test
  void secondDepositTest() {
    InvoiceHandler handler = new InvoiceHandler();
    handler.addItem(new Item("", 400, "", "", (short) 4, 7.50, 5, 0));
    handler.addItem(new Item("", 125, "", "", (short) 10, 1.6, 5, 0));
    handler.addItem(new Item("", 1600, "", "", (short) 10, 2.50, 5, 5));
    handler.setNonDocumentedCost(133);
    handler.setDeposit(37);
    handler.setInterests(39.95);
    Assertions.assertEquals(7363.83, handler.calculate());
  }
}