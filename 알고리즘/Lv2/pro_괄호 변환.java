 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-15
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/60058
  *
  */

import java.util.*;
class Solution {
    public String solution(String p) {
       return convert(p);
    }

    private static String convert(String p) {
        if (p.equals("")) return "";

        int divideIndex = getDivideIndex(p);
        String u = p.substring(0, divideIndex);
        String v = p.substring(divideIndex);

        if (checkCorrectString(u)) {
            return u += convert(v);
        } else {
            String str = "(" + convert(v) + ")";
            u = u.substring(1, u.length()-1);
            return str + reverse(u);
        }
    }

    private static String reverse(String u) {
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<u.length(); i++) {
            if (u.charAt(i) == ')') {
                sb.append('(');
            } else {
                sb.append(')');
            }
        }
        return sb.toString();
    }

    private static int getDivideIndex(String p) {
        int left = 0;
        int right = 0;
        for (int i=0; i<p.length(); i++) {
            if (p.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) return i+1;
        }
        return p.length();
    }

    private static boolean checkCorrectString(String p) {
        Stack<Character> stack = new Stack<>();
        char[] ch = p.toCharArray();

        boolean isCorrectStr = true;
        for (char c : ch) {
            if (c == '(') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) {
                isCorrectStr = false;
                break;
            }
            stack.pop();
        }
        return isCorrectStr;
    }
}