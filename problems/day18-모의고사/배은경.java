class Solution {
    public int[] solution(int[] answers) {
        int[] answer;
        int idx = 0;
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];
        
        for(int i = 0; i < answers.length; i++) {
            if(p1[i % p1.length] == answers[i])
                score[0]++;
            if(p2[i % p2.length] == answers[i])
                score[1]++;
            if(p3[i % p3.length] == answers[i])
                score[2]++;
        }
        
        int max = Math.max(score[0], Math.max(score[1], score[2]));
        int cnt = 0;
        for (int i = 0; i < 3; i++) 
            if (score[i] == max) cnt++;

        answer = new int[cnt];
        for (int i = 0; i < 3; i++)
            if (score[i] == max)
                answer[idx++] = i + 1;
        
        return answer;
    }
}
