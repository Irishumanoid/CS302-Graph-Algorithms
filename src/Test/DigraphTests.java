package Test;

import static org.junit.jupiter.api.Assertions.*;

import Algorithms.Digraph;
import org.junit.jupiter.api.Test;

public class DigraphTests {
  private static final Digraph graphOne = Graphs.graphOne;
  private static final Digraph graphTwo = Graphs.graphTwo;
  private static final Digraph graphThree = Graphs.graphThree;

  @Test
  public void cycleTest() {
    assertFalse(graphOne.hasCycle());
    assertFalse(graphTwo.hasCycle());
    assertFalse(graphThree.hasCycle());
  }

  @Test
  public void nodeIndexFetchTest() {
    assertEquals(2, graphOne.getNodeIndex(0, "B"));
    assertEquals(6, graphOne.getNodeIndex(3, "F"));
    assertEquals(3, graphOne.getNodeIndex(4, "C"));
    assertEquals(-1, graphOne.getNodeIndex(6, "A"));

    assertEquals(4, graphTwo.getNodeIndex(1, "E"));
    assertEquals(4, graphTwo.getNodeIndex(2, "E"));
    assertEquals(6, graphTwo.getNodeIndex(4, "G"));
    assertEquals(6, graphTwo.getNodeIndex(5, "G"));

    assertEquals(8, graphThree.getNodeIndex(4, "I"));
    assertEquals(9, graphThree.getNodeIndex(6, "J"));
    assertEquals(9, graphThree.getNodeIndex(8, "J"));
    assertEquals(-1, graphThree.getNodeIndex(9, "J"));
  }
}
