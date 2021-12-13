package Gui;

import api.DirectedWeightedGraphAlgorithms;
import api.NodeData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Short_Path extends JFrame implements ActionListener {
    private JTextField Sours_text, Destination_text;
    private JButton button_search;
    private JLabel Src, Dest;

    private DirectedWeightedGraphAlgorithms MyGraph;

    public Short_Path(DirectedWeightedGraphAlgorithms MyGraph) {
        this.MyGraph = MyGraph;
        Src = new JLabel("Sours:");
        Dest = new JLabel("Destination:");
        button_search = new JButton("OK");
        button_search.addActionListener(this);
        Sours_text = new JTextField(2);
        Destination_text = new JTextField(2);

        JPanel p = new JPanel();
        p.add(Src);
        p.add(Sours_text);
        p.add(Dest);
        p.add(Destination_text);
        p.add(button_search);

        add(p);
        pack();
        setResizable(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("OK")) {
            action();
        }
    }
    private void action() {
        String link = "";
        setVisible(false);
        List<NodeData> My_Node = MyGraph.shortestPath(Integer.parseInt(Sours_text.getText()), Integer.parseInt(Destination_text.getText()));
        if (!My_Node.isEmpty()) {
            for (NodeData nodeData : My_Node) {
                link += nodeData.getKey() + " --> ";
            }
        }
        JOptionPane.showMessageDialog(new JFrame(), link, "Short Path", JOptionPane.DEFAULT_OPTION);

    }
}