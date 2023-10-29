package com.artiomastashonak.schoolaccountingstudio;

import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;

public class Table extends JTable {

    public Table(Color backgroundColor, Color textColor, Font font) {
        setBackground(backgroundColor);
        setForeground(textColor);
        setFont(font);
    }

}