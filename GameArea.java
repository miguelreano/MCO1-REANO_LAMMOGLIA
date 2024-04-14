import java.util.Scanner;

//import Character.CharacterStats;

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
    static Scanner myScanner = new Scanner(System.in);
    boolean result = FirstFloor(myScanner);
    private static Character playerCharacter;

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
        //printGameBoard(ROWS1, COLS1, currentPositionX, currentPositionY);
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
        System.out.println(doorReached);
        if (doorReached) {
            ThirdFloor(scanner);
        } else {
            FirstFloor(scanner);
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
            //System.out.print("\033\143");
            printGameBoard(ROWS3, COLS3, currentPositionX, currentPositionY);
            System.out.println("Choose your move: [W] Up, [S] Down, [D] Right, [A] Left");
            String choice = scanner.nextLine();

            updatePosition(choice, ROWS3, COLS3);

            if (isTile(currentPositionX, currentPositionY, DOOR3)) {
                System.out.print("\033\143");
                Menus.Pause();
                SecondFloor(scanner);
            }

            if (isTile(currentPositionX, currentPositionY, BOSS_TILE)) {
                // Assuming you've initialized bosses somewhere; select the appropriate boss
                Boss[] bosses = Boss.initializeBoss();
                Boss theBoss = bosses[0]; // Example: Selecting the first boss for the battle
                
                System.out.println("You've encountered the boss: " + theBoss.getBossname());
                Battle battle = new Battle(playerCharacter, theBoss);
                battle.start(characterStats); // Start the boss battle
            
                if (characterStats.getHP() > 0) {
                    System.out.println("You have defeated the boss: " + theBoss.getBossname());
                    // Handle victory scenario, like going back to map or a reward screen
                } else {
                    System.out.println("You have been defeated. Returning to the lobby...");
                    // Handle defeat scenario, like resetting stats or returning to the main menu
                }
                
                System.out.println("boss lol");
            }

            if (isTile(currentPositionX, currentPositionY, FAST_TRAVEL_TILE)) {
                gameRunning = false;
                //System.out.print("\033\143");
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
        //System.out.print("\033\143");
        printGameBoard(rows, cols, currentPositionX, currentPositionY);
        System.out.println("Choose your move: [W] Up, [S] Down, [D] Right, [A] Left");
        String choice = scanner.nextLine();

        updatePosition(choice, rows, cols);
        if (doors.length == 2) {
            if (isTile(currentPositionX, currentPositionY, doors[1])) {
                System.out.print("\033\143");
                System.out.println(doorMessage);
                Menus.Pause();
                return false;
            } else if (isTile(currentPositionX, currentPositionY, doors[0])){
                System.out.print("\033\143");
                System.out.println(doorMessage);
                Menus.Pause();
                return true;
                
            }
        } else {
            if (isTile(currentPositionX, currentPositionY, doors[0])) {
                System.out.print("\033\143");
                System.out.println(doorMessage);
                Menus.Pause();
                reachedDoor = true;
                break; // Exit the loop if a door is reached
            }
        }
        /* 
        for (int[] currentDoor : doors) {
            if (isTile(currentPositionX, currentPositionY, currentDoor)) {
                System.out.print("\033\143");
                System.out.println(doorMessage);
                Menus.Pause();
                reachedDoor = true;
                break; // Exit the loop if a door is reached
            }
        }
        */
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
                    Character character = new Character();
                    System.out.println(character.getCharacterStats());
                    Character.CharacterStats characterStats = character.getCharacterStats();                
                    Spawn[] spawnss = Spawn.initializeSpawn();
                    Spawn chosenSpawn = spawnss[new Random().nextInt(spawns.length)]; // Select a random spawn
                    Battle battle = new Battle(playerCharacter, chosenSpawn); // Assuming 'user' is your Character instance
                    System.out.println(characterStats);
                    //battle.start(characterStats); // Start the battle

                    if (characterStats.getHP() > 0) {
                        System.out.println("Victory! You defeated the spawn.");
                        // Optionally move the player to the original position or continue the adventure
                    } else {
                        System.out.println("Defeat! Returning to lobby...");
                        user.setRunes(0); // Reset runes to 0
                        // Implement logic to return to the lobby
                        return false; // Or another approach based on your game's flow
                    }

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
 */
private static void updatePosition(String choice, int rows, int cols) {
    Scanner myScanner = new Scanner(System.in);
    switch (choice.toLowerCase()) {
        case "w": // Move Up
            if (currentPositionX > 0) currentPositionX--;
            else System.out.println("Cannot move up. You are at the edge.");
            break;
        case "s": // Move Down
            if (currentPositionX < rows - 1) 
                currentPositionX++;
            else
                System.out.println("Cannot move down. You are at the edge.");
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

    public int[] getPlayerPosition() {
        return new int[]{currentPositionX, currentPositionY};
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




