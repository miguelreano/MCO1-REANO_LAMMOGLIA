import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

public class LevelUpGUI extends JFrame{
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

        HPButton = new JButton("HP");
        ENDButton = new JButton("END");
        DEXButton = new JButton("DEX");
        STRButton = new JButton("STR");
        INTButton = new JButton("INT");
        FTHButton = new JButton("FTH");
        backButton = new JButton("Back");

        statsTextArea = new JTextArea(20, 30);
        statsTextArea.setEditable(false);

        JPanel leftPanel = new JPanel(new GridLayout(7, 1, 0, 10));
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LevelUpGUI(); // Make the JFrame visible
            }
        });
    }

}
