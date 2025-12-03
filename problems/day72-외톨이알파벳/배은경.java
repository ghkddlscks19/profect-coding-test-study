class Solution {
    public String solution(String input_string) {
        StringBuilder sb = new StringBuilder();
        char[] arr = input_string.toCharArray();
        int[] cnt = new int[26];
        
        for(int i = 0; i < arr.length; i++)
            cnt[arr[i] - 'a'] += 1;
        
        for(int i = 0; i < 26; i++) {
            if(cnt[i] == 0) continue;
            char c = (char)('a' + i);
            int idx1 = input_string.indexOf(c);
            int idx2 = input_string.lastIndexOf(c);
            if(idx2 - idx1 >= cnt[i])
                sb.append(c);
        }
        String answer = sb.toString().equals("") ? "N" : sb.toString();
        return answer;
    }
}
