import java.util.*;
import java.io.*;

class Main {
    static boolean win = false;
    static int[][] arr;
    static boolean[][] vst;
    static int n;
    static void dfs(int x, int y) {
        if(x == n && y == n){
            win = true;
            return;
        }
        if(vst[x][y] == true || arr[x][y] == 0)
            return;
        vst[x][y] = true;
        if(x + arr[x][y] <= n)
            dfs(x + arr[x][y], y);
        if(y + arr[x][y] <= n) 
            dfs(x, y+ arr[x][y]);
        return;
    }
  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[n + 1][n + 1];
        vst = new boolean[n + 1][n + 1];
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        
        dfs(1, 1);
        if(win == true)
            System.out.println("HaruHaru");
        else
            System.out.println("Hing");
    }
}
