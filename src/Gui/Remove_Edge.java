package Gui;

import api.DirectedWeightedGraph;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Remove_Edge extends JFrame implements ActionListener {
    private JLabel Sours_text, Destination_text;
    private JButton button_search;
    private JTextField Src, Dest;

    private MyJpanel panel;
    private DirectedWeightedGraph MyGraph;

    public Remove_Edge(DirectedWeightedGraph MyGraph, MyJpanel panel) {
        this.MyGraph = MyGraph;
        this.panel = panel;
        Sours_text = new JLabel("Sours");
        Destination_text = new JLabel("Destination");
        button_search = new JButton("Remove");
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
        if (s.equals("Remove")) {
            action();
        }
    }
    private void action() {
        setVisible(false);
        if (MyGraph.removeEdge(Integer.parseInt(Src.getText()), Integer.parseInt(Dest.getText())) != null) {
            JOptionPane.showMessageDialog(new JFrame(), "Remove", "Remove Edge", JOptionPane.DEFAULT_OPTION);
            panel.repaint();
        }
        this.dispose();
    }
}