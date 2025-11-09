import java.util.*;

class Solution {
    // 8방향 이동 (시계방향: 위부터)
    // 0: 위, 1: 오른쪽위, 2: 오른쪽, 3: 오른쪽아래
    // 4: 아래, 5: 왼쪽아래, 6: 왼쪽, 7: 왼쪽위
    int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    
    public int solution(int[] arrows) {
        int answer = 0;
        
        Set<String> visitedNode = new HashSet<>();
        Set<String> visitedEdge = new HashSet<>();
        
        int x = 0, y = 0;
        visitedNode.add(x + "," + y);
        
        for (int arrow : arrows) {
            // 대각선 교차점 처리를 위해 2번 이동
            for (int i = 0; i < 2; i++) {
                int nx = x + dx[arrow];
                int ny = y + dy[arrow];
                
                String node = nx + "," + ny;
                String edge1 = x + "," + y + "-" + nx + "," + ny;
                String edge2 = nx + "," + ny + "-" + x + "," + y;
                
                // 이미 방문한 노드에 새로운 간선으로 도착 = 방 생성
                if (visitedNode.contains(node) && 
                    !visitedEdge.contains(edge1)) {
                    answer++;
                }
                
                visitedNode.add(node);
                visitedEdge.add(edge1);
                visitedEdge.add(edge2);
                
                x = nx;
                y = ny;
            }
        }
        
        return answer;
    }
}
