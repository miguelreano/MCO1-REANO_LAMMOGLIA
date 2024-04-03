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
        this.view.addBackButtonListener(new BackButtonListener());
        initView();
        updateView();
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
            updateView(); // You might need to adjust this to ensure the view is updated correctly
        
    }



    private void updateView() {
        // Format and set the character's stats text in the GUI's text area
        Character.CharacterStats stats = user.getCharacterStats();
        String statsText = String.format("Class: %s\nHP: %d\nEND: %d\nDEX: %d\nSTR: %d\nINT: %d\nFTH: %d\nLevel: %d",
                                         stats.getClassName(), stats.getHP(), stats.getEND(), stats.getDEX(), 
                                         stats.getSTR(), stats.getINT(), stats.getFTH(), stats.getPlayerLevel());
        view.getStatsTextArea().setText(statsText);
    }

    class BackButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.dispose();
            GameLobbyGUI gameLobbyGUI = new GameLobbyGUI();
            GameLobby gameLobby = new GameLobby();
            GameLobbyController gameLobbyController = new GameLobbyController(gameLobby, gameLobbyGUI);
        }
    }

}
