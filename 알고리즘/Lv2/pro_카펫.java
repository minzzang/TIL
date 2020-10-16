 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-16
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/42842
  *
  */

class Solution {
    public int[] solution(int brown, int yellow) {
      int[] answer = {};

        int width = 0;
        int height = 0;

        for (int i=yellow; i>=Math.sqrt(yellow); i--) {
            width = i;
            height = yellow / i;

            if (yellow % i == 0) {
                int brownArea = (width+2) * (height+2);
                int yellowArea = width * height;

                if (brownArea - yellowArea == brown) break;
            }
        }
        answer = new int[2];
        answer[0] = width + 2;
        answer[1] = height + 2;
        return answer;
    }
}