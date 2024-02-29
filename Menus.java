
import java.util.Scanner;

public class Menus {

  private static Character user;

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
        user = new Character();
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

  public static void menusGameLobby(Character.CharacterStats characterStats) {
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
        GameLobby.FastTravel();
        break;
      case 2:
        GameLobby.LevelUp(characterStats, user);
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
        menusGameLobby(characterStats);
        break;
    }

    scanner.close();

  }

}
