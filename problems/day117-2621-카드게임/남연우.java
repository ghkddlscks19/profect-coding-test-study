import java.io.*;
import java.util.*;

public class Main{
  static int[] color;
  static int[] num;
  
  static int count1() {
    if (isFlush() && isStraight())
      return 900 + getMax();

    return 0;
  }

  static int count2() {
    for (int i = 1; i <= 9; i++) {
      if (num[i] == 4)
        return 800 + i;
    }

    return 0;
  }

  static int count3() {
    int three = 0;
    int pair = 0;

    for (int i = 1; i <= 9; i++) {
      if (num[i] == 3)
        three = i;
      if (num[i] == 2)
        pair = i;
    }

    if (three > 0 && pair > 0)
      return 700 + three * 10 + pair;

    return 0;
  }

  static int count4() {
    if (isFlush())
      return 600 + getMax();

    return 0;
  }

  static int count5() {
    if (isStraight())
      return 500 + getMax();

    return 0;
  }

  static int count6() {
    for (int i = 1; i <= 9; i++) {
      if (num[i] == 3)
        return 400 + i;
    }

    return 0;
  }

  static int count7() {
    int pair1 = 0;
    int pair2 = 0;

    for (int i = 1; i <= 9; i++) {
      if (num[i] == 2) {
        if (pair1 == 0)
          pair1 = i;
        else
          pair2 = i;
      }
    }

    if (pair1 > 0 && pair2 > 0)
      return 300 + Math.max(pair1, pair2) * 10 + Math.min(pair1, pair2);

    return 0;
  }

  static int count8() {
    for (int i = 1; i <= 9; i++) {
      if (num[i] == 2)
        return 200 + i;
    }

    return 0;
  }

  static int count9() {
    return 100 + getMax();
  }

  static boolean isFlush() {
    for (int i = 0; i < 4; i++) {
      if (color[i] == 5) 
        return true;
    }
    
    return false;
  }

  static boolean isStraight() {
    int prev = -1;
    int cnt = 0;
    
    for (int i = 1; i <= 9; i++) {
      if (num[i] > 0) {
        if (prev != -1 && i != prev + 1)
          return false;

        prev = i;
        cnt++;
      }
    }

    if (cnt == 5)
      return true;

    return false;
  }

  static int getMax() {
    for (int i = 9; i >= 1; i--) {
      if (num[i] > 0)
        return i;
    }

    return 0;
  }
  
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    color = new int[4];
    num = new int[10];
    
    for (int i = 0; i < 5; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      char c = st.nextToken().charAt(0);
      int n = Integer.parseInt(st.nextToken());

      if (c == 'R')
        color[0]++;
      else if (c == 'B')
        color[1]++;
      else if (c == 'Y')
        color[2]++;
      else
        color[3]++;

      num[n]++;
    }

    int score = 0;

    score = Math.max(score, count1());
    score = Math.max(score, count2());
    score = Math.max(score, count3());
    score = Math.max(score, count4());
    score = Math.max(score, count5());
    score = Math.max(score, count6());
    score = Math.max(score, count7());
    score = Math.max(score, count8());
    score = Math.max(score, count9());
    
    System.out.println(score);
  }
}
