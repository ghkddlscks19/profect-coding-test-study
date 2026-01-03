import java.io.*;
import java.util.*;

public class Main{

  static String order;
  static String devil;
  static String angel;

  static int[][][] dp;
  
  static int dfs(int depth, int type, int idx) {
    if (depth == order.length()) {
      return 1;
    }

    if (dp[type][idx + 1][depth] != -1) {
      return dp[type][idx + 1][depth];
    }

    int count = 0;
    String curType = "";

    if (type == 0)
      curType = devil;
    else
      curType = angel;

    for (int i = idx + 1; i < curType.length(); i++) {
      if (curType.charAt(i) == order.charAt(depth)) {
        count += dfs(depth + 1, 1 - type, i);
      }
    }

    dp[type][idx + 1][depth] = count;
    return count;
  }
  
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    order = br.readLine();
    devil = br.readLine();
    angel = br.readLine();

    int bLen = devil.length();
    int oLen = order.length();

    dp = new int[2][bLen + 1][oLen];
    
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j <= bLen; j++) {
        for (int k = 0; k < oLen; k++) {
          dp[i][j][k] = -1;
        }
      }
    }

    int answer = 0;

    answer = dfs(0, 0, -1) + dfs(0, 1, -1);

    System.out.println(answer);
  }
}
