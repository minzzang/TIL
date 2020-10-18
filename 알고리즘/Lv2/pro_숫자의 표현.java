 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-18
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12924
  *
  */

class Solution {
    public int solution(int n) {
        int answer = 1;
        for (int i=1; i<(n+1)/2; i++) {
            int sum = 0;
            for (int j=i; j<=(n+1)/2; j++) {
                sum += j;
                if (sum > n) break;
                if (sum == n) {

                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}