/**
 * Julianna Charlize Lammoglia & Arstin Miguel Reano
 * S12
 * Last edit made April 5, 2024 11:19PM
 */
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TitleScreenGUI titleScreenGUI = new TitleScreenGUI();
                TitleScreenController titleScreenController = new TitleScreenController(titleScreenGUI);
            }
        });
    }
}
