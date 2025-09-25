import java.util.*;
class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i =0; i<places.length; i++) {
            answer[i] = check(places[i]) ? 1 : 0; // 체크 성공은 1 아니면 0
        }
        return answer;
    }
    
    static boolean check(String[] place) {
        char[][] c = new char[5][5];
        
        for(int i =0; i<5; i++) {
            c[i] = place[i].toCharArray();
        }
        
        for(int i =0; i<5; i++) {
            for(int j =0; j<5; j++) {
                if(c[i][j] == 'P') {
                    if(!isValid(c, i, j)) return false;
                }
            }     
        }
        return true;
    }
    
    // 현 위치의 사람이 유효한 위치에 있는지 확인하는 함수, BFS를 통해 확인
    static boolean isValid(char[][] c, int x, int y) {
        ArrayDeque<Point> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[5][5];
        
        q.offer(new Point(x, y, 0));
        visited[x][y] = true;
        
        while(!q.isEmpty()) {
            Point curr = q.poll();
            
            for(int i =0; i<4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                int dist = curr.dist + 1;
                
                if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue; // 범위 내여야함
                
                if(visited[nx][ny]) continue; // 이미 방문
                
                if(c[nx][ny] == 'X') continue; // 파티션이면 그 방향으로는 더 이상 갈 수 없음
                
                // 사람 만났는데 dist가 2 이하면 규칙을 만족하지 못함
                if(c[nx][ny] == 'P' && dist <= 2) return false;
                
                // 거리가 2 이하 일 때만 탐색
                if(dist <= 2) { 
                    visited[nx][ny] = true;
                    q.offer(new Point(nx, ny, dist));
                }
            }
        }
        return true;
    }
    
    static class Point {
        int x, y, dist;
        
        public Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
