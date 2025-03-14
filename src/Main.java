import Algorithms.BellmanFord;
import Algorithms.Digraph;
import java.util.List;

public class Main {
  // runs Bellman-Ford Algorithm, DAG-based Shortest Path Algorithm, and Ford-Fulkerson Algorithm
  public static void main(String[] args) {
      Digraph graph =
              new Digraph(
                      List.of(
                              new Digraph.NodeVertices("A", new String[] {"B"}, new double[] {2.5}),
                              new Digraph.NodeVertices("B", new String[] {"C"}, new double[] {1.0}),
                              new Digraph.NodeVertices("C", new String[] {}, new double[] {})),
                      true);
      BellmanFord bf = new BellmanFord(graph.getNodeMap());
      System.out.println(bf.bellmanFord());
  }
}
