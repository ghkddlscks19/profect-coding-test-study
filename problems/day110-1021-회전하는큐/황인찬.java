import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    
    LinkedList<Integer> deque = new LinkedList<>();

    // 수 다 넣기
    for(int i =1; i<=N; i++) {
      deque.offer(i);
    }

    st = new StringTokenizer(br.readLine());
    int count = 0;
    
    for(int i =0; i<M; i++) {
      int num = Integer.parseInt(st.nextToken());
      int index = deque.indexOf(num);

      // 맨앞이면 뽑기
      if(index == 0) deque.pollFirst();
      else if(index <= deque.size() / 2) {
        // 왼쪽 회전
        while(deque.peekFirst() != num) {
          deque.offerLast(deque.pollFirst());
          count++;
        }
        deque.pollFirst();
      } else {
        // 오른쪽 회전
        while(deque.peekFirst() != num) {
          deque.offerFirst(deque.pollLast());
          count++;
        }
        deque.pollFirst();
      }
    }

    bw.write(String.valueOf(count));
    bw.flush();
    bw.close();
  }
}

