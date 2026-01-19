import java.io.*;
import java.util.*;

public class Main{
  static char[][] students;
  static int count;
  static boolean[] selected;
  static int answer = 0;
  
  static int[] dx = { 0, 1, 0, -1};
  static int[] dy = { 1, 0, -1, 0};

  static void dfs(int idx, int count, int sCount) {
    if (count == 7 && sCount >= 4) {
      if (bfs())
        answer++;
      return;
    }

    if (idx == 25)
      return;

    selected[idx] = true;
    if (students[idx / 5][idx % 5] == 'S')
      dfs(idx + 1, count + 1, sCount + 1);
    else
      dfs(idx + 1, count + 1, sCount);

    selected[idx] = false;
    dfs(idx + 1, count, sCount);
    
    return;
  }

  static boolean bfs() {
    Queue<Integer> q = new LinkedList<>();
    boolean[] visited = new boolean[25];

    for (int i = 0; i < 25; i++) {
      if (selected[i]) {
        q.add(i);
        visited[i] = true;
        break;
      }
    }

    int count = 1;

    while (!q.isEmpty()) {
      int cur = q.poll();
      int x = cur / 5;
      int y = cur % 5;

      for (int k = 0; k < 4; k++) {
        int nx = x + dx[k];
        int ny = y + dy[k];

        if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
          int next = nx * 5 + ny;

          if (selected[next] && !visited[next]) {
            visited[next] = true;
            q.add(next);
            count++;
          }
        }
      }
    }

    if (count == 7)
      return true;

    return false;
  }
  
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    students = new char[5][5];
    selected = new boolean[25];

    for (int i = 0; i < 5; i++) {
      String line = br.readLine();
      for (int j = 0; j < 5; j++) {
        students[i][j] = line.charAt(j);
      }
    }

    dfs(0, 0, 0);

    System.out.println(answer);
  }
}
