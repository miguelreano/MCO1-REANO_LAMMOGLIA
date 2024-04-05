import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameBoardView extends JFrame {
    private GameAreaControll controller;
    private JPanel gridPanel = new JPanel();
    private JLabel playerStats = new JLabel("Player Stats Here");

    public GameBoardView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setTitle("Game Area");
        setLayout(new BorderLayout());

        playerStats.setHorizontalAlignment(SwingConstants.CENTER);
        add(playerStats, BorderLayout.NORTH);

        gridPanel.setLayout(new GridLayout(0, 7)); // Assuming 7x7 grid for simplicity
        add(gridPanel, BorderLayout.CENTER);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                controller.handleKeyPress(e.getKeyCode());
            }
        });

        // To prevent focus issues
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void setController(GameAreaControll controller) {
        this.controller = controller;
    }

    public void updateGameBoard(String[][] board) {
        gridPanel.removeAll(); // Clear previous state

        for (String[] row : board) {
            for (String cell : row) {
                JLabel label = new JLabel(cell, SwingConstants.CENTER);
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                gridPanel.add(label);
            }
        }

        gridPanel.revalidate();
        gridPanel.repaint();
    }

    public void updatePlayerStats(String stats) {
        playerStats.setText(stats);
    }
}
