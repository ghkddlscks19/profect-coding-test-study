import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine());

    for(int i =0; i<T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int stick = Integer.parseInt(st.nextToken());
      int n = Integer.parseInt(st.nextToken());
      int min = 0;
      int max = 0;
      
      // 굳이 충돌 신경쓸 필요 없다
      for(int j =0; j<n; j++) {
        int pos = Integer.parseInt(br.readLine());
        int longer = Math.max(stick - pos, pos);
        int shorter = Math.min(stick - pos, pos);

        min = Math.max(min, shorter);
        max = Math.max(max, longer);
      }

      bw.write(min + " " + max + "");
      bw.newLine();
    }

    bw.flush();
    bw.close();
  }
}

