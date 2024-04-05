import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

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

    public void addWarp1(ActionListener listener){
        Warp1.addActionListener(listener);
    }

    public void addWarp2(ActionListener listener){
        Warp2.addActionListener(listener);
    }

    public void addWarp3(ActionListener listener){
        Warp3.addActionListener(listener);
    }

    
}
