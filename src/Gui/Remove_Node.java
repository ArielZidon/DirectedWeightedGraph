package Gui;

import api.DirectedWeightedGraph;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Remove_Node extends JFrame implements ActionListener {
    private JTextField Search_text;
    private JButton Press_Enter;
    private JLabel Node_id;

    private DirectedWeightedGraph MyGraph;
    private MyJpanel panel;

    public Remove_Node(DirectedWeightedGraph MyGraph, MyJpanel panel) {
        this.MyGraph = MyGraph;
        this.panel = panel;
        Node_id = new JLabel("Node id");
        Press_Enter = new JButton("Remove");
        Press_Enter.addActionListener(this);
        Search_text = new JTextField(2);

        JPanel jPanel = new JPanel();
        jPanel.add(Node_id);
        jPanel.add(Search_text);
        jPanel.add(Press_Enter);

        add(jPanel);
        pack();
        setResizable(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand();
        if (s.equals("Remove")) {
            action();
        }
    }
    private void action() {
        setVisible(false);
            if (MyGraph.removeNode(Integer.parseInt(Search_text.getText())) != null) {
                JOptionPane.showMessageDialog(new JFrame(), "Remove", "Remove Node", JOptionPane.DEFAULT_OPTION);
            }
            panel.repaint();
        this.dispose();
    }
}