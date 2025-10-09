class Solution {
    static int[] answer = new int[2]; // 0의 개수, 1의 개수

    public int[] solution(int[][] arr) {
        compress(arr, 0, 0, arr.length);
        return answer;
    }
    
    static void compress(int[][] arr, int x, int y, int size) {
        // 현재 영역이 같은 숫자인지 확인
        if(isSame(arr, x, y, size)) {
            answer[arr[x][y]]++; // 0 이나 1 카운트 증가
            return;
        }
        
        int half = size / 2;
        compress(arr, x, y, half); // 왼쪽 위
        compress(arr, x, y + half, half); // 오른쪽 위
        compress(arr, x + half, y, half); // 왼쪽 아래
        compress(arr, x + half, y + half, half); // 오른쪽 아래

    }
    
    static boolean isSame(int[][] arr, int x, int y, int size) {
        int value = arr[x][y];
        
        for(int i =x; i<x+size; i++) {
            for(int j =y; j<y+size; j++) {
                if(arr[i][j] != value) return false;
            }
        }
        
        return true;
    }
}
