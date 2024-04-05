import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitleScreenController {
    private TitleScreenGUI view;

    public TitleScreenController(TitleScreenGUI view) {
        this.view = view;
        
        // Add action listeners to the buttons in the view
        this.view.addStartButtonListener(new StartButtonListener());
        this.view.addExitButtonListener(new ExitButtonListener());
    }

    // Inner class to handle the "START" button action
    class StartButtonListener implements ActionListener {
        //@Override
        public void actionPerformed(ActionEvent e) {
            view.dispose();
            Character character = new Character();
            CharacterCreationGUI characterCreationGUI = new CharacterCreationGUI();
            CharacterCreationController characterCreationController = new CharacterCreationController(characterCreationGUI, character);
        }
    }

    // Inner class to handle the "EXIT" button action
    class ExitButtonListener implements ActionListener {
        //@Override
        public void actionPerformed(ActionEvent e) {
            // Exit the application
            System.exit(0);
        }
    }
}
