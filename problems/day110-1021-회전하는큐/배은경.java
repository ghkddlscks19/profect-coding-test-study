import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for(int i = 1; i <= n; i++)
            dq.addLast(i);
            
        int cnt = 0;
        int idx = 0;
        while(idx < m) {
            ArrayDeque<Integer> cp = new ArrayDeque<>(dq);
            int size = dq.size();
            int a = arr[idx];
            int c = 0;
            
            while(cp.peekFirst() != a) {
                int tmp = cp.pollFirst();
                cp.addLast(tmp);
                c++;
            }
            
            if(c > size / 2) {
                c = 0;
                cp = new ArrayDeque<>(dq);
                while(cp.peekLast() != a) {
                    int tmp = cp.pollLast();
                    cp.addFirst(tmp);
                    c++;
                }
                c++;
                cp.pollLast();
            } else
                cp.pollFirst();
            
            cnt += c;
            dq = new ArrayDeque<>(cp);
            idx++;
        }
        
        System.out.print(cnt);
    }
}
