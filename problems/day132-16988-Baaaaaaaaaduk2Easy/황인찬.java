import java.util.*;
import java.io.*;
public class Main{
  static int N, M;
  static int[][] grid;
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, 1, 0, -1};
  static int max = 0;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    grid = new int[N][M];

    List<Point> list = new ArrayList<>();
    
    for(int i =0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j =0; j<M; j++) {
        grid[i][j] = Integer.parseInt(st.nextToken());
        
        // 0인 좌표를 모두 구한다.
        if(grid[i][j] == 0) list.add(new Point(i, j));     
      }
    }

    // 0인 좌표 2개씩 가져와서 돌 놓아보기
    for(int i =0; i<list.size(); i++) {
      for(int j =i+1; j<list.size(); j++) {
        Point p1 = list.get(i);
        Point p2 = list.get(j);

        // 돌 2개 놓기
        grid[p1.x][p1.y] = 1;
        grid[p2.x][p2.y] = 1;

        // bfs로 순회
        int curr = 0;
        boolean[][] visited = new boolean[N][M];

        for(int r =0; r<N; r++) {
          for(int c =0; c<M; c++) {
            if(grid[r][c] == 2 && !visited[r][c]) {
              curr += bfs(r, c, visited);
            }
          }
        }

        max = Math.max(curr, max);
                
        // 돌 2개 원위치
        grid[p1.x][p1.y] = 0;
        grid[p2.x][p2.y] = 0;
        
      }
    }

    bw.write(max + "");
    bw.flush();
    bw.close();
  }

  static int bfs(int r, int c, boolean[][] visited) {
    Deque<Point> q = new ArrayDeque<>();
    visited[r][c] = true;
    q.offer(new Point(r, c));

    int count = 1; // 현재 그룹에 돌 개수
    boolean dead = true; // 일단 죽었다고 가정한다.

    while(!q.isEmpty()) {
      Point curr = q.poll();

      for(int i =0; i<4; i++) {
        int nx = curr.x + dx[i];
        int ny = curr.y + dy[i];

        if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

        // 빈칸이 있는 그룹이니까 죽지 않는다.
        if(grid[nx][ny] == 0) {
          dead = false;
        }

        // 상대 돌이면서 방문 안한거면 큐에 넣고 계속 탐색
        if(grid[nx][ny] == 2 && !visited[nx][ny]) {
          visited[nx][ny] = true;
          q.offer(new Point(nx, ny));
          count++;
        }
      }
    }

    return dead ? count : 0;
  }

  static class Point {
    int x, y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}

