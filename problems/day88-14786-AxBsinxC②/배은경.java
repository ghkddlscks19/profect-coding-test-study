import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        double left = 0;
        double right = (double)(c + (b > 0 ? b : -1 * b))/a;
        double mid = 0;
        while(right - left > 0.000000001) {
            mid = (left + right) / 2;
            
            double rslt = a * mid + b * Math.sin(mid);
            if(rslt >= c)
                right = mid;
            else
                left = mid;
        }
        
        System.out.print(right);
    }
}
