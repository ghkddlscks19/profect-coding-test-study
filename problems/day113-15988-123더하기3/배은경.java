import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        for(int i = 0; i < n; i++)
            num[i] = Integer.parseInt(br.readLine());
        
        long[] dp = new long[1000001];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i < 1000001; i++)
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009;
            
        for(int i = 0; i < n; i++)
            System.out.println(dp[num[i]]);
    }
}
