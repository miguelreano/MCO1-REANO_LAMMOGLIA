import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

/**
 * The {@code FastTravelCtrl} class is a controller that manages the fast travel functionality
 * in the game. It handles the user's selection of a warp point and transitions the player
 * to the corresponding game area.
 */

public class FastTravelCtrl {
    private FastTravelGUI view;
    private Character model;

    /**
     * The {@code FastTravelCtrl} constructor initializes the controller with the provided
     * model and view.
     *
     * @param model The game lobby model.
     * @param view The fast travel GUI view.
     */
    public FastTravelCtrl(Character model, FastTravelGUI view){
        this.model = model;
        this.view = view;
    

        /**
         * Adds an action listener to the warp 1 button in the fast travel GUI.
         *
         * @param actionListener The action listener to be added.
         */    
        view.addWarp1(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                warpToGameArea(7, 3);
            }
        });

        /**
         * Adds an action listener to the warp 2 button in the fast travel GUI.
         *
         * @param actionListener The action listener to be added.
         */
        view.addWarp2(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                view.setVisible(false);
                Scanner scanner = new Scanner(System.in);
                GameArea2 gameArea2 = new GameArea2();
                gameArea2.firstFloor(scanner);

            }
        });

        /**
         * Adds an action listener to the warp 3 button in the fast travel GUI.
         *
         * @param actionListener The action listener to be added.
         */
        view.addWarp3(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                view.setVisible(false);
                Scanner scanner = new Scanner(System.in);
                GameArea3 gameArea3 = new GameArea3();
                gameArea3.firstFloor(scanner);
            }
        });

        /**
         * Adds an action listener to the warp 3 button in the fast travel GUI.
         *
         * @param actionListener The action listener to be added.
         */
        view.addBack(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                view.setVisible(false);
                // Proceed to game lobby
                GameLobbyGUI gameLobbyGUI = new GameLobbyGUI();
                GameLobbyController gameLobbyController = new GameLobbyController(model, gameLobbyGUI);
                gameLobbyGUI.setVisible(true);
            }
        });
    }

    /**
     * Warps the player to the specified game area dimensions.
     *
     * @param numRows The number of rows in the game area.
     * @param numCols The number of columns in the game area.
     */
    private void warpToGameArea(int numRows, int numCols) {
        view.setVisible(false); // Hide the fast travel GUI
        GameAreaModel1 gameModel = new GameAreaModel1();
        GameAreaGUI gameAreaGUI = new GameAreaGUI(numRows, numCols, 1, 6); // Create a new GameAreaGUI
        GameAreaController gameAreaController = new GameAreaController(model, gameAreaGUI, gameModel);
    }
    
}
