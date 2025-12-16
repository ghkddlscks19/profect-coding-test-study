import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int N = sc.nextInt();
    int[] cranes = new int[N];
    for (int i = 0; i < N; i++) {
      cranes[i] = sc.nextInt();
    }
    
    int M = sc.nextInt();
    int[] boxes = new int[M];
    for (int i = 0; i < M; i++) {
      boxes[i] = sc.nextInt();
    }

    Arrays.sort(cranes);
    Arrays.sort(boxes);

    if (boxes[M - 1] > cranes[N - 1]) {
      System.out.println(-1);
      return;
    }
    
    int max = 0;
    int[] count = new int[N];
    for (int i = M - 1; i >= 0; i--) {
      boolean com = false;
      
      for (int j = 0; j < N; j++) {
        if (boxes[i] <= cranes[j] && count[j] != max) {
          count[j]++;
          if (max < count[j])
            max = count[j];
          com = true;
          break;
        }
      }

      if (boxes[i] <= cranes[N - 1] && com == false) {
        count[N - 1]++;
        if (max < count[N - 1])
            max = count[N - 1];
      }
    }

    System.out.println(max);
  }
}
