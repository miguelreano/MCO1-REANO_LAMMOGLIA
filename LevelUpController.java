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
      
        Character.CharacterStats stats = user.getCharacterStats();
        updateCharacterStatsDisplay();
        view.addBackButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                GameLobbyGUI gameLobbyGUI = new GameLobbyGUI();
                GameLobbyController gameLobbyController = new GameLobbyController(user, gameLobbyGUI);
            }
        });

        view.addHPButtonListener(e -> { 
            Character.CharacterStats currentStats = user.getCharacterStats();
            currentStats.setHP(currentStats.getHP() + 1);
            currentStats.setPlayerLevel(currentStats.getPlayerLevel() + 1);
            updateCharacterStatsDisplay();
        });
        view.addENDButtonListener(e -> {
            Character.CharacterStats currentStats = user.getCharacterStats();
            currentStats.setEND(currentStats.getEND() + 1);
            currentStats.setPlayerLevel(currentStats.getPlayerLevel() + 1);
            updateCharacterStatsDisplay();
        });

        // DEX Button Listener
        view.addDEXButtonListener(e -> {
            Character.CharacterStats currentStats = user.getCharacterStats();
            currentStats.setDEX(currentStats.getDEX() + 1);
            currentStats.setPlayerLevel(currentStats.getPlayerLevel() + 1);
            updateCharacterStatsDisplay();
        });

        // STR Button Listener
        view.addSTRButtonListener(e -> {
            Character.CharacterStats currentStats = user.getCharacterStats();
            currentStats.setSTR(currentStats.getSTR() + 1);
            currentStats.setPlayerLevel(currentStats.getPlayerLevel() + 1);
            updateCharacterStatsDisplay();
        });

        // INT Button Listener
        view.addINTButtonListener(e -> {
            Character.CharacterStats currentStats = user.getCharacterStats();
            currentStats.setINT(currentStats.getINT() + 1);
            currentStats.setPlayerLevel(currentStats.getPlayerLevel() + 1);
            updateCharacterStatsDisplay();
        });

        // FTH Button Listener
        view.addFTHButtonListener(e -> {
            Character.CharacterStats currentStats = user.getCharacterStats();
            currentStats.setFTH(currentStats.getFTH() + 1);
            currentStats.setPlayerLevel(currentStats.getPlayerLevel() + 1);
            updateCharacterStatsDisplay();
        });
    }

    
    private void updateCharacterStatsDisplay() {
        String characterStats = user.getCharacterStats().toString(); // Ensure CharacterStats has a suitable toString method
        SwingUtilities.invokeLater(() -> {
            view.displayStatsTextArea(characterStats);
        });
    }

}
