import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 가로
    int M = Integer.parseInt(st.nextToken()); // 세로
    int L = Integer.parseInt(st.nextToken()); // 트램펄린 한 변의 길이
    int K = Integer.parseInt(st.nextToken()); // 별똥별 수

    // 별똥별 좌표를 리스트에 저장
    List<Point> stars = new ArrayList<>();
    for(int i =0; i<K; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      stars.add(new Point(x, y));
    }

    Collections.sort(stars, (a, b) -> {
      return a.x - b.x;
    });

    // 트램펄린을 어디에 놓는게 좋을까
    int tx = 0, ty = 0;

    int max = 0;
    // 모든 별똥별 좌표의 x, y를 뽑아서 안에 들어가는지 체크
    for(Point star1: stars) {  
      for(Point star2: stars) {   
        int cnt = 0;
        tx = star1.x;
        ty = star2.y;
        for(Point star3: stars) {
          if(star3.x >= tx && star3.x <= tx + L && star3.y >= ty && star3.y <= ty + L) cnt++;
        }
        max = Math.max(max, cnt);   
      }          
    }

    bw.write(K - max + "");
    bw.flush();
    bw.close();
  }

  static class Point {
    int x, y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
  
}

