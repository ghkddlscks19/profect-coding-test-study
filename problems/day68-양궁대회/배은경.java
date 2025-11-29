import java.util.*;

class Solution {
    int[] inf;
    int[] ans = {-1};
    int max = 0;

    public int[] solution(int n, int[] info) {
        inf = info;
        int[] r = new int[11];
        dfs(0, n, r);

        return ans;
    }

    void dfs(int i, int rem, int[] r) {
        if (i == 11) {
            if (rem > 0) 
                r[10] += rem;

            int rr = 0, aa = 0;
            for (int k = 0; k < 11; k++) {
                if (r[k] == 0 && inf[k] == 0)
                    continue;
                if (r[k] > inf[k])
                    rr += (10 - k);
                else 
                    aa += (10 - k);
            }
            int diff = rr - aa;

            if (diff > 0) {
                if (diff > max) {
                    max = diff;
                    ans = r.clone();
                } else if (diff == max) {
                    boolean flag = false;
                    for (int k = 10; k >= 0; k--) {
                        if (r[k] != ans[k]) {
                            if (r[k] > ans[k])
                                flag = true;
                            break;
                        }
                    }
                    if(flag)
                        ans = r.clone();
                }
            }

            if (rem > 0) 
                r[10] -= rem;
            return;
        }

        int need = inf[i] + 1;
        if (rem >= need) {
            r[i] = need;
            dfs(i + 1, rem - need, r);
            r[i] = 0;
        }

        dfs(i + 1, rem, r);
    }
}
