import java.util.Scanner;

public class Character {
    private Scanner scanner = new Scanner(System.in);
    private String characterName = "";
    private CharacterStats characterStats = null;
    private int Runes = 0;

    public void startCharacterCreation() {
        boolean isConfirmed = false;
        while (!isConfirmed) {
            System.out.println("[1] Input Name");
            System.out.println("[2] Select Class");
            System.out.println("[3] Confirm");
            System.out.println("[4] Back");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    System.out.print("Enter character name: ");
                    characterName = scanner.nextLine();
                    break;
                case 2:
                    chooseJobClass();
                    break;
                case 3:
                    if (characterName.isEmpty() || characterStats == null) {
                        System.out.println("Please ensure you have chosen a name and job class.");
                    } else {
                        System.out.println("Confirm Character? (yes/no)");
                        String confirm = scanner.nextLine();
                        if (confirm.equalsIgnoreCase("yes")) {
                            isConfirmed = true;
                            Menus.menusGameLobby();
                        } else {
                            System.out.println("Character creation not confirmed, returning to options.");
                        }
                    }
                    break;
                case 4:
                    Menus.TitleScreen();
                    break;
                default:
                    System.out.println("Invalid Input!");
                    startCharacterCreation();
            }
        }
    }

    private void chooseJobClass() {
        System.out.println("CLASS: \t\t HP  END  DEX  STR  INT  FTH \tLVL");
        System.out.println("[1] Vagabond \t 15   11   13   14    9    9     9");
        System.out.println("[2] Samurai \t 12   13   15   12    9    8     9");
        System.out.println("[3] Warrior \t 11   11   16   10   10    8     8");
        System.out.println("[4] Hero \t 14   12    9   16    7    8     7");
        System.out.println("[5] Astrologer \t  9    9   12    8   16    7     6");
        System.out.println("[6] Prophet \t 10    8   10   11    7   16     7");
        int classOption = scanner.nextInt();
        switch (classOption) {
            case 1:
                characterStats = new CharacterStats("Vagabond", 15, 11, 13, 14, 9, 9, 9);
                break;
            case 2:
                characterStats = new CharacterStats("Samurai", 12, 13, 15, 12, 9, 8, 9);
                break;
            case 3:
                characterStats = new CharacterStats("Warrior", 11, 11, 16, 10, 10, 8, 8);
                break;
            case 4:
                characterStats = new CharacterStats("Hero", 14, 12, 9, 16, 7, 8, 7);
                break;
            case 5:
                characterStats = new CharacterStats("Astrologer", 9, 9, 12, 8, 16, 7, 6);
                break;
            case 6:
                characterStats = new CharacterStats("Prophet", 10, 8, 10, 11, 7, 16, 7);
                break;
            default:
                System.out.println("Invalid selection. Please select a number between 1 and 6.");
        }
    }

    public CharacterStats getCharacterStats() {
        return characterStats;
    }

    class CharacterStats {
        String className;
        int HP, END, DEX, STR, INT, FTH, playerLevel;

        public CharacterStats(String className, int HP, int END, int DEX, int STR, int INT, int FTH, int playerLevel) {
            this.className = className;
            this.HP = HP;
            this.END = END;
            this.DEX = DEX;
            this.STR = STR;
            this.INT = INT;
            this.FTH = FTH;
            this.playerLevel = playerLevel;
        }

        public String getClassName() {
            return className;
        }

        public int getHP() {
            return HP;
        }

        public int getEND() {
            return END;
        }
        
        public int getDEX() {
            return DEX;
        }

        public int getSTR() {
            return STR;
        }

        public int getINT() {
            return INT;
        }

        public int getFTH() {
            return HP;
        }

        public int getPlayerLevel() {
            return playerLevel;
        }
    }

}