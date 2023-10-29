package com.artiomastashonak.schoolaccountingstudio;

import com.artiomastashonak.schoolaccountingstudio.tree.FileManagerTreeCellRenderer;
import org.jetbrains.annotations.NotNull;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.util.Objects;

public class FileManager extends JPanel {

    public Button refreshButton;
    public Button closeButton;
    public JTree fileTree;
    private final File[] files;

    public FileManager(@NotNull File[] files) {
        this.files = files;

        setBackground(DarkThemeColors.POP_UP_WINDOW_BACKGROUND_COLOR.color);
        setLayout(new BorderLayout());
        setFocusable(true);

        JPanel title = new JPanel();
        title.setBackground(DarkThemeColors.POP_UP_WINDOW_BACKGROUND_COLOR.color);
        title.setLayout(new FlowLayout(FlowLayout.LEADING));
        Label fileManagerLabel = new Label(StringsEN.FILE_MANAGER_TITLE.value, new Font("K2D", Font.PLAIN, TextSizes.MENU_BAR_TEXT_SIZE.size), DarkThemeColors.SECONDARY_TEXT_COLOR.color, null);
        title.add(fileManagerLabel);

        JPanel titleButtonGroupPanel = new JPanel();
        titleButtonGroupPanel.setBackground(DarkThemeColors.POP_UP_WINDOW_BACKGROUND_COLOR.color);
        titleButtonGroupPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        refreshButton = new Button(new ImageIcon(), DarkThemeColors.POP_UP_WINDOW_BACKGROUND_COLOR.color);
        closeButton = new Button(new ImageIcon(), DarkThemeColors.POP_UP_WINDOW_BACKGROUND_COLOR.color);
        titleButtonGroupPanel.add(refreshButton);
        titleButtonGroupPanel.add(closeButton);
        title.add(titleButtonGroupPanel);

        fileTree = new JTree(update());
        fileTree.setBackground(DarkThemeColors.POP_UP_WINDOW_BACKGROUND_COLOR.color);
        fileTree.setForeground(DarkThemeColors.PRIMARY_TEXT_COLOR.color);
        fileTree.setCellRenderer(new FileManagerTreeCellRenderer());
        fileTree.setRootVisible(false);

        JScrollPane filesTree = new JScrollPane(fileTree);
        filesTree.setBorder(null);

        add(title, BorderLayout.NORTH);
        add(filesTree, BorderLayout.CENTER);

    }

    public DefaultMutableTreeNode update() {
        DefaultMutableTreeNode rootFileNode = new DefaultMutableTreeNode("Documents");
        for (File rootFile : files) {
            if (rootFile.isDirectory()) {
                DefaultMutableTreeNode directory = new DefaultMutableTreeNode(rootFile.getName().substring(0, 1).toUpperCase() + rootFile.getName().substring(1));

                for (File directoryFile : Objects.requireNonNull(rootFile.listFiles())) {
                    DefaultMutableTreeNode file = new DefaultMutableTreeNode(directoryFile.getName());
                    directory.add(file);
                }

                rootFileNode.add(directory);
            } else {
                rootFileNode.add(new DefaultMutableTreeNode(rootFile.getName()));
            }
        }
        return rootFileNode;
    }

}