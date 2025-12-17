import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    List<Integer> crane = new ArrayList<>();
    for(int i =0; i<N; i++) {
      crane.add(Integer.parseInt(st.nextToken()));
    }
    int M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    List<Integer> box = new ArrayList<>();
    for(int i =0; i<M; i++) {
      box.add(Integer.parseInt(st.nextToken()));
    }

    Collections.sort(crane, Collections.reverseOrder());
    Collections.sort(box, Collections.reverseOrder());

    // 제일 큰 크레인이 제일 무거운 박스 못들면 -1
    if(crane.get(0) < box.get(0)) {
      bw.write("-1");
      bw.flush();
      bw.close();
      return;
    }
    
    int time = 0;
    while(!box.isEmpty()) {
      time++;
      int boxIdx = 0;

      for(int i =0; i<N; i++) {
        // 현재 박스가 박스 크기를 넘어서면 안됨
        if(boxIdx >= box.size()) break;

        // 박스 들기
        while(boxIdx < box.size()) {
          if(crane.get(i) >= box.get(boxIdx)) {
            box.remove(boxIdx);
            break;
          }
          boxIdx++;
        }
      }
      
    }

    bw.write(time + "");
    bw.flush();
    bw.close();
  }
}

