import java.io.*;
import java.util.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());

    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());

      String[] arr = new String[n];
      for (int j = 0; j < n; j++) {
        arr[j] = br.readLine();
      }

      Arrays.sort(arr);
      boolean consistency = true;
      for (int j = 0; j < n - 1; j++) {
        if (arr[j + 1].startsWith(arr[j])) {
          consistency = false;
          break;
        }
      }

      if (consistency)
        System.out.println("YES");
      else
        System.out.println("NO");
    }
  }
}
