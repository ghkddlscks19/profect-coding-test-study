import java.util.*;

class Solution {
    static class Result {
        boolean win;
        int turn;
        Result(boolean w, int t) {
            win = w;
            turn = t;
        }
    }

    static Result dfs(boolean a, int[] aloc, int[] bloc, int[][] board) {
        int x = a ? aloc[0] : bloc[0];
        int y = a ? aloc[1] : bloc[1];
        if(board[x][y] == 0)
            return new Result(false, 0);

        boolean win = false;
        int min = board.length * board[0].length;
        int max = 0;
        boolean flag = false;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length || board[nx][ny] == 0)
                continue;
            flag = true;
            board[x][y] = 0;
            Result r;
            if(a)
                r = dfs(false, new int[]{nx, ny}, bloc, board);
            else
                r = dfs(true, aloc, new int[]{nx, ny}, board);
            board[x][y] = 1;

            if(!r.win) {
                win = true;
                min = Math.min(min, r.turn);
            } else
                max = Math.max(max, r.turn);
        }

        if(!flag)
            return new Result(false, 0);
        if(win)
            return new Result(true, min + 1);
        return new Result(false, max + 1);
    }

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        Result r = dfs(true, aloc, bloc, board);
        int answer = r.turn;
        
        return answer;
    }
}
