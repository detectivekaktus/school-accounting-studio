package com.artiomastashonak.schoolaccountingstudio;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Button extends JButton {

    public Button(String text, Color backogrundColor, Color textColor) {
        setText(text);
        setBackground(backogrundColor);
        setForeground(textColor);
    }

    public Button(ImageIcon icon, Color backgroundColor) {
        setIcon(icon);
        setBackground(backgroundColor);
    }

    public Button(ImageIcon icon, String text, Color backgroundColor, Color textColor) {
        setIcon(icon);
        setText(text);
        setBackground(backgroundColor);
        setForeground(textColor);
    }

}