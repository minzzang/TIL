 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-12-16
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/64064
  *
  */

import java.util.*;

class Solution {
    public static Set<Integer> set = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        dfs(0, 0,user_id, banned_id);
        return set.size();
    }

    private static void dfs(int depth, int bit, String[] user_id, String[] banned_id) {
        if (depth == banned_id.length) {
            set.add(bit);
            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if (((bit >> i) & 1) == 1) continue;
            if (doesMatch(user_id[i], banned_id[depth])) {
                dfs(depth+1, bit | (1 << i), user_id, banned_id);
            }
        }

    }

    private static boolean doesMatch(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == '*' || s2.charAt(i) == '*') continue;
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }
    
}