import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JOptionPane;

public class GameAreaController2 {
    private Character player;
    private GameAreaGUI2 gameArea2;
    private GameAreaModel2 model;
    private int NUM_ROWS;
    private int NUM_COLS;

    public GameAreaController2(Character player, GameAreaGUI2 gameArea2, GameAreaModel2 model) {
        this.player = player;
        this.gameArea2 = gameArea2;
        this.model = model;
        
        int[] dimensions = this.model.getFloorDimension2();
        this.NUM_ROWS = dimensions[0];
        this.NUM_COLS = dimensions[1];

        updateCharacterStatsDisplay();

        this.gameArea2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPress(e);
            }
        });
        this.gameArea2.setFocusable(true);
    }

    private void handleKeyPress(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_W:
                if (gameArea2.getPlayerY() > 0) {
                    gameArea2.movePlayerUp();
                    gameArea2.updateGameArea();
                    checkIfDoor();
                    checkifSpawn();
                }
                break;
            case KeyEvent.VK_S:
                if (gameArea2.getPlayerY() < NUM_ROWS - 1) {
                    gameArea2.movePlayerDown();
                    gameArea2.updateGameArea();
                    checkIfDoor();
                    checkifSpawn();
                }
                break;
            case KeyEvent.VK_A:
                if (gameArea2.getPlayerX() > 0) {
                    gameArea2.movePlayerLeft();
                    gameArea2.updateGameArea();
                    checkIfDoor();
                    checkifSpawn();
                }
                break;
            case KeyEvent.VK_D:
                if (gameArea2.getPlayerX() < NUM_COLS - 1) {
                    gameArea2.movePlayerRight();
                    gameArea2.updateGameArea();
                    checkIfDoor();
                    checkifSpawn();
                }
                break;

        }
    }

    private void checkifSpawn() {
        if (this.model.isSpawn(gameArea2.getPlayerX(), gameArea2.getPlayerY())) {
            System.out.println("You've reached a spawn point.");
            if (this.model.generateRandomNumber() == 3) {
                int runesObtained = this.model.treasureRunes();
                JOptionPane.showMessageDialog(null, "It's your lucky day! You reached a treasure tile\nYou won this much runes:" + runesObtained);
                this.player.setRunes(this.player.getRunes() + runesObtained);
            } 
            else {
                Character.CharacterStats characterStats = this.player.getCharacterStats();                
                Spawn[] spawnss = Spawn.initializeSpawn();
                Spawn chosenSpawn = spawnss[new Random().nextInt(this.model.getSpawnLen2())]; // Select a random spawn
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
                    GameLobbyController gameLobbyController2 = new GameLobbyController(this.player, gameLobbyGUI);
                    this.gameArea2.dispose();
                    gameLobbyGUI.setVisible(true);
                }
            }
        }
    }

    private void checkIfDoor() {
        String isDoor = this.model.isDoor(gameArea2.getPlayerX(), gameArea2.getPlayerY());
        if (isDoor.equals("UP")) {
            this.model.setCurrentFloor2(this.model.getCurrentFloor2() + 1);
            int[] dimensions = this.model.getFloorDimension2();
            int[] pos = this.model.getStartPos2();

            this.gameArea2.dispose();
            GameAreaGUI2 gameAreaGUI2 = new GameAreaGUI2(dimensions[0], dimensions[1], pos[1], pos[0]); // Create a new GameAreaGUI
            GameAreaController2 gameAreaController2 = new GameAreaController2(this.player, gameAreaGUI2, this.model);
        }
        else if (isDoor.equals("DOWN")) {
            this.model.setCurrentFloor2(this.model.getCurrentFloor2() - 1);
            int[] dimensions = this.model.getFloorDimension2();
            int[] pos = this.model.getStartPos2();

            this.gameArea2.dispose();

            GameAreaGUI2 gameAreaGUI2 = new GameAreaGUI2(dimensions[0], dimensions[1], pos[1], pos[0]); // Create a new GameAreaGUI
            GameAreaController2 gameAreaController2 = new GameAreaController2(this.player, gameAreaGUI2, this.model);
        }
        else if (isDoor.equals("FAST-TRAVEL")) {
            JOptionPane.showMessageDialog(null, "You have reached the end of this map! Redirecting you to the Game Lobby...");

            // Proceed to game lobby
            GameLobbyGUI gameLobbyGUI = new GameLobbyGUI();
            GameLobbyController gameLobbyController2 = new GameLobbyController(this.player, gameLobbyGUI);
            this.gameArea2.dispose();
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
        gameArea2.displayStatsTextArea(characterStats);
    }
}
