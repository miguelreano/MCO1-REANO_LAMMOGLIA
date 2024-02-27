import java.util.Scanner;

public class CharacterCreation {
    private Scanner scanner = new Scanner(System.in);
    private String characterName = "";
    private CharacterStats characterStats = null;
    private int HP, END, DEX, STR, INT, FTH;

    public void startCharacterCreation() {
        boolean isConfirmed = false;
        while (!isConfirmed) {
            System.out.println("[1] Input Name\n[2] Job Class\n[3] Confirm");
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
                            Menus.GameLobby();
                        } else {
                            System.out.println("Character creation not confirmed, returning to options.");
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid selection. Please select a number between 1 and 3.");
            }
        }
    }

    private void chooseJobClass() {
        System.out.println("Choose your job class:\n[1] Vagabond\n[2] Samurai\n[3] Warrior\n[4] Hero\n[5] Astrologer\n[6] Prophet");
        int classOption = scanner.nextInt();
        switch (classOption) {
            case 1:
                characterStats = new CharacterStats(15, 11, 13, 14, 9, 9, 9);
                break;
            case 2:
                characterStats = new CharacterStats(12, 13, 15, 12, 9, 8, 9);
                break;
            case 3:
                characterStats = new CharacterStats(11, 11, 16, 10, 10, 8, 8);
                break;
            case 4:
                characterStats = new CharacterStats(14, 12, 9, 16, 7, 8, 7);
                break;
            case 5:
                characterStats = new CharacterStats(9, 9, 12, 8, 16, 7, 6);
                break;
            case 6:
                characterStats = new CharacterStats(10, 8, 10, 11, 7, 16, 7);
                break;
            default:
                System.out.println("Invalid selection. Please select a number between 1 and 6.");
        }
    }

    class CharacterStats {
        int HP, END, DEX, STR, INT, FTH, playerLevel;

        public CharacterStats(int HP, int END, int DEX, int STR, int INT, int FTH, int playerLevel) {
            this.HP = HP;
            this.END = END;
            this.DEX = DEX;
            this.STR = STR;
            this.INT = INT;
            this.FTH = FTH;
            this.playerLevel = playerLevel;
        }
    }

}

/*
 * Old CODE
 * 
 * public class Character {
 * public String playerName;
 * 
 * public int HP;
 * public int END;
 * public int DEX;
 * public int STR;
 * public int INT;
 * public int FTH;
 * 
 * public Character() {
 * this.HP = ClassStats.HP;
 * this.END = ClassStats.END;
 * this.DEX = ClassStats.DEX;
 * this.STR = ClassStats.STR;
 * this.INT = ClassStats.INT;
 * this.FTH = ClassStats.FTH;
 * }
 * }
 */