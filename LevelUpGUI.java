import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;



public class LevelUpGUI extends JFrame{
    private JLabel runeLabel;
    private JButton HPButton;
    private JButton ENDButton;
    private JButton DEXButton;
    private JButton STRButton;
    private JButton INTButton;
    private JButton FTHButton;
    private JButton backButton;
    private JTextArea statsTextArea;

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
        //leftPanel.add(Box.createVerticalStrut(10));
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
    
    public void addHPButtonListener(ActionListener listenForHPButton) {
        HPButton.addActionListener(listenForHPButton);
    }

    public void addENDButtonListener(ActionListener listenForENDButton) {
        ENDButton.addActionListener(listenForENDButton);
    }

    public void addDEXButtonListener(ActionListener listenForDEXButton){
        DEXButton.addActionListener(listenForDEXButton);
    }

    public void addSTRButtonListener(ActionListener listenForSTRButton){
        STRButton.addActionListener(listenForSTRButton);
    }

    public void addINTButtonListener(ActionListener listenForINTButton){
        INTButton.addActionListener(listenForINTButton);
    }

    public void addFTHButtonListener(ActionListener listenForFTHButton){
        FTHButton.addActionListener(listenForFTHButton);
    }

    public void displayStatsTextArea(String stats) {
        statsTextArea.setText(stats);
    }

    public void addBackButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }

    public JTextArea getStatsTextArea() {
        return statsTextArea;
    }

    public void updateRuneDisplay(int runes) {
        runeLabel.setText("Runes: " + runes);
    }
    

}
