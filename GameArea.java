import java.util.Scanner;
import java.util.Random;

/**
* The {@code GameArea} class represents the game environment where the player can navigate through
* different floors, encounter various challenges, and collect treasures. It manages the game's
* spatial logic, including movements, encounters, and transitions between floors.
*/

public class GameArea {

    //private static final Scanner scanner = new Scanner(System.in);
    private static final int ROWS1 = 7; // First floor rows
    private static final int COLS1 = 3; // First floor columns
    private static final int ROWS2 = 7; // Second floor rows
    private static final int COLS2 = 7; // Second floor columns
    private static final int ROWS3 = 7; // Third floor rows
    private static final int COLS3 = 5; // Third floor columns
    public static int floor=0;
    private static int currentPositionX; 
    private static int currentPositionY; 

    private static final int[] DOOR1 = { 0, 1 }; // Door position for the first floor
    private static final int[][] DOOR2 = { {0, 3}, {6,3}}; // Door position for the second floor
    private static final int[] DOOR3 = {6,2};
    private static final int[][] SPAWNS1 = { { 1, 0 }, { 1, 2 } }; // Spawn positions for the first floor
    
    private static final int[][] SPAWNS2 = {
            { 5, 2 }, { 5, 4 }, { 3, 0 }, { 3, 2 }, 
            { 3, 3 }, { 3, 4 }, { 3, 6 }, { 1, 3 } // 2nd floor Spawn positions                                                                                      
    };

    private static final int[] BOSS_TILE = { 3, 2 }; // Boss position for the third floor
    private static final int[] FAST_TRAVEL_TILE = { 0, 2 }; // Fast travel position for the third floor

    private static Character.CharacterStats characterStats;
    Scanner myScanner = new Scanner(System.in);
    boolean result = FirstFloor(myScanner);

    /*
    * Initiates the first floor of the game area, setting the player's starting position
    * and managing gameplay logic including door and spawn encounters.
    * 
    * @param scanner The scanner object to read player inputs.
    * @return {@code true} if the player reaches the door, {@code false} otherwise.
    */

    public static boolean FirstFloor(Scanner scanner) {
        currentPositionX = 6;
        currentPositionY = 1;
        boolean doorReached = floorLogic(scanner, ROWS1, COLS1, new int[][]{DOOR1}, SPAWNS1,
        "You've reached the door of the first floor...");
        if (doorReached) {
        SecondFloor(scanner);
        }
        return doorReached;

    }

