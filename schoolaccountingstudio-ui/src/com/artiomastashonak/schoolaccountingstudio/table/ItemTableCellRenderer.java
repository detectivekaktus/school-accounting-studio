package com.artiomastashonak.schoolaccountingstudio.table;

import com.artiomastashonak.schoolaccountingstudio.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Component;
import java.awt.Font;

public class ItemTableCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        setBackground(DarkThemeColors.MENU_BAR_BACKGROUND_COLOR.color);
        setForeground(DarkThemeColors.TERTIARY_TEXT_COLOR.color);
        setFont(new Font("K2D", Font.PLAIN, TextSizes.BUTTON_TEXT_SIZE.size));
        return this;
    }
}