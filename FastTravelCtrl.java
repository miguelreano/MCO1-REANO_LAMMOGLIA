import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;


public class FastTravelCtrl {
    private FastTravelGUI view;
    private GameLobby model;

    public FastTravelCtrl(GameLobby model, FastTravelGUI view){
        this.model = model;
        this.view = view;
    


    view.addWarp1(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            GameArea gameArea = new GameArea();
            Character character = new Character();
            Character.CharacterStats stats = character.getCharacterStats();
            GameAreaGui gameAreaGui = new GameAreaGui(gameArea, stats);
            GameAreaControll gameAreaControll = new GameAreaControll();
        }
    });

    view.addWarp2(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            //implementation
        }
    });

    view.addWarp2(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            //implementation
        }
    });
    }
    
}
