package com.artiomastashonak.schoolaccountingstudio.tree;

import com.artiomastashonak.schoolaccountingstudio.DarkThemeColors;
import com.artiomastashonak.schoolaccountingstudio.TextSizes;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.Component;
import java.awt.Font;

public class FileManagerTreeCellRenderer extends DefaultTreeCellRenderer {

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean exp, boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, exp, leaf, row, hasFocus);
        setBackground(DarkThemeColors.POP_UP_WINDOW_BACKGROUND_COLOR.color);
        setBackgroundSelectionColor(DarkThemeColors.VIOLET_SECONDARY_ACCENT_COLOR.color);
        setBackgroundNonSelectionColor(DarkThemeColors.POP_UP_WINDOW_BACKGROUND_COLOR.color);
        setForeground(DarkThemeColors.PRIMARY_TEXT_COLOR.color);
        setFont(new Font("K2D", Font.BOLD, TextSizes.MENU_BAR_TEXT_SIZE.size));
        return this;
    }

}