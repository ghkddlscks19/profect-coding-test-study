import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int len = triangle.length;

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0)
                    triangle[i][j] += triangle[i-1][j];
                else if (j == triangle[i].length - 1)
                    triangle[i][j] += triangle[i-1][j-1];
                else
                    triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
            }
        }

        int max = 0;
        for (int i = 0; i < triangle[len - 1].length; i++)
            if (triangle[len - 1][i] > max)
                max = triangle[len - 1][i];
                
        return max;
    }
}
