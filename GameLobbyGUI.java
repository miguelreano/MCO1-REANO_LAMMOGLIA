import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Represents the game lobby GUI, providing the player with options such as fast travel,
 * leveling up, accessing inventory, visiting the shop, and quitting the game. Additionally,
 * it displays character stats and current weapon information.
 */
public class GameLobbyGUI extends JFrame {
    private JLabel nameLabel;
    private JLabel levelLabel;
    private JLabel runesLabel;
    private JLabel currentWeaponLabel;
    private JButton fastTravelButton;
    private JButton levelUpButton;
    private JButton inventoryButton;
    private JButton shopButton;
    private JButton quitButton;
    private JTextArea statsTextArea;

    /**
     * Initializes the game lobby GUI components and layout.
     */
    public GameLobbyGUI() {
        try {
            setTitle("Game Lobby");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(600, 400);

            // Initialize components
            nameLabel = new JLabel();
            levelLabel = new JLabel();
            runesLabel = new JLabel();
            currentWeaponLabel = new JLabel();
            fastTravelButton = new JButton("Fast Travel");
            levelUpButton = new JButton("Level Up");
            inventoryButton = new JButton("Inventory");
            shopButton = new JButton("Shop");
            quitButton = new JButton("Quit Game");
            statsTextArea = new JTextArea(10, 30);
            statsTextArea.setEditable(false);

            // Setup layout
            JPanel leftPanel = new JPanel(new GridLayout(9, 1, 0, 10));
            leftPanel.add(nameLabel);
            leftPanel.add(levelLabel);
            leftPanel.add(runesLabel);
            leftPanel.add(currentWeaponLabel);
            leftPanel.add(fastTravelButton);
            leftPanel.add(levelUpButton);
            leftPanel.add(inventoryButton);
            leftPanel.add(shopButton);
            leftPanel.add(quitButton);
            leftPanel.setBorder(new EmptyBorder(10, 10, 10, 150));

            JPanel rightPanel = new JPanel(new GridLayout(1, 1));
            rightPanel.add(statsTextArea);

            setLayout(new GridLayout(1, 2));
            add(leftPanel);
            add(rightPanel);

            setVisible(true);
            setLocationRelativeTo(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates the character information displayed in the lobby, including name, level, runes,
     * and equipped weapon.
     * 
     * @param character The character whose information is to be displayed.
     */
    public void updateCharacter(Character character) {
        nameLabel.setText("Name: " + character.getCharacterName());
        levelLabel.setText("Level: " + character.getCharacterStats().getPlayerLevel());
        runesLabel.setText("Runes: " + character.getRunes());
        currentWeaponLabel.setText(character.getEquippedWeapon() != null ? "Weapon: " + character.getEquippedWeapon().getName() : "Weapon: None");
    }

    /**
     * Displays character stats in the stats text area.
     * 
     * @param stats The stats to display.
     */
    public void displayStatsTextArea(String stats) {
        statsTextArea.setText(stats);
    }

    // Methods to add action listeners to buttons
    public void addFastTravelButtonListener(ActionListener listener) {
        fastTravelButton.addActionListener(listener);
    }

    public void addLevelUpButtonListener(ActionListener listener) {
        levelUpButton.addActionListener(listener);
    }

    public void addInventoryButtonListener(ActionListener listener) {
        inventoryButton.addActionListener(listener);
    }

    public void addShopButtonListener(ActionListener listener) {
        shopButton.addActionListener(listener);
    }

    public void addQuitButtonListener(ActionListener listener) {
        quitButton.addActionListener(listener);
    }
}
