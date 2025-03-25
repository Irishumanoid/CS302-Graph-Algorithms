package Algorithms;

import java.util.ArrayList;
import java.util.List;

/** A data structure containing the directed connections between nodes. */
public class Digraph {
  /**
   * Contains all the end vertices for the given start vertex and the weights of those connections.
   */
  public record NodeVertices(String start, String[] nodeIds, double[] weights) {}

  private final List<NodeVertices> nodeMap;

  public Digraph(List<NodeVertices> nodeMap, boolean mustBeAcyclic) {
    this.nodeMap = nodeMap;
    for (NodeVertices v : nodeMap) {
      if (v.nodeIds.length != v.weights.length) {
        throw new IllegalArgumentException(
            "There must be the same number of connections and connection weights.");
      }
    }
    if (mustBeAcyclic && this.hasCycle()) {
      throw new RuntimeException("Cycle found for acyclic graph");
    }
  }

  /** See if current node and connections have already been visited. */
  private boolean checkStartForCycle(int curIndex, boolean[] visited, boolean[] stack) {
    if (stack[curIndex]) {
      return true; // node is already in recursion stack
    }
    visited[curIndex] = true;
    stack[curIndex] = true;
    // get all connections for curIndex in nodeMap
    String[] cons = nodeMap.get(curIndex).nodeIds();
    for (String con : cons) {
      int conIdx = -1;
      for (int i = 0; i < nodeMap.size(); i++) {
        if (nodeMap.get(i).start.equals(con)) {
          conIdx = i;
        }
      }
      if (conIdx == -1) {
        continue;
      }
      if (checkStartForCycle(conIdx, visited, stack)) {
        return true;
      }
    }

    stack[curIndex] = false;
    return false;
  }

  /** Uses DFS traversal to check if back edges exist. */
  public boolean hasCycle() {
    int numVertices = nodeMap.size();
    boolean[] visited = new boolean[numVertices];
    boolean[] stack = new boolean[numVertices];
    for (int i = 0; i < numVertices; i++) {
      if (!visited[i] && checkStartForCycle(i, visited, stack)) {
        System.out.println("Cycle found at vertex " + i);
        return true;
      }
    }
    return false;
  }

  /** Get index of one of parent's connections in initial map. */
  public int getNodeIndex(int parent, String nodeId) {
    NodeVertices node = nodeMap.get(parent);
    String id = "";
    for (int i = 0; i < node.nodeIds().length; i++) {
      if (nodeId.equals(node.nodeIds()[i])) {
        id = node.nodeIds()[i];
        for (int j = 0; j < nodeMap.size(); j++) {
          if (id.equals(nodeMap.get(j).start())) {
            return j;
          }
        }
      }
    }
    return -1;
  }

  public List<NodeVertices> getNodeMap() {
    return nodeMap;
  }
}
