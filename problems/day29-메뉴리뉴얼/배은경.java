import java.util.*;

class Solution {
    static Map<String, Integer> map;
    static int max;

    public String[] solution(String[] orders, int[] course) {
        List<String> list = new ArrayList<>();

        for (int c : course) {
            map = new HashMap<>();
            max = 0;

            for (String order : orders) {
                char[] menus = order.toCharArray();
                Arrays.sort(menus);
                dfs(menus, "", 0, c);
            }

            for (String key : map.keySet())
                if (map.get(key) == max && max >= 2)
                    list.add(key);
        }

        Collections.sort(list);
        return list.toArray(new String[0]);
    }

    private void dfs(char[] menus, String cur, int idx, int len) {
        if (cur.length() == len) {
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            max = Math.max(max, map.get(cur));
            return;
        }

        for (int i = idx; i < menus.length; i++)
            dfs(menus, cur + menus[i], i + 1, len);
    }
}
