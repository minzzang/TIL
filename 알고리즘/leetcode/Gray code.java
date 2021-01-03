 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2021-01-02
  * URL   : https://leetcode.com/problems/gray-code/
  *
  */

import java.util.ArrayList;
import java.util.List;

class Solution {
    static char[] visited;
    static List<Integer> list;
    
    public List<Integer> grayCode(int n) {
        list = new ArrayList<>();
        if (n == 0) {
            list.add(0);
        } else {
            visited = new char[n];
            dfs(0, n, 0);    
        }

        return list;
    }
    
    private static void dfs(int depth, int n, int reverse) {
        if (depth == n) {
            list.add(Integer.parseInt(new String(visited), 2));
            return;
        }

        visited[depth] = (char)(reverse + '0');
        dfs(depth + 1, n, 0);

        visited[depth] = (char)(1 - reverse + '0');
        dfs(depth + 1, n, 1);
    }
}