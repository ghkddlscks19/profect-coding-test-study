import java.util.*;
import java.io.*;
public class Main{
  static char[][] seat = new char[5][5];
  static boolean[][] selected = new boolean[5][5];
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, 1, 0, -1};
  static int result = 0;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 자리 입력
    for(int i =0; i<5; i++) {
      String line = br.readLine();
      for(int j =0; j<5; j++) {
        seat[i][j] = line.charAt(j);
      }
    }

    // 가로 세로 인접하는 조합을 전부 뽑는다 -> dfs, 백트래킹
    // S: 이다솜 Y: 임도연
    dfs(0, 0, 0, 0);
    bw.write(String.valueOf(result));
    bw.flush();
    bw.close();
    
  }

  static void dfs(int x, int y, int cnt, int sCnt) {
    // 7명이고 S가 4명 이상
    if(cnt == 7) {
      if(sCnt >= 4 && isConnected()) {
        result++;
      }
      return;
    }

    for(int i =x; i<5; i++) {
      for(int j =0; j<5; j++) {
        // 시작점 이전이면 건너뜀
        if(i == x && j < y) continue;

        selected[i][j] = true;
        dfs(i, j + 1, cnt + 1, seat[i][j] == 'S' ? sCnt + 1 : sCnt);
        selected[i][j] = false;
      }
    }
  }

  static boolean isConnected() {
    boolean[][] visited = new boolean[5][5];

    int startX = 0, startY = 0;
    boolean found = false;
    for(int i =0; i<5; i++) {
      for(int j =0; j<5; j++) {
        if(selected[i][j]) {
          startX = i;
          startY = j;
          break;
        }
      }
      if(found) break;
    }

    int count = dfsConnect(startX, startY, visited);

    return count == 7 ? true : false;
  }

  static int dfsConnect(int x, int y, boolean[][] visited) {
    visited[x][y] = true;
    int count = 1;

    for(int i =0; i<4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;

      if(visited[nx][ny] || !selected[nx][ny]) continue;

      count += dfsConnect(nx, ny, visited);
    }

    return count;
  }
  
}

