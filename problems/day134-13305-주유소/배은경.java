import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dist = new int[n - 1];
        int[] cost = new int[n];
        
        for(int i = 0; i < n - 1; i++)
            dist[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            cost[i] = Integer.parseInt(st.nextToken());
        
        long sum = 0;
        for(int i = 0; i < n - 1; i++) {
            long distance = 0L;
            int std = i;
            while(i + 1 < n - 1 && cost[std] < cost[i + 1])
                distance += dist[i++];
            distance += dist[i];
            sum += distance * cost[std];
        }
        
        System.out.print(sum);
    }
}
