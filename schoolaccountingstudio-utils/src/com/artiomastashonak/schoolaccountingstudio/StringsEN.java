package com.artiomastashonak.schoolaccountingstudio;

public enum StringsEN {

    APPLICATION_NAME("School Accounting Studio"),
    APPLICATION_VERSION("Version 0.0.0"),
    WELCOME_MESSAGE("Welcome to School Accounting Studio"),

    WELCOME_DIALOG_MESSAGE("You are using free and open source application developed by Artiom Astashonak for High School \"Guglielmo Oberdan\" in Treviglio."),

    FILE_MANAGER_TITLE("File manager"),

    INVOICE_SECTION_TITLE("Invoices"),
    INVOICE_CREATE_BUTTON_ACTION("Create new invoice"),

    BUTTON_CLOSE_ACTION("Close"),
    BUTTON_CREDITS_ACTION("Credits"),
    BUTTON_GITHUB_ACTION("Visit GitHub"),
    BUTTON_DONE_ACTION("Done"),
    BUTTON_PRINT_ACTION("Print");

    public final String value;

    StringsEN(String value) {
        this.value = value;
    }

}