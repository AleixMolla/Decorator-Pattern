import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CruiserPanel extends JPanel{

    private JPanel roomPane = new JPanel(), extrasPane = new JPanel();
    private JButton confirmB;
    private Color bottomBG= new Color(153,153,0), topBG = new Color(204,229,255);
    private Listener listener = new Listener();
    private JCheckBox beverageCBox, klondikeCBox, helicopterCBox, climbingCBox, lumberjackCBox, scientiologyCBox;
    private JRadioButton interiorRB, oceanRB, balconyRB, suiteRB;

    private JLabel roomLabel = new JLabel(" Room Type: "), addOns = new JLabel("Extra packages: ");

    public CruiserPanel() {

        add(setRoomPaneLayout());
        add(setExtraPaneLayout());

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
        scientiologyCBox.addActionListener(listener);

        setBackground(Color.WHITE);
    }

    public JPanel setRoomPaneLayout() {

        roomPane.add(roomLabel);
        roomPane.add(interiorRB= new JRadioButton("Interior room - $1000"));
        roomPane.add(oceanRB= new JRadioButton("Ocean room - $1500"));
        roomPane.add(balconyRB= new JRadioButton("Balcony room - $2000"));
        roomPane.add(suiteRB= new JRadioButton("Suite room - $3000"));

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

    public JPanel setExtraPaneLayout() {

        extrasPane.add(addOns);
        extrasPane.add(beverageCBox= new JCheckBox("Beverage package ($700): "));
        extrasPane.add(klondikeCBox= new JCheckBox("Klondike trail guided horseback tour ($50): "));
        extrasPane.add(helicopterCBox= new JCheckBox("Helicopter glacier tour ($200): "));
        extrasPane.add(climbingCBox= new JCheckBox("Rock climbing lessons ($60): "));
        extrasPane.add(lumberjackCBox= new JCheckBox("Lumberjack competition ($15): "));
        extrasPane.add(scientiologyCBox= new JCheckBox("Scientology enlightenment tour ($500): "));
        extrasPane.add(confirmB = new JButton("Confirm Purchase"));
        confirmB.setEnabled(false);

        extrasPane.setPreferredSize(new Dimension(600,200));
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
                                .addComponent(confirmB))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(climbingCBox)
                                .addComponent(lumberjackCBox)
                                .addComponent(scientiologyCBox))
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
                                .addComponent(scientiologyCBox))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(confirmB))
        );

        return extrasPane;
    }

    public class Listener implements ActionListener {

        Room room = null;

        public void actionPerformed (ActionEvent ae) {

            if (ae.getSource() == interiorRB || ae.getSource() == oceanRB ||
                    ae.getSource() == balconyRB || ae.getSource() == suiteRB ) {
                confirmB.setEnabled(true);
            }

            if (ae.getSource() == confirmB) {

                if (interiorRB.isContentAreaFilled())
                    room = new InteriorRoom();
                else if (oceanRB.isContentAreaFilled())
                    room = new OceanRoom();
                else if (balconyRB.isContentAreaFilled())
                    room = new BalconyRoom();
                else if (suiteRB.isContentAreaFilled())
                    room = new SuiteRoom();

                if (beverageCBox.isContentAreaFilled())
                    room = new BeverageExtra(room);
                if (klondikeCBox.isContentAreaFilled())
                    room = new KlondikeExtra(room);
                if (helicopterCBox.isContentAreaFilled())
                    room = new HelicopterExtra(room);
                if (climbingCBox.isContentAreaFilled())
                    room = new ClimbingExtra(room);
                if (lumberjackCBox.isContentAreaFilled())
                    room = new LumberjackExtra(room);
                if (scientiologyCBox.isContentAreaFilled())
                    room = new ScientologyExtra(room);

            }
        }
    }
}
