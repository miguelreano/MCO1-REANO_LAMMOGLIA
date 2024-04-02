import java.awt.event.ActionEvent;
import javax.swing.SwingUtilities;
import java.awt.event.ActionListener;

public class LevelUpController {
    private LevelUpGUI view;
    private Character user;

    public LevelUpController(LevelUpGUI view, Character user) {
        this.view = view;
        this.user = user;
        this.view.addBackButtonListener(new BackButtonListener());
        initView();
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
        }
        // Increment player level with each attribute increase
        stats.setPlayerLevel(stats.getPlayerLevel() + 1);
        updateView();
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
        //@Override
        public void actionPerformed(ActionEvent e) {
            view.dispose();
            GameLobbyGUI gameLobbyGUI = new GameLobbyGUI();
            GameLobby gameLobby = new GameLobby();
            GameLobbyController gameLobbyController = new GameLobbyController(gameLobby, gameLobbyGUI);
        }
    }

}
