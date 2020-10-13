 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-13
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12899
  *
  */

class Solution {
    public String solution(int n) {
      String answer = "";
        StringBuffer sb = new StringBuffer();

        while (n != 0) {
            int remainder = n % 3;
            n = n/3;

            if (remainder == 0) {
                sb.append(4);
                n--;
                continue;
            }
            sb.append(remainder);
        }
        return sb.reverse().toString();
    }
}