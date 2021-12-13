package Gui;

import api.DirectedWeightedGraph;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Add_Edge extends JFrame implements ActionListener {
    private JTextField Src, Dest, Weight;
    private JLabel src_t, weight_t, dest_t;
    private JButton add_bt;

    private MyJpanel panel;
    private DirectedWeightedGraph MyGraph;

    public Add_Edge(DirectedWeightedGraph MyGraph, MyJpanel panel) {
        this.MyGraph = MyGraph;
        this.panel = panel;
        src_t = new JLabel("Sours");
        dest_t = new JLabel("Destination");
        weight_t = new JLabel("Weight");
        add_bt = new JButton("Add");
        add_bt.addActionListener(this);
        Src = new JTextField(2);
        Dest = new JTextField(2);
        Weight = new JTextField(8);


        JPanel jPanel = new JPanel();
        jPanel.add(src_t);
        jPanel.add(Src);
        jPanel.add(dest_t);
        jPanel.add(Dest);
        jPanel.add(weight_t);
        jPanel.add(Weight);
        jPanel.add(add_bt);

        add(jPanel);
        pack();
        setResizable(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Add")) {
            closeWindow();
        }
    }

    private void closeWindow() {
        setVisible(false);
        MyGraph.connect(Integer.parseInt(Src.getText()), Integer.parseInt(Dest.getText()), Double.parseDouble(Weight.getText()));
        JOptionPane.showMessageDialog(new JFrame(), "Add Success", "Add Edge", JOptionPane.DEFAULT_OPTION);
        panel.repaint();
        this.dispose();
    }
}