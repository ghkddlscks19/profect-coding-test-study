import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[1] == b[1])
                return b[2] - a[2];
            return a[1] - b[1];
        });
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
       
        for(int i = 0; i < Math.min(n, k); i++)
            pq.offer(new int[]{arr[i][0], arr[i][1], i + 1});
            
        long rslt = 0;
        int idx = k;
        int num = 1;
        while(!pq.isEmpty()) {
            boolean[] list = new boolean[k + 1];
            int time = pq.peek()[1];
            while(!pq.isEmpty() && pq.peek()[1] == time) {
                int t[] = pq.poll();
                list[t[2]] = true;
                rslt += (long)t[0] * num++;
            }
            
            for(int i  = 1; i <= k; i++)
                if(idx < n && list[i] == true) {
                    pq.offer(new int[]{arr[idx][0], arr[idx][1] + time, i});
                    idx++;
                }
        }
        System.out.println(rslt);
    }
}
