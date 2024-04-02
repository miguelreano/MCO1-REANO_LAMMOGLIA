import java.util.Random;

public class BossBattle {
    Character character = new Character();
    private boolean attemptDodge(){
        Random random = new Random();
        return (random.nextInt(100) + 1) <= character.getCharacterStats().getEND();
    }

    public void start(){
        
    }

    
}
