import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    static void dfs(int x, int y, int range) {
        if(range <= 1) {
            sb.append(arr[x][y]);
            return;
        }
        
        int std = arr[x][y];
        boolean ch = false;
        for(int i = x; i < x + range; i++) {
            for(int j = y; j < y + range; j++) {
                if(arr[i][j] != std) {
                    ch = true;
                    break;
                }
            }
        }
        
        if(ch) {
            sb.append("(");
            range /= 2;
            dfs(x, y, range);
            dfs(x, y + range, range);
            dfs(x + range, y, range);
            dfs(x + range, y + range, range);
            sb.append(")");
        } else {
            sb.append(std);
        }
        return;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        
        dfs(0, 0, n);
        System.out.println(sb.toString());
    }
}
