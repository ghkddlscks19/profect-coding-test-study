class Solution {
    public int solution(int n, int[][] results) {
        // 경기 결과를 담을 배열
        boolean[][] win = new boolean[n+1][n+1];
        
        // 이기는 관계는 설정
        for(int[] r: results) {
            int winner = r[0];
            int loser = r[1];
            win[winner][loser] = true;
        }
        
        // 나를 이기는 사람, 지는 사람 수가 n-1명 일 때 나의 순위를 알 수 있음
        for(int k =1; k<=n; k++) { // 경유
            for(int i =1; i<=n; i++) { // 시작
                for(int j =1; j<=n; j++) { // 끝
                    if(win[i][k] && win[k][j]) { // a가 b를 이기고 b가 c를 이기면 a도 c를 이기므로 관계 설정
                        win[i][j] = true;
                    }
                }
            }
        }
        
        // 각 선수의 승패 수 확인
        int answer = 0;
        for(int i =1; i<=n; i++) {
            int cnt = 0;
            for(int j =1; j<=n; j++) {
                if(win[i][j]) cnt++; // i가 이긴 선수
                if(win[j][i]) cnt++; // i가 진 선수
            }
            
            if(cnt == n-1) answer++;
        }
    
        return answer;
    }
}
