package Gui;

import api.DirectedWeightedGraphAlgorithms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Load_json extends JFrame implements ActionListener {
    private JTextField load_text;
    private JButton load_bt;
    private JLabel name;

    private MyJpanel panel;
    private DirectedWeightedGraphAlgorithms MyGraph;

    public Load_json(DirectedWeightedGraphAlgorithms MyGraph, MyJpanel panel) {
        this.MyGraph = MyGraph;
        this.panel = panel;
        name = new JLabel("Enter a graph name");
        load_bt = new JButton("Load");
        load_bt.addActionListener(this);
        load_text = new JTextField(10);

        JPanel p = new JPanel();
        p.add(name);
        p.add(load_text);
        p.add(load_bt);

        add(p);
        pack();
        setResizable(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Load")) {
            action();
        }
    }
    private void action() {
        setVisible(false);
            if (MyGraph.load(load_text.getText())) {
                JOptionPane.showMessageDialog(new JFrame(), " Load Success", "Load", JOptionPane.DEFAULT_OPTION);
            }
            panel.init(MyGraph.getGraph());
            panel.repaint();
        this.dispose();
    }
}