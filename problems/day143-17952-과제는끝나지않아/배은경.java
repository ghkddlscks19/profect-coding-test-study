import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[n][3];
        int[] now = {0, 0};
        int rslt = 0;
        Stack<int[]> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int ts = Integer.parseInt(st.nextToken());
            if(ts == 1) {
                if(now[0] != 0)
                    stack.push(new int[]{now[0], now[1]});
                now[0] = Integer.parseInt(st.nextToken());
                now[1] = Integer.parseInt(st.nextToken());
            }
            if(now[0] != 0)
                now[1]--;
            
            if(now[0] != 0 && now[1] == 0) {
                rslt += now[0];
                if(!stack.isEmpty())
                    now = stack.pop();
                else 
                    now[0] = 0;
            }
        }
        
        System.out.println(rslt);
    }
}
