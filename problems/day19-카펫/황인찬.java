class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        
        // 정답은 sum의 약수인 값들 중에 나옴
        for(int i =3; i<=sum; i++) {
            if(sum % i == 0) {
                int width = sum / i;
                int height = i;
                
                // yellow는 (width - 2) * (height - 2)
                if((width - 2) * (height - 2) == yellow) {
                    return new int[]{width, height};
                }
            }
        }
        return new int[]{0, 0};
    }
}
