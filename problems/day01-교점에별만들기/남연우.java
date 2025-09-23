import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
      
        int num = line.length;
        List<int[]> points = new ArrayList<>();
        long minX = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;
        
        for (int i = 0; i < num; i++) {
            long a1 = line[i][0];
            long b1 = line[i][1];
            long c1 = line[i][2];
            
            for (int j = i + 1; j < num; j++) {
                long a2 = line[j][0];
                long b2 = line[j][1];
                long c2 = line[j][2];
                
                if (a1 * b2 - a2 * b1 == 0)
                    continue;
                
                long nx = b1 * c2 - b2 * c1;
                long ny = c1 * a2 - c2 * a1;
                long d = a1 * b2 - a2 * b1;
                
                if (nx % d == 0 && ny % d == 0) {
                    long x = nx / d;
                    long y = ny / d;

                    points.add(new int[]{(int)x, (int)y});

                    if (x < minX) minX = x;
                    if (x > maxX) maxX = x;
                    if (y < minY) minY = y;
                    if (y > maxY) maxY = y;
                }
            }
        }
        
        char[][] result = new char[(int)(maxY - minY + 1)][(int)(maxX - minX + 1)];
        
        for (int i = 0; i < maxY - minY + 1; i++) {
            for (int j = 0; j < maxX - minX + 1; j++)
                result[i][j] = '.';
        }
        
        for (int[] p : points) {
            result[(int)maxY - p[1]][p[0] - (int)minX] = '*';
        }
        
        
        
        String[] answer = new String[result.length];
        
        for (int i = 0; i < result.length; i++) {
            answer[i] = new String(result[i]);
        }
        
        return answer;
    }
}
