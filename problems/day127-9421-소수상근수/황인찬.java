
import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    // 소수를 먼저 구한다
    boolean[] prime = new boolean[n+1];
    
    Arrays.fill(prime, true);
    
    prime[0] = prime[1] = false;
    
    for(int i =2; i<=Math.sqrt(n); i++) {
      if(prime[i]) {
        for(int j =i*i; j<=n; j+=i) {
           prime[j] = false; 
        }
      }
    }
    
    // 그 중 상근수를 구한다
    // 상근수는 결국 순환이 생기는 것 같다. 수 하나를 저장해놓고 다시 돌아오면 상근수가 아니라고 판단
    // 그 순환이 나오는 수가 4다
    for(int i =2; i<=n; i++) {
      
      if(prime[i]) {
        int curr = i;
        // 1이 아니고 4도 아닐 때까지 계속 반복
        while(curr != 1 && curr != 4) {
          int sum = 0;
          int temp = curr;

          while(temp > 0) {
            int num = temp % 10;
            sum += num * num;
            temp /= 10;
          }

          curr = sum;
        }

        // 반복문 끝나고 1이면 상근수
        if(curr == 1) bw.write(i + "\n");
      }
       
    }

    bw.flush();
    bw.close();
  }
}

