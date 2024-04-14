import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JOptionPane;

public class GameAreaController3 {
    private Character player;
    private GameAreaGUI3 gameArea3;
    private GameAreaModel3 model;
    private int NUM_ROWS;
    private int NUM_COLS;

    public GameAreaController3(Character player, GameAreaGUI3 gameArea3, GameAreaModel3 model) {
        this.player = player;
        this.gameArea3 = gameArea3;
        this.model = model;
        
        int[] dimensions = this.model.getFloorDimension3();
        this.NUM_ROWS = dimensions[0];
        this.NUM_COLS = dimensions[1];

        updateCharacterStatsDisplay();

        this.gameArea3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPress(e);
            }
        });
        this.gameArea3.setFocusable(true);
    }

    private void handleKeyPress(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_W:
                if (gameArea3.getPlayerY() > 0) {
                    gameArea3.movePlayerUp();
                    gameArea3.updateGameArea();
                    checkIfDoor();
                    checkifSpawn();
                }
                break;
            case KeyEvent.VK_S:
                if (gameArea3.getPlayerY() < NUM_ROWS - 1) {
                    gameArea3.movePlayerDown();
                    gameArea3.updateGameArea();
                    checkIfDoor();
                    checkifSpawn();
                }
                break;
            case KeyEvent.VK_A:
                if (gameArea3.getPlayerX() > 0) {
                    gameArea3.movePlayerLeft();
                    gameArea3.updateGameArea();
                    checkIfDoor();
                    checkifSpawn();
                }
                break;
            case KeyEvent.VK_D:
                if (gameArea3.getPlayerX() < NUM_COLS - 1) {
                    gameArea3.movePlayerRight();
                    gameArea3.updateGameArea();
                    checkIfDoor();
                    checkifSpawn();
                }
                break;

        }
    }

    private void checkifSpawn() {
        if (this.model.isSpawn(gameArea3.getPlayerX(), gameArea3.getPlayerY())) {
            System.out.println("You've reached a spawn point.");
            if (this.model.generateRandomNumber() == 3) {
                int runesObtained = this.model.treasureRunes();
                JOptionPane.showMessageDialog(null, "It's your lucky day! You reached a treasure tile\nYou won this much runes:" + runesObtained);
                this.player.setRunes(this.player.getRunes() + runesObtained);
            } 
            else {
                Character.CharacterStats characterStats = this.player.getCharacterStats();                
                Spawn[] spawnss = Spawn.initializeSpawn();
                Spawn chosenSpawn = spawnss[new Random().nextInt(this.model.getSpawnLen3())]; // Select a random spawn
                Battle battle = new Battle(this.player, chosenSpawn); // Assuming 'user' is your Character instance
                String message;

                while (characterStats.getHP() > 0 && battle.getEnemyHealth() > 0) {
                    int option = JOptionPane.showOptionDialog(null, "A fierce battle begins!\n\n" + battle.displayInitialBattleState() +"\n\nChoose an action:", "Player Turn", JOptionPane.YES_NO_OPTION,
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
                    JOptionPane.showMessageDialog(null, "You got a battle tile!\nVictory! You defeated the spawn.\nGaining runes...");
                    this.player.addRunes(battle.getEnemyHealth() * 2); // Placeholder logic for rune reward
                    updateCharacterStatsDisplay();
                } else {
                    JOptionPane.showMessageDialog(null, "You got a battle tile!\nDefeat! Returning to lobby...");
                    this.player.setRunes(0); // Reset runes to 0
                    // Proceed to game lobby
                    GameLobbyGUI gameLobbyGUI = new GameLobbyGUI();
                    GameLobbyController gameLobbyController = new GameLobbyController(this.player, gameLobbyGUI);
                    this.gameArea3.dispose();
                    gameLobbyGUI.setVisible(true);
                }
            }
        }
    }

    private void checkIfDoor() {
        String isDoor = this.model.isDoor(gameArea3.getPlayerX(), gameArea3.getPlayerY());
        if (isDoor.equals("UP")) {
            this.model.setCurrentFloor3(this.model.getCurrentFloor3() + 1);
            int[] dimensions = this.model.getFloorDimension3();
            int[] pos = this.model.getStartPos3();

            this.gameArea3.dispose();
            GameAreaGUI3 gameAreaGUI3 = new GameAreaGUI3(dimensions[0], dimensions[1], pos[1], pos[0]); // Create a new GameAreaGUI
            GameAreaController3 gameAreaController3 = new GameAreaController3(this.player, gameAreaGUI3, this.model);
        }
        else if (isDoor.equals("DOWN")) {
            this.model.setCurrentFloor3(this.model.getCurrentFloor3() - 1);
            int[] dimensions = this.model.getFloorDimension3();
            int[] pos = this.model.getStartPos3();

            this.gameArea3.dispose();

            GameAreaGUI3 gameAreaGUI3 = new GameAreaGUI3(dimensions[0], dimensions[1], pos[1], pos[0]); // Create a new GameAreaGUI
            GameAreaController3 gameAreaController3 = new GameAreaController3(this.player, gameAreaGUI3, this.model);
        }
        else if (isDoor.equals("FAST-TRAVEL")) {
            JOptionPane.showMessageDialog(null, "You have reached the end of this map! Redirecting you to the Game Lobby...");

            // Proceed to game lobby
            GameLobbyGUI gameLobbyGUI = new GameLobbyGUI();
            GameLobbyController gameLobbyController = new GameLobbyController(this.player, gameLobbyGUI);
            this.gameArea3.dispose();
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
        gameArea3.displayStatsTextArea(characterStats);
    }
}
