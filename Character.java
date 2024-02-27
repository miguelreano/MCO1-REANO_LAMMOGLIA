public class Character {
    public static Character currentCharacter;
    public String playerName;
    public int HP, END, DEX, STR, INT, FTH;
    public int playerLevel;

    // Modified constructor to accept parameters
    public Character(String playerName, int HP, int END, int DEX, int STR, int INT, int FTH, int playerLevel) {
        this.playerName = playerName;
        this.HP = HP;
        this.END = END;
        this.DEX = DEX;
        this.STR = STR;
        this.INT = INT;
        this.FTH = FTH;
        this.playerLevel = playerLevel;
    }

    public void levelUpHP(){
        this.HP++;
    }
    public void levelUpEND(){
        this.END++;
    }
    public void levelUpDEX(){
        this.DEX++;
    }
    public void levelUpSTR(){
        this.STR++;
    }
    public void levelUpINT(){
        this.INT++;
    }
    public void levelUpFTH(){
        this.FTH++;
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