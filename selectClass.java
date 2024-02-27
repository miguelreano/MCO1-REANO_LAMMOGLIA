import java.util.Scanner;

public class selectClass {
  public static Character selectClass() {
    Scanner scanner = new Scanner(System.in);
    Character character = null;
    while (true) {
      System.out.println("Select Your Class:");
      System.out.println("[1] Vagabond\n[2] Samurai\n[3] Warrior\n[4] Hero\n[5] Astrologer\n[6] Prophet");
      int classOption = scanner.nextInt();

      switch (classOption) {
        case 1:
          character = new Character(15, 11, 13, 14, 9, 9); // Vagabond stats
          break;
        case 2:
          character = new Character(12, 13, 15, 12, 9, 8); // Samurai stats
          break;
        case 3:
          character = new Character(11, 11, 16, 10, 10, 8); // Warrior
          break;
        case 4:
          character = new Character(14, 12, 9, 16, 7, 8); // Hero
          break;
        case 5:
          character = new Character(9, 9, 12, 8, 16, 7); // Astronomer
          break;
        case 6:
          character = new Character(10, 8, 10, 11, 7, 16); // Prophet
          break;
        default:
          System.out.println("Invalid selection. Please select a number between 1 and 6.");
          continue; // This will cause the loop to continue, prompting the user again.
      }
      break; // Break out of the loop if a valid selection is made.
    }
    return character; // Return the created character
  }
}

/*
 * public class CharacterCreation {
 * 
 * public static void selectClass(){
 * Scanner scanner = new Scanner(System.in);
 * 
 * System.out.println("Select Class");
 * 
 * System.out.println("CLASS");
 * int classOption = scanner.nextInt();
 * 
 * switch (classOption) {
 * case 1:
 * Vagabond vagabond = CharacterCreation.new Vagabond();
 * break;
 * case 2:
 * Samurai samurai = new Samurai();
 * break;
 * case 3:
 * Warrior warrior = new Warrior();
 * break;
 * case 4:
 * Hero hero = new Hero();
 * break;
 * case 5:
 * Astrologer astrologer = new Astrologer();
 * break;
 * case 6:
 * Prophet prophet = new Prophet();
 * break;
 * 
 * }
 * 
 * 
 * }
 * 
 * public class Vagabond{
 * int HP = 15;
 * int END = 11;
 * int DEX = 13;
 * int STR = 14;
 * int INT = 9;
 * int FTH = 9;
 * }
 * 
 * public class Samurai{
 * int HP = 12;
 * int END = 13;
 * int DEX = 15;
 * int STR = 12;
 * int INT = 9;
 * int FTH = 8;
 * }
 * 
 * public class Warrior{
 * int HP = 11;
 * int END = 11;
 * int DEX = 16;
 * int STR = 10;
 * int INT = 10;
 * int FTH = 8;
 * }
 * 
 * public class Hero{
 * int HP = 14;
 * int END = 12;
 * int DEX = 9;
 * int STR = 16;
 * int INT = 7;
 * int FTH = 8;
 * }
 * 
 * public class Astrologer{
 * int HP = 9;
 * int END = 9;
 * int DEX = 12;
 * int STR = 8;
 * int INT = 16;
 * int FTH = 7;
 * }
 * 
 * public class Prophet{
 * int HP = 10;
 * int END = 8;
 * int DEX = 10;
 * int STR = 11;
 * int INT = 7;
 * int FTH = 16;
 * }
 * 
 * }
 */