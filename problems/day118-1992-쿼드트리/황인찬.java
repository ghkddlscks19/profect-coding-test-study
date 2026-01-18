import java.util.*;
import java.io.*;
public class Main{
  static int[][] board;
  static StringBuilder sb = new StringBuilder();
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    board = new int[N][N];

    for(int i =0; i<N; i++) {
      String line = br.readLine();
      for(int j =0; j<N; j++) {
        board[i][j] = line.charAt(j) - '0';
      }
    }
    
    dfs(0, 0, N);
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  static void dfs(int x, int y, int size) {
    // size 내 모두 같은 색이면
    if(sameColor(x, y, size)) {
      sb.append(board[x][y]);
      return;
    }

    // 4개의 영역으로 분할해서 확인
    int newSize = size / 2;
    sb.append('(');
    dfs(x, y, newSize); // 왼쪽 위
    dfs(x, y + newSize, newSize); // 오른쪽 위
    dfs(x + newSize, y, newSize); // 왼쪽 아래
    dfs(x + newSize, y + newSize, newSize); // 오른쪽 아래
    sb.append(')');
  }

  static boolean sameColor(int x, int y, int size) {
    int color = board[x][y];
    
    for(int i =x; i<x+size; i++) {
      for(int j=y; j<y+size; j++) {
        if(board[i][j] != color) return false;
      }
    }

    return true;
  }
}

