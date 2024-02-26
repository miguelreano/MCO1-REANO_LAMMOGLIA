

public class CharacterCreation {

  public static void selectClass(){
    Scanner scanner = new Scanner(System.in);

    System.out.println("Select Class");

    System.out.println("CLASS");
    int classOption = scanner.nextInt();

    switch (classOption) {
      case 1:
        Vagabond vagabond = new Vagabond();
        break;
      case 2:
        Samurai samurai = new Samurai();
        break;
      case 3:
        Warrior warrior = new Warrior();
        break;
      case 4:
        Hero hero = new Hero();
        break;
      case 5:
        Astrologer astrologer = new Astrologer();
        break;
      case 6:
        Prophet prophet = new Prophet();
        break;

    }

  }

  public class Vagabond{
    int HP = 15;
    int END = 11;
    int DEX = 13;
    int STR = 14;
    int INT = 9;
    int FTH = 9;
  }

  public class Samurai{
    int HP = 12;
    int END = 13;
    int DEX = 15;
    int STR = 12;
    int INT = 9;
    int FTH = 8;
  }

  public class Warrior{
    int HP = 11;
    int END = 11;
    int DEX = 16;
    int STR = 10;
    int INT = 10;
    int FTH = 8;
  }

  public class Hero{
    int HP = 14;
    int END = 12;
    int DEX = 9;
    int STR = 16;
    int INT = 7;
    int FTH = 8;
  }

  public class Astrologer{
    int HP = 9;
    int END = 9;
    int DEX = 12;
    int STR = 8;
    int INT = 16;
    int FTH = 7;
  }

  public class Prophet{
    int HP = 10;
    int END = 8;
    int DEX = 10;
    int STR = 11;
    int INT = 7;
    int FTH = 16;
  }

}