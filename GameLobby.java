import java.util.Scanner;

public class GameLobby {
    private static Character.CharacterStats characterStats;
    private Character user;
    GameArea gameArea = new GameArea();

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
                System.out.print("\033\143");
                System.out.println("Going to Stormveil Castle");
                Menus.Pause();
                System.out.print("\033\143");
                GameArea.FirstFloor(scanner);
                break;
            case 2:
                System.out.print("\033\143");
                System.out.println("Going to Raya Lucaria Academy");
                Menus.Pause();
                System.out.print("\033\143");
                FastTravel();
                break;
            case 3:
                System.out.print("\033\143");
                System.out.println("Going to The Elden Throne");
                Menus.Pause();
                System.out.print("\033\143");
                FastTravel();
                break;
            case 4:
                System.out.print("\033\143");
                Menus.menusGameLobby(characterStats);
                break;
            default:
                System.out.print("\033\143");
                System.out.println("Invalid choice. Please try again.");
                Menus.Pause();
                System.out.print("\033\143");
                FastTravel();
                break;
        }

        scanner.close();
    }

    public static void LevelUp(Character.CharacterStats characterStats, Character user) {
        Scanner scanner = new Scanner(System.in);

        int runeCost = (characterStats.getPlayerLevel() * 100) / 2;

        System.out.println("\nCurrent Runes: " + user.getRunes());

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
                        System.out.print("\033\143");
                        characterStats.setHP(characterStats.getHP() + 1);
                        characterStats.setPlayerLevel(characterStats.getPlayerLevel() + 1);
                        System.out.println("Leveled HP");
                        characterStats.displayStats();
                        LevelUp(characterStats, user);
                        System.out.print("\033\143");
                        break;
                    case 2:
                        System.out.print("\033\143");
                        characterStats.setEND(characterStats.getEND() + 1);
                        characterStats.setPlayerLevel(characterStats.getPlayerLevel() + 1);
                        System.out.println("Leveled END");
                        characterStats.displayStats();
                        LevelUp(characterStats, user);
                        System.out.print("\033\143");
                        break;
                    case 3:
                        System.out.print("\033\143");
                        characterStats.setDEX(characterStats.getDEX() + 1);
                        characterStats.setPlayerLevel(characterStats.getPlayerLevel() + 1);
                        System.out.println("Leveled DEX");
                        characterStats.displayStats();
                        LevelUp(characterStats, user);
                        System.out.print("\033\143");
                        break;
                    case 4:
                        System.out.print("\033\143");
                        characterStats.setSTR(characterStats.getSTR() + 1);
                        characterStats.setPlayerLevel(characterStats.getPlayerLevel() + 1);
                        System.out.println("Leveled STR");
                        characterStats.displayStats();
                        LevelUp(characterStats, user);
                        System.out.print("\033\143");
                        break;
                    case 5:
                        System.out.print("\033\143");
                        characterStats.setINT(characterStats.getINT() + 1);
                        characterStats.setPlayerLevel(characterStats.getPlayerLevel() + 1);
                        System.out.println("Leveled INT");
                        characterStats.displayStats();
                        LevelUp(characterStats, user);
                        System.out.print("\033\143");
                        break;
                    case 6:
                        System.out.print("\033\143");
                        characterStats.setFTH(characterStats.getFTH() + 1);
                        characterStats.setPlayerLevel(characterStats.getPlayerLevel() + 1);
                        System.out.println("Leveled FTH");
                        characterStats.displayStats();
                        LevelUp(characterStats, user);
                        System.out.print("\033\143");
                        break;
                }

            } else {
                System.out.print("\033\143");
                System.out.println("Not Enough Runes!");
                System.out.println("Current Runes: " + user.getRunes());
                Menus.Pause();
                System.out.print("\033\143");
                Menus.menusGameLobby(characterStats);
            }
        } else if (option == 7) {
            System.out.print("\033\143");
            Menus.menusGameLobby(characterStats);
        } else {
            System.out.print("\033\143");
            System.out.println("Invalid choice. Please try again.");
            Menus.Pause();
            System.out.print("\033\143");
            LevelUp(characterStats, user);
        }

        scanner.close();
    }

}