import javax.swing.*;
import java.awt.*;

public class ShopGUI extends JFrame {
    private String[] weaponNames = {
        "Short Sword", "Rogier's Rapier", "Coded Sword", "Sword of Night and Flame",
        "Uchigatana", "Moonveil", "River of Blood", "Hand of Malenia",
        "Whip", "Urumi", "Thorned Whip", "Hoslow's Petal Whip",
        "Claymore", "Starscourge Greatsword", "Inseparable Sword", "Malekith's Black Blade",
        "Astrologer's Staff", "Albinauric Staff", "Staff of the Guilty", "Carian Regal Scepter",
        "Finger Seal", "Godslayer's Seal", "Golden Order Seal", "Dragon Communion Seal"
    };
    private JButton backButton;
    

    public ShopGUI() {
        setTitle("Shop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        backButton = new JButton("Back");

        JPanel buttonPanel = new JPanel(new GridLayout(6, 4, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        for (int i = 0; i < 24; i++) {
            JButton button = new JButton(weaponNames[i]);
            buttonPanel.add(button);
        }

        JPanel panel = new JPanel(new GridLayout(1, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 440));
        panel.add(backButton);

        add(buttonPanel);
        add(panel, BorderLayout.SOUTH);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ShopGUI(); // Make the JFrame visible
            }
        });
    }
}
