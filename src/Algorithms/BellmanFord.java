package Algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Returns the length of the shortest path from the start vertex to every other vertex through
 * successively growing vertex cloud.
 */
public class BellmanFord {
  private final Digraph graph;
  private boolean stopEarly;

  /** Construct digraph. */
  public BellmanFord(List<Digraph.NodeVertices> nodeMap) {
    this.graph = new Digraph(nodeMap, true);
    this.stopEarly = false;
  }

  /** relax directed edges by adding nodes to vertex cloud and looking at all outgoing edges. */
  private void checkAllNodes(
      List<Double> shortest, List<Digraph.NodeVertices> nodeMap, boolean firstCheck) {
    int numOutgoingVisited = 0;
    while (numOutgoingVisited < shortest.size()) {
      for (int j = 0; j < nodeMap.get(numOutgoingVisited).nodeIds().length; j++) {
        // perform edge relaxation
        double edgeWeight = nodeMap.get(numOutgoingVisited).weights()[j];
        int targetIndex =
            graph.getNodeIndex(numOutgoingVisited, nodeMap.get(numOutgoingVisited).nodeIds()[j]);
        if (shortest.get(numOutgoingVisited) + edgeWeight <= shortest.get(targetIndex)) {
          if (firstCheck) {
            System.out.println("First check update");
            shortest.set(targetIndex, shortest.get(numOutgoingVisited) + edgeWeight);
            stopEarly = true;
          } else {
            System.out.println("negative cycle exists in graph");
            return;
          }
        }
      }
      numOutgoingVisited++;
    }
  }

  public List<Double> bellmanFord() {
    List<Digraph.NodeVertices> nodeMap = graph.getNodeMap();
    String startId = nodeMap.getFirst().start();
    List<Double> shortest =
        new ArrayList<>(
            nodeMap.stream()
                .map(n -> n.start().equals(startId) ? 0.0 : Double.POSITIVE_INFINITY)
                .toList()); // make mutable by instantiating as arraylist

    for (int i = 1; i < shortest.size() - 1; i++) {
      checkAllNodes(shortest, nodeMap, true);
      // breaking out of loop early if already optimized
      if (stopEarly) {
        break;
      }
    }
    checkAllNodes(shortest, nodeMap, false);
    stopEarly = false;
    return shortest;
  }
}
