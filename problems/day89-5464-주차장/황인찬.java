import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); 
    int M = Integer.parseInt(st.nextToken()); 

    int[] fee = new int[N]; // 단위 무게당 요금
    for(int i =0; i<N; i++) {
      fee[i] = Integer.parseInt(br.readLine());
    }

    int[] weight = new int[M+1]; // 무게
    for(int i =1; i<=M; i++) {
      weight[i] = Integer.parseInt(br.readLine());
    }

    int[] parking = new int[N]; // 주차 공간에 주차된 차량 번호
    int[] carSpace = new int[M+1]; // n번차가 어디에 주차되어있는지
    Deque<Integer> q = new ArrayDeque<>();
    int result = 0;
    
    for(int i =0; i<M*2; i++) {
      int car = Integer.parseInt(br.readLine());

      // 양수면 입차 음수면 출차
      if(car > 0) {
        boolean parked = false;

        for(int j =0; j<N; j++) {
          // 빈 공간이 있다면
          if(parking[j] == 0) { 
            parking[j] = car;
            carSpace[car] = j;
            result += fee[j] * weight[car];
            parked = true;
            break;
          }
        }

        // 빈 공간이 없다면
        if(!parked) {
          q.offer(car);
        }
      } else {
        car = -car;
        int space = carSpace[car];
        parking[space] = 0; // 출차 처리

        // 큐에 차가 있다면 넣어주기
        if(!q.isEmpty()) {
          int nextCar = q.poll();
          parking[space] = nextCar;
          carSpace[nextCar] = space;
          result += fee[space] * weight[nextCar];
        }
      }
    }

    bw.write(result + "");
    bw.flush();
    bw.close();
  }
}

