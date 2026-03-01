import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    String[] words = new String[N];
    
    for(int i =0; i<N; i++) {
      words[i] = br.readLine();
    }

    int cnt = 0;
    
    for(int i =0; i<N; i++) {
      for(int j =i+1; j<N; j++) {
        if(check(words[i], words[j])) cnt++;
      }
    }

    bw.write(cnt + "");
    bw.flush();
    bw.close();
  }

  static boolean check(String word1, String word2) {
    int[] mapping1 = new int[26]; // word1 -> word2
    int[] mapping2 = new int[26]; // word2 -> word1  

    for(int i =0; i<word1.length(); i++) {
      int c1 = word1.charAt(i) - 'a';
      int c2 = word2.charAt(i) - 'a';

      if(mapping1[c1] == 0 && mapping2[c2] == 0) {
        mapping1[c1] = c2 + 1;
        mapping2[c2] = c1 + 1;        
      } else if(mapping1[c1] != c2 + 1 || mapping2[c2] != c1 + 1) {
        return false;
      }
    }

    return true;
  }
}

