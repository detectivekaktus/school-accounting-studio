package com.artiomastashonak.schoolaccountingstudio;

public enum StringsEN {

    APPLICATION_NAME("School Accounting Studio"),
    APPLICATION_VERSION("Version 0.0.0"),
    WELCOME_MESSAGE("Welcome to School Accounting Studio"),

    WELCOME_DIALOG_MESSAGE("You are using free and open source application developed by Artiom Astashonak for High School \"Guglielmo Oberdan\" in Treviglio."),

    FILE_MANAGER_TITLE("File manager"),
    FILE_MANAGER_NO_ITEMS("Nothing to show here..."),

    INVOICE_CREATE_BUTTON_ACTION("Create new invoice"),
    INVOICE_INFORMATION_TITLE("Information"),
    INVOICE_SELLER_AND_CUSTOMER_TITLE("Seller and customer"),
    INVOICE_SELLER_TITLE("Seller"),
    INVOICE_CUSTOMER_TITLE("Customer"),
    INVOICE_INVOICE_TITLE("Invoice"),
    INVOICE_NUMBER_TITLE("Number"),
    INVOICE_EMISSION_DATE_TITLE("Emission date"),
    INVOICE_EXPIRE_DATE_TITLE("Expire date"),
    INVOICE_TYPE_TITLE("Type"),
    INVOICE_DELIVERY_TITLE("Delivery"),
    INVOICE_DELIVERY_TYPE_TITLE("Type"),
    INVOICE_DELIVERY_DATE_TITLE("Date"),
    INVOICE_TRANSPORT_TITLE("Transport"),
    INVOICE_TRANSPORT_TYPE_TITLE("Type"),
    INVOICE_TRANSPORT_ADDITIONAL_INFO_TITLE("Additional info"),
    INVOICE_TRANSPORT_COMPANY_TITLE("Company"),
    INVOICE_PACKAGING_TITLE("Packaging"),
    INVOICE_PACKAGING_TYPE_TITLE("Type"),
    INVOICE_PAYMENT_TITLE("Payment"),
    INVOICE_PAYMENT_TYPE_TITLE("Type"),
    INVOICE_PAYMENT_METHOD_TITLE("Method"),
    INVOICE_PAYMENT_BANK_NAME_TITLE("Bank name"),
    INVOICE_PAYMENT_BANK_ACCOUNT_NUMBER_TITLE("Bank account number"),
    INVOICE_ITEMS_TITLE("Items"),
    INVOICE_COSTS_TITLE("Costs"),
    INVOICE_PACKAGING_COST_TITLE("Packaging cost"),
    INVOICE_BILLED_PACKAGING_COST_TITLE("Billed packaging cost"),
    INVOICE_BAILED_PACKAGING_COST_TITLE("Bailed packaging cost"),
    INVOICE_DOCUMENTED_COSTS_TITLE("Documented/non documented costs"),
    INVOICE_NON_DOCUMENTED_COST_TITLE("Non documented cost"),
    INVOICE_DOCUMENTED_COST_TITLE("Documented cost"),
    INVOICE_INTEREST_TITLE("Interest"),
    INVOICE_INTEREST_VALUE_TITLE("Interest value"),
    INVOICE_VAT_INCLUDED_TITLE("Vat included"),
    INVOICE_SUBTOTAL_TITLE("Subtotal: "),
    INVOICE_TOTAL_TITLE("Total: "),

    BUTTON_CLOSE_ACTION("Close"),
    BUTTON_CREDITS_ACTION("Credits"),
    BUTTON_GITHUB_ACTION("Visit GitHub"),
    BUTTON_DONE_ACTION("Done"),
    BUTTON_PRINT_ACTION("Print"),
    BUTTON_ADD_ACTION("Add"),
    BUTTON_IMPORT_ACTION("Import"),
    BUTTON_EDIT_ACTION("Edit"),
    BUTTON_DELETE_ACTION("Delete");

    public final String value;

    StringsEN(String value) {
        this.value = value;
    }

}