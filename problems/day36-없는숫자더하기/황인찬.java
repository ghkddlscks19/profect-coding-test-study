class Solution {
    public int solution(int[] numbers) {
        boolean[] checked = new boolean[10];
        
        for(int n: numbers) {
            checked[n] = true;
        } 
        
        int answer = 0;
        for(int i =0; i<10; i++) {
            if(checked[i] == false) answer += i;
        }
        
        return answer;
    }
}
~
