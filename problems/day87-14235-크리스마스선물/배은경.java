import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if(num != 0)
                for(int j = 0; j < num; j++)
                    pq.offer(Integer.parseInt(st.nextToken()));
            else
                if(!pq.isEmpty())
                    sb.append(pq.poll() + "\n");
                else
                    sb.append("-1\n");
        }
        System.out.print(sb.toString());
    }
}
