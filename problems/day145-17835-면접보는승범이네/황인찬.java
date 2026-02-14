import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 다익스트라를 이용해서 구현해야함
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    List<List<Info>> graph = new ArrayList<>();
  
    for(int i =0; i<=N; i++) {
      graph.add(new ArrayList<>());
    }

    // 역방향 그래프 생성
    for(int i =0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int U = Integer.parseInt(st.nextToken());
      int V = Integer.parseInt(st.nextToken());
      int C = Integer.parseInt(st.nextToken());

      graph.get(V).add(new Info(U, C));     
    }

    // 다익스트라
    long[] dist = new long[N+1];
    Arrays.fill(dist, Long.MAX_VALUE);
    PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> {
      return Long.compare(o1.dist, o2.dist);
    });
    
    
    st = new StringTokenizer(br.readLine());
    // 면접관 위치부터 다익스트라 시작
    for(int i =0; i<K; i++) {
      int k = Integer.parseInt(st.nextToken());
      dist[k] = 0;
      pq.offer(new Info(k, 0));
    }

    while(!pq.isEmpty()) {
      Info curr = pq.poll();
      int currNode = curr.node;
      long currDist = curr.dist;

      // 이미 처리된 노드는 스킵
      if(currDist > dist[currNode]) continue;

      for(Info next: graph.get(currNode)) {
        int nextNode = next.node;
        long nextDist = currDist + next.dist;

        // 최단거리일시 갱신
        if(nextDist < dist[nextNode]) {
          dist[nextNode] = nextDist;
          pq.offer(new Info(nextNode, dist[nextNode]));
        }
      }
    }

    int maxCity = 0;
    long maxDist = -1;

    for(int i =1; i<=N; i++) {
      if(dist[i] > maxDist) {
        maxDist = dist[i];
        maxCity = i;
      }
    }

    bw.write(maxCity + "\n" + maxDist);
    bw.flush();
    bw.close();
    
  }

  static class Info {
    int node;
    long dist;

    public Info(int node, long dist) {
      this.node = node;
      this.dist = dist;
    }
  }
}

