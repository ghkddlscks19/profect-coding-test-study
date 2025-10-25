import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> hs = new HashSet<>();
        boolean answer = true;
        
        // 해시에 저장
        for(String phone: phone_book) {
            hs.add(phone);
        }
        
        // 접두사인 경우 체크
        for(String phone: phone_book) {
            for(int i =1; i<phone.length(); i++) {
                if(hs.contains(phone.substring(0, i))) {
                    return false;
                }
            }
        }
        
        
        return answer;
    }
}
