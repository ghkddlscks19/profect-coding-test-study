import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    int[] stat = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    
    for(int i =0; i<N; i++) {
      stat[i] = Integer.parseInt(st.nextToken());
    }

    int max = 0;

    int left = 0;
    int right = N-1;

    while(left < right) {
      int curr = (right - left - 1) * Math.min(stat[left], stat[right]);
      max = Math.max(max, curr);

      if(stat[left] < stat[right]) {
        left++;
      } else {
        right--;
      }
    }

    bw.write(max + "");
    bw.flush();
    bw.close();
  }
}

