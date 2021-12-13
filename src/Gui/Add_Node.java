package Gui;

import api.DirectedWeightedGraph;
import DirectedWeightedGraph.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Add_Node extends JFrame implements ActionListener {
    private JTextField in_id;
    private JTextField in_x;
    private JTextField in_y;
    private JButton button;
    private JLabel textKey, text_x, text_y;

    private MyJpanel panel;
    private DirectedWeightedGraph MyGraph;


    public Add_Node(DirectedWeightedGraph MyGraph, MyJpanel panel) {
        this.panel = panel;
        this.MyGraph = MyGraph;
        textKey = new JLabel("Key:");
        text_x = new JLabel("x");
        text_y = new JLabel("y");
        button = new JButton("Enter");
        button.addActionListener(this);
        in_id = new JTextField(8);
        in_x = new JTextField(8);
        in_y = new JTextField(8);


        JPanel jPanel = new JPanel();
        jPanel.add(textKey);
        jPanel.add(in_id);
        jPanel.add(text_x);
        jPanel.add(in_x);
        jPanel.add(text_y);
        jPanel.add(in_y);
        jPanel.add(button);

        add(jPanel);
        pack();
        setResizable(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Enter")) {
            action();
        }
    }
    private void action() {
        setVisible(false);
     //   myNodeData node = new myNodeData( 88, "35.201540221146180002,32.105944858823430004,0.0");
        String str = in_x.getText();
        str = str +","+in_y.getText();
        str = str + ",0.0";
        int id = Integer.parseInt(in_id.getText());
        myNodeData node = new myNodeData( id, str);
        MyGraph.addNode(node);
        panel.repaint();
        this.dispose();
    }
}