import java.util.Scanner;

public class classStats {

  public static void selectClass() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Select Class");

    System.out.println("[1] Vagabond");
    System.out.println("[2] Samurai");
    System.out.println("[3] Warrior");
    System.out.println("[4] Hero");
    System.out.println("[5] Astrologer");
    System.out.println("[6] Prophet");

    System.out.println("Enter your class:");

    int classOption = scanner.nextInt();

    switch (classOption) {
      case 1:
        setStats(new Vagabond());
        break;
      case 2:
        setStats(new Samurai());
        break;
      case 3:
        setStats(new Warrior());
        break;
      case 4:
        setStats(new Hero());
        break;
      case 5:
        setStats(new Astrologer());
        break;
      case 6:
        setStats(new Prophet());
        break;

    }

  }

  private static void setStats(ClassStats classStats) {

    HP = classStats.HP;
    END = classStats.END;
    DEX = classStats.DEX;
    STR = classStats.STR;
    INT = classStats.INT;
    FTH = classStats.FTH;

  }

  public static class Vagabond extends classStats {
    int HP = 15;
    int END = 11;
    int DEX = 13;
    int STR = 14;
    int INT = 9;
    int FTH = 9;
  }

  public static class Samurai extends classStats {
    int HP = 12;
    int END = 13;
    int DEX = 15;
    int STR = 12;
    int INT = 9;
    int FTH = 8;
  }

  public static class Warrior extends classStats {
    int HP = 11;
    int END = 11;
    int DEX = 16;
    int STR = 10;
    int INT = 10;
    int FTH = 8;
  }

  public static class Hero extends classStats {
    int HP = 14;
    int END = 12;
    int DEX = 9;
    int STR = 16;
    int INT = 7;
    int FTH = 8;
  }

  public static class Astrologer extends classStats {
    int HP = 9;
    int END = 9;
    int DEX = 12;
    int STR = 8;
    int INT = 16;
    int FTH = 7;
  }

  public static class Prophet extends classStats {
    int HP = 10;
    int END = 8;
    int DEX = 10;
    int STR = 11;
    int INT = 7;
    int FTH = 16;
  }

}