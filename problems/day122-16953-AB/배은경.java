import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int cnt = 1;
        while(m > n) {
            cnt++;
            if(m % 2 == 0) {
                m /= 2;
            } else if(m % 10 == 1) {
                m /= 10;
            } else {
                cnt = -1;
                break;
            }
            if(m < n)
                cnt = -1;
        }
        
        System.out.print(cnt);
    }
}
