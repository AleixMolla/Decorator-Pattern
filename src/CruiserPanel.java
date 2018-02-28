import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class CruiserPanel extends JPanel{

    private JPanel roomPane = new JPanel(), extrasPane = new JPanel();
    private JButton confirmB;
    private Color bottomBG= new Color(135,153,133), topBG = new Color(204,229,255);
    private Listener listener = new Listener();
    private JCheckBox beverageCBox, klondikeCBox, helicopterCBox, climbingCBox, lumberjackCBox, scientologyCBox;
    private JRadioButton interiorRB, oceanRB, balconyRB, suiteRB;
    private JLabel roomLabel = new JLabel(" Room Type: "), addOns = new JLabel("Extra packages: ");
    private JLabel netTotalLabel, taxLabel, tipLabel, totalLabel;

    public CruiserPanel() {
        // Set Layout's
        add(setRoomPaneLayout());
        add(setExtraPaneLayout());

        // Add Listeners
        confirmB.addActionListener(listener);
        interiorRB.addActionListener(listener);
        oceanRB.addActionListener(listener);
        balconyRB.addActionListener(listener);
        suiteRB.addActionListener(listener);
        beverageCBox.addActionListener(listener);
        klondikeCBox.addActionListener(listener);
        helicopterCBox.addActionListener(listener);
        climbingCBox.addActionListener(listener);
        lumberjackCBox.addActionListener(listener);
        scientologyCBox.addActionListener(listener);

        setBackground(Color.WHITE);
    }

    /**
     *      Sets the Room's Panel Layout
     * */
    public JPanel setRoomPaneLayout() {

        roomPane.add(roomLabel);
        roomPane.add(interiorRB= new JRadioButton("Interior room - $1000"));
        roomPane.add(oceanRB= new JRadioButton("Ocean room - $1500"));
        roomPane.add(balconyRB= new JRadioButton("Balcony room - $2000"));
        roomPane.add(suiteRB= new JRadioButton("Suite room - $3000"));
        interiorRB.setOpaque(false);
        oceanRB.setOpaque(false);
        balconyRB.setOpaque(false);
        suiteRB.setOpaque(false);

        ButtonGroup group = new ButtonGroup();
        group.add(interiorRB);
        group.add(oceanRB);
        group.add(balconyRB);
        group.add(suiteRB);

        roomPane.setPreferredSize(new Dimension(580,80));
        roomPane.setBackground(topBG);
        GroupLayout layout = new GroupLayout(roomPane);
        roomPane.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addComponent(roomLabel)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(interiorRB)
                                .addComponent(oceanRB))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(balconyRB)
                                .addComponent(suiteRB))
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(roomLabel)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(interiorRB)
                                .addComponent(balconyRB))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(oceanRB)
                                .addComponent(suiteRB))
        );


        return roomPane;
    }

    /**
     *      Sets the Extra Decorator's Panel Layout
     * */
    public JPanel setExtraPaneLayout() {

        extrasPane.add(addOns);
        extrasPane.add(beverageCBox= new JCheckBox("Beverage package ($700): "));
        extrasPane.add(klondikeCBox= new JCheckBox("Klondike trail guided horseback tour ($50): "));
        extrasPane.add(helicopterCBox= new JCheckBox("Helicopter glacier tour ($200): "));
        extrasPane.add(climbingCBox= new JCheckBox("Rock climbing lessons ($60): "));
        extrasPane.add(lumberjackCBox= new JCheckBox("Lumberjack competition ($15): "));
        extrasPane.add(scientologyCBox= new JCheckBox("Scientology enlightenment tour ($500): "));
        extrasPane.add(netTotalLabel= new JLabel());
        extrasPane.add(taxLabel= new JLabel());
        extrasPane.add(tipLabel= new JLabel());
        extrasPane.add(totalLabel= new JLabel());
        extrasPane.add(confirmB = new JButton("Confirm Purchase"));
        confirmB.setEnabled(false);
        beverageCBox.setOpaque(false);
        klondikeCBox.setOpaque(false);
        helicopterCBox.setOpaque(false);
        climbingCBox.setOpaque(false);
        lumberjackCBox.setOpaque(false);
        scientologyCBox.setOpaque(false);

        extrasPane.setPreferredSize(new Dimension(600,210));
        extrasPane.setBackground(bottomBG);
        GroupLayout layout = new GroupLayout(extrasPane);
        extrasPane.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(addOns)
                                .addComponent(beverageCBox)
                                .addComponent(klondikeCBox)
                                .addComponent(helicopterCBox)
                                .addComponent(confirmB)
                                .addComponent(netTotalLabel)
                                .addComponent(totalLabel))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(climbingCBox)
                                .addComponent(lumberjackCBox)
                                .addComponent(scientologyCBox)
                                .addComponent(taxLabel)
                                .addComponent(tipLabel))
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(addOns)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(beverageCBox)
                                .addComponent(climbingCBox))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(klondikeCBox)
                                .addComponent(lumberjackCBox))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(helicopterCBox)
                                .addComponent(scientologyCBox))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(confirmB))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(netTotalLabel)
                                .addComponent(taxLabel))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(totalLabel)
                                .addComponent(tipLabel))
        );

        return extrasPane;
    }

    /**
     *      Listener of JRadioButtons, JCheckBoxes and JButton
     *          also modifies JLabels
     * */
    public class Listener implements ActionListener {

        private Room room = null;
        private DecimalFormat df = new DecimalFormat(".00");

        public void actionPerformed (ActionEvent ae) {
            // Enable the button to be pressed only if a Room is selected
            if (ae.getSource() == interiorRB || ae.getSource() == oceanRB ||
                    ae.getSource() == balconyRB || ae.getSource() == suiteRB ) {
                confirmB.setEnabled(true);
            }

            // Button Pressed Actions
            if (ae.getSource() == confirmB) {
                // Creates a Room object with the selected room
                if (interiorRB.isSelected())
                    room = new InteriorRoom();
                else if (oceanRB.isSelected())
                    room = new OceanRoom();
                else if (balconyRB.isSelected())
                    room = new BalconyRoom();
                else if (suiteRB.isSelected())
                    room = new SuiteRoom();

                // Wraps the room over decorator's selected
                if (beverageCBox.isSelected())
                    room = new BeverageExtra(room);
                if (klondikeCBox.isSelected())
                    room = new KlondikeExtra(room);
                if (helicopterCBox.isSelected())
                    room = new HelicopterExtra(room);
                if (climbingCBox.isSelected())
                    room = new ClimbingExtra(room);
                if (lumberjackCBox.isSelected())
                    room = new LumberjackExtra(room);
                if (scientologyCBox.isSelected())
                    room = new ScientologyExtra(room);

                // JLabel's calculations and display
                df.setRoundingMode(RoundingMode.HALF_UP);
                netTotalLabel.setText("Net Total = $"+df.format(room.cost()));
                taxLabel.setText("Taxes = $"+df.format(room.taxCost()-room.cost()));
                tipLabel.setText("Tips = $"+df.format(room.gratuity()));
                totalLabel.setText("TOTAL = $"+df.format(room.taxCost()+room.gratuity()));
            }

        }
    }
}
