import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        StringBuilder sb = new StringBuilder();

        while ((s = br.readLine()) != null) {
            int num = Integer.parseInt(s);
            boolean ch = false;
            int len = 0;
            long n = 0L;
            while(ch == false) { 
                n = (n * 10 + 1) % num;
                if(n == 0)
                    ch = true;
                len++;
            }
            sb.append(len + "\n");
        }
        System.out.print(sb.toString());
    }
}
