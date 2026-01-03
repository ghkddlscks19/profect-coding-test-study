import java.util.*;
import java.io.*;

class Main {
    static char[] tr;
    static char[] ab;
    static char[] db;
    static int[][][] vst;
    static int dp(int idx2, int idx1, int ch) {
        int sum = 0;
        
        if(idx1 == tr.length)
            return 1;
        if(idx2 >= ab.length)
            return 0;
        if(vst[idx2][idx1][ch] != -1)
            return vst[idx2][idx1][ch];
        
        for(int i = idx2; i < ab.length; i++)
            if(ch == 1 && ab[i] == tr[idx1]) {
                if(vst[idx2][idx1][1] == -1)
                    sum += dp(i + 1, idx1 + 1, 0);
            } else if(ch == 0 && db[i] == tr[idx1]) {
                if(vst[idx2][idx1][0] == -1)
                    sum += dp(i + 1, idx1 + 1, 1);
            }
        
        if(ch == 0) vst[idx2][idx1][0] = sum;
        if(ch == 1) vst[idx2][idx1][1] = sum;
        return sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String d = br.readLine();
        String a = br.readLine();
        
        tr = s.toCharArray();
        db = d.toCharArray();
        ab = a.toCharArray();
        vst = new int[db.length][tr.length][2];
        for (int i = 0; i < db.length; i++)
            for (int j = 0; j < tr.length; j++)
                Arrays.fill(vst[i][j], -1);
        
        int cnt = dp(0, 0, 0) + dp(0, 0, 1);
        System.out.print(cnt);
    }
}
