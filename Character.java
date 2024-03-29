import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * Represents a character in the game, including their stats, name, and runes.
 * This class also handles the character creation process, allowing players to input their name,
 * select a class, and confirm their choices.
 */
public class Character {
    private Scanner scanner = new Scanner(System.in);
    public static String characterName = "";
    private CharacterStats characterStats = null;
    private int Runes = 10000;
    private List<Weapon> inventory;
    private Weapon equippedWeapon;


    public Character() {
        inventory = new ArrayList<>();
    }

    public List<Weapon> getInventory() {
        return inventory;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public void setEquippedWeapon(Weapon equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }

    /**
     * Retrieves the current amount of runes the character has.
     * @return The current amount of runes.
     */
    public int getRunes() {
        return this.Runes;
    }

    /**
     * Sets the rune count for the character.
     * @param Runes The new amount of runes to set.
     */
    public void setRunes(int Runes) {
        this.Runes = Runes;
    }

    
    /**
     * Increases the character's rune count by a specified amount.
     * @param amount The amount to add to the current runes.
     */
    public void addRunes(int amount) {
        this.Runes += amount;
    }

    /**
     * Decreases the character's rune count by a specified amount.
     * @param amount The amount to subtract from the current runes.
     */
    public void subtractRunes(int amount) {
        this.Runes -= amount;
    }

    
    /**
     * Starts the character creation process, allowing the player to input their name,
     * select a character class, and confirm their choices.
     */
    public void startCharacterCreation() {
        boolean isConfirmed = false;
        while (!isConfirmed) {

            System.out.print("\033\143");
            Menus.Title();
            System.out.println("\n[1] Input Name");
            System.out.println("[2] Select Class");
            System.out.println("[3] Confirm");
            System.out.println("[4] Back");

            System.out.print("\nEnter choice: ");
            int choice = scanner.nextInt();

            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    System.out.print("\033\143");
                    System.out.print("Enter character name: ");
                    characterName = scanner.nextLine();
                    Menus.Pause();
                    System.out.print("\033\143");
                    System.out.println("Name set to " + characterName);
                    Menus.Pause();
                    System.out.print("\033\143");
                    break;
                case 2:
                    System.out.print("\033\143");
                    selectClass();
                    break;
                case 3:
                    System.out.print("\033\143");
                    if (characterName.isEmpty() || characterStats == null) {
                        System.out.print("\033\143");
                        System.out.println("Please ensure you have chosen a name and job class.");
                        Menus.Pause();
                        System.out.print("\033\143");
                    } else {
                        System.out.println("Confirm Character?");
                        System.out.println("[YES] [NO]");
                        System.out.print("\nEnter Choice: ");
                        String confirm = scanner.nextLine();
                        if (confirm.equalsIgnoreCase("yes")) {
                            System.out.print("\033\143");
                            isConfirmed = true;
                            Menus.menusGameLobby(characterStats);
                        } else if (confirm.equalsIgnoreCase("no")) {
                            System.out.print("\033\143");
                            System.out.println("Character creation not confirmed, returning to options.");
                            Menus.Pause();
                            System.out.print("\033\143");
                        }
                    }
                    break;
                case 4:
                    System.out.print("\033\143");
                    Menus.TitleScreen();
                    break;
                default:
                    System.out.print("\033\143");
                    System.out.println("Invalid Input!");
                    Menus.Pause();
                    System.out.print("\033\143");
                    startCharacterCreation();
                    
            }
        }
    }

