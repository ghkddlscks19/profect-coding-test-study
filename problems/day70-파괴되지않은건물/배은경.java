class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] sum = new int[board.length][board[0].length];
        
        for(int i = 0; i < skill.length; i++) {
            if(skill[i][0] == 1) {
                sum[skill[i][1]][skill[i][2]] -= skill[i][5];
                if(skill[i][3] + 1 < board.length)
                    sum[skill[i][3] + 1][skill[i][2]] += skill[i][5];
                if(skill[i][4] + 1 < board[0].length)
                    sum[skill[i][1]][skill[i][4] + 1] += skill[i][5];
                if(skill[i][3] + 1 < board.length && skill[i][4] + 1 < board[0].length)
                    sum[skill[i][3] + 1][skill[i][4] + 1] -= skill[i][5];
            }else {
                sum[skill[i][1]][skill[i][2]] += skill[i][5];
                if(skill[i][3] + 1 < board.length)
                    sum[skill[i][3] + 1][skill[i][2]] -= skill[i][5];
                if(skill[i][4] + 1 < board[0].length)
                    sum[skill[i][1]][skill[i][4] + 1] -= skill[i][5];
                if(skill[i][3] + 1 < board.length && skill[i][4] + 1 < board[0].length)
                    sum[skill[i][3] + 1][skill[i][4] + 1] += skill[i][5];
            }
        }
        
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++) {
                if(i > 0) 
                    sum[i][j] += sum[i - 1][j];
                if(j > 0)
                    sum[i][j] += sum[i][j - 1];
                if(i > 0 && j > 0)
                    sum[i][j] -= sum[i- 1][j - 1];
                if(board[i][j] + sum[i][j] > 0)
                    answer++;
            }
        
        return answer;
    }
}
