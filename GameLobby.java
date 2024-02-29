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
    
        switch (option) {
          case 1:
            if(user.getRunes() >= runeCost) {
              user.subtractRunes(runeCost);
              characterStats.setHP(characterStats.getHP() + 1);
              characterStats.setPlayerLevel(characterStats.getPlayerLevel() + 1);
              characterStats.displayStats();
              System.out.println("Leveled HP");
            } else if (user.getRunes() < runeCost) {
              System.out.println("Not Enough Runes!");
              System.out.println("Current Runes: " + user.getRunes());
            }
            LevelUp(characterStats, user);
            break;
          case 2:
            if(user.getRunes() >= runeCost) {
              user.subtractRunes(runeCost);
              characterStats.setEND(characterStats.getEND() + 1);
              characterStats.setPlayerLevel(characterStats.getPlayerLevel() + 1);
              characterStats.displayStats();
              System.out.println("Leveled END");
            } else if (user.getRunes() < runeCost) { 
              System.out.println("Not Enough Runes!");
              System.out.println("Current Runes: " + user.getRunes());
            }
            LevelUp(characterStats, user);
            break;
          case 3:
            if(user.getRunes() >= runeCost) {
              user.subtractRunes(runeCost);
             characterStats.setDEX(characterStats.getDEX() + 1);
              characterStats.setPlayerLevel(characterStats.getPlayerLevel() + 1);
             characterStats.displayStats();
             System.out.println("Leveled DEX");
            } else if (user.getRunes() < runeCost) {
              System.out.println("Not Enough Runes!");
              System.out.println("Current Runes: " + user.getRunes());
            }
            LevelUp(characterStats, user);
            break;
          case 4:
            if(user.getRunes() >= runeCost) {
              user.subtractRunes(runeCost);
              characterStats.setSTR(characterStats.getSTR() + 1);
              characterStats.setPlayerLevel(characterStats.getPlayerLevel() + 1);
              characterStats.displayStats();
              System.out.println("Leveled STR");
            } else if (user.getRunes() < runeCost) {
              System.out.println("Not Enough Runes!");
              System.out.println("Current Runes: " + user.getRunes());
            }
            LevelUp(characterStats, user);
            break;
          case 5:
            if(user.getRunes() >= runeCost) {
              user.subtractRunes(runeCost);
             characterStats.setINT(characterStats.getINT() + 1);
             characterStats.setPlayerLevel(characterStats.getPlayerLevel() + 1);
             characterStats.displayStats();
             System.out.println("Leveled INT");
            } else if (user.getRunes() < runeCost) {
              System.out.println("Not Enough Runes!");
              System.out.println("Current Runes: " + user.getRunes());
            }
            LevelUp(characterStats, user);
            break;
          case 6:
            if(user.getRunes() >= runeCost) {
              user.subtractRunes(runeCost);
              characterStats.setFTH(characterStats.getFTH() + 1);
              characterStats.setPlayerLevel(characterStats.getPlayerLevel() + 1);
              characterStats.displayStats();
              System.out.println("Leveled FTH");
            } else if (user.getRunes() < runeCost) {
              System.out.println("Not Enough Runes!");
              System.out.println("Current Runes: " + user.getRunes());
            }
            LevelUp(characterStats, user);
            break;
          case 7:
            Menus.menusGameLobby(characterStats);
            break;
          default:
            System.out.println("Invalid choice. Please try again.");
            LevelUp(characterStats, user);
            break;
        }
    
        scanner.close();
      }
}