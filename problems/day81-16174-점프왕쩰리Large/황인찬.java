import java.util.*;
import java.io.*;
public class Main{
  static int[][] map;
  static int[] dx = {0, 1};
  static int[] dy = {1, 0};
  static boolean[][] visited;
  static int N;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());

    // 게임 구역 생성
    map = new int[N][N];
    for(int i =0; i<N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j =0; j<N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    visited = new boolean[N][N];
    String answer = bfs(0, 0);
    bw.write(answer);
    bw.flush();
    bw.close();
    
  }

  static String bfs(int x, int y) {
    Deque<Point> q = new ArrayDeque<>();
    q.offer(new Point(x, y));
    visited[x][y] = true;

    while(!q.isEmpty()) {
      Point curr = q.poll();

      if(map[curr.x][curr.y] == -1) return "HaruHaru";

      for(int i =0; i<2; i++) {
        int nx = curr.x + dx[i] * map[curr.x][curr.y];
        int ny = curr.y + dy[i] * map[curr.x][curr.y];

        // 범위 밖
        if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

        // 이미 방문
        if(visited[nx][ny]) continue;

        // 방문 처리 및 큐에 추가
        visited[nx][ny] = true;
        q.offer(new Point(nx, ny));
      }
    }

    return "Hing";
   
  }

  static class Point {
    int x, y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}

