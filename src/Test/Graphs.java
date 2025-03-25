package Test;

import Algorithms.Digraph;
import java.util.List;

public class Graphs {
  public static Digraph graphOne =
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
  public static Digraph graphTwo =
      new Digraph(
          List.of(
              new Digraph.NodeVertices("A", new String[] {"B", "C", "D"}, new double[] {2, 5, 1}),
              new Digraph.NodeVertices("B", new String[] {"E"}, new double[] {3}),
              new Digraph.NodeVertices("C", new String[] {"E", "F"}, new double[] {2, 4}),
              new Digraph.NodeVertices("D", new String[] {"F"}, new double[] {6}),
              new Digraph.NodeVertices("E", new String[] {"G"}, new double[] {1}),
              new Digraph.NodeVertices("F", new String[] {"G"}, new double[] {3}),
              new Digraph.NodeVertices("G", new String[] {}, new double[] {})),
          true);
  public static Digraph graphThree =
      new Digraph(
          List.of(
              new Digraph.NodeVertices("A", new String[] {"B", "C", "D"}, new double[] {2, 4, 1}),
              new Digraph.NodeVertices("B", new String[] {"E", "F"}, new double[] {3, 7}),
              new Digraph.NodeVertices("C", new String[] {"F", "G"}, new double[] {5, 2}),
              new Digraph.NodeVertices("D", new String[] {"H"}, new double[] {6}),
              new Digraph.NodeVertices("E", new String[] {"I"}, new double[] {3}),
              new Digraph.NodeVertices("F", new String[] {"H", "I"}, new double[] {4, 2}),
              new Digraph.NodeVertices("G", new String[] {"J"}, new double[] {3}),
              new Digraph.NodeVertices("H", new String[] {"J"}, new double[] {5}),
              new Digraph.NodeVertices("I", new String[] {"J"}, new double[] {1}),
              new Digraph.NodeVertices("J", new String[] {}, new double[] {})),
          true);
}
