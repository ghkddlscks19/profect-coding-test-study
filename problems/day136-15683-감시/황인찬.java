import java.util.*;
import java.io.*;
public class Main{
  static int[][] office;
  static int[] dx = {-1, 0, 1, 0}; 
  static int[] dy = {0, 1, 0, -1};
  static int[][][] mode = {
    {}, // 0번 cctv는 없음
    {{0}, {1}, {2}, {3}}, // 1번 cctv 한방향
    {{0, 2}, {1, 3}}, // 2번 cctv 수평
    {{0, 1}, {1, 2}, {2, 3}, {3, 0}}, // 3번 cctv 직각
    {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}}, // 4번 cctv 3방향
    {{0, 1, 2, 3}} // 5번 cctv 4방향
  };
  static int N, M;
  static int min = Integer.MAX_VALUE;
  static List<CCTV> cctvs = new ArrayList<>();
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    office = new int[N][M];

    // 입력
    for(int i =0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j =0; j<M; j++) {
        office[i][j] = Integer.parseInt(st.nextToken());
        if(office[i][j] > 0 && office[i][j] < 6) {
          cctvs.add(new CCTV(i, j, office[i][j]));
        }
      }
    }

    dfs(0, office);
    bw.write(min + "");
    bw.flush();
    bw.close();
    
  }

  static void dfs(int depth, int[][] prev) {
    // 종료 조건
    if(depth == cctvs.size()) {
      int count = 0;
      for(int i =0; i<N; i++) {
        for(int j =0; j<M; j++) {
          if(prev[i][j] == 0) count++; // 사각지대 개수 세기
        }
      }
      
      min = Math.min(count, min);
      return;
    }

    CCTV cctv = cctvs.get(depth);

    for(int[] dir: mode[cctv.type]) {
      // 배열 복사
      int[][] temp = copyMap(prev);

      // cctv 감시 
      for(int d: dir) {
        watch(cctv.x, cctv.y, d, temp);
      }

      dfs(depth + 1, temp);
    }
  }

  static int[][] copyMap(int[][] office) {
    int[][] temp = new int[N][M];

    for(int i =0; i<N; i++) {
      temp[i] = office[i].clone();
    }

    return temp;
  }

  // cctv 감시 전부 -1 체크
  static void watch(int x, int y, int dir, int[][] office) {
    while(true) {
      x += dx[dir];
      y += dy[dir];

      // 범위를 벗어나거나 벽일 때 멈춘다
      if(x < 0 || x >= N || y < 0 || y >= M || office[x][y] == 6) break;
      
      if(office[x][y] == 0) office[x][y] = -1;
    }
  }

  static class CCTV {
    int x, y, type;

    public CCTV(int x, int y, int type) {
      this.x = x;
      this.y = y;
      this.type = type;
    }
  }
}

