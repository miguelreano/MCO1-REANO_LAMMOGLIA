/*import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class TitleScreenGUI extends JFrame {
    private JLabel titleLabel;
    private JButton startButton;
    private JButton exitButton;

    public TitleScreenGUI() {
        setTitle("Elden Rogue");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        titleLabel = new JLabel("ELDEN ROGUE", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));

        startButton = new JButton("START");
        exitButton = new JButton("EXIT");

        startButton.setSize(80, 30);
        exitButton.setSize(80, 30);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(Box.createVerticalStrut(10));
        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(Box.createVerticalStrut(20));

        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 0, 10));
        buttonPanel.add(startButton);
        buttonPanel.add(exitButton);
        buttonPanel.setBorder(new EmptyBorder(30, 100, 30, 100));

        panel.add(buttonPanel, BorderLayout.CENTER);
        add(panel);

        setVisible(true);
        setLocationRelativeTo(null);
    }

    public void addStartButtonListener(ActionListener listener) {
        startButton.addActionListener(listener);
    }

    // Method to add ActionListener to the "EXIT" button
    public void addExitButtonListener(ActionListener listener) {
        exitButton.addActionListener(listener);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TitleScreenGUI view = new TitleScreenGUI();
                new TitleScreenController(view);
                view.setVisible(true); // Make the JFrame visible
            }
        });
    }
}*/

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class TitleScreenGUI extends JFrame {
    private JLabel titleLabel;
    private JButton startButton;
    private JButton exitButton;

    public TitleScreenGUI() {
        setTitle("Elden Rogue");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        titleLabel = new JLabel("Elden Rogue", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Mantinia", Font.BOLD, 30)); // Setting custom font and size

        // Make the first and last letters larger
        Font originalFont = titleLabel.getFont();
        String htmlText = "<html><span style='font-size: 40px;'>" + "E" + "</span>LDEN ROGU" + "<span style='font-size: 40px;'>" + "E" + "</span></html>";
        titleLabel.setText(htmlText);

        startButton = new JButton("START");
        exitButton = new JButton("EXIT");

        startButton.setSize(80, 30);
        exitButton.setSize(80, 30);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(Box.createVerticalStrut(10));
        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(Box.createVerticalStrut(20));

        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 0, 10));
        buttonPanel.add(startButton);
        buttonPanel.add(exitButton);
        buttonPanel.setBorder(new EmptyBorder(30, 100, 30, 100));

        panel.add(buttonPanel, BorderLayout.CENTER);
        add(panel);

        setVisible(true);
        setLocationRelativeTo(null);
    }

    public void addStartButtonListener(ActionListener listener) {
        startButton.addActionListener(listener);
    }

    // Method to add ActionListener to the "EXIT" button
    public void addExitButtonListener(ActionListener listener) {
        exitButton.addActionListener(listener);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TitleScreenGUI view = new TitleScreenGUI();
                // new TitleScreenController(view); // Assuming you have this class somewhere
                view.setVisible(true); // Make the JFrame visible
            }
        });
    }
}

