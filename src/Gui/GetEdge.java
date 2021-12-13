package Gui;

import api.DirectedWeightedGraph;
import api.EdgeData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GetEdge extends JFrame implements ActionListener {
    private JTextField Src, Dest;
    private JButton button_search;
    private JLabel Sours_text, Destination_text;

    private DirectedWeightedGraph MyGraph;

    public GetEdge(DirectedWeightedGraph MyGraph) {
        JPanel panel = new JPanel();
        this.MyGraph = MyGraph;
        Sours_text = new JLabel("Sours");
        Destination_text = new JLabel("Destination");
        button_search = new JButton("Get");
        button_search.addActionListener(this);
        Src = new JTextField(2);
        Dest = new JTextField(2);

        panel.add(Sours_text);
        panel.add(Src);
        panel.add(Destination_text);
        panel.add(Dest);
        panel.add(button_search);

        add(panel);
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
        EdgeData my_edge = MyGraph.getEdge(Integer.parseInt(Src.getText()), Integer.parseInt(Dest.getText()));
        if (my_edge != null) {
            String message = "Weight = " + my_edge.getWeight();
            JOptionPane.showMessageDialog(new JFrame(), message, "Edge  " + my_edge.getSrc() + " <---> " + my_edge.getDest() , JOptionPane.DEFAULT_OPTION);
            this.dispose();
        }
    }
}