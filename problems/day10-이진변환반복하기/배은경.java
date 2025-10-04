class Solution {
    public int[] solution(String s) {
        int[] rslt = new int[2];
        int bf, len;
        
        while(!s.equals("1")) {
            rslt[0]++;
            bf = s.length();
            s = s.replace("0", "");
            len = s.length();
            s = Integer.toBinaryString(len);
            rslt[1] += bf - len;
        }
        
        return rslt;
    }
}
