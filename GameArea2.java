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
    private static final int[][] DOOR3 = {{3,0}, {0,2}, {3,4}};
    private static final int[] DOOR4 = {1,0};
    private static final int[] BossDOOR = {7, 3};

    private static final int[][] BossBOUNDS = {{0,0}, {0,1}, {0,5}, {0,6}};
    private static int[][] BOUNDS3 = {{0,0}, {1,0}, {0,4}, {1,4}, {5,0}, {6,0}, {5,4}, {6,4}};

    private static int[][] SPAWN1 = {{3,1}, {3,3}};
    private static int[][] SPAWN2 = {{1,0}, {3,0}, {5,0}};
    private static int[][] SPAWN3 = {{5,2}, {1,2}};
    private static int[][] SPAWN4 = {{0,2}, {0,4}, {2,2}, {2,4}};
    private static int[][] BossSPAWN = {{2,1}, {2,3}, {2,5}, {4,1}, {4,5}, {6,1}, {6,5}};

    private static int[] BOSSTILE = {4,3};
    private static int[] FT1 = {0,2};
    private static int[] FTB = {4,3};

    public static boolean firstFloor(Scanner scanner){
        currentPosX = 0;
        currentPosY = 2;
        
    }

    /**
     * Updates the player's position based on the input command. It prevents movement
     * outside the bounds of the game board.
     * 
     * @param choice The player's movement choice.
     * @param rows The number of rows in the current floor.
     * @param cols The number of columns in the current floor.
     */
    private static void updatePosition(String choice, int rows, int cols) {
        switch (choice.toLowerCase()) {
            case "w": // Move Up
                if (currentPosX > 0)
                    currentPosX--;
                else
                    System.out.print("\033\143");
                    System.out.println("Cannot move up. You are at the edge.");
                    
                break;
            case "s": // Move Down
                if (currentPosX < rows - 1)
                    currentPosX++;
                else
                    System.out.print("\033\143");
                    System.out.println("Cannot move down. You are at the edge.");
                    
                break;
            case "d": // Move Right
                if (currentPosY < cols - 1)
                    currentPosY++;
                else
                    System.out.print("\033\143");
                    System.out.println("Cannot move right. You are at the edge.");
                    
                break;
            case "a": // Move Left
                if (currentPosY > 0)
                    currentPosY--;
                else
                    System.out.print("\033\143");
                    System.out.println("Cannot move left. You are at the edge.");
                    
                break;
            default:
                System.out.print("\033\143");
                System.out.println("Invalid input. Please choose a valid move.");
                Menus.Pause();
                break;
        }
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
