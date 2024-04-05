import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import java.util.Scanner;

/**
 * The {@code FastTravelCtrl} class is a controller that manages the fast travel functionality
 * in the game. It handles the user's selection of a warp point and transitions the player
 * to the corresponding game area.
 */

public class FastTravelCtrl {
    private FastTravelGUI view;
    private GameLobby model;

    /**
     * The {@code FastTravelCtrl} constructor initializes the controller with the provided
     * model and view.
     *
     * @param model The game lobby model.
     * @param view The fast travel GUI view.
     */
    public FastTravelCtrl(GameLobby model, FastTravelGUI view){
        this.model = model;
        this.view = view;
    

    /**
     * Adds an action listener to the warp 1 button in the fast travel GUI.
     *
     * @param actionListener The action listener to be added.
     */    
    view.addWarp1(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            view.setVisible(false);
            Scanner scanner = new Scanner(System.in);
            GameArea gameArea = new GameArea();
            gameArea.FirstFloor(scanner);


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
    }
    
}
