import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

public class CharacterCreationController {
    private CharacterCreationGUI view;
    private Character model;

    public CharacterCreationController(CharacterCreationGUI view, Character model) {
        this.view = view;
        this.model = model;
        this.view.addConfirmButtonListener(new ConfirmButtonListener());
        this.view.addBackButtonListener(new BackButtonListener());
    }

    class ConfirmButtonListener implements ActionListener {
        //@Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Retrieve input data from the view and update the model
                String name = view.getName();
                String selectedClass = view.getSelectedClass();
                
                model.setCharacterName(name);
                model.selectClass(selectedClass);
    
                // Log before attempting to display the GameLobbyGUI
                System.out.println("Attempting to display GameLobbyGUI");

                view.dispose();
    
                // Proceed to the GameLobbyGUI
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            view.dispose();
                            GameLobbyGUI gameLobbyGUI = new GameLobbyGUI();
                            GameLobbyController gameLobbyController = new GameLobbyController(null, gameLobbyGUI);
                            System.out.println("GameLobbyGUI displayed successfully");

                        } catch (Exception ex) {
                            ex.printStackTrace(); // Log any exceptions thrown during GameLobbyGUI initialization
                        }
                    }
                });
            } catch (Exception ex) {
                ex.printStackTrace(); // Catch and log any exceptions during the character creation confirmation
            }
        }
    }
    



    class BackButtonListener implements ActionListener {
        //@Override
        public void actionPerformed(ActionEvent e) {
            view.dispose();
            TitleScreenGUI titleScreenGUI = new TitleScreenGUI();
            TitleScreenController titleScreenController = new TitleScreenController(titleScreenGUI);
        }
    }

}
