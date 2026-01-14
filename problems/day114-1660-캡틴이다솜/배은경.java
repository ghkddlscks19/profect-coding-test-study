import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 3000001);
        dp[0] = 0;

        int i = 1;
        int sum = 0;
        int total = 0;

        while (true) {
            sum += i;
            total += sum;
          
            if (total > n) break;
            for (int j = total; j <= n; j++) 
                dp[j] = Math.min(dp[j], dp[j - total] + 1);
            i++;
        }

        System.out.print(dp[n]);
    }
}
