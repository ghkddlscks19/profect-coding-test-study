import java.util.*;
import java.io.*;

class Main {
    static int[][] per;
    static int n;
    static int max = 0;
    public static void DFS(int idx, int status, int happy){
        if(idx > n)
            return;
        if(happy > max)
            max = happy;
        
        for(int i = idx; i < n; i++)
            if(status - per[i][0] > 0)
                DFS(i + 1, status - per[i][0], happy + per[i][1]);
        return;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        per = new int[n][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            per[i][0] = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            per[i][1] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(per, (a, b) -> b[1] - a[1]);
        DFS(0, 100, 0);
        System.out.println(max);
    }
}
