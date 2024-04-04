import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.awt.event.ActionListener;

public class LevelUpController {
    private LevelUpGUI view;
    private Character user;
    
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

    private int calculateRuneCost() {
        return (user.getCharacterStats().getPlayerLevel() * 100) / 2;
    }

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

    private void updateCharacterStatsDisplay() {
        String characterStats = user.getCharacterStats().toString(); // Ensure CharacterStats has a suitable toString method
        SwingUtilities.invokeLater(() -> {
            view.displayStatsTextArea(characterStats);
        });
    }

    private void displayInsufficientRunesMessage() {
    SwingUtilities.invokeLater(() -> {
        JOptionPane.showMessageDialog(view, "You do not have enough runes to level up.", "Insufficient Runes", JOptionPane.WARNING_MESSAGE);
    });
}

}
