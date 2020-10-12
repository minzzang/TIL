 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-12
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12928
  *
  */

class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i=1; i*i<=n; i++) {
            if (n % i == 0) {
                answer += i;
                if (i == n / i) continue;
                answer += n / i;
            }
        }
        return answer;
    }
}