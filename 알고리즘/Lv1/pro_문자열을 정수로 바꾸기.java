 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-12
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12925
  *
  */

class Solution {
    public int solution(String s) {
        boolean isPlus = true;
        char[] ch = s.toCharArray();

        if (ch[0] == '-') isPlus = false;

        int answer = 0;
        int index = ch.length - 1;
        for (char c : ch) {
            if (c == '-' || c == '+') {
                index--;
                continue;
            }
            answer += (c - '0') * Math.pow(10, index--);
        }
        return isPlus ? answer : -answer;
    }
}