import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for(String o : operations){
            String[] parts = o.split(" ");
            int num = Integer.parseInt(parts[1]);
            
            if(parts[0].equals("I")){
                maxHeap.offer(num);
                minHeap.offer(num);
                map.put(num, map.getOrDefault(num, 0) + 1);
            }else if(parts[0].equals("D")){
                
                if(num == -1){
                    remove(map, minHeap);
                }else if(num == 1){
                    remove(map, maxHeap);
                }
                
            }
        }
        
        int max = getValid(map, maxHeap);
        int min = getValid(map, minHeap);
        
        if (map.isEmpty()) 
            return new int[]{0, 0};
        
        answer = new int[]{max, min};
        
        return answer;
    }
    
    private void remove(Map<Integer, Integer> map, PriorityQueue<Integer> heap){
        while(!heap.isEmpty()){
            int val = heap.poll();
            if(map.containsKey(val)){
                map.put(val, map.get(val) -1);
                if(map.get(val) == 0)
                    map.remove(val);
                break;
            }
        }
    }
    
   private int getValid(Map<Integer, Integer> map, PriorityQueue<Integer> heap) {
        while (!heap.isEmpty()) {
            int val = heap.peek();
            if (map.containsKey(val)) 
                return val;
            heap.poll();
        }
        return 0;
    }
    
}
