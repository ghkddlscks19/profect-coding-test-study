import java.util.*;
class Solution {
    static int[] ryan;
    static int[] apeach;
    static int[] result;
    static int maxDiff = 0;
    
    public int[] solution(int n, int[] info) {
        apeach = info;
        ryan = new int[11];
        result = new int[11];
        
        dfs(0, n);
       
        if(maxDiff <= 0) return new int[]{-1};
        return result;
    }
    
    static void dfs(int depth, int arrow) {
        if(depth == 11) {
            if(arrow > 0) {
                ryan[10] += arrow;
            }
            
            int ryanScore = 0;
            int apeachScore = 0;
            
            // 점수 구하기
            for(int i =0; i<11; i++) {
                if(apeach[i] == ryan[i]) continue;
                else if(apeach[i] > ryan[i]) apeachScore += 10 - i;
                else ryanScore += 10 - i;
            }
            
            if(maxDiff < ryanScore - apeachScore) {
                maxDiff = ryanScore - apeachScore;      
                result = Arrays.copyOf(ryan, 11);
            } else if(maxDiff == ryanScore - apeachScore) {
                // 최대 점수 차이가 같을 때는 낮은 점수를 많이 맞춘 배열로 변경
                for(int i =10; i>=0; i--) {
                    if(ryan[i] > result[i]) {
                        result = Arrays.copyOf(ryan, 11);
                        break;
                    } else if(ryan[i] < result[i]) {
                        break;
                    }
                }
            }
            
            if(arrow > 0) {
                ryan[10] -= arrow;
            }
            
            return;
        }
        
        // 화살이 어피치가 쏜거보다 많이 남아있어야 이길 수 있음
        if(arrow > apeach[depth]) {
            ryan[depth] = apeach[depth] + 1;
            dfs(depth + 1, arrow - ryan[depth]);
            ryan[depth] = 0;
        }
        
        // 이 칸에는 안쏜다
        dfs(depth + 1, arrow);
        
    }
}
