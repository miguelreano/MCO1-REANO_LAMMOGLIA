import java.util.Scanner;

/**
 * The {@code GameLobby} class provides functionalities for the game lobby, including fast travel and leveling up options.
 * It facilitates navigation between different game areas and managing character progression.
 */
public class GameLobby {
    private static Character.CharacterStats characterStats;
    
    private static Character user;
    GameArea gameArea = new GameArea();
    private static Weapon[] weapons;



    /**
     * Presents the Fast Travel menu to the player, allowing them to choose different destinations.
     * Depending on the player's choice, they can travel to various locations in the game or return to the game lobby.
     * This method uses a scanner to capture user input and switch to the desired game location.
     */
    public static void FastTravel(Character.CharacterStats characterStats) {
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
                FastTravel(characterStats);
                break;
            case 3:
                System.out.print("\033\143");
                System.out.println("Going to The Elden Throne");
                Menus.Pause();
                System.out.print("\033\143");
                FastTravel(characterStats);
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
                FastTravel(characterStats);
                break;
        }

        scanner.close(); 
    }


    /**
     * Allows the player to level up their character by spending runes. The player can choose which attribute to level up,
     * affecting the character's overall stats. Each level up increases the cost in runes, requiring the player to manage
     * their resources wisely.
     *
     * @param characterStats The character's current stats, used to calculate the cost and effect of leveling up.
     * @param user The character instance being leveled up, which holds the rune balance and stats.
     */
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

    public static void Inventory(Character user) {
        Scanner scanner = new Scanner(System.in);
    
        // Display equipped weapon
        System.out.println("Equipped Weapon: " + (user.getEquippedWeapon() != null ? user.getEquippedWeapon().getName() : " "));
    
        // Display inventory
        System.out.println("\nInventory:");
        user.displayInventory();
    
        // Prompt user for action
        System.out.println("\n[1] Select a weapon to equip");
        System.out.println("[2] Back");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
    
        switch (choice) {
            case 1:
                System.out.print("\033\143"); // Clear screen
                user.displayInventory();
                System.out.print("Enter the number of the weapon to equip: ");
                int index = scanner.nextInt();
                if (index >= 1 && index <= user.getInventory().size()) {
                    Weapon selectedWeapon = user.getInventory().get(index - 1); // Adjust index to match list
                    if (user.getCharacterStats().getDEX() >= selectedWeapon.getWeaponDEX()) {
                    // Set the chosen weapon as the equipped weapon
                    user.setEquippedWeapon(selectedWeapon);
                    System.out.print("\033\143");
                    System.out.println(selectedWeapon.getName() + " equipped successfully!");
                } else {
                    System.out.print("\033\143");
                    System.out.println("You do not meet the dexterity requirement to equip this weapon.");
                }
                } else {
                    System.out.println("Invalid input.");
                }
                Menus.Pause();
                System.out.print("\033\143");
                Inventory(user); // Go back to manage inventory
                break;
            case 2:
                System.out.print("\033\143"); // Clear screen
                Menus.menusGameLobby(user.getCharacterStats()); // Back to main game lobby
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                Menus.Pause();
                System.out.print("\033\143");
                Inventory(user); // Go back to manage inventory
                break;
        }
    
        scanner.close();
    }
    

    public static void Shop(Weapon[] weapons, Character user) {
        Scanner scanner = new Scanner(System.in);
    
        weapons = Weapon.initializeWeapons();
    
        while (true) {
            Weapon.displayAvailableWeapons(weapons);
            
            System.out.println("\nCurrent Runes: " + user.getRunes());

            System.out.println("\nType '0' to exit.");
            System.out.print("Which weapon would you like to buy?: ");
            
    
            int shopOption = scanner.nextInt();
    
            if (shopOption == 0) {
                System.out.print("\033\143");
                System.out.println("Exiting the shop...");
                Menus.Pause();
                System.out.print("\033\143");
                Menus.menusGameLobby(user.getCharacterStats());
            }
    
            try {
                if (shopOption >= 1 && shopOption <= weapons.length) {
                    Weapon selectedWeapon = weapons[shopOption]; // Adjust index to match array
                    int cost = selectedWeapon.getWeaponCost();
                    if (user.getRunes() >= cost) {
                        user.subtractRunes(cost);
                        System.out.print("\033\143");
                        System.out.println("You have purchased: " + selectedWeapon.getName());
                        user.addtoInventory(selectedWeapon);
                        Menus.Pause();
                        System.out.print("\033\143");
                    } else {
                        System.out.print("\033\143");
                        System.out.println("You don't have enough runes to buy this weapon!");
                        Menus.Pause();
                        System.out.print("\033\143");
                }
                    
                } else {
                    System.out.print("\033\143");
                    System.out.println("Invalid Option.");
                    Menus.Pause();
                    System.out.print("\033\143");
                }
            } catch (Exception e) {
                System.out.print("\033\143");
                System.out.println("An error occurred: " + e.getMessage());
                Menus.Pause();
                System.out.print("\033\143");
            }
            
        }
        
    }
        
}

