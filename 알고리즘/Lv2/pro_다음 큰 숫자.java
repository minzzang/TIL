 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-17
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12911
  *
  */

class Solution {
    public int solution(int n) {
        int count = Integer.bitCount(n);
        for (int i=n+1; ; i++) {
            if (count == Integer.bitCount(i)) {
                return i;
            }
        }
    }
}