
import java.util.Scanner;

public class Menus {

    public Menus(){
        TitleScreen();
    }

    public static void TitleScreen() {
        Scanner scanner = new Scanner(System.in);

      // Title Screen
      System.out.println("\n=== Title Screen ===");
      System.out.println("[1] Start");
      System.out.println("[2] Exit");

      System.out.print("\nEnter your choice: ");
      int titleOption = scanner.nextInt();

      scanner.close();

      switch (titleOption) {
        case 1:
        GameLobby();
        case 2:
        System.exit(0);
        default:
        System.out.println("Invalid choice. Please try again.");
      }
    }

    public static void GameLobby(){
        Scanner scanner = new Scanner(System.in);

      // Character Creation
      System.out.println("[1] Fast Travel");
      System.out.println("[2] Level Up");
      System.out.println("[3] Inventory");
      System.out.println("[4] Shop");
      System.out.println("[5] Quit Game");

      System.out.print("\nEnter your choice: ");
      int option = scanner.nextInt();

      scanner.close();

      switch (option) {
        case 1:
        FastTravel();
        case 2:
        LevelUp();
        case 3:
        System.out.println("Inventory");
        case 4:
        System.out.println("Shop");
        case 5:
        TitleScreen();
        default:
        System.out.println("Invalid choice. Please try again.");
      }
    }

    public static void CharacterCreation(){
        Scanner scanner = new Scanner(System.in);

      // Character Creation
      System.out.println("[1] Input Name");
      System.out.println("[2] Select Job Class");
      System.out.println("[3] Confirm");
      System.out.println("[4] Back");

      System.out.print("\nEnter your choice: ");
      int option = scanner.nextInt();

      scanner.close();

      switch (option) {
        case 1:
        System.out.println("Input name");
        case 2:
        System.out.println("Select Job Class");
        case 3:
        System.out.println("Confirm");
        case 4:
        TitleScreen();
        default:
        System.out.println("Invalid choice. Please try again.");
      }
    }

    public static void FastTravel(){
        Scanner scanner = new Scanner(System.in);

      // Character Creation
      System.out.println("[1] Stormveil Castle");
      System.out.println("[2] Raya Lucaria Academey");
      System.out.println("[3] The Elden Throne");
      System.out.println("[4] Back");

      System.out.print("\nEnter your choice: ");
      int option = scanner.nextInt();

      scanner.close();

      switch (option) {
        case 1:
        System.out.println("Go A1");
        case 2:
        System.out.println("Go A2");
        case 3:
        System.out.println("Go A3");
        case 4:
        GameLobby();
        default:
        System.out.println("Invalid choice. Please try again.");
      }
    }

    public static void LevelUp(){
        Scanner scanner = new Scanner(System.in);

      // Character Creation
      System.out.println("[1] Level Health");
      System.out.println("[2] Level Endurance");
      System.out.println("[3] Level Dexterity");
      System.out.println("[4] Level Strength");
      System.out.println("[5] Level Intelligence");
      System.out.println("[6] Level Faith");
      System.out.println("[7] Back");

      System.out.print("\nEnter your choice: ");
      int option = scanner.nextInt();

      scanner.close();

      switch (option) {
        case 1:
        System.out.println("Leveled HP");
        case 2:
        System.out.println("Leveled END");
        case 3:
        System.out.println("Leveled DEX");
        case 4:
        System.out.println("Leveled STR");
        case 5:
        System.out.println("Leveled INT");
        case 6:
        System.out.println("Leveled FTH");
        case 7:
        GameLobby();
        default:
        System.out.println("Invalid choice. Please try again.");
      }
    }
    
  }

