import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameAreaGui extends JFrame {
    private JLabel gameTitleLabel;
    private JTextArea playerStatsTextArea;
    private JPanel gameBoardPanel;
    private JButton[][] gameBoardButtons;
    private JButton upButton, downButton, leftButton, rightButton;

    private int rows; // Instance variable to hold the current number of rows in the game board
    private int cols; // Instance variable to hold the current number of columns in the game board

    public GameAreaGui() {
        initializeComponents();
    }

    private void initializeComponents() {
        setTitle("Elden Rogue");
        setLayout(new BorderLayout());
        
        gameTitleLabel = new JLabel("Elden Rogue", SwingConstants.CENTER);
        add(gameTitleLabel, BorderLayout.NORTH);
        
        playerStatsTextArea = new JTextArea(5, 20);
        playerStatsTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(playerStatsTextArea);
        add(scrollPane, BorderLayout.WEST);
        
        gameBoardPanel = new JPanel();
        gameBoardPanel.setLayout(new GridLayout(0, 0)); // Rows and cols will be set later
        add(gameBoardPanel, BorderLayout.CENTER);
        
        JPanel movementPanel = new JPanel(new GridLayout(2, 2));
        upButton = new JButton("Up");
        downButton = new JButton("Down");
        leftButton = new JButton("Left");
        rightButton = new JButton("Right");
        
        movementPanel.add(upButton);
        movementPanel.add(downButton);
        movementPanel.add(leftButton);
        movementPanel.add(rightButton);
        
        add(movementPanel, BorderLayout.SOUTH);
        
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void setFloorSize(int rows, int cols) {
        // Clear previous game board
        gameBoardPanel.removeAll();
        gameBoardPanel.setLayout(new GridLayout(rows, cols)); // Set new grid layout
        
        gameBoardButtons = new JButton[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                gameBoardButtons[i][j] = new JButton();
                gameBoardPanel.add(gameBoardButtons[i][j]);
            }
        }
        
        gameBoardPanel.revalidate();
        gameBoardPanel.repaint();
    }


    public JButton getUpButton() {
        return upButton;
    }

    public JButton getDownButton() {
        return downButton;
    }

    public JButton getLeftButton() {
        return leftButton;
    }

    public JButton getRightButton() {
        return rightButton;
    }

    public void setGameTitle(String title) {
        gameTitleLabel.setText(title);
    }

    public void updatePlayerStats(String stats) {
        playerStatsTextArea.setText(stats);
    }

    public void updateGameBoard(String[][] gameBoardData) {
        for (int i = 0; i < gameBoardData.length; i++) {
            for (int j = 0; j < gameBoardData[i].length; j++) {
                JButton button = gameBoardButtons[i][j];
                button.setText(gameBoardData[i][j]); // Setting the text to what's in the gameBoardData array
            }
        }
    }

    public void setButtonListener(ActionListener listener) {
        upButton.addActionListener(listener);
        downButton.addActionListener(listener);
        leftButton.addActionListener(listener);
        rightButton.addActionListener(listener);
    }

    public void setMovementButtonsEnabled(boolean enabled) {
        upButton.setEnabled(enabled);
        downButton.setEnabled(enabled);
        leftButton.setEnabled(enabled);
        rightButton.setEnabled(enabled);
    }

    public void FloorSize(int rows, int cols) {
        this.rows = rows; // Update the instance variable when floor size changes
        this.cols = cols; // Update the instance variable when floor size changes
        // Rest of the method implementation...
    }

    public void highlightPlayerPosition(int x, int y) {
        // Ensure all buttons are reset first
        for (int i = 0; i < this.rows; i++) { // Use instance variable this.rows
            for (int j = 0; j < this.cols; j++) { // Use instance variable this.cols
                JButton button = gameBoardButtons[i][j];
                button.setOpaque(false);
                button.setBorderPainted(true);
                button.setBackground(null); // Reset background to default
            }
        }
        
        // Highlight the button at the player's position
        JButton playerButton = gameBoardButtons[x][y];
        playerButton.setOpaque(true);
        playerButton.setBorderPainted(false);
        playerButton.setBackground(Color.GREEN); // Highlight the current player's position
    }

}
 