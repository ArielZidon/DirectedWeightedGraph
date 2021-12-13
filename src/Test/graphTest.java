import api.DirectedWeightedGraph;
import api.GeoLocation;
import api.NodeData;
import org.testng.annotations.Test;
import DirectedWeightedGraph.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNull;


public class graphTest {
    DirectedWeightedGraph G1;
    myDirectedWeightedGraphAlgorithms alg;

    graphTest() {
        G1 = Ex2.getGrapg("data/G1.json"); // example for G1.json file

        alg = new myDirectedWeightedGraphAlgorithms();

        alg.init(G1); }

    public static void main(String[] args) {
        graphTest test = new graphTest();
        List<NodeData> checkTps = new ArrayList<NodeData>();

        for (int j = 0; j < 16; j++) {
            checkTps.add(test.G1.getNode(j));
        }

        List<NodeData> nodeData = test.alg.tsp(checkTps);

        for (NodeData n : nodeData) {
            System.out.print(n.getKey() + ",");
        }
    }

    @Test
    void testGetNode() {
        graphTest test1 = new graphTest();
        GeoLocation location = new myGeoLocation("35.19589389346247,32.10152879327731,0.0");
        assertEquals(location.toString(), test1.G1.getNode(0).getLocation().toString());
    }
    @Test
    void testGetEdge() {
        graphTest test = new graphTest();
        assertEquals(1.8015954015822042,test.G1.getEdge(1,2).getWeight());

    }

    @Test
    void testCenter() {
        graphTest test1 = new graphTest();
        assertEquals(8, test1.alg.center().getKey());
    }
    @Test
    void testShortestPathDis() {
        graphTest test = new graphTest();
        assertEquals(1.7938753352369698, test.alg.shortestPathDist(2,6));

    }
    @Test
    void testEdgeSize() {
        graphTest test = new graphTest();
        assertEquals(36, test.G1.edgeSize());
    }


    @Test
    void testNodeSize() {
        graphTest test = new graphTest();
        assertEquals(17, test.G1.nodeSize());
    }

    @Test
    void testRemoveEdge() {
        graphTest test = new graphTest();
        test.G1.removeEdge(0,1);
        assertEquals(null, test.G1.getEdge(0,1));

    }

    @Test
    void testRemoveNode() {
        graphTest test = new graphTest();
        test.G1.removeNode(1);
        assertEquals(16, test.G1.nodeSize());

    }

    @Test
    void testNodeIterator() {
        graphTest test = new graphTest();
        Iterator<NodeData> iter = test.G1.nodeIter();
        int S = iter.next().getKey();
        iter.remove();
        assertNull(test.G1.getNode(S));
        test.G1.addNode(new myNodeData(55,"0,0,0"));
    }

    @Test
    void testConnect() {
        graphTest test = new graphTest();
        assertEquals(true, test.alg.isConnected());
        graphTest secTest = new graphTest();
        for (int j = 1; j <= secTest.G1.nodeSize(); j++) {
            secTest.G1.removeEdge(0, j);
            secTest.G1.removeEdge(j, 0);
        }
        assertEquals(false, secTest.alg.isConnected());

    }

    @Test
    void testGetMC() {
        graphTest test1 = new graphTest();
        test1.G1.removeEdge(0,3);
        test1.G1.removeEdge(3,0);
        test1.G1.removeEdge(1,9);
        assertEquals(56, test1.G1.getMC());

    }

//    @Test
//    void testEdgeIterator() {
//        graphTest test = new graphTest();
//        Iterator<EdgeData> iter = test.myGraph.edgeIter();
//        iter.remove();
//        assertEquals(null, test.myGraph.getEdge(0,1));
//
//    }

//    @Test
//    void testShortestPath() {
//        graphTest test1 = new graphTest();
//        ArrayList<DirectedWeightedGraph.myNodeData> ans = new ArrayList<>();
//        ans.add( new DirectedWeightedGraph.myNodeData(2,"35.20752617756255,32.1025646605042,0.0"));
//        ans.add(new DirectedWeightedGraph.myNodeData(6,"35.20797194027441,32.104854472268904,0.0"));
//        assertEquals(ans,test1.meAlgo.shortestPath(2,6));
//
//    }

}
