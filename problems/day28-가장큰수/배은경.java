import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        int leng = numbers.length;
        Integer[] arr = new Integer[leng];
        int idx;

        for (int i = 0; i < leng; i++)
            arr[i] = numbers[i];

        Arrays.sort(arr, (a, b) -> {
            String s1 = a + "" + b;
            String s2 = b + "" + a;
            return s2.compareTo(s1);
        });

        StringBuilder sb = new StringBuilder();
        for (int num : arr)
            sb.append(num);
        
        answer = sb.toString();
        if (answer.replaceAll("0", "").equals(""))
            return "0";

        return answer;
    }
}
