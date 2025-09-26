class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        //행렬의 곱 -> (m×n)⋅(n×p)=(m×p) //arr1가로 * arr2세로 합
        for(int i = 0; i < arr1.length; i++)
            for(int j = 0; j < arr2[0].length; j++)
                answer[i][j] = calc(arr1, arr2, i, j);
        
        return answer;
    }
    
    int calc(int[][] arr1, int[][] arr2, int x, int y) {
        int sum = 0;
        for(int j = 0; j < arr1[0].length; j++)
            sum += arr1[x][j] * arr2[j][y];
        
        return sum;
    }
}
