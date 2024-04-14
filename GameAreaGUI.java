import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GameAreaGUI extends JFrame {
    private final int WIDTH = 600;
    private final int HEIGHT = 600;
    private JPanel[][] tiles;
    private final int NUM_ROWS;
    private final int NUM_COLS;
    private JTextArea statsTextArea;

    private int playerX;
    private int playerY;

    public GameAreaGUI(int NUM_ROWS, int NUM_COLS, int startX, int startY) {
        this.NUM_ROWS = NUM_ROWS;
        this.NUM_COLS = NUM_COLS;
        this.playerX = startX;
        this.playerY = startY;

        setTitle("Game Area");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setSize(WIDTH, HEIGHT);
        setBackground(Color.WHITE);

        setLayout(new BorderLayout());
        initializeGameArea();
        initializeCharacterStatWindow();

        setFocusable(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeGameArea() {
        JPanel gameAreaPanel = new JPanel(new GridLayout(NUM_ROWS, NUM_COLS));
        tiles = new JPanel[NUM_ROWS][NUM_COLS];
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                JPanel tile = new JPanel();
                tile.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                gameAreaPanel.add(tile);
                tiles[row][col] = tile;
            }
        }
        add(gameAreaPanel, BorderLayout.CENTER);
        updateGameArea();
    }

    private void initializeCharacterStatWindow() {
        JPanel statPanel = new JPanel(new BorderLayout());

        statPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        statPanel.setBackground(Color.LIGHT_GRAY);

        statsTextArea = new JTextArea(100, 10);
        statsTextArea.setLineWrap(true); // Enable word wrapping
        statsTextArea.setWrapStyleWord(true); // Wrap at word boundaries
        statsTextArea.setEditable(false);
        statPanel.add(statsTextArea);

        add(statPanel, BorderLayout.WEST);
    }

    public void updateGameArea() {
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                if (row == playerY && col == playerX) {
                    tiles[row][col].setBackground(Color.RED);
                } else {
                    tiles[row][col].setBackground(Color.BLACK);
                }
            }
        }
    }

    /**
     * Displays character stats in the stats text area.
     * 
     * @param stats The stats to display.
     */
    public void displayStatsTextArea(String stats) {
        statsTextArea.setText(stats);
    }

    public int getPlayerY() {
        return playerY;
    }

    public int getPlayerX() {
        return playerX;
    }

    public void setPlayerY(int y) {
        playerY = y;
    }

    public void setPlayerX(int x) {
        playerX = x;
    }
    
    public void movePlayerUp() {
        playerY--;
    }
    
    public void movePlayerDown() {
        playerY++;
    }
    
    public void movePlayerLeft() {
        playerX--;
    }
    
    public void movePlayerRight() {
        playerX++;
    }
    
    
}
