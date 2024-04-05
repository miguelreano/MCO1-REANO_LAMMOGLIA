import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The {@code FastTravelGUI} class represents the graphical user interface for the fast travel feature in the game.
 */
public class FastTravelGUI extends JFrame{
    private JButton Warp1;
    private JButton Warp2;
    private JButton Warp3;
    private JButton backButton;

    /**
     * The {@code FastTravelGUI} constructor initializes the fast travel GUI with the specified components.
     */
    public FastTravelGUI() {
        setTitle("Fast Travel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        Warp1 = new JButton("Stormveil Castle");
        Warp2 = new JButton("Raya Lucaria Academy");
        Warp3 = new JButton("The Elden Throne");
        backButton = new JButton("Back");

        JPanel buttonpanel = new JPanel(new GridLayout(4, 1, 0, 10));
        buttonpanel.add(Warp1);
        buttonpanel.add(Warp2);
        buttonpanel.add(Warp3);
        buttonpanel.add(backButton);
        add(buttonpanel, BorderLayout.CENTER);

        setVisible(true);
        
        setLocationRelativeTo(null);

    }

    /**
     * Adds an action listener to the Warp1 button.
     *
     * @param listener The action listener to be added.
     */
    public void addWarp1(ActionListener listener){
        Warp1.addActionListener(listener);
    }

    /**
     * Adds an action listener to the Warp2 button.
     *
     * @param listener The action listener to be added.
     */
    public void addWarp2(ActionListener listener){
        Warp2.addActionListener(listener);
    }

    /**
     * Adds an action listener to the Warp3 button.
     *
     * @param listener The action listener to be added.
     */
    public void addWarp3(ActionListener listener){
        Warp3.addActionListener(listener);
    }

    
}
