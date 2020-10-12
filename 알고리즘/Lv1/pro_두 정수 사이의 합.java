 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-12
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12912
  *
  */

class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        for (int i=Math.min(a,b); i<=Math.max(a,b); i++) {
            answer += i;
        }
        return answer;
    }
}