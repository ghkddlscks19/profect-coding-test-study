import java.util.*;
import java.io.*;
public class Main{
  static List<List<Integer>> graph = new ArrayList<>();
  static Island[] islandInfo;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    islandInfo = new Island[N+1]; // 섬 정보

    for(int i =0; i<=N; i++) {
      graph.add(new ArrayList<>());
    }

    islandInfo[1] = new Island('S', 0);
    for(int i =2; i<=N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      char t = st.nextToken().charAt(0);
      int a = Integer.parseInt(st.nextToken());
      int p = Integer.parseInt(st.nextToken());

      islandInfo[i] = new Island(t, a); // 섬 정보는 배열
      graph.get(p).add(i); // 연결은 노드 번호로 그래프
    }

    
    long result = dfs(1);
    bw.write(result + "");
    bw.flush();
    bw.close();
  }

  static long dfs(int node) {
    long sum = 0;

    for(int next: graph.get(node)) {
      sum += dfs(next);
    }

    // 현재 양이면 더하고 늑대면 뺀다
    Island currIsland = islandInfo[node];

    if(currIsland.t == 'S') {
      sum += currIsland.a;
    } else {
      sum -= currIsland.a;
    }

    if(sum < 0) {
      return 0;
    } else {
      return sum;
    }
  }

  static class Island {
    char t;
    int a;

    public Island(char t, int a) {
      this.t = t;
      this.a = a;
    }
  }
}

