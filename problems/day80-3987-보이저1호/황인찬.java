import java.util.*;
import java.io.*;
public class Main{
  static char[][] map;
  static boolean[][][] visited;
  static int[] dx = {-1, 0, 1, 0}; // U R D L
  static int[] dy = {0, 1, 0, -1};
  static int N, M;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new char[N][M];
    
    // map 생성
    for(int i =0; i<N; i++) {
      String input = br.readLine();
      for(int j =0; j<M; j++) {
        map[i][j] = input.charAt(j);
      }
    }

    // 시작 위치
    st = new StringTokenizer(br.readLine());
    int startX = Integer.parseInt(st.nextToken()) - 1;
    int startY = Integer.parseInt(st.nextToken()) - 1;

    int maxTime = 0;
    int maxDir = 0;
    String[] dir = {"U", "R", "D", "L"};
    
    // 4방향으로 쏘기
    for(int i =0; i<4; i++) {
      int time = signal(startX, startY, i);

      // 무한 루프일 때
      if(time == Integer.MAX_VALUE) {
        bw.write(dir[i] + "\n");
        bw.write("Voyager");
        bw.flush();
        bw.close();
        return;
      }

      if(time > maxTime) {
        maxTime = time;
        maxDir = i;
      }
    } 

    bw.write(dir[maxDir] + "\n");
    bw.write(maxTime + "");
    bw.flush();
    bw.close();
  }

  static int signal(int x, int y, int direction) {
    visited = new boolean[N][M][4];
    int time = 0;

    while(true) {
      if(visited[x][y][direction]) {
        return Integer.MAX_VALUE; // 방문한 곳을 또 방문하면 무한 루프
      }

      // 방문 처리
      visited[x][y][direction] = true;

      // 다음 좌표
      int nx = x + dx[direction];
      int ny = y + dy[direction];
      time++;

      // 범위 밖으로 벗어나면 종료
      if(nx < 0 || nx >= N || ny < 0 || ny >= M) return time;

      // 블랙홀 만나면 종료
      if(map[nx][ny] == 'C') return time;

      // /: U -> R, R -> U, D -> L, L -> D  
      if(map[nx][ny] == '/') {
        if(direction == 0) direction = 1;
        else if(direction == 1) direction = 0;
        else if(direction == 2) direction = 3;
        else if(direction == 3) direction = 2;
      }

      // \: U -> L, R -> D, D -> R, L -> U
      if(map[nx][ny] == '\\') {
        if(direction == 0) direction = 3;
        else if(direction == 1) direction = 2;
        else if(direction == 2) direction = 1;
        else if(direction == 3) direction = 0;
      }

      // 좌표 업데이트
      x = nx;
      y = ny;
    }
  }
}

