import java.util.*;
import java.io.*;
public class Main{
  static List<Point> houses = new ArrayList<>();
  static List<Point> chickens = new ArrayList<>();
  static boolean[] selected;
  static int answer = Integer.MAX_VALUE;
  static int N, M;
  static int[][] map; 
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N+1][N+1];

    for(int i =1; i<=N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j =1; j<=N; j++) {
        int num = Integer.parseInt(st.nextToken()); 
        map[i][j] = num;

        if(num == 1) houses.add(new Point(i, j));
        else if(num == 2) chickens.add(new Point(i, j));
      }
    }

    selected = new boolean[chickens.size()];
    backtracking(0, 0);
    
    bw.write(answer + "");
    bw.flush();
    bw.close();
    
  }
  static void backtracking(int start, int depth) {
    if(depth == M) {
      int cityDist = 0;
      for(Point house: houses) {
        int minDist = Integer.MAX_VALUE;
        for(int i =0; i<chickens.size(); i++) {
          if(selected[i]) {
            Point chicken = chickens.get(i);
            int dist = Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
            minDist = Math.min(dist, minDist);
          }
        }
        cityDist += minDist;
      }
      answer = Math.min(answer, cityDist);
    }

    for(int i =start; i<chickens.size(); i++) {
      selected[i] = true;
      backtracking(i + 1, depth + 1);
      selected[i] = false;
    }
  }

  static class Point {
    int x, y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}

