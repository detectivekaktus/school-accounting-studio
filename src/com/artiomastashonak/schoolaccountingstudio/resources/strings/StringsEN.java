package com.artiomastashonak.schoolaccountingstudio.resources.strings;

public enum StringsEN {

    APPLICATION_NAME("School Accounting Studio"),

    WELCOME_MESSAGE("Welcome to School Accounting Studio"),
    WELCOME_MESSAGE_DESCRIPTION("You are using a free and open source application developed by Artiom Astashonak for High School \"Guglielmo Oberdan\" in Treviglio.\n\n For more information, you can visit the GitHub page of the application.\n\n In case you are interested in seeing the creators and contributors of this application, you can see them on GitHub, or you can click the button below."),

    BTN_CLOSE_MESSAGE("Close"),
    BTN_CREDITS("See credits"),
    BTN_GITHUB("Visit GitHub"),
    BTN_NEW_INVOICE("Create a new invoice");

    public final String value;

    StringsEN(String value) {
        this.value = value;
    }

}