class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        int l = 10;
        int r = 12;
        for (int num : numbers) {
            if (num == 1 || num == 4 || num == 7) {
                sb.append('L');
                l = num;
            }
            else if (num == 3 || num == 6 || num == 9) {
                sb.append('R');
                r = num;
            }
            else {
                if (num == 0) {
                    num = 11;
                }
                int x = (num - 1) % 3;
                int y = (num - 1) / 3;
                int lx = (l - 1) % 3;
                int ly = (l - 1) / 3;
                int rx = (r - 1) % 3;
                int ry = (r - 1) / 3;
                
                if ((Math.abs(x - lx) + Math.abs(y - ly)) == (Math.abs(x - rx) + Math.abs(y - ry))) {
                    if (hand.equals("right")) {
                        sb.append('R');
                        r = num;
                    }
                    else {
                        sb.append('L');
                        l = num;
                    }
                }
                else if ((Math.abs(x - lx) + Math.abs(y - ly)) < (Math.abs(x - rx) + Math.abs(y - ry))) {
                    sb.append('L');
                    l = num;
                }
                else {
                    sb.append('R');
                    r = num;
                }
            }
        }
        return sb.toString();
    }
}
