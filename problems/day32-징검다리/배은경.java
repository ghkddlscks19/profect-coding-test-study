import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);

        int left = 1;
        int right = distance;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (getRemovedCount(distance, rocks, mid) <= n) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    private int getRemovedCount(int distance, int[] rocks, int min) {
        int removed = 0;
        int cur = 0;
        
        for (int rock : rocks) {
            if (rock - cur < min) {
                removed++;
            } else {
                cur = rock;
            }
        }
        
        if (distance - cur < min)
            removed++;
        
        return removed;
    }
}
