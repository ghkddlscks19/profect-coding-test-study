import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{0, 0, 1});
        maps[0][0] = 0;
        
        int n = maps.length;
        int m = maps[0].length;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while(!que.isEmpty()) {
            int[] arr = que.poll();
            
            if(arr[0] == n - 1 && arr[1] == m - 1){
                answer = arr[2];
                break;
            }
            for(int i = 0; i < 4; i++) {
                if(arr[0] + dx[i] >= 0 && arr[0] + dx[i] < n && arr[1] + dy[i] >= 0 && arr[1] + dy[i] < m) {
                    if(maps[arr[0] + dx[i]][arr[1] + dy[i]] == 1) {
                        que.offer(new int[]{arr[0] + dx[i], arr[1] + dy[i], arr[2] + 1});
                        maps[arr[0] + dx[i]][arr[1] + dy[i]] = 0;
                    }
                }       
            }
        }
        
        return answer;
    }
}
