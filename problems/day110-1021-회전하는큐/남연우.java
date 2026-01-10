import java.io.*;
import java.util.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m= Integer.parseInt(st.nextToken());

    Deque<Integer> dq = new LinkedList<>();
    for (int  i = 1; i <= n; i++) {
      dq.addLast(i);
    }
    
    int[] want = new int[m];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      want[i] = Integer.parseInt(st.nextToken());
    }

    int count = 0;    
    for (int i = 0; i < m; i++) {
      int target = want[i];
      int front = dq.peekFirst();
      
      if (front == target) {
        dq.pollFirst();
      }
      else {
        int size = dq.size();
        int idx = 0;
        for (int v : dq) {
          if (v == target)
            break;
          idx++;
        }

        if (idx < size - idx) {
          for (int j = 0; j < idx; j++) {
            dq.addLast(dq.pollFirst());
            count++;
          }
          dq.pollFirst();
        }
        else {
          for (int j = 0; j < size - idx; j++) {
            dq.addFirst(dq.pollLast());
            count++;
          }
          dq.pollFirst();
        }
      }
    }

    System.out.println(count);
  }
}
