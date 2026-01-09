import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static long cnt = 0;
    static void check(int idx, int l, int r) {
        int std = arr[idx] * -1;
        while(l < r) {
            if(arr[r] + arr[l] > std)
                r--;
            else if(arr[r] + arr[l] < std)
                l++;
            else if(arr[r] + arr[l] == std) {
                int cnt1 = 1;
                int cnt2 = 1;
                if(arr[r] != arr[l]) {
                    while(l < r && arr[r] == arr[r - 1]) {
                        cnt1++;
                        r--;
                    }
                    r--;
                    while(l < r && arr[l] == arr[l + 1]) {
                        cnt2++;
                        l++;
                    }
                    l++;
                    cnt += (long)cnt1 * cnt2;
                } else {
                    long k = r - l + 1;
                    cnt += k * (k - 1) / 2;
                    break;
                }
            }
        }
        
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(arr);
        for(int i = 0; i < n - 2; i++)
                check(i, i + 1, n - 1);
        System.out.print(cnt);
    }
}
