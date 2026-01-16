import java.io.*;
import java.util.*;

public class Main{
  static int[][] sudoku;
  static List<int[]> blanks;

  static void dfs(int idx) {
    if (idx == blanks.size()) {
      for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
          System.out.print(sudoku[i][j]);
        }
        System.out.println();
      }
      System.exit(0);
    }

    int[] cur = blanks.get(idx);
    int r = cur[0];
    int c = cur[1];

    for (int i = 1; i <= 9; i++) {
      if (check(r, c, i)) {
        sudoku[r][c] = i;
        dfs(idx + 1);
        sudoku[r][c] = 0;
      }
    }
  }

  static boolean check(int r, int c, int num) {
    for (int i = 0; i < 9; i++) {
      if (sudoku[r][i] == num)
        return false;
      
      if (sudoku[i][c] == num)
        return false;
    }

    int startRow = (r / 3) * 3;
    int startCol = (c / 3) * 3;

    for (int i = startRow; i < startRow + 3; i++) {
      for (int j = startCol; j < startCol + 3; j++) {
        if (sudoku[i][j] == num) {
          return false;
        }
      }
    }
    
    return true;
  }
  
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    sudoku = new int[9][9];
    blanks = new ArrayList<>();

    for (int i = 0; i < 9; i++) {
      String line = br.readLine();
      for (int j = 0; j < 9; j++) {
        sudoku[i][j] = line.charAt(j) - '0';
        if (sudoku[i][j] == 0) {
          blanks.add(new int[] {i, j});
        }
      }
    }

    dfs(0);
  }
}
