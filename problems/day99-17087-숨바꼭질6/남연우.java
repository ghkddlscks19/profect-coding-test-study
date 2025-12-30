import java.util.*;

public class Main {
  static int gcd(int a, int b) {
    while (b != 0) {
      int tmp = a % b;
      a = b;
      b = tmp;
    }
    return a;
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int S = sc.nextInt();
    
    int[] locations = new int[N];
    for (int i = 0; i < N; i++) {
      locations[i] = sc.nextInt();
    }

    int result = Math.abs(locations[0] - S);
    for (int i = 0; i < N; i++) {
      int dist = Math.abs(locations[i] - S);
      result = gcd(result, dist);
    }

    System.out.println(result);
  }
}
