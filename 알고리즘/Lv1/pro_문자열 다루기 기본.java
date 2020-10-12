 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-12
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12918
  *
  */

class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        if (s.length() == 4 || s.length() == 6) {
            char[] ch = s.toCharArray();
            for (char c : ch) {
                if (c - '9' > 0) {
                    answer = false;
                    break;
                }
            }
        } else {
            answer = false;
        }
        return answer;
    }
}