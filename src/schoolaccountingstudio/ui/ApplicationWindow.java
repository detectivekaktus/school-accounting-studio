package schoolaccountingstudio.ui;

import com.artiomastashonak.schoolaccountingstudio.resources.colors.DarkThemeColors;
import com.artiomastashonak.schoolaccountingstudio.resources.strings.StringsEN;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;

public class ApplicationWindow extends JFrame {

    public ApplicationWindow(@org.jetbrains.annotations.NotNull ImageIcon icon) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(icon.getImage());
        setTitle(StringsEN.APPLICATION_NAME.value);
        setMinimumSize(new Dimension(1000, 500));
        setExtendedState(MAXIMIZED_BOTH);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(DarkThemeColors.WINDOW_BACKGROUND_COLOR.red, DarkThemeColors.WINDOW_BACKGROUND_COLOR.green, DarkThemeColors.WINDOW_BACKGROUND_COLOR.blue));

        setJMenuBar(new ApplicationMenuBar());

        setVisible(true);
    }

}