import java.util.*;

class Solution {
    static int len;
    public int[] solution(String[] id_list, String[] report, int k) {
        len = id_list.length;
        int[] answer = new int[len];
        HashSet<String>[] set = new HashSet[len];
        for(int i = 0; i < len; i++)
            set[i] = new HashSet<>();
        
        for(int i = 0; i < report.length; i++) {
            String s = report[i];
            String[] arr = s.split(" ");
            set[same(arr[1], id_list)].add(arr[0]);
        }
        
        for(int i = 0; i < len; i++)
            if(set[i].size() >= k)
                for(String s : set[i])
                    answer[same(s, id_list)]++;
        return answer;
    }
    
    static int same(String name, String[] ids) {
        for(int j = 0; j < len; j++)
            if(name.equals(ids[j]))
                return j;
        return 0;
    }
}
