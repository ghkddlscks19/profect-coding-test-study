import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    long N = Long.parseLong(br.readLine());
    long answer = 0;
    long pow = 1;

    while(N > 0) {
      // 2진수로 봤을 때 현재 자리가 1이면 해당 자리의 3의 거듭제곱을 더함
      if(N % 2 == 1) {
        answer += pow;
      }     

      N /= 2;
      pow *= 3;
    }

    bw.write(answer + "");
    bw.flush();
    bw.close();
  }
}

