 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-13
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12943
  *
  */

class Solution {
    public int solution(int num) {
        int answer = 0;
   
        long n = num;
        for (int i=0; i<500; i++) {
            if (n == 1) return answer;
            
            if (n % 2 == 0) n /= 2;
            else n = n * 3 + 1;
            answer++;
        }

        return -1;
    }
}