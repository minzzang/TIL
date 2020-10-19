 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-19
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/67257
  *
  */

import java.util.*;
class Solution {
    private static boolean[] visited = new boolean[3];
    private static char[] math = { '+', '-', '*'};
    private static List<Long> number = new ArrayList<>();
    private static List<Character> oper = new ArrayList<>();
    private static long sum;
    
    public static long solution(String expression) {
        String num = "";
        for (int i=0; i<expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch >= '0' && ch <= '9') {
                num += ch;
            } else {
                number.add(Long.parseLong(num));
                oper.add(ch);
                num = "";
            }
        }
        number.add(Long.parseLong(num));

        dfs(0, new char[3]);

        return sum;
    }

    private static void dfs(int count, char[] chars) {
        if (count == 3) {
            List<Long> copyNumber = new ArrayList<>(number);
            List<Character> copyOper = new ArrayList<>(oper);

            for (int i=0; i<chars.length; i++) {
                for (int j=0; j<copyOper.size(); j++) {
                    if (chars[i] == copyOper.get(j)) {
                        long calc = calc(copyNumber.remove(j), copyNumber.remove(j), chars[i]);
                        copyNumber.add(j, calc);
                        copyOper.remove(j);
                        j--;
                    }
                }
            }
            sum = Math.max(sum, Math.abs(copyNumber.get(0)));
            return;
        }

        for (int i=0; i<3; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            chars[count] = math[i];
            dfs(count + 1, chars);
            visited[i] = false;
        }
    }

    private static long calc(Long num1, Long num2, char ch) {
        long num = 0;
        if (ch == '+') {
            num = num1 + num2;
        } else if (ch == '-') {
            num = num1 - num2;
        } else {
            num = num1 * num2;
        }

        return num;
    }
}