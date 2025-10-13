package queues;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {

  private final int size;
  private final Queue<Integer> window = new LinkedList<>();

  public MovingAverage(int size) {
    this.size = size;
  }

  public double next(int val) {
    while (!window.isEmpty() && window.size() >= size) {
      window.poll();
    }
    window.offer(val);

    return (double) window.stream().reduce(0, Integer::sum) / window.size();
  }
}
