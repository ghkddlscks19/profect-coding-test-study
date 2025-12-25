import java.util.*;
import java.io.*;
public class Main{
  static boolean[] visited;
  static int[] order;
  static int cnt = 1;
  static List<List<Integer>> graph;
  
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int R = Integer.parseInt(st.nextToken());

    graph = new ArrayList<>();
    visited = new boolean[N+1];
    order = new int[N+1];
    for(int i =0; i<=N; i++) {
      graph.add(new ArrayList<>());
    }

    for(int i =0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      graph.get(u).add(v);
      graph.get(v).add(u);
    }

    for(int i =1; i<=N; i++) {
      Collections.sort(graph.get(i));
    }

    bfs(R);

    for(int i =1; i<=N; i++) {
      bw.write(order[i] + "\n");
    }

    bw.flush();
    bw.close();
  }
  static void bfs(int node) {
    Deque<Integer> q = new ArrayDeque<>();
    q.offer(node);
    visited[node] = true;
    order[node] = cnt++;

    while(!q.isEmpty()) {
      int curr = q.poll();

      for(int next: graph.get(curr)) {
        if(!visited[next]) {
          visited[next] = true;
          q.offer(next);
          order[next] = cnt++;
        }
      }
    }
  }
}

