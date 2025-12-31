import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    // 고객 정보
    List<Customer> customers = new ArrayList<>();
    for(int i =0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      int id = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      customers.add(new Customer(id, w));
    }

    // 계산대
    PriorityQueue<Counter> pq = new PriorityQueue<>(
      (a, b) -> {
        if(a.endTime == b.endTime) {
          return a.num - b.num;
        }
        return a.endTime - b.endTime;
      }
    );

    for(int i =1; i<=K; i++) {
      pq.offer(new Counter(0, i));
    }

    List<Exit> exits = new ArrayList<>();

    for(Customer customer: customers) {
      // 가장 빨리 비는 계산대
      Counter counter = pq.poll();

      // 퇴장 시간
      int exitTime = customer.w + counter.endTime;

      // 퇴장 리스트에 추가
      exits.add(new Exit(customer.id, exitTime, counter.num));

      // counter를 다시 pq에 넣기
      pq.offer(new Counter(exitTime, counter.num));
    }

    // 같으면 계산대 번호 내림차순, 아니면 퇴장시간 오름차순
    Collections.sort(exits, (a, b) -> {
      if(a.exitTime == b.exitTime) {
        return b.counterNum - a.counterNum;
      }
      return a.exitTime - b.exitTime;
    });

    long answer = 0;
    int i = 1;
    for(Exit exit: exits) {
      answer += (long) i * exit.id;
      i++;
    }

    bw.write(answer + "");
    bw.flush();
    bw.close();
  }

  static class Customer {
    int id, w;

    public Customer(int id, int w) {
      this.id = id;
      this.w = w;
    }
  }

  static class Counter {
    int endTime, num;

    public Counter(int endTime, int num) {
      this.endTime = endTime;
      this.num = num;
    }
  }

  static class Exit {
    int id, exitTime, counterNum;

    public Exit(int id, int exitTime, int counterNum) {
      this.id = id;
      this.exitTime = exitTime;
      this.counterNum = counterNum;
    }
  }

  
}

