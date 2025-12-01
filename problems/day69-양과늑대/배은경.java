import java.util.*;
class Solution {
    static int[] infos;
    static ArrayList<Integer>[] list;
    static int max = 0;
    static void dfs(int n, int lamb, int wolf, Set<Integer> vst, Set<Integer> able) {
        if(lamb <= wolf && n != 0) 
            return;
        if(infos[n] == 0) 
            lamb += 1;
        else 
            wolf += 1;
        
        if(lamb > max)
            max = lamb;
        Set<Integer> newVst = new HashSet<>(vst);
        newVst.add(n);
        
        for(int i = 0; i < list[n].size(); i++)
            if(!newVst.contains(list[n].get(i)))
                able.add(list[n].get(i));
        
        for(int s : able) {
            Set<Integer> newAble = new HashSet<>(able);
            newAble.remove(s);
            dfs(s, lamb, wolf, newVst, newAble);
        } 
        
        return;
    }
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        list = new ArrayList[info.length + 1];
        infos = info;
        
        for(int i = 0; i <= info.length; i++) 
            list[i] = new ArrayList<>();
        for(int i = 0; i < edges.length; i++)
            list[edges[i][0]].add(edges[i][1]);
        
        Set<Integer> visited = new HashSet<>();
        Set<Integer> able = new HashSet<>();
        dfs(0, 0, 0, visited, able);
        answer = max;
        return answer;
    }
}
