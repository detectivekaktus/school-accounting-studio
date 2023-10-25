package com.artiomastashonak.schoolaccountingstudio;

public enum DarkThemeColors {

    MAIN_WINDOW_BACKGROUND_COLOR(54, 54, 54, 1.0f),
    MENU_BAR_BACKGROUND_COLOR(37, 37, 37, 1.0f),
    POP_UP_WINDOW_BACKGROUND_COLOR(71, 71, 71, 1.0f),
    BUTTON_BACKGROUND_COLOR(90, 90, 90, 1.0f),
    SELECTED_BUTTON_BACKGROUND_COLOR(95, 95, 95, 1.0f),
    TEXT_ENTRY_BACKGROUND_COLOR(56, 56, 56, 1.0f),

    PRIMARY_TEXT_COLOR(255, 255, 255, 1.0f),
    SECONDARY_TEXT_COLOR(155, 155, 155, 1.0f),
    TERTIARY_TEXT_COLOR(207, 207, 207, 1.0f),

    VIOLET_PRIMARY_ACCENT_COLOR(149, 88, 249, 1.0f),
    VIOLET_SECONDARY_ACCENT_COLOR(194, 156, 255, 1.0f),
    VIOLET_TERTIARY_ACCENT_COLOR(149, 88, 249, 0.25f),

    DANGER_COLOR(250, 89, 89, 1.0f);

    public final int red;
    public final int green;
    public final int blue;
    public final float alpha;

    DarkThemeColors(int red, int green, int blue, float alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }

}