package com.artiomastashonak.schoolaccountingstudio;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class TextInput extends JTextField {

    public TextInput(Font font, Color textColor, Color backgroundColor) {
        setBackground(backgroundColor);
        setForeground(textColor);
        setFont(font);

    }

}