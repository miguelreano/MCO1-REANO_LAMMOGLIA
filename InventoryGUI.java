// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.util.List;

// public class InventoryGUI extends JFrame {
//     private JPanel mainPanel;
//     private JScrollPane scrollPane;
//     private JButton backButton;
//     private Character character; // Reference to the Character instance

//     public InventoryGUI(Character character) {
//         this.character = character;
//         setTitle("Inventory");
//         setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // Hide on close to avoid terminating the application
//         setSize(400, 600);

//         mainPanel = new JPanel();
//         mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
//         updateInventory();

//         backButton = new JButton("Back");
//         backButton.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent e) {
//                 dispose();
//                 GameLobbyGUI gameLobbyGUI = new GameLobbyGUI();
//                 GameLobbyController gameLobbyController = new GameLobbyController(character, gameLobbyGUI);
//                 gameLobbyGUI.setVisible(true);
//             }
//         });

//         JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//         backPanel.add(backButton);
//         mainPanel.add(backPanel, BorderLayout.SOUTH);

//         scrollPane = new JScrollPane(mainPanel);
//         setContentPane(scrollPane);
//         setLocationRelativeTo(null);
//         setVisible(true);
//     }

//     public void updateInventory() {
//         mainPanel.removeAll(); // Clear existing inventory buttons
//         List<Weapon> inventory = character.getInventory();
//         for (Weapon weapon : inventory) {
//             JButton button = new JButton(weapon.getName());
//             button.addActionListener(new ActionListener() {
//                 public void actionPerformed(ActionEvent e) {
//                     character.setEquippedWeapon(weapon);
//                     JOptionPane.showMessageDialog(null, weapon.getName() + " is now equipped.");
//                 }
//             });
//             mainPanel.add(button);
//         }
//         mainPanel.revalidate();
//         mainPanel.repaint();
//     }
// }


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class InventoryGUI extends JFrame {
    private JPanel mainPanel, inventoryPanel, backPanel;
    private JScrollPane scrollPane;
    private JButton backButton;
    private Character character; // Reference to the Character instance

    public InventoryGUI(Character character) {
        this.character = character;
        setTitle("Inventory");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // Hide on close to avoid terminating the application
        setSize(800, 400); // Adjust size if necessary

        // Main panel with BorderLayout to separate inventory and navigation
        mainPanel = new JPanel(new BorderLayout());

        // Inventory panel with GridLayout for the weapons
        inventoryPanel = new JPanel(new GridLayout(0, 4, 10, 10)); // Rows set to 0 for any number of rows
        inventoryPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding around the grid
        updateInventory();

        // Scroll pane for inventory items
        scrollPane = new JScrollPane(inventoryPanel);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Back button and its panel
        backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                GameLobbyGUI gameLobbyGUI = new GameLobbyGUI();
                GameLobbyController gameLobbyController = new GameLobbyController(character, gameLobbyGUI);
                gameLobbyGUI.setVisible(true);
            }
        });
        backPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        backPanel.add(backButton);
        mainPanel.add(backPanel, BorderLayout.SOUTH);

        setContentPane(mainPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void updateInventory() {
        inventoryPanel.removeAll(); // Clear existing inventory buttons
        List<Weapon> inventory = character.getInventory();
        for (Weapon weapon : inventory) {
            JButton button = new JButton(weapon.getName());
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Check if character DEX meets weapon DEX requirements
                    if (character.getCharacterStats().getDEX() >= weapon.getWeaponDEX()) {
                        character.setEquippedWeapon(weapon);
                        JOptionPane.showMessageDialog(null, weapon.getName() + " is now equipped.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Your Dexterity is too low to equip this weapon. Required: " + weapon.getWeaponDEX(), "Requirement Not Met", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            inventoryPanel.add(button);
        }
        inventoryPanel.revalidate();
        inventoryPanel.repaint();
    }
    
}
