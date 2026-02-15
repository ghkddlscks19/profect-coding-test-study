import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int[] num = new int[N];
    long sum = 0;
    // 빈도 체크를 위한 배열 -4000 ~ 4000
    int[] count = new int[8001];
    int maxCount = 0;
    
    for(int i =0; i<N; i++) {
      num[i] = Integer.parseInt(br.readLine());
      sum += num[i];
      count[num[i] + 4000]++;
      maxCount = Math.max(maxCount, count[num[i] + 4000]);
    }

    // 계산을 위해 정렬
    Arrays.sort(num);

    // 산술 평균
    int avg = (int) Math.round((double) sum / N);

    // 중앙값
    int med = num[N/2];

    // 최빈값
    int modeCount = 0;
    int mode = 0;
    for(int i =0; i<count.length; i++) {
      if(count[i] == maxCount) {
        mode = i - 4000;
        modeCount++;

        if(modeCount == 2) break;
      }
    }

    // 범위
    int range = num[N-1] - num[0];

    bw.write(avg + "\n" + med + "\n" + mode + "\n" + range);
    bw.flush();
    bw.close();
  }
}

