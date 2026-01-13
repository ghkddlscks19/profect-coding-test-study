import java.util.*;
import java.io.*;
public class Main{
  public static final int MOD = 1000000009;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine());

    long[] dp = new long[1000001];
    
    dp[1] = 1L;
    dp[2] = 2L;
    dp[3] = 4L;
    for(int i =4; i<dp.length; i++) {
      dp[i] = (dp[i-3] + dp[i-2] + dp[i-1]) % MOD;
    }
    
    for(int i =0; i<T; i++) {
      int n = Integer.parseInt(br.readLine());
      bw.write(dp[n] + "");
      bw.newLine();
    }

    bw.flush();
    bw.close();
  }
}

