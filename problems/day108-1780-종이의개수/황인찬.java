import java.util.*;
import java.io.*;
public class Main{
  static int[] count = new int[3]; 
  static int[][] paper;
  
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    paper = new int[N][N];
    
    for(int i =0; i<N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      for(int j =0; j<N; j++) {
        paper[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dfs(0, 0, N);

    for(int c: count) {
      bw.write(c + "");
      bw.newLine();
    }

    bw.flush();
    bw.close();
  }

  static void dfs(int x, int y, int size) {
    int num = paper[x][y];
    boolean same = true;

    for(int i =x; i<x+size; i++) {
      for(int j =y; j<y+size; j++) {
        // 종이가 모두 같은 수가 아니라면 종료
        if(paper[i][j] != num) {
          same = false;
          break;
        }
      }
      if(!same) break;
    }

    // 모든 종이가 같다면
    if(same) {
      count[num+1]++;
      return;
    }

    int divideSize = size / 3;
    for(int i =0; i<3; i++) {
      for(int j =0; j<3; j++) {
        dfs(x + i * divideSize, y + j * divideSize, divideSize);
      }
    }
    
  }
}

