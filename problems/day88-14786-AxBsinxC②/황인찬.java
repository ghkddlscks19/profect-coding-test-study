import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());

    // Ax + Bsin(x) = C
    // 이분 탐색으로 범위를 좁혀가면서 값을 찾아낸다

    double left = 0;
    double right = 200000;
    while(right - left > 0.000000001) {
      double mid = (left + right) / 2;
      double value = A * mid + B * Math.sin(mid);
      if(value < C) {
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

