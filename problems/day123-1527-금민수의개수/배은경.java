import java.io.*;
import java.util.*;

public class Main {
    static long n, m;
    static int cnt = 0;
    static void check(long k) {
        if(k > m)
            return;
        if(k >= n && k <= m)
            cnt++;
        check(k * 10 + 4);
        check(k * 10 + 7);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        m = Long.parseLong(st.nextToken());
        
        check(4);
        check(7);
        System.out.print(cnt);
    }
}
