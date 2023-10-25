package com.artiomastashonak.schoolaccountingstudio.resources.colors;

public enum DarkThemeColors {

    WINDOW_BACKGROUND_COLOR(54, 54, 54, 1.0f),
    TITLE_BAR_BACKGROUND_COLOR(37, 37, 37, 1.0f),
    SECONDARY_WINDOW_BACKGROUND_COLOR(71, 71, 71, 1.0f),

    TITLE_PRIMARY_TEXT_COLOR(90, 90, 90, 1.0f),
    PRIMARY_TEXT_COLOR(255, 255, 255, 1.0f),
    LIGHT_TEXT_COLOR(189, 189, 189, 1.0f),
    DARK_TEXT_COLOR(155, 155, 155, 1.0f),

    VIOLET_PRIMARY_ACCENT_COLOR(149, 88, 249, 1.0f),
    VIOLET_SECONDARY_ACCENT_COLOR(194, 156, 255, 1.0f),
    VIOLET_TERTIARY_ACCENT_COLOR(149, 88,249, 0.25f),

    BLUE_PRIMARY_ACCENT_COLOR(88, 114, 249, 1.0f),
    BLUE_SECONDARY_ACCENT_COLOR(108, 128, 234, 1.0f),
    BLUE_TERTIARY_ACCENT_COLOR(88, 114, 249, 0.25f);

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