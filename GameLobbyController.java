import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

public class GameLobbyController {
    private GameLobbyGUI view;
    private Character model;
    //Character character = new Character();
    public GameLobbyController(Character model, GameLobbyGUI view) {
        this.model = model;
        this.view = view;

        updateCharacterStatsDisplay();

        // Add action listeners to buttons in the view
        view.addFastTravelButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                //GameLobbyGUI gameLobbyGUI = new GameLobbyGUI();
                //GameLobbyController gameLobbyController = new GameLobbyController(null, gameLobbyGUI);
            }
        });

        view.addLevelUpButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                view.dispose();
                LevelUpGUI levelUpGUI = new LevelUpGUI();
                LevelUpController levelUpController = new LevelUpController(levelUpGUI, null, null);
                //GameLobbyGUI gameLobbyGUI = new GameLobbyGUI();
                //GameLobbyController gameLobbyController = new GameLobbyController(null, gameLobbyGUI);
            }
        });

        view.addInventoryButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                //GameLobbyGUI gameLobbyGUI = new GameLobbyGUI();
                //GameLobbyController gameLobbyController = new GameLobbyController(null, gameLobbyGUI);
            }
        });
        view.addShopButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                //GameLobbyGUI gameLobbyGUI = new GameLobbyGUI();
                //GameLobbyController gameLobbyController = new GameLobbyController(null, gameLobbyGUI);
            }
        });
        view.addFastTravelButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                //GameLobbyGUI gameLobbyGUI = new GameLobbyGUI();
                //GameLobbyController gameLobbyController = new GameLobbyController(null, gameLobbyGUI);
            }
        });

        view.addQuitButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                TitleScreenGUI titleScreenGUI = new TitleScreenGUI();
                TitleScreenController titleScreenController = new TitleScreenController(titleScreenGUI);
            }
        });
        
        //view.updateCharacterInfo(character);
    }

    private void updateCharacterStatsDisplay() {
        String characterStats = model.getCharacterStats().toString(); // Ensure CharacterStats has a suitable toString method
        SwingUtilities.invokeLater(() -> {
            view.updateCharacter(model);
            view.displayStatsTextArea(characterStats);
        });
    }
    

}
