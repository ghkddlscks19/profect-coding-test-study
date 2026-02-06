import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    long N = Long.parseLong(st.nextToken());
    long L = Long.parseLong(st.nextToken());
    long W = Long.parseLong(st.nextToken());
    long H = Long.parseLong(st.nextToken());

    // 0과 가장 짧은 변 하나를 기준으로 두고 이분탐색 진행
    double left = 0;
    double right = Math.min(L, Math.min(W, H));

    // 실수 이분탐색은 오차 범위를 좁히기 위해 for문으로 횟수를 정하는 것이 안전                                                                                                                                                                                                                                                                                                                                                          
    for(int i =0; i<100; i++) {
      double mid = (left + right) / 2;
      long count = (long)(L / mid) * (long)(W / mid) * (long)(H / mid);

      if(count >= N) {
        left = mid;
      } else {
        right = mid;
      }
    }

    bw.write(left + "");
    bw.flush();
    bw.close();
  }
}

