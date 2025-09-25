class Solution {
    public int check(String[] s, int j1, int k1) {
        int j = j1;
        int k = k1;

        j++;        
        while(j < 5 && j <= j1 + 2) {
            if(s[j].charAt(k) =='P') return 0;
            else if(s[j].charAt(k) == 'X') break; 
            j++;
        }
        
        k++;
        while(k < 5 && k <= k1 + 2) {
            if(s[j1].charAt(k) == 'P') return 0;
            else if(s[j1].charAt(k) == 'X') break; 
            k++;
        }
        
        if(k1 < 4 && j1 < 4) {
            if(s[j1 + 1].charAt(k1 + 1) == 'P') {
                if(s[j1 + 1].charAt(k1) == 'O' || s[j1].charAt(k1 + 1) == 'O') return 0;
            }
        }
        
        if(k1 > 0 && j1 < 4) {
            if(s[j1 + 1].charAt(k1 - 1) == 'P') {
                if(s[j1 + 1].charAt(k1) == 'O' || s[j1].charAt(k1 - 1) == 'O') return 0;
            }
        }
        
        return 1;
    }
    
    public int[] solution(String[][] places) {
        int leng = places[0].length;
        
        //p이면 자신의 아래(2칸까지), 오른쪽(2칸까지), 대각선(/,\)에 p없는지, 있더라도 그 사이에 파티션이 있는지 CHECK
        int[] answer = new int[leng];
        for(int i = 0; i < leng; i++) {
            String[] s = places[i];
            if(answer[i] == 0) { 
                for(int j = 0; j < s.length; j++) {
                    if(answer[i] == 0) {
                        for(int k = 0; k < 5; k++) {
                            if(s[j].charAt(k) == 'P'){
                                if(check(s, j, k) == 0){
                                    answer[i] = -1;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if(answer[i] == 0) answer[i] = 1;
            else answer[i] = 0;
        }
        return answer;
    }
}
