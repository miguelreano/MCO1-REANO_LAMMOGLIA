import java.awt.event.ActionEvent;
import javax.swing.SwingUtilities;
import java.awt.event.ActionListener;

public class LevelUpController {
    private LevelUpGUI view;
    private Character user;
    private GameLobby gameLobby;

    public LevelUpController(LevelUpGUI view, Character user, GameLobby gameLobby) {
        this.view = view;
        this.user = user;
        this.gameLobby = gameLobby;
        initView();
        updateCharacterStatsDisplay();

        view.addBackButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                transitionToGameLobby();
                //GameLobbyGUI gameLobbyGUI = new GameLobbyGUI(); add back
                //GameLobbyController gameLobbyController = new GameLobbyController(user, gameLobbyGUI);
            }
        });
    }

    private void updateCharacterStatsDisplay() {
        String characterStats = user.getCharacterStats().toString(); // Ensure CharacterStats has a suitable toString method
        SwingUtilities.invokeLater(() -> {
            view.displayStatsTextArea(characterStats);
        });
    }

    private void initView() {
        // Hook up the action listeners to the buttons using the methods provided in the LevelUpGUI class
        view.addLevelHPButtonListener(e -> levelUp("HP"));
        view.addLevelENDButtonListener(e -> levelUp("END"));
        view.addLevelDEXButtonListener(e -> levelUp("DEX"));
        view.addLevelSTRButtonListener(e -> levelUp("STR"));
        view.addLevelINTButtonListener(e -> levelUp("INT"));
        view.addLevelFTHButtonListener(e -> levelUp("FTH"));
        
    }

    private void levelUp(String attribute) {
            // Assuming you have a reference to the GameLobby instance
            gameLobby.levelUpCharacter(attribute);
            updateCharacterStatsDisplay(); // You might need to adjust this to ensure the view is updated correctly
        
    }

    //remove
    private void transitionToGameLobby() {
        SwingUtilities.invokeLater(() -> {
            try {
                if (view != null) {
                    view.dispose(); // Ensure the current view is disposed properly
                }
                GameLobbyGUI gameLobbyGUI = new GameLobbyGUI(); // Initialize the Game Lobby GUI
                new GameLobbyController(user, gameLobbyGUI); // Initialize the Game Lobby Controller with the current user model
                // Make sure GameLobbyGUI is made visible if it's not automatically done in its constructor
                gameLobbyGUI.setVisible(true);
            } catch (Exception ex) {
                ex.printStackTrace();
                // Handle any exceptions, possibly show an error message to the user
            }
        });
    }

}
