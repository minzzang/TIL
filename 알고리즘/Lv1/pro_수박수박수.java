 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-12
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12922
  *
  */

class Solution {
    public String solution(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i=1; i<=n; i++) {
            if (i % 2 == 1) {
                sb.append("수");
            } else {
                sb.append("박");
            }
        }
        return sb.toString();
    }
}