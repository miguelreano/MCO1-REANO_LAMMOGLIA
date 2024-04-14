import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShopGUI extends JFrame {
    private JPanel mainPanel;
    private JScrollPane scrollPane;
    private JButton backButton;
    private JLabel runeLabel;
    private Character character;
    private InventoryGUI inventoryGUI; // Reference to the Character instance

    public ShopGUI(Weapon[] weapons, Character character) {
        this.character = character; // Initialize the character
        this.inventoryGUI = new InventoryGUI(character);
        this.inventoryGUI.setVisible(false);
        setTitle("Shop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);

        runeLabel = new JLabel("Runes: " + character.getRunes());

        mainPanel = new JPanel(new BorderLayout()); // Use BorderLayout for main panel

        // Creating a panel for weapons in a grid layout
        JPanel weaponsPanel = new JPanel(new GridLayout(6, 4, 10, 10)); // 6 rows, 4 columns, with gaps
        if (weapons != null) {
            for (Weapon weapon : weapons) {
                if (weapon != null) {
                    JButton button = new JButton("<html>" + weapon.getName() + "<br/>Cost: " + weapon.getWeaponCost() + "</html>");
                    button.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            character.purchaseWeapon(weapon, inventoryGUI); 
                            updateRuneDisplay(character.getRunes());
                        }
                    });
                    
                    weaponsPanel.add(button);
                }
            }
        }

        // Add weaponsPanel to the center of mainPanel
        mainPanel.add(weaponsPanel, BorderLayout.CENTER);

        // Back button setup
        backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                GameLobbyGUI gameLobbyGUI = new GameLobbyGUI();
                GameLobbyController gameLobbyController = new GameLobbyController(character, gameLobbyGUI);
                gameLobbyGUI.setVisible(true);
            }
        });

        // Panel to hold the backButton, aligns to the left
        JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        backPanel.add(backButton);
        mainPanel.add(backPanel, BorderLayout.SOUTH); // Place backPanel at the bottom of the mainPanel

        JPanel runeDisplay = new JPanel(new FlowLayout(FlowLayout.LEFT));
        runeDisplay.add(runeLabel);
        mainPanel.add(runeDisplay, BorderLayout.NORTH);

        scrollPane = new JScrollPane(mainPanel);
        setContentPane(scrollPane);
        pack();  // Adjusts frame size based on the components
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void updateRuneDisplay(int runes) {
        runeLabel.setText("Runes: " + runes);
    }

}
