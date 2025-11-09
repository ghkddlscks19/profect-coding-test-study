import java.util.*;

class Solution {
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

    public int solution(int[] arrows) {
        Set<String> visitedVertex = new HashSet<>();
        Set<String> visitedEdge = new HashSet<>();

        int x = 0, y = 0;
        visitedVertex.add(posKey(x, y));
        int rooms = 0;

        for (int dir : arrows) {
            // 중간 교차 감지를 위해 2번 이동
            for (int step = 0; step < 2; step++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                String edge1 = edgeKey(x, y, nx, ny);
                String edge2 = edgeKey(nx, ny, x, y);

                // 새 길을 통해 이미 방문한 점에 처음 도착하면 방 생성
                if (!visitedEdge.contains(edge1) && visitedVertex.contains(posKey(nx, ny))) {
                    rooms++;
                }

                visitedVertex.add(posKey(nx, ny));
                visitedEdge.add(edge1);
                visitedEdge.add(edge2);

                x = nx;
                y = ny;
            }
        }
        return rooms;
    }

    private String posKey(int x, int y) {
        return x + "," + y;
    }

    private String edgeKey(int x1, int y1, int x2, int y2) {
        return x1 + "," + y1 + "->" + x2 + "," + y2;
    }
}
