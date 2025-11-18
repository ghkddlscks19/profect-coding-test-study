class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int[] pos = new int[]{3, 0, 3, 2}; // 0 1 - left, 2 3 - right}
        int[][] nums = new int[4][3];
        
        for(int i = 0; i < numbers.length; i++) {
            int x = (numbers[i] - 1) / 3;
            int y = (numbers[i] - 1) % 3;
            if(numbers[i] == 0) {
                x = 3;
                y = 1;
            }
            
            int flag = 0;
            if(numbers[i] % 3 == 1)
                flag = 0;
            else if (numbers[i] % 3 == 0 && numbers[i] != 0)
                flag = 1;
            else {
                int dis1 = (pos[0] - x > 0) ? pos[0] - x + y - pos[1] : (x - pos[0]) + y - pos[1];
                int dis2 = (pos[2] - x > 0) ? pos[2] - x + pos[3] - y : (x - pos[2]) + pos[3] - y;
                if(dis1 == dis2)
                    if(hand.equals("right"))
                        flag = 1;
                    else
                        flag = 0;
                else if(dis1 > dis2)
                    flag = 1;
            }
            if(flag == 0) {
                pos[0] = x;
                pos[1] = y;
                sb.append("L");
            } else {
                pos[2] = x;
                pos[3] = y;
                sb.append("R");
            }
            //System.out.println(numbers[i] + " , " + sb.toString());
        }
        answer = sb.toString();
        return answer;
    }
}
