import java.io.*;
import java.util.*;

public class Main{
  static long[][] info;
  static ArrayList<Integer>[] children;
  
  static long move(int i) {
    long sum = 0;

    for (int c : children[i]) {
      sum += move(c);
    }

    if (info[i][0] == 0)
      sum += info[i][1];
    else
      sum -= info[i][1];

    return Math.max(0, sum);
  }
  
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    info = new long[n + 1][3];
    children = new ArrayList[n + 1];

    for (int i = 1; i <= n; i++)
      children[i] = new ArrayList<>();
    
    for (int i = 2; i <= n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      char t = st.nextToken().charAt(0);
      int a = Integer.parseInt(st.nextToken());
      int p = Integer.parseInt(st.nextToken());

      // 'S' -> 0, 'W' -> 1
      if (t == 'S')
        info[i][0] = 0;
      else
        info[i][0] = 1;

      info[i][1] = a;
      info[i][2] = p;

      children[p].add(i);
    }

    System.out.println(move(1));
  }
}
