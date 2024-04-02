import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

public class GameLobbyController {
    private GameLobby model;
    private GameLobbyGUI view;
    //Character character = new Character();
    public GameLobbyController(GameLobby model, GameLobbyGUI view) {
        this.model = model;
        this.view = view;

        // Add action listeners to buttons in the view
        this.view.addFastTravelButtonListener(new FastTravelButtonListener());
        this.view.addLevelUpButtonListener(new LevelUpButtonListener());
        this.view.addInventoryButtonListener(new InventoryButtonListener());
        this.view.addShopButtonListener(new ShopButtonListener());
        this.view.addQuitButtonListener(new QuitButtonListener());
        //view.updateCharacterInfo(character);
    }

    // Action listener for the Fast Travel button
    // Action listener for the Fast Travel button
    class FastTravelButtonListener implements ActionListener {
        //@Override
        public void actionPerformed(ActionEvent e) {
            view.dispose();
            FastTravelGUI fastTravelGUI = new FastTravelGUI();
            fastTravelGUI.setVisible(true);
        }
    }

// Action listener for the Level Up button
    class LevelUpButtonListener implements ActionListener {
        //@Override
        public void actionPerformed(ActionEvent e) {
            view.dispose();
            LevelUpGUI levelUpGUI = new LevelUpGUI();
            LevelUpController levelUpController = new LevelUpController(levelUpGUI, null);
        }
    }

    // Action listener for the Inventory button
    class InventoryButtonListener implements ActionListener {
        //@Override
        public void actionPerformed(ActionEvent e) {
            view.dispose();
            FastTravelGUI fastTravelGUI = new FastTravelGUI();
            fastTravelGUI.setVisible(true);
        }
    }

    // Action listener for the Shop button
    class ShopButtonListener implements ActionListener {
        //@Override
        public void actionPerformed(ActionEvent e) {
            view.dispose();
            ShopGUI shopGUI = new ShopGUI();
            shopGUI.setVisible(true);
        }
    }

    // Action listener for the Quit button
    class QuitButtonListener implements ActionListener {
        //@Override
        public void actionPerformed(ActionEvent e) {
            view.dispose();
            TitleScreenGUI titleScreenGUI = new TitleScreenGUI();
            TitleScreenController titleScreenController = new TitleScreenController(titleScreenGUI);
        }
        
    }

}
