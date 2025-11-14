import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        // 1️⃣ 비용 기준 오름차순 정렬
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;  // 초기: 자기 자신이 부모
        
        int total = 0;
        int count = 0;
        
        // 2️⃣ 간선 순회
        for (int[] edge : costs) {
            int a = edge[0];
            int b = edge[1];
            int cost = edge[2];
            
            // 서로 연결되어 있지 않으면(싸이클X)
            if (find(parent, a) != find(parent, b)) {
                union(parent, a, b);
                total += cost;
                count++;
            }
            
            // 모든 섬이 연결되면 조기 종료
            if (count == n - 1) break;
        }
        
        return total;
    }
    
    // Find (경로 압축)
    private int find(int[] parent, int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent, parent[x]);
    }
    
    // Union
    private void union(int[] parent, int a, int b) {
        int pa = find(parent, a);
        int pb = find(parent, b);
        if (pa != pb) parent[pb] = pa;
    }
}
