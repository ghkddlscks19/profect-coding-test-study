import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    // 에라토스테네스의 체 활용
    boolean[] notPrime = new boolean[b+1];

    notPrime[0] = notPrime[1] = true;

    for(int i =2; i<=Math.sqrt(b); i++) {
      if(!notPrime[i]) {
        for(int j =i*i; j<=b; j+=i) {
          notPrime[j] = true;
        }
      }
    }

    for(int i =a; i<=b; i++) {
      if(!notPrime[i]) {
        if(isPalindrome(i)) {
          bw.write(i + "\n");
        }
      }
    }

    bw.write("-1" + "\n");
    bw.flush();
    bw.close();
    
  }

  static boolean isPalindrome(int n) {
    int original = n;
    int reverse = 0;

    while(n > 0) {
      reverse = reverse * 10 + (n % 10);
      n /= 10;
    }

    if(original == reverse) return true;
    return false;
  }
}

