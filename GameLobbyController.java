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
                FastTravelGUI fastTravelGUI = new FastTravelGUI();
                FastTravelCtrl fastTravelCtrl = new FastTravelCtrl(null, fastTravelGUI);
                //GameLobbyController gameLobbyController = new GameLobbyController(null, gameLobbyGUI);
            }
        });

        view.addLevelUpButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                LevelUpGUI levelUpGUI = new LevelUpGUI();
                LevelUpController levelUpController = new LevelUpController(levelUpGUI, model, null);
                //GameLobbyGUI gameLobbyGUI = new GameLobbyGUI();
                //GameLobbyController gameLobbyController = new GameLobbyController(null, gameLobbyGUI);
            }
        });

        view.addInventoryButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Hide the GUI to shift focus to the terminal
                view.setVisible(false);
    
                // Call the inventory interaction
                GameLobby.Inventory(model); // Assuming `model` is your character object
    
                // After exiting the inventory, make the GUI visible and refresh
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        updateCharacterStatsDisplay();
                        view.setVisible(true);
                    }
                });
            }
        });

        view.addShopButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Hide the GUI to prevent interaction while in terminal mode
                view.setVisible(false);

                // Assuming GameLobby.Shop() is correctly defined to handle terminal-based shop logic
                // And assuming model.getWeapons() correctly retrieves an array of Weapon objects
                Weapon[] weapons = Weapon.initializeWeapons();
                GameLobby.Shop(weapons, model);


                // After the shop interaction completes, update and make the GUI visible again
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        updateCharacterStatsDisplay();
                        view.setVisible(true);
                    }
                });
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
