//import Character.CharacterStats;

import java.util.Random;

public class GameAreaModel3 extends GameAreaModel {
    private final int[][] FLOORS = {{9,3}, {7,7}, {9,3}}; 
    private final int[][] START_POS = {{6,1}, {6,3}, {6,2}}; 
    private final int[][] DOORS = {{0,1}, {0, 3}, {6,2}}; 
    private int currentFloor = 0;
    private int bossFloor = 2;

    private final int[][] SPAWNS1 = {{4,1}, {0,0}}; // Spawn positions for the first floor
    
    private final int[][] SPAWNS3 = {
        {7,0}, {7,2}, {5,0}, {5,2}, {3,0}, {3,2}, {1,0}, {1,2}// 2nd floor Spawn positions                                                                                      
    };

    private final int[] BOSS_TILE = { 3, 3 }; // Boss position for the third floor

    private final int[] FAST_TRAVEL_TILE = { 0, 1 }; // Fast travel position for the third floor

    public String isDoor(int x, int y) {
        if (currentFloor == 1) {
            if (x == DOORS[currentFloor][1] && y == DOORS[currentFloor][0]) {
                return "UP";
            }
            
            if (x == START_POS[currentFloor][1] && y == START_POS[currentFloor][0]) {
                return "DOWN";
            }
        }
        else if (currentFloor == 2) {
            if (x == DOORS[currentFloor][1] && y == DOORS[currentFloor][0]) {
                return "DOWN";
            }
        }
        else if (x == DOORS[currentFloor][1] && y == DOORS[currentFloor][0])
            return "UP";
        else if (x == FAST_TRAVEL_TILE[1] && y == FAST_TRAVEL_TILE[0])
            return "FAST-TRAVEL";

        return "NOPE";
    }

    public boolean isBoss(int x, int y) {
        return  this.currentFloor == this.bossFloor && x == BOSS_TILE[1] && y == BOSS_TILE[0];
    }

    public boolean isSpawn(int x, int y) {
        if (currentFloor == 0) {
            for (int[] i : SPAWNS1) {
                if (x == i[1] && y == i[0]) return true;
            }
        } 
        else if (currentFloor == 1) {
            for (int[] i : SPAWNS3) {
                if (x == i[1] && y == i[0]) return true;
            }
        }
        
        return false;
    }



    /**
     * Generates a random number of runes for the player to collect at treasure spawn points.
     * 
     * @return The number of runes generated.
     */
    public int treasureRunes() {
        Random random = new Random(); // Create a Random object
        int min = 50; // Set the minimum number (inclusive)
        int max = 150; // Set the maximum number (exclusive)
        return random.nextInt(max - min) + min; // Generate and return the random number
    }

    /**
     * Generates a random number used to determine if a spawn point will yield treasure.
     * 
     * @return A random number between 1 and 4.
     */
    public int generateRandomNumber() {
        Random randa = new Random();
        return randa.nextInt(4) + 1; // Generate a number between 0-3 and then add 1
    }

    public int[] getFloorDimension() {
        return FLOORS[currentFloor];
    }

    public void setCurrentFloor(int num) {
        this.currentFloor = num;
    }

    public int getCurrentFloor() {
        return this.currentFloor;
    }

    public int[] getStartPos() {
        return START_POS[currentFloor];
    }

    public int getSpawnLen() {
        if (currentFloor == 0) return SPAWNS1.length;
        else if (currentFloor == 1) return SPAWNS3.length;
        return 0;
    }

    
} 




