import java.util.Random;

public class GameAreaModel2 {
    private final int[][] FLOORS = {{5,5}, {7,3}, {7,5}, {3,6}, {8,7}};
    private final int[][] START_POS = {{0,2}, {0,1}, {3,0}, {1,0}, {7,3}};
    private final int[][] DOORS ={{4,2}, {3,2}, {0,2}};
    public int currentFloor2 = 0;

    private final int[][] SPAWNS1 = {{3,1}, {3,3}};
    private final int[][] SPAWNS2 = {{1,0}, {3,0}, {5,0}};
    private final int[][] SPAWNS3 = {{5,2}, {1,2}};
    private final int[][] SPAWNS4 = {{0,2}, {0,4}, {2,2}, {2,4}};

    private final int[] BOSS_TILE = {4,3};

    private final int[] FAST_TRAVEL_TILE = {0,3};

    public String isDoor(int x, int y) {
        if (currentFloor2 == 1) {
            if (x == DOORS[currentFloor2][1] && y == DOORS[currentFloor2][0]) {
                return "UP";
            }
            
            if (x == START_POS[currentFloor2][1] && y == START_POS[currentFloor2][0]) {
                return "DOWN";
            }
        }
        else if (currentFloor2 == 2) {
            if (x == DOORS[currentFloor2][1] && y == DOORS[currentFloor2][0]) {
                return "DOWN";
            }
        }
        else if (x == DOORS[currentFloor2][1] && y == DOORS[currentFloor2][0])
            return "UP";
        else if (x == FAST_TRAVEL_TILE[1] && y == FAST_TRAVEL_TILE[0])
            return "FAST-TRAVEL";

        return "NOPE";
    }

    public boolean isSpawn(int x, int y) {
        if (currentFloor2 == 0) {
            for (int[] i : SPAWNS1) {
                if (x == i[1] && y == i[0]) return true;
            }
        } 
        else if (currentFloor2 == 1) {
            for (int[] i : SPAWNS2) {
                if (x == i[1] && y == i[0]) return true;
            }
        }  
        else if (currentFloor2 == 2) {
                for (int[] i : SPAWNS3) {
                    if (x == i[1] && y == i[0]) return true;
                }
        }
        else if (currentFloor2 == 3) {
            for (int[] i : SPAWNS4) {
                    if (x == i[1] && y == i[0]) return true;
            }
        } else if (currentFloor2 == 4) return x == BOSS_TILE[1] && y == BOSS_TILE[0];
        
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

    public int[] getFloorDimension2() {
        return FLOORS[currentFloor2];
    }

    public void setCurrentFloor2(int num) {
        this.currentFloor2 = num;
    }

    public int getCurrentFloor2() {
        return this.currentFloor2;
    }

    public int[] getStartPos2() {
        return START_POS[currentFloor2];
    }

    public int getSpawnLen2() {
        if (currentFloor2 == 0) return SPAWNS1.length;
        else if (currentFloor2 == 1) return SPAWNS2.length;
        return 0;
    }


}
