import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 신호등 개수
    int K = Integer.parseInt(st.nextToken()); // 연속 k개
    int B = Integer.parseInt(st.nextToken()); // 고장난 신호등 개수

    boolean[] isBreak = new boolean[N+1];

    for(int i =1; i<=B; i++) {
      int n = Integer.parseInt(br.readLine());
      isBreak[n] = true;
    }

    int count = 0;

    // 초기 값 설정
    for(int i =1; i<=K; i++) {
      if(isBreak[i]) count++;
    }

    int min = count;

    // 앞에부터 하나씩 빠짐
    for(int i =1; i<=N-K; i++) {
      // 빠지는 신호등이 고장난 것이었다면
      if(isBreak[i]) count--;

      // 들어오는 신호등이 고장난 것이었다면
      if(isBreak[i+K]) count++;

      min = Math.min(min, count);
    }

    bw.write(String.valueOf(min));
    bw.flush();
    bw.close();
    
  }
}

