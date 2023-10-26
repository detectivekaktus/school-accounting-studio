package com.artiomastashonak.schoolaccountingstudio;

import org.jetbrains.annotations.NotNull;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.File;

public class FileManager extends JPanel {

    public FileManager(@NotNull File[] directories) {
        setLayout(new BorderLayout());
        setBackground(DarkThemeColors.POP_UP_WINDOW_BACKGROUND_COLOR.color);

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        titlePanel.add(new Label(StringsEN.FILE_MANAGER_TITLE.value, DarkThemeColors.SECONDARY_TEXT_COLOR.color, null));
        titlePanel.add(new Button(new ImageIcon(), DarkThemeColors.SECONDARY_TEXT_COLOR.color));
        add(titlePanel, BorderLayout.NORTH);

        for (File directory : directories) {
            JPanel directoryPanel = new JPanel();
            directoryPanel.setLayout(new FlowLayout());
            for (File file : directory.listFiles()) {
                directoryPanel.add(new Button(new ImageIcon(), file.getName(), DarkThemeColors.POP_UP_WINDOW_BACKGROUND_COLOR.color, DarkThemeColors.PRIMARY_TEXT_COLOR.color));
            }
            add(directoryPanel, BorderLayout.CENTER);
        }
    }

}