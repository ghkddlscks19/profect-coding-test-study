import java.util.*;
import java.io.*;
public class Main{
  static int L, R, C;
  static char[][][] building;
  static int[][][] dist;
  static int[] dl = {0, 0, 0, 0, -1, 1};
  static int[] dr = {-1, 0, 1, 0, 0, 0};
  static int[] dc = {0, 1, 0, -1, 0, 0};
  static Point start, end;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String input = "";

    while(!(input = br.readLine()).equals("0 0 0")) {
      StringTokenizer st = new StringTokenizer(input);
      L = Integer.parseInt(st.nextToken()); // 층
      R = Integer.parseInt(st.nextToken()); // 행
      C = Integer.parseInt(st.nextToken()); // 열
      
      building = new char[L][R][C];

      for(int i =0; i<L; i++) {
        for(int j =0; j<R; j++) {
          String line = br.readLine();
          for(int k =0; k<C; k++) {
            building[i][j][k] = line.charAt(k);

            // 시작 지점 및 끝 지점
            if(building[i][j][k] == 'S') start = new Point(i, j, k);
            else if(building[i][j][k] == 'E') end = new Point(i, j, k);
          } 
        }
        // 층 사이 빈줄
        br.readLine();
      }

      // 일단 거리 큰값으로 채워 놓기
      dist = new int[L][R][C];

      for(int i =0; i<L; i++) {
        for(int j =0; j<R; j++) {
          Arrays.fill(dist[i][j], Integer.MAX_VALUE);
        }
      }

      bfs();

      // 탈출 시간이 정수 최대 값이면 방문 못한 것
      int escapeTime = dist[end.l][end.r][end.c];
      if(escapeTime == Integer.MAX_VALUE) bw.write("Trapped!");
      else bw.write("Escaped in " + escapeTime + " minute(s).");
      bw.newLine();
    }

    bw.flush();
    bw.close();
  }

  static void bfs() {
    Queue<Point> q = new ArrayDeque<>();
    q.offer(start);
    dist[start.l][start.r][start.c] = 0;

    while(!q.isEmpty()) {
      Point curr = q.poll();

      for(int i =0; i<6; i++) {
        int nl = curr.l + dl[i];
        int nr = curr.r + dr[i];
        int nc = curr.c + dc[i];

        // 범위를 벗어났을 때
        if(nl < 0 || nl >= L || nr < 0 || nr >= R || nc < 0 || nc >= C) continue;

        // 막혀있을 때
        if(building[nl][nr][nc] == '#') continue;

        // 이미 방문했는데 더 작은 값으로 온 적 있을 때
        if(dist[nl][nr][nc] <= dist[curr.l][curr.r][curr.c] + 1) continue;

        dist[nl][nr][nc] = dist[curr.l][curr.r][curr.c] + 1;
        q.offer(new Point(nl, nr, nc));
      }
    }
  }

  static class Point {
    int l, r, c;

    public Point(int l, int r, int c) {
      this.l = l;
      this.r = r;
      this.c = c;
    }
  }
}

