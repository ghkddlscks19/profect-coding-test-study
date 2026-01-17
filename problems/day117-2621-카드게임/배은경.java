import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] col = new char[5];
        int[] num = new int[5];
        int[] cnt = new int[10];

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            col[i] = st.nextToken().charAt(0);
            num[i] = Integer.parseInt(st.nextToken());
            cnt[num[i]]++;
        }

        boolean flush = true;
        for (int i = 1; i < 5; i++) {
            if (col[i] != col[0]) {
                flush = false;
                break;
            }
        }
        Arrays.sort(num);

        boolean straight = true;
        for (int i = 1; i < 5; i++) {
            if (num[i] != num[0] + i) {
                straight = false;
                break;
            }
        }

        int four = 0;
        int three = 0;
        int[] pairs = new int[2];
        int pCnt = 0;
        for (int v = 1; v <= 9; v++) {
            if (cnt[v] == 4) four = v;
            else if (cnt[v] == 3) three = v;
            else if (cnt[v] == 2) pairs[pCnt++] = v;
        }

        int ans = 0;
        if (flush && straight) {
            ans = 900 + num[4];
        } else if (four != 0) {
            ans = 800 + four;
        } else if (three != 0 && pCnt == 1) {
            ans = 700 + three * 10 + pairs[0];
        } else if (flush) {
            ans = 600 + num[4];
        } else if (straight) {
            ans = 500 + num[4];
        } else if (three != 0) {
            ans = 400 + three;
        } else if (pCnt == 2) {
            int hi = Math.max(pairs[0], pairs[1]);
            int lo = Math.min(pairs[0], pairs[1]);
            ans = 300 + hi * 10 + lo;
        } else if (pCnt == 1) {
            ans = 200 + pairs[0];
        } else {
            ans = 100 + num[4];
        }

        System.out.print(ans);
    }
}
