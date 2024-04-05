import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * This class represents the GUI for the level up screen in a game.
 * It provides buttons for increasing different stats of a character, such as HP, END, DEX, STR, INT, and FTH,
 * as well as displaying the current stats and available runes for level up.
 */
public class LevelUpGUI extends JFrame {
    private JLabel runeLabel;
    private JButton HPButton;
    private JButton ENDButton;
    private JButton DEXButton;
    private JButton STRButton;
    private JButton INTButton;
    private JButton FTHButton;
    private JButton backButton;
    private JTextArea statsTextArea;

    /**
     * Constructs a LevelUpGUI frame with initialized components including
     * stat buttons, a text area for displaying stats, and a label for showing available runes.
     * Sets up the layout and makes the frame visible.
     */
    public LevelUpGUI() {
        setTitle("Level Up");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        runeLabel = new JLabel();
        HPButton = new JButton("HP");
        ENDButton = new JButton("END");
        DEXButton = new JButton("DEX");
        STRButton = new JButton("STR");
        INTButton = new JButton("INT");
        FTHButton = new JButton("FTH");
        backButton = new JButton("Back");

        statsTextArea = new JTextArea(20, 30);
        statsTextArea.setEditable(false);

        JPanel leftPanel = new JPanel(new GridLayout(8, 1, 0, 10));
        leftPanel.add(runeLabel);
        leftPanel.add(HPButton);
        leftPanel.add(ENDButton);
        leftPanel.add(DEXButton);
        leftPanel.add(STRButton);
        leftPanel.add(INTButton);
        leftPanel.add(FTHButton);
        leftPanel.add(backButton);
        leftPanel.setBorder(new EmptyBorder(30, 10, 30, 100));

        JPanel rightPanel = new JPanel(new GridLayout(1, 1));
        rightPanel.add(statsTextArea);

        setLayout(new GridLayout(1, 2));
        add(leftPanel);
        add(rightPanel);

        setVisible(true);
        setLocationRelativeTo(null);
    }
    
    /**
     * Adds an ActionListener to the HP button.
     * @param listenForHPButton The ActionListener to be added.
     */
    public void addHPButtonListener(ActionListener listenForHPButton) {
        HPButton.addActionListener(listenForHPButton);
    }

    /**
     * Adds an ActionListener to the END button.
     * @param listenForENDButton The ActionListener to be added.
     */
    public void addENDButtonListener(ActionListener listenForENDButton) {
        ENDButton.addActionListener(listenForENDButton);
    }

    /**
     * Adds an ActionListener to the DEX button.
     * @param listenForDEXButton The ActionListener to be added.
     */
    public void addDEXButtonListener(ActionListener listenForDEXButton){
        DEXButton.addActionListener(listenForDEXButton);
    }

    /**
     * Adds an ActionListener to the STR button.
     * @param listenForSTRButton The ActionListener to be added.
     */
    public void addSTRButtonListener(ActionListener listenForSTRButton){
        STRButton.addActionListener(listenForSTRButton);
    }

    /**
     * Adds an ActionListener to the INT button.
     * @param listenForINTButton The ActionListener to be added.
     */
    public void addINTButtonListener(ActionListener listenForINTButton){
        INTButton.addActionListener(listenForINTButton);
    }

    /**
     * Adds an ActionListener to the FTH button.
     * @param listenForFTHButton The ActionListener to be added.
     */
    public void addFTHButtonListener(ActionListener listenForFTHButton){
        FTHButton.addActionListener(listenForFTHButton);
    }

    /**
     * Displays character stats in the stats text area.
     * @param stats The character stats to display.
     */
    public void displayStatsTextArea(String stats) {
        statsTextArea.setText(stats);
    }

    /**
     * Adds an ActionListener to the back button.
     * @param listener The ActionListener to be added.
     */
    public void addBackButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }

    /**
     * Returns the stats text area component.
     * @return The JTextArea component used for displaying stats.
     */
    public JTextArea getStatsTextArea() {
        return statsTextArea;
    }

    /**
     * Updates the display of available runes in the rune label.
     * @param runes The number of available runes to display.
     */
    public void updateRuneDisplay(int runes) {
        runeLabel.setText("Runes: " + runes);
    }
}
