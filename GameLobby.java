import java.util.Scanner;


public class GameLobby{
    private Character user;


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
   //     Menus.menusGameLobby(characterStats);
        break;
      default:
        System.out.println("Invalid choice. Please try again.");
        FastTravel();
        break;
    }

    scanner.close();
  }

  public static void LevelUp(Character.CharacterStats characterStats, Character user) {
    Scanner scanner = new Scanner(System.in);

    int runeCost = (characterStats.getPlayerLevel() * 100) / 2;

    System.out.println("\n[1] Level Health");
    System.out.println("[2] Level Endurance");
    System.out.println("[3] Level Dexterity");
    System.out.println("[4] Level Strength");
    System.out.println("[5] Level Intelligence");
    System.out.println("[6] Level Faith");
    System.out.println("[7] Back");

    System.out.print("\nEnter your choice: ");
    int option = scanner.nextInt();

    if (option >= 1 && option <= 6) {
        if (user.getRunes() >= runeCost) {
            user.subtractRunes(runeCost);

            switch (option) {
                case 1:
                System.out.println("Current Runes: " + user.getRunes());
                    characterStats.setHP(characterStats.getHP() + 1);
                    System.out.println("Leveled HP");
                    break;
                case 2:
                    characterStats.setEND(characterStats.getEND() + 1);
                    System.out.println("Leveled END");
                    break;
                case 3:
                    characterStats.setDEX(characterStats.getDEX() + 1);
                    System.out.println("Leveled DEX");
                    break;
                case 4:
                    characterStats.setSTR(characterStats.getSTR() + 1);
                    System.out.println("Leveled STR");
                    break;
                case 5:
                    characterStats.setINT(characterStats.getINT() + 1);
                    System.out.println("Leveled INT");
                    break;
                case 6:
                    characterStats.setFTH(characterStats.getFTH() + 1);
                    System.out.println("Leveled FTH");
                    break;
            }

            characterStats.setPlayerLevel(characterStats.getPlayerLevel() + 1);
            characterStats.displayStats();
        } else {
            System.out.println("Not Enough Runes!");
            System.out.println("Current Runes: " + user.getRunes());
        }
    } else if (option == 7) {
        Menus.menusGameLobby(characterStats);
    } else {
        System.out.println("Invalid choice. Please try again.");
    }

    scanner.close();
}

}