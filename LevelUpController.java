import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.awt.event.ActionListener;

/**
 * Controls the interactions between the LevelUpGUI and the Character model for leveling up attributes.
 * This class handles the logic for updating character attributes when the player chooses to level up
 * using in-game runes. It also manages the display of the character's current stats and rune balance.
 */
public class LevelUpController {
    private LevelUpGUI view;
    private Character user;
    
    /**
     * Constructs a LevelUpController with a view and a character model.
     * Initializes the controller, sets up the initial display of character stats and runes,
     * and configures action listeners for the GUI's buttons.
     *
     * @param view       The GUI for leveling up the character.
     * @param user       The character model being leveled up.
     * @param gameLobby  The game lobby instance to return to after leveling up (currently not used directly in the controller).
     */
    public LevelUpController(LevelUpGUI view, Character user, GameLobby gameLobby) {
        this.view = view;
        this.user = user;

        updateCharacterStatsDisplay();
        view.updateRuneDisplay(user.getRunes());

        view.addBackButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                GameLobbyGUI gameLobbyGUI = new GameLobbyGUI();
                GameLobbyController gameLobbyController = new GameLobbyController(user, gameLobbyGUI);
            }
        });

        // Add the logic for checking runes and updating attributes within each listener
        // HP Button Listener
        view.addHPButtonListener(e -> {
            updateAttributeAndLevel("HP");
        });
        // END Button Listener
        view.addENDButtonListener(e -> {
            updateAttributeAndLevel("END");
        });
        // DEX Button Listener
        view.addDEXButtonListener(e -> {
            updateAttributeAndLevel("DEX");
        });
        // STR Button Listener
        view.addSTRButtonListener(e -> {
            updateAttributeAndLevel("STR");
        });
        // INT Button Listener
        view.addINTButtonListener(e -> {
            updateAttributeAndLevel("INT");
        });
        // FTH Button Listener
        view.addFTHButtonListener(e -> {
            updateAttributeAndLevel("FTH");
        });
    }
    
    /**
     * Updates the specified attribute of the character and levels up if there are sufficient runes.
     * If not enough runes are available, displays a message indicating insufficient runes.
     *
     * @param attribute The attribute to level up.
     */
    private void updateAttributeAndLevel(String attribute) {
        int runeCost = calculateRuneCost();
        if (user.getRunes() >= runeCost) {
            user.subtractRunes(runeCost);
            levelUpAttribute(attribute);
            user.getCharacterStats().setPlayerLevel(user.getCharacterStats().getPlayerLevel() + 1);
            updateCharacterStatsDisplay();
            view.updateRuneDisplay(user.getRunes());
        } else {
            displayInsufficientRunesMessage();
            //displayInsufficientRunesMessage();
        }
    }

    /**
     * Calculates the cost in runes to level up based on the character's current level.
     *
     * @return The rune cost for leveling up.
     */
    private int calculateRuneCost() {
        return (user.getCharacterStats().getPlayerLevel() * 100) / 2;
    }

    /**
     * Levels up the specified attribute of the character.
     *
     * @param attribute The attribute to be leveled up.
     */
    private void levelUpAttribute(String attribute) {
        Character.CharacterStats stats = user.getCharacterStats();
        switch (attribute) {
            case "HP":
                stats.setHP(stats.getHP() + 1);
                break;
            case "END":
                stats.setEND(stats.getEND() + 1);
                break;
            case "DEX":
                stats.setDEX(stats.getDEX() + 1);
                break;
            case "STR":
                stats.setSTR(stats.getSTR() + 1);
                break;
            case "INT":
                stats.setINT(stats.getINT() + 1);
                break;
            case "FTH":
                stats.setFTH(stats.getFTH() + 1);
                break;
            // No default case needed as we control the input
        }
    }

    /**
     * Updates the character stats display in the GUI.
     * Fetches the latest stats from the character model and updates the view.
     */
    private void updateCharacterStatsDisplay() {
        String characterStats = user.getCharacterStats().toString(); // Ensure CharacterStats has a suitable toString method
        SwingUtilities.invokeLater(() -> {
            view.displayStatsTextArea(characterStats);
        });
    }

    /**
     * Displays a message dialog indicating the player does not have enough runes to level up.
     */
    private void displayInsufficientRunesMessage() {
    SwingUtilities.invokeLater(() -> {
        JOptionPane.showMessageDialog(view, "You do not have enough runes to level up.", "Insufficient Runes", JOptionPane.WARNING_MESSAGE);
    });
}

}
