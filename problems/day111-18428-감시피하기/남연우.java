import java.io.*;
import java.util.*;

public class Main{
  static int n;
  static char[][] info;
  static boolean answer = false;

  static void dfs(int depth) {
    if (answer)
      return;

    if (depth == 3) {
      if (check())
        answer = true;
      return;
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (info[i][j] == 'X') {
          info[i][j] = 'O';
          dfs(depth + 1);
          info[i][j] = 'X';
        }
      }
    }
  }

  static boolean check() {
     for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (info[i][j] != 'T')
          continue;

        //상
        for (int k = i - 1; k >= 0; k--) {
          if (info[k][j] == 'O')
            break;
          if (info[k][j] == 'S')
            return false;
        }

        //하
        for (int k = i + 1; k < n; k++) {
          if (info[k][j] == 'O')
            break;
          if (info[k][j] == 'S')
            return false;
        }

        //좌
        for (int k = j - 1; k >= 0; k--) {
          if (info[i][k] == 'O')
            break;
          if (info[i][k] == 'S')
            return false;
        }

        //우
        for (int k = j + 1; k < n; k++) {
          if (info[i][k] == 'O')
            break;
          if (info[i][k] == 'S')
            return false;
        }
      }
     }
    return true;
  }
  
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    info = new char[n][n];
    
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        info[i][j] = st.nextToken().charAt(0);
      }
    }

    dfs(0);

    if (answer)
      System.out.println("YES");
    else
      System.out.println("NO");
  }
}
