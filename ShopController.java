import javax.swing.*;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.awt.event.ActionListener;

public class ShopController {
    private ShopGUI view;
    private Character model;
    // Assuming Weapon class and a method to find a weapon by name are available
    private Weapon[] weapons; // Array of Weapon objects available for purchase

    public ShopController(ShopGUI view, Character user, Weapon[] weapons) {
        this.view = view;
        this.model = user;
        this.weapons = weapons;
        //initializeWeaponButtons();

        view.addBackButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                GameLobbyGUI gameLobbyGUI = new GameLobbyGUI();
                GameLobbyController gameLobbyController = new GameLobbyController(user, gameLobbyGUI);
            }
        });
    }

    private void initializeWeaponButtons() {
        // Assuming ShopGUI has a method getWeaponButtons() that returns an array of JButtons
        JButton[] weaponButtons = view.getWeaponButtons();
        for (JButton button : weaponButtons) {
            button.addActionListener(e -> {
                String weaponName = e.getActionCommand(); // Get the weapon name from the button's text
                Weapon weaponToBuy = findWeaponByName(weaponName);
                if (weaponToBuy != null) {
                    purchaseWeapon(weaponToBuy);
                }
            });
        }
    }

    private Weapon findWeaponByName(String name) {
        for (Weapon weapon : weapons) {
            if (weapon.getName().equals(name)) {
                return weapon;
            }
        }
        return null; // Return null if no weapon found with the given name
    }

    private void purchaseWeapon(Weapon weapon) {
        if (user.getRunes() >= weapon.getPrice()) {
            user.subtractRunes(weapon.getPrice()); // Assuming Character has a method to subtract runes
            user.addWeaponToInventory(weapon); // Assuming Character has a method to add a weapon to its inventory
            JOptionPane.showMessageDialog(view, "You have purchased: " + weapon.getName(), "Purchase Successful", JOptionPane.INFORMATION_MESSAGE);
            // Update UI elements like user's runes here if necessary
        } else {
            JOptionPane.showMessageDialog(view, "Insufficient runes to purchase " + weapon.getName(), "Purchase Failed", JOptionPane.ERROR_MESSAGE);
        }
    }
}


 /*import javax.swing.*;

public class ShopController {
    private ShopGUI view;
    private Character user;
    // Assuming Weapon class and a method to find a weapon by name are available
    private Weapon[] weapons; // Array of Weapon objects available for purchase

    public ShopController(ShopGUI view, Character user, Weapon[] weapons) {
        this.view = view;
        this.user = user;
        this.weapons = weapons;
        initializeWeaponButtons();
    }

    private void initializeWeaponButtons() {
        // Assuming ShopGUI has a method getWeaponButtons() that returns an array of JButtons
        JButton[] weaponButtons = view.getWeaponButtons();
        for (JButton button : weaponButtons) {
            button.addActionListener(e -> {
                String weaponName = e.getActionCommand(); // Get the weapon name from the button's text
                Weapon weaponToBuy = findWeaponByName(weaponName);
                if (weaponToBuy != null) {
                    purchaseWeapon(weaponToBuy);
                }
            });
        }
    }

    private Weapon findWeaponByName(String name) {
        for (Weapon weapon : weapons) {
            if (weapon.getName().equals(name)) {
                return weapon;
            }
        }
        return null; // Return null if no weapon found with the given name
    }

    private void purchaseWeapon(Weapon weapon) {
        if (user.getRunes() >= weapon.getPrice()) {
            user.subtractRunes(weapon.getPrice()); // Assuming Character has a method to subtract runes
            user.addWeaponToInventory(weapon); // Assuming Character has a method to add a weapon to its inventory
            JOptionPane.showMessageDialog(view, "You have purchased: " + weapon.getName(), "Purchase Successful", JOptionPane.INFORMATION_MESSAGE);
            // Update UI elements like user's runes here if necessary
        } else {
            JOptionPane.showMessageDialog(view, "Insufficient runes to purchase " + weapon.getName(), "Purchase Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Additional methods as necessary...
}
 */   