import java.io.*;
import java.util.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] A = new int[N];
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(A);

    int count = 0;
    for (int i = 0; i < N; i++) {
      int left = i + 1;
      int right = N - 1;
      while (left < right) {
        int sum = A[i] + A[left] + A[right];
        
        if (sum == 0) {
          if (A[left] == A[right]) {
            int cnt = right - left + 1;
            count += cnt * (cnt - 1) / 2;
            break;
          }

          int lVal = A[left];
          int rVal = A[right];
          int lCnt = 0;
          int rCnt = 0;

          while (left < right && A[left] == lVal) {
            lCnt++;
            left++;
          }
          while (left <= right && A[right] == rVal) {
            rCnt++;
            right--;
          }

          count += lCnt * rCnt;
        }
          
        else if (sum > 0)
          right--;
        else
          left++;
      }
    }

    System.out.println(count);
  }
}
