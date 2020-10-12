 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-12
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12934
  *
  */

class Solution {
    public long solution(long n) {
        long answer = 0;
        double num = Math.sqrt(n);

        if (num - (int)num == 0) {
            answer = (long)Math.pow(num+1, 2);
        } else {
            answer = -1;
        }
        return answer;
    }
}