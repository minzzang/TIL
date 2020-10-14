 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-14
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/42586
  *
  */

import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
      List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<progresses.length; i++) {
            int day = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);

            if (!queue.isEmpty() && queue.peek() < day) {
                list.add(queue.size());
                queue.clear();
            }
            queue.offer(day);
        }
        list.add(queue.size());

        int[] answer = new int[list.size()];
        int index = 0;
        for (int i : list) {
            answer[index++] = i;
        }
        return answer;
    }
}