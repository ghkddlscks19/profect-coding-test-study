import java.util.*;
class Solution {
    static int parent[];
    //정점들과 비용 정보를 담은 클래스
    static class Node{
        int v1;
        int v2;
        int cost;
        public Node(int v1, int v2, int cost){
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
    }
    
    //파인드 메소드
    public int find(int v){
        if(parent[v] == v) return parent[v];
        return parent[v] = find(parent[v]);
    }
    
    //유니온 메소드
    public void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        parent[fb] = fa;
    }
    public int solution(int n, int[][] costs) {
        int answer = 0;
        ArrayList<Node> graph = new ArrayList<>();
        
        //처음은 모두 부모로 초기화
        parent = new int[n];
        for(int i =0; i<n; i++){
            parent[i] = i;
        }
        
        //ArrayList를 통해 그래프 생성
        for(int[] cost : costs){
            graph.add(new Node(cost[0], cost[1], cost[2]));
        }
        
        //비용이 낮은 순으로 정렬
        Collections.sort(graph, (n1, n2) -> {
            return n1.cost - n2.cost;
        });
        
        for(Node node : graph){
            int fa = find(node.v1);
            int fb = find(node.v2);
            if(fa != fb){
                union(fa, fb);
                answer += node.cost;
            } 
                        
        }
        
        return answer;
    }
}
