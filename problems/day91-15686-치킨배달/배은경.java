import java.util.*;
import java.io.*;

class Main {
    static List<int[]> home;
    static List<int[]> chicken;
    static int m;
    static int rslt;
    static void DFS(int idx, int cnt, List<Integer> list) {
        if(idx > chicken.size())
            return;
        if(cnt == m) {
            int total = 0;
            for(int[] sp : home) {
                int min = 100;
                for(int a : list) {
                    int[] ch = chicken.get(a);
                    int dist = Math.abs(sp[0] - ch[0]) + Math.abs(sp[1] - ch[1]);
                    if(dist < min) 
                        min = dist;
                }
                total += min;
            }
            if(total < rslt)
                rslt = total;
            return;
        }
        
        for(int i = idx; i < chicken.size(); i++) {
            list.add(i);
            DFS(i + 1, cnt + 1, list);
            list.remove(Integer.valueOf(i));
        }
        
        return;
        
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] grid = new int[n][n];
        home = new ArrayList<>();
        chicken = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if(grid[i][j] == 1)
                    home.add(new int[]{i, j});
                else if(grid[i][j] == 2) 
                    chicken.add(new int[]{i, j});
            }
        }
        
        rslt = 100 * home.size();
        List<Integer> choose = new ArrayList<>();
        DFS(0, 0, choose);
        System.out.println(rslt);
        
    }
}
