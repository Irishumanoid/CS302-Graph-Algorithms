package Test;

import static org.junit.jupiter.api.Assertions.*;

import Algorithms.BellmanFord;
import Algorithms.Digraph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class BellmanFordTests {
  private static final Digraph graphOne = Graphs.graphOne;
  private static final Digraph graphTwo = Graphs.graphTwo;
  private static final Digraph graphThree = Graphs.graphThree;
  private BellmanFord bfOne;
  private BellmanFord bfTwo;
  private BellmanFord bfThree;

  @BeforeEach
  void setUp() {
    bfOne = new BellmanFord(graphOne.getNodeMap());
    bfTwo = new BellmanFord(graphTwo.getNodeMap());
    bfThree = new BellmanFord(graphThree.getNodeMap());
  }

  @Test
  public void bellmanFordTest() {
    assertArrayEquals(
        List.of(0.0, 1.0, 2.0, 2.0, 9.0, 6.0, 3.0).toArray(), bfOne.bellmanFord().toArray());
    assertArrayEquals(
        List.of(0.0, 2.0, 5.0, 1.0, 5.0, 7.0, 6.0).toArray(), bfTwo.bellmanFord().toArray());
    assertArrayEquals(
        List.of(0.0, 2.0, 4.0, 1.0, 5.0, 9.0, 6.0, 7.0, 8.0, 9.0).toArray(),
        bfThree.bellmanFord().toArray());
  }
}
