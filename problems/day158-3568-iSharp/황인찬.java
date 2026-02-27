import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input = br.readLine().replace(",", "").replace(";", "").split(" ");

    String data = input[0];
    for(int i =1; i<input.length; i++) {
      // 알파벳과 기호 분리
      StringBuilder sign = new StringBuilder();
      StringBuilder alpha = new StringBuilder();
      sign.append(data);
      for(int j =input[i].length() - 1; j>=0; j--) {
        char c = input[i].charAt(j);
        
        if(c == '[') sign.append("]");
        else if(c == ']') sign.append("[");
        else if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) alpha.append(c);
        else sign.append(c);        
      }

      bw.write(sign.toString() + " " + alpha.reverse().toString() + ";");
      bw.newLine();
    }

    bw.flush();
    bw.close();
  }
}

