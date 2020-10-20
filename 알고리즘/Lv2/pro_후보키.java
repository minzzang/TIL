 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-20
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/42890
  *
  */

import java.util.*;

class Solution {
    private static List<List<Integer>> candidate = new ArrayList<>();
    private static String[][] rel;
    
    public int solution(String[][] relation) {
         rel = relation;
        int n = rel[0].length;
        dfs(0, n, new ArrayList<Integer>());
        return candidate.size();
    }

    private static void dfs(int index, int n, List<Integer> combination) {
        if (index == n) {
            for (List hs : candidate) {
                if (combination.containsAll(hs)) {
                    return;
                }
            }

            List<String> check = new ArrayList<>();
            for (int i=0; i<rel.length; i++) {
                String tmp = "";
                for (int j=0; j<rel[0].length; j++) {
                    if (combination.contains(j)) {
                        tmp += rel[i][j] + ",";
                    }
                }
                if (check.contains(tmp)) {
                    return;
                }
                check.add(tmp);
            }
            candidate.add(combination);
            return;
        }

        List<Integer> copy1 = new ArrayList<>(combination);
        List<Integer> copy2 = new ArrayList<>(combination);

        dfs(index + 1, n, copy1);
        copy2.add(index);
        dfs(index + 1, n, copy2);
    }
}