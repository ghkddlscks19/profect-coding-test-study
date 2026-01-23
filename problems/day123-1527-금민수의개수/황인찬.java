import java.util.*;
import java.io.*;
public class Main{
  static int count = 0;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());

    dfs(4, A, B);
    dfs(7, A, B);
    
    bw.write(String.valueOf(count));
    bw.flush();
    bw.close();
  }

  static void dfs(long n, int A, int B) {
    if(n > B) {
      return;
    }

    if(n >= A) {
      count++;
    }
    
    dfs(n * 10 + 4, A, B); // 4 붙이기
    dfs(n * 10 + 7, A, B); // 7 붙이기
  }
}

