import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int A = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[] dp = new int[K+1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[A] = 0;
    
    for(int i=A; i<=K; i++) {
      if(dp[i] == Integer.MAX_VALUE) continue;

      if(i + 1 <= K) dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);

      if(i * 2 <= K) dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
    }

    bw.write(dp[K] + "");
    bw.flush();
    bw.close();
  }
}

