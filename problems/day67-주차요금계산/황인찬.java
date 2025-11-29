import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        // 차량이 들어온 시간 저장
        Map<String, Integer> inMap = new HashMap<>();
        // 차량이 머물던 시간 저장
        Map<String, Integer> totalMap = new HashMap<>();
        
        for(String record: records) {
            String[] input = record.split(" ");
            String time = input[0];
            String car = input[1];
            String state = input[2];
            
            int minute = timeToMinute(time);
            
            // 입차일 때
            if(state.equals("IN")) {
                inMap.put(car, minute);
            } else {
                // 주차 시간 계산하고 inMap에서 제거
                int parking = minute - inMap.get(car);
                totalMap.put(car, totalMap.getOrDefault(car, 0) + parking);
                inMap.remove(car);
            }
        }
        
        // 입차만 한 차는 23:59에 나가는 걸로 처리
        for(String car: inMap.keySet()) {
            int parking = timeToMinute("23:59") - inMap.get(car);
            totalMap.put(car, totalMap.getOrDefault(car, 0) + parking);
        }
        
        // 차량 번호 순 정렬 후 요금 계산
        List<String> cars = new ArrayList<>(totalMap.keySet());
        Collections.sort(cars);
        
        int[] answer = new int[cars.size()];
        for(int i =0; i<cars.size(); i++) {
            int time = totalMap.get(cars.get(i));
            answer[i] = calculateFee(fees, time);
        }
        
        return answer;
    }
    
    // 시간 변환
    int timeToMinute(String time) {
        String[] input = time.split(":");
        return Integer.parseInt(input[0]) * 60 + Integer.parseInt(input[1]);
    }
    
    // 요금 계산
    int calculateFee(int[] fees, int time) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        if(time <= baseTime) {
            return baseFee;
        }
        
        return baseFee + (int) Math.ceil(((double) time - baseTime) / unitTime) * unitFee;
    }
}
