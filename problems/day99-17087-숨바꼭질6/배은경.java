import java.util.*;
import java.io.*;

class Main {

    static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] sp = new int[n];

        for (int i = 0; i < n; i++)
            sp[i] = Math.abs(Integer.parseInt(st.nextToken()) - s);

        int rslt = sp[0];
        for (int i = 1; i < n; i++)
            rslt = gcd(rslt, sp[i]);

        System.out.print(rslt);
    }
}
