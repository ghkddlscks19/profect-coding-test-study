import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = Integer.parseInt(br.readLine());

    for(int i =0; i<t; i++) {
      int n = Integer.parseInt(br.readLine());
      List<String> phones = new ArrayList<>();
      
      for(int j =0; j<n; j++) {
        String phone = br.readLine();
        phones.add(phone);
      }

      // 정렬 후 옆에거랑 비교해서 접두어 체크
      Collections.sort(phones);

      boolean b = true;
      for(int j =0; j<phones.size()-1; j++) {
        if(phones.get(j+1).startsWith(phones.get(j))) {
          b = false;
          bw.write("NO");
          break;
        }    
      }

      if(b == true) bw.write("YES");
      bw.newLine();
      
    }

    bw.flush();
    bw.close();
  }
}

