class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int[] arr = new int[number.length()];
        int a = 0;
        for(char c : number.toCharArray()) {
            arr[a++] = c - '0';
        }
        
        int idx = 0;
        int cnt = k;
        StringBuilder sb = new StringBuilder();

        while (idx < arr.length && cnt > 0) {
            int end = Math.min(arr.length - 1, idx + cnt);
            int max = arr[idx];
            int mIdx = idx;

            for (int i = idx; i <= end; i++)
                if (arr[i] > max) {
                    max = arr[i];
                    mIdx = i;
                }

            sb.append(max);
            cnt -= (mIdx - idx);
            idx = mIdx + 1;
        }
        
        for (int i = idx; i < arr.length; i++)
            sb.append(arr[i]);
        if (cnt > 0)
            sb.setLength(sb.length() - cnt);
        
        answer = sb.toString();
        return answer;
    }
}
