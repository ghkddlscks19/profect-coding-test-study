import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine());
    
    for(int i =0; i<T; i++) {
      int k = Integer.parseInt(br.readLine());
      TreeMap<Integer, Integer> tm = new TreeMap<>();
      for(int j =0; j<k; j++) {
        String line[] = br.readLine().split(" ");
        String alpha = line[0];
        int num = Integer.parseInt(line[1]);

        if(alpha.equals("I")) {
          tm.put(num, tm.getOrDefault(num, 0) + 1);
        } else {
          if(tm.isEmpty()) continue;
          // 1이면 최대, -1이면 최소
          int key = (num == 1) ? tm.lastKey() : tm.firstKey();
          if(tm.get(key) == 1) {
            tm.remove(key);
          } else {
            tm.put(key, tm.get(key) - 1);
          }
        }
      }
      
      if(tm.isEmpty()) bw.write("EMPTY");
      else bw.write(tm.lastKey() + " " + tm.firstKey() + "");
      bw.newLine();
    }

    bw.flush();
    bw.close();
  }
}