    /*Initiates the second floor of the game area with a new set of challenges and updates
     * the player's position accordingly. It also handles logic for door and spawn encounters.
     * 
     * @param scanner The scanner object to read player inputs.
     * @return {@code true} if the player reaches the door, {@code false} otherwise.
     */
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


    
    /*
     * Initiates the third floor of the game area, presenting the final set of challenges,
     * including a boss fight and a fast travel tile to conclude the level.
     * 
     * @param scanner The scanner object to read player inputs.
     */
    public static void ThirdFloor(Scanner scanner) {
        currentPositionX = 6; // Starting position for the third floor
        currentPositionY = 2;
        boolean gameRunning = true;
        
        while (gameRunning) {
            System.out.print("\033\143");
            printGameBoard(ROWS3, COLS3, currentPositionX, currentPositionY);
            System.out.println("Choose your move: [W] Up, [S] Down, [D] Right, [A] Left");
            String choice = scanner.nextLine();

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


    /**
     * Contains the logic for player movement and interactions within a floor, including
     * handling spawn points, door encounters, and displaying the game board.
     * 
     * @param scanner The scanner object for reading player inputs.
     * @param rows The number of rows in the current floor.
     * @param cols The number of columns in the current floor.
     * @param door The coordinates of the floor's door.
     * @param spawns The spawn points within the floor.
     * @param doorMessage The message to display when the door is reached.
     * @return {@code true} if the player reaches the door, {@code false} otherwise.
     */
    private static boolean floorLogic(Scanner scanner, int rows, int cols, int[][] doors, int[][] spawns,
        String doorMessage) {
    boolean reachedDoor = false;
    Character user = new Character();
    while (!reachedDoor) {
        System.out.print("\033\143");
        printGameBoard(rows, cols, currentPositionX, currentPositionY);
        System.out.println("Choose your move: [W] Up, [S] Down, [D] Right, [A] Left");
        String choice = scanner.nextLine();

        updatePosition(choice, rows, cols);

        for (int[] currentDoor : doors) {
            if (isTile(currentPositionX, currentPositionY, currentDoor)) {
                System.out.print("\033\143");
                System.out.println(doorMessage);
                Menus.Pause();
                reachedDoor = true;
                break; // Exit the loop if a door is reached
            }
        }
        
        // Removed the incorrect if statement checking for `door`

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
    }
    return reachedDoor;
}

/** 
 * Updates the player's position based on the input command. It prevents movement
 * outside the bounds of the game board.
 * 
 * @param choice The player's movement choice.
 * @param rows The number of rows in the current floor.
 * @param cols The number of columns in the current floor.
 
    private static void updatePosition(String choice, int rows, int cols) {
        switch (choice.toLowerCase()) {
            case "w": // Move Up
                if (currentPositionX > 0)
                    currentPositionX--;
                else
                    System.out.println("Cannot move up. You are at the edge.");
                break;
            case "s": // Move Down
                if (currentPositionX < rows - 1)
                    currentPositionX++;
                else
                    System.out.println("Cannot move down. You are at the edge.");
                break;
            case "d": // Move Right
                if (currentPositionY < cols - 1)
                    currentPositionY++;
                else
                    System.out.println("Cannot move right. You are at the edge.");
                break;
            case "a": // Move Left
                if (currentPositionY > 0)
                    currentPositionY--;
                else
                    System.out.println("Cannot move left. You are at the edge.");
                break;
            default:
                System.out.println("Invalid input. Please choose a valid move.");
                break;
        }
    }
*/
    private static void updatePosition(String choice, int rows, int cols) {
        Scanner myScanner = new Scanner(System.in);
        switch (choice.toLowerCase()) {
            case "w": // Move Up
                if (currentPositionX > 0) currentPositionX--;
                else System.out.println("Cannot move up. You are at the edge.");
                break;
            case "s": // Move Down
                // Check for specific door positions and floor transitions
                if (isTile(currentPositionX, currentPositionY, DOOR2[1])) {
                    // Transition from DOOR2 (6,3) to First Floor's DOOR1 (0, 1)
                    FirstFloor(myScanner); // Reset or transition to the first floor
                    currentPositionX = DOOR1[0]; // Set X to the first floor door position
                    currentPositionY = DOOR1[1]; // Set Y to the first floor door position
                    System.out.println("Transitioned to First Floor, Door 1");
                } else if (isTile(currentPositionX, currentPositionY, DOOR3)) {
                    // Transition from DOOR3 to Second Floor's DOOR2 (0,3)
                    SecondFloor(myScanner); // Transition to the second floor
                    currentPositionX = DOOR2[0][0]; // Adjust X to DOOR2's first entry
                    currentPositionY = DOOR2[0][1]; // Adjust Y to match DOOR2 (assuming 0,3 is correct)
                    System.out.println("Transitioned to Second Floor, Door 2");
                } else if (currentPositionX < rows - 1) {
                    currentPositionX++;
                }else{
                    System.out.println("Cannot move down. You are at the edge.");
                }
                break;
                case "d": // Move Right
                    if (currentPositionY < cols - 1) currentPositionY++;
                    else System.out.println("Cannot move right. You are at the edge.");
                    break;
                case "a": // Move Left
                    if (currentPositionY > 0) currentPositionY--;
                    else System.out.println("Cannot move left. You are at the edge.");
                    break;
                default:
                    System.out.println("Invalid input. Please choose a valid move.");
                    break;
            }
        }
        

    /**
     * Checks if the current position matches the specified tile coordinates.
     * 
     * @param x The x-coordinate of the current position.
     * @param y The y-coordinate of the current position.
     * @param tile The tile coordinates to compare with the current position.
     * @return {@code true} if the current position matches the tile coordinates, {@code false} otherwise.
     */
    private static boolean isTile(int x, int y, int[] tile) {
        return x == tile[0] && y == tile[1];
    }

    /**
     * Prints the game board to the console, showing the player's current position
     * and the layout of the floor.
     * 
     * @param rows The number of rows in the current floor.
     * @param cols The number of columns in the current floor.
     * @param x The x-coordinate of the player's current position.
     * @param y The y-coordinate of the player's current position.
     */
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

    /**
     * Generates a random number of runes for the player to collect at treasure spawn points.
     * 
     * @return The number of runes generated.
     */
    public static int treasureRunes() {
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
    public static int generateRandomNumber() {
        Random randa = new Random();
        return randa.nextInt(4) + 1; // Generate a number between 0-3 and then add 1
    }

} 



