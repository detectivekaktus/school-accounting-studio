package com.artiomastashonak.schoolaccountingstudio.invoice;

public record Item(String measureUnit,
                   int quantity,
                   String code,
                   String description,
                   short vat,
                   double price,
                   float discount1,
                   float discount2) { }