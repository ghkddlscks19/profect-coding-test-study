import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static char[][] grid;
    static boolean[][] vst;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int oc = 0;
    static int vc = 0;
    static void dfs(int x, int y) {
        if(grid[x][y] == 'o')
            oc++;
        else if(grid[x][y] == 'v')
            vc++;
        
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < m && vst[nx][ny] == false && grid[nx][ny] != '#') {
                vst[nx][ny] = true;
                dfs(nx, ny);
            }
        }
        
        return;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new char[n][m];
        vst = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            grid[i] = s.toCharArray();
        }
        
        
        int[] cnt = {0, 0};
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(vst[i][j] == false && grid[i][j] != '#') {
                    vst[i][j] = true;
                    dfs(i, j);
                    if(oc > vc) cnt[0] += oc;
                    else cnt[1] += vc;
                    oc = 0; vc = 0;
                }
            }
        }
        
        System.out.print(cnt[0] + " " + cnt[1]);
    }
}
