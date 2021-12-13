package DirectedWeightedGraph;

import Gui.MyJframe;
import api.DirectedWeightedGraph;
import api.DirectedWeightedGraphAlgorithms;
import api.NodeData;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class is the main class for DirectedWeightedGraph.Ex2 - your implementation will be tested using this class.
 */
public class Ex2 {

    /**
     * This static function will be used to test your implementation
     * @param json_file - a json file (e.g., G1.json - G3.gson)
     * @return
     */
    public static DirectedWeightedGraph getGrapg(String json_file) {
        DirectedWeightedGraph graph;
        try {
            graph = readGRaphFromJson(json_file);
        } catch (Exception e) {
            e.printStackTrace();
            graph = new myDirectedWeightedGraph();
        }
        return graph;
        }
    /**
     * This static function will be used to test your implementation
     * @param json_file - a json file (e.g., G1.json - G3.gson)
     * @return
     */
    public static DirectedWeightedGraphAlgorithms getGrapgAlgo(String json_file) {
        DirectedWeightedGraph graph = getGrapg(json_file);
        DirectedWeightedGraphAlgorithms graphAlgo = new myDirectedWeightedGraphAlgorithms();
        graphAlgo.init(graph);
        return graphAlgo;
    }
    /**
     * This static function will run your GUI using the json fime.
     * @param json_file - a json file (e.g., G1.json - G3.gson)
     *
     */
    public static void runGUI(String json_file) {
        DirectedWeightedGraphAlgorithms myJframe = getGrapgAlgo(json_file);
        new MyJframe(myJframe);

        // ********************************
    }

    public static myDirectedWeightedGraph readGRaphFromJson(String json_file)
            throws IOException, org.json.simple.parser.ParseException {

        myDirectedWeightedGraph pick = new myDirectedWeightedGraph();
        JSONParser take = new JSONParser();

        var obj = take.parse(new FileReader(json_file));
        var jobj = (JSONObject) obj;
        var edges = (JSONArray) jobj.get("Edges");
        var nodes = (JSONArray) jobj.get("Nodes");
        for (int i = 0, nodesSize = nodes.size(); i < nodesSize; i++) {
            Object o = nodes.get(i);
            var id = (JSONObject) o;
            NodeData n = new myNodeData(Integer.parseInt(id.get("id").toString()), id.get("pos").toString());
            pick.addNode(n);
        }
        for (int i = 0, edgesSize = edges.size(); i < edgesSize; i++) {
            var o = edges.get(i);
            var temp = (JSONObject) o;
            if ((temp.get("src") == null) || temp.get("dest") == null || temp.get("w") == null) {
                continue;
            }
            int src = Integer.parseInt(temp.get("src").toString());
            int dest = Integer.parseInt(temp.get("dest").toString());
            double w = Double.parseDouble(temp.get("w").toString());
            pick.connect(src, dest, w);
        }
        return pick;
    }
    public static void main(String[] args) {
        DirectedWeightedGraphAlgorithms a =getGrapgAlgo("data/G1.json");
        System.out.println(a.getGraph());
        System.out.println(a.isConnected());
        a.getGraph().removeNode(2);
        System.out.println(a.isConnected());
        JPanel panel = new Gui.MyJpanel(getGrapgAlgo("data/G1.json").getGraph());
        new Gui.MyJframe(a).add(panel);
    }
    }

