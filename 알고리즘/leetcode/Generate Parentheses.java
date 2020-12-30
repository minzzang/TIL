 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-12-30
  * URL   : https://leetcode.com/problems/generate-parentheses
  *
  */

import java.util.*;

class Solution {
    static char[] ch;
    static List<String> list;
    
    public List<String> generateParenthesis(int n) {
        ch = new char[n * 2 + 1];
        list = new ArrayList<>();

        dfs(0, n * 2);
        
        return list;
    }
    
    private static void dfs(int depth, int n) {
        if (depth == n) {
            if (isValid(ch)) appendParenthesis(ch);
            return;
        }

        ch[depth] = '(';
        dfs(depth+1, n);

        ch[depth] = ')';
        dfs(depth+1, n);
    }

    private static boolean isValid(char[] ch) {
        int n = 0;
        for (int i = 0; i < ch.length-1; i++) {
            if (ch[i] == '(') n++;
            else n--;

            if (n < 0) return false;
        }
        return n == 0;
    }

    private static void appendParenthesis(char[] ch) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ch.length - 1; i++) {
            sb.append(ch[i]);
        }
        list.add(sb.toString());
    }
}