import java.util.*;
import java.io.*;
public class Main{
  static int r, c;
  static int[][] map;
  static boolean[][] visited;
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, 1, 0, -1};
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    map = new int[r][c];
    for(int i =0; i<r; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j =0; j<c; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    

    int time = 0;
    int lastCheese = 0;

    while(true) {
      int cheese = countCheese();

      if(cheese == 0) break; // 치즈 0개면 종료

      lastCheese = cheese;
      bfs();
      time++;
    }

    bw.write(time + "\n" + lastCheese);
    bw.flush();
    bw.close();
  }

  static int countCheese() {
    int cnt = 0;
    for(int i =0; i<r; i++) {
      for(int j =0; j<c; j++) {
        if(map[i][j] == 1) cnt++;
      }
    }

    return cnt;
  }

  static void bfs() {
    Deque<Point> q = new ArrayDeque<>();
    visited = new boolean[r][c];
    List<Point> melts = new ArrayList<>(); // 녹을 리스트
    
    q.offer(new Point(0, 0));
    visited[0][0] = true;

    while(!q.isEmpty()) {
      Point curr = q.poll();

      for(int i =0; i<4; i++) {
        int nx = curr.x + dx[i];
        int ny = curr.y + dy[i];

        if(nx < 0 || nx >=r || ny < 0 || ny >=c) continue;
        if(visited[nx][ny]) continue;

        visited[nx][ny] = true;
        // 외부 공기면 계속 탐색, 아니면 녹을 리스트에 추가
        if(map[nx][ny] == 0) q.offer(new Point(nx, ny));
        else melts.add(new Point(nx, ny));
      }
    }

    // 녹을 리스트 제거
    for(Point p: melts) {
      map[p.x][p.y] = 0;
    }
  }

  static class Point {
    int x, y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}

