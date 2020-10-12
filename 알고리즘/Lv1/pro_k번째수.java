 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-12
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/42748
  *
  */

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int answerIndex = 0;

        for (int[] i: commands) {
            int start = i[0], end = i[1], index = i[2];
            int[] newArray = new int[end - start + 1];

            int cnt = 0;
            for (int j=start-1; j<end; j++) {
                newArray[cnt++] = array[j];
            }
            Arrays.sort(newArray);
            answer[answerIndex++] = newArray[index-1];
        }
        return answer;
    }
}