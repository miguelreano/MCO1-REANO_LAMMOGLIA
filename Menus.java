
import java.util.Scanner;

public class Menus {

  private static CharacterCreation user;

  public Menus() {
    TitleScreen();
  }

  public static void TitleScreen() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("test");

    System.out.println("\n=== Title Screen ===");
    System.out.println("[1] Start");
    System.out.println("[2] Exit");

    System.out.print("\nEnter your choice: ");
    int titleOption = scanner.nextInt();

    switch (titleOption) {
      case 1:
        user = new CharacterCreation();
        user.startCharacterCreation();
        break;
      case 2:
        System.exit(0);
        break;
      default:
        System.out.println("Invalid choice. Please try again.");
        TitleScreen();
        break;
    }

    scanner.close();
  }

  public static void GameLobby() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("[1] Fast Travel");
    System.out.println("[2] Level Up");
    System.out.println("[3] Inventory");
    System.out.println("[4] Shop");
    System.out.println("[5] Quit Game");

    System.out.print("\nEnter your choice: ");
    int option = scanner.nextInt();

    switch (option) {
      case 1:
        FastTravel();
        break;
      case 2:
        LevelUp();
        break;
      case 3:
        System.out.println("Inventory");
        break;
      case 4:
        System.out.println("Shop");
        break;
      case 5:
        TitleScreen();
        break;
      default:
        System.out.println("Invalid choice. Please try again.");
        GameLobby();
        break;
    }

    scanner.close();

  }

  public static void CharacterCreation() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("[1] Input Name");
    System.out.println("[2] Select Job Class");
    System.out.println("[3] Confirm");
    System.out.println("[4] Back");

    System.out.print("\nEnter your choice: ");
    int option = scanner.nextInt();

    switch (option) {
      case 1:
        
        break;
      case 2:
        
        break;
      case 3:
        GameLobby();
        break;
      case 4:
        TitleScreen();
        break;
      default:
        System.out.println("Invalid choice. Please try again.");
        CharacterCreation();
        break;
    }

    scanner.close();
  }

  public static void FastTravel() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("[1] Stormveil Castle");
    System.out.println("[2] Raya Lucaria Academey");
    System.out.println("[3] The Elden Throne");
    System.out.println("[4] Back");

    System.out.print("\nEnter your choice: ");
    int option = scanner.nextInt();

    switch (option) {
      case 1:
        System.out.println("Go to Stormveil Castle");
        break;
      case 2:
        System.out.println("Go to Raya Lucaria Academy");
        break;
      case 3:
        System.out.println("Go to The Elden Throne");
        break;
      case 4:
        GameLobby();
        break;
      default:
        System.out.println("Invalid choice. Please try again.");
        FastTravel();
        break;
    }

    scanner.close();
  }

  public static void LevelUp() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("\n[1] Level Health");
    System.out.println("[2] Level Endurance");
    System.out.println("[3] Level Dexterity");
    System.out.println("[4] Level Strength");
    System.out.println("[5] Level Intelligence");
    System.out.println("[6] Level Faith");
    System.out.println("[7] Back");

    System.out.print("\nEnter your choice: ");
    int option = scanner.nextInt();

    switch (option) {
      case 1:
        System.out.println("Leveled HP");
        LevelUp();
        break;
      case 2:
        System.out.println("Leveled END");
        LevelUp();
        break;
      case 3:
        System.out.println("Leveled DEX");
        LevelUp();
        break;
      case 4:
        System.out.println("Leveled STR");
        LevelUp();
        break;
      case 5:
        System.out.println("Leveled INT");
        LevelUp();
        break;
      case 6:
        System.out.println("Leveled FTH");
        LevelUp();
        break;
      case 7:
        GameLobby();
        break;
      default:
        System.out.println("Invalid choice. Please try again.");
        LevelUp();
        break;
    }

    scanner.close();
  }

}
