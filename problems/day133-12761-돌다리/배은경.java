import java.io.*;
import java.util.*;

public class Main {
    static int n, m, a, b;
    static int min;
    static boolean[] vst;

    static void bfs() {
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{n, 0});
        vst[n] = true;

        while (!que.isEmpty()) {
            int[] q = que.poll();
            if (q[0] == m) {
                min = q[1];
                return;
            }

            int[] nq = {q[0] + 1, q[0] - 1, q[0] + a, q[0] - a, q[0] + b, q[0] - b, q[0] * a, q[0] * b};
            for (int i = 0; i < 8; i++) {
                if (nq[i] < 0 || nq[i] > 100000) 
                    continue;
                if (vst[nq[i]]) 
                    continue;

                vst[nq[i]] = true;
                que.offer(new int[]{nq[i], q[1] + 1});
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        vst = new boolean[100001];
        bfs();

        System.out.print(min);
    }
}
