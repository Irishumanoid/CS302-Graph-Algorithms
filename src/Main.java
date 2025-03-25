import Algorithms.BellmanFord;
import Algorithms.DAG;
import Algorithms.Digraph;
import Test.Graphs;

import java.util.List;

public class Main {
  /** runs Bellman-Ford Algorithm and DAG-based Shortest Path Algorithm */
  public static void main(String[] args) {
    Digraph graphOne = Graphs.graphOne;
    Digraph graphTwo = Graphs.graphTwo;
    Digraph graphThree = Graphs.graphThree;
    runAlgorithms(graphOne);
    runAlgorithms(graphTwo);
    runAlgorithms(graphThree);
  }

  private static void runAlgorithms(Digraph graph) {
    BellmanFord bf = new BellmanFord(graph.getNodeMap());

    System.out.println("BF output: ");
    List<Digraph.NodeVertices> bfVertices = graph.getNodeMap();
    List<Double> bfOutput = bf.bellmanFord();
    for (int i = 0; i < bfVertices.size(); i++) {
      System.out.println("distance to " + bfVertices.get(i).start() + " is " + bfOutput.get(i));
    }

    DAG dag = new DAG(graph.getNodeMap());
    System.out.println("DAG output: ");
    List<Digraph.NodeVertices> dagVertices = graph.getNodeMap();
    List<Double> dagOutput = dag.getDistances();
    for (int i = 0; i < dagVertices.size(); i++) {
      System.out.println("distance to " + dagVertices.get(i).start() + " is " + dagOutput.get(i));
    }
  }
}
