import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Main {

  public static void main(String[] args) {
    List<Node> data = new ArrayList<>();
    data.add(new Node("USD", "JPY", 110));
    data.add(new Node("USD", "AUD", 1.45));
    data.add(new Node("JPY", "GBP", 0.0070));
    System.out.println(getRatio("GBP", "AUD", data));
  }

  //approach: create graph relationship and BFS to make calculation
  public static double getRatio(String from, String to, List<Node> currencies) {

    //Create graph based on currencies
    var adjacencyList = getGraph(currencies);

    Queue<String> currenciesToVisit = new LinkedList<>();
    Queue<Double> valuesToMultiply = new LinkedList<>();
    currenciesToVisit.offer(from);
    valuesToMultiply.offer(1.0);

    return bfs(currenciesToVisit, valuesToMultiply, adjacencyList, to);

  }

  public static double bfs(Queue<String> currenciesToVisit, Queue<Double> valuesToMultiply,
      Map<String, Map<String, Double>> adjacencyList, String toCurrencyName) {
    Set<String> visited = new HashSet<>();
    while (!currenciesToVisit.isEmpty()) {
      String currentCurrency = currenciesToVisit.poll();
      double valueToMultiply = valuesToMultiply.poll();
      if (visited.contains(currentCurrency)) {
        continue;
      }
      visited.add(currentCurrency);
      if (adjacencyList.containsKey(currentCurrency)) {
        Map<String, Double> nextCurrency = adjacencyList.get(currentCurrency);
        for (var pair : nextCurrency.entrySet()) {
          var currencyName = pair.getKey();
          if (!visited.contains(currencyName)) {
            currenciesToVisit.offer(currencyName);
            if (currencyName.equals(toCurrencyName)) {
              return valueToMultiply * nextCurrency.get(currencyName);
            }
            valuesToMultiply.offer(valueToMultiply * nextCurrency.get(currencyName));
          }
        }
      }
    }
    return -1;
  }

  public static Map<String, Map<String, Double>> getGraph(List<Node> currencies) {
    Map<String, Map<String, Double>> adjacencyMap = new HashMap<>();
    for (Node currency : currencies) {
      if (!adjacencyMap.containsKey(currency.from)) {
        adjacencyMap.put(currency.from, new HashMap<>());
      }
      adjacencyMap.get(currency.from).put(currency.to, currency.rate);
      if (!adjacencyMap.containsKey(currency.to)) {
        adjacencyMap.put(currency.to, new HashMap<>());
      }
      adjacencyMap.get(currency.to).put(currency.from, 1.0 / currency.rate);
    }
    return adjacencyMap;
  }
  public static class Node {

    String from;
    String to;
    double rate;

    public Node(String from, String to, double rate) {
      this.from = from;
      this.to = to;
      this.rate = rate;
    }
  }
}