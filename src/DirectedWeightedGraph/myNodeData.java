package DirectedWeightedGraph;

import api.EdgeData;
import api.GeoLocation;
import api.NodeData;

import java.util.HashMap;
import java.util.Map;

public class myNodeData implements NodeData{
    public int key;
    public myGeoLocation n;
    public int t;

    public Map<Integer, EdgeData> EdgesIn; // key = node it's going to
    public Map<Integer,EdgeData> EdgesOut; // key = node it's came from

    public myNodeData(int key, String n) {
        this.key = key;
        this.n =  new myGeoLocation(n);
        EdgesIn = new HashMap<>();
        EdgesOut = new HashMap<>();
        t = 0;
    }

    public myNodeData(NodeData n) {
        this.key = n.getKey();
        this.n =new myGeoLocation(n.getLocation());
        this.t=n.getTag();
    }


    @Override
    public int getKey() {
        return this.key;
    }

    @Override
    public GeoLocation getLocation() {
        return this.n;
    }

    @Override
    public void setLocation(GeoLocation p) {
        this.n= new myGeoLocation(p);
    }

    @Override
    public double getWeight() { // not use
        return 0;
    } //not use

    @Override
    public void setWeight(double w) { //not use
    }

    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public void setInfo(String s) {

    }

    @Override
    public int getTag() {
        return t;
    }

    @Override
    public void setTag(int t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "DirectedWeightedGraph.myNodeData{" +
                "key=" + key +
                ", n=" + n +
                '}';
    }

}
