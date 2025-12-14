import java.util.*;
import java.io.*;
public class Main{
  static char[][] field;
  static boolean[][] visited;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  static class Point {
    int x, y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
  
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 필드 입력
    field = new char[12][6];
    for(int i =0; i<12; i++) {
      String line = br.readLine();
      for(int j =0; j<6; j++) {
        field[i][j] = line.charAt(j);
      }
    }

    int answer = 0;

    while(true) {
      boolean popped = false;
      visited = new boolean[12][6];

      // 모든 칸에서 전부 bfs로 연결된 뿌요 찾기
      for(int i =0; i<12; i++) {
        for(int j =0; j<6; j++) {
          if(!visited[i][j] && field[i][j] != '.') {
            List<Point> group = bfs(i, j);
            
            // 4개 이상이면 터트리기
            if(group.size() >= 4) {
              popped = true;

              for(Point p: group) {
                field[p.x][p.y] = '.';
              }
            }
          }
        }
      }

      // 터진게 없으면 종료
      if(!popped) break;

      // 연쇄 증가
      answer++;

      // 중력 적용
      gravity();
    }

    bw.write(answer + "");
    bw.flush();
    bw.close();
    
  }

  // 4개 이상 뭉쳐있는지를 확인하기 위함
  static List<Point> bfs(int x, int y) {
    Deque<Point> q = new ArrayDeque<>();
    List<Point> group = new ArrayList<>();

    char color = field[x][y];
    visited[x][y] = true;
    q.offer(new Point(x, y));
    group.add(new Point(x, y));

    while(!q.isEmpty()) {
      Point curr = q.poll();

      for(int i =0; i<4; i++) {
        int nx = curr.x + dx[i];
        int ny = curr.y + dy[i];

        // 범위 초과
        if(nx < 0 || nx >=12 || ny < 0 || ny >= 6) continue;

        // 방문 했거나 색이 다른 경우
        if(visited[nx][ny] || color != field[nx][ny]) continue;

        visited[nx][ny] = true;
        q.offer(new Point(nx, ny));
        group.add(new Point(nx, ny));
        
      }
    }

    return group;
    
  }

  // 중력 적용
  static void gravity() {
    for(int j =0; j<6; j++) {
      int bottom = 11;
      for(int i =11; i>=0; i--) {
        if(field[i][j] != '.') {
          if(i != bottom) {
            field[bottom][j] = field[i][j];
            field[i][j] = '.';
          }
          bottom--;
        }
      }

    }
  }
}

