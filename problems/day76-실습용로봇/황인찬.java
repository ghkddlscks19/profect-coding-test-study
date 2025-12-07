class Solution {
    int[] dx = {0, 1, 0, -1};  // 북, 동, 남, 서 (x 좌표)
    int[] dy = {1, 0, -1, 0};  // 북, 동, 남, 서 (y 좌표)
    
    public int[] solution(String command) {
        int x = 0, y = 0;
        int dir = 0;
        
        for(int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);
            
            if(c == 'R') {
                dir = (dir + 1) % 4;
            } else if(c == 'L') {
                dir = (dir + 3) % 4;
            } else if(c == 'G') {
                x += dx[dir];
                y += dy[dir];
            } else {
                x -= dx[dir];
                y -= dy[dir];
            }
        }
        
        return new int[]{x, y};
    }
}
