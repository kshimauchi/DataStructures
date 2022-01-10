package Programming.Graphs;

import Programming.Linkedlists.SinglyLinklist;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GraphTraversalTest {
    Graph g1;

    @Before
    public void init(){
        g1 = new Graph();
//        g1.addVertex("Bob");
//        g1.addVertex("Alice");
//        g1.addVertex("Rob");
//
//        g1.addEdge("Bob", "Alice");
//        g1.addEdge("Alice", "Rob");
//        g1.Map();
//        g1.makeGraph();
    }

    @Test
    public void traverseUsingBFS(){
        Assert.assertEquals("[Bob, Alice, Rob, Mark, Maria]", g1.breadthFirstTraversal(g1, "Alice").toString());
    }

}
