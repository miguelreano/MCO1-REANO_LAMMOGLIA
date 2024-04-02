/**
 * Julianna Charlize Lammoglia & Arstin Miguel Reano
 * S12
 * Last edit made March 1, 2024 11:15PM
 */
/*public class Main{
    public static void main(String[] args){

        new Menus();
    }
}*/

/*public class Main{
    public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            Menus titleScreen = new Menus();
            titleScreen.setVisible(true);
        }
    });
  }
} */

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Create TitleScreenGUI and its controller
                TitleScreenGUI titleScreenGUI = new TitleScreenGUI();
                TitleScreenController titleScreenController = new TitleScreenController(titleScreenGUI);
                // Display the title screen
                titleScreenGUI.setVisible(true);
            }
        });
    }
}
