import java.util.*;
class Solution {    
    public String solution(int[] numbers) {
        // 문자열로 변환하여 담을 리스트
        ArrayList<String> list = new ArrayList<>();
        // 문자열로 변환
        for(int n : numbers){
            list.add(String.valueOf(n));
        }
        
        //list에서 문자열로 앞+뒤를 한 값이 큰 값순으로 정렬
        Collections.sort(list, (o1, o2) -> {
            int a = Integer.parseInt(o1 + o2);
            int b = Integer.parseInt(o2 + o1);
            // 106, 610
            // 두 수를 정렬하는데 리턴값을 기준으로 정렬
            // 2-1 -> 음수 -> 내림차순
            return b-a;
        });

        // 리스트에 있는 값을 문자열로 변환
        StringBuilder sb = new StringBuilder();
        for(String s : list){
            sb.append(s);
        }
        
        // "000"같은 경우가 나와서 맨 앞이 0이면 "0"리턴할 수 있도록 함
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}
