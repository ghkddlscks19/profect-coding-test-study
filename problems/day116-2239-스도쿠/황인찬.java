import java.util.*;
import java.io.*;
public class Main {
  static int[][] sudoku;
  static List<Point> zeros = new ArrayList<>();
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    sudoku = new int[9][9];

    for(int i =0; i<9; i++) {
      String line = br.readLine();
      for(int j=0; j<9; j++) {
        int num = line.charAt(j) - '0';
        sudoku[i][j] = num;

        if(num == 0) zeros.add(new Point(i, j));
      }
    }

    dfs(0);

  }

  static void dfs(int depth) {
    if(depth == zeros.size()) {
      StringBuilder sb = new StringBuilder();
      for(int i =0; i<9; i++) {
        for(int j =0; j<9; j++) {
          sb.append(sudoku[i][j]);
        }
        sb.append("\n");
      }

      System.out.print(sb);
      System.exit(0); // 하나 찾으면 바로 종료
    }

    Point zero = zeros.get(depth);
    int x = zero.x;
    int y = zero.y;

    for(int i =1; i<=9; i++) {
      if(isValid(x, y, i)) {
        sudoku[x][y] = i;
        dfs(depth + 1);
        sudoku[x][y] = 0;
      }
    }
  }

  static boolean isValid(int x, int y, int num) {
    // 가로
    for(int i =0; i<9; i++) {
      if(num == sudoku[x][i]) return false;
    }

    // 세로
    for(int i =0; i<9; i++) {
      if(num == sudoku[i][y]) return false;
    }
    
    // 3*3
    int startX = (x / 3) * 3;
    int startY = (y / 3) * 3;

    for(int i =startX; i<startX+3; i++) {
      for(int j =startY; j<startY+3; j++) {
        if(sudoku[i][j] == num) return false;
      }
    }


    return true;
  }

  static class Point {
    int x, y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}

