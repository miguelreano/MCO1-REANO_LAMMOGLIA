
import java.util.Scanner;

public class Menus {

  private static Character user;

  /**
   * Initializes the game by displaying the title screen and processing user input
   * for starting the game or exiting.
   */

  public Menus() {
    TitleScreen();
  }

   /**
   * Displays the game's title screen and options for starting or exiting the game.
   * Handles user input to navigate to the character creation process or exit the game.
   * 
   */
  public static void TitleScreen() {
    Scanner scanner = new Scanner(System.in);

    String yellowColorCode = "\u001B[33m";

    System.out.println(yellowColorCode + " _____ _    ______ _____ _   _  ______ _____ _____ _   _ _____ ");
    System.out.println(yellowColorCode + "|  ___| |   |  _  \\  ___| \\ | | | ___ \\  _  |  __ \\ | | |  ___|");
    System.out.println(yellowColorCode + "| |__ | |   | | | | |__ |  \\| | | |_/ / | | | |  \\/ | | | |__  ");
    System.out.println(yellowColorCode + "|  __|| |   | | | |  __|| . ` | |    /| | | | | __| | | |  __| ");
    System.out.println(yellowColorCode + "| |___| |___| |/ /| |___| |\\  | | |\\ \\  \\_/ / |_\\ \\ |_| | |___ ");
    System.out.println(yellowColorCode + "\\____/\\_____/___/ \\____/\\_| \\_/ \\_| \\_/\\___/ \\____/\\___/\\____/ ");

    String resetColorCode = "\u001B[0m";
    System.out.print(resetColorCode);

    System.out.println("\n[1] Start");
    System.out.println("[2] Exit");

    System.out.print("\nEnter your choice: ");
    int titleOption = scanner.nextInt();

    switch (titleOption) {
      case 1:
        System.out.print("\033\143");
        user = new Character();
        user.startCharacterCreation();
        break;
      case 2:
        System.out.print("\033\143");
        System.exit(0);
        break;
      default:
        System.out.print("\033\143");
        System.out.println("Invalid choice. Please try again.");
        Pause();
        System.out.print("\033\143");
        TitleScreen();
        break;
    }

    scanner.close();
  }

  /**
   * Displays the game lobby menu with options for fast travel, leveling up, accessing the inventory,
   * visiting the shop, or quitting the game. Processes user input to navigate to the selected option.
   *
   * @param characterStats The current character's statistics, used for certain game actions such as leveling up.
   */
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
        System.out.print("\033\143");
        GameLobby.FastTravel();
        break;
      case 2:
        System.out.print("\033\143");
        GameLobby.LevelUp(characterStats, user);
        break;
      case 3:
        System.out.print("\033\143");
        System.out.println("Inventory");
        Pause();
        System.out.print("\033\143");
        menusGameLobby(characterStats);
        break;
      case 4:
        System.out.print("\033\143");
        System.out.println("Shop");
        Pause();
        System.out.print("\033\143");
        menusGameLobby(characterStats);
        break;
      case 5:
        System.out.print("\033\143");
        TitleScreen();
        break;
      default:
        System.out.print("\033\143");
        System.out.println("Invalid choice. Please try again.");
        Pause();
        System.out.print("\033\143");
        menusGameLobby(characterStats);
        break;
    }

    scanner.close();

  }
  
  /**
   * Pauses the execution for a brief moment, typically used to allow the user
   * to read on-screen messages before proceeding.
   */
  public static void Pause(){
    try {
      Thread.sleep(1500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
