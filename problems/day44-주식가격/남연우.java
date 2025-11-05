class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length]; 
        
        int i = 0;
        for (int price : prices) {
            int index = 0;
            for (int j = i; j < prices.length; j++) {
                index++;
                if (price > prices[j])
                    break;
            }
            
            answer[i++] = index - 1;
        }
        
        return answer;
    }
}
