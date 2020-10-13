 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-13
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12982
  *
  */

import java.util.Arrays;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for (int i=0; i<d.length; i++) {
            if (budget < d[i]) break;
            answer++;
            budget -= d[i];
        }
        return answer;
    }
}