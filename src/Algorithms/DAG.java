package Algorithms;

import java.util.*;

/** Shortest path algorithm that uses topological vertex ordering to determine vertex distance calculation order. */
public class DAG {
  private final Digraph graph;

  public DAG(List<Digraph.NodeVertices> nodeMap) {
    this.graph = new Digraph(nodeMap, true);
  }

  protected int numIncomingEdges(String vertexId) {
    int numIncoming = 0;
    for (Digraph.NodeVertices v : graph.getNodeMap()) {
      for (String nodeId : v.nodeIds()) {
        if (nodeId.equals(vertexId)) {
          numIncoming++;
        }
      }
    }
    return numIncoming;
  }

  /** Get topological ordering for graph vertices. */
  private List<Digraph.NodeVertices> topologicalSort() {
    List<Digraph.NodeVertices> vertices = graph.getNodeMap();
    Queue<Digraph.NodeVertices> queue = new ArrayDeque<>();
    Map<String, Integer> inCounter = new HashMap<>();

    for (Digraph.NodeVertices v : vertices) {
      String vertex = v.start();
      inCounter.put(vertex, numIncomingEdges(vertex));
      if (inCounter.get(vertex) == 0) {
        queue.offer(v);
      }
    }

    List<Digraph.NodeVertices> sorted = new ArrayList<>();
    while (!queue.isEmpty()) {
      Digraph.NodeVertices v = queue.poll();
      sorted.add(v);
      for (String outgoing : v.nodeIds()) {
        // decrement counter for outgoing vertices and push to stack if 0 for any of them
        inCounter.put(outgoing, inCounter.get(outgoing) - 1);
        if (inCounter.get(outgoing) == 0) {
          // add node to queue if all of its incoming vertices have been processed
          for (Digraph.NodeVertices e : vertices) {
            if (e.start().equals(outgoing)) {
              queue.offer(e);
              break;
            }
          }
        }
      }
    }
    if (sorted.size() != vertices.size()) {
      throw new RuntimeException("Graph contains cycle.");
    }
    return sorted;
  }

  private int getOriginalVertexIndex(String vertexId) {
    for (int i = 0; i < graph.getNodeMap().size(); i++) {
      if (graph.getNodeMap().get(i).start().equals(vertexId)) {
        return i;
      }
    }
    return -1;
  }

  /** Updates vertex distances in topological order. */
  public List<Double> getDistances() {
    List<Digraph.NodeVertices> vertices = topologicalSort();
    List<Double> distances =
        new ArrayList<>(vertices.stream().map(n -> Double.POSITIVE_INFINITY).toList());
    if (!distances.isEmpty()) {
      distances.set(0, 0.0);
    }
    for (Digraph.NodeVertices v : vertices) {
      int startId = getOriginalVertexIndex(v.start());
      for (int i = 0; i < v.nodeIds().length; i++) {
        double weightBetween = v.weights()[i];
        int endId = getOriginalVertexIndex(v.nodeIds()[i]);
        if (distances.get(startId) + weightBetween < distances.get(endId)) {
          System.out.println("DAG found shorter path to vertex " + endId + " from vertex " + startId);
          distances.set(endId, distances.get(startId) + weightBetween);
        }
      }
    }

    return distances;
  }
}
