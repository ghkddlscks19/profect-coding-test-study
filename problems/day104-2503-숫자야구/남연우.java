import java.io.*;
import java.util.*;

public class Main{
  static boolean question(int a, int b, int strike, int ball) {
    int[] aArr = { a / 100, (a / 10) % 10, a % 10 };
    int[] bArr = { b / 100, (b / 10) % 10, b % 10 };

    int sCount = 0;
    int bCount = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (aArr[i] == bArr[j]) {
          if (i == j)
            sCount++;
          else {
            bCount++;
          }
        }
      }
    }

    if (sCount == strike && bCount == ball)
      return true;
    
    return false;
  }
  
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[][] answer = new int[n][3];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
        answer[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int count = 0;
    for (int i = 1; i <= 9; i++) {
      for (int j = 1; j <= 9; j++) {
        for (int k = 1; k <= 9; k++) {
          if (i != j && j != k && i != k) {
            int num = i * 100 + j * 10 + k;
            boolean isTrue = true;
            for (int q = 0; q < n; q++) {
              if (!question(num, answer[q][0], answer[q][1], answer[q][2]))
                isTrue = false;
            }
            if (isTrue)
              count++;
          }
        }
      }
    }

    System.out.println(count);
  }
}
