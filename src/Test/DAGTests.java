package Test;

import Algorithms.DAG;
import Algorithms.Digraph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DAGTests {
  private static final Digraph graphOne = Graphs.graphOne;
  private static final Digraph graphTwo = Graphs.graphTwo;
  private static final Digraph graphThree = Graphs.graphThree;
  private DAG dagOne;
  private DAG dagTwo;
  private DAG dagThree;

  @BeforeEach
  void setUp() {
    dagOne = new DAG(graphOne.getNodeMap());
    dagTwo = new DAG(graphTwo.getNodeMap());
    dagThree = new DAG(graphThree.getNodeMap());
  }

  @Test
  public void getDistancesTest() {
    assertArrayEquals(
        List.of(0.0, 1.0, 2.0, 2.0, 9.0, 6.0, 3.0).toArray(), dagOne.getDistances().toArray());
    assertArrayEquals(
        List.of(0.0, 2.0, 5.0, 1.0, 5.0, 7.0, 6.0).toArray(), dagTwo.getDistances().toArray());
    assertArrayEquals(
        List.of(0.0, 2.0, 4.0, 1.0, 5.0, 9.0, 6.0, 7.0, 8.0, 9.0).toArray(),
        dagThree.getDistances().toArray());
  }
}
