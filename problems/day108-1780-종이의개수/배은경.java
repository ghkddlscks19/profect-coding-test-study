import java.io.*;
import java.util.*;

public class Main {
    static int[] rslt;
    static int[][] arr;
    static void check(int x, int y, int size) {
        boolean ch = true;
        int std = arr[x][y];
        
        for(int i = x; i < x + size; i++)
            for(int j = y; j < y + size; j++)
                if(arr[i][j] != std){
                    ch = false;
                    break;
                }
        
        if(ch == true) {
            rslt[std + 1]++;
            return;
        }
        
        size /= 3;
        for(int i = x; i < x + size * 3; i += size)
            for(int j = y; j < y + size * 3; j += size)
                check(i, j, size);
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        rslt = new int[3];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        
        check(0, 0, n);
        for(int i = 0; i < 3; i++)
            System.out.println(rslt[i]);
    }
}
