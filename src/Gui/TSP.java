package Gui;

import api.DirectedWeightedGraphAlgorithms;
import api.NodeData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TSP extends JFrame implements ActionListener {
    private JButton TSP;
    private JLabel Search;

    private DirectedWeightedGraphAlgorithms MyGraph;

    public TSP(DirectedWeightedGraphAlgorithms MyGraph) {
        this.MyGraph = MyGraph;
        Search = new JLabel("Press Enter to TSP search");
        TSP = new JButton("TSP");
        TSP.addActionListener(this);

        JPanel p = new JPanel();
        p.add(Search);
        p.add(TSP);
        add(p);
        pack();
        setResizable(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if(s.equals("TSP")) {
            action();
        }
    }
    private void action() {
        List<NodeData> My_Node = new ArrayList();
        Iterator<NodeData> iterator_node = MyGraph.getGraph().nodeIter();
        while (iterator_node.hasNext()) {
            My_Node.add(iterator_node.next());
        }
        setVisible(false);
        List<NodeData> My_Node_tsp = MyGraph.tsp(My_Node);
        String Link = "*";
        for (NodeData nodeData : My_Node_tsp) {
            Link = Link + nodeData.getKey() + " --> ";
        }
        JOptionPane.showMessageDialog(new JFrame(), Link, "TSP", JOptionPane.DEFAULT_OPTION);
        this.dispose();
    }
}