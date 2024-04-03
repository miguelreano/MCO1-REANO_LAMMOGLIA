import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CharacterCreationGUI extends JFrame {
    private JLabel nameLabel;
    private JLabel selectClassLabel;
    private JTextField nameField;
    private JComboBox<String> selectClassComboBox;
    private JTextArea statsTextArea;
    private JButton confirmButton;
    private JButton backButton;

    public CharacterCreationGUI() {
        setTitle("Character Creation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        nameLabel = new JLabel("Name: ");
        nameField = new JTextField(13);
        selectClassLabel = new JLabel("Class: ");
        selectClassComboBox = new JComboBox<>(new String[]{"Vagabond", "Samurai", "Warrior", "Hero", "Astrologer", "Prophet"});
        selectClassComboBox.setPreferredSize(new Dimension(150, selectClassComboBox.getPreferredSize().height));
        statsTextArea = new JTextArea(10, 30);
        statsTextArea.setEditable(false);

        confirmButton = new JButton("Confirm");
        backButton = new JButton("Back");

        JPanel leftPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Add nameLabel and nameField
        gbc.gridx = 0;
        gbc.gridy = 0;
        leftPanel.add(nameLabel, gbc);

        gbc.gridx = 1;
        leftPanel.add(nameField, gbc);

        // Add selectClassLabel and selectClassComboBox
        gbc.gridx = 0;
        gbc.gridy = 1;
        leftPanel.add(selectClassLabel, gbc);

        gbc.gridx = 1;
        leftPanel.add(selectClassComboBox, gbc);

        // Add buttons
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        leftPanel.add(confirmButton, gbc);

        gbc.gridy = 3;
        leftPanel.add(backButton, gbc);

        JPanel rightPanel = new JPanel();
        rightPanel.add(statsTextArea);

        // Use a JPanel with BorderLayout to hold leftPanel at the top-left corner
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(leftPanel, BorderLayout.NORTH);

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.WEST); // Place left panel at the top-left corner
        add(rightPanel, BorderLayout.EAST);

        setVisible(true);
        setLocationRelativeTo(null);
    }

    public void addConfirmButtonListener(ActionListener listener) {
        confirmButton.addActionListener(listener);
    }

    public void addBackButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }

    public void addSelectClassListener(ActionListener listener) {
        selectClassComboBox.addActionListener(listener);
    }

    public String getName() {
        return nameField.getText().trim();
    }

    public String getSelectedClass() {
        return (String) selectClassComboBox.getSelectedItem();
    }

    public void updateStatsTextArea(String stats) {
        statsTextArea.setText(stats);
    }

    //public static void main(String[] args) {
    // Create model and view instances for character creation
    //Character character = new Character(); // Assuming you have a Character class
    //CharacterCreationGUI characterCreationGUI = new CharacterCreationGUI();

    // Create controller instance for character creation
    //CharacterCreationController characterCreationController = new CharacterCreationController(characterCreationGUI, character);

    // Display the character creation GUI
    //characterCreationGUI.setVisible(true);
}



