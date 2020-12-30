 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-12-30
  * URL   : https://leetcode.com/problems/generate-parentheses
  *
  */

import java.util.ArrayList;
import java.util.List;

class Main {

    static char[] ch;
    static int COUNT;
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        generateParenthesis(3);
    }

    public static List<String> generateParenthesis(int n) {
        ch = new char[n * 2 + 1];

        dfs(0, n * 2);
        
        return list;
    }

    private static void dfs(int depth, int n) {
        if (depth == n) {
            if (isValid(ch)) {

            }
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

            if (n < 0 || n > (ch.length - 1) / 2) return false;
        }
        return true;
    }

}