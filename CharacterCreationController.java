import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CharacterCreationController {
    private CharacterCreationGUI view;
    private Character model;

    public CharacterCreationController(CharacterCreationGUI view, Character model) {
        this.view = view;
        this.model = model;

        this.view.addConfirmButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Validate input before proceeding
                String name = view.getName().trim(); // Assuming getName() method exists and fetches the character name from the GUI
                String selectedClass = view.getSelectedClass().trim(); // Assuming getSelectedClass() method exists and fetches the selected class from the GUI
                
                // Check if the name and class have been entered
                if (name.isEmpty() || selectedClass.isEmpty()) {
                    JOptionPane.showMessageDialog(view, "You must enter a name and select a class to proceed.", "Missing Information", JOptionPane.WARNING_MESSAGE);
                } else {
                    model.setCharacterName(name);
                    model.selectClass(selectedClass); // Assuming selectClass() updates the model based on the selected class
                    
                    view.dispose(); // Close the current GUI
                    
                    // Proceed to Game Lobby
                    GameLobbyGUI gameLobbyGUI = new GameLobbyGUI();
                    GameLobbyController gameLobbyController = new GameLobbyController(model, gameLobbyGUI);
                    gameLobbyGUI.setVisible(true); // Assuming GameLobbyGUI has a method to make itself visible
                }
            }
        });

        this.view.addBackButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle back button action, for example, by showing the previous screen or closing the current window
                view.dispose(); // Close the current GUI
                // Here you might instantiate and show the title screen GUI again
            }
        });

        this.view.addSelectClassListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Assuming this method is called when a class is selected and updates the GUI accordingly
                String selectedClass = view.getSelectedClass();
                if (!selectedClass.isEmpty()) {
                    String stats = model.getStatsForClass(selectedClass);
                    view.updateStatsTextArea(stats); // Assuming updateStatsTextArea() updates the GUI with the character's stats
                }
            }
        });
    }
}
