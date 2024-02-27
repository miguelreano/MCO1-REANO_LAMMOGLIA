public class Character {
    public String playerName;

    public int HP;
    public int END;
    public int DEX;
    public int STR;
    public int INT;
    public int FTH;

    public Character() {
        this.HP = ClassStats.HP;
        this.END = ClassStats.END;
        this.DEX = ClassStats.DEX;
        this.STR = ClassStats.STR;
        this.INT = ClassStats.INT;
        this.FTH = ClassStats.FTH;
    }
}
