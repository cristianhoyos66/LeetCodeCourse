package queues;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfRecentCalls {

  private final Queue<Integer> queue;

  public NumberOfRecentCalls(int t) {
    queue = new LinkedList<>();
  }

  public int ping(int t) {
    while (!queue.isEmpty() && queue.peek() < t - 3000) {
      queue.poll();
    }

    queue.offer(t);
    return queue.size();
  }
}
