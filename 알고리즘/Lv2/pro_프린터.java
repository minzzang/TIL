 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-14
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/42587
  *
  */

import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i=0; i<priorities.length; i++) {
            queue.offer(priorities[i]);
        }

        int answer = 0;
        while (!queue.isEmpty()) {
            int first = queue.peek();

            int index = 0;
            boolean isRemoved = false;
            for (int i : queue) {
                if (index++ == 0) continue;

                if (first < i) {
                    if (location == 0) {
                        location = queue.size() - 1;
                    } else {
                        location--;
                    }
                    queue.offer(queue.remove());
                    isRemoved = true;
                    break;
                }
            }

            if (!isRemoved) {
                answer++;
                queue.remove();
                if (location == 0) {
                    break;
                } else {
                    location--;
                }
            }
        }

        return answer;
    }
}