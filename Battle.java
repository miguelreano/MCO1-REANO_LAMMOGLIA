import java.util.Random;
import java.util.Scanner;

/**
 * The {@code Battle} class manages the game's battle system, handling player and enemy interactions,
 * turn-based mechanics, and battle outcomes.
 */
public class Battle {

    
    
    private Character player;
    private Object enemy; // Can be an instance of Spawn or Boss
    private Scanner scanner = new Scanner(System.in);
    Character character = new Character();
    
    Character.CharacterStats characterStats = character.getCharacterStats();
    private int getEnemyHealth() {
        if (enemy instanceof Spawn) {
            return ((Spawn) enemy).getHealth();
        } else if (enemy instanceof Boss) {
            return ((Boss) enemy).getHealth();
        }
        return 0;
    }

    private void setEnemyHealth(int newHealth) {
        if (enemy instanceof Spawn) {
            ((Spawn) enemy).setHealth(newHealth);
        } else if (enemy instanceof Boss) {
            ((Boss) enemy).setHealth(newHealth);
        }
    }
    
    /**
     * The {@code Battle} constructor initializes the battle with the provided player and enemy.
     *
     * @param player The player character.
     * @param enemy The enemy object, which can be an instance of {@code Spawn} or {@code Boss}.
     */
    public Battle(Character player, Object enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    /**
     * Starts the battle, displaying the initial battle state and managing the turn-based mechanics
     * until either the player or the enemy is defeated.
     *
     * @param characterStats The player's character stats.
     */
    public void start(Character.CharacterStats characterStats) {
        System.out.println("A fierce battle begins!");
        // Initial battle state display
        displayInitialBattleState(characterStats, character);
        
        while (characterStats.getHP() > 0 && getEnemyHealth() > 0) {
            playerTurn();
            if (getEnemyHealth() > 0) {
                enemyTurn(characterStats);
            }
        }

        concludeBattle(characterStats);
    }

    /**
     * Displays the initial battle state, showing the player and enemy information.
     *
     * @param characterStats The player's character stats.
     * @param character The player character.
     */
    private void displayInitialBattleState(Character.CharacterStats characterStats, Character character) {
        if (characterStats != null) {
            System.out.println("Player: " + character.getCharacterName() + " | Health: " + characterStats.getHP());
        } else {
            System.out.println("Player stats not initialized.");
        }
        System.out.println("Player Sprite: [==]"); // Placeholder sprite
        System.out.println("Enemy Sprite: [xx]"); // Placeholder sprite
    }

     /**
     * Manages the player's turn, allowing them to attack or dodge.
     */
    private void playerTurn() {
        System.out.println("\nPlayer Turn. Choose action:\n1. Attack\n2. Dodge");
        int action = scanner.nextInt();
        switch (action) {
            case 1: // Attack
                executePlayerAttack();
                break;
            case 2: // Dodge
                if (attemptDodge(characterStats)) {
                    System.out.println("Dodge successful! Enemy's turn is skipped.");
                    return;
                } else {
                    System.out.println("Dodge failed. Enemy will attack.");
                }
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                playerTurn();
                break;
        }
    }

    /**
     * Executes the player's attack, dealing damage to the enemy based on the selected attack type.
     */
    private void executePlayerAttack() {
        System.out.println("Choose your attack type:\n1. Physical\n2. Sorcery\n3. Incantation");
        int attackType = scanner.nextInt();
        int damage = 0;
    
        switch (attackType) {
            case 1: // Physical attack
                damage = calculatePlayerDamage("physical", characterStats);
                break;
            case 2: // Sorcery attack
                damage = calculatePlayerDamage("sorcery", characterStats);
                break;
            case 3: // Incantation attack
                damage = calculatePlayerDamage("incantation", characterStats);
                break;
            default:
                System.out.println("Invalid attack type selected. Defaulting to physical attack.");
                damage = calculatePlayerDamage("physical", characterStats);
                break;
        }
    
        System.out.println("Attacking the enemy with " + (attackType == 1 ? "physical" : attackType == 2 ? "sorcery" : "incantation") + " damage...");
        setEnemyHealth(getEnemyHealth() - damage);
        System.out.println("Dealt " + damage + " damage to the enemy.");
    }
    
    /**
     * Attempts to dodge the enemy's attack, with a success rate based on the player's END stat.
     *
     * @param characterStats The player's character stats.
     * @return {@code true} if the dodge is successful, {@code false} otherwise.
     */
    private boolean attemptDodge(Character.CharacterStats characterStats) {
        Random random = new Random();
        return random.nextInt(100) < characterStats.getEND(); // Example dodge logic
    }

    /**
     * Manages the enemy's turn, allowing them to attack the player.
     *
     * @param characterStats The player's character stats.
     */
    private void enemyTurn(Character.CharacterStats characterStats) {
        // Example adaptation for Boss and Spawn attacks
        int damage = 0;
        if (enemy instanceof Boss) {
            damage = ((Boss) enemy).getAttack(); // Use Boss' getAttack
            System.out.println("Boss attacks, dealing " + damage + " damage.");
        } else if (enemy instanceof Spawn) {
            damage = ((Spawn) enemy).getAttack(); // Use Spawn's getAttack
            System.out.println("Spawn attacks, dealing " + damage + " damage.");
        }
        characterStats.setHP(characterStats.getHP() - damage);
    }

    /**
     * Concludes the battle, updating the player's runes and returning to the game lobby if the player is defeated.
     *
     * @param characterStats The player's character stats.
     */
    private void concludeBattle(Character.CharacterStats characterStats) {
        if (characterStats.getHP() <= 0) {
            System.out.println(character.getCharacterName() + " has been defeated. Returning to game lobby...");
            character.setRunes(0);
            // Logic to return to game lobby goes here
        } else {
            System.out.println("Enemy defeated! Gaining runes...");
            character.addRunes(getEnemyHealth() * 2); // Placeholder logic for rune reward
        }
    }

    /**
     * Calculates the player's damage based on the selected attack type and their character stats.
     *
     * @param attackType The selected attack type (physical, sorcery, or incantation).
     * @param stats The player's character stats.
     * @return The calculated damage.
     */
    private int calculatePlayerDamage(String attackType, Character.CharacterStats stats) {
        
        Weapon equippedWeapon = character.getEquippedWeapon();
        int damage = 0;
    
        // Retrieve enemy defenses
        double enemyPhysicalDefense = (enemy instanceof Spawn) ? ((Spawn)enemy).getpDef() : ((Boss)enemy).getpDef(); // Assuming Boss class has getpDef method
        double enemySorceryDefense = (enemy instanceof Spawn) ? ((Spawn)enemy).getsDef() : ((Boss)enemy).getsDef(); // Assuming Boss class has getsDef method
        double enemyIncantationDefense = (enemy instanceof Spawn) ? ((Spawn)enemy).getiDef() : ((Boss)enemy).getiDef(); // Assuming Boss class has getiDef method
    
        switch (attackType) {
            case "physical":
                damage = (int) ((stats.getSTR() + (equippedWeapon != null ? equippedWeapon.getWeaponSTR() : 0)) * (1 - enemyPhysicalDefense));
                break;
            case "sorcery":
                damage = (int) ((stats.getINT() + (equippedWeapon != null ? equippedWeapon.getWeaponINT() : 0)) * (1 - enemySorceryDefense));
                break;
            case "incantation":
                damage = (int) ((stats.getFTH() + (equippedWeapon != null ? equippedWeapon.getWeaponFTH() : 0)) * (1 - enemyIncantationDefense));
                break;
        }
    
        return Math.max(damage, 0); // Ensure damage is not negative
    }
    
    
  
}
