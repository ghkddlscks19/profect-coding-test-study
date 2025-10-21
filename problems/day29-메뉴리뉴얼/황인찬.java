import java.util.*;
class Solution {
    static HashMap<String, Integer> hm = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        // orders를 정렬한 상태로 조합 생성하기!
        for(String order: orders) {
            char[] orderArray = order.toCharArray();
            Arrays.sort(orderArray);
            combi(orderArray, "", 0);
        }
        
        List<String> answer = new ArrayList<>();
        // 길이가 n이고 가장 많이 나온 걸 정답에 저장
        for(int n: course) {
            int max = 0;
            // 1. 가장 많이 나오는 개수부터 구하기
            for(String menu: hm.keySet()) {
                if(menu.length() == n && hm.get(menu) >= 2) {
                    max = Math.max(max, hm.get(menu));
                }
            }
            
            // 2. 최대랑 같은 메뉴만 추출해서 저장
            for(String menu: hm.keySet()) {
                if(menu.length() == n && hm.get(menu) == max) {
                    answer.add(menu);
                }
            }
        }
        
        Collections.sort(answer);
        
        return answer.toArray(new String[answer.size()]);
    }
    
    static void combi(char[] orderArray, String curr, int idx) {
        // 길이가 2 이상이면 저장하지만 계속 진행
        if(curr.length() >= 2) {
            hm.put(curr, hm.getOrDefault(curr, 0) + 1);
        }
        
        for(int i =idx; i<orderArray.length; i++) {
            combi(orderArray, curr + orderArray[i], i + 1);
        }
    }
}
