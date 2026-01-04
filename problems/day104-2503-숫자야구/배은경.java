import java.util.*;
import java.io.*;

class Main {
    static int[][] ask;
    static boolean math(int q, int n1, int n2) {
        int[] a = new int[]{n1 / 100, n1 / 10 % 10, n1 % 10};
        int[] b = new int[]{n2 / 100, n2 / 10 % 10, n2 % 10};
        int bcnt = 0;
        int scnt = 0;
        
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                if(i != j && a[i] == b[j])
                    bcnt++;
                else if(a[i] == b[j])
                    scnt++;
                    
        if(scnt == ask[q][1] && bcnt == ask[q][2])
            return true;
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int qst = Integer.parseInt(br.readLine());
        ask = new int[qst][3];
        
        StringTokenizer st;
        for (int i = 0; i < qst; i++) {
            st = new StringTokenizer(br.readLine());
            ask[i][0] = Integer.parseInt(st.nextToken());
            ask[i][1] = Integer.parseInt(st.nextToken());
            ask[i][2] = Integer.parseInt(st.nextToken());
        }
        
        int rslt = 0;
        int[] candidate = new int[1000];
        for(int i = 100; i < 1000; i++) {
            int a = i / 100;
            int b = i / 10 % 10;
            int c = i % 10;
            
            if(a != 0 && b != 0 && c != 0 && a != b && b != c && c != a) {
                boolean ch = false;
                for(int j = 0; j < qst; j++) {
                    ch = math(j, ask[j][0], i); 
                    if(ch == false)
                        break;
                }
                if(ch)  rslt++;
            }
        }
        System.out.print(rslt);
    }
}
