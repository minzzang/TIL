 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-13
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12954
  *
  */

class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        
        long num = x;
        for (int i=0; i<n; i++) {
            answer[i] = num * (i+1);
        }
        return answer;
    }
}