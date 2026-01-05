import java.util.*;
import java.io.*;

class Main {
    static String[] arr;
    static int tc;
    static boolean check(int idx) {
        String fn = arr[idx];
        for(int i = idx; i < arr.length; i++) {
            if(arr[i].charAt(0) != fn.charAt(0))
                return false;
            if(fn.length() >= arr[i].length()) 
                continue;
            if(arr[i].substring(0, fn.length()).equals(fn))
                return true;
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < tc; i++) {
           int n = Integer.parseInt(br.readLine());
            arr = new String[n];
            for(int j = 0; j < n; j++)
                arr[j] = br.readLine();
        
            Arrays.sort(arr, (a, b) -> { 
                if(a.charAt(0) == b.charAt(0))
                    return a.length() - b.length();
                return a.charAt(0) - b.charAt(0);
            });
            
            boolean ch = false;
            for(int j = 0; j < n; j++) {
                if(check(j)) {
                    ch = true;
                    break;
                }
            }
            
            if(ch)
                sb.append("NO\n");
            else
                sb.append("YES\n");
        }
        
        System.out.print(sb.toString());
    }
}
