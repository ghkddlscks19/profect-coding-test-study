import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine());

    for(int i =0; i<T; i++) {
      int N = Integer.parseInt(br.readLine());

      // 2부터 시작해서 나눠보기
      for(int j =2; j*j<=N; j++) {
        int cnt = 0;

        // 소인수 분해가 가능하면 횟수 추가 및 나눠주기
        while(N % j == 0) {
          cnt++;
          N /= j;
        }

        if(cnt > 0) {
          bw.write(j + " " + cnt + "\n");
        }
      }

      // 마지막 남은 수 처리
      if(N > 1) {
        bw.write(N + " " + 1 + "\n");
      }
    }

    bw.flush();
    bw.close();
  }
}

