import java.util.*;
import java.io.*;
public class Main{
  static List<List<Node>> graph = new ArrayList<>();
  static boolean[] visited;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());  
    int robot1 = Integer.parseInt(st.nextToken());
    int robot2 = Integer.parseInt(st.nextToken());

    for(int i =0; i<=N; i++) {
      graph.add(new ArrayList<>());
    }
    
    for(int i =0; i<N-1; i++) {
      st = new StringTokenizer(br.readLine());
      int r1 = Integer.parseInt(st.nextToken());
      int r2 = Integer.parseInt(st.nextToken());
      int dist = Integer.parseInt(st.nextToken());

      graph.get(r1).add(new Node(r2, dist));
      graph.get(r2).add(new Node(r1, dist));
    }

    visited = new boolean[N+1];
    bfs(robot1, robot2);
    
  }

  static class Node {
    int room, dist, total, maxDist;

    public Node(int room, int dist) {
      this.room = room;
      this.dist = dist;
    }

    public Node(int room, int total, int maxDist) {
      this.room = room;
      this.total = total;
      this.maxDist = maxDist;
    }
  }

  static void bfs(int start, int target) {
    Deque<Node> q = new ArrayDeque<>();
    q.offer(new Node(start, 0, 0));
    visited[start] = true;

    while(!q.isEmpty()) {
      Node curr = q.poll();

      // 목적지 로봇을 만났을 때
      if(curr.room == target) {
        System.out.println(curr.total - curr.maxDist);
        return;
      }

      for(Node next: graph.get(curr.room)) {
        if(!visited[next.room]) {
          visited[next.room] = true;
          // 새로운 total = 현재까지의 total + 이번 간선의 dist
          // 새로운 maxDist = 지금까지의 maxDist와 이번 간선의 dist 중 큰 값
          q.offer(new Node(next.room, 
                           curr.total + next.dist, 
                           Math.max(curr.maxDist, next.dist)));
        }
      }
    }
  }
}

