import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controls the interactions between the user and the title screen.
 */
public class TitleScreenController {
    private TitleScreenGUI view;

    /**
     * Constructs a new TitleScreenController.
     * 
     * @param view The TitleScreenGUI that this controller manipulates.
     */
    public TitleScreenController(TitleScreenGUI view) {
        this.view = view;
        
        // Add action listeners to the buttons in the view
        this.view.addStartButtonListener(new StartButtonListener());
        this.view.addExitButtonListener(new ExitButtonListener());
    }

    /**
     * Inner class to handle the "START" button action.
     * This listener disposes of the current view and initializes the character creation process.
     */
    class StartButtonListener implements ActionListener {
        /**
         * Handles the action to be performed when the "START" button is pressed.
         * This involves closing the current view and starting the character creation process.
         * 
         * @param e The event that triggered this action.
         */
        public void actionPerformed(ActionEvent e) {
            view.dispose();
            Character character = new Character();
            CharacterCreationGUI characterCreationGUI = new CharacterCreationGUI();
            CharacterCreationController characterCreationController = new CharacterCreationController(characterCreationGUI, character);
        }
    }

    /**
     * Inner class to handle the "EXIT" button action.
     * This listener exits the application when the "EXIT" button is pressed.
     */
    class ExitButtonListener implements ActionListener {
        /**
         * Handles the action to be performed when the "EXIT" button is pressed.
         * This action exits the application.
         * 
         * @param e The event that triggered this action.
         */
        public void actionPerformed(ActionEvent e) {
            // Exit the application
            System.exit(0);
        }
    }
}
