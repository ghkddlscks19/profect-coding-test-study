class Solution {
    public String solution(int[] numbers, String hand) {
        // 147 왼손, 369 오른손, 가운데는 거리 계산해서 가까운거
        int left = 10; // *
        int right = 12; // #

        StringBuilder sb = new StringBuilder();
        for(int num : numbers) {
            if(num == 0) num = 11;
            if(num == 1 || num ==4 || num == 7) {
                sb.append("L");
                left = num;
            }
            else if(num == 3 || num == 6 || num == 9) {
                sb.append("R");
                right = num;
            }
            else {
                int leftNear = Math.abs(left - num) / 3 + Math.abs(left - num) % 3;
                int rightNear = Math.abs(right - num) / 3 + Math.abs(right - num) % 3;

                if(leftNear < rightNear) {
                    sb.append("L");
                    left = num;
                } else if(rightNear < leftNear) {
                    sb.append("R");
                    right = num;
                } else {
                    if(hand.equals("left")) {
                        sb.append("L");
                        left = num;
                    } else {
                        sb.append("R");
                        right = num;
                    }
                }
            }
        }

        return sb.toString();
    }
}
