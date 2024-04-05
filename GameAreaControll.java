import java.awt.event.KeyEvent;

public class GameAreaControll{
    private GameBoardView view;
    private GameArea gameArea;

    public GameAreaControll(GameBoardView view) {
        this.view = view;
        this.gameArea = new GameArea(); // Initialize your game area/model here
        this.view.setController(this);
    }

    public void handleKeyPress(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_W:
                gameArea.movePlayer("W");
                break;
            case KeyEvent.VK_A:
                gameArea.movePlayer("A");
                break;
            case KeyEvent.VK_S:
                gameArea.movePlayer("S");
                break;
            case KeyEvent.VK_D:
                gameArea.movePlayer("D");
                break;
            default:
                break;
        }

        String[][] board = gameArea.getGameBoard(); // Assuming getGameBoard() method returns current game state as 2D array
        view.updateGameBoard(board);

        // Update player stats here if needed
        // view.updatePlayerStats("Updated Stats Here");
    }
}
