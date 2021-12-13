package Gui;

import api.DirectedWeightedGraphAlgorithms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MyJframe extends JFrame implements ActionListener, MouseMotionListener {
    public JMenuBar mb;
    public JFrame f;
    public JMenu x;
    public MyJpanel panel;
    public JMenuItem Load, Save, Add_Node,Add_Edge, Remove_Node, Get_Node, Get_Edge,
                    ShortPath, ShortPath_dis, IsConnected, TSP,Remove_Edge, Center;

    private boolean needToAddNode = false;
    private DirectedWeightedGraphAlgorithms MyGraph;

    public MyJframe(DirectedWeightedGraphAlgorithms  myGraph){
    super("Menu");
    
    this.MyGraph = myGraph;
    panel = new MyJpanel(myGraph.getGraph());
    
    this.add(panel);
    this.addMouseListener( this);
    this.pack();
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
        
    mb = new JMenuBar();
    x = new JMenu("Menu");

    // create menuitems
    Load = new JMenuItem("Load");
    Save = new JMenuItem("Save");
    Add_Node = new JMenuItem("Add_Node");
    Add_Edge = new JMenuItem("Add_Edge");
    Get_Edge = new JMenuItem("Get_Edge");
    Get_Node = new JMenuItem("Get_Node");
    Remove_Edge = new JMenuItem("Remove_Edge");
    Remove_Node = new JMenuItem("Remove_Node");
    ShortPath = new JMenuItem("ShortPath");
    ShortPath_dis = new JMenuItem("ShortPath_dis");
    IsConnected = new JMenuItem("IsConnected");
    TSP = new JMenuItem("TSP");
    Center = new JMenuItem("Center");

    // add menu items to menu
    x.add(Load);
    x.add(Save);
    x.add(Add_Edge);
    x.add(Add_Node);
    x.add(Get_Edge);
    x.add(Get_Node);
    x.add(Remove_Node);
    x.add(Remove_Edge);
    x.add(ShortPath);
    x.add(ShortPath_dis);
    x.add(IsConnected);
    x.add(Center);
    x.add(TSP);

    mb.add(x);
    setJMenuBar(mb);
    add(panel);

    Load.addActionListener(this);
    Save.addActionListener(this);
    Add_Node.addActionListener(this);
    Add_Edge.addActionListener(this);
    Remove_Edge.addActionListener(this);
    Remove_Node.addActionListener(this);
    Get_Node.addActionListener(this);
    Get_Edge.addActionListener(this);
    ShortPath_dis.addActionListener(this);
    ShortPath.addActionListener(this);
    Center.addActionListener(this);
    IsConnected.addActionListener(this);
    TSP.addActionListener(this);


    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setSize(screenSize.width, screenSize.height);
    setTitle("DirectedWeightedGraph.Ex2 Graph");

    getContentPane().setBackground(new Color(133, 167, 234));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
}
    private void addMouseListener(MyJframe myJframe) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Load){
            new Load_json(MyGraph, (MyJpanel) panel);

        }
        else if(e.getSource() == Save) {
            new Save(MyGraph);

        }
        else if(e.getSource() == Add_Edge){
            new Add_Edge(MyGraph.getGraph(), panel);
        }
        else if(e.getSource() == Add_Node){
           new Add_Node(MyGraph.getGraph(), panel);
        }
        else if(e.getSource() == Remove_Edge){
            new Remove_Edge(MyGraph.getGraph(), panel);
        }
        else if(e.getSource() == Remove_Node){
            new Remove_Node(MyGraph.getGraph(), panel);
        }
        else if(e.getSource() == TSP){
            new TSP(MyGraph);

        }
        else if(e.getSource() == ShortPath_dis){
            new ShortPath_dis((DirectedWeightedGraphAlgorithms)MyGraph);

        }
        else if(e.getSource() == ShortPath){
            new Short_Path((DirectedWeightedGraphAlgorithms) MyGraph);

        }
        else if(e.getSource() == Get_Edge){
            new GetEdge(MyGraph.getGraph());
        }
        else if(e.getSource() == Get_Node){
            new GetNode(MyGraph.getGraph());

        }
        else if(e.getSource() == Center){
            JOptionPane.showMessageDialog(new JFrame(), MyGraph.center().getKey(), "Center", JOptionPane.DEFAULT_OPTION);
        }
        else if(e.getSource() == IsConnected){
            boolean conn = MyGraph.isConnected();
            if(conn) {
                JOptionPane.showMessageDialog(new JFrame(), "The Graph is connected ? :"+true, "IsConnected", JOptionPane.DEFAULT_OPTION);
            }
            else {
                JOptionPane.showMessageDialog(new JFrame(), "The Graph is connected :"+false, "IsConnected", JOptionPane.DEFAULT_OPTION);
            }
        }
    }
    
    public void mouseClicked(MouseEvent e) {
  }

    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
