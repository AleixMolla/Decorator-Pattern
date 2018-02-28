import javax.swing.*;
import java.awt.*;

public class Driver {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tom's Cruise Alaskan Cruises!!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(new CruiserPanel());

        frame.setPreferredSize(new Dimension(600,310));
        frame.pack();
        frame.setVisible(true);
    }
}
