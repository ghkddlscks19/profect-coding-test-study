class Solution {
    public String[] solution(String[] strings, int n) {
        int leng = strings.length;

        for (int i = 0; i < leng - 1; i++) {
            for (int j = 0; j < leng - 1 - i; j++) {
                String s1 = strings[j];
                String s2 = strings[j + 1];
                char c1 = s1.charAt(n);
                char c2 = s2.charAt(n);

                if (c1 > c2 || (c1 == c2 && s1.compareTo(s2) > 0)) {
                    strings[j] = s2;
                    strings[j + 1] = s1;
                }
            }
        }
      
        return strings;
    }
}
