import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] days = new int[n + 2][2];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            days[i][0] = Integer.parseInt(st.nextToken());
            days[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 3];
        for (int i = n; i >= 1; i--) {
            int r1 = dp[i + 1];
            int r2 = 0;
            int next = i + days[i][0];
            if (next <= n + 1) 
                r2 = days[i][1] + dp[next];
            dp[i] = Math.max(r1, r2);
        }

        System.out.println(dp[1]);
    }
}
