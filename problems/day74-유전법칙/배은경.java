class Solution {
    public String[] solution(int[][] queries) {
        String[] answer = new String[queries.length];
        String[] s = {"RR", "Rr", "rr"};
      
        for(int i = 0; i < queries.length; i++) {
            int[] arr = new int[queries[i][0] + 1];
            int n = queries[i][1] - 1;
            for(int j = queries[i][0]; j > 0; j--) {
                arr[j] = n;
                n = n / 4; 
            }
            
            int pr = 1; // 0-> RR, 1-> Rr, 2-> rr
            for(int j = 2; j <= queries[i][0]; j++)
                if(pr == 1) 
                    if(arr[j] % 4 == 1 || arr[j] % 4 == 2)
                        pr = 1;
                    else if(arr[j] % 4 == 0)
                        pr = 0;
                    else
                        pr = 2;
            
            answer[i] = s[pr];
        }
        return answer;
    }
}
