import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    String input = "";

    while((input = br.readLine()) != null) {
      int n = Integer.parseInt(input);
      int i = 0;
      int length = 0;
      while(true) {
        i = (i * 10 + 1) % n;
        length++;
  
        if(i % n == 0) {
          bw.write(length + "\n");
          break;
        }
      }
     
    }

    bw.flush();
    bw.close();
    
  }
}

