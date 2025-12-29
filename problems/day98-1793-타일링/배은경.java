import java.util.*;
import java.io.*;
import java.math.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = "";
        while((num = br.readLine()) != null){
            int n = Integer.parseInt(num);
            BigInteger[] dp = new BigInteger[n + 1];
            dp[0] = BigInteger.ONE;
            if(n >= 1)
                dp[1] = BigInteger.ONE;
          
            for(int i = 2; i <= n; i++)
                dp[i] = dp[i - 2].multiply(BigInteger.valueOf(3)).add(dp[i - 1].subtract(dp[i-2]));
            System.out.println(dp[n]);
        }
    }
}
