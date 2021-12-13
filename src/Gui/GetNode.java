package Gui;

import api.DirectedWeightedGraph;
import api.NodeData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GetNode extends JFrame implements ActionListener {
    private JButton Press_Enter;
    private JLabel Search_text;
    private JTextField num_ID;

    private DirectedWeightedGraph MyGraph;

    public GetNode(DirectedWeightedGraph MyGraph) {
        this.MyGraph = MyGraph;
        Search_text = new JLabel("Enter ID node");
        Press_Enter = new JButton("Get");
        Press_Enter.addActionListener(this);
        num_ID = new JTextField(2);

        JPanel p = new JPanel();
        p.add(Search_text);
        p.add(num_ID);
        p.add(Press_Enter);
        add(p);

        pack();
        setResizable(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Get")) {
            action();
        }
    }
    private void action() {
        setVisible(false);
        NodeData my_node = MyGraph.getNode(Integer.parseInt(num_ID.getText()));
        if (my_node != null) {
            String x_lo = my_node.getLocation().x()+"";
            String y_lo = my_node.getLocation().y()+"";
            String location = "\t\t\t\nLocation: (X= " + x_lo.substring(0,x_lo.indexOf(".")+4)+",Y=  " + x_lo.substring(0,y_lo.indexOf(".")+4)+",Z= 0.0)";
            JOptionPane.showMessageDialog(new JFrame(), location, "Node: " + my_node.getKey(), JOptionPane.DEFAULT_OPTION);
            this.dispose();
        }
    }
}