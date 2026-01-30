import java.io.*;
import java.util.*;

public class Main {
    static int calc(String s) {
        int sum = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c >= '0' && c <= '9')
                sum += c - '0';
        }
        return sum;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i = 0; i < n; i++)
            arr[i] = br.readLine();
        
        Arrays.sort(arr, (a, b) -> {
            if(a.length() == b.length()) {
                int r1 = calc(a);
                int r2 = calc(b);
                if(r1 == r2) {
                    int idx = 0;
                    while(idx + 1 < a.length() && a.charAt(idx) == b.charAt(idx))
                        idx++;
                    return a.charAt(idx) - b.charAt(idx);
                }
                return r1 - r2;
            }
            return a.length() - b.length();
        });
        
        for(int i = 0; i < n; i++) 
            System.out.println(arr[i]);
    }
}
