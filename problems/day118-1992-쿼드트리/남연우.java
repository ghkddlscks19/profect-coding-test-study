import java.io.*;
import java.util.*;

public class Main{
  static int[][] video;

  static void dfs(int x, int y, int size) {
    if (same(x, y, size)) {
      System.out.print(video[x][y]);
      return;
    }

    int half = size / 2;
    
    System.out.print("(");
    dfs(x, y, half);
    dfs(x, y + half, half);
    dfs(x + half, y, half);
    dfs(x + half, y + half, half);
    System.out.print(")");

    return;
  }

  static boolean same(int x, int y, int size) {
    int check = video[x][y];

    for (int i = x; i < x + size; i++) {
      for (int j = y; j < y + size; j++) {
        if (check != video[i][j])
          return false;
      }
    }

    return true;
  }
  
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    video = new int[n][n];
    
    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      for (int j = 0; j < n; j++) {
        video[i][j] = line.charAt(j) - '0';
      }
    }

    dfs(0, 0, n);
  }
}
