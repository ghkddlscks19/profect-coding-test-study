import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    // 평론가 수 - 최대 공약수가 정답
    int gcd = gcd(N, M);

    bw.write(M - gcd + "");
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

