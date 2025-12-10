import java.util.*;
class Solution {
    int[][] map;
    boolean[][][] visited;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    int N, M;
    public int solution(int n, int m, int[][] hole) {
        N = n;
        M = m;
        // 지도 초기화 및 구멍 처리
        map = new int[m+1][n+1];
        visited = new boolean[m+1][n+1][2];
        for(int[] h: hole) {
            map[h[1]][h[0]] = 1;
        }
        
        int answer = bfs();
            
        return answer;
    }
    
    int bfs() {
        Deque<Point> q = new ArrayDeque<>();
        q.offer(new Point(1, 1, 0, false));
        visited[1][1][0] = true;
        
        while(!q.isEmpty()) {
            Point curr = q.poll();
            
            // 도착했을 시
            if(curr.x == N && curr.y == M) return curr.time;
            
            // 평범한 이동
            for(int i =0; i<4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                
                if(nx < 1 || nx > N || ny < 1 || ny > M) continue; // 지도 범위 밖
                
                if(map[ny][nx] == 1) continue; // 구멍
                
                int shoes = curr.usedShoes ? 1 : 0;
                
                if(visited[ny][nx][shoes]) continue; // 이미 방문
                
                visited[ny][nx][shoes] = true;
                q.offer(new Point(nx, ny, curr.time + 1, curr.usedShoes));
                
            }
            
            // 신발을 이용한 이동
            if(!curr.usedShoes) {
                for(int i =0; i<4; i++) {
                    // 2칸 이동
                    int nx = curr.x + dx[i] * 2;
                    int ny = curr.y + dy[i] * 2;
                    
                    if(nx < 1 || nx > N || ny < 1 || ny > M) continue; // 지도 범위 밖
                
                    if(map[ny][nx] == 1) continue; // 구멍

                    if(visited[ny][nx][1]) continue; // 이미 방문

                    visited[ny][nx][1] = true;
                    q.offer(new Point(nx, ny, curr.time + 1, true));
                }   
            }
            
        }
        
        return -1; // 도달 불가능
    }
    
    class Point {
        int x, y, time;
        boolean usedShoes;
        
        public Point(int x, int y, int time, boolean usedShoes) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.usedShoes = usedShoes;
        }
    }
}
