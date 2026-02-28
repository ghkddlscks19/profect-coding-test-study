import java.util.*;
import java.io.*;
public class Main {
  static int N, r1, c1, r2, c2;
  static int[][] dist;
  static int[] dr = {-2, -2, 0, 0, 2, 2};
  static int[] dc = {-1, 1, -2, 2, -1, 1};
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    
    r1 = Integer.parseInt(st.nextToken());
    c1 = Integer.parseInt(st.nextToken());
    r2 = Integer.parseInt(st.nextToken());
    c2 = Integer.parseInt(st.nextToken());

    dist = new int[N][N];
    for(int i =0; i<N; i++) {
      Arrays.fill(dist[i], -1);
    }

    bfs();

    bw.write(dist[r2][c2] + "");
    bw.flush();
    bw.close();
  }

  static void bfs() {
    Deque<Point> q = new ArrayDeque<>();
    q.offer(new Point(r1, c1));
    dist[r1][c1] = 0;

    while(!q.isEmpty()) {
      Point curr = q.poll();

      for(int i =0; i<6; i++) {
        int nr = curr.r + dr[i];
        int nc = curr.c + dc[i];

        if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;

        if(dist[nr][nc] != -1) continue;

        q.offer(new Point(nr, nc));
        dist[nr][nc] = dist[curr.r][curr.c] + 1;
      }
    }
  }

  static class Point {
    int r, c;

    public Point(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }
}

