import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 메모리 제한이 있어서 비트를 사용해야함 -> 처음 안 사실
    BitSet bs = new BitSet(33554432);

    StringTokenizer st = new StringTokenizer(br.readLine());

    while(st.hasMoreTokens()) {
      int num = Integer.parseInt(st.nextToken());

      // 처음 나온 숫자라면
      if(!bs.get(num)) {
        bs.set(num);
        bw.write(num + " ");
      }
      
    }

    bw.flush();
    bw.close();
  }
}

