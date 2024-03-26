public class Weapon {
    private String weaponName;
    private int weaponCost;
    private int weaponHP;
    private int weaponEND;
    private int weaponDEX;
    private int weaponSTR;
    private int weaponINT;
    private int weaponFTH;

    public Weapon(String weaponName, int weaponCost, int weaponHP, int weaponEND, int weaponDEX, int weaponSTR, int weaponINT, int weaponFTH) {
        this.weaponName = weaponName;
        this.weaponCost = weaponCost;
        this.weaponHP = weaponHP;
        this.weaponEND = weaponEND;
        this.weaponDEX = weaponDEX;
        this.weaponSTR = weaponSTR;
        this.weaponINT = weaponINT;
        this.weaponFTH = weaponFTH;

    }

    public String getName() {
        return weaponName;
    }

    public void setName(String weaponName) {
        this.weaponName = weaponName;
    }

    public int getWeaponCost() {
        return weaponCost;
    }

    public void setWeaponCost(int weaponCost) {
        this.weaponCost = weaponCost;
    }

    public int getWeaponHP() {
        return weaponHP;
    }

    public void setWeaponHP(int weaponHP) {
        this.weaponHP = weaponHP;
    }

    public int getWeaponEND() {
        return weaponEND;
    }

    public void setWeaponEND(int weaponEND) {
        this.weaponEND = weaponEND;
    }

    public int getWeaponDEX() {
        return weaponDEX;
    }

    public void setWeaponDEX(int weaponDEX) {
        this.weaponDEX = weaponDEX;
    }

    public int getWeaponSTR() {
        return weaponSTR;
    }

    public void setWeaponSTR(int weaponSTR) {
        this.weaponSTR = weaponSTR;
    }

    public int getWeaponINT() {
        return weaponINT;
    }

    public void setWeaponINT(int weaponINT) {
        this.weaponINT = weaponINT;
    }

    public int getWeaponFTH() {
        return weaponFTH;
    }

    public void setWeaponFTH(int weaponFTH) {
        this.weaponFTH = weaponFTH;
    }

    public static Weapon[] initializeWeapons() {
        Weapon[] weapons = new Weapon[24];

        weapons[0] = new Weapon("Short Sword", 1000, 0, 15, 13, 15, 15, 15);
        weapons[1] = new Weapon("Rogier's Rapier", 2000, 10, 25, 18, 35, 35, 35);
        weapons[2] = new Weapon("Coded Sword", 4000, 20, 35, 21, 40, 40, 40);
        weapons[3] = new Weapon("Sword of Night and Flame", 8000, 30, 45, 25, 55, 55, 55);
        
        weapons[4] = new Weapon("Uchigatana", 1875, 20, 35, 15, 30, 0, 0);
        weapons[5] = new Weapon("Moonveil", 3750, 30, 40, 20, 45, 0, 0);
        weapons[6] = new Weapon("River of Blood", 7500, 40, 45, 25, 60, 0, 0);
        weapons[7] = new Weapon("Hand of Malenia", 15000, 50, 50, 30, 75, 0, 0);

        weapons[8] = new Weapon("Whip", 1500, 15, 60, 20, 20, 0, 0);
        weapons[9] = new Weapon("Urumi", 3000, 20, 70, 25, 40, 10, 0);
        weapons[10] = new Weapon("Thorned Whip", 5000, 30, 80, 30, 50, 0, 40);
        weapons[11] = new Weapon("Hoslow's Petal Whip", 10000,35, 90, 35, 55, 20, 20);

        weapons[12] = new Weapon("Claymore", 3000, 15, 10, 9, 20, 0, 0);
        weapons[13] = new Weapon("Starscourge Greatsword", 6000, 20, 15, 14, 40, 0, 20);
        weapons[14] = new Weapon("Inseparable Sword", 12000, 25, 20, 19, 70, 60, 60);
        weapons[15] = new Weapon("Malekith's Black Blade", 24000, 30, 25, 24, 80, 40, 60);

        weapons[16] = new Weapon("Astrologer's Staff", 2000, 5, 20, 12, 5, 25, 15);
        weapons[17] = new Weapon("Albinauric Staff", 4000, 10, 30, 14, 10, 45, 35);
        weapons[18] = new Weapon("Staff of the Guilty", 8000, 15, 40, 16, 15, 65, 60);
        weapons[19] = new Weapon("Carian Regal Scepter", 16000, 25, 50, 18, 20, 85, 75);

        weapons[20] = new Weapon("Finger Seal", 2500, 10, 45, 10, 0, 15, 20);
        weapons[21] = new Weapon("Godslayer's Seal", 5000, 15, 50, 12, 0, 35, 40);
        weapons[22] = new Weapon("Golden Order Seal", 10000, 20, 55, 14, 0, 65, 65);
        weapons[23] = new Weapon("Dragon Communion Seal", 15000, 25, 60, 18, 0, 75, 80);

        return weapons;
    }

    public void displayWeaponStats(){
        System.out.println("Weapon Name:" + weaponName);
        System.out.println("Cost: " + weaponCost);
        System.out.println("Current Stats:");
        System.out.println("HP: " + weaponHP);
        System.out.println("END: " + weaponEND);
        System.out.println("DEX: " + weaponDEX);
        System.out.println("STR: " + weaponSTR);
        System.out.println("INT: " + weaponINT);
        System.out.println("FTH: " + weaponFTH);
    }
}
