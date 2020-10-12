 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-12
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/42862
  *
  */

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        for (int i=0; i<lost.length; i++) {
            for (int j=0; j<reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = 0;
                    reserve[j] = 0;
                }
            }
        }

        for (int i=0; i<lost.length; i++) {
            if (lost[i] == 0) continue;
            for (int j=0; j<reserve.length; j++) {
                if (reserve[j] == 0) continue;

                if (Math.abs(lost[i] - reserve[j]) == 1) {
                    lost[i] = 0;
                    reserve[j] = 0;
                }
            }
        }

        int answer = 0;
        for (int i=0; i<lost.length; i++) {
            if (lost[i] > 0) answer++;
        }
        return n-answer;
    }
}