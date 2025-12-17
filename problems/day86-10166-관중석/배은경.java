import java.util.*;
import java.io.*;

class Main {
    static int gcd(int a, int b) {
        if(a % b == 0)
            return b;
        return gcd(b, a %  b);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
       
        int cnt = 1;
        boolean[][] ch = new boolean[2001][2001];
        for(int i = n; i <= m; i++) {
            for(int j = 0; j < i; j++) {
                if(j == 0) 
                    continue;
                int g = gcd(i, j);
                if(ch[j / g][i / g] == false){
                    ch[j / g][i / g] = true;
                    cnt++;
                }
            }
        }
        
        System.out.println(cnt);
    }
}
