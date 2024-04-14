import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JOptionPane;

public class GameAreaController {
    private Character player;
    private GameAreaGUI gameArea;
    private GameAreaModel model;
    private int NUM_ROWS;
    private int NUM_COLS;

    public GameAreaController(Character player, GameAreaGUI gameArea, GameAreaModel model) {
        this.player = player;
        this.gameArea = gameArea;
        this.model = model;
        init();
    }

    private void init() {
        int[] dimensions = this.model.getFloorDimension();
        this.NUM_ROWS = dimensions[0];
        this.NUM_COLS = dimensions[1];

        updateCharacterStatsDisplay();

        this.gameArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPress(e);
            }
        });
        this.gameArea.setFocusable(true);
    }

    private void handleKeyPress(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_W:
                if (gameArea.getPlayerY() > 0) {
                    gameArea.movePlayerUp();
                    checkAll();
                }
                break;
            case KeyEvent.VK_S:
                if (gameArea.getPlayerY() < NUM_ROWS - 1) {
                    gameArea.movePlayerDown();
                    checkAll();
                }
                break;
            case KeyEvent.VK_A:
                if (gameArea.getPlayerX() > 0) {
                    gameArea.movePlayerLeft();
                    checkAll();
                }
                break;
            case KeyEvent.VK_D:
                if (gameArea.getPlayerX() < NUM_COLS - 1) {
                    gameArea.movePlayerRight();
                    checkAll();
                }
                break;

        }
    }

    private void checkAll() {
        gameArea.updateGameArea();
        checkIfDoor();
        checkifSpawn();
        checkifBoss();
    }


    private void battleEnemy(Battle battle, String intro, Boss theBoss) {
        Character.CharacterStats characterStats = this.player.getCharacterStats();                
        String message;

        while (characterStats.getHP() > 0 && battle.getEnemyHealth() > 0) {
            int option = JOptionPane.showOptionDialog(null, intro + "A fierce battle begins!\n\n" + battle.displayInitialBattleState() +"\n\nChoose an action:", "Player Turn", JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE, null, new String[]{"2. Dodge", "1. Attack"}, null);

            // Determine which option was selected
            if (option == JOptionPane.NO_OPTION) {
                int attackType = JOptionPane.showOptionDialog(null, "Choose an option", "Popup", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, new String[]{"3. Incantation", "2. Sorcery", "1. Physical"}, null);
                
                // Determine which option was selected
                if (attackType == JOptionPane.CANCEL_OPTION) {
                    message = battle.executePlayerAttack(1);
                } else if (attackType == JOptionPane.NO_OPTION) {
                    message = battle.executePlayerAttack(2);
                } else { // (attackType == JOptionPane.CANCEL_OPTION)
                    message = battle.executePlayerAttack(3);
                }
                
                JOptionPane.showMessageDialog(null, message);

                if (battle.getEnemyHealth() > 0) {
                    message = battle.enemyTurn();
                    JOptionPane.showMessageDialog(null, message);
                }
            } else {
                if (battle.attemptDodge()) {
                    JOptionPane.showMessageDialog(null, "Dodge successful! Enemy's turn is skipped.");
                    return;
                }
                else {
                    message = battle.enemyTurn();
                    JOptionPane.showMessageDialog(null, message);
                }
            }
        }

        if (characterStats.getHP() > 0) {
            String endMessage = "";
            if (this.model.getCurrentFloor() == 2) {
                endMessage += "You have defeated the boss: " + theBoss.getBossname();
            } else {
                endMessage += "You got a battle tile!\nVictory! You defeated the spawn.\nGaining runes...";
            }
            
            JOptionPane.showMessageDialog(null, endMessage);
            this.player.addRunes(battle.getEnemyHealth() * 2); // Placeholder logic for rune reward
            updateCharacterStatsDisplay();
        } else {
            JOptionPane.showMessageDialog(null, "You have been defeated. Returning to the lobby...");
            this.player.setRunes(0); // Reset runes to 0
            // Proceed to game lobby
            GameLobbyGUI gameLobbyGUI = new GameLobbyGUI();
            GameLobbyController gameLobbyController = new GameLobbyController(this.player, gameLobbyGUI);
            this.gameArea.dispose();
            gameLobbyGUI.setVisible(true);
        }
    }

    private void checkifBoss() {
        if (this.model.isBoss(gameArea.getPlayerX(), gameArea.getPlayerY())) {
            // Assuming you've initialized bosses somewhere; select the appropriate boss
            Boss[] bosses = Boss.initializeBoss();
            Boss theBoss = bosses[0]; // Example: Selecting the first boss for the battle
            
            String message = "You've encountered the boss: " + theBoss.getBossname() + "\n\n";
            Battle battle = new Battle(this.player, theBoss);
            battleEnemy(battle, message, theBoss);
        }
    }

    private void checkifSpawn() {
        if (this.model.isSpawn(gameArea.getPlayerX(), gameArea.getPlayerY())) {
            System.out.println("You've reached a spawn point.");
            if (this.model.generateRandomNumber() == 3) {
                int runesObtained = this.model.treasureRunes();
                JOptionPane.showMessageDialog(null, "It's your lucky day! You reached a treasure tile\nYou won this much runes:" + runesObtained);
                this.player.setRunes(this.player.getRunes() + runesObtained);
            } 
            else {
                Spawn[] spawnss = Spawn.initializeSpawn();
                Spawn chosenSpawn = spawnss[new Random().nextInt(this.model.getSpawnLen())]; // Select a random spawn
                Battle battle = new Battle(this.player, chosenSpawn); // Assuming 'user' is your Character instance

                battleEnemy(battle, "", null);
            }
        }
    }

    private void checkIfDoor() {
        String isDoor = this.model.isDoor(gameArea.getPlayerX(), gameArea.getPlayerY());
        if (isDoor.equals("UP")) {
            this.model.setCurrentFloor(this.model.getCurrentFloor() + 1);
            int[] dimensions = this.model.getFloorDimension();
            int[] pos = this.model.getStartPos();

            this.gameArea.dispose();
            GameAreaGUI gameAreaGUI = new GameAreaGUI(dimensions[0], dimensions[1], pos[1], pos[0]); // Create a new GameAreaGUI
            GameAreaController gameAreaController = new GameAreaController(this.player, gameAreaGUI, this.model);
        }
        else if (isDoor.equals("DOWN")) {
            this.model.setCurrentFloor(this.model.getCurrentFloor() - 1);
            int[] dimensions = this.model.getFloorDimension();
            int[] pos = this.model.getStartPos();

            this.gameArea.dispose();

            GameAreaGUI gameAreaGUI = new GameAreaGUI(dimensions[0], dimensions[1], pos[1], pos[0]); // Create a new GameAreaGUI
            GameAreaController gameAreaController = new GameAreaController(this.player, gameAreaGUI, this.model);
        }
        else if (isDoor.equals("FAST-TRAVEL")) {
            JOptionPane.showMessageDialog(null, "You have reached the end of this map! Redirecting you to the Game Lobby...");

            // Proceed to game lobby
            GameLobbyGUI gameLobbyGUI = new GameLobbyGUI();
            GameLobbyController gameLobbyController = new GameLobbyController(this.player, gameLobbyGUI);
            this.gameArea.dispose();
            gameLobbyGUI.setVisible(true);
        }
    }

    /**
     * Updates the character stats display in the game lobby GUI. This method fetches the current
     * stats from the {@code model} and updates the {@code view} accordingly. It ensures the GUI
     * reflects the most up-to-date character information, specifically the character's stats, by
     * invoking the {@code view}'s methods to update the character model display and stats area.
     */
    private void updateCharacterStatsDisplay() {
        String characterStats = player.getCharacterStats().toString(); // Ensure CharacterStats has a suitable toString method
        gameArea.displayStatsTextArea(characterStats);
    }
}
