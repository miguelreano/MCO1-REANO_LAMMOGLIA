import java.util.Random;

/**
* The {@code Boss} class represents a boss enemy in the RPG game.
* It contains properties such as the boss's name, health, attack, physical defense, sorcery defense,
* incantation defense, and a method to display the boss's stats.
*/
public class Boss{
    private int health;
    private int attack;
    private double pDef; // physical defense
    private double sDef; // sorcery defense
    private double iDef; // incantation defense
    private String bossName;

    /**
     * The {@code Boss} constructor initializes the boss with the provided name, health, attack, physical defense,
     * sorcery defense, and incantation defense.
     *
     * @param bossName The name of the boss.
     * @param health The health of the boss.
     * @param attack The attack power of the boss.
     * @param pDef The physical defense of the boss.
     * @param sDef The sorcery defense of the boss.
     * @param iDef The incantation defense of the boss.
     */
    
    public Boss(String bossName, double pDef, double sDef, double iDef, int health, int attack) {
        this.bossName = bossName;
        this.pDef = pDef;
        this.sDef = sDef;
        this.iDef = iDef;
        this.health = health;
        this.attack = attack;
    }
    @Override
    public String toString() {
        return String.format("Health: %d, Attack: %d, Physical Defense: %.2f, Sorcery Defense: %.2f, Incantation Defense: %.2f",
                health, attack, pDef, sDef, iDef);
    }

    public String getBossname(){
        return bossName;
    }

    public void setBossname(String bossName){
        this.bossName = bossName;
    }

    public double getpDef() {
        return pDef;
    }

    public void setpDef(double pDef) {
        this.pDef = pDef;
    }

    public double getsDef() {
        return sDef;
    }

    public void setsDef(double sDef) {
        this.sDef = sDef;
    }

    public double getiDef() {
        return iDef;
    }

    public void setiDef(double iDef) {
        this.iDef = iDef;
    }

    public int getHealth() {
        return health;
    }

    // Updated to take a parameter
    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    // Updated to take a parameter
    public void setAttack(int attack) {
        this.attack = attack;
    }

    public static int bossAttack1(){
        Random random = new Random();
        return random.nextInt(151) + 150;
    }

    public static int bossAttack2(){
        Random random = new Random();
        return random.nextInt(101)+200;
    }

    public static int bossAttack3(){
        Random random = new Random();
        return random.nextInt(251) + 250;
    }

    public static Boss[] initializeBoss(){
        Boss[] boss = new Boss[3];

        boss[0] = new Boss("Godrick Boss", 0.35, 0.20, 0.15, 200, bossAttack1());
        boss[1] = new Boss("Nala Boss", 0.15, 0.30, 0.25, 400, bossAttack2());
        boss[2] = new Boss("Elden Beast", 0.25, 0.50, 0.40, 800, bossAttack3());
        return boss;
    }

    


}