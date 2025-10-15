class Solution {
    static int[][] answer;
    static int idx = 0;
    public int[][] solution(int n) {
        answer = new int[(1<<n) - 1][2];
        hanoi(1, 2, 3, n);
        return answer;
    }
    
    static void hanoi(int from, int temp, int to, int n) {
        if(n == 1) {
            answer[idx++] = new int[]{from, to};
            return;
        }
        
        hanoi(from, to, temp, n-1); // from -> to -> temp에 맨 밑에거를 제외하고 전부 이동
        answer[idx++] = new int[]{from, to}; // 가장 큰 원판 이동
        hanoi(temp, from, to, n-1); // temp -> from -> to로 남은거 전부 이동
    }
}
