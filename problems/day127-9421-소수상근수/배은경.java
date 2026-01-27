import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static boolean[] arr;
    static int[] rslt;
    static void check(int n) {
        for(int i = 2; i <= Math.sqrt(n); i++) {
            int a = 2;
            while(arr[i] == false && a * i <= n)
                arr[a++* i] = true; 
        }
        
        return;
    }
    
    static int calc(int n) {
        if(n == 1)
            return 1;
        if(rslt[n] != -1)
            return rslt[n];
        
        rslt[n] = 0;
        String s = String.valueOf(n);
        int sum = 0;
        int num = n;
        for(int i = 0; i < s.length(); i++) {
            int a = num % 10;
            sum += a * a;
            num /= 10;
        }
        rslt[n] = calc(sum);
        
        return rslt[n];
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        arr = new boolean[n + 1];
        rslt = new int[10000001];
        check(n);
        
        Arrays.fill(rslt, -1);
        for(int i = 2; i <= n; i++)
            if(!arr[i])
                if(calc(i) == 1)
                    sb.append(i + "\n");
        
        System.out.print(sb.toString());
    }
}
