import java.util.Random;

/**
 * The {@code Battle} class manages the game's battle system, handling player and enemy interactions,
 * turn-based mechanics, and battle outcomes.
 */
public class Battle {
    private Character player;
    private Object enemy; // Can be an instance of Spawn or Boss
    private Character.CharacterStats characterStats; 

    public int getEnemyHealth() {
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
        this.characterStats = this.player.getCharacterStats();
    }


    /**
     * Displays the initial battle state, showing the player and enemy information.
     *
     * @param characterStats The player's character stats.
     * @param character The player character.
     */
    public String displayInitialBattleState() {
        String message = "";
        message += "Player: " + this.player.getCharacterName() + " | Health: " + this.characterStats.getHP();
        message += "\nPlayer Sprite: [==]"; // Placeholder sprite
        message += "\nEnemy Sprite: [xx]"; // Placeholder sprite
        return message;
    }

    /**
     * Executes the player's attack, dealing damage to the enemy based on the selected attack type.
     */
    public String executePlayerAttack(int attackType) {
        int damage = 0;
    
        switch (attackType) {
            case 1: // Physical attack
                damage = calculatePlayerDamage("physical");
                break;
            case 2: // Sorcery attack
                damage = calculatePlayerDamage("sorcery");
                break;
            case 3: // Incantation attack
                damage = calculatePlayerDamage("incantation");
                break;
        }
    
        setEnemyHealth(getEnemyHealth() - damage);
        return "Attacking the enemy with " + (attackType == 1 ? "physical" : attackType == 2 ? "sorcery" : "incantation") + " damage..." + "\n\nDealt " + damage + " damage to the enemy.";
    }
    
    /**
     * Attempts to dodge the enemy's attack, with a success rate based on the player's END stat.
     *
     * @return {@code true} if the dodge is successful, {@code false} otherwise.
     */
    public boolean attemptDodge() {
        Random random = new Random();
        return random.nextInt(100) < this.characterStats.getEND(); // Example dodge logic
    }

    /**
     * Manages the enemy's turn, allowing them to attack the player.
     *
     */
    public String enemyTurn() {
        // Example adaptation for Boss and Spawn attacks
        int damage = 0;

        if (enemy instanceof Boss) {
            damage = ((Boss) enemy).getAttack(); // Use Boss' getAttack
            characterStats.setHP(this.characterStats.getHP() - damage);
            return "Boss attacks, dealing " + damage + " damage.";
        } else { // (enemy instanceof Spawn)
            damage = ((Spawn) enemy).getAttack(); // Use Spawn's getAttack
            characterStats.setHP(this.characterStats.getHP() - damage);
            return "Spawn attacks, dealing " + damage + " damage.";
        }
    }


    /**
     * Calculates the player's damage based on the selected attack type and their character stats.
     *
     * @param attackType The selected attack type (physical, sorcery, or incantation).
     * @return The calculated damage.
     */
    private int calculatePlayerDamage(String attackType) {
        
        Weapon equippedWeapon = this.player.getEquippedWeapon();
        int damage = 0;
    
        // Retrieve enemy defenses
        double enemyPhysicalDefense = (enemy instanceof Spawn) ? ((Spawn)enemy).getpDef() : ((Boss)enemy).getpDef(); // Assuming Boss class has getpDef method
        double enemySorceryDefense = (enemy instanceof Spawn) ? ((Spawn)enemy).getsDef() : ((Boss)enemy).getsDef(); // Assuming Boss class has getsDef method
        double enemyIncantationDefense = (enemy instanceof Spawn) ? ((Spawn)enemy).getiDef() : ((Boss)enemy).getiDef(); // Assuming Boss class has getiDef method
    
        switch (attackType) {
            case "physical":
                damage = (int) ((characterStats.getSTR() + (equippedWeapon != null ? equippedWeapon.getWeaponSTR() : 0)) * (1 - enemyPhysicalDefense));
                break;
            case "sorcery":
                damage = (int) ((characterStats.getINT() + (equippedWeapon != null ? equippedWeapon.getWeaponINT() : 0)) * (1 - enemySorceryDefense));
                break;
            case "incantation":
                damage = (int) ((characterStats.getFTH() + (equippedWeapon != null ? equippedWeapon.getWeaponFTH() : 0)) * (1 - enemyIncantationDefense));
                break;
        }
    
        return Math.max(damage, 0); // Ensure damage is not negative
    }
    
    
  
}
