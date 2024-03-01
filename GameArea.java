import java.util.Scanner;
import java.util.Random;

public class GameArea {

    private static final int ROWS1 = 7; // First floor rows
    private static final int COLS1 = 3; // First floor columns
    private static final int ROWS2 = 7; // Second floor rows
    private static final int COLS2 = 7; // Second floor columns
    private static final int ROWS3 = 7; // Third floor rows
    private static final int COLS3 = 5; // Third floor columns

    private static int currentPositionX; // Generalized position row for any floor
    private static int currentPositionY; // Generalized position column for any floor

    private static final int[] DOOR1 = { 0, 1 }; // Door position for the first floor
    private static final int[] DOOR2 = { 0, 3 }; // Door position for the second floor
    private static final int[][] SPAWNS1 = { { 1, 0 }, { 1, 2 } }; // Spawn positions for the first floor
    private static final int[][] SPAWNS2 = {
            { 5, 2 }, { 5, 4 }, { 3, 0 }, { 3, 2 }, { 3, 3 }, { 3, 4 }, { 3, 6 }, { 1, 3 } // Spawn positions for the
                                                                                           // second floor
    };
    private static final int[] BOSS_TILE = { 3, 2 }; // Boss position for the third floor
    private static final int[] FAST_TRAVEL_TILE = { 0, 2 }; // Fast travel position for the third floor

    private static Character.CharacterStats characterStats;

    public static boolean FirstFloor(Scanner scanner) {
        currentPositionX = 6;
        currentPositionY = 1;
        boolean doorReached = floorLogic(scanner, ROWS1, COLS1, DOOR1, SPAWNS1,
                "You've reached the door of the first floor...");
        if (doorReached) {
            SecondFloor(scanner);
        }
        return doorReached;
    }

    public static boolean SecondFloor(Scanner scanner) {
        currentPositionX = 6; // Starting position for the second floor
        currentPositionY = 3;
        boolean doorReached = floorLogic(scanner, ROWS2, COLS2, DOOR2, SPAWNS2,
                "You've reached the door of the second floor...");
        if (doorReached) {
            ThirdFloor(scanner);
        }
        return doorReached;
    }

    public static void ThirdFloor(Scanner scanner) {
        currentPositionX = 6; // Starting position for the third floor
        currentPositionY = 2;
        boolean gameRunning = true;
        
        while (gameRunning) {
            System.out.print("\033\143");
            printGameBoard(ROWS3, COLS3, currentPositionX, currentPositionY);
            System.out.println("Choose your move: [1] Up, [2] Down, [3] Right, [4] Left");
            int choice = scanner.nextInt();

            updatePosition(choice, ROWS3, COLS3);

            if (isTile(currentPositionX, currentPositionY, BOSS_TILE)) {
                System.out.print("\033\143");
                System.out.println("You've encountered a Boss but can still move to tiles.");
                Menus.Pause();
            }

            if (isTile(currentPositionX, currentPositionY, FAST_TRAVEL_TILE)) {
                gameRunning = false;
                System.out.print("\033\143");
                System.out.println("You have reached the end of this map! Redirecting you to the Game Lobby...");
                Menus.Pause();
                Menus.menusGameLobby(characterStats);
            }
        }
    }

    private static boolean floorLogic(Scanner scanner, int rows, int cols, int[] door, int[][] spawns,
            String doorMessage) {
        boolean reachedDoor = false;
        Character user = new Character();
        while (!reachedDoor) {
            System.out.print("\033\143");
            printGameBoard(rows, cols, currentPositionX, currentPositionY);
            System.out.println("Choose your move: [1] Up, [2] Down, [3] Right, [4] Left");
            int choice = scanner.nextInt();

            updatePosition(choice, rows, cols);

            for (int[] spawn : spawns) {
                if (isTile(currentPositionX, currentPositionY, spawn)) {
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

            if (isTile(currentPositionX, currentPositionY, door)) {
                System.out.print("\033\143");
                System.out.println(doorMessage);
                Menus.Pause();
                reachedDoor = true;
            }
        }
        return reachedDoor;
    }

    // Remaining methods (updatePosition, isTile, printGameBoard, treasureRunes,
    // generateRandomNumber) are unchanged

    private static void updatePosition(int choice, int rows, int cols) {
        switch (choice) {
            case 1: // Move Up
                if (currentPositionX > 0)
                    currentPositionX--;
                else
                    System.out.print("\033\143");
                    System.out.println("Cannot move up. You are at the edge.");
                    
                break;
            case 2: // Move Down
                if (currentPositionX < rows - 1)
                    currentPositionX++;
                else
                    System.out.print("\033\143");
                    System.out.println("Cannot move down. You are at the edge.");
                    
                break;
            case 3: // Move Right
                if (currentPositionY < cols - 1)
                    currentPositionY++;
                else
                    System.out.print("\033\143");
                    System.out.println("Cannot move right. You are at the edge.");
                    
                break;
            case 4: // Move Left
                if (currentPositionY > 0)
                    currentPositionY--;
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

    private static boolean isTile(int x, int y, int[] tile) {
        return x == tile[0] && y == tile[1];
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

    public static int treasureRunes() {
        Random random = new Random(); // Create a Random object
        int min = 50; // Set the minimum number (inclusive)
        int max = 150; // Set the maximum number (exclusive)
        return random.nextInt(max - min) + min; // Generate and return the random number
    }

    public static int generateRandomNumber() {
        Random randa = new Random();
        return randa.nextInt(4) + 1; // Generate a number between 0-3 and then add 1
    }

}