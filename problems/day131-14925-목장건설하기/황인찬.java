import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());

    int[][] map = new int[M][N];

    for(int i =0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j =0; j<N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int[][] dp = new int[M+1][N+1];
    
    int max = 0;
    for(int i =1; i<=M; i++) {
      for(int j =1; j<=N; j++) {
        if(map[i-1][j-1] == 0) {
          dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
          max = Math.max(dp[i][j], max);
        }
      }
    }

    bw.write(max + "");
    bw.flush();
    bw.close();
  }
}

