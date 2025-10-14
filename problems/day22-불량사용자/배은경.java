import java.util.*;

class Solution {
    static Set<List<Integer>> banUser = new HashSet<>();
    static boolean vst[];
    static String[] user;
    static String[] banned;
  
    public int solution(String[] user_id, String[] banned_id) {
        user = user_id;
        banned = banned_id;
        
        vst = new boolean[user_id.length];
        dfs(0);
        return banUser.size();
    }
    
    public void dfs(int dep) {
        if(dep == banned.length) {
            List<Integer> list = new ArrayList<>(); 
            for(int i = 0; i < vst.length; i++)
                if(vst[i]) 
                    list.add(i);
            
            Collections.sort(list);
            banUser.add(list);
            return;
        }
        
        for(int i = 0; i < user.length; i++) {
            if(vst[i] == false) {
                if (user[i].length() != banned[dep].length())
                    continue;

                int flag = 1;
                for (int k = 0; k < user[i].length(); k++) {
                    char ban = banned[dep].charAt(k);
                    char userId = user[i].charAt(k);
                    
                    if (ban != '*' && ban != userId) {
                        flag = 0;
                        break;
                    }
                }

                if(flag == 1) {
                    vst[i] = true;
                    dfs(dep + 1);
                    vst[i] = false;
                }
            }
        }
    }
    
}
