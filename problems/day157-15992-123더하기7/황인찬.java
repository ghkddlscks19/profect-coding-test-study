import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine());

    long[][] dp = new long[1001][1001];
    dp[0][0] = 1;
    for(int i =1; i<=1000; i++) {
      for(int j =1; j<=1000; j++) {
        if(i >= 1) dp[i][j] = (dp[i][j] + dp[i-1][j-1]) % 1_000_000_009;
        if(i >= 2) dp[i][j] = (dp[i][j] + dp[i-2][j-1]) % 1_000_000_009;
        if(i >= 3) dp[i][j] = (dp[i][j] + dp[i-3][j-1]) % 1_000_000_009;
      }
    }

    for(int t =0; t<T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      bw.write(dp[n][m] + "\n");
    }

    bw.flush();
    bw.close();
  }
}

