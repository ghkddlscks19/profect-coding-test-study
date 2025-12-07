class Solution {
    public int[] solution(String command) {
        int[] answer = {0, 0};
        char[] arr = command.toCharArray();
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int dir = 2;
      
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 'R')
                dir = (dir + 1) % 4;
            else if (arr[i] == 'L')
                dir = (dir + 3) % 4;
            else if (arr[i] == 'G') {
                answer[1] += dx[dir];
                answer[0] += dy[dir];
            } else if (arr[i] == 'B') {
                answer[1] -= dx[dir];
                answer[0] -= dy[dir];
            }
        }
        return answer;
    }
}
