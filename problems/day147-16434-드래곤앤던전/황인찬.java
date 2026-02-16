import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    long atk = Long.parseLong(st.nextToken());

    long[] t = new long[N+1];
    long[] a = new long[N+1];
    long[] h = new long[N+1];
    for(int i =0; i<N; i++) {
      st = new StringTokenizer(br.readLine());  
      t[i] = Long.parseLong(st.nextToken());
      a[i] = Long.parseLong(st.nextToken());
      h[i] = Long.parseLong(st.nextToken());
    }

    // 이분탐색으로 최대 체력 구하기
    long left = 1;
    long right = 1_000_000_000_000_000_000L;
    long result = right;

    while(left <= right) {
      long mid = (left + right) / 2;

      // 스테이지를 깰 수 있는 체력일 때
      if(clearStage(mid, atk, N, t, a, h)) {
        result = mid;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    bw.write(result + "");
    bw.flush();
    bw.close();
  }

  static boolean clearStage(long maxHp, long atk, int N, long[] t, long[] a, long[] h) {
    long currHp = maxHp;
    long currAtk = atk;

    for(int i =0; i<N; i++) {
      // 몬스터가 있는 방일 때
      if(t[i] == 1) {
        long cnt = (h[i] + currAtk - 1) / currAtk;
        long damageCnt = cnt - 1;

        // 남은 체력보다 데미지가 큰지 확인
        if(currHp / a[i] < damageCnt) return false;

        currHp -= damageCnt * a[i];
        if(currHp <= 0) return false;
      } else { // 포션 있는 방
        currAtk += a[i];
        currHp = Math.min(currHp + h[i], maxHp);
      }
    }

    return true;
  }
}

