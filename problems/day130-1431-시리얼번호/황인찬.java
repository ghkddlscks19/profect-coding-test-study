import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    String[] serial = new String[N];
    
    for(int i =0; i<N; i++) {
      serial[i] = br.readLine();  
    }

    Arrays.sort(serial, (a, b) -> {
      // 길이가 다르면 오름차순
      if(a.length() != b.length()) {
        return a.length() - b.length();
      }

      int sumA = 0;
      int sumB = 0;

      // 숫자면 더하기
      for(char c : a.toCharArray()) {
        if(Character.isDigit(c)) sumA += c - '0';
      }
      
      for(char c : b.toCharArray()) {
        if(Character.isDigit(c)) sumB += c - '0';
      }

      // 합이 다르면 비교해서 오름차순
      if(sumA != sumB) return sumA - sumB;

      // 합이 같으면 사전순
      return a.compareTo(b);
    });

    for(String s: serial) {
      bw.write(s);
      bw.newLine();
    }

    bw.flush();
    bw.close();
  }
}

