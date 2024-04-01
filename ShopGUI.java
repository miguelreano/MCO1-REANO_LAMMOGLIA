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
    

    public ShopGUI() {
        setTitle("Shop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        JPanel buttonPanel = new JPanel(new GridLayout(6, 4, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        for (int i = 0; i < 24; i++) {
            JButton button = new JButton(weaponNames[i]);
            buttonPanel.add(button);
        }

        add(buttonPanel);
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
