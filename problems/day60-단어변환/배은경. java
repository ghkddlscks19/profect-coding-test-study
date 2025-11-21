class Solution {
    static int len;
    static int answer;
    static boolean[] vst;
    
    static void dfs(int cnt, String str, String target, String[] word) {
        if(str.equals(target) || cnt > len) {
            if(answer > cnt) 
                answer = cnt;
            return;
        }
        
        for(int i  = 0; i < word.length; i++) {
            if(vst[i] == false) {
                int c = 0;
                for(int j = 0; j < len; j++) 
                    if(str.charAt(j) != word[i].charAt(j))
                        c++;
                
                if(c == 1) {
                    vst[i] = true;
                    dfs(cnt + 1, word[i], target, word);
                    vst[i] = false;
                }
            }
            
        }        
    }
    public int solution(String begin, String target, String[] words) {
        answer = words.length;
        len = words[0].length();
        vst = new boolean[words.length];
        
        boolean flag = false;
        for(int i = 0; i < words.length; i++)
            if(words[i].equals(target)) {
                flag = true;
                break;
            }
        
        if(flag == false)
            return 0;
    
        dfs(0, begin, target, words);
        return answer;
    }
}
