class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int size = id_list.length;
        boolean[][] rp = new boolean[size][size];
        int[] repSum = new int[size];
        int[] mailSum = new int[size];
        
        for (String rep : report) {
            String[] repArr = rep.split(" ");
            int from = -1;
            int to = -1;
            for (int i = 0; i < size; i++) {
                if (id_list[i].equals(repArr[0]))
                    from = i;
                if (id_list[i].equals(repArr[1]))
                    to = i;
            }
            
            if (!rp[from][to]) {
                rp[from][to] = true;
                repSum[to]++;
            }
        }
        
        for (int i = 0; i < size; i++) {
            if (repSum[i] >= k) {
                for (int j = 0; j < size; j++) {
                    if (rp[j][i])
                        mailSum[j]++;
                }
            }
        }
        
        return mailSum;
    }
}
