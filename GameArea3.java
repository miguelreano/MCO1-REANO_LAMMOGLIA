import java.util.Scanner;
import java.util.Random;

public class GameArea3 {

    private static final int ROW1 = 9;
    private static final int COL1 = 3;
    private static final int BossROW = 7;
    private static final int BossCOL = 7;
    private static final int ROW3 = 9;
    private static final int COL3 = 3;

    private static int[] SPAWN1 = {4,1};
    private static int[][] SPAWN3 = {{7,0}, {7,2}, {5,0}, {5,2}, {3,0}, {3,2}, {1,0}, {1,2}};

    private static int[] DOOR1 = {0,1};
    private static int[] DOOR2 = {6,3};
    private static int[] Other2 = {0,3};
    private static int[] DOOR3 = {8,1};

    private static int[] BOSS = {3,3};
    private static int[] Credits = {0,1};

    private static boolean bossdefeat;
    private static int currentPosX;
    private static int currentPosY;

    private static Character playerCharacter;

    public static boolean firstFloor(Scanner scanner){
        currentPosX = 8;
        currentPosY = 1;
        boolean doorReached = floorLogic(scanner, ROW1, COL1, new int[][]{DOOR1}, new int[][] {SPAWN1},
        "You've reached the door of the first floor...");
        if(doorReached){
            SecondFloor(scanner);
        }

        return doorReached;
    }
    
    public static boolean SecondFloor(Scanner scanner){
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

            if (isTile(currentPosX, currentPosY, DOOR2)) {
                System.out.print("\033\143");
                Menus.Pause();
                firstFloor(scanner);
            }

            if (isTile(currentPosX, currentPosY, Other2) && bossdefeat == true) {
                System.out.print("\033\143");
                Menus.Pause();
                ThirdFloor(scanner);
                break;
            }

            if (isTile(currentPosX, currentPosY, BOSS)) {
                // Assuming you've initialized bosses somewhere; select the appropriate boss
                Boss[] bosses = Boss.initializeBoss();
                Boss theBoss = bosses[0]; // Example: Selecting the first boss for the battle
                Character character = new Character();
                Character.CharacterStats characterStats = character.getCharacterStats();                 
                System.out.println("You've encountered the boss: " + theBoss.getBossname());
                Battle battle = new Battle(playerCharacter, theBoss);
                battle.start(characterStats); // Start the boss battle
            
                if (characterStats.getHP() > 0) {
                    System.out.println("You have defeated the boss: " + theBoss.getBossname());
                    bossdefeat = true;
                } else {
                    System.out.println("You have been defeated. Returning to the lobby...");
                    // Handle defeat scenario, like resetting stats or returning to the main menu
                    bossdefeat = false;
                }
                

            }

            
        }
        return bossdefeat;
    }

    public static boolean ThirdFloor(Scanner scanner){
        currentPosX = 8;
        currentPosY = 1;
        boolean doorReached = floorLogic(scanner, ROW3, COL3,new int[][] {Credits}, SPAWN3,
        "You've reached the door of the first floor...");
        if(doorReached){
            // done
        }

        return doorReached;
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

        if (doors.length == 2) {
            if (isTile(currentPosX, currentPosY, doors[1])) {
                System.out.print("\033\143");
                System.out.println(doorMessage);
                Menus.Pause();
                return false;
            } else if (isTile(currentPosX, currentPosY, doors[0])){
                System.out.print("\033\143");
                System.out.println(doorMessage);
                Menus.Pause();
                return true;
                
            }
        } else {
            if (isTile(currentPosX, currentPosY, doors[0])) {
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
                        return false; // Or another approach based on your game's flow
                    }

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
