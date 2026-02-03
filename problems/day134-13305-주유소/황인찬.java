import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    int[] road = new int[N-1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i =0; i<N-1; i++) {
      road[i] = Integer.parseInt(st.nextToken());
    }

    int[] price = new int[N]; 
    st = new StringTokenizer(br.readLine());
    for(int i =0; i<N; i++) {
      price[i] = Integer.parseInt(st.nextToken());
    }

    long result = 0;
    long minPrice = price[0];
    for(int i =0; i<N-1; i++) {
      // 더 싼 가격이 있다면 갱신
      if(price[i] < minPrice) {
        minPrice = price[i];
      }

      result += minPrice * road[i];
    }

    bw.write(result + "");
    bw.flush();
    bw.close();
  }
}

