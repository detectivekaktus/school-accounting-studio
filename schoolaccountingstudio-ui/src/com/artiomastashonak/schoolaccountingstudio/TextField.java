package com.artiomastashonak.schoolaccountingstudio;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
public class TextField extends JTextField {

    public TextField(Color backgroundColor, Color foregroundColor, Font font) {
        setBackground(backgroundColor);
        setForeground(foregroundColor);
        setFont(font);
        setBorder(null);
    }

}