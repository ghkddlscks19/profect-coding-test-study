import java.util.*;
class Solution {
    public int[] solution(int n) {
        // 2차원 배열 생성
        int[][] arr = new int[n][n];
        int x = -1, y = 0; // 초기 좌표 설정 x = -1로 설정해야 모두 동일한 로직 적용 가능
        int num = 1;
        for(int i =0; i<n; i++) {
            for(int j =i; j<n; j++) {
                // 아래
                if(i % 3 == 0) {
                    x++;
                }
                // 위
                else if(i % 3 == 1) {
                    y++;
                }
                // 대각선
                else if(i % 3 == 2) {
                    x--;
                    y--;
                }
                
                arr[x][y] = num++;
            }
        }
        
        // 순회하면서 0이 아닌 값 넣어주기
        int[] answer = new int[n*(n+1)/2]; // 정답 개수가 n*(n+1)/2개
        int index = 0;
        for(int i =0; i<n; i++) {
            for(int j =0; j<n; j++) {
                if(arr[i][j] != 0) {
                    answer[index] = arr[i][j];
                    index++;
                }
            }
        }
  
      
        return answer;
    }
}
