import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * Controls the character creation process, handling user interactions within the
 * {@link CharacterCreationGUI} and updating the {@link Character} model accordingly.
 */
public class CharacterCreationController {
    private CharacterCreationGUI view;
    private Character model;

    /**
     * Constructs a controller for character creation, linking the model and view,
     * and setting up listeners for GUI interactions.
     *
     * @param view  The GUI component of character creation.
     * @param model The data model representing the character being created.
     */
    public CharacterCreationController(CharacterCreationGUI view, Character model) {
        this.view = view;
        this.model = model;

        // Listener for confirm button action
        this.view.addConfirmButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Validate input before proceeding
                String name = view.getName().trim();
                String selectedClass = view.getSelectedClass().trim();

                // Validate name and class selection
                if (name.isEmpty() || selectedClass.isEmpty()) {
                    JOptionPane.showMessageDialog(view, "You must enter a name and select a class to proceed.", "Missing Information", JOptionPane.WARNING_MESSAGE);
                } else {
                    model.setCharacterName(name);
                    model.selectClass(selectedClass);

                    view.dispose(); // Close the character creation GUI

                    // Proceed to game lobby
                    GameLobbyGUI gameLobbyGUI = new GameLobbyGUI();
                    GameLobbyController gameLobbyController = new GameLobbyController(model, gameLobbyGUI);
                    gameLobbyGUI.setVisible(true);
                }
            }
        });

        // Listener for back button action
        this.view.addBackButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose(); // Close the character creation GUI
                // Additional actions to return to the previous screen could be added here
            }
        });

        // Listener for class selection action
        this.view.addSelectClassListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedClass = view.getSelectedClass();
                if (!selectedClass.isEmpty()) {
                    String stats = model.getStatsForClass(selectedClass);
                    view.updateStatsTextArea(stats); // Display class-specific stats in the GUI
                }
            }
        });
    }
}
