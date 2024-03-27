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

    
}
