import java.util.*;
import java.io.*;
public class Main{
  static int A, B, answer = -1;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    A = Integer.parseInt(st.nextToken());
    B = Integer.parseInt(st.nextToken());
    
    dfs(A, 1);
    bw.write(String.valueOf(answer));
    bw.flush();
    bw.close();
    
  }

  static void dfs(long num, int count) {
    if(num > B) {
      return;
    }

    if(num == B) {
      if(answer == -1 || count < answer) {
        answer = count;
      }
      return;
    }

    dfs(num * 2, count + 1);
    dfs(num * 10 + 1, count + 1);
  }
}

