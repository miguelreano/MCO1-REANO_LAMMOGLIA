import javax.swing.*;
import java.awt.*;

public class FastTravelGUI extends JFrame{
    private JButton Warp1;
    private JButton Warp2;
    private JButton Warp3;
    private JButton backButton;

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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FastTravelGUI(); // Make the JFrame visible
            }
        });
    }
    
}
