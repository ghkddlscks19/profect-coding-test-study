import java.util.*;
class Solution {
    
    int[] apeach;
    int[] best;
    int maxDiff;
    boolean foundWin;
    
    public int[] solution(int n, int[] info) {
        
        apeach = info;
        maxDiff = 0;
        foundWin = false;
        best = new int[11];
        int[] ryan = new int[11];
        
        dfs(0, n, ryan);
      
        if (!foundWin) return new int[]{-1};
        return best;
    }
    
    void dfs(int idx, int remain, int[] ryan){
        if(idx == 11){
            if(remain>0){
                ryan[10] += remain;
            }
            
            int[] score = calScore(ryan, apeach);
            int rScore = score[0];
            int aScore = score[1];
            int diff = rScore - aScore;
        
            // 라이언이 이겼다면
            if(diff > 0){
                foundWin = true;
                compareAndUpdate(ryan, diff);
            }
            
            if(remain > 0){
                ryan[10] -= remain;
            }
            
            return;
        }
        
        dfs(idx + 1, remain, ryan);
        
        int need = apeach[idx] + 1;
        if(remain >= need){
            ryan[idx] = need;
            dfs(idx + 1, remain - need, ryan);
            ryan[idx] = 0;
        }
    }
    
    // 점수차 최대인 거 비교
    int[] calScore(int[] ryan, int[] apeach){
        int rScore = 0;
        int aScore = 0;
        
        for(int i =0; i<11; i++){
            int score = 10 - i;
            if(ryan[i] == 0 && apeach[i] == 0)
                continue;
            
            if(ryan[i] > apeach[i]) rScore += score;
            else aScore += score;
        }
        
        return new int[]{rScore, aScore};
    }
    
    // 비교후 최대 점수인 ryan 배열 업뎃
    void compareAndUpdate(int[] ryan, int diff){
        if(diff > maxDiff){
            maxDiff = diff;
            best = Arrays.copyOf(ryan, ryan.length);
            return;
        }
        
        if(diff == maxDiff){
            if (isBetter(ryan, best)) {
            best = Arrays.copyOf(ryan, ryan.length);
            }
        }
    }
    
    // 이기는 과정 중 더 나은 결과
    boolean isBetter(int[] cur, int[] best) {
        for (int i = 10; i >= 0; i--) {
            if (cur[i] > best[i]) return true;
            if (cur[i] < best[i]) return false;
        }
            return false;
    }

}
