import Algorithms.BellmanFord;
import Algorithms.DAG;
import Algorithms.Digraph;
import java.util.List;

public class Main {
  // runs Bellman-Ford Algorithm, DAG-based Shortest Path Algorithm, and Ford-Fulkerson Algorithm
  // graph of a minimum of 6 nodes and minimum of 7 edges
  public static void main(String[] args) {
    Digraph graph =
        new Digraph(
            List.of(
                new Digraph.NodeVertices("S", new String[] {"A", "B"}, new double[] {1, 2}),
                new Digraph.NodeVertices("A", new String[] {"C", "E"}, new double[] {1, 5}),
                new Digraph.NodeVertices("B", new String[] {"C", "D"}, new double[] {3, 7}),
                new Digraph.NodeVertices("C", new String[] {"F"}, new double[] {1}),
                new Digraph.NodeVertices("D", new String[] {"C", "F"}, new double[] {9, 8}),
                new Digraph.NodeVertices("E", new String[] {"C", "F"}, new double[] {-2, -2}),
                new Digraph.NodeVertices("F", new String[] {}, new double[] {})),
            true);
    BellmanFord bf = new BellmanFord(graph.getNodeMap());
    System.out.println(bf.bellmanFord());
    DAG dag = new DAG(graph.getNodeMap());
    System.out.println(dag.getDistances());
  }
}
