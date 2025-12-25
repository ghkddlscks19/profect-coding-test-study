import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] list = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++)
            list[i] = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            list[n1].add(n2);
            list[n2].add(n1);
        }
    
        for(int i = 1; i <= n; i++)
            Collections.sort(list[i]);
            
        Queue<Integer> que = new ArrayDeque<>();
        boolean[] vst = new boolean[n + 1];
        int[] order = new int[n + 1];
        que.add(r);
        vst[r] = true;
        int cnt = 0;
        
        while(!que.isEmpty()) {
            int q = que.poll();
            order[q] = ++cnt;
            for(int num : list[q]) {
                if(vst[num] == false) {
                    que.offer(num);
                    vst[num] = true;
                }
            }
        }
    
        for(int i = 1; i <= n; i++)
            System.out.println(order[i]);
    }
}
