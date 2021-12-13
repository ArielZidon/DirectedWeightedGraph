package Gui;

import api.DirectedWeightedGraph;
import api.EdgeData;
import api.NodeData;
import DirectedWeightedGraph.*;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

public class MyJpanel extends JPanel {
    private double MIN_X; //the smallest node(x);
    private double MIN_Y; //the smallest node(y)
    private double MAX_X; //the biggest node(x)
    private double MAX_Y; //the biggest node(y)

    private double CALC_X;
    private double CALC_Y;

    private DirectedWeightedGraph MyGraph;

    //constructor
    public MyJpanel(DirectedWeightedGraph graph) {
        this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setBackground(new Color(0x8BAEC7));
        this.setFocusable(true);
        init(graph);
    }
    public void init(DirectedWeightedGraph graph) {
        this.MyGraph = graph;
        Pixel();
    }
    public void Pixel() {
        Iterator<NodeData> pix = MyGraph.nodeIter();
        NodeData node_pix = pix.next();
        MIN_X = node_pix.getLocation().x();
        MIN_Y = node_pix.getLocation().y();
        MAX_X = node_pix.getLocation().x();
        MAX_Y = node_pix.getLocation().y();

        while (pix.hasNext()) {
            node_pix = pix.next();
            MIN_X = Min_Locarion(MIN_X, node_pix.getLocation().x());
            MAX_X = Max_Locarion(MAX_X, node_pix.getLocation().x());
            MIN_Y = Min_Locarion(MIN_Y, node_pix.getLocation().y());
            MAX_Y = Max_Locarion(MAX_Y, node_pix.getLocation().y());
        }
    }
    public double Min_Locarion(double x, double y) {
        if(x < y){
            return x;
        } else{
            return y;
        }
    }
    public double Max_Locarion(double x, double y) {
        if(x > y){
            return x;
        } else{
            return y;
        }
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        CALC_X = this.getWidth() / Math.abs(MAX_X - MIN_X) * 0.975;
        CALC_Y = this.getHeight() / Math.abs(MAX_Y - MIN_Y) * 0.9;

        Draw_iterator_edge(g);
        Draw_iterator_node(g);
    }

    public void Draw_iterator_node(Graphics graphics) {
        Iterator<NodeData> my_node = MyGraph.nodeIter();
        while (my_node.hasNext()) {
            NodeData temp_node = my_node.next();
            double x = (temp_node.getLocation().x()-MIN_X) * CALC_X;
            double y = (temp_node.getLocation().y()-MIN_Y) * CALC_Y;

            graphics.setColor(Color.black);
            graphics.fillRoundRect((int)x+2, (int) y-8, 30, 35,25,25);
            if(temp_node.getKey() < 9) {
                graphics.setColor(Color.white);
                graphics.setFont(new Font("David",Font.ITALIC, 18));
                graphics.drawString("" + temp_node.getKey(), (int) x + 12, (int) y + 12);
            }
            else{
                graphics.setColor(Color.white);
                graphics.setFont(new Font("David", Font.ITALIC, 16));
                graphics.drawString("" + temp_node.getKey(), (int) x + 8, (int) y + 10);
            }
        }
    }
    public int Calc_edge_des_y(double d_y){
        return (int)((d_y-MIN_Y) * CALC_Y);
    }
    public int Calc_edge_des_x(double d_x){
        return (int)((d_x-MIN_X) * CALC_X);
    }
    public int Calc_edge_src_x(double s_x){
        return (int)((s_x-MIN_X)*CALC_X);
    }
    public int Calc_edge_src_y(double s_y){
        return (int)((s_y-MIN_Y) * CALC_Y);
    }

    public void Draw_iterator_edge(Graphics graphics) {
        Iterator<EdgeData> my_edge = MyGraph.edgeIter();
        while (my_edge.hasNext()) {
            EdgeData edge = my_edge.next();

            int edge_des_x = Calc_edge_des_x(MyGraph.getNode(edge.getDest()).getLocation().x());
            int edge_des_y = Calc_edge_des_y(MyGraph.getNode(edge.getDest()).getLocation().y());
            int edge_src_x = Calc_edge_src_x(MyGraph.getNode(edge.getSrc()).getLocation().x());
            int edge_src_y = Calc_edge_src_y(MyGraph.getNode(edge.getSrc()).getLocation().y());

            graphics.setColor(Color.white);
            graphics.setFont(new Font("David", Font.BOLD, 16));
            drawArrowLine(graphics, edge_src_x+14, edge_src_y+10, edge_des_x+10, edge_des_y+14, 22, 8);
        }

    }
    public void Add_node(int key, int x, int y) {
        y -= 50;
        x-=5;
        double newX = (x-12)/CALC_X + MIN_X;
        double newY = (y-12)/CALC_Y + MIN_Y;
        MyGraph.addNode(new myNodeData(key,newX+","+newY+",0"));
        repaint();
    }
    /**
     *

     /**   //https://stackoverflow.com/questions/2027613/how-to-draw-a-directed-arrow-line-in-java

     * Draw an arrow line between two points.
     *
     * @param g  the graphics component.
     * @param x1 x-position of first point.
     * @param y1 y-position of first point.
     * @param x2 x-position of second point.
     * @param y2 y-position of second point.
     * @param d  the width of the arrow.
     * @param h  the height of the arrow.
     */
    private void drawArrowLine(Graphics g, int x1, int y1, int x2, int y2, int d, int h) {
        int dx = x2 - x1, dy = y2 - y1;
        double D = Math.sqrt(dx * dx + dy * dy);
        double xm = D - d, xn = xm, ym = h, yn = -h, x;
        double sin = dy / D, cos = dx / D;

        x = xm * cos - ym * sin + x1;
        ym = xm * sin + ym * cos + y1;
        xm = x;

        x = xn * cos - yn * sin + x1;
        yn = xn * sin + yn * cos + y1;
        xn = x;

        int[] xpoints = {x2, (int) xm, (int) xn};
        int[] ypoints = {y2, (int) ym, (int) yn};

        g.drawLine(x1, y1, x2, y2);
        g.fillPolygon(xpoints, ypoints, 3);
    }
}