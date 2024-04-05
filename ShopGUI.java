import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ShopGUI extends JFrame {
    private String[] weaponNames = {
        "Short Sword", "Rogier's Rapier", "Coded Sword", "Sword of Night and Flame",
        "Uchigatana", "Moonveil", "Rivers of Blood", "Hand of Malenia",
        "Whip", "Urumi", "Thorned Whip", "Hoslow's Petal Whip",
        "Claymore", "Starscourge Greatsword", "Inseparable Sword", "Malekith's Black Blade",
        "Astrologer's Staff", "Albinauric Staff", "Staff of the Guilty", "Carian Regal Scepter",
        "Finger Seal", "Godslayer's Seal", "Golden Order Seal", "Dragon Communion Seal"
    };
    private JButton backButton;
    private JLabel runesLabel;
    private JButton[] weaponButtons;
    

    public ShopGUI() {
        setTitle("Shop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);

        backButton = new JButton("Back");
        runesLabel = new JLabel();
        runesLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(6, 4, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        for (int i = 0; i < 24; i++) {
            JButton button = new JButton(weaponNames[i]);
            buttonPanel.add(button);

        }

        JPanel panel = new JPanel(new GridLayout(1, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 440));
        panel.add(backButton);

        initializeWeaponButtons();

        add(runesLabel, BorderLayout.NORTH);
        add(buttonPanel);
        add(panel, BorderLayout.SOUTH);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void initializeWeaponButtons() {
        weaponButtons = new JButton[24]; // Assuming you have 24 weapons
        for (int i = 0; i < weaponNames.length; i++) {
            weaponButtons[i] = new JButton(weaponNames[i]);
            // Add the buttons to your GUI layout
        }
        // Don't forget to add these buttons to your GUI in the appropriate panel
    }

    public void addBackButtonListener(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }

    public JButton[] getWeaponButtons() {
        return weaponButtons;
    }

    public JButton getBackButton() {
        return backButton;
    }

}


