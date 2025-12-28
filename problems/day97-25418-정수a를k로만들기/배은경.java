import java.util.*;
import java.io.*;

class Main {
    static int[] arr;
    static int n, m;
    static int bfs() {
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{n, 0});
        int cnt = m;
      
        while(!que.isEmpty()) {
            int[] q = que.poll();
            arr[q[0]] = q[1];
            if(q[0] == m)
                return q[1];
                
            if(q[0] * 2 <= m && arr[q[0] * 2] == 0)
                que.offer(new int[]{q[0] * 2, q[1] + 1});
            if(arr[q[0] + 1] == 0)
                que.offer(new int[]{q[0] + 1, q[1] + 1});
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m + 1];
        
        System.out.println(bfs());
    }
}
