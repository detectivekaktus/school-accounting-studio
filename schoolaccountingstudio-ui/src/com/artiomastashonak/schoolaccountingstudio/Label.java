package com.artiomastashonak.schoolaccountingstudio;

import org.jetbrains.annotations.Nullable;
import javax.swing.JLabel;
import java.awt.Color;

public class Label extends JLabel {

    public Label(String text, Color textColor, @Nullable Color backgroundColor) {
        setHorizontalAlignment(LEFT);
        setVerticalAlignment(TOP);
        setForeground(textColor);
        setBackground(backgroundColor);
        setText(text);
    }

}