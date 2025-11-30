import java.util.*;
class Solution {
    List<List<Integer>> tree;
    int answer = 0;
    
    public int solution(int[] info, int[][] edges) {
        // 트리 형태로 만들기
        tree = new ArrayList<>();
        for(int i =0; i<info.length; i++) {
            tree.add(new ArrayList<>());
        }
        for(int[] edge: edges) {
            tree.get(edge[0]).add(edge[1]);
        }
        
        // 현재 갈 수 있는 곳 관리
        List<Integer> canVisit = new ArrayList<>();
        canVisit.add(0); 
        
        dfs(0, 0, canVisit, info);
        
        return answer;
    }
    
    void dfs(int sheep, int wolf, List<Integer> canVisit, int[] info) {
        answer = Math.max(sheep, answer);
        
        for(int node: canVisit) {
            // 노드 방문 후 양, 늑대 계산
            int newSheep = sheep;
            int newWolf = wolf;
            if(info[node] == 0) {
                newSheep++;
            } else {
                newWolf++;
            }
            
            // 늑대가 양보다 많으면 안됨
            if(newWolf >= newSheep) continue;
            
            // 현재 새롭게 방문할 수 있는 리스트 만들기
            List<Integer> newCanVisit = new ArrayList<>(canVisit);
            newCanVisit.remove(Integer.valueOf(node));
            newCanVisit.addAll(tree.get(node));
            
            // 다음 탐색
            dfs(newSheep, newWolf, newCanVisit, info);
        }
    }
}
