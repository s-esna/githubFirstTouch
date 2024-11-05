package gr.aueb.cf.ch1;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PrintUTFCharacter {
    public static void main(String[] args) {
        // Unicode code point for U+130BA
        int unicode = 0x130BA;
        String unicodeString = new String(Character.toChars(unicode));

        // Load and use the specific font
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Unicode Display");
            JLabel label = new JLabel(unicodeString);

            try {
                // Load the custom font
                Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("NotoSansEgyptianHieroglyphs-Regular.ttf"));
                customFont = customFont.deriveFont(64f); // Set the font size
                label.setFont(customFont);
            } catch (FontFormatException | IOException e) {
                e.printStackTrace();
            }

            frame.add(label);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);
            frame.setVisible(true);
        });
    }
}
