import java.io.*;
import java.util.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    boolean[] info = new boolean[n + 1];

    for (int i = 0; i < b; i++) {
      int idx = Integer.parseInt(br.readLine());
      info[idx] = true;
    }

    int min = k;
    for (int i = 1; i <= n - k + 1; i++) {
      int count = 0;
      for (int j = i; j < i + k; j++) {
        if (info[j] == true)
          count++;
      }

      if (min > count)
        min = count;
    }    
    
    System.out.println(min);
  }
}
