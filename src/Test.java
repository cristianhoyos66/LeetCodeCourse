import java.util.Arrays;

public class Test {

  public static void main(String[] args) {

    /*int[] denominations = new int[10];
    for (int i = 0; i < 10; i++) {
      denominations[i] = i;
    }*/

    int[] denominations = {1, 1, 4};

    System.out.println(findSmallest(denominations));
  }

  static int findSmallest(int[] denominations) {
    int smallestUnreachable = 1;

    //(nlogn)
    Arrays.sort(denominations);
    //(n)
    for (int denomination : denominations) {
      if (denomination > smallestUnreachable) {
        return smallestUnreachable;
      }
      smallestUnreachable += denomination;
    }
    return smallestUnreachable;
  }

}
