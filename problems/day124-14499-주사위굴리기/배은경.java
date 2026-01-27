import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] grid;
    static int[] cmd, dice;
    static StringBuilder sb = new StringBuilder();
    static void simul(int x, int y, int idx) {
        if(idx == cmd.length)
            return;
        int k = cmd[idx];
        int[] before = dice.clone();
        boolean ch = false;
        if (k == 1) { //동
            if(y + 1 < m) {
                ch = true;
                dice[0] = before[3];
                dice[2] = before[0];
                dice[3] = before[5];
                dice[5] = before[2];
                if(grid[x][y + 1] == 0) {
                    grid[x][y + 1] = dice[5];
                } else {
                    dice[5] = grid[x][y + 1];
                    grid[x][y + 1] = 0;
                }
                sb.append(dice[0] + "\n");
                simul(x, y + 1, idx + 1);
            }
        } else if(k == 2) { //서
            if(y - 1 >= 0) {
                ch = true;
                dice[0] = before[2];
                dice[2] = before[5];
                dice[3] = before[0];
                dice[5] = before[3];
                if(grid[x][y - 1] == 0) {
                    grid[x][y - 1] = dice[5];
                } else {
                    dice[5] = grid[x][y - 1];
                    grid[x][y - 1] = 0;
                }
                sb.append(dice[0] + "\n");
                simul(x, y - 1, idx + 1);
            }
        } else if(k == 3) { //북
            if(x - 1 >= 0) {
                ch = true;
                dice[0] = before[4];
                dice[1] = before[0];
                dice[4] = before[5];
                dice[5] = before[1];
                if(grid[x - 1][y] == 0) {
                    grid[x - 1][y] = dice[5];
                } else {
                    dice[5] = grid[x - 1][y];
                    grid[x - 1][y] = 0;
                }
                sb.append(dice[0] + "\n");
                simul(x - 1, y, idx + 1);
            }
        } else if(k == 4) { //남
            if(x + 1 < n) {
                ch = true;
                dice[0] = before[1];
                dice[1] = before[5];
                dice[4] = before[0];
                dice[5] = before[4];
                
                if(grid[x + 1][y] == 0) {
                    grid[x + 1][y] = dice[5];
                } else {
                    dice[5] = grid[x + 1][y];
                    grid[x + 1][y] = 0;
                }
                sb.append(dice[0] + "\n");
                simul(x + 1, y, idx + 1);
            }
        }
        
        if(ch == false)
            simul(x, y, idx + 1);
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++)
                grid[i][j] = Integer.parseInt(st.nextToken());
        }
        
        dice = new int[]{0, 0, 0, 0, 0, 0};
        cmd = new int[k + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++)
            cmd[i] = Integer.parseInt(st.nextToken());
        
        simul(x, y, 0);
        System.out.print(sb.toString());
    }
}
