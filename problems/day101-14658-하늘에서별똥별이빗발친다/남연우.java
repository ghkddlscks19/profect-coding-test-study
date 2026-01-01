import java.io.*;
import java.util.*;

public class Main{
  static class Star {
    int x;
    int y;
  }
  
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    Star[] stars = new Star[K];

    for (int i = 0; i < K; i++) {
        st = new StringTokenizer(br.readLine());
        stars[i] = new Star();
        stars[i].x = Integer.parseInt(st.nextToken());
        stars[i].y = Integer.parseInt(st.nextToken());
    }

    int max = 0;
    
    for (int i = 0; i < K; i++) {
        for (int j = 0; j < K; j++) {
            int startX = stars[i].x;
            int startY = stars[j].y;
    
            int cnt = 0;
            for (int k = 0; k < K; k++) {
                if (stars[k].x >= startX && stars[k].x <= startX + L &&
                    stars[k].y >= startY && stars[k].y <= startY + L) {
                    cnt++;
                }
            }
    
            max = Math.max(max, cnt);
        }
    }

    System.out.println(K - max);
  }
}
