import java.util.*;

class Solution {
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        List<String>[] normal = new ArrayList[10001];
        List<String>[] reverse = new ArrayList[10001];
        
        for(int i = 0; i < 10001; i++) {
            normal[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }
        
        StringBuffer sb;
        for(int i = 0; i < words.length; i++) {
            int len = words[i].length();
            normal[len].add(words[i]);
            sb = new StringBuffer(words[i]);
            reverse[len].add(sb.reverse().toString());
        }
        for(int i = 0; i < 10001; i++) {
            Collections.sort(normal[i]);
            Collections.sort(reverse[i]);
        }
        
        for(int i = 0; i < queries.length; i++) {
            String q = queries[i];
            int len = q.length();
            List<String> list;
            
            if(q.startsWith("?")) { //접두사로 ?
                int idx = q.lastIndexOf('?') + 1;
                q = q.substring(idx);
                sb = new StringBuffer(q);
                q = sb.reverse().toString();
                list = reverse[len];
            } else { //접미사로 ?
                q = q.substring(0, q.indexOf('?'));
                list = normal[len];
            }
            
            int idx1 = lower(0, list.size(), q, list);
            int idx2 = upper(0, list.size(), q, list);
            answer[i] = idx2 - idx1;
        }
        return answer;
    }
    
    public int lower(int left, int right, String s, List<String> list) {
        if(left >= right)
            return left;
        int mid = (left + right) / 2;
                
        if(list.get(mid).substring(0, s.length()).compareTo(s) < 0) {
            return lower(mid + 1, right, s, list);
        }else {
            return lower(left, mid, s, list);
        }
    }
    
    public int upper(int left, int right, String s, List<String> list) {
        if(left >= right)
            return left;
        int mid = (left + right) / 2;
                
        if(list.get(mid).substring(0, s.length()).compareTo(s) <= 0) {
            return upper(mid + 1, right, s, list);
        }else {
            return upper(left, mid, s, list);
        }
    }
    
}
