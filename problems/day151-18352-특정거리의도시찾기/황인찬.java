import java.util.*;
import java.io.*;
public class Main{
  static List<List<Integer>> graph = new ArrayList<>();
  static int N, M, K, X;
  static int[] dist;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    X = Integer.parseInt(st.nextToken());

    for(int i =0; i<=N; i++) {
      graph.add(new ArrayList<>());
    }

    for(int i =0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      graph.get(a).add(b);
    }

    dist = new int[N+1];
    Arrays.fill(dist, -1);
    bfs(X);

    List<Integer> result = new ArrayList<>();
    for(int i =1; i<=N; i++) {
      if(dist[i] == K) result.add(i);
    }

    if(result.size() == 0) bw.write("-1");
    else {
      for(int n: result) {
        bw.write(n + "\n");
      }
    }

    bw.flush();
    bw.close();
  }

  static void bfs(int start) {
    Deque<Integer> q = new ArrayDeque<>();
    q.offer(start);
    dist[start] = 0;

    while(!q.isEmpty()) {
      int curr = q.poll();

      for(int next : graph.get(curr)) {
        if(dist[next] == -1) {
          dist[next] = dist[curr] + 1;
          q.offer(next);
        }
      }
    }
  }
}

