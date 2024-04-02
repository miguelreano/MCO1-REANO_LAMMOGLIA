import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameLobbyGUI extends JFrame{
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

    public GameLobbyGUI() {
        setTitle("Game Lobby");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        nameLabel = new JLabel("Name: ");
        levelLabel = new JLabel("Level: ");
        runesLabel = new JLabel("Runes: ");
        currentWeaponLabel = new JLabel("Weapon: ");

        fastTravelButton = new JButton("Fast Travel");
        levelUpButton = new JButton("Level Up");
        inventoryButton = new JButton("Inventory");
        shopButton = new JButton("Shop");
        quitButton = new JButton("Quit Game");

        statsTextArea = new JTextArea();
        statsTextArea.setEditable(false);

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
    }  

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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GameLobbyGUI gui = new GameLobbyGUI();
                gui.setVisible(true);
            }
        });
    }

}
