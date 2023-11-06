package com.artiomastashonak.schoolaccountingstudio;

public enum TextSizes {

    SECTION_TITLE_TEXT_SIZE(50),
    WELCOME_ACTION_BUTTONS_TEXT_SIZE(35),
    SUBSECTION_TITLE_TEXT_SIZE(40),
    ELEMENT_TITLE_TEXT_SIZE(27),
    BUTTON_TEXT_SIZE(18),
    MENU_BAR_TEXT_SIZE(15);

    public int size;

    TextSizes(int size) {
        this.size = size;
    }

}