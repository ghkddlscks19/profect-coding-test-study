import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    int[] T = new int[N+1];
    int[] P = new int[N+1];

    for(int i =1; i<=N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      T[i] = Integer.parseInt(st.nextToken());
      P[i] = Integer.parseInt(st.nextToken());
    }

    int[] dp = new int[N+2];

    for(int i =N; i>=1; i--) {
      if(i + T[i] > N + 1) { // 상담 일이 퇴사 일 넘어 가는 경우
        dp[i] = dp[i+1];
      } else { // 상담 받기 vs 안 받기 최대 값
        dp[i] = Math.max(P[i] + dp[i + T[i]], dp[i+1]);
      }
    }

    bw.write(String.valueOf(dp[1]));
    bw.flush();
    bw.close();
  }
}

