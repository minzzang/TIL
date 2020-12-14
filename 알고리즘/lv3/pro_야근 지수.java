 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-12-14
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12927
  *
  */

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i : works) {
            queue.offer(i);
        }

        while (n-- > 0) {
            int maxWorkTime = queue.poll();
            if (maxWorkTime <= 0) return 0;

            queue.offer(maxWorkTime-1);
        }

        for (int i : queue) {
            answer += Math.pow(i, 2);
        }

        return answer;
    }
}