import java.io.*;
import java.util.*;

public class Main {
    static boolean stop = false;
    static void dfs(int x, int y, int[][] arr, boolean[][] cr, boolean[][] gr, boolean[][] box, int cnt) {
        if(stop == true) return;
        if(cnt == 0) {
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    System.out.print(arr[i][j]);
                }
                System.out.println();
            }
            stop = true;
            return;
        }
        
        boolean fn = false;
        for(int i = x; i < 9; i++) {
            if(fn == true) break;
            for(int j = 0; j < 9; j++) {
                if(i == x && j < y) continue;
                if(arr[i][j] == 0) {
                    fn = true;
                    for(int k = 1; k < 10; k++) {
                        int idx = (i / 3) * 3 + (j / 3);
                        if(cr[i][k] == false && gr[j][k] == false && box[idx][k] == false) {
                            cr[i][k] = true; gr[j][k] = true; box[idx][k] = true;
                            arr[i][j] = k;
                            dfs(x, y + 1, arr, cr, gr, box, cnt - 1);
                            arr[i][j] = 0;
                            cr[i][k] = false; gr[j][k] = false; box[idx][k] = false;
                        }
                    }
                    break;
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[9][9];
        boolean[][] cr = new boolean[10][10];
        boolean[][] gr = new boolean[10][10];
        boolean[][] box = new boolean[9][10];
        
        int cnt = 0;
        for(int i = 0; i < 9; i++) {
            String s = br.readLine();
            for(int j = 0; j < 9; j++) {
                arr[i][j] = s.charAt(j) - '0';
                if(arr[i][j] == 0) {
                    cnt++;
                } else {
                    int idx = (i / 3) * 3 + (j / 3);
                    cr[i][arr[i][j]] = true;
                    gr[j][arr[i][j]] = true;
                    box[idx][arr[i][j]] = true;
                }
            }
        }
        
        dfs(0, 0, arr, cr, gr, box, cnt);
    }
}
