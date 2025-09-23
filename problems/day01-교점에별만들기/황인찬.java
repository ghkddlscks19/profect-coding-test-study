import java.util.*;
class Solution {
    public String[] solution(int[][] line) {
        // 모든 교점 찾기
        List<Point> points = new ArrayList<>();
        for(int i =0; i<line.length; i++) {
            for(int j =i+1; j<line.length; j++) {
                Point intersection = getIntersection(line[i], line[j]);
                
                if(intersection != null) points.add(intersection);
            }
        }
        
        // 최소, 최대 좌표 구하기
        long minX = points.get(0).x, maxX = points.get(0).x;
        long minY = points.get(0).y, maxY = points.get(0).y;
        
        for(Point p: points) {
            minX = Math.min(minX, p.x);
            maxX = Math.max(maxX, p.x);
            minY = Math.min(minY, p.y);
            maxY = Math.max(maxY, p.y);
        } 
        
        
        // 배열 크기 long -> int 
        int width = (int) (maxX - minX + 1);
        int height = (int) (maxY - minY + 1);
       
        // 전부 점으로 채우기
        char[][] board = new char[height][width];
        for(char[] c: board) {
            Arrays.fill(c, '.');
        }
        
        // 교점은 *로 채우기
        // x좌표는 0부터 시작하도록 변환, y좌표는 뒤집어야함
        for(Point p: points) {
            int x = (int) (p.x - minX);
            int y = (int) (maxY - p.y);
            board[y][x] = '*';
        }
        
        String[] answer = new String[height];
        for(int i =0; i<height; i++) {
            answer[i] = new String(board[i]);
        }
        
        return answer;
    }
    
    // 교점 찾는 메소드
    static Point getIntersection(int[] line1, int[] line2) {
        long A = line1[0], B = line1[1], E = line1[2];
        long C = line2[0], D = line2[1], F = line2[2];
        
        long denominator = A*D - B*C;
        
        // 평행 또는 일치
        if(denominator == 0) return null;
        
        long numeratorX = B*F - E*D;
        long numeratorY = E*C - A*F;
        
        // 정수가 아닌 교점은 필요 없음
        if(numeratorX % denominator != 0 || numeratorY % denominator != 0) return null;
        
        return new Point((numeratorX / denominator), (numeratorY / denominator));
    }
    
    
    // 좌표
    static class Point {
        long x, y;
        
        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}
