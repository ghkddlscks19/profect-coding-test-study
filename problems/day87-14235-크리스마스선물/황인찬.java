import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    for(int i =0; i<N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      
      if(a == 0) {
        // pq가 비어있다면 -1
        if(pq.isEmpty()) {
          bw.write("-1");
        } else {
          bw.write(pq.poll() + "");
        }
        bw.newLine();
      } else {
        for(int j =0; j<a; j++) {
          pq.offer(Integer.parseInt(st.nextToken()));
        }
      }
    }

    bw.flush();
    bw.close();
  }
}

