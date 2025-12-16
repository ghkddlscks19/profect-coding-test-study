import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] crane = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            crane[i] = Integer.parseInt(st.nextToken());
        
        int m = Integer.parseInt(br.readLine());
        List<Integer> box = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++)
            box.add(Integer.parseInt(st.nextToken()));
        
        Arrays.sort(crane, Comparator.reverseOrder());
        Collections.sort(box,  Collections.reverseOrder());
    
        if(box.get(0) > crane[0]) {
            System.out.println("-1");
            return;
        }
        int time = 0;
        while(!box.isEmpty()) {
            time++;
            for(int i = 0; i < n; i++)
                for(int j = 0; j < box.size(); j++)
                    if(box.get(j) <= crane[i]){
                        box.remove(j);
                        break;
                    }
        }
        System.out.println(time);
    }
}
