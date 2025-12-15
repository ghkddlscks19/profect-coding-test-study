import java.util.Scanner;

public class Main {

  static int s, N, K;
  static long start, end;
  
  static long powLong(long base, int exp) {
      long res = 1L;
      for (int i = 0; i < exp; i++) res *= base;
      return res;
  }

  static boolean isBlack(long r, long c) {
    long len = powLong(N, s);
    int level = s;

    while (level > 0) {
      len /= N;

      long br = r / len;
      long bc = c / len;

      if (start <= br && br <= end && start <= bc && bc <= end)
        return true;

      r %= len;
      c %= len;
      level--;
    }

    return false;
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    s = sc.nextInt();
    N = sc.nextInt();
    K = sc.nextInt();
    int R1 = sc.nextInt();
    int R2 = sc.nextInt();
    int C1 = sc.nextInt();
    int C2 = sc.nextInt();

    start = (N - K) / 2L;
    end = start + K - 1L;

    StringBuilder sb = new StringBuilder();
    for (long r = R1; r <= R2; r++) {
      for (long c = C1; c <= C2; c++) {
        sb.append(isBlack(r, c) ? '1' : '0');
      }
      sb.append('\n');
    }

    System.out.print(sb);
  }
}
