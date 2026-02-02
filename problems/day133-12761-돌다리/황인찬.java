import java.util.*;
import java.io.*;
public class Main{
  static int A, B, N, M;
  static int min = Integer.MAX_VALUE;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 최소한의 이동횟수니까 dp나 bfs 생각
    // -1할 때 값은 어디서 구해오지?? 일단 bfs로 해보자

    StringTokenizer st = new StringTokenizer(br.readLine());
    A = Integer.parseInt(st.nextToken());
    B = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    bfs();
    
    bw.write(min + "");
    bw.flush();
    bw.close();
  }

  static void bfs() {
    Deque<Point> q = new ArrayDeque<>();
    boolean[] visited = new boolean[100001];
    q.offer(new Point(N, 0));
    visited[N] = true;

    while(!q.isEmpty()) {
      Point curr = q.poll();
      // 도착했으면 최소 횟수 비교
      if(curr.pos == M) {
        min = Math.min(min, curr.count);
        return;
      }

      int[] nextPos = {
        curr.pos - 1, curr.pos + 1, 
        curr.pos - A, curr.pos + A, curr.pos * A,
        curr.pos - B, curr.pos + B, curr.pos * B
      };

      for(int next: nextPos) {
        if(next < 0 || next > 100000) continue;

        // 이미 방문해도 패스
        if(visited[next]) continue;

        q.offer(new Point(next, curr.count + 1));
        visited[next] = true;
      }
      
      
    }
  }

  static class Point {
    int pos, count;

    public Point(int pos, int count) {
      this.pos = pos;
      this.count = count;
    }
  }
}

