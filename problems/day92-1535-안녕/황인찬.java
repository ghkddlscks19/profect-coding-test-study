import java.util.*;
import java.io.*;
public class Main{
  static int N;
  static int[] hp, happy;
  static int maxHappy = 0;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());
    hp = new int[N];
    happy = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i =0; i<N; i++) {
      hp[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for(int i =0; i<N; i++) {
      happy[i] = Integer.parseInt(st.nextToken());
    }

    dfs(0, 100, 0);

    bw.write(maxHappy + "");
    bw.flush();
    bw.close();
  }

  static void dfs(int idx, int currHp, int currHappy) {
    // 끝까지 돌았으면 최대 기쁨 갱신 후 리턴
    if(idx == N) {
      maxHappy = Math.max(maxHappy, currHappy);
      return;
    }
    // 현재 사람 선택 안함
    dfs(idx + 1, currHp, currHappy);

    // 체력이 남으면 현재 사람 선택
    if(currHp - hp[idx] > 0) {
      dfs(idx + 1, currHp - hp[idx], currHappy + happy[idx]);    
    }    
  }
}

