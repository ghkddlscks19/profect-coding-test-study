import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int S = Integer.parseInt(st.nextToken());

    // 내 위치와 동생들 위치의 차이를 구해서 그 값들의 최대 공약수를 구한다
    st = new StringTokenizer(br.readLine());
    int[] diff = new int[N];
    for(int i =0; i<N; i++) {
      int bro = Integer.parseInt(st.nextToken());
      diff[i] = Math.abs(bro - S); 
    }

    int answer = diff[0];
    for(int i =1; i<N; i++) {
      answer = gcd(answer, diff[i]);
    }

    bw.write(answer + "");
    bw.flush();
    bw.close();
  }

  static int gcd(int a, int b) {
    if(b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }
}

