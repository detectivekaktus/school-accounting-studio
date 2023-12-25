package com.artiomastashonak.schoolaccountingstudio;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class TextInput extends JTextField {

    public TextInput(Color backgroundColor, Color textColor, Font font) {
        setBackground(backgroundColor);
        setForeground(textColor);
        setFont(font);

    }

}