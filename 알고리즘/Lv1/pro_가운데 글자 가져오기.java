 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-12
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12903
  *
  */

class Solution {
    public String solution(String s) {
        String answer = "";
        int length = s.length();

        if (length % 2 == 0) {
            answer += s.charAt(length / 2 - 1);
        }
        answer += s.charAt(length / 2);

        return answer;
    }
}