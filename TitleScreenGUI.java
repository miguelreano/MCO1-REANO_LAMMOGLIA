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
} original code*/ 

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
    
        titleLabel = new JLabel("Elden Rogue", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Mantinia", Font.BOLD, 30)); // Setting custom font and size
    
        // Make the first and last letters larger and set the text color to yellow
        String yellowHex = "#ef8b09"; // Hexadecimal color code for yellow
        String htmlText = "<html><span style='font-size: 40px; color: " + yellowHex + ";'>" + "E" + "</span><span style='color: " + yellowHex + ";'>LDEN ROGU</span><span style='font-size: 40px; color: " + yellowHex + ";'>" + "E" + "</span></html>";
        titleLabel.setText(htmlText);
    
        startButton = new JButton("START");
        exitButton = new JButton("EXIT");
    
        startButton.setContentAreaFilled(false);
        startButton.setBorderPainted(false);
        startButton.setForeground(Color.WHITE);
        startButton.setSize(80, 30);

        exitButton.setContentAreaFilled(false);
        exitButton.setBorderPainted(false);
        exitButton.setForeground(Color.WHITE);
        exitButton.setSize(80, 30);
    
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.BLACK); // Set the panel background to black
        panel.add(Box.createVerticalStrut(10));
        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(Box.createVerticalStrut(20));
    
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 0, 10));
        buttonPanel.add(startButton);
        buttonPanel.add(exitButton);
        buttonPanel.setBorder(new EmptyBorder(30, 100, 30, 100));
        buttonPanel.setBackground(Color.BLACK); // Also set the button panel background to black if you want
    
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

} with color */

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * A class representing the title screen of a game, extending JFrame.
 */
public class TitleScreenGUI extends JFrame {
    private JLabel titleLabel;
    private JButton startButton;
    private JButton exitButton;

    /**
     * Constructs a TitleScreenGUI object.
     * Initializes the GUI components and layouts for the title screen, including a title label and start/exit buttons.
     * The title screen is set with a predefined size and layout, and it becomes visible upon creation.
     */
    public TitleScreenGUI() {
        setTitle("Elden Rogue");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        titleLabel = new JLabel("Elden Rogue", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Mantinia", Font.BOLD, 30));

        // Make the first and last letters larger
        Font originalFont = titleLabel.getFont();
        String htmlText = "<html><span style='font-size: 40px;'>" + "E" + "</span>LDEN ROGU" + "<span style='font-size: 40px;'>" + "E" + "</span></html>";
        titleLabel.setText(htmlText);

        startButton = new JButton("START");
        exitButton = new JButton("EXIT");

        // Set fixed size for the buttons
        Dimension buttonSize = new Dimension(100, 50);
        startButton.setPreferredSize(buttonSize);
        exitButton.setPreferredSize(buttonSize);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(Box.createVerticalStrut(10));
        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(Box.createVerticalStrut(20));

        // Use FlowLayout for the button panel to respect the preferred size
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(startButton);
        buttonPanel.add(exitButton);

        // Adjusting the border to maintain layout consistency
        buttonPanel.setBorder(new EmptyBorder(30, 100, 30, 100));

        panel.add(buttonPanel, BorderLayout.CENTER);
        add(panel);

        setVisible(true);
        setLocationRelativeTo(null);
    }

    /**
     * Adds an ActionListener to the start button.
     * @param listener The ActionListener to be added to the start button.
     */
    public void addStartButtonListener(ActionListener listener) {
        startButton.addActionListener(listener);
    }

    /**
     * Adds an ActionListener to the exit button.
     * @param listener The ActionListener to be added to the exit button.
     */
    public void addExitButtonListener(ActionListener listener) {
        exitButton.addActionListener(listener);
    }
}
