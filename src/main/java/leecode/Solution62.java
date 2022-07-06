package leecode;

import java.util.HashMap;
import java.util.Map;

public class Solution62 {
    private static Map<String, Integer> map = new HashMap();

    //C m n-1
    public int uniquePaths(int m, int n) {
        if (m == 1) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        String a = m + "," + n;
        String b = n + "," + m;
        if (map.get(a) != null) {
            return map.get(a);
        }
        if (map.get(b) != null) {
            return map.get(b);
        }
        int result = 0;
        result += uniquePaths(m - 1, n);
        result += uniquePaths(m, n - 1);
        map.put(m + "," + n, result);
        return result;
    }

    public static void main(String[] args) {
        Solution62 solution62 = new Solution62();
        System.out.println(solution62.uniquePaths(3, 7));
    }
}
