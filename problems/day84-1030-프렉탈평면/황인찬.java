import java.util.*;
import java.io.*;
public class Main{
  static int s, N, K;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    s = Integer.parseInt(st.nextToken()); // 시간
    N = Integer.parseInt(st.nextToken()); // N*N 크기로 분할
    K = Integer.parseInt(st.nextToken()); // 가운데 K*K 정사각형이 검정색
    int R1 = Integer.parseInt(st.nextToken()); // 출력 행 시작
    int R2 = Integer.parseInt(st.nextToken()); // 출력 행 끝
    int C1 = Integer.parseInt(st.nextToken()); // 출력 열 시작
    int C2 = Integer.parseInt(st.nextToken()); // 출력 열 끝

    // 전체 길이는 N의 s승
    int size = 1;
    for(int i =0; i<s; i++) {
      size *= N;
    }

    StringBuilder sb = new StringBuilder();

    // 출력 범위 내에서 답 구하기
    for(int i =R1; i<=R2; i++) {
      for(int j=C1; j<=C2; j++) {
        sb.append(dfs(size, i, j));
      }
      sb.append("\n");
    }

    bw.write(sb.toString());
    bw.flush();
    bw.close();
    
  }

  static int dfs(int len, int r, int c) {
    // 더이상 쪼갤 수 없을 때
    if(len == 1) {
      return 0;
    }

    // 현재 격자를 N등분 했을 때 한칸의 크기
    int size = len / N;

    // 현재 좌표가 어떤 곳에 속하는지 구하기
    int row = r / size;
    int col = c / size;

    // 가운데 검정색 영역 범위 계산
    int start = (N - K) / 2;
    int end = (N + K) / 2;

    // 현재 좌표가 가운데 검정색인지 체크
    if(row >= start && row < end && col >= start && col < end) {
      return 1;
    }

    // 가운데가 아니면 재귀 ㅌ캄색
    return dfs(size, r % size, c % size);
  }
}

