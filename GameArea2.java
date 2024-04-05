import java.util.Scanner;
import java.util.Random;

/**
 * The {@code GameArea2} class represents the game environment where the player can navigate through
 * different floors, encounter various challenges, and collect treasures. It manages the game's
 * spatial logic, including movements, encounters, and transitions between floors.
 */
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
    private static final int[] DOOR4 = {1,0};
    private static final int[] BossDOOR = {7,3};

    private static final int[][] BossBOUNDS = {{0,0}, {0,1}, {0,5}, {0,6}};
    private static int[][] BOUNDS3 = {{0,0}, {1,0}, {0,4}, {1,4}, {5,0}, {6,0}, {5,4}, {6,4}};

    private static int[][] SPAWN1 = {{3,1}, {3,3}};
    private static int[][] SPAWN2 = {{1,0}, {3,0}, {5,0}};
    private static int[][] SPAWN3 = {{5,2}, {1,2}};
    private static int[][] SPAWN4 = {{0,2}, {0,4}, {2,2}, {2,4}};
    private static int[][] BossSPAWN = {{2,1}, {2,3}, {2,5}, {4,1}, {4,5}, {6,1}, {6,5}};

    private static int[] BOSSTILE = {4,3};
    //sprivate static int[] FT1 = {0,2};
    private static int[] FTB = {4,3};

    private static Character playerCharacter;

    private static Character.CharacterStats characterStats;

    /**
     * Initiates the first floor of the game area, setting the player's starting position
     * and managing gameplay logic including door and spawn encounters.
     *
     * @param scanner The scanner object to read player inputs.
     * @return {@code true} if the player reaches the door, {@code false} otherwise.
     */
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

    /**
     * Initiates the second floor of the game area with a new set of challenges
     * and updates the player's position accordingly. It also handles logic for door and spawn encounters.
     *
     * @param scanner The scanner object to read player inputs.
     * @return {@code true} if the player reaches the door, {@code false} otherwise.
     */
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

    /**
     * Initiates the third floor of the game area, presenting the final set of challenges,
     * including a boss fight and a fast travel tile to conclude the level.
     *
     * @param scanner The scanner object to read player inputs.
     */
    public static boolean ThirdFloor(Scanner scanner){
        currentPosX=3;
        currentPosY=0;
        boolean doorReached = floorLogic(scanner, ROW3, COL3, DOOR3, SPAWN3,
        "You've reached the door of the second floor...");
        if (doorReached) {
            BossFloor(scanner, BossSPAWN);
        }
        return doorReached;
        
    }

    /**
     * Initiates the fourth floor of the game area, setting the player's starting position
     * and managing gameplay logic including door and spawn encounters.
     *
     * @param scanner The scanner object to read player inputs.
     * @return {@code true} if the player reaches the door, {@code false} otherwise.
     */
    public static boolean fourthFloor(Scanner scanner){
        currentPosX = 1;
        currentPosY = 0;
        boolean doorReached = floorLogic(scanner, ROW4, COL4, new int[][] {DOOR4}, SPAWN4, null);
        if(doorReached){
            ThirdFloor(scanner);
        }

        return doorReached;
    }

    /**
     * Handles the boss floor gameplay, including spawn encounters, boss encounters, and fast travel.
     *
     * @param scanner The scanner object to read player inputs.
     * @param spawns The spawn points within the boss floor.
     */
    public static void BossFloor(Scanner scanner, int[][] spawns){
        currentPosX = 6; // Starting position for the third floor
        currentPosY = 2;
        boolean gameRunning = true;
        Character user = new Character();
        while (gameRunning) {
            //System.out.print("\033\143");
            printGameBoard(BossROW, BossCOL, currentPosX, currentPosY);
            System.out.println("Choose your move: [W] Up, [S] Down, [D] Right, [A] Left");
            String choice = scanner.nextLine();
            

            updatePosition(choice, BossROW, BossCOL);

            if (isTile(currentPosX, currentPosY, BossDOOR)) {
                System.out.print("\033\143");
                Menus.Pause();
                SecondFloor(scanner);
            }

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
                        Character character = new Character();
                        character.selectClass("Vagabond");
                        Character.CharacterStats characterStats = character.getCharacterStats();                
                        //Initialize Spawn and Battle
                        Spawn[] spawnss = Spawn.initializeSpawn();
                        Spawn chosenSpawn = spawnss[new Random().nextInt(spawns.length)]; // Select a random spawn
                        Battle battle = new Battle(playerCharacter, chosenSpawn); // Assuming 'user' is your Character instance
                        battle.start(characterStats); // Start the battle
    
                        if (characterStats.getHP() > 0) {
                            System.out.println("Victory! You defeated the spawn.");
                            // Optionally move the player to the original position or continue the adventure
                        } else {
                            System.out.println("Defeat! Returning to lobby...");
                            user.setRunes(0); // Reset runes to 0
                            // Implement logic to return to the lobby
                             // Or another approach based on your game's flow
                        }
    
                    }
                    break;
                }
            }
            if (isTile(currentPosX, currentPosY, BOSSTILE)) {
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

            if (isTile(currentPosX, currentPosY, FTB)) {
                gameRunning = false;
                //System.out.print("\033\143");
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
    private static void updatePosition(String choice, int rows, int cols) {
        Scanner myScanner = new Scanner(System.in);
        switch (choice.toLowerCase()) {
            case "w": // Move Up
                if (currentPosX > 0) currentPosX--;
                else System.out.println("Cannot move up. You are at the edge.");
                break;
            case "s": // Move Down
                if (currentPosX < rows - 1) 
                    currentPosX++;
                else
                    System.out.println("Cannot move down. You are at the edge.");
                break;
                case "d": // Move Right
                    if (currentPosY < cols - 1) currentPosY++;
                    else System.out.println("Cannot move right. You are at the edge.");
                    break;
                case "a": // Move Left
                    if (currentPosY > 0) currentPosY--;
                    else System.out.println("Cannot move left. You are at the edge.");
                    break;
                default:
                    System.out.println("Invalid input. Please choose a valid move.");
                    break;
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
     * Generates a random number of runes for the player to collect at treasure spawn points.
     * 
     * @return The number of runes generated.
     */
    public static int generateRandomNumber() {
        Random randa = new Random();
        return randa.nextInt(4) + 1; // Generate a number between 0-3 and then add 1
    }

    /**
     * Generates a random number used to determine if a spawn point will yield treasure.
     * 
     * @return A random number between 1 and 4.
     */
    public static int treasureRunes() {
        Random random = new Random(); // Create a Random object
        int min = 50; // Set the minimum number (inclusive)
        int max = 150; // Set the maximum number (exclusive)
        return random.nextInt(max - min) + min; // Generate and return the random number
    }


}
