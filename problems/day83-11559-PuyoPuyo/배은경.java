import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] arr = new char[12][6];
        for(int i = 0; i < 12; i++) {
            String s = br.readLine();
            arr[i] = s.toCharArray();
        }
        boolean[][] vst;
        Queue<int[]> que;
        boolean check = true;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int rslt = 0;
        while(check == true) {
            check = false;
            vst = new boolean[12][6];
            que = new ArrayDeque<>();
            for(int i = 11; i >= 0; i--) {
                for(int j = 5; j >= 0; j--) {
                    if(arr[i][j] != '.' && vst[i][j] == false) {
                        List<int[]> grp = new ArrayList<>();
                        que.offer(new int[]{i, j});
                        vst[i][j] = true;
                        int cnt = 1;
                        int[] sp = {};
                        char std = arr[i][j];
                        while(!que.isEmpty()) {
                            sp = que.poll();
                            grp.add(sp);
                            for(int k = 0; k < 4; k++) {
                                int nx = sp[0] + dx[k];
                                int ny = sp[1] + dy[k];
                                if(nx >= 0 && nx < 12 && ny >= 0 && ny < 6 && arr[nx][ny] == std && vst[nx][ny] == false) {
                                    cnt++;
                                    vst[nx][ny] = true;
                                    que.offer(new int[]{nx, ny});
                                }
                            }
                        }
                        
                        if(cnt >= 4) {
                            check = true;
                            for(int[] a : grp) 
                                arr[a[0]][a[1]] = '.';
                        } else
                            que.clear();
                    }
                }
            }
            if(check == true) {
                rslt++;
                for(int y = 5; y >= 0; y--)
                    for(int x = 11; x >= 0; x--)
                        if(arr[x][y] == '.') {
                            int p = 0;
                            while(x - p > 0){
                                p++;
                                if(arr[x - p][y] != '.') {
                                    arr[x][y] = arr[x - p][y];
                                    arr[x - p][y] = '.';
                                    break;
                                }
                            }
                        }
            }
        }
        System.out.println(rslt);
    }
}
