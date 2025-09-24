import java.util.*;

class Solution {
    int sum = 0;
    
    public int[] solution(int n) {
        int[][] array = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = 0;
            }
            sum += i + 1;
        }
        
        snail(array, 0, 0, 1, n);
        
        int[] answer = new int[sum];
        int c = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
               if (array[i][j] != 0) {
                   answer[c++] = array[i][j];
               }
            }
        }
        return answer;
    }
    
    public void snail(int[][] array, int startX, int startY, int count, int len) {
        if (count > sum || len <= 0)
            return;
        
        for (int i = startX; i < startX + len; i++) {
            array[i][startY] = count++;
        }
        
        for (int i = startY + 1; i < startY + len; i++) {
            array[startX + len - 1][i] = count++;
        }
        
        for (int i = 1; i < len - 1; i++) {
            array[startX + len - 1 - i][startY + len - 1 - i] = count++;
        }
        
        snail(array, startX + 2, startY + 1, count, len - 3);
        return;
    }
}
