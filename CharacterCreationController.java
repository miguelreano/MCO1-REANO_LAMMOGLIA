import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

public class CharacterCreationController {
    private CharacterCreationGUI view;
    private Character model;

    public CharacterCreationController(CharacterCreationGUI view, Character model) {
        this.view = view;
        this.model = model;

        // Add action listeners to the buttons in the view
        this.view.addConfirmButtonListener(new ConfirmButtonListener());
        this.view.addBackButtonListener(new BackButtonListener());
    }

    // Inner class to handle the "Confirm" button action
    // Inner class to handle the "Confirm" button action
    class ConfirmButtonListener implements ActionListener {
        //@Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Retrieve input data from the view and update the model
                String name = view.getName();
                String selectedClass = view.getSelectedClass();
                
                model.setCharacterName(name);
                model.selectClass(selectedClass);
    
                // Dispose of the current CharacterCreationGUI
                view.dispose();
    
                // Log before attempting to display the GameLobbyGUI
                System.out.println("Attempting to display GameLobbyGUI");
    
                // Proceed to the GameLobbyGUI
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            GameLobbyGUI gameLobbyGUI = new GameLobbyGUI();
                            gameLobbyGUI.setVisible(true);
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
            System.out.println("Back button clicked"); // Debugging statement

            // Dispose of the current window
            view.dispose();
           
            // Open the TitleScreenGUI window
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    TitleScreenGUI titleScreenGUI = new TitleScreenGUI();
                    titleScreenGUI.setVisible(true);
                }
            });
        }
    }

}
