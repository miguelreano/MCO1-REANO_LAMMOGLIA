import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

/**
 * Controls the interactions between the {@link GameLobbyGUI} and the {@link Character} model.
 * This class is responsible for handling actions within the game lobby such as navigating to
 * different parts of the game (e.g., fast travel, level up, inventory, and shop) as well as
 * quitting the game. It updates the game lobby's view based on interactions and changes to the
 * character model.
 */
public class GameLobbyController {
    private GameLobbyGUI view;
    private Character model;
    private Weapon[] weapons = new Weapon[25];
    private Weapon weapon;
    
    /**
     * Constructs a new GameLobbyController to manage interactions between the game lobby GUI and the character model.
     * Initializes the controller with the specified model and view, setting up action listeners for various
     * GUI elements to facilitate interactions like fast travel, leveling up, managing inventory, visiting the shop,
     * and quitting the game. It also updates the character stats display in the GUI.
     *
     * @param model The character model that holds the data to be displayed and modified in the game lobby.
     * @param view The game lobby GUI that displays the character's data and provides interaction options.
     */
    public GameLobbyController(Character model, GameLobbyGUI view) {
        this.model = model;
        this.view = view;
        //this.weapons = weapons.initializeWeapons();
        updateCharacterStatsDisplay();

        // Initialize action listeners for each button in the game lobby view
        view.addFastTravelButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                FastTravelGUI fastTravelGUI = new FastTravelGUI();
                FastTravelCtrl fastTravelCtrl = new FastTravelCtrl(null, fastTravelGUI, model);
            }
        });

        view.addLevelUpButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                LevelUpGUI levelUpGUI = new LevelUpGUI();
                LevelUpController levelUpController = new LevelUpController(levelUpGUI, model, null);
            }
        });

        view.addInventoryButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                GameLobby.Inventory(model); 
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
                view.dispose();
                Weapon[] weapons = new Weapon[25];
                weapons = Weapon.initializeWeapons();
                //GameLobby.Shop(weapons, model);
                //weapons = GameLobby.getWeapons();
                ShopGUI shopGUI = new ShopGUI(weapons, model);
            }
        });

        view.addQuitButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                TitleScreenGUI titleScreenGUI = new TitleScreenGUI();
                TitleScreenController titleScreenController = new TitleScreenController(titleScreenGUI);
            }
        });
        
    }

    /**
     * Updates the character stats display in the game lobby GUI. This method fetches the current
     * stats from the {@code model} and updates the {@code view} accordingly. It ensures the GUI
     * reflects the most up-to-date character information, specifically the character's stats, by
     * invoking the {@code view}'s methods to update the character model display and stats area.
     */
    private void updateCharacterStatsDisplay() {
        String characterStats = model.getCharacterStats().toString(); // Ensure CharacterStats has a suitable toString method
        SwingUtilities.invokeLater(() -> {
            view.updateCharacter(model);
            view.displayStatsTextArea(characterStats);
        });
    }
}
