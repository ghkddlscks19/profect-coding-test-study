import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String s1 = br.readLine();
    String s2 = br.readLine();

    int[][] dp = new int[s1.length() + 1][s2.length() + 1];

    int answer = 0;
    
    for(int i =1; i<=s1.length(); i++) {
      for(int j =1; j<=s2.length(); j++) {
        if(s1.charAt(i-1) == s2.charAt(j-1)) {
          dp[i][j] = dp[i-1][j-1] + 1;
          answer = Math.max(answer, dp[i][j]);
        }
      }
    }

    bw.write(answer + "");
    bw.flush();
    bw.close();
  }
}

