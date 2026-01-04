import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    // 될 수 있는 후보군들 전부 생성
    // 1~9가 들어간 서로 다른 3자리 숫자
    List<Integer> nums = new ArrayList<>();
    for(int i =123; i<=987; i++) {
      // 백의자리, 십의자리, 일의자리 추출 후 겹치지 않는 것들만 리스트에 추가
      int hund = i / 100; 
      int ten = i % 100 / 10;
      int one = i % 10;

      if(hund == ten || hund == one || ten == one) continue;
      if(ten == 0 || one == 0) continue;
      
      nums.add(i);
    }

    for(int i =0; i<N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int num = Integer.parseInt(st.nextToken());
      int strike = Integer.parseInt(st.nextToken());
      int ball = Integer.parseInt(st.nextToken());

      // 해당하는 스트라이크 볼만 남겨놓기
      for(int j =nums.size() - 1; j>=0; j--) {
        int hund = num / 100; 
        int ten = num % 100 / 10;
        int one = num % 10;

        int s = 0;
        int b = 0;

        int curr = nums.get(j);
        int currHund = curr / 100; 
        int currTen = curr % 100 / 10;
        int currOne = curr % 10;

        if(hund == currHund) s++;
        if(ten == currTen) s++;
        if(one == currOne) s++;

        if(hund == currTen || hund == currOne) b++;
        if(ten == currHund || ten == currOne) b++;
        if(one == currHund || one == currTen) b++;

        // 스트라이크, 볼 안맞으면 제거
        if(strike != s || ball != b) nums.remove(Integer.valueOf(curr));
      }
      
    }

    bw.write(nums.size() + "");
    bw.flush();
    bw.close();
  }
}

