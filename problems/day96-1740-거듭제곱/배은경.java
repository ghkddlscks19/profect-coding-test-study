import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long rslt = 0;
        long sqr = 1;
        
        while(n > 0) {
            if(n % 2 == 1) {
                rslt += sqr;
            }
            sqr *= 3;
            n /= 2;
        }
        
        System.out.println(rslt);
    }
}
