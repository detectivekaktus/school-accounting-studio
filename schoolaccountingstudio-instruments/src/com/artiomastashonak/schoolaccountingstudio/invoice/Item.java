package com.artiomastashonak.schoolaccountingstudio.invoice;

public record Item(String measureUnit,
                   int quantity,
                   String code,
                   String description,
                   short vat,
                   double price,
                   double discount1,
                   double discount2) { }