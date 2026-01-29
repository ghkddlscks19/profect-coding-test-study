import java.util.*;
import java.io.*;
public class Main{
  static char[] s;
  static Map<Character, Integer> hm = new HashMap<>();
  static int count = 0;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 입력 받고 HashMap에 넣기
    s = br.readLine().toCharArray();

    for(char c: s) {
      hm.put(c, hm.getOrDefault(c, 0) + 1);
    }

    backtracking(0, ' ');
    
    bw.write(count + "");
    bw.flush();
    bw.close();
  }

  static void backtracking(int depth, char prev) {
    if(depth == s.length) {
      count++;
      return;
    }

    // 가능한 문자를 map을 순회하며 대입
    for(char c : hm.keySet()) {
      if(hm.get(c) > 0 && prev != c) {
        hm.put(c, hm.get(c) - 1);      
        backtracking(depth + 1, c);
        hm.put(c, hm.getOrDefault(c, 0) + 1);
      }
    }
  }
}

