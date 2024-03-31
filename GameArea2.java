import java.util.Scanner;
import java.util.Random;


public class GameArea2 {

    private static final int ROW1 = 5;
    private static final int COL1 = 5;
    private static final int ROW2 = 7;
    private static final int COL2 = 3;
    private static final int ROW3 = 7;
    private static final int COL3 = 5;
    private static final int ROW4 = 3;
    private static final int COL4 = 6;
    private static final int BossROW = 8;
    private static final int BossCOL = 7;

    private static int currentPosX;
    private static int currentPosY;

    private static final int[] DOOR1 = {4,2};
    private static final int[][] DOOR2 = {{0,1}, {3,2}};
    private static final int[][] DOOR3 = {{3,0}, {0,2}};
    //private static final int[] DOOR4 = {1,0};

    private static final int[][] BossBOUNDS = {{0,0}, {0,1}, {0,5}, {0,6}};
    private static int[][] BOUNDS3 = {{0,0}, {1,0}, {0,4}, {1,4}, {5,0}, {6,0}, {5,4}, {6,4}};

    private static int[][] SPAWN1 = {{3,1}, {3,3}};
    private static int[][] SPAWN2 = {{1,0}, {3,0}, {5,0}};
    private static int[][] SPAWN3 = {{5,2}, {1,2}};
    //private static int[][] SPAWN4 = {{0,2}, {0,4}, {2,2}, {2,4}};
    private static int[][] BossSPAWN = {{2,1}, {2,3}, {2,5}, {4,1}, {4,5}, {6,1}, {6,5}};

    private static int[] BOSSTILE = {4,3};
    //sprivate static int[] FT1 = {0,2};
    private static int[] FTB = {4,3};

    private static Character.CharacterStats characterStats;

    public static boolean firstFloor(Scanner scanner){
        currentPosX = 0;
        currentPosY = 2;
        boolean doorReached = floorLogic(scanner, ROW1, COL1, new int[][]{DOOR1}, SPAWN1,
        "You've reached the door of the first floor...");
        if (doorReached) {
        SecondFloor(scanner);
        }
        return doorReached;

        
    }

    public static boolean SecondFloor(Scanner scanner){
        currentPosX = 0;
        currentPosY = 1;
        boolean doorReached = floorLogic(scanner, ROW2, COL2, DOOR2, SPAWN2,
        "You've reached the door of the second floor...");
        if (doorReached) {
            ThirdFloor(scanner);
        }
        return doorReached;

    }

    public static boolean ThirdFloor(Scanner scanner){
        currentPosX=3;
        currentPosY=0;
        boolean doorReached = floorLogic(scanner, ROW3, COL3, DOOR3, SPAWN3,
        "You've reached the door of the second floor...");
        if (doorReached) {
            BossFloor(scanner);
        }
        return doorReached;
        
    }

    public static void BossFloor(Scanner scanner){
        currentPosX = 7; // Starting position for the third floor
        currentPosY = 3;
        boolean gameRunning = true;
        
        while (gameRunning) {
            System.out.print("\033\143");
            printGameBoard(BossROW, BossCOL, currentPosX, currentPosY);
            System.out.println("Choose your move: [W] Up, [S] Down, [D] Right, [A] Left");
            String choice = scanner.nextLine();

            updatePosition(choice, BossROW, BossCOL);

            if (isTile(currentPosX, currentPosY, BOSSTILE)) {
                System.out.print("\033\143");
                System.out.println("You've encountered a Boss but can still move to tiles.");
                Menus.Pause();
            }

            if (isTile(currentPosX, currentPosY, FTB)) {
                gameRunning = false;
                System.out.print("\033\143");
                System.out.println("You have reached the end of this map! Redirecting you to the Game Lobby...");
                Menus.Pause();
                Menus.menusGameLobby(characterStats);
            }
        }

    }
    /**
     * Updates the player's position based on the input command. It prevents movement
     * outside the bounds of the game board.
     * 
     * @param choice The player's movement choice.
     * @param rows The number of rows in the current floor.
     * @param cols The number of columns in the current floor.
     */
   private static void updatePosition(String choice, int rows, int cols, int[][] bounds) {
    int nextPosX = currentPosX;
    int nextPosY = currentPosY;
    switch (choice.toLowerCase()) {
        case "w": // Move Up
            nextPosX--;
            break;
        case "s": // Move Down
            nextPosX++;
            break;
        case "d": // Move Right
            nextPosY++;
            break;
        case "a": // Move Left
            nextPosY--;
            break;
        default:
            System.out.print("\033\143");
            System.out.println("Invalid input. Please choose a valid move.");
            Menus.Pause();
            return;
    }

    // Check for out-of-bounds or moving into a boundary
    if (nextPosX >= 0 && nextPosX < rows && nextPosY >= 0 && nextPosY < cols && !isInBounds(nextPosX, nextPosY, bounds)) {
        currentPosX = nextPosX;
        currentPosY = nextPosY;
    } else {
        System.out.print("\033\143");
        System.out.println("Cannot move there. You've reached an edge or a boundary.");
    }
}

private static boolean isInBounds(int x, int y, int[][] bounds) {
    for (int[] bound : bounds) {
        if (x == bound[0] && y == bound[1]) {
            return true;
        }
    }
    return false;
}

    private static boolean floorLogic(Scanner scanner, int rows, int cols, int[][] doors, int[][] spawns,
        String doorMessage) {
    boolean reachedDoor = false;
    Character user = new Character();
    while (!reachedDoor) {
        System.out.print("\033\143");
        printGameBoard(rows, cols, currentPosX, currentPosY);
        System.out.println("Choose your move: [W] Up, [S] Down, [D] Right, [A] Left");
        String choice = scanner.nextLine();

        updatePosition(choice, rows, cols);

        for (int[] currentDoor : doors) {
            if (isTile(currentPosX, currentPosY, currentDoor)) {
                System.out.print("\033\143");
                System.out.println(doorMessage);
                Menus.Pause();
                reachedDoor = true;
                break; // Exit the loop if a door is reached
            }
        }
        
        // Removed the incorrect if statement checking for `door`

        for (int[] spawn : spawns) {
            if (isTile(currentPosX, currentPosY, spawn)) {
                System.out.print("\033\143");
                System.out.println("You've reached a spawn point.");
                Menus.Pause();
                if (generateRandomNumber() == 3) {
                    System.out.print("\033\143");
                    System.out.println("\nIt's your lucky day! You reached a treasure tile");
                    int runesObtained = treasureRunes();
                    System.out.println("\nYou won this much runes:" + runesObtained);
                    user.setRunes(user.getRunes() + runesObtained);
                    Menus.Pause();
                } else {
                    System.out.print("\033\143");
                    System.out.println("\nYou got a battle tile!");
                    Menus.Pause();
                }
                break;
            }
        }
    }
    return reachedDoor;
    }

    private static void printGameBoard(int rows, int cols, int x, int y) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == x && j == y)
                    System.out.print("| ? |");
                else
                    System.out.print("|   |");
            }
            System.out.println();
        }
    }
    
    private static boolean isTile(int x, int y, int[] tile) {
        return x == tile[0] && y == tile[1];
    }

    public static int generateRandomNumber() {
        Random randa = new Random();
        return randa.nextInt(4) + 1; // Generate a number between 0-3 and then add 1
    }

    public static int treasureRunes() {
        Random random = new Random(); // Create a Random object
        int min = 50; // Set the minimum number (inclusive)
        int max = 150; // Set the maximum number (exclusive)
        return random.nextInt(max - min) + min; // Generate and return the random number
    }


}
