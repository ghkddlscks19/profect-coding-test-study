import java.io.*;
import java.util.*;

public class Main{
  public static void main(String args[]) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine().trim());

    int[][] board = new int[n][n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) 
        board[i][j] = Integer.parseInt(st.nextToken());
    }

    boolean[][] visited = new boolean[n][n];
    ArrayDeque<int[]> q = new ArrayDeque<>();
    q.add(new int[]{0, 0});
    visited[0][0] = true;

    while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            int k = board[r][c];

            if (k == -1) {                 
                System.out.println("HaruHaru");
                return;
            }
            if (k == 0) continue;          

            int nr = r + k, nc = c;
            if (nr < n && !visited[nr][nc]) {
                visited[nr][nc] = true;
                q.add(new int[]{nr, nc});
            }

            nr = r; nc = c + k;
            if (nc < n && !visited[nr][nc]) {
                visited[nr][nc] = true;
                q.add(new int[]{nr, nc});
            }
        }

        System.out.println("Hing");
  }
}

