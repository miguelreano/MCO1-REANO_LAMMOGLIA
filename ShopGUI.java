import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShopGUI extends JFrame {
    private JPanel mainPanel;
    private JScrollPane scrollPane;
    private JButton backButton;
    private Character character; // Reference to the Character instance

    public ShopGUI(Weapon[] weapons, Character character) {
        this.character = character; // Initialize the character
        setTitle("Shop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);

        mainPanel = new JPanel(new BorderLayout()); // Use BorderLayout for main panel

        // Creating a panel for weapons in a grid layout
        JPanel weaponsPanel = new JPanel(new GridLayout(6, 4, 10, 10)); // 6 rows, 4 columns, with gaps
        if (weapons != null) {
            for (Weapon weapon : weapons) {
                if (weapon != null) {
                    JButton button = new JButton("<html>" + weapon.getName() + "<br/>Cost: " + weapon.getWeaponCost() + "</html>");
                    button.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            // Use the purchaseWeapon method when a button is clicked
                            character.purchaseWeapon(weapon);
                        }
                    });
                    weaponsPanel.add(button);
                }
            }
        }//why not work

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

        scrollPane = new JScrollPane(mainPanel);
        setContentPane(scrollPane);
        pack();  // Adjusts frame size based on the components
        setLocationRelativeTo(null);
        setVisible(true);
    }


}
