import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < t; i++) {
            int num = Integer.parseInt(br.readLine());
            int n = 2;
            int cnt = 0;
            
            while(num >= n) {
                if(num % n == 0) {
                    cnt++;
                    num /= n;
                }else{
                    if(cnt > 0)
                        System.out.println(n + " " + cnt);
                    n++;
                    cnt = 0;
                }
            }
            
            if(cnt > 0)
                System.out.println(n + " " + cnt);
            if(num > 1){
                cnt = 1;
                System.out.println(num + " " + cnt);
            }
        }
    }
}
