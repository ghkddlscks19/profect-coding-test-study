import java.util.*;
class Solution {
    
    static Map<String, Integer> map = new HashMap();
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        for(int i=0; i<orders.length; i++){
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = new String(arr);
        }
        
        for(String order : orders){
            for(int len : course){
                if(order.length() >= len)
                    dfs(order, len, "", 0);
            }
        }
        
        List<String> list = new ArrayList<>();
        
        for(int i=0; i<course.length; i++){
            int num = course[i];
            int max = 0;
            
            for(String key : map.keySet()){
                if(key.length() == num){
                    Integer cnt = map.get(key);
                    if(cnt>=2 && max < cnt){
                        max = cnt;
                    }
                }
            }
            
            for(String key : map.keySet()){
            if(key.length() == num){
                Integer cnt = map.get(key);
                if(cnt == max) 
                    list.add(key);
            }
        }        
    }
        
        Collections.sort(list);
        answer = list.toArray(String[]::new);
        return answer;
    }
    
    static void dfs(String order, int len, String word, int start){
        if(word.length()==len){
            map.put(word, map.getOrDefault(word, 0) + 1); 
            return;
        }else{
            for(int i=start; i<order.length(); i++){
                dfs(order, len, word + order.charAt(i), i+1);
            }
        }
    }
}
