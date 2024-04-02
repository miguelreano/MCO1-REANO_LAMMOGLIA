import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        view.dispose(); // Close the current window
        new FastTravelGUI().setVisible(true); // Open the FastTravelGUI window
    }
}

// Action listener for the Level Up button
    class LevelUpButtonListener implements ActionListener {
        //@Override
        public void actionPerformed(ActionEvent e) {
            view.dispose(); // Close the current window
            new LevelUpGUI().setVisible(true); // Open the LevelUpGUI window
        }
    }

    // Action listener for the Inventory button
    class InventoryButtonListener implements ActionListener {
        //@Override
        public void actionPerformed(ActionEvent e) {
            view.dispose(); // Close the current window
            //new InventoryGUI().setVisible(true); // Open the InventoryGUI window
        }
    }

    // Action listener for the Shop button
    class ShopButtonListener implements ActionListener {
        //@Override
        public void actionPerformed(ActionEvent e) {
            view.dispose(); // Close the current window
            new ShopGUI().setVisible(true); // Open the ShopGUI window
        }
    }

    // Action listener for the Quit button
    class QuitButtonListener implements ActionListener {
        //@Override
        public void actionPerformed(ActionEvent e) {
            view.dispose(); // Close the current window
            System.exit(0); // Close the entire application
        }
    }

}
