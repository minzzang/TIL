 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-12
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/68935
  *
  */

class Solution {
    public int solution(int n) {
        StringBuffer sb = new StringBuffer();

        while (n != 0) {
            sb.append(n % 3);
            n = n / 3;

        }
        sb.reverse();

        int answer = 0;
        for (int i=0; i<sb.length(); i++) {
            if (sb.charAt(i) == '0') continue;
            answer += (sb.charAt(i) - '0') * Math.pow(3, i);
        }
        return answer;
    }
}