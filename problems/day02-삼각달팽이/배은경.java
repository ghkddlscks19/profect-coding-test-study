class Solution {
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        int a = -1;
        int b = 0;
        int num = 1;
        
        for(int i = 0; i < n; i++) {
            if(i % 3 == 0) {
                arr[++a][b] = num++;
                while(a + 1 < n && arr[a + 1][b] == 0) {
                    arr[++a][b] = num++;
                }
            }else if(i % 3 == 1) {
                arr[a][++b] = num++;
                while(b + 1 < n && arr[a][b + 1] == 0) {
                    arr[a][++b] = num++;
                }
            }else {
                arr[--a][--b] = num++;
                while(arr[a - 1][b - 1] == 0) {
                    arr[--a][--b] = num++;
                }
            }
        }
        
        int idx = 0;
        int[] answer = new int[--num];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == 0) break;
                answer[idx++] = arr[i][j];
            }
        }
        
        return answer;
    }
}
