import java.io.*;
import java.util.*;

public class Main {
    static char[] arr;
    static Set<String> set = new HashSet<>();
    static void dfs(String ns, boolean[] vst) {
        if(ns.length() == arr.length)
            set.add(ns);
        
        for(int i = 0; i < arr.length; i++) {
            if(vst[i] == false && arr[i] != ns.charAt(ns.length() - 1)) {
                vst[i] = true;
                dfs(ns + arr[i], vst);
                vst[i] = false;
            }
        }
        return;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        arr = s.toCharArray();
        int[] alpha = new int[26];
        boolean ch = false;
        for(int i = 0; i < arr.length; i++) {
            int k = arr[i] - 'a';
            alpha[k]++;
            if(alpha[k] > 1)
                ch = true;
        }
        if(ch == false) {
            int rslt = 1;
            for(int i = arr.length; i > 1; i--)
                rslt *= i;
            System.out.println(rslt);
            return;
        }
        
        boolean[] vst = new boolean[s.length()];
        for(int i = 0; i < s.length(); i++) {
            vst[i] = true;
            dfs(String.valueOf(arr[i]), vst);
            vst[i] = false;
        }   
        
        System.out.println(set.size());
    }
}
