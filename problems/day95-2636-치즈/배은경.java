import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1)
                    cnt++;
            }
        }
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        boolean ch = true;
        int time = 0;
        
        while(ch) {
            boolean[][] vst = new boolean[n][m];
            Queue<int[]> que = new ArrayDeque<>();
            que.offer(new int[]{0, 0});
            vst[0][0] = true;
            int num = 0;
            while(!que.isEmpty()) {
                int[] sp = que.poll();
                for(int i = 0; i < 4; i++) {
                    int nx = sp[0] + dx[i];
                    int ny = sp[1] + dy[i];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < m && vst[nx][ny] == false) {
                        vst[nx][ny] = true;
                        if(arr[nx][ny] == 0)
                            que.offer(new int[]{nx, ny});
                        else
                            arr[nx][ny] = 0;
                    }
                }
            }
            
            time++;
            for(int i = 0; i < n; i++)
                for(int j = 0; j < m; j++)
                    if(arr[i][j] == 1)
                        num++;
            ch = num > 0 ? true : false;
            cnt = num > 0 ? num : cnt;
        }
        
        System.out.print(time + "\n" + cnt);
    }
}
