import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

     PriorityQueue<Integer> presents = new PriorityQueue<>(Collections.reverseOrder());
    
    for (int i = 0; i < n; i++) {
      int a = sc.nextInt();

      if (a == 0) {
        if (presents.isEmpty())
          System.out.println("-1");
        else {
          System.out.println(presents.poll());
        }
      } else {
        for (int j = 0; j < a; j++) {
          int val = sc.nextInt();
          presents.add(val);
        }
      }
    }
  }
}
