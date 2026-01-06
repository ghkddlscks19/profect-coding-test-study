import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine()); // 포도주 잔 개수

    int[] arr = new int[n];

    for(int i =0; i<n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    int[] dp = new int[n];
    dp[0] = arr[0];

    if(n > 1) {
      dp[1] = arr[0] + arr[1];
    }

    if(n > 2) {
      dp[2] = Math.max(dp[1], Math.max(dp[0] + arr[2], arr[1] + arr[2]));
    }
    for(int i =3; i<n; i++) {
      // 1. 현재 잔을 마시지 못하는 경우
      // 2. 현재 잔을 마실 수 있고, 첫 번째 잔인 경우
      // 3. 현재 잔을 마실 수 있고, 두 번째 잔인 경우
      dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i-1] + arr[i]));
    }

    bw.write(dp[n-1] + "");
    bw.flush();
    bw.close();
  }
}

