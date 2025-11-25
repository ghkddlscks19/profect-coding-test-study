import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        // 진출 시간 순 오름차순 정렬
        Arrays.sort(routes, (a, b) -> {
            if(a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        
        int camera = 1;
        int pos = routes[0][1];
        
        for(int i =1; i<routes.length; i++) {
            // 현재 차량의 위치와 진입 시점 카메라 위치 비교
            if(routes[i][0] > pos) {
                camera++;
                pos = routes[i][1];
            }
        }
        
        return camera;
    }
}
