package Gui;

import api.DirectedWeightedGraphAlgorithms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShortPath_dis extends JFrame implements ActionListener {
    private JTextField Src, Dest;
    private JButton button_search;
    private JLabel Sours_text, Destination_text;

    private DirectedWeightedGraphAlgorithms MyGraph;

    public ShortPath_dis(DirectedWeightedGraphAlgorithms MyGraph) {
        this.MyGraph = MyGraph;
        Sours_text = new JLabel("Sours:");
        Destination_text = new JLabel("Destination:");
        button_search = new JButton("OK");
        button_search.addActionListener(this);
        Src = new JTextField(2);
        Dest = new JTextField(2);

        JPanel jPanel = new JPanel();
        jPanel.add(Sours_text);
        jPanel.add(Src);
        jPanel.add(Destination_text);
        jPanel.add(Dest);
        jPanel.add(button_search);

        add(jPanel);
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
        setVisible(false);
        double s_p_d = MyGraph.shortestPathDist(Integer.parseInt(Src.getText()), Integer.parseInt(Dest.getText()));
        if (s_p_d != -1) {
            JOptionPane.showMessageDialog(new JFrame(), "" + s_p_d, "Short Path dis", JOptionPane.DEFAULT_OPTION);
        }
        this.dispose();
    }

}