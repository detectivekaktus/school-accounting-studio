// Copyright 2023-2024 Artiom Astashonak. Use of this code is governed by the Apache License 2.0 that can be found in the LICENSE file.
package com.artiomastashonak.schoolaccountingstudio.invoice;

/**
 * The {@code Item} record creates a new invoice item to be stored and
 * operated within invoice-calculating algorithms.
 *
 * @param measureUnit the measure unit of the item
 * @param quantity the quantity of the item
 * @param code the code of the item
 * @param description the description of the item
 * @param vat the vat percent value of the item
 * @param price the price of the item
 * @param discount1 the first discount percent value of the item
 * @param discount2 the second discount percent value of the item
 *
 * @author Artiom Astashonak
 */
public record Item(String measureUnit, int quantity, String code, String description, int vat, double price, double discount1, double discount2) { }