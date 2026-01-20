import java.util.*;
import java.io.*;
public class Main{
  static List<List<Integer>> graph = new ArrayList<>();
  static boolean[] visited;
  static Set<Integer> cycle = new HashSet<>();
  static int cycleStart = -1, cycleEnd = -1;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    for(int i =0; i<=N; i++) {
      graph.add(new ArrayList<>());
    }

    // 간선 연결
    for(int i =0; i<N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());

      graph.get(v1).add(v2);
      graph.get(v2).add(v1);
    }

    visited = new boolean[N+1];
    for(int i =1; i<=N; i++) {
      if(!visited[i]) {
        if(dfs(i, -1)) {
          cycle.add(cycleStart);
          break;
        }
      }
    }

    int[] result = bfs(N);

    for(int i =1; i<=N; i++) {
      bw.write(result[i] + " ");
    }

    bw.flush();
    bw.close();
  }

  // 사이클 찾기
  static boolean dfs(int curr, int from) {
    visited[curr] = true;
  
    for(int next : graph.get(curr)) {
      if(next == from) continue;
  
      if(visited[next] && cycleStart == -1) {
        cycleStart = next;
        cycleEnd = curr;
        cycle.add(curr);
        return true;
      }
  
      if(!visited[next] && dfs(next, curr)) {
        cycle.add(curr);
  
        if(curr == cycleStart) {
          return false;
        }
        return true;
      }
    }
    return false;
  }



  // 각 정점 거리 계산
  static int[] bfs(int N) {
    int[] distance = new int[N+1];
    Arrays.fill(distance, -1);

    Deque<Integer> q = new ArrayDeque<>();

    // 사이클에 들어있는건 모두 거리가 0
    for(int node: cycle) {
      q.offer(node);
      distance[node] = 0;
    }

    while(!q.isEmpty()) {
      int curr = q.poll();

      for(int next: graph.get(curr)) {
        if(distance[next] == -1) {
          distance[next] = distance[curr] + 1;
          q.offer(next);
        }
      }
    }

    return distance;
  }
}

