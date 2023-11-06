package com.artiomastashonak.schoolaccountingstudio;

import org.jetbrains.annotations.NotNull;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Dialog extends JDialog {

    public Dialog(@NotNull ImageIcon icon, String title, Color backgroundColor) {
        setBackground(backgroundColor);
        setIconImage(icon.getImage());
        setTitle(title);
    }

}