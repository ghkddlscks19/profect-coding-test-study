import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while((st = new StringTokenizer(br.readLine())) != null) {
            int n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
    
            if(n + r + c == 0)
                break;
            char[][][] grid = new char[n][r][c];
            boolean[][][] vst = new boolean[n][r][c];
            int[] s = new int[3];
            int[] d = new int[3];
            
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < r; j++) {
                    String str = br.readLine();
                    for(int k = 0; k < c; k++) {
                        grid[i][j][k] = str.charAt(k);
                        if(grid[i][j][k] == 'S') 
                            s = new int[]{i, j, k};
                        else if(grid[i][j][k] == 'E')
                            d = new int[]{i, j, k};
                    }
                }
                br.readLine();
            }
            
            Queue<int[]> que = new ArrayDeque<>();
            vst[s[0]][s[1]][s[2]] = true;
            que.offer(new int[]{s[0], s[1], s[2], 0});
            
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            int rslt = 0;
            while(!que.isEmpty()) {
                int[] q = que.poll();
                if(q[0] == d[0] && q[1] == d[1] && q[2] == d[2]){
                    rslt = q[3];
                    break;
                }
                //방문 안했고, 상하 동서남북
                if(q[0] - 1 >= 0 && vst[q[0] - 1][q[1]][q[2]] == false && (grid[q[0] - 1][q[1]][q[2]] == '.' || grid[q[0] - 1][q[1]][q[2]] == 'E')) {
                    que.offer(new int[]{q[0] - 1, q[1], q[2], q[3] + 1});
                    vst[q[0] - 1][q[1]][q[2]] = true;
                }
                if(q[0] + 1 < n && vst[q[0] + 1][q[1]][q[2]] == false && (grid[q[0] + 1][q[1]][q[2]] == '.' || grid[q[0] + 1][q[1]][q[2]] == 'E')) {
                    que.offer(new int[]{q[0] + 1, q[1], q[2], q[3] + 1});
                    vst[q[0] + 1][q[1]][q[2]] = true;
                }
                
                for(int i = 0; i < 4; i++) {
                    int nx = q[1] + dx[i];
                    int ny = q[2] + dy[i];
                    if(nx >= 0 && nx < r && ny >= 0 && ny < c && vst[q[0]][nx][ny] == false && (grid[q[0]][nx][ny] == '.' || grid[q[0]][nx][ny] == 'E')) {
                        que.offer(new int[]{q[0], nx, ny, q[3] + 1});
                        vst[q[0]][nx][ny] = true;
                    }
                }
            }
            
            if(rslt == 0)
                sb.append("Trapped!\n");
            else
                sb.append("Escaped in " + rslt + " minute(s).\n");
        }
        
        System.out.println(sb.toString());
    }
}
