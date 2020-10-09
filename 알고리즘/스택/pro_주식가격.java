 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-09
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/42584
  *
  */

class Solution {
    public int[] solution(int[] prices) {
       int[] answer = new int[prices.length];

        for (int i=0; i<prices.length-1; i++) {
            for (int j=i+1; j<prices.length; j++) {
                if (prices[i] > prices[j]) {
                    answer[i] = j-i;
                    break;
                }
                answer[i] = j-i;
            }
        }

        return answer;
    }
}