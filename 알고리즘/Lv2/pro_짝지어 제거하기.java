 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-19
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12973
  *
  */

import java.util.*;
class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        char[] ch = s.toCharArray();
        
        for (char c : ch) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
      
        return stack.isEmpty() ? 1 : 0;

    }
}