    /**
     * Presents the class selection menu to the player and sets the character's stats
     * based on the selected class.
     */
    private void selectClass() {
        System.out.println("CLASS: \t\t HP  END  DEX  STR  INT  FTH \tLVL");
        System.out.println("[1] Vagabond \t 15   11   13   14    9    9     9");
        System.out.println("[2] Samurai \t 12   13   15   12    9    8     9");
        System.out.println("[3] Warrior \t 11   11   16   10   10    8     8");
        System.out.println("[4] Hero \t 14   12    9   16    7    8     7");
        System.out.println("[5] Astrologer \t  9    9   12    8   16    7     6");
        System.out.println("[6] Prophet \t 10    8   10   11    7   16     7");

        System.out.print("\nEnter choice: ");
        int selectedClass = scanner.nextInt();
        switch (selectedClass) {
            case 1:
                characterStats = new CharacterStats("Vagabond", 15, 11, 13, 14, 9, 9, 9);
                System.out.print("\033\143");
                System.out.println("You have selected the Vagabond class.");
                Menus.Pause();
                System.out.print("\033\143");
                break;
            case 2:
                characterStats = new CharacterStats("Samurai", 12, 13, 15, 12, 9, 8, 9);
                System.out.print("\033\143");
                System.out.println("You have selected the Samurai class.");
                Menus.Pause();
                System.out.print("\033\143");
                break;
            case 3:
                characterStats = new CharacterStats("Warrior", 11, 11, 16, 10, 10, 8, 8);
                System.out.print("\033\143");
                System.out.println("You have selected the Warrior class.");
                Menus.Pause();
                System.out.print("\033\143");
                break;
            case 4:
                characterStats = new CharacterStats("Hero", 14, 12, 9, 16, 7, 8, 7);
                System.out.print("\033\143");
                System.out.println("You have selected the Hero class.");
                Menus.Pause();
                System.out.print("\033\143");
                break;
            case 5:
                characterStats = new CharacterStats("Astrologer", 9, 9, 12, 8, 16, 7, 6);
                System.out.print("\033\143");
                System.out.println("You have selected the Astrologer class.");
                Menus.Pause();
                System.out.print("\033\143");
                break;
            case 6:
                characterStats = new CharacterStats("Prophet", 10, 8, 10, 11, 7, 16, 7);
                System.out.print("\033\143");
                System.out.println("You have selected the Prophet class.");
                Menus.Pause();
                System.out.print("\033\143");
                break;
            default:
                System.out.print("\033\143");
                System.out.println("Invalid selection. Please select a number between 1 and 6.");
                Menus.Pause();
                System.out.print("\033\143");
                selectClass();
        }
    }

    /**
     * Retrieves the character's stats.
     *
     * @return The current {@code CharacterStats} of the character.
     */
    public CharacterStats getCharacterStats() {
        return characterStats;
    }
    
    /**
     * Represents the statistics of a character, including class name, health points (HP),
     * endurance (END), dexterity (DEX), strength (STR), intelligence (INT), faith (FTH),
     * and player level.
     */
    class CharacterStats {
        String className;
        int HP, END, DEX, STR, INT, FTH, playerLevel;

        
        /**
         * Constructs a {@code CharacterStats} object with specified stats.
         *
         * @param className The class name of the character.
         * @param HP The health points of the character.
         * @param END The endurance level of the character.
         * @param DEX The dexterity level of the character.
         * @param STR The strength level of the character.
         * @param INT The intelligence level of the character.
         * @param FTH The faith level of the character.
         * @param playerLevel The current level of the character.
         */
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

          /**
         * getters and setters for the constructor above
         */
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
            return FTH;
        }

        public int getPlayerLevel() {
            return playerLevel;
        }

        public String setClassName(String className) {
            this.className = className;
            return this.className;
        }

        public void setHP(int HP) {
            this.HP = HP;
        }

        public void setEND(int END) {
            this.END = END;
        }

        public void setDEX(int DEX) {
            this.DEX = DEX;
        }

        public void setSTR(int STR) {
            this.STR = STR;
        }

        public void setINT(int INT) {
            this.INT = INT;
        }

        public void setFTH(int FTH) {
            this.FTH = FTH;
        }

        public void setPlayerLevel(int playerLevel) {
            this.playerLevel = playerLevel;
        }
        
        
        /**
         * Displays the current stats of the character to the console.
         */
        public void displayStats() {
            System.out.println("Class:" + className);
            System.out.println("Current Stats:");
            System.out.println("HP: " + HP);
            System.out.println("END: " + END);
            System.out.println("DEX: " + DEX);
            System.out.println("STR: " + STR);
            System.out.println("INT: " + INT);
            System.out.println("FTH: " + FTH);
            System.out.println("Player Level: " + playerLevel);
        }

    }

    public void addtoInventory(Weapon weapons) {
        inventory.add(weapons);
    }

    public void displayInventory() {
        if (inventory.isEmpty()){
            System.out.println(":(");
        } else {
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.printf("| %-35s | %-7s | %-3s | %-2s | %-1s | %s | %s | %s |\n", "NAME", "COST", "HP", "END", "DEX", "STR", "INT", "FTH");
            System.out.println("-------------------------------------------------------------------------------------");
            for (int i = 0; i < inventory.size(); i++) {
                Weapon weapon = inventory.get(i);
                String stats = String.format("| [%2d] %-30s | %-7d | %-3d | %-3d | %-3d | %-3d | %-3d | %-3d |",
                        i + 1, weapon.getName(), weapon.getWeaponCost(), weapon.getWeaponHP(), weapon.getWeaponEND(), weapon.getWeaponDEX(),
                        weapon.getWeaponSTR(), weapon.getWeaponINT(), weapon.getWeaponFTH());
                System.out.println(stats);
            }   
            System.out.println("-------------------------------------------------------------------------------------");
        }  
    }

    
}
