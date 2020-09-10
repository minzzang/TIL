 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-10
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/42840
  *
  */

import java.util.List;
import java.util.ArrayList;

class Solution {
    
    private static final int[] solve1 = {1,2,3,4,5};

    private static final int[] solve2 = {2,1,2,3,2,4,2,5};

    private static final int[] solve3 = {3,3,1,1,2,2,4,4,5,5};
    
    public int[] solution(int[] answers) {
        int[] answerCount = new int[3];
        List<Integer> list = new ArrayList<>();
        int max = 0;

        solve(answers, answerCount);

        for (int i : answerCount) {
            max = Math.max(max,i);
        }

        for (int i=0; i<answerCount.length; i++) {
            if (answerCount[i] == max) {
                list.add(i+1);
            }
        }

        int[] answer = new int[list.size()];

        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
    
    private static void solve(int[] answers, int[] answerCount) {

        for (int i=0; i<answers.length; i++) {

            if (answers[i] == solve1[i % 5]) {
                answerCount[0]++;
            }
            if (answers[i] == solve2[i % 8]) {
                answerCount[1]++;
            }
            if (answers[i] == solve3[i % 10]) {
                answerCount[2]++;
            }
        }
    }
}