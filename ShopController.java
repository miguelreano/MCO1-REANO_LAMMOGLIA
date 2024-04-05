/*import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ShopController {
    private ShopGUI view;
    private Character model;
    private Weapon[] weapons;

    public ShopController(ShopGUI view, Character model, Weapon[] weapons) {
        this.view = view;
        this.model = model;
        this.weapons = Weapon.initializeWeapons(); // Assuming this is how you've set up weapon initialization

        initializeWeaponButtons();
    }

    private void initializeWeaponButtons() {
        // This assumes the ShopGUI has been adjusted to include a method for retrieving weapon buttons
        JButton[] weaponButtons = view.getWeaponButtons();
        for (int i = 0; i < weaponButtons.length; i++) {
            final int weaponIndex = i;
            weaponButtons[i].addActionListener(e -> purchaseWeapon(weapons[weaponIndex]));
        }
    }

    private void purchaseWeapon(Weapon weapon) {
        if (model.getRunes() >= weapon.getWeaponCost()) {
            model.subtractRunes(weapon.getWeaponCost());
            model.addtoInventory(weapon);
            JOptionPane.showMessageDialog(view, "You have purchased: " + weapon.getName());
        } else {
            JOptionPane.showMessageDialog(view, "You don't have enough runes to buy this weapon!");
        }
    }
}*/
