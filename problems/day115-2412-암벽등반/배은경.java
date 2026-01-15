import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        Map<Integer, List<Integer>> map = new HashMap<>();
        int[][] arr = new int[n][2];
        boolean[] vst = new boolean[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            map.computeIfAbsent(arr[i][0], k-> new ArrayList<>()).add(i);
        }
        
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{0, 0, 0});
        boolean ch = false;
        int rslt = n;
        while(!que.isEmpty()) {
            int[] std = que.poll();
            if(std[1] >= t) {
                ch = true;
                rslt = Math.min(std[2], rslt);
            }
            int min = std[0] - 2 < 0 ? 0 : std[0] - 2;
            for(int i = min; i <= std[0] + 2; i++) {
                List<Integer> list = map.get(i);
                if(list == null) continue;
                
                for(int num : list)
                    if(vst[num] == false && Math.abs(arr[num][0] - std[0]) <= 2 && Math.abs(arr[num][1] - std[1]) <= 2) {
                        que.offer(new int[]{arr[num][0], arr[num][1], std[2] + 1});
                        vst[num] = true;
                    }
            }
        }
        
        rslt = ch == false ? -1 : rslt;
        System.out.print(rslt);
    }
}
