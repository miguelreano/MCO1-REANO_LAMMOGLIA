public class Character {
    public String playerName;
    public int HP, END, DEX, STR, INT, FTH;
    public int playerLevel;

    // Modified constructor to accept parameters
    public Character(int HP, int END, int DEX, int STR, int INT, int FTH) {
        this.HP = HP;
        this.END = END;
        this.DEX = DEX;
        this.STR = STR;
        this.INT = INT;
        this.FTH = FTH;
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