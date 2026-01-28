import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    long[] t = new long[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i =0; i<N; i++) {
      t[i] = Long.parseLong(st.nextToken());
    }

    Arrays.sort(t);

    // 짝수면 근손실 (0 + N-1), (1 + N-2) ...
    // 홀수면 근손실 (N-1), (0 + N-2), (1 + N-3) ... 
    long max = 0;
    
    if(N % 2 == 0) {
      for(int i =0; i<N/2; i++) {
        long sum = t[i] + t[N-1-i];
        max = Math.max(sum, max);
      }
    } else {  
      max = t[N-1];
      for(int i =0; i<N/2; i++) {
        long sum = t[i] + t[N-2-i];
        max = Math.max(sum, max);
      }
    }
    bw.write(max + "");
    bw.flush();
    bw.close();
  }
}

