 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-12
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12921
  *
  */

class Solution {
    public int solution(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;

        int count = 0;
        for (int i=2; i<=n; i++) {
            for (int j=2; j*j<=i; j++) {
                if (i % j == 0) {
                    count++;
                    break;
                }
            }
        }
        return n - count - 1;
    }
}