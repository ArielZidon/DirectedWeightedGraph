package Gui;

import api.DirectedWeightedGraphAlgorithms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Save extends JFrame implements ActionListener {
    private JTextField save_text;
    private JButton save_bt;
    private JLabel name;

    private DirectedWeightedGraphAlgorithms MyGraph;

    public Save(DirectedWeightedGraphAlgorithms MyGraph) {
        this.MyGraph = MyGraph;
        name = new JLabel("Enter a new graph name");
        save_bt = new JButton("Save");
        save_bt.addActionListener(this);
        save_text = new JTextField(10);

        JPanel jPanel = new JPanel();
        jPanel.add(name);
        jPanel.add(save_text);
        jPanel.add(save_bt);

        add(jPanel);
        pack();
        setResizable(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Save")) {
            action();
        }
    }
    private void action() {
        setVisible(false);
            if (MyGraph.save(save_text.getText()))
                JOptionPane.showMessageDialog(new JFrame(), "Save Success", "Save", JOptionPane.DEFAULT_OPTION);
        this.dispose();
    }
}