import java.util.Scanner;
import javax.xml.stream.events.Characters;

import java.util.List;
import java.util.ArrayList;

/**
 * Represents a character in the game, including their stats, name, and runes.
 * This class also handles the character creation process, allowing players to input their name,
 * select a class, and confirm their choices.
 */
public class Character {
    private String characterName;
    private int Runes = 0;
    private CharacterStats characterStats;
    private List<Weapon> inventory;
    private Weapon equippedWeapon;

    public Character() {
        this.inventory = new ArrayList<>();
        this.Runes = 10000; // Starting runes
    }

    public String getCharacterName() {
        return characterName;
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

    public void setCharacterName(String name) {
        characterName = name;
    }

    // Method to select the character's class and update stats accordingly
    public void selectClass(String className) {
        switch (className) {
            case "Vagabond":
                characterStats = new CharacterStats("Vagabond", 15, 11, 13, 14, 9, 9, 9);
                break;
            case "Samurai":
                characterStats = new CharacterStats("Samurai", 12, 13, 15, 12, 9, 8, 9);
                break;
            case "Warrior":
                characterStats = new CharacterStats("Warrior", 11, 11, 16, 10, 10, 8, 8);
                break;
            case "Hero":
                characterStats = new CharacterStats("Hero", 14, 12, 9, 16, 7, 8, 7);
                break;
            case "Astrologer":
                characterStats = new CharacterStats("Astrologer", 9, 9, 12, 8, 16, 7, 6);
                break;
            case "Prophet":
                characterStats = new CharacterStats("Prophet", 10, 8, 10, 11, 7, 16, 7);
                break;
            default:
                characterStats = null;
                break;
        }
        
    }

    public String getStatsForClass(String className) {
        selectClass(className);
        if (characterStats != null) {
            return characterStats.toString();
        } 
        return "Class not found";
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

        public String toString() {
            return String.format("Class: %s\nHP: %d\nEND: %d\nDEX: %d\nSTR: %d\nINT: %d\nFTH: %d\nLVL: %d",
                    className, HP, END, DEX, STR, INT, FTH, playerLevel);
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
            System.out.println("-------------------------------------------------------------------------------");
            System.out.printf("| %-35s | %-7s | %-3s | %-2s | %s | %s | %s |\n", "NAME", "REQDEX", "HP", "END", "STR", "INT", "FTH");
            System.out.println("-------------------------------------------------------------------------------");
            for (int i = 0; i < inventory.size(); i++) {
                Weapon weapon = inventory.get(i);
                String stats = String.format("| [%2d] %-30s | %-7d | %-3d | %-3d | %-3d | %-3d | %-3d |",
                        i + 1, weapon.getName(), weapon.getWeaponDEX(), weapon.getWeaponHP(), weapon.getWeaponEND(), weapon.getWeaponDEX(),
                        weapon.getWeaponSTR(), weapon.getWeaponINT(), weapon.getWeaponFTH());
                System.out.println(stats);
            }   
            System.out.println("-------------------------------------------------------------------------------");
        }  
    }

    
}
