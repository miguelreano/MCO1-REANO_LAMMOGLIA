import java.util.Scanner;
import java.util.Random;

public class Spawn {
    private int health;
    private int attack;
    private double pDef; // physical defense
    private double sDef; // sorcery defense
    private double iDef; // incantation defense
    Spawn[] battles = new Spawn[3];
    public double getpDef(){
        return pDef;
    }

    public void setpDef(double pDef){
        this.pDef = pDef;
    }

    public double getsDef(){
        return sDef;
    }

    public void setsDef(double sDef){
        this.sDef = sDef;
    }

    public double getiDef(){
        return iDef;
    }

    public void setiDef(double iDef){
        this.iDef = iDef;
    }

    public Spawn(double pDef, double sDef, double iDef){
        this.pDef = pDef;
        this.iDef = iDef;
        this.sDef= sDef;

    }

    public static int typepickNumber() {
        Random random = new Random();
        return random.nextInt(3) + 1; // Generates a number between 0 (inclusive) and 3 (exclusive), then adds 1
    }

    public static Spawn[] initializeSpawn(){
        Spawn[] battles = new Spawn[3];
        battles[1] = new Spawn(0.20, 0.15, 0.10);
        battles[2] = new Spawn(0.50, 0.15, 0.20);
        battles[3] = new Spawn(0.25,0.25,0.20);


        return battles;

    }

    public static void chosenType(){
        if
    }
}
