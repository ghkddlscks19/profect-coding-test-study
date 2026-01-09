import java.util.*;
import java.io.*;

public class Main {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    int[] score = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      score[i] = Integer.parseInt(st.nextToken());
    }

    // 오름차순 정렬
    Arrays.sort(score);

    long answer = 0;

    // 투 포인터 탐색
    for (int i = 0; i < N; i++) {
      if (score[i] > 0) break;

      int left = i + 1;
      int right = N - 1;
      int target = -score[i]; 

      while (left < right) {
        int sum = score[left] + score[right]; 

        if (sum < target) {
          left++;
        } else if (sum > target) {
          right--;
        } else {
          // 합이 0이 되는 경우 (sum == target)

          // 두 수가 같은 경우
          if (score[left] == score[right]) { 
            int count = right - left + 1;
            answer += (long) count * (count - 1) / 2;
            break;
          }
          // 두 수가 다른 경우
          else {
            int lCnt = 1;
            int rCnt = 1;

            // 왼쪽 중복 개수 세기
            while (left + 1 < right && score[left] == score[left + 1]) {
              lCnt++;
              left++;
            }
            // 오른쪽 중복 개수 세기
            while (left < right - 1 && score[right] == score[right - 1]) { // [수정] arr -> score
              rCnt++;
              right--;
            }

            answer += (long) lCnt * rCnt;
            left++;
            right--;
          }
        }
      }
    }

    bw.write(String.valueOf(answer));
    bw.flush();
    bw.close();
  }
}
