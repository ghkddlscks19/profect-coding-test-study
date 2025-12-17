import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int D1 = Integer.parseInt(st.nextToken());
    int D2 = Integer.parseInt(st.nextToken());

    boolean[][] visited = new boolean[2001][2001];
    // 각도가 같으면 가려져 있다
    // 0/3, 1/3, 2/3
    // 0/4, 1/4, 2/4, 3/4
    // 0/5, 1/5, 2/5, 3/5, 4/5
    // 0/6, 1/6, 2/6, 3/6, 4/6, 5/6
    // 같은 기약분수끼리는 겹침 안겹치는거 세면 정답

    int answer = 0;
    for(int i =D1; i<=D2; i++) {
      for(int j =0; j<i; j++) {
        // 최대 공약수로 나눠줘야 기약분수가 됨
        int gcd = gcd(i, j);
        int bunja = j / gcd;
        int bunmo = i / gcd;

        if(!visited[bunmo][bunja]) {
            visited[bunmo][bunja] = true;
            answer++;
        }
      }
    }

    bw.write(answer + "");
    bw.flush();
    bw.close();
    
  }
  
  static int gcd(int a, int b) {
    if(b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }
}